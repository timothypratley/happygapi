(ns happygapi.mirror.locations
  "Google Mirror API
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "mirror_schema.edn"))))

(defn get$
  "Required parameters: id
  
  Optional parameters: none
  
  Gets a single location by ID."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "locations/{id}"
     #{"id"}
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
  
  Optional parameters: none
  
  Retrieves a list of locations for the user."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "locations"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
