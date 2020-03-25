(ns happygapi.poly.users
  "Poly API: users.
  The Poly API provides read access to assets hosted on <a href=\"https://poly.google.com\">poly.google.com</a> to all, and upload access to <a href=\"https://poly.google.com\">poly.google.com</a> for whitelisted accounts.
  
  See: https://developers.google.com/poly/api/reference/rest/v1/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn likedassets-list$
  "https://developers.google.com/poly/api/reference/rest/v1/users/likedassets/list
  
  Required parameters: name
  
  Optional parameters: orderBy, pageToken, pageSize, format
  
  Lists assets that the user has liked. Only the value 'me', representing
  the currently-authenticated user, is supported. May include assets with an
  access level of UNLISTED."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://poly.googleapis.com/"
     "v1/{+name}/likedassets"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn assets-list$
  "https://developers.google.com/poly/api/reference/rest/v1/users/assets/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, visibility, orderBy, format
  
  Lists assets authored by the given user. Only the value 'me', representing
  the currently-authenticated user, is supported. May include assets with an
  access level of PRIVATE or
  UNLISTED and assets which are
  All Rights Reserved for the
  currently-authenticated user."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://poly.googleapis.com/"
     "v1/{+name}/assets"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
