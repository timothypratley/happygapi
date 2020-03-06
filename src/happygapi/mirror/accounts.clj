(ns happygapi.mirror.accounts
  "Google Mirror API: accounts.
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glassapi/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/glassapi/reference/rest/v1/accounts/insert
  
  Required parameters: accountName, accountType, userToken
  
  Optional parameters: none
  
  Body: 
  
  {:authTokens [{:authToken string, :type string}],
   :features [string],
   :password string,
   :userData [{:key string, :value string}]}
  
  Inserts a new account for a user"
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{:userToken :accountName :accountType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "accounts/{userToken}/{accountType}/{accountName}"
     #{:userToken :accountName :accountType}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
