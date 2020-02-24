(ns happygapi.pagespeedonline.pagespeedapi
  "PageSpeed Insights API
  The PageSpeed Insights API lets you analyze the performance of your website with a simple API.  It offers tailored suggestions for how you can optimize your site, and lets you easily integrate PageSpeed Insights analysis into your development tools and workflow.
  
  See: https://developers.google.com/speed/docs/insights/v5/about"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn runpagespeed$
  "Required parameters: none
  
  Runs PageSpeed analysis on the page at the specified URL, and returns
  PageSpeed scores, a list of suggestions to make that page faster, and other
  information."
  {:scopes ["openid"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pagespeedonline.googleapis.com/"
     "pagespeedonline/v5/runPagespeed"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
