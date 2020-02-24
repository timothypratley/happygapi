(ns happygapi.oauth2.userinfo
  "Google OAuth2 API
  Obtains end-user authorization grants for use with other Google APIs.
  See: https://developers.google.com/accounts/docs/OAuth2"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: none
  
  "
  {:scopes ["https://www.googleapis.com/auth/plus.me"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "oauth2/v2/userinfo"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn v2-me-get$
  "Required parameters: none
  
  "
  {:scopes ["https://www.googleapis.com/auth/plus.me"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "userinfo/v2/me"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
