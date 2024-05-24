(ns happygapi.webfonts.webfonts
  "Web Fonts Developer API: webfonts.
  The Google Web Fonts Developer API lets you retrieve information about web fonts served by Google.
  See: https://developers.google.com/fonts/docs/developer_apidocs/reference/rest/v1/webfonts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/fonts/docs/developer_apiapi/reference/rest/v1/webfonts/list
  
  Required parameters: none
  
  Optional parameters: sort, capability, family, subset
  
  Retrieves the list of fonts currently served by the Google Fonts Developer API."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://webfonts.googleapis.com/"
     "v1/webfonts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
