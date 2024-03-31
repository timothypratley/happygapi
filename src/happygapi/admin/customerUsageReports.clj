(ns happygapi.admin.customerUsageReports
  "Admin SDK API: customerUsageReports.
  Admin SDK lets administrators of enterprise domains to view and manage resources like user, groups etc. It also provides audit and usage reports of domain.
  See: https://developers.google.com/admin-sdk/api/reference/rest/reports_v1/customerUsageReports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/admin-sdk/api/reference/rest/reports_v1/customerUsageReports/get
  
  Required parameters: date
  
  Optional parameters: customerId, pageToken, parameters
  
  Retrieves a report which is a collection of properties and statistics for a specific customer's account. For more information, see the Customers Usage Report guide. For more information about the customer report's parameters, see the Customers Usage parameters reference guides. "
  {:scopes ["https://www.googleapis.com/auth/admin.reports.usage.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:date})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admin.googleapis.com/"
     "admin/reports/v1/usage/dates/{date}"
     #{:date}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
