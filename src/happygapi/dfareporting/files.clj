(ns happygapi.dfareporting.files
  "Campaign Manager 360 API: files.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/files"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/files/get
  
  Required parameters: reportId, fileId
  
  Optional parameters: none
  
  Retrieves a report file by its report ID and file ID. This method supports media download."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/reports/{reportId}/files/{fileId}"
     #{:reportId :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/files/list
  
  Required parameters: profileId
  
  Optional parameters: sortOrder, pageToken, sortField, scope, maxResults
  
  Lists files for a user profile."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/files"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
