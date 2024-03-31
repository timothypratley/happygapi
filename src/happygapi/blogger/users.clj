(ns happygapi.blogger.users
  "Blogger API: users.
  The Blogger API provides access to posts, comments and pages of a Blogger blog.
  See: https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/users/get
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets one user by user_id."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/users/{userId}"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
