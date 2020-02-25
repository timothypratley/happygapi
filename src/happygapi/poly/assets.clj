(ns happygapi.poly.assets
  "Poly API
  The Poly API provides read access to assets hosted on <a href=\"https://poly.google.com\">poly.google.com</a> to all, and upload access to <a href=\"https://poly.google.com\">poly.google.com</a> for whitelisted accounts.
  
  See: https://developers.google.com/poly/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "poly_schema.edn"))))

(defn get$
  "Required parameters: name
  
  Optional parameters: none
  
  Returns detailed information about an asset given its name.
  PRIVATE assets are returned only if
   the currently authenticated user (via OAuth token) is the author of the
   asset."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: maxComplexity, pageToken, pageSize, keywords, orderBy, format, curated, category
  
  Lists all public, remixable assets. These are assets with an access level
  of PUBLIC and published under the
  CC-By license."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
