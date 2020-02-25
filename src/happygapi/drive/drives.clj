(ns happygapi.drive.drives
  "Drive API
  Manages files in Drive including uploading, downloading, searching, detecting changes, and updating sharing permissions.
  See: https://developers.google.com/drive/"
  (:require [cheshire.core]
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
  
  Creates a new shared drive."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"requestId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives"
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

(defn delete$
  "Required parameters: driveId
  
  Optional parameters: none
  
  Permanently deletes a shared drive for which the user is an organizer. The shared drive cannot contain any untrashed items."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args]
  {:pre [(util/has-keys? args #{"driveId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}"
     #{"driveId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: driveId
  
  Optional parameters: useDomainAdminAccess
  
  Gets a shared drive's metadata by ID."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"driveId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}"
     #{"driveId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn hide$
  "Required parameters: driveId
  
  Optional parameters: none
  
  Hides a shared drive from the default view."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"driveId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}/hide"
     #{"driveId"}
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
  "Required parameters: none
  
  Optional parameters: pageSize, pageToken, q, useDomainAdminAccess
  
  Lists the user's shared drives."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn unhide$
  "Required parameters: driveId
  
  Optional parameters: none
  
  Restores a shared drive to the default view."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"driveId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}/unhide"
     #{"driveId"}
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
  "Required parameters: driveId
  
  Optional parameters: useDomainAdminAccess
  
  Updates the metadate for a shared drive."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args]
  {:pre [(util/has-keys? args #{"driveId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}"
     #{"driveId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
