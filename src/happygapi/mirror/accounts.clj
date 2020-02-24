(ns happygapi.mirror.accounts
  "Google Mirror API
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glass"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn insert$
  "Required parameters: accountName,accountType,userToken
  
  Inserts a new account for a user"
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"accountName" "userToken" "accountType"})]}
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
