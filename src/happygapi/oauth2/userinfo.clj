(ns happygapi.oauth2.userinfo
  "Google OAuth2 API: userinfo.
  Obtains end-user authorization grants for use with other Google APIs.
  See: https://developers.google.com/accounts/docs/OAuth2api/reference/rest/v2/userinfo"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/accounts/docs/OAuth2api/reference/rest/v2/userinfo/get
  
  Required parameters: none
  
  Optional parameters: none
  
  "
  {:scopes ["openid"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "oauth2/v2/userinfo"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn v2-me-get$
  "https://developers.google.com/accounts/docs/OAuth2api/reference/rest/v2/userinfo/v2/me/get
  
  Required parameters: none
  
  Optional parameters: none
  
  "
  {:scopes ["openid"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "userinfo/v2/me"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
