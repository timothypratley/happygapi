(ns happy.oauth2-credentials
  "Reference for how to manage credentials.
  For a web app, you should implement something like this but use your database for credential storage.
  secret, scopes, fetch, save have default implementations that you can replace with init!"
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [happy.oauth2 :as oauth2]
            [happy.oauth2-capture-redirect :as ocr]
            [clojure.edn :as edn]
            [cheshire.core :as json]))

(def *secret
  (atom {}))

(def *scopes
  (atom []))

(def *credentials-cache
  (atom nil))

(defn fetch-credentials [user]
  (or (get @*credentials-cache user)
      (let [credentials-file (io/file "tokens" (str user ".edn"))]
        (when (.exists credentials-file)
          (edn/read-string (slurp credentials-file))))))

(defn save-credentials [user new-credentials]
  (when (not= @*credentials-cache new-credentials)
    (swap! *credentials-cache assoc user new-credentials)
    (spit (io/file (doto (io/file "tokens") (.mkdirs))
                   (str user ".edn"))
          new-credentials)))

(def *fetch (atom fetch-credentials))
(def *save (atom save-credentials))

(defn auth!
  ([] (auth! "user"))
  ([user]
   (let [credentials (@*fetch user)
         new-credentials (ocr/update-credentials @*secret credentials @*scopes nil)]
     (@*save user new-credentials)
     (oauth2/auth-header new-credentials))))

(defn init!
  ([]
   ;; TODO: shouldn't have these defaults
   (init! ["https://www.googleapis.com/auth/spreadsheets"
           "https://www.googleapis.com/auth/drive"
           "https://www.googleapis.com/auth/youtube"
           "https://www.googleapis.com/auth/cloud-vision"]))
  ([scopes]
   (init! (merge
            ;; If you download secret.json or service.json from your Google Console,
            ;; do not add them to source control.
            (let [secret-file (io/file "secret.json")]
              (when (.exists secret-file)
                (first (vals (json/parse-string (slurp secret-file) true)))))
            (let [service-file (io/file "service.json")]
              (when (.exists service-file)
                (json/parse-string (slurp service-file) true))))
          scopes))
  ([config scopes]
   (init! config scopes fetch-credentials save-credentials))
  ([config scopes fetch-credentials save-credentials]
   (reset! *secret config)
   (reset! *scopes scopes)
   (reset! *fetch fetch-credentials)
   (reset! *save save-credentials)))
