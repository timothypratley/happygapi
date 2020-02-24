(ns happygapi.searchconsole.urlTestingTools
  "Google Search Console URL Testing Tools API
  Provides tools for running validation tests against single URLs
  See: https://developers.google.com/webmaster-tools/search-console-api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn mobileFriendlyTest-run$
  "Required parameters: none
  
  Runs Mobile-Friendly Test for a given URL."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "v1/urlTestingTools/mobileFriendlyTest:run"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
