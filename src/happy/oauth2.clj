(ns happy.oauth2
  "An example way to authorize for testing the generated api"
  (:require [clojure.java.io :as io])
  (:import (com.google.api.client.googleapis.auth.oauth2 GoogleClientSecrets GoogleAuthorizationCodeFlow$Builder)
           (com.google.api.client.json.jackson2 JacksonFactory)
           (com.google.api.client.googleapis.javanet GoogleNetHttpTransport)
           (com.google.api.client.extensions.jetty.auth.oauth2 LocalServerReceiver$Builder)
           (com.google.api.client.util.store FileDataStoreFactory)
           (com.google.api.client.extensions.java6.auth.oauth2 AuthorizationCodeInstalledApp)))

(def default-config
  {:tokens-directory "tokens"
   :secret-file      (io/file "secret.json")
   :scopes           ["https://www.googleapis.com/auth/spreadsheets"
                      "https://www.googleapis.com/auth/drive"]
   :port             8888})

(defonce ^{:doc "Optional singleton system"} singleton-app nil)

(defn start*
  "Creates a new, running authorization system.
  Use this to compose with system management."
  [{:keys [scopes secret-file tokens-directory port]}]
  {:pre [(.exists (io/file secret-file))]}
  (doto (io/file tokens-directory) (.mkdirs))
  (let [json-factory (JacksonFactory/getDefaultInstance)
        transport (GoogleNetHttpTransport/newTrustedTransport)
        secrets (with-open [r (io/reader (io/file secret-file))]
                  (GoogleClientSecrets/load json-factory r))
        flow (-> (GoogleAuthorizationCodeFlow$Builder. transport json-factory secrets scopes)
                 (.setDataStoreFactory (FileDataStoreFactory. (io/file tokens-directory)))
                 (.setAccessType "offline")
                 (.build))
        receiver (-> (LocalServerReceiver$Builder.)
                     (.setPort port)
                     (.build))]
    (AuthorizationCodeInstalledApp. flow receiver)))

(defn stop*
  "Stops an authorization system."
  [app]
  (.stop (.getReceiver app)))

(defn auth*
  "Returns request header suitable for merging into a request.
  May refresh a token."
  [app user]
  (let [cred (.authorize app user)]
    (or (pos? (.getExpiresInSeconds cred))
        (.refreshToken cred))
    {:headers {"Authorization" (str "Bearer " (.getAccessToken cred))}}))

(defn start!
  "Starts the (optional) singleton system.
  Use this if you don't have some other system management in place."
  ([] (start! nil))
  ([config]
   {:pre [(nil? singleton-app)]}
   (alter-var-root #'singleton-app (constantly (start* (merge default-config config))))))

(defn stop!
  "Stops the (optional) singleton system.
  Use this if you don't have some other system management in place."
  []
  {:pre [singleton-app]}
  (stop* singleton-app)
  (alter-var-root #'singleton-app (constantly nil)))

(defn auth!
  "Returns request header suitable for merging into a request,
  based on the (optional) singleton system.
  Will start an oauth2 listener if not already running.
  Will refresh tokens."
  ([] (auth! "user"))
  ([user]
   (or singleton-app (start!))
   (auth* singleton-app user)))
