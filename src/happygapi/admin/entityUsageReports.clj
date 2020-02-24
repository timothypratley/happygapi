(ns happygapi.admin.entityUsageReports
  "Admin Reports API
  Fetches reports for the administrators of G Suite customers about the usage, collaboration, security, and risk for their users.
  See: /admin-sdk/reports/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: date,entityKey,entityType
  
  Retrieves a report which is a collection of properties and statistics for entities used by users within the account. For more information, see the Entities Usage Report guide. For more information about the entities report's parameters, see the Entities Usage parameters reference guides."
  {:scopes ["https://www.googleapis.com/auth/admin.reports.usage.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"entityKey" "entityType" "date"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/admin/reports/v1/"
     "usage/{entityType}/{entityKey}/dates/{date}"
     #{"entityKey" "entityType" "date"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
