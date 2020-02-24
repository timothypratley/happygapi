(ns happygapi.mirror.settings
  "Google Mirror API
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glass"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: id
  
  Gets a single setting by ID."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "settings/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
