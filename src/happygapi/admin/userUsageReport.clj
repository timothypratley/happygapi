(ns happygapi.admin.userUsageReport
  "Admin Reports API
  Fetches reports for the administrators of G Suite customers about the usage, collaboration, security, and risk for their users.
  See: /admin-sdk/reports/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "admin_schema.edn"))))

(defn get$
  "Required parameters: date, userKey
  
  Optional parameters: customerId, filters, maxResults, orgUnitID, pageToken, parameters
  
  Retrieves a report which is a collection of properties and statistics for a set of users with the account. For more information, see the User Usage Report guide. For more information about the user report's parameters, see the Users Usage parameters reference guides."
  {:scopes ["https://www.googleapis.com/auth/admin.reports.usage.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userKey" "date"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/admin/reports/v1/"
     "usage/users/{userKey}/dates/{date}"
     #{"userKey" "date"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
