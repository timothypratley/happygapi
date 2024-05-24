(ns happygapi.admin.userUsageReport
  "Admin SDK API: userUsageReport.
  Admin SDK lets administrators of enterprise domains to view and manage resources like user, groups etc. It also provides audit and usage reports of domain.
  See: https://developers.google.com/admin-sdk/docs/reference/rest/reports_v1/userUsageReport"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/admin-sdk/api/reference/rest/reports_v1/userUsageReport/get
  
  Required parameters: date, userKey
  
  Optional parameters: filters, orgUnitID, pageToken, customerId, parameters, groupIdFilter, maxResults
  
  Retrieves a report which is a collection of properties and statistics for a set of users with the account. For more information, see the User Usage Report guide. For more information about the user report's parameters, see the Users Usage parameters reference guides."
  {:scopes ["https://www.googleapis.com/auth/admin.reports.usage.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:date :userKey})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admin.googleapis.com/"
     "admin/reports/v1/usage/users/{userKey}/dates/{date}"
     #{:date :userKey}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
