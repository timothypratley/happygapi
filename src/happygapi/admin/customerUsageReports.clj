(ns happygapi.admin.customerUsageReports
  "Admin Reports API
  Fetches reports for the administrators of G Suite customers about the usage, collaboration, security, and risk for their users.
  See: /admin-sdk/reports/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: date
  
  Retrieves a report which is a collection of properties and statistics for a specific customer's account. For more information, see the Customers Usage Report guide. For more information about the customer report's parameters, see the Customers Usage parameters reference guides."
  {:scopes ["https://www.googleapis.com/auth/admin.reports.usage.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"date"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/admin/reports/v1/"
     "usage/dates/{date}"
     #{"date"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
