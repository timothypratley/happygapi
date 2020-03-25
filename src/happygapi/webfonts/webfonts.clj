(ns happygapi.webfonts.webfonts
  "Google Fonts Developer API: webfonts.
  Accesses the metadata for all families served by Google Fonts, providing a list of families currently available (including available styles and a list of supported script subsets).
  See: https://developers.google.com/fonts/docs/developer_apiapi/reference/rest/v1/webfonts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/fonts/docs/developer_apiapi/reference/rest/v1/webfonts/list
  
  Required parameters: none
  
  Optional parameters: sort
  
  Retrieves the list of fonts currently served by the Google Fonts Developer API"
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webfonts/v1/"
     "webfonts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
