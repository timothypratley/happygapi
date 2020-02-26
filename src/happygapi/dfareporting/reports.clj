(ns happygapi.dfareporting.reports
  "DCM/DFA Reporting And Trafficking API
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "dfareporting_schema.edn"))))

(defn delete$
  "Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Deletes a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Retrieves a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Creates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"profileId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn list$
  "Required parameters: profileId
  
  Optional parameters: maxResults, pageToken, scope, sortField, sortOrder
  
  Retrieves list of reports."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"profileId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: profileId, reportId
  
  Optional parameters: synchronous
  
  Runs a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn update$
  "Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Updates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})
         (json-schema/validate schemas args)]}
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
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn compatibleFields-query$
  "Required parameters: profileId
  
  Optional parameters: none
  
  Returns the fields that are compatible to be selected in the respective sections of a report criteria, given the fields already selected in the input report and user permissions."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"profileId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn files-get$
  "Required parameters: fileId, profileId, reportId
  
  Optional parameters: none
  
  Retrieves a report file. This method supports media download."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "profileId" "fileId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: profileId, reportId
  
  Optional parameters: maxResults, pageToken, sortField, sortOrder
  
  Lists files for a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "profileId"})
         (json-schema/validate schemas args)]}
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
