(ns happygapi.admin.userUsageReport
  "Admin Reports API: userUsageReport.
  Fetches reports for the administrators of G Suite customers about the usage, collaboration, security, and risk for their users.
  See: /admin-sdk/reports/api/reference/rest/reports_v1/userUsageReport"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "/admin-sdk/reports/api/reference/rest/reports_v1/userUsageReport/get
  
  Required parameters: date, userKey
  
  Optional parameters: customerId, filters, maxResults, orgUnitID, pageToken, parameters
  Retrieves a report which is a collection of properties and statistics for a set of users with the account. For more information, see the User Usage Report guide. For more information about the user report's parameters, see the Users Usage parameters reference guides."
  {:scopes ["https://www.googleapis.com/auth/admin.reports.usage.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:date :userKey})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/admin/reports/v1/"
     "usage/users/{userKey}/dates/{date}"
     #{:date :userKey}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
