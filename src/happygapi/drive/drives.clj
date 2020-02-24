(ns happygapi.drive.drives
  "Drive API
  Manages files in Drive including uploading, downloading, searching, detecting changes, and updating sharing permissions.
  See: https://developers.google.com/drive/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn create$
  "Required parameters: requestId
  
  Creates a new shared drive."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"requestId"})]}
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
  
  Permanently deletes a shared drive for which the user is an organizer. The shared drive cannot contain any untrashed items."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args]
  {:pre [(util/has-keys? args #{"driveId"})]}
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
  
  Gets a shared drive's metadata by ID."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"driveId"})]}
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
  
  Hides a shared drive from the default view."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"driveId"})]}
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
  
  Lists the user's shared drives."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
  
  Restores a shared drive to the default view."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"driveId"})]}
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
  
  Updates the metadate for a shared drive."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args]
  {:pre [(util/has-keys? args #{"driveId"})]}
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
