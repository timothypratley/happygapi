(ns happygapi.mirror.accounts
  "Google Mirror API
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glass"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "mirror_schema.edn"))))

(defn insert$
  "Required parameters: accountName, accountType, userToken
  
  Optional parameters: none
  
  Inserts a new account for a user"
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"accountName" "userToken" "accountType"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "accounts/{userToken}/{accountType}/{accountName}"
     #{"accountName" "userToken" "accountType"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
