(ns happygapi.dfareporting.files
  "DCM/DFA Reporting And Trafficking API: files.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/files"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/files/get
  
  Required parameters: fileId, reportId
  
  Optional parameters: none
  Retrieves a report file by its report ID and file ID. This method supports media download."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{:reportId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "reports/{reportId}/files/{fileId}"
     #{:reportId :fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/files/list
  
  Required parameters: profileId
  
  Optional parameters: maxResults, pageToken, scope, sortField, sortOrder
  Lists files for a user profile."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/files"
     #{:profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
