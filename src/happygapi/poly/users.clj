(ns happygapi.poly.users
  "Poly API
  The Poly API provides read access to assets hosted on <a href=\"https://poly.google.com\">poly.google.com</a> to all, and upload access to <a href=\"https://poly.google.com\">poly.google.com</a> for whitelisted accounts.
  
  See: https://developers.google.com/poly/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn assets-list$
  "Required parameters: name
  
  Lists assets authored by the given user. Only the value 'me', representing
  the currently-authenticated user, is supported. May include assets with an
  access level of PRIVATE or
  UNLISTED and assets which are
  All Rights Reserved for the
  currently-authenticated user."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://poly.googleapis.com/"
     "v1/{+name}/assets"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn likedassets-list$
  "Required parameters: name
  
  Lists assets that the user has liked. Only the value 'me', representing
  the currently-authenticated user, is supported. May include assets with an
  access level of UNLISTED."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://poly.googleapis.com/"
     "v1/{+name}/likedassets"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
