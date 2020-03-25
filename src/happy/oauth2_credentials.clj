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

(def secret
  "If you download secret.json from your Google Console, do not add it to source control."
  (atom (let [secret-file (io/file "secret.json")]
          (when (.exists secret-file)
            (:installed (json/parse-string (slurp secret-file) true))))))
(def scopes
  (atom ["https://www.googleapis.com/auth/spreadsheets"
         "https://www.googleapis.com/auth/drive"]))

(def credentials-cache (atom nil))

(defn fetch-credentials [user]
  (or (get @credentials-cache user)
      (let [credentials-file (io/file "tokens" (str user ".edn"))]
        (when (.exists credentials-file)
          (edn/read-string (slurp credentials-file))))))

(defn save-credentials [user new-credentials]
  (when (not= @credentials-cache new-credentials)
    (swap! credentials-cache assoc user new-credentials)
    (spit (io/file (doto (io/file "tokens") (.mkdirs))
                   (str user ".edn"))
          new-credentials)))

(def fetch (atom fetch-credentials))
(def save (atom save-credentials))

(defn auth!
  ([] (auth! "user"))
  ([user]
   (let [credentials (@fetch user)
         new-credentials (ocr/update-credentials @secret credentials @scopes nil)]
     (@save user new-credentials)
     (oauth2/auth-header new-credentials))))

(defn init!
  ([]
   (init! secret scopes))
  ([config new-scopes]
   (init! config new-scopes fetch-credentials save-credentials))
  ([config new-scopes fetch-credentials save-credentials]
   (reset! secret config)
   (reset! scopes new-scopes)
   (reset! fetch fetch-credentials)
   (reset! save save-credentials)))
