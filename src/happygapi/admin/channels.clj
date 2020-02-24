(ns happygapi.admin.channels
  "Admin Reports API
  Fetches reports for the administrators of G Suite customers about the usage, collaboration, security, and risk for their users.
  See: /admin-sdk/reports/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn stop$
  "Required parameters: none
  
  Stop watching resources through this channel"
  {:scopes ["https://www.googleapis.com/auth/admin.reports.audit.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/admin/reports/v1/"
     "/admin/reports_v1/channels/stop"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
