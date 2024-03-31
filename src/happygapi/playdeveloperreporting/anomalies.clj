(ns happygapi.playdeveloperreporting.anomalies
  "Google Play Developer Reporting API: anomalies.
  
  See: https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/anomalies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/anomalies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists anomalies in any of the datasets."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+parent}/anomalies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
