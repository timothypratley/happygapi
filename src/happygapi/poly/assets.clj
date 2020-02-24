(ns happygapi.poly.assets
  "Poly API
  The Poly API provides read access to assets hosted on <a href=\"https://poly.google.com\">poly.google.com</a> to all, and upload access to <a href=\"https://poly.google.com\">poly.google.com</a> for whitelisted accounts.
  
  See: https://developers.google.com/poly/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: name
  
  Returns detailed information about an asset given its name.
  PRIVATE assets are returned only if
   the currently authenticated user (via OAuth token) is the author of the
   asset."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://poly.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Lists all public, remixable assets. These are assets with an access level
  of PUBLIC and published under the
  CC-By license."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url "https://poly.googleapis.com/" "v1/assets" #{} args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
