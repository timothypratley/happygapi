(ns happygapi.mirror.locations
  "Google Mirror API: locations.
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glassapi/reference/rest/v1/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/glassapi/reference/rest/v1/locations/get
  
  Required parameters: id
  
  Optional parameters: none
  
  Gets a single location by ID."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "locations/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/glassapi/reference/rest/v1/locations/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Retrieves a list of locations for the user."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "locations"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
