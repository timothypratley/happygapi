(ns happygapi.dfareporting.reports
  "DCM/DFA Reporting And Trafficking API
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: profileId,reportId
  
  Deletes a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}"
     #{"reportId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: profileId,reportId
  
  Retrieves a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}"
     #{"reportId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: profileId
  
  Creates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports"
     #{"profileId"}
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

(defn list$
  "Required parameters: profileId
  
  Retrieves list of reports."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports"
     #{"profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn run$
  "Required parameters: profileId,reportId
  
  Runs a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}/run"
     #{"reportId" "profileId"}
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

(defn update$
  "Required parameters: profileId,reportId
  
  Updates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}"
     #{"reportId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn compatibleFields-query$
  "Required parameters: profileId
  
  Returns the fields that are compatible to be selected in the respective sections of a report criteria, given the fields already selected in the input report and user permissions."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/compatiblefields/query"
     #{"profileId"}
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

(defn files-get$
  "Required parameters: fileId,profileId,reportId
  
  Retrieves a report file. This method supports media download."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "profileId" "fileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}/files/{fileId}"
     #{"reportId" "profileId" "fileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn files-list$
  "Required parameters: profileId,reportId
  
  Lists files for a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}/files"
     #{"reportId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
