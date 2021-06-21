(ns happygapi.admin.entityUsageReports
  "Admin SDK API: entityUsageReports.
  Admin SDK lets administrators of enterprise domains to view and manage resources like user, groups etc. It also provides audit and usage reports of domain.
  See: http://developers.google.com/admin-sdk/api/reference/rest/reports_v1/entityUsageReports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "http://developers.google.com/admin-sdk/api/reference/rest/reports_v1/entityUsageReports/get
  
  Required parameters: date, entityType, entityKey
  
  Optional parameters: customerId, filters, pageToken, maxResults, parameters
  
  Retrieves a report which is a collection of properties and statistics for entities used by users within the account. For more information, see the Entities Usage Report guide. For more information about the entities report's parameters, see the Entities Usage parameters reference guides."
  {:scopes ["https://www.googleapis.com/auth/admin.reports.usage.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:date :entityKey :entityType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admin.googleapis.com/"
     "admin/reports/v1/usage/{entityType}/{entityKey}/dates/{date}"
     #{:date :entityKey :entityType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
