(ns happygapi.chromeuxreport.records
  "Chrome UX Report API: records.
  The Chrome UX Report API lets you view real user experience data for millions of websites. 
  See: https://developers.google.com/web/tools/chrome-user-experience-report/api/referenceapi/reference/rest/v1/records"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn queryRecord$
  "https://developers.google.com/web/tools/chrome-user-experience-report/api/referenceapi/reference/rest/v1/records/queryRecord
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:origin string,
   :url string,
   :effectiveConnectionType string,
   :formFactor string,
   :metrics [string]}
  
  Queries the Chrome User Experience for a single `record` for a given site. Returns a `record` that contains one or more `metrics` corresponding to performance data about the requested site."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromeuxreport.googleapis.com/"
     "v1/records:queryRecord"
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

(defn queryHistoryRecord$
  "https://developers.google.com/web/tools/chrome-user-experience-report/api/referenceapi/reference/rest/v1/records/queryHistoryRecord
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:origin string, :url string, :formFactor string, :metrics [string]}
  
  Queries the Chrome User Experience Report for a timeseries `history record` for a given site. Returns a `history record` that contains one or more `metric timeseries` corresponding to performance data about the requested site."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromeuxreport.googleapis.com/"
     "v1/records:queryHistoryRecord"
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
