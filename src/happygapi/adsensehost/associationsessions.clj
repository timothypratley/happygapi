(ns happygapi.adsensehost.associationsessions
  "AdSense Host API: associationsessions.
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/api/reference/rest/v4.1/associationsessions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn start$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/associationsessions/start
  
  Required parameters: productCode, websiteUrl
  
  Optional parameters: userLocale, websiteLocale
  Create an association session for initiating an association with an AdSense user."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{:websiteUrl :productCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "associationsessions/start"
     #{:websiteUrl :productCode}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn verify$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/associationsessions/verify
  
  Required parameters: token
  
  Optional parameters: none
  Verify an association session after the association callback returns from AdSense signup."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{:token})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "associationsessions/verify"
     #{:token}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
