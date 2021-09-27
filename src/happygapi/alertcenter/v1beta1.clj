(ns happygapi.alertcenter.v1beta1
  "Google Workspace Alert Center API: v1beta1.
  Manages alerts on issues affecting your domain.
  See: https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/v1beta1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/updateSettings
  
  Required parameters: none
  
  Optional parameters: customerId
  
  Body: 
  
  {:notifications [{:cloudPubsubTopic CloudPubsubTopic}]}
  
  Updates the customer-level settings."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/settings"
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

(defn $
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/getSettings
  
  Required parameters: none
  
  Optional parameters: customerId
  
  Returns customer-level settings."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/settings"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
