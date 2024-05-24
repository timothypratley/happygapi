(ns happygapi.playdeveloperreporting.apps
  "Google Play Developer Reporting API: apps.
  
  See: https://developers.google.com/play/developer/reportingdocs/reference/rest/v1beta1/apps"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/apps/search
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Searches for Apps accessible by the user."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/apps:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn fetchReleaseFilterOptions$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/apps/fetchReleaseFilterOptions
  
  Required parameters: name
  
  Optional parameters: none
  
  Describes filtering options for releases."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}:fetchReleaseFilterOptions"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
