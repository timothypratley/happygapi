(ns happygapi.firebasedatabase.projects
  "Firebase Realtime Database API: projects.
  The Firebase Realtime Database API enables programmatic provisioning and management of Realtime Database instances.
  See: https://firebase.google.com/docs/reference/rest/database/database-management/rest/api/reference/rest/v1beta/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-instances-disable$
  "https://firebase.google.com/docs/reference/rest/database/database-management/rest/api/reference/rest/v1beta/projects/locations/instances/disable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Disables a DatabaseInstance. The database can be re-enabled later using ReenableDatabaseInstance. When a database is disabled, all reads and writes are denied, including view access in the Firebase console."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedatabase.googleapis.com/"
     "v1beta/{+name}:disable"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-undelete$
  "https://firebase.google.com/docs/reference/rest/database/database-management/rest/api/reference/rest/v1beta/projects/locations/instances/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Restores a DatabaseInstance that was previously marked to be deleted. After the delete method is used, DatabaseInstances are set to the DELETED state for 20 days, and will be purged within 30 days. Databases in the DELETED state can be undeleted without losing any data. This method may only be used on a DatabaseInstance in the DELETED state. Purged DatabaseInstances may not be recovered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedatabase.googleapis.com/"
     "v1beta/{+name}:undelete"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-delete$
  "https://firebase.google.com/docs/reference/rest/database/database-management/rest/api/reference/rest/v1beta/projects/locations/instances/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Marks a DatabaseInstance to be deleted. The DatabaseInstance will be set to the DELETED state for 20 days, and will be purged within 30 days. The default database cannot be deleted. IDs for deleted database instances may never be recovered or re-used. The Database may only be deleted if it is already in a DISABLED state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebasedatabase.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-reenable$
  "https://firebase.google.com/docs/reference/rest/database/database-management/rest/api/reference/rest/v1beta/projects/locations/instances/reenable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Enables a DatabaseInstance. The database must have been disabled previously using DisableDatabaseInstance. The state of a successfully reenabled DatabaseInstance is ACTIVE."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedatabase.googleapis.com/"
     "v1beta/{+name}:reenable"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-get$
  "https://firebase.google.com/docs/reference/rest/database/database-management/rest/api/reference/rest/v1beta/projects/locations/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the DatabaseInstance identified by the specified resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasedatabase.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-list$
  "https://firebase.google.com/docs/reference/rest/database/database-management/rest/api/reference/rest/v1beta/projects/locations/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, showDeleted, pageToken
  
  Lists each DatabaseInstance associated with the specified parent project. The list items are returned in no particular order, but will be a consistent view of the database instances when additional requests are made with a `pageToken`. The resulting list contains instances in any STATE. The list results may be stale by a few seconds. Use GetDatabaseInstance for consistent reads."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasedatabase.googleapis.com/"
     "v1beta/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-create$
  "https://firebase.google.com/docs/reference/rest/database/database-management/rest/api/reference/rest/v1beta/projects/locations/instances/create
  
  Required parameters: parent
  
  Optional parameters: databaseId, validateOnly
  
  Body: 
  
  {:type string,
   :project string,
   :name string,
   :state string,
   :databaseUrl string}
  
  Requests that a new DatabaseInstance be created. The state of a successfully created DatabaseInstance is ACTIVE. Only available for projects on the Blaze plan. Projects can be upgraded using the Cloud Billing API https://cloud.google.com/billing/reference/rest/v1/projects/updateBillingInfo. Note that it might take a few minutes for billing enablement state to propagate to Firebase systems."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedatabase.googleapis.com/"
     "v1beta/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
