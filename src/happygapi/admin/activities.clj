(ns happygapi.admin.activities
  "Admin SDK API: activities.
  Admin SDK lets administrators of enterprise domains to view and manage resources like user, groups etc. It also provides audit and usage reports of domain.
  See: http://developers.google.com/admin-sdk/api/reference/rest/reports_v1/activities"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn watch$
  "http://developers.google.com/admin-sdk/api/reference/rest/reports_v1/activities/watch
  
  Required parameters: applicationName, userKey
  
  Optional parameters: eventName, actorIpAddress, startTime, filters, endTime, orgUnitID, pageToken, customerId, groupIdFilter, maxResults
  
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
  
  Start receiving notifications for account activities. For more information, see Receiving Push Notifications."
  {:scopes ["https://www.googleapis.com/auth/admin.reports.audit.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:applicationName :userKey})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://admin.googleapis.com/"
     "admin/reports/v1/activity/users/{userKey}/applications/{applicationName}/watch"
     #{:applicationName :userKey}
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

(defn list$
  "http://developers.google.com/admin-sdk/api/reference/rest/reports_v1/activities/list
  
  Required parameters: applicationName, userKey
  
  Optional parameters: eventName, actorIpAddress, startTime, filters, endTime, orgUnitID, pageToken, customerId, groupIdFilter, maxResults
  
  Retrieves a list of activities for a specific customer's account and application such as the Admin console application or the Google Drive application. For more information, see the guides for administrator and Google Drive activity reports. For more information about the activity report's parameters, see the activity parameters reference guides. "
  {:scopes ["https://www.googleapis.com/auth/admin.reports.audit.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:applicationName :userKey})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admin.googleapis.com/"
     "admin/reports/v1/activity/users/{userKey}/applications/{applicationName}"
     #{:applicationName :userKey}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
