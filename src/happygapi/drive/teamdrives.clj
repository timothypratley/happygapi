(ns happygapi.drive.teamdrives
  "Drive API
  Manages files in Drive including uploading, downloading, searching, detecting changes, and updating sharing permissions.
  See: https://developers.google.com/drive/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "drive_schema.edn"))))

(defn create$
  "Required parameters: requestId
  
  Optional parameters: none
  
  Deprecated use drives.create instead."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"requestId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives"
     #{}
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

(defn delete$
  "Required parameters: teamDriveId
  
  Optional parameters: none
  
  Deprecated use drives.delete instead."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args]
  {:pre [(util/has-keys? args #{"teamDriveId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives/{teamDriveId}"
     #{"teamDriveId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: teamDriveId
  
  Optional parameters: useDomainAdminAccess
  
  Deprecated use drives.get instead."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"teamDriveId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives/{teamDriveId}"
     #{"teamDriveId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: pageSize, pageToken, q, useDomainAdminAccess
  
  Deprecated use drives.list instead."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: teamDriveId
  
  Optional parameters: useDomainAdminAccess
  
  Deprecated use drives.update instead"
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args]
  {:pre [(util/has-keys? args #{"teamDriveId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives/{teamDriveId}"
     #{"teamDriveId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
