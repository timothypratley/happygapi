(ns happygapi.poly.users
  "Poly API
  The Poly API provides read access to assets hosted on <a href=\"https://poly.google.com\">poly.google.com</a> to all, and upload access to <a href=\"https://poly.google.com\">poly.google.com</a> for whitelisted accounts.
  
  See: https://developers.google.com/poly/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "poly_schema.edn"))))

(defn assets-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize, visibility, orderBy, format
  
  Lists assets authored by the given user. Only the value 'me', representing
  the currently-authenticated user, is supported. May include assets with an
  access level of PRIVATE or
  UNLISTED and assets which are
  All Rights Reserved for the
  currently-authenticated user."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: orderBy, pageToken, pageSize, format
  
  Lists assets that the user has liked. Only the value 'me', representing
  the currently-authenticated user, is supported. May include assets with an
  access level of UNLISTED."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
