(ns happygapi.mirror.settings
  "Google Mirror API: settings.
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glassapi/reference/rest/v1/settings"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/glassapi/reference/rest/v1/settings/get
  
  Required parameters: id
  
  Optional parameters: none
  
  Gets a single setting by ID."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "settings/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
