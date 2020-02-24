(ns happy.oauth2
  "Supports testing the generated api"
  (:require [clojure.java.io :as io])
  (:import (com.google.api.client.googleapis.auth.oauth2 GoogleClientSecrets GoogleAuthorizationCodeFlow$Builder)
           (com.google.api.client.json.jackson2 JacksonFactory)
           (com.google.api.client.googleapis.javanet GoogleNetHttpTransport)
           (com.google.api.client.extensions.jetty.auth.oauth2 LocalServerReceiver$Builder)
           (com.google.api.client.util.store FileDataStoreFactory)
           (com.google.api.client.extensions.java6.auth.oauth2 AuthorizationCodeInstalledApp)))

(def secrets-file (io/file "secret.json"))
(assert secrets-file "must provide secrets")
(def tokens-directory (doto (io/file "tokens") (.mkdir)))
(def scopes ["https://www.googleapis.com/auth/spreadsheets"])
(defonce json-factory (JacksonFactory/getDefaultInstance))
(defonce transport (GoogleNetHttpTransport/newTrustedTransport))
(defonce app
  (let [secrets (GoogleClientSecrets/load json-factory (io/reader secrets-file))
        flow (-> (GoogleAuthorizationCodeFlow$Builder. transport json-factory secrets scopes)
                 (.setDataStoreFactory (FileDataStoreFactory. tokens-directory))
                 (.setAccessType "offline")
                 (.build))
        receiver (-> (LocalServerReceiver$Builder.)
                     (.setPort 8888)
                     (.build))]
    (AuthorizationCodeInstalledApp. flow receiver)))

(defn auth []
  {:headers {"Authorization" (str "Bearer " (.getAccessToken (.authorize app "user")))}})
