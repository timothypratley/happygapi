(ns happygapi.admin.channels
  "Admin Reports API: channels.
  Fetches reports for the administrators of G Suite customers about the usage, collaboration, security, and risk for their users.
  See: /admin-sdk/reports/api/reference/rest/reports_v1/channels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn stop$
  "/admin-sdk/reports/api/reference/rest/reports_v1/channels/stop
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:address string,
   :resourceUri string,
   :payload boolean,
   :expiration string,
   :params {},
   :type string,
   :resourceId string,
   :token string,
   :id string,
   :kind string}
  
  Stop watching resources through this channel"
  {:scopes ["https://www.googleapis.com/auth/admin.reports.audit.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/admin/reports/v1/"
     "/admin/reports_v1/channels/stop"
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
