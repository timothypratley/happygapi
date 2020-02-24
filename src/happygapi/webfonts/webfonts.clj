(ns happygapi.webfonts.webfonts
  "Google Fonts Developer API
  Accesses the metadata for all families served by Google Fonts, providing a list of families currently available (including available styles and a list of supported script subsets).
  See: https://developers.google.com/fonts/docs/developer_api"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn list$
  "Required parameters: none
  
  Retrieves the list of fonts currently served by the Google Fonts Developer API"
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webfonts/v1/"
     "webfonts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
