(ns happygapi.blogger.users
  "Blogger API: users.
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/users/get
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets one user by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "users/{userId}"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
