(ns happygapi.searchconsole.urlTestingTools
  "Google Search Console URL Testing Tools API: urlTestingTools.
  Provides tools for running validation tests against single URLs
  See: https://developers.google.com/webmaster-tools/search-console-api/api/reference/rest/v1/urlTestingTools"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn mobileFriendlyTest-run$
  "https://developers.google.com/webmaster-tools/search-console-api/api/reference/rest/v1/urlTestingTools/mobileFriendlyTest/run
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:url string, :requestScreenshot boolean}
  
  Runs Mobile-Friendly Test for a given URL."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "v1/urlTestingTools/mobileFriendlyTest:run"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
