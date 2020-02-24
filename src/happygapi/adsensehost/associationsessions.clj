(ns happygapi.adsensehost.associationsessions
  "AdSense Host API
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn start$
  "Required parameters: productCode,websiteUrl
  
  Create an association session for initiating an association with an AdSense user."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"productCode" "websiteUrl"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "associationsessions/start"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn verify$
  "Required parameters: token
  
  Verify an association session after the association callback returns from AdSense signup."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"token"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "associationsessions/verify"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
