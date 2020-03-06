(ns happygapi.firebase.projects
  "Firebase Management API: projects.
  The Firebase Management API enables programmatic setup and management of Firebase projects, including a project's Firebase resources and Firebase apps.
  See: https://firebase.google.comapi/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the FirebaseProject identified by the specified resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :projectId string,
   :projectNumber string,
   :resources {:hostingSite string,
               :storageBucket string,
               :realtimeDatabaseInstance string,
               :locationId string}}
  
  Updates the attributes of the FirebaseProject identified by the
  specified resource name.
  <br>
  <br>All [query parameters](#query-parameters) are required."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getAnalyticsDetails$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/getAnalyticsDetails
  
  Required parameters: name
  
  Optional parameters: none
  Gets the Google Analytics details currently associated with a
  FirebaseProject.
  <br>
  <br>If the `FirebaseProject` is not yet linked to Google Analytics, then
  the response to `GetAnalyticsDetails` is NOT_FOUND."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn addFirebase$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/addFirebase
  
  Required parameters: project
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string, :regionCode string, :timeZone string}
  
  Adds Firebase resources to the specified existing
  [Google Cloud Platform (GCP) `Project`]
  (https://cloud.google.com/resource-manager/reference/rest/v1/projects).
  <br>
  <br>Since a FirebaseProject is actually also a GCP `Project`, a
  `FirebaseProject` uses underlying GCP identifiers (most importantly,
  the `projectId`) as its own for easy interop with GCP APIs.
  <br>
  <br>The result of this call is an [`Operation`](../../v1beta1/operations).
  Poll the `Operation` to track the provisioning process by calling
  GetOperation until
  [`done`](../../v1beta1/operations#Operation.FIELDS.done) is `true`. When
  `done` is `true`, the `Operation` has either succeeded or failed. If the
  `Operation` succeeded, its
  [`response`](../../v1beta1/operations#Operation.FIELDS.response) is set to
  a FirebaseProject; if the `Operation` failed, its
  [`error`](../../v1beta1/operations#Operation.FIELDS.error) is set to a
  google.rpc.Status. The `Operation` is automatically deleted after
  completion, so there is no need to call
  DeleteOperation.
  <br>
  <br>This method does not modify any billing account information on the
  underlying GCP `Project`.
  <br>
  <br>To call `AddFirebase`, a member must be an Editor or Owner for the
  existing GCP `Project`. Service accounts cannot call `AddFirebase`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+project}:addFirebase"
     #{:project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn removeAnalytics$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/removeAnalytics
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:analyticsPropertyId string}
  
  Unlinks the specified `FirebaseProject` from its Google Analytics account.
  <br>
  <br>This call removes the association of the specified `FirebaseProject`
  with its current Google Analytics property. However, this call does not
  delete the Google Analytics resources, such as the Google Analytics
  property or any data streams.
  <br>
  <br>These resources may be re-associated later to the `FirebaseProject` by
  calling
  [`AddGoogleAnalytics`](../../v1beta1/projects/addGoogleAnalytics) and
  specifying the same `analyticsPropertyId`. For Android Apps and iOS Apps,
  this call re-links data streams with their corresponding apps. However,
  for Web Apps, this call provisions a <em>new</em> data stream for each Web
  App.
  <br>
  <br>To call `RemoveAnalytics`, a member must be an Owner for
  the `FirebaseProject`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}:removeAnalytics"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn searchApps$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/searchApps
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  A convenience method that lists all available Apps for the specified
  FirebaseProject.
  <br>
  <br>Typically, interaction with an App should be done using the
  platform-specific service, but some tool use-cases require a summary of all
  known Apps (such as for App selector interfaces)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}:searchApps"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  Lists each FirebaseProject accessible to the caller.
  <br>
  <br>The elements are returned in no particular order, but they will be a
  consistent view of the Projects when additional requests are made with a
  `pageToken`.
  <br>
  <br>This method is eventually consistent with Project mutations, which
  means newly provisioned Projects and recent modifications to existing
  Projects might not be reflected in the set of Projects. The list will
  include only ACTIVE Projects.
  <br>
  <br>Use
  GetFirebaseProject
  for consistent reads as well as for additional Project details."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/projects"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getAdminSdkConfig$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/getAdminSdkConfig
  
  Required parameters: name
  
  Optional parameters: none
  Gets the configuration artifact used by servers to simplify initialization.
  <br>
  <br>Typically, this configuration is used with the Firebase Admin SDK
  [initializeApp](https://firebase.google.com/docs/admin/setup#initialize_the_sdk)
  command."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn addGoogleAnalytics$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/addGoogleAnalytics
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:analyticsPropertyId string, :analyticsAccountId string}
  
  Links a FirebaseProject with an existing
  [Google Analytics account](http://www.google.com/analytics/).
  <br>
  <br>Using this call, you can either:
  <ul>
  <li>Specify an `analyticsAccountId` to provision a new Google Analytics
  property within the specified account and associate the new property with
  your `FirebaseProject`.</li>
  <li>Specify an existing `analyticsPropertyId` to associate the property
  with your `FirebaseProject`.</li>
  </ul>
  <br>
  Note that when you call `AddGoogleAnalytics`:
  <ol>
  <li>The first check determines if any existing data streams in the
  Google Analytics property correspond to any existing Firebase Apps in your
  `FirebaseProject` (based on the `packageName` or `bundleId` associated with
  the data stream). Then, as applicable, the data streams and apps are
  linked. Note that this auto-linking only applies to Android Apps and iOS
  Apps.</li>
  <li>If no corresponding data streams are found for your Firebase Apps,
  new data streams are provisioned in the Google Analytics property
  for each of your Firebase Apps. Note that a new data stream is always
  provisioned for a Web App even if it was previously associated with a
  data stream in your Analytics property.</li>
  </ol>
  Learn more about the hierarchy and structure of Google Analytics
  accounts in the
  [Analytics
  documentation](https://support.google.com/analytics/answer/9303323).
  <br>
  <br>The result of this call is an [`Operation`](../../v1beta1/operations).
  Poll the `Operation` to track the provisioning process by calling
  GetOperation until
  [`done`](../../v1beta1/operations#Operation.FIELDS.done) is `true`. When
  `done` is `true`, the `Operation` has either succeeded or failed. If the
  `Operation` succeeded, its
  [`response`](../../v1beta1/operations#Operation.FIELDS.response) is set to
  an AnalyticsDetails; if the `Operation` failed, its
  [`error`](../../v1beta1/operations#Operation.FIELDS.error) is set to a
  google.rpc.Status.
  <br>
  <br>To call `AddGoogleAnalytics`, a member must be an Owner for
  the existing `FirebaseProject` and have the
  [`Edit` permission](https://support.google.com/analytics/answer/2884495)
  for the Google Analytics account.
  <br>
  <br>If a `FirebaseProject` already has Google Analytics enabled, and you
  call `AddGoogleAnalytics` using an `analyticsPropertyId` that's different
  from the currently associated property, then the call will fail. Analytics
  may have already been enabled in the Firebase console or by specifying
  `timeZone` and `regionCode` in the call to
  [`AddFirebase`](../../v1beta1/projects/addFirebase)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}:addGoogleAnalytics"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn availableLocations-list$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/availableLocations/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Returns a list of valid Google Cloud Platform (GCP) resource locations for
  the specified Project (including a FirebaseProject).
  <br>
  <br>One of these locations can be selected as the Project's [_default_ GCP
  resource location](https://firebase.google.com/docs/projects/locations),
  which is the geographical location where project resources, such as Cloud
  Firestore, will be provisioned by default. However, if the default GCP
  resource location has already been set for the Project, then this setting
  cannot be changed.
  <br>
  <br>This call checks for any location restrictions for the specified
  Project and, thus, might return a subset of all possible GCP resource
  locations. To list all GCP resource locations (regardless of any
  restrictions), call the endpoint without specifying a `projectId` (that is,
  `/v1beta1/{parent=projects/-}/listAvailableLocations`).
  <br>
  <br>To call `ListAvailableLocations` with a specified project, a member
  must be at minimum a Viewer of the project. Calls without a specified
  project do not require any specific project permissions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/availableLocations"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webApps-getConfig$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/webApps/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  Gets the configuration artifact associated with the specified WebApp."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webApps-get$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/webApps/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the WebApp identified by the specified resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webApps-list$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/webApps/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Lists each WebApp associated with the specified parent Project.
  <br>
  <br>The elements are returned in no particular order, but will be a
  consistent view of the Apps when additional requests are made with a
  `pageToken`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/webApps"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webApps-patch$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/webApps/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :appId string,
   :projectId string,
   :appUrls [string],
   :name string}
  
  Updates the attributes of the WebApp identified by the specified
  resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webApps-create$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/webApps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :appId string,
   :projectId string,
   :appUrls [string],
   :name string}
  
  Requests that a new WebApp be created.
  <br>
  <br>The result of this call is an `Operation` which can be used to track
  the provisioning process. The `Operation` is automatically deleted after
  completion, so there is no need to call `DeleteOperation`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/webApps"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn defaultLocation-finalize$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/defaultLocation/finalize
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string}
  
  Sets the default Google Cloud Platform (GCP) resource location for the
  specified FirebaseProject.
  <br>
  <br>This method creates an App Engine application with a
  [default Cloud Storage
  bucket](https://cloud.google.com/appengine/docs/standard/python/googlecloudstorageclient/setting-up-cloud-storage#activating_a_cloud_storage_bucket),
  located in the specified
  [`location_id`](#body.request_body.FIELDS.location_id).
  This location must be one of the available
  [GCP resource
  locations](https://firebase.google.com/docs/projects/locations). <br>
  <br>After the default GCP resource location is finalized, or if it was
  already set, it cannot be changed. The default GCP resource location for
  the specified FirebaseProject might already be set because either the
  GCP `Project` already has an App Engine application or
  `FinalizeDefaultLocation` was previously called with a specified
  `location_id`. Any new calls to `FinalizeDefaultLocation` with a
  <em>different</em> specified `location_id` will return a 409 error.
  <br>
  <br>The result of this call is an [`Operation`](../../v1beta1/operations),
  which can be used to track the provisioning process. The
  [`response`](../../v1beta1/operations#Operation.FIELDS.response) type of
  the `Operation` is google.protobuf.Empty.
  <br>
  <br>The `Operation` can be polled by its `name` using
  GetOperation until `done` is
  true. When `done` is true, the `Operation` has either succeeded or failed.
  If the `Operation` has succeeded, its
  [`response`](../../v1beta1/operations#Operation.FIELDS.response) will be
  set to a google.protobuf.Empty; if the `Operation` has failed, its
  `error` will be set to a google.rpc.Status. The `Operation` is
  automatically deleted after completion, so there is no need to call
  DeleteOperation.
  <br>
  <br>All fields listed in the [request body](#request-body) are required.
  <br>
  <br>To call `FinalizeDefaultLocation`, a member must be an Owner
  of the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/defaultLocation:finalize"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn iosApps-get$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/iosApps/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the IosApp identified by the specified resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn iosApps-list$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/iosApps/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Lists each IosApp associated with the specified parent Project.
  <br>
  <br>The elements are returned in no particular order, but will be a
  consistent view of the Apps when additional requests are made with a
  `pageToken`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/iosApps"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn iosApps-patch$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/iosApps/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:bundleId string,
   :appStoreId string,
   :name string,
   :projectId string,
   :appId string,
   :displayName string}
  
  Updates the attributes of the IosApp identified by the specified
  resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn iosApps-create$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/iosApps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:bundleId string,
   :appStoreId string,
   :name string,
   :projectId string,
   :appId string,
   :displayName string}
  
  Requests that a new IosApp be created.
  <br>
  <br>The result of this call is an `Operation` which can be used to track
  the provisioning process. The `Operation` is automatically deleted after
  completion, so there is no need to call `DeleteOperation`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/iosApps"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn iosApps-getConfig$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/iosApps/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  Gets the configuration artifact associated with the specified IosApp."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn androidApps-get$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/androidApps/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the AndroidApp identified by the specified resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn androidApps-list$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/androidApps/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Lists each AndroidApp associated with the specified parent Project.
  <br>
  <br>The elements are returned in no particular order, but will be a
  consistent view of the Apps when additional requests are made with a
  `pageToken`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/androidApps"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn androidApps-patch$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/androidApps/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:appId string,
   :projectId string,
   :name string,
   :packageName string,
   :displayName string}
  
  Updates the attributes of the AndroidApp identified by the specified
  resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn androidApps-create$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/androidApps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:appId string,
   :projectId string,
   :name string,
   :packageName string,
   :displayName string}
  
  Requests that a new AndroidApp be created.
  <br>
  <br>The result of this call is an `Operation` which can be used to track
  the provisioning process. The `Operation` is automatically deleted after
  completion, so there is no need to call `DeleteOperation`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/androidApps"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn androidApps-getConfig$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/androidApps/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  Gets the configuration artifact associated with the specified
  AndroidApp."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn androidApps-sha-delete$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/androidApps/sha/delete
  
  Required parameters: name
  
  Optional parameters: none
  Removes a SHA certificate from the specified AndroidApp."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn androidApps-sha-list$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/androidApps/sha/list
  
  Required parameters: parent
  
  Optional parameters: none
  Returns the list of SHA-1 and SHA-256 certificates for the specified
  AndroidApp."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/sha"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn androidApps-sha-create$
  "https://firebase.google.comapi/reference/rest/v1beta1/projects/androidApps/sha/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :shaHash string, :certType string}
  
  Adds a SHA certificate to the specified AndroidApp."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/{+parent}/sha"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
