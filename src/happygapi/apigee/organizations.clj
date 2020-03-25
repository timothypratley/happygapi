(ns happygapi.apigee.organizations
  "Apigee API: organizations.
  The Apigee API lets you programmatically manage Apigee hybrid with a set of RESTful operations, including:<ul>  <li>Create, edit, and delete API proxies</li>  <li>Manage users</li>  <li>Deploy and undeploy proxy revisions</li>  <li>Configure environments</li></ul><p>For information on using the APIs described in this section, see <a href=\"/hybrid/api-get-started\">Get started using the APIs</a>.</p><p><strong>Note:</strong> This product is available as a free trial for a time period of 60 days.
  See: https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the profile for an Apigee organization.
  See [Organizations](/hybrid/terminology#organizations)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getSystem$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/getSystem
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the current state of the portal application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/system"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setSyncAuthorization$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/setSyncAuthorization
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:identities [string], :etag string}
  
  Sets the permissions required to allow the Synchronizer to download
  environment data from the control plane. You must call this API to enable
  proper functioning of hybrid.
  
  Pass the ETag when calling `setSyncAuthorization` to ensure that
  you are updating the correct version. To get an ETag,
  call [getSyncAuthorization](getSyncAuthorization).
  If you don't pass the ETag in the call to `setSyncAuthorization`, then the
  existing authorization is overwritten indiscriminately.
  
  For more information, see
  [Enable Synchronizer access](/hybrid/install-sa-keys)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}:setSyncAuthorization"
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

(defn create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/create
  
  Required parameters: none
  
  Optional parameters: parent
  
  Body: 
  
  {:description string,
   :properties {:property [GoogleCloudApigeeV1Property]},
   :analyticsRegion string,
   :displayName string,
   :name string,
   :customerName string,
   :createdAt string,
   :type string,
   :environments [string],
   :lastModifiedAt string,
   :attributes [string],
   :subscriptionType string}
  
  Creates an Apigee organization. See
  [Create an organization](/hybrid/precog-provision)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/organizations"
     #{}
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

(defn update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :properties {:property [GoogleCloudApigeeV1Property]},
   :analyticsRegion string,
   :displayName string,
   :name string,
   :customerName string,
   :createdAt string,
   :type string,
   :environments [string],
   :lastModifiedAt string,
   :attributes [string],
   :subscriptionType string}
  
  Updates the properties for an Apigee organization. No other fields in the
  organization profile will be updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn getSites$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/getSites
  
  Required parameters: parent
  
  Optional parameters: zmsId, domain
  
  Lists details for all portals."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/sites"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the Apigee organizations and associated GCP projects that you have
  permission to access. See
  [Organizations](/hybrid/terminology#organizations)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getMetrics$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/getMetrics
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets metrics for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/metrics"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getSyncAuthorization$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/getSyncAuthorization
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Lists the service accounts with the permissions required to allow
  the Synchronizer to download environment data from the control plane.
  
  An ETag is returned in the response to `getSyncAuthorization`.
  Pass that ETag when calling [setSyncAuthorization](setSyncAuthorization)
  to ensure that you are updating the correct version. If you don't pass the
  ETag in the call to `setSyncAuthorization`, then the existing authorization
  is overwritten indiscriminately.
  
  For more information, see
  [Enable Synchronizer access](/hybrid/install-sa-keys)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}:getSyncAuthorization"
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

(defn apps-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apps/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the app profile for the specified app ID."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apps/list
  
  Required parameters: parent
  
  Optional parameters: startKey, apiProduct, ids, keyStatus, rows, status, includeCred, expand, apptype
  
  Lists IDs of apps within an organization that have the specified app status
  (approved or revoked) or are of the specified app type
  (developer or company)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn providers-clearScope$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/providers/clearScope
  
  Required parameters: name
  
  Optional parameters: none
  
  Clears the scope of an identity provider.
  Not a recognized rest pattern"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn providers-users-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/providers/users/list
  
  Required parameters: parent
  
  Optional parameters: sortBy, sortOrder, filter, startIndex, count
  
  Lists all users."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/users"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn providers-users-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/providers/users/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn providers-users-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/providers/users/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:customFieldValues [{:fieldValue string, :fieldName string}],
   :apps [{:description string,
           :callbackUrl string,
           :apiProducts [GoogleCloudApigeeV1ApiProductRef],
           :credentials [GoogleCloudApigeeV1Credential],
           :displayName string,
           :name string,
           :ownerType string,
           :created string,
           :modified string,
           :status string,
           :apiProductsFromCredentials [GoogleCloudApigeeV1Credential],
           :id string,
           :owner string}],
   :email string,
   :name {:familyName string, :givenName string, :userName string},
   :passwordLastModified string,
   :teams [{:description string,
            :memberCount integer,
            :apps [GoogleCloudApigeeV1PortalApp],
            :name string,
            :created string,
            :id string,
            :memberships [GoogleCloudApigeeV1ConsumerTeamMembership],
            :audiences [GoogleCloudApigeeV1ConsumerAudience],
            :pointOfContact string,
            :users [GoogleCloudApigeeV1ConsumerUser]}],
   :active boolean,
   :id string,
   :audiences [{:resources [string],
                :membershipType string,
                :name string,
                :teams [GoogleCloudApigeeV1ConsumersTeam],
                :id string,
                :created string,
                :description string,
                :users [GoogleCloudApigeeV1ConsumerUser]}],
   :verified boolean}
  
  Updates a user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn providers-users-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/providers/users/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn providers-resources-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/providers/resources/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn providers-resources-createResource$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/providers/resources/createResource
  
  Required parameters: name
  
  Optional parameters: none
  
  Creates a resource ID for the resource path.
  Not a recognized rest pattern"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn system-getAnnouncements$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/system/getAnnouncements
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets any cross-organizational announcement that you want to
  display to customers on the UI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/system/announcements"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn keyvaluemaps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/keyvaluemaps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a key value map in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn keyvaluemaps-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/keyvaluemaps/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  List key value maps in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keyvaluemaps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn keyvaluemaps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/keyvaluemaps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encrypted boolean, :name string}
  
  Creates a key value map in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keyvaluemaps"
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

(defn sites-send-test-email$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/send-test-email
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:emailTemplateId string, :to string}
  
  Sends a test email using the email template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/send-test-email"
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

(defn sites-getCustomcss$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/getCustomcss
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the custom CSS for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/customcss"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:trashedBy string,
   :idpEnabled boolean,
   :description string,
   :altLogoUrl string,
   :timeZone string,
   :currentDomain string,
   :anonAllowedByDefault boolean,
   :defaultDomain string,
   :logoUrl string,
   :approvedEmails string,
   :siteDomainSuffix string,
   :zoneId string,
   :name string,
   :orgName string,
   :analyticsScript string,
   :showSettings boolean,
   :defaultURL string,
   :created string,
   :lastPublished string,
   :itSecretKey string,
   :teams [string],
   :migrationSrcSiteId string,
   :theme string,
   :migrationDestSiteId string,
   :customerId string,
   :currentURL string,
   :lastModified string,
   :status string,
   :iconUrl string,
   :language string,
   :themeVersion string,
   :trashed boolean,
   :id string,
   :portalVersion integer,
   :fileLimit integer,
   :customDomain string,
   :analyticsTrackingId string,
   :trashedOn string,
   :stylesheetDirty boolean,
   :iconBg string,
   :customDomainEnabled boolean,
   :direction string,
   :lastLogin string,
   :https boolean}
  
  Creates a new portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/sites"
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

(defn sites-getOrgtype$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/getOrgtype
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the organization type for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/orgtype"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-getAudiencesenabled$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/getAudiencesenabled
  
  Required parameters: parent
  
  Optional parameters: none
  
  Retrieves the audience feature flag setting for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/audiencesenabled"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-getPortal$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/getPortal
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the details for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/portal"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-getConfig$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/getConfig
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the portal configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/sites/config"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-render$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/render
  
  Required parameters: parent
  
  Optional parameters: pageId, draft
  
  Gets the title and contents of the page on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/render"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-updateCustomcss$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/updateCustomcss
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:cssEditorPayload {:content string, :kind string},
   :themeEditorPayload {:editorMode string,
                        :logo string,
                        :kind string,
                        :mobileLogo string,
                        :overrides string,
                        :customScss string,
                        :variables string,
                        :favicon string}}
  
  Updates the custom CSS for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/customcss"
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

(defn sites-getDrafttoken$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/getDrafttoken
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the draft token for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/drafttoken"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-updateSmtp$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/updateSmtp
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:siteId string,
   :fromEmail string,
   :password string,
   :authType string,
   :username string,
   :port string,
   :securePassword string,
   :host string,
   :id integer,
   :secure boolean}
  
  Updates the SMTP configuration for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/smtp"
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

(defn sites-getKeystores$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/getKeystores
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the keystores and certs that are available for TLS configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keystores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-updatePortal$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/updatePortal
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:trashedBy string,
   :idpEnabled boolean,
   :description string,
   :altLogoUrl string,
   :timeZone string,
   :currentDomain string,
   :anonAllowedByDefault boolean,
   :defaultDomain string,
   :logoUrl string,
   :approvedEmails string,
   :siteDomainSuffix string,
   :zoneId string,
   :name string,
   :orgName string,
   :analyticsScript string,
   :showSettings boolean,
   :defaultURL string,
   :created string,
   :lastPublished string,
   :itSecretKey string,
   :teams [string],
   :migrationSrcSiteId string,
   :theme string,
   :migrationDestSiteId string,
   :customerId string,
   :currentURL string,
   :lastModified string,
   :status string,
   :iconUrl string,
   :language string,
   :themeVersion string,
   :trashed boolean,
   :id string,
   :portalVersion integer,
   :fileLimit integer,
   :customDomain string,
   :analyticsTrackingId string,
   :trashedOn string,
   :stylesheetDirty boolean,
   :iconBg string,
   :customDomainEnabled boolean,
   :direction string,
   :lastLogin string,
   :https boolean}
  
  Updates a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/portal"
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

(defn sites-getPublishedapis$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/getPublishedapis
  
  Required parameters: parent
  
  Optional parameters: filter
  
  Lists all published APIs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/publishedapis"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-getSmtp$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/getSmtp
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the SMTP configuration for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/smtp"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-trash$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/trash
  
  Required parameters: parent
  
  Optional parameters: none
  
  Deletes a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/trash"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-menutypes-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menutypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:friendlyId string,
   :menuTypeId string,
   :name string,
   :modified string,
   :siteId string,
   :modifiedBy string}
  
  Creates a menu type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/menutypes"
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

(defn sites-menutypes-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menutypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a menu type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-menutypes-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menutypes/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all menu types."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/menutypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-drafttoken-verify$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/drafttoken/verify
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:draftToken string}
  
  Verifies a draft token for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/drafttoken/verify"
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

(defn sites-email-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/email/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an email template for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-email-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/email/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:siteId string,
   :textBody string,
   :htmlBody string,
   :variables [string],
   :modified string,
   :title string,
   :id integer,
   :emailTemplateId string,
   :modifiedBy string,
   :subject string}
  
  Updates an email template for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn sites-site-key$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/site/key
  
  Required parameters: parent
  
  Optional parameters: none
  
  Regenerates the secret key for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/site/key"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-site-defaultanonallowed$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/site/defaultanonallowed
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:defaultAnonAllowed boolean}
  
  Sets the default visibility to all users (public), using the
  `defaultAnonAllowed` flag, for pages and API products that are published
  on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/site/defaultanonallowed"
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

(defn sites-site-getDefaultanonallowed$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/site/getDefaultanonallowed
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the `defaultAnonAllowed` flag setting for a portal. This flag
  defines the default visibility for pages and API products that are
  published on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/site/defaultanonallowed"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-site-approvedEmails$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/site/approvedEmails
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:approvedEmails string}
  
  Restricts portal registration by identifying the individual email addresses
  or email domains that can create accounts on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/site/approvedEmails"
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

(defn sites-site-getDomains$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/site/getDomains
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the custom domain configuration for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/site/domains"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-site-domains$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/site/domains
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:tlsAlias string,
   :siteId string,
   :subdomain string,
   :tlsKeystore string,
   :redirectHttps boolean,
   :force boolean,
   :domain string,
   :id string}
  
  Enables or updates the custom domain for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/site/domains"
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

(defn sites-site-clone$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/site/clone
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:trashedBy string,
   :idpEnabled boolean,
   :description string,
   :altLogoUrl string,
   :timeZone string,
   :currentDomain string,
   :anonAllowedByDefault boolean,
   :defaultDomain string,
   :logoUrl string,
   :approvedEmails string,
   :siteDomainSuffix string,
   :zoneId string,
   :name string,
   :orgName string,
   :analyticsScript string,
   :showSettings boolean,
   :defaultURL string,
   :created string,
   :lastPublished string,
   :itSecretKey string,
   :teams [string],
   :migrationSrcSiteId string,
   :theme string,
   :migrationDestSiteId string,
   :customerId string,
   :currentURL string,
   :lastModified string,
   :status string,
   :iconUrl string,
   :language string,
   :themeVersion string,
   :trashed boolean,
   :id string,
   :portalVersion integer,
   :fileLimit integer,
   :customDomain string,
   :analyticsTrackingId string,
   :trashedOn string,
   :stylesheetDirty boolean,
   :iconBg string,
   :customDomainEnabled boolean,
   :direction string,
   :lastLogin string,
   :https boolean}
  
  Clones an existing portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/site/clone"
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

(defn sites-site-analytics$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/site/analytics
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:analyticsTrackingId string, :analyticsScript string}
  
  Updates the custom analytics script for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/site/analytics"
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

(defn sites-file-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/file/delete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filename string}
  
  Deletes a file from the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/file/delete"
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

(defn sites-file-post$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/file/post
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Uploads a file to the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/file/post"
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

(defn sites-file-list-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/file/list/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all files stored on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/file/list"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-resource-entitlements-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/resource-entitlements/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lists the resource audience entitlements."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-resource-entitlements-updateResourceEntitlement$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/resource-entitlements/updateResourceEntitlement
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:authEntitled boolean,
   :explicitAudiences [{:entitled boolean,
                        :audience GoogleCloudApigeeV1Audience}],
   :isPublic boolean}
  
  Updates audience entitlements for a resource.
  Not a recognized rest pattern"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn sites-pages-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/pages/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a page from the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-pages-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/pages/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the pages on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/pages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-pages-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/pages/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :anonAllowed boolean,
   :siteId string,
   :friendlyId string,
   :layout string,
   :content string,
   :apiProduct string,
   :name string,
   :systemGenerated boolean,
   :type string,
   :created string,
   :modified string,
   :publishedBy string,
   :generatedContent [string],
   :draft string,
   :active boolean,
   :id string,
   :submenuId string,
   :modifiedBy string,
   :published string}
  
  Creates a new page on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/pages"
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

(defn sites-pages-content$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/pages/content
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:content string}
  
  Updates the draft content of a page on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/content"
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

(defn sites-pages-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/pages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a page on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-pages-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/pages/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :anonAllowed boolean,
   :siteId string,
   :friendlyId string,
   :layout string,
   :content string,
   :apiProduct string,
   :name string,
   :systemGenerated boolean,
   :type string,
   :created string,
   :modified string,
   :publishedBy string,
   :generatedContent [string],
   :draft string,
   :active boolean,
   :id string,
   :submenuId string,
   :modifiedBy string,
   :published string}
  
  Updates a page on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn sites-pages-publish$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/pages/publish
  
  Required parameters: parent
  
  Optional parameters: none
  
  Publishes a page on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/publish"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-pages-unpublish$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/pages/unpublish
  
  Required parameters: parent
  
  Optional parameters: none
  
  Unpublishes a page on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/unpublish"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-pages-menutypes-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/pages/menutypes/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the menu types that reference a specific page."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/menutypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-customcss-publish$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/customcss/publish
  
  Required parameters: parent
  
  Optional parameters: none
  
  Publishes the custom CSS for a portal"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/publish"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-customcss-getEditorschema$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/customcss/getEditorschema
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the information required for the theme editor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/editorschema"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-specs-listProxySpecs$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/specs/listProxySpecs
  
  Required parameters: name
  
  Optional parameters: none
  
  Lists details for the OpenAPI Specifications associated with an API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-zones-associateSiteZone$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/zones/associateSiteZone
  
  Required parameters: name
  
  Optional parameters: none
  
  Associates a portal with a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-dns-check$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/dns/check
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:domain string, :cname string}
  
  Checks DNS to verify that a domain has the
  expected canonical name (CNAME) record."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/sites/dns/check"
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

(defn sites-smtp-reset$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/smtp/reset
  
  Required parameters: parent
  
  Optional parameters: none
  
  Resets the default settings for the SMTP configuration for a portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/smtp/reset"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-apidocs-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apidocs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:specTitle string,
   :description string,
   :snapshotSourceMissing boolean,
   :snapshotModified string,
   :snapshotExists boolean,
   :enrollment string,
   :anonAllowed boolean,
   :siteId string,
   :snapshotOutdated boolean,
   :edgeAPIProductName string,
   :modified string,
   :title string,
   :requireCallbackUrl boolean,
   :imageUrl string,
   :specId string,
   :id string,
   :specModified string,
   :specContent string,
   :productExists boolean,
   :visibility boolean,
   :snapshotState string,
   :apiId string}
  
  Publishes an API to the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apidocs"
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

(defn sites-apidocs-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apidocs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details for a published API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-apidocs-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apidocs/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:specTitle string,
   :description string,
   :snapshotSourceMissing boolean,
   :snapshotModified string,
   :snapshotExists boolean,
   :enrollment string,
   :anonAllowed boolean,
   :siteId string,
   :snapshotOutdated boolean,
   :edgeAPIProductName string,
   :modified string,
   :title string,
   :requireCallbackUrl boolean,
   :imageUrl string,
   :specId string,
   :id string,
   :specModified string,
   :specContent string,
   :productExists boolean,
   :visibility boolean,
   :snapshotState string,
   :apiId string}
  
  Updates the details or specification for a published API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn sites-apidocs-snapshot$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apidocs/snapshot
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Uploads the contents of an OpenAPI Specification snapshot for
  a published API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/snapshot"
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

(defn sites-apidocs-deleteSnapshot$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apidocs/deleteSnapshot
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes the current OpenAPI Specification snapshot from the published API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/snapshot"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-apidocs-listPublishableProducts$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apidocs/listPublishableProducts
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the APIs that can be published to the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apidocs:listPublishableProducts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-apidocs-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apidocs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes a published API from the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-apidocs-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apidocs/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the details for all published APIs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apidocs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-menuitems-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menuitems/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:isNested boolean,
   :pageId string,
   :menuTypeId string,
   :name string,
   :menuItemId string,
   :modified string,
   :draft boolean,
   :priority integer,
   :url string,
   :modifiedBy string}
  
  Updates a menu item."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn sites-menuitems-publish$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menuitems/publish
  
  Required parameters: parent
  
  Optional parameters: none
  
  Publishes all menu items."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/publish"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-menuitems-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menuitems/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a menu item."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-menuitems-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menuitems/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all menu items."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/menuitems"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-menuitems-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menuitems/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:isNested boolean,
   :pageId string,
   :menuTypeId string,
   :name string,
   :menuItemId string,
   :modified string,
   :draft boolean,
   :priority integer,
   :url string,
   :modifiedBy string}
  
  Creates a menu item."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/menuitems"
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

(defn sites-menuitems-listItemsByType$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menuitems/listItemsByType
  
  Required parameters: name
  
  Optional parameters: none
  
  Lists the menu items for a menu type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-menuitems-save-updatePriorities$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menuitems/save/updatePriorities
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Rearranges the order of menu items."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/save/priorities"
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

(defn sites-menuitems-toggle-nested$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/menuitems/toggle/nested
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:isNested boolean}
  
  Toggles the nesting of a menu item."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/toggle/nested"
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

(defn zone-enableaudiences$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zone/enableaudiences
  
  Required parameters: parent
  
  Optional parameters: none
  
  Enables the audience feature in a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/enableaudiences"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zone-getAudiencesenabled$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zone/getAudiencesenabled
  
  Required parameters: parent
  
  Optional parameters: none
  
  Retrieves the audience feature flag setting for a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/audiencesenabled"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zone-audiencesenabled-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zone/audiencesenabled/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all zones in an Apigee organization with the audience feature
  enabled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/zone/audiencesenabled"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn portals-getStatus$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/portals/getStatus
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets a health check from the server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/portals/status"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apiproducts-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets configuration details for an API product.
  
  The API product name required in the request URL is the internal name of
  the product, not the display name. While they may be the same, it depends
  on whether the API product was created via the UI or the API. View the list
  of API products to verify the internal name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apiproducts-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :description string,
   :displayName string,
   :name string,
   :createdAt string,
   :approvalType string,
   :quota string,
   :environments [string],
   :quotaTimeUnit string,
   :proxies [string],
   :lastModifiedAt string,
   :quotaInterval string,
   :attributes [{:value string, :name string}],
   :apiResources [string]}
  
  Updates an existing API product. You must include all required values,
  whether or not you are updating them, as well as any optional values that
  you are updating.
  
  The API product name required in the request URL is the
  internal name of the product, not the Display Name. While they may be the
  same, it depends on whether the API product was created via UI or API. View
  the list of API products to identify their internal names."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn apiproducts-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an API product from an organization.
  
  Deleting an API product
  causes app requests to the resource URIs defined in the API product to
  fail.
  
  Ensure that you create a new API product to serve existing apps, unless
  your intention is to disable access to the resources defined in the API
  product.
  
  The API product name required in the request URL is the internal name of
  the product, not the display name. While they may be the same, it depends
  on whether the API product was created via the UI or the API. View the list
  of API products to verify the internal name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apiproducts-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/list
  
  Required parameters: parent
  
  Optional parameters: count, startKey, attributevalue, expand, attributename
  
  Lists all API product names for an organization.
  Filter the list by passing an `attributename` and `attibutevalue`.
  
  The limit on the number of API products returned by the API is 1000. You
  can paginate the list of API products returned using the `startKey` and
  `count` query parameters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apiproducts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apiproducts-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :description string,
   :displayName string,
   :name string,
   :createdAt string,
   :approvalType string,
   :quota string,
   :environments [string],
   :quotaTimeUnit string,
   :proxies [string],
   :lastModifiedAt string,
   :quotaInterval string,
   :attributes [{:value string, :name string}],
   :apiResources [string]}
  
  Creates an API product in an organization.
  You create API products after
  you have proxied backend services using API proxies.
  An API product is a
  collection of API resources combined with quota settings and metadata that
  you can use to deliver customized and productized API bundles to your
  developer community. This metadata can include:
  
  - Scope
  - Environments
  - API proxies
  - Extensible profile
  
  API products enable you repackage APIs
  on-the-fly, without having to do any additional coding or configuration.
  Apigee recommends that you start with a simple API product including only
  required elements. You then provision credentials to apps to enable them to
  start testing your APIs.
  
  After you have authentication and authorization
  working against a simple API product, you can iterate to create finer
  grained API products, defining different sets of API resources for each API
  product.
  
  <aside class=\"warning\"><strong>WARNING:</strong>
  
  - If you don't specify an API proxy in the request body, <em>any</em> app
  associated with the product can make calls to <em>any</em> API in your
  entire organization.
  - If you don't specify an environment in the request body, the product
  allows access to all environments.
  
  </aside>
  
  For more information, see {{what_api_product}}"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apiproducts"
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

(defn apiproducts-attributes$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:attribute [{:value string, :name string}]}
  
  Updates or creates API product attributes. This API **replaces** the
  current list of attributes with the attributes specified in the request
  body. In this way, you can update existing attributes, add new attributes,
  or delete existing attributes by omitting them from the request body.
  
  OAuth access tokens and Key Management Service (KMS) entities (apps,
  developers, and API products) are cached for 180 seconds (current default).
  Any custom attributes associated with entities also get cached for at least
  180 seconds after entity is accessed during runtime.
  In this case, the `ExpiresIn` element on the OAuthV2 policy won't be able
  to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/attributes"
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

(defn apiproducts-attributes-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the value of an API product attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apiproducts-attributes-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Returns a list of all API product attributes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attributes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apiproducts-attributes-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an API product attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apiproducts-attributes-updateApiProductAttribute$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes/updateApiProductAttribute
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:value string, :name string}
  
  Updates the value of an API product attribute. Limitations are:
  
  OAuth access tokens and Key Management Service (KMS) entities (apps,
  developers, and API products) are cached for 180 seconds (current default).
  Any custom attributes associated with entities also get cached for at least
  180 seconds after entity is accessed during runtime.
  In this case, the `ExpiresIn` element on the OAuthV2 policy won't be able
  to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn teams-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/teams/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all teams a user can access."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/teams"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/list
  
  Required parameters: parent
  
  Optional parameters: includeRevisions, includeMetaData
  
  Lists all shared flows in the organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/sharedflows"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a shared flow by name, including a list of its revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/create
  
  Required parameters: parent
  
  Optional parameters: action, name
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Uploads a ZIP-formatted shared flow configuration bundle to an
  organization. If the shared flow already exists, this creates a new
  revision of it. If the shared flow does not exist, this creates it.
  
  Once imported, the shared flow revision must be deployed before it can be
  accessed at runtime.
  
  The size limit of a shared flow bundle is 15 MB."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/sharedflows"
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

(defn sharedflows-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a shared flow and all it's revisions. The shared flow must be
  undeployed before you can delete it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of a shared flow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-revisions-updateSharedFlowRevision$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/revisions/updateSharedFlowRevision
  
  Required parameters: name
  
  Optional parameters: validate
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Updates a shared flow revision. This operation is only allowed on revisions
  which have never been deployed. After deployment a revision becomes
  immutable, even if it becomes undeployed.
  
  The payload is a ZIP-formatted shared flow.  Content type must be either
  multipart/form-data or application/octet-stream."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn sharedflows-revisions-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/revisions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a shared flow and all associated policies, resources, and
  revisions. You must undeploy the shared flow before deleting it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-revisions-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/revisions/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all revisions for a shared flow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/revisions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-revisions-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/revisions/get
  
  Required parameters: name
  
  Optional parameters: format
  
  Gets a revision of a shared flow.
  
  If `format=bundle` is passed, it instead outputs a shared flow revision as
  a ZIP-formatted bundle of code and config files."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-revisions-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/revisions/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of a shared flow revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumerresources-pages$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumerresources/pages
  
  Required parameters: parent
  
  Optional parameters: q, zmsId
  
  List all pages in a ZMS zone that match the query string.
  Not a recognized rest pattern"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/consumerresources/pages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumerresources-apis$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumerresources/apis
  
  Required parameters: parent
  
  Optional parameters: q, zmsId
  
  List all API docs in a ZMS zone that match the given query.
  Not a recognized rest pattern"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/consumerresources/apis"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumerresources-getResourcetypes$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumerresources/getResourcetypes
  
  Required parameters: parent
  
  Optional parameters: none
  
  Get all consumer resource types managed by this API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/consumerresources/resourcetypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/deployments/list
  
  Required parameters: parent
  
  Optional parameters: sharedFlows
  
  Lists all deployments of API proxies or shared flows."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets environment details."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-unsubscribe$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/unsubscribe
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string}
  
  Deletes a subscription for the environment's Pub/Sub topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}:unsubscribe"
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

(defn environments-updateDebugmask$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/updateDebugmask
  
  Required parameters: name
  
  Optional parameters: updateMask, replaceRepeatedFields
  
  Body: 
  
  {:namespaces {},
   :responseXPaths [string],
   :name string,
   :variables [string],
   :requestJSONPaths [string],
   :requestXPaths [string],
   :faultJSONPaths [string],
   :faultXPaths [string],
   :responseJSONPaths [string]}
  
  Updates the debug mask singleton resource for an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn environments-setIamPolicy$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :auditConfigs [GoogleIamV1AuditConfig],
            :bindings [GoogleIamV1Binding],
            :etag string},
   :updateMask string}
  
  Sets the IAM policy on an environment, if the policy already
  exists it will be replaced. For more information, see
  [Manage users, roles, and permissions
  using the API](/hybrid/manage-users-roles).
  
  You must have the `apigee.environments.setIamPolicy` permission to
  call this API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn environments-testIamPermissions$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Tests the permissions of a user on an environment,
  and returns a subset of permissions that the user has on the environment.
  If the environment does not exist, an empty permission set is returned
  (a NOT_FOUND error is not returned)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn environments-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/create
  
  Required parameters: parent
  
  Optional parameters: name
  
  Body: 
  
  {:name string,
   :lastModifiedAt string,
   :createdAt string,
   :displayName string,
   :description string,
   :properties {:property [GoogleCloudApigeeV1Property]}}
  
  Creates an environment in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/environments"
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

(defn environments-getDatalocation$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/getDatalocation
  
  Required parameters: name
  
  Optional parameters: contentType, relativeFilePath, dataset, repo
  
  Get Google Cloud Storage (GCS) signed url for specific organization and
  environment. Collection agent uses this signed url to upload data
  to GCS bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :lastModifiedAt string,
   :createdAt string,
   :displayName string,
   :description string,
   :properties {:property [GoogleCloudApigeeV1Property]}}
  
  Updates an existing environment.
  
  When updating properties, you must pass all existing properties to the API,
  even if they are not being changed. If you omit properties from the
  payload, the properties are removed. To get the current list of
  properties for the environment, use the [Get Environment API](get)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn environments-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an environment from an organization. Returns the deleted
  environment resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-getIamPolicy$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the IAM policy on an environment. For more information, see
  [Manage users, roles, and permissions
  using the API](/hybrid/manage-users-roles).
  
  You must have the `apigee.environments.getIamPolicy` permission to call
  this API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all environments in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/environments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-getDebugmask$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/getDebugmask
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the debug mask singleton resource for an Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-updateEnvironment$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/updateEnvironment
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :lastModifiedAt string,
   :createdAt string,
   :displayName string,
   :description string,
   :properties {:property [GoogleCloudApigeeV1Property]}}
  
  Updates an existing environment.
  
  When updating properties, you must pass all existing properties to the API,
  even if they are not being changed. If you omit properties from the
  payload, the properties are removed. To get the current list of
  properties for the environment, use the [Get Environment API](get)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn environments-getDeployedConfig$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/getDeployedConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the deployed configuration for an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-subscribe$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/subscribe
  
  Required parameters: parent
  
  Optional parameters: none
  
  Creates a subscription for the environment's Pub/Sub topic.
  The server will assign a random name for this subscription.
  The \"name\" and \"push_config\" must *not* be specified."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}:subscribe"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-caches-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/caches/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a cache."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-caches-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/caches/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all caches in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/caches"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-resourcefiles-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/get
  
  Required parameters: name, type, parent
  
  Optional parameters: none
  
  Gets the contents of a resource file.
  
  For more information about resource files, see
  [Resource files](/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :name :type})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles/{type}/{name}"
     #{:parent :name :type}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-resourcefiles-listEnvironmentResources$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/listEnvironmentResources
  
  Required parameters: type, parent
  
  Optional parameters: none
  
  Lists all resource files.
  
  For more information about resource files, see
  [Resource files](/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :type})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles/{type}"
     #{:parent :type}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-resourcefiles-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/update
  
  Required parameters: name, type, parent
  
  Optional parameters: none
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Updates a resource file.
  
  Specify the `Content-Type` as `application/octet-stream` or
  `multipart/form-data`.
  
  For more information about resource files, see
  [Resource files](/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :name :type})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles/{type}/{name}"
     #{:parent :name :type}
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

(defn environments-resourcefiles-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/delete
  
  Required parameters: name, type, parent
  
  Optional parameters: none
  
  Deletes a resource file.
  
  For more information about resource files, see
  [Resource files](/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :name :type})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles/{type}/{name}"
     #{:parent :name :type}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-resourcefiles-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/list
  
  Required parameters: parent
  
  Optional parameters: type
  
  Lists all resource files.
  
  For more information about resource files, see
  [Resource files](/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-resourcefiles-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/create
  
  Required parameters: parent
  
  Optional parameters: name, type
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Creates a resource file.
  
  Specify the `Content-Type` as `application/octet-stream` or
  `multipart/form-data`.
  
  For more information about resource files, see
  [Resource files](/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles"
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

(defn environments-keyvaluemaps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keyvaluemaps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a key value map in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keyvaluemaps-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keyvaluemaps/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  List key value maps in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keyvaluemaps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keyvaluemaps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keyvaluemaps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encrypted boolean, :name string}
  
  Creates a key value map in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keyvaluemaps"
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

(defn environments-flowhooks-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/flowhooks/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the flow hooks attached to an environment. This API always
  returns: `[\"PreProxyFlowHook\", \"PostProxyFlowHook\", \"PreTargetFlowHook\",
  \"PostTargetFlowHook\"]`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/flowhooks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-flowhooks-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/flowhooks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the name of the shared flow attached to the specified flow hook. If
  there's no shared flow attached to the flow hook, the API does not return
  an error; it simply does not return a name in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-flowhooks-attachSharedFlowToFlowHook$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/flowhooks/attachSharedFlowToFlowHook
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :flowHookPoint string,
   :continueOnError boolean,
   :sharedFlow string}
  
  Attaches a shared flow to a flow hook."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn environments-flowhooks-detachSharedFlowFromFlowHook$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/flowhooks/detachSharedFlowFromFlowHook
  
  Required parameters: name
  
  Optional parameters: none
  
  Detaches a shared flow from a flow hook."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-references-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/references/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all References in an environment as a JSON array."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/references"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-references-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/references/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Reference resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-references-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/references/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :description string,
   :resourceType string,
   :refers string}
  
  Updates an existing Reference. Note that this operation has PUT
  semantics; it will replace the entirety of the existing Reference with
  the resource in the request body."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn environments-references-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/references/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :description string,
   :resourceType string,
   :refers string}
  
  Creates a Reference in the specified environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/references"
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

(defn environments-references-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/references/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Reference from an environment. Returns the deleted
  Reference resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-sharedflows-revisions-deployments$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/sharedflows/revisions/deployments
  
  Required parameters: name
  
  Optional parameters: none
  
  Undeploys a shared flow revision from an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-sharedflows-revisions-getDeployments$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/sharedflows/revisions/getDeployments
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the deployment of a shared flow revision and actual state reported by
  runtime pods."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-sharedflows-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/sharedflows/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of a shared flow in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/deployments/list
  
  Required parameters: parent
  
  Optional parameters: sharedFlows
  
  Lists all deployments of API proxies or shared flows in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-analytics-admin-getSchemav2$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/analytics/admin/getSchemav2
  
  Required parameters: name
  
  Optional parameters: type
  
  Get a list of metrics and dimensions which can be used for creating
  analytics queries and reports.
  Each schema element contains the name of the field with its associated type
  and if it is either custom field or standard field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-optimizedStats-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/optimizedStats/get
  
  Required parameters: name
  
  Optional parameters: tzo, aggTable, limit, offset, timeRange, accuracy, realtime, sonar, topk, sortby, tsAscending, filter, timeUnit, sort, select
  
  This api is similar to GetStats
  except that the response is less verbose.
  In the current scheme, a query parameter _optimized instructs
  Edge Analytics to change the response but since this behavior
  is not possible with protocol buffer and since this parameter is
  predominantly used by Edge UI, we are introducing a separate api."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keystores-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/create
  
  Required parameters: parent
  
  Optional parameters: name
  
  Body: 
  
  {:name string, :aliases [string]}
  
  Creates a keystore or truststore:
   * Keystore: Contains certificates and their associated keys.
   * Truststore: Contains trusted certificates used to validate a
   server's certificate. These certificates are typically self-signed
   certificates or certificates that are not signed by a trusted CA."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keystores"
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

(defn environments-keystores-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a keystore or truststore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keystores-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all keystores and truststores."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keystores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keystores-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a keystore or truststore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keystores-aliases-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all aliases."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/aliases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keystores-aliases-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/create
  
  Required parameters: parent
  
  Optional parameters: alias, format, _password, ignoreExpiryValidation, ignoreNewlineValidation
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Creates an alias from a key, certificate pair.
  The structure of the request is controlled by the `format` query parameter:
   * `keycertfile` - Separate PEM-encoded key and certificate files are
   uploaded. The request must have `Content-Type: multipart/form-data` and
   include fields `keyFile` and `certFile`. If uploading to a truststore,
   omit `keyFile`.
  * `pkcs12` - A PKCS12 file is uploaded. The request must have
  `Content-Type: multipart/form-data` with the file provided in the only
  field.
  * `selfsignedcert` - A new private key and certificate are generated. The
  request must have `Content-Type: application/json` and a body of
  CertificateGenerationSpec."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/aliases"
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

(defn environments-keystores-aliases-getCertificate$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/getCertificate
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the certificate from an alias in PEM-encoded form."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/certificate"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keystores-aliases-csr$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/csr
  
  Required parameters: name
  
  Optional parameters: none
  
  Generates a PKCS #10 Certificate Signing Request for the private key in
  an alias."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/csr"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keystores-aliases-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an alias."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keystores-aliases-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/update
  
  Required parameters: name
  
  Optional parameters: ignoreExpiryValidation, ignoreNewlineValidation
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Updates the certificate in an alias."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn environments-keystores-aliases-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an alias."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-targetservers-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/targetservers/create
  
  Required parameters: parent
  
  Optional parameters: name
  
  Body: 
  
  {:description string,
   :isEnabled boolean,
   :sSLInfo {:protocols [string],
             :keyStore string,
             :keyAlias string,
             :trustStore string,
             :clientAuthEnabled boolean,
             :commonName GoogleCloudApigeeV1TlsInfoCommonName,
             :ciphers [string],
             :enabled boolean,
             :ignoreValidationErrors boolean},
   :name string,
   :port integer,
   :host string}
  
  Creates a TargetServer in the specified environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/targetservers"
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

(defn environments-targetservers-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/targetservers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a TargetServer from an environment. Returns the deleted
  TargetServer resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-targetservers-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/targetservers/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all TargetServers in an environment as a JSON array."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/targetservers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-targetservers-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/targetservers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a TargetServer resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-targetservers-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/targetservers/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :isEnabled boolean,
   :sSLInfo {:protocols [string],
             :keyStore string,
             :keyAlias string,
             :trustStore string,
             :clientAuthEnabled boolean,
             :commonName GoogleCloudApigeeV1TlsInfoCommonName,
             :ciphers [string],
             :enabled boolean,
             :ignoreValidationErrors boolean},
   :name string,
   :port integer,
   :host string}
  
  Updates an existing TargetServer. Note that this operation has PUT
  semantics; it will replace the entirety of the existing TargetServer with
  the resource in the request body."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn environments-apis-revisions-getDeployments$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/getDeployments
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the deployment of an API proxy revision and actual state reported by
  runtime pods."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-deployments$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/deployments
  
  Required parameters: name
  
  Optional parameters: none
  
  Undeploys an API proxy revision from an environment.
  
  Because multiple revisions of the same API proxy can be deployed in
  the same environment if the base paths are different, you must specify the
  revision number of the API proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-debugsessions-deleteData$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/deleteData
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the data from a debug session. This does not cancel the debug
  session or prevent further data from being collected if the session is
  still active in runtime pods."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/data"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-debugsessions-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists debug sessions that are currently active in the given API Proxy
  revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/debugsessions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-debugsessions-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/create
  
  Required parameters: parent
  
  Optional parameters: timeout
  
  Body: 
  
  {:timeout string,
   :name string,
   :validity integer,
   :tracesize integer,
   :filter string,
   :count integer}
  
  Creates a debug session for a deployed API Proxy revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/debugsessions"
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

(defn environments-apis-revisions-debugsessions-data-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/data/list
  
  Required parameters: parent
  
  Optional parameters: limit
  
  Lists the transaction IDs from a debug session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/data"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-debugsessions-data-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/data/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the debug data from a transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of an API proxy in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-queries-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/queries/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reportDefinitionId string,
   :limit integer,
   :timeRange any,
   :name string,
   :outputFormat string,
   :dimensions [string],
   :filter string,
   :csvDelimiter string,
   :groupByTimeUnit string,
   :metrics [{:operator string,
              :value string,
              :function string,
              :name string,
              :alias string}]}
  
  Submit a query to be processed in the background.
  If the submission of the query succeeds, the API returns a 201 status and
  an ID that refer to the query. In addition to the HTTP status 201, the
  `state` of \"enqueued\" means that the request succeeded."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/queries"
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

(defn environments-queries-getResult$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/queries/getResult
  
  Required parameters: name
  
  Optional parameters: none
  
  After the query is completed, use this API to retrieve the results.
  If the request succeeds, and there is a non-zero result set, the result is
  downloaded to the client as a zipped JSON file.
  The name of the downloaded file will be:
    OfflineQueryResult-<query-id>.zip
  
  Example: `OfflineQueryResult-9cfc0d85-0f30-46d6-ae6f-318d0cb961bd.zip`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-queries-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/queries/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get query status
  If the query is still in progress, the `state` is set to \"running\"
  After the query has completed successfully, `state` is set to \"completed\""
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-queries-getResultView$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/queries/getResultView
  
  Required parameters: name
  
  Optional parameters: none
  
  "
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-queries-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/queries/list
  
  Required parameters: parent
  
  Optional parameters: status, dataset, submittedBy, from, inclQueriesWithoutReport, to
  
  Return a list of Asynchronous Queries"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/queries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-stats-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/stats/get
  
  Required parameters: name
  
  Optional parameters: tzo, aggTable, limit, offset, timeRange, accuracy, realtime, sonar, topk, sortby, tsAscending, filter, timeUnit, sort, select
  
  Retrieve metrics grouped by dimensions.
  The types of metrics you can retrieve include traffic, message counts,
  API call latency, response size, and cache hits and counts.
  Dimensions let you view metrics in meaningful groups.
  The stats api does accept dimensions as path params. The dimensions are
  optional in which case the metrics are computed on the entire data
  for the given timerange."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumers-status$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumers/status
  
  Required parameters: parent
  
  Optional parameters: none
  
  Checks the status of this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/consumers/status"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumers-access$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumers/access
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:data [{:action string, :resourcePath string}]}
  
  Checks whether a developer has access to a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/consumers/access"
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

(defn consumers-apps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumers/apps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumers-apps-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumers/apps/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all apps."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/consumers/apps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumers-apps-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumers/apps/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumers-apps-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumers/apps/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :callbackUrl string,
   :apiProducts [{:status string, :apiproduct string}],
   :credentials [{:issuedAt string,
                  :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                  :status string,
                  :scopes [string],
                  :expiresAt string,
                  :consumerSecret string,
                  :consumerKey string,
                  :attributes [GoogleCloudApigeeV1Attribute]}],
   :displayName string,
   :name string,
   :ownerType string,
   :created string,
   :modified string,
   :status string,
   :apiProductsFromCredentials [{:issuedAt string,
                                 :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                                 :status string,
                                 :scopes [string],
                                 :expiresAt string,
                                 :consumerSecret string,
                                 :consumerKey string,
                                 :attributes [GoogleCloudApigeeV1Attribute]}],
   :id string,
   :owner string}
  
  Updates an app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn consumers-apps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumers/apps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:attributes [{:value string, :name string}],
   :callbackUrl string,
   :description string,
   :apiProducts [string],
   :owner string,
   :name string,
   :ownerType string}
  
  Creates an app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/consumers/apps"
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

(defn consumers-apps-keys-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumers/apps/keys/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Creates an API key for an app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keys"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumers-apps-keys-approveRevokeConsumerAppKey$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/consumers/apps/keys/approveRevokeConsumerAppKey
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:action string}
  
  Approves or revokes an API key for an app.
  Not a recognized rest pattern"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn developers-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/get
  
  Required parameters: name
  
  Optional parameters: action
  
  Returns the developer details, including the
  developer's name, email address, apps, and other information.
  
  **Note**: The response includes only the first 100 developer apps."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:apps [string],
   :email string,
   :accessType string,
   :appFamily string,
   :firstName string,
   :createdAt string,
   :organizationName string,
   :developerId string,
   :status string,
   :lastModifiedAt string,
   :lastName string,
   :companies [string],
   :attributes [{:value string, :name string}],
   :userName string}
  
  Updates a developer.
  
  This API replaces the existing developer details with those specified
  in the request. Include or exclude any existing details that
  you want to retain or delete, respectively.
  
  The custom attribute limit is 18.
  
  **Note**: OAuth access tokens and Key Management Service (KMS) entities
  (apps, developers, and API products) are cached for 180 seconds
  (current default). Any custom attributes associated with these entities
  are cached for at least 180 seconds after the entity is accessed at
  runtime. Therefore, an `ExpiresIn` element on the OAuthV2 policy
  won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn developers-setDeveloperStatus$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/setDeveloperStatus
  
  Required parameters: name
  
  Optional parameters: action
  
  Sets the status of a developer. Valid values are `active` or `inactive`.
  
  A developer is `active` by default. If you set a developer's status to
  `inactive`, the API keys assigned to the developer apps are no longer valid
  even though the API keys are set to `approved`. Inactive developers
  can still sign in to the developer portal and create apps; however, any
  new API keys generated during app creation won't work.
  
  If successful, the API call returns the
  following HTTP status code: `204 No Content`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a developer. All apps and API keys associated
  with the developer are also removed.
  
  **Warning**: This API will permanently delete the developer
  and related artifacts.
  
  To avoid permanently deleting developers and their artifacts,
  set the developer status to `inactive` using
  the SetDeveloperStatus API.
  
  **Note**: The delete operation is asynchronous. The developer app is
  deleted immediately,
  but its associated resources, such as apps and API keys, may take anywhere
  from a few seconds to a few minutes to be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/list
  
  Required parameters: parent
  
  Optional parameters: startKey, expand, ids, includeCompany, count
  
  Lists all developers in an organization by email address.
  
  By default,
  the response does not include company developers. Set the `includeCompany`
  query parameter to `true` to include company developers.
  
  **Note**: A maximum of 1000 developers are returned in the response. You
  paginate the list of developers returned using the `startKey` and `count`
  query parameters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/developers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:apps [string],
   :email string,
   :accessType string,
   :appFamily string,
   :firstName string,
   :createdAt string,
   :organizationName string,
   :developerId string,
   :status string,
   :lastModifiedAt string,
   :lastName string,
   :companies [string],
   :attributes [{:value string, :name string}],
   :userName string}
  
  Creates a developer. Once created,
  the developer can register an app and obtain an API key.
  
  At creation time, a developer is set as `active`. To change the developer
  status, use the SetDeveloperStatus API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/developers"
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

(defn developers-attributes$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:attribute [{:value string, :name string}]}
  
  Updates developer attributes.
  
  This API replaces the
  existing attributes with those specified in the request.
  Add new attributes, and include or exclude any existing
  attributes that you want to retain or
  remove, respectively.
  
  The custom attribute limit is 18.
  
  **Note**: OAuth access tokens and Key Management Service (KMS) entities
  (apps, developers, and API products) are cached for 180 seconds
  (default). Any custom attributes associated with these entities
  are cached for at least 180 seconds after the entity is accessed at
  runtime. Therefore, an `ExpiresIn` element on the OAuthV2 policy
  won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attributes"
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

(defn developers-apps-attributes$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:attribute [{:value string, :name string}]}
  
  Updates attributes for a developer app. This API replaces the
  current attributes with those specified in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/attributes"
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

(defn developers-apps-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/get
  
  Required parameters: name
  
  Optional parameters: entity, query
  
  Returns the details for a developer app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :callbackUrl string,
   :apiProducts [string],
   :credentials [{:issuedAt string,
                  :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                  :status string,
                  :scopes [string],
                  :expiresAt string,
                  :consumerSecret string,
                  :consumerKey string,
                  :attributes [GoogleCloudApigeeV1Attribute]}],
   :name string,
   :appFamily string,
   :keyExpiresIn string,
   :createdAt string,
   :developerId string,
   :status string,
   :appId string,
   :lastModifiedAt string,
   :attributes [{:value string, :name string}]}
  
  Updates the details for a developer app. In addition, you can
  add an API product to a developer app and automatically generate
  an API key for the app to use when calling APIs in the API product.
  
  If you want to use an existing API key for the API product,
  add the API product to the API key using the
  UpdateDeveloperAppKey
  API.
  
  Using this API, you cannot update the following:
  
  * App name as it is the primary key used to identify the app and cannot
    be changed.
  * Scopes associated with the app. Instead, use the
    ReplaceDeveloperAppKey API.
  
  This API replaces the
  existing attributes with those specified in the request.
  Include or exclude any existing attributes that you want to retain or
  delete, respectively."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn developers-apps-generateKeyPairOrUpdateDeveloperAppStatus$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/generateKeyPairOrUpdateDeveloperAppStatus
  
  Required parameters: name
  
  Optional parameters: action
  
  Body: 
  
  {:scopes [string],
   :callbackUrl string,
   :apiProducts [string],
   :credentials [{:issuedAt string,
                  :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                  :status string,
                  :scopes [string],
                  :expiresAt string,
                  :consumerSecret string,
                  :consumerKey string,
                  :attributes [GoogleCloudApigeeV1Attribute]}],
   :name string,
   :appFamily string,
   :keyExpiresIn string,
   :createdAt string,
   :developerId string,
   :status string,
   :appId string,
   :lastModifiedAt string,
   :attributes [{:value string, :name string}]}
  
  Manages access to a developer app by enabling you to:
  
  * Approve or revoke a developer app
  * Generate a new consumer key and secret for a developer app
  
  To approve or revoke a developer app, set the `action` query parameter to
  `approved` or `revoked`, respectively, and the
  `Content-Type` header to `application/octet-stream`. If a developer app is
  revoked, none of its API keys are valid for API calls even though
  the keys are still `approved`. If successful, the API call returns the
  following HTTP status code: `204 No Content`
  
  To generate a new consumer key and secret for a developer
  app, pass the new key/secret details. Rather than
  replace an existing key, this API generates a new
  key. In this case, multiple key
  pairs may be associated with a single developer app. Each key pair has an
  independent status (`approved` or `revoked`) and expiration time.
  Any approved, non-expired key can be used in an API call.
  
  For example, if you're using API key rotation, you can generate new
  keys with expiration times that overlap keys that are going to expire.
  You might also generate a new consumer key/secret if the security of the
  original key/secret is compromised.
  
  The `keyExpiresIn` property defines the
  expiration time for the API key in milliseconds. If you don't set
  this property or set it to `-1`, the API key never expires.
  
  **Notes**:
  
  * When generating a new key/secret, this API replaces the
  existing attributes, notes, and callback URLs with those specified in the
  request. Include or exclude any existing information that you want to
  retain or delete, respectively.
  * To migrate existing consumer keys and secrets to hybrid from another
  system, see the
  CreateDeveloperAppKey API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn developers-apps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a developer app.
  
  **Note**: The delete operation is asynchronous. The developer app is
  deleted immediately,
  but its associated resources, such as app
  keys or access tokens, may take anywhere from a few seconds to a
  few minutes to be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/list
  
  Required parameters: parent
  
  Optional parameters: shallowExpand, startKey, count, expand
  
  Lists all apps created by a developer in an Apigee organization.
  Optionally, you can request an expanded view of the developer apps.
  
  A maximum of 100 developer apps are returned per API call. You can paginate
  the list of deveoper apps returned using the `startKey` and `count` query
  parameters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :callbackUrl string,
   :apiProducts [string],
   :credentials [{:issuedAt string,
                  :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                  :status string,
                  :scopes [string],
                  :expiresAt string,
                  :consumerSecret string,
                  :consumerKey string,
                  :attributes [GoogleCloudApigeeV1Attribute]}],
   :name string,
   :appFamily string,
   :keyExpiresIn string,
   :createdAt string,
   :developerId string,
   :status string,
   :appId string,
   :lastModifiedAt string,
   :attributes [{:value string, :name string}]}
  
  Creates an app associated with a developer. This API associates the
  developer app with the specified API
  product and auto-generates an API key for the app to use in calls to API
  proxies inside that API product.
  
  The `name` is the unique ID of the app
  that you can use in API calls. The `DisplayName` (set as an
  attribute) appears in the UI. If you don't set the
  `DisplayName` attribute, the `name` appears in the UI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apps"
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

(defn developers-apps-keys-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns details for a consumer key for a developer app, including the key
  and secret value, associated API products, and other information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-keys-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :expiresAt string,
   :attributes [{:value string, :name string}],
   :consumerKey string,
   :consumerSecret string,
   :apiProducts [any],
   :issuedAt string,
   :status string}
  
  Creates a custom consumer key and secret for a developer app. This is
  particularly useful if you want to migrate existing consumer keys and
  secrets to Apigee hybrid from another system.
  
  Consumer keys and secrets can contain letters, numbers, underscores, and
  hyphens. No other special characters are allowed.
  
  **Note**: To avoid service disruptions, a consumer key and secret
  should not exceed 2 KBs each.
  
  After creating the consumer key and secret, associate the key with
  an API product using the
  UpdateDeveloperAppKey API.
  
  If a consumer key and secret already exist, you can keep them or
  delete them using the
  DeleteDeveloperAppKey API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keys"
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

(defn developers-apps-keys-replaceDeveloperAppKey$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/replaceDeveloperAppKey
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :expiresAt string,
   :attributes [{:value string, :name string}],
   :consumerKey string,
   :consumerSecret string,
   :apiProducts [any],
   :issuedAt string,
   :status string}
  
  Updates the scope of an app.
  
  This API replaces the
  existing scopes with those specified in the request.
  Include or exclude any existing scopes that you want to retain or
  delete, respectively. The specified scopes must already
  be defined for the API products associated with the app.
  
  This API sets the `scopes` element
  under the `apiProducts` element in the attributes of the app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn developers-apps-keys-updateDeveloperAppKey$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/updateDeveloperAppKey
  
  Required parameters: name
  
  Optional parameters: action
  
  Body: 
  
  {:scopes [string],
   :expiresAt string,
   :attributes [{:value string, :name string}],
   :consumerKey string,
   :consumerSecret string,
   :apiProducts [any],
   :issuedAt string,
   :status string}
  
  Adds an API product to a developer app key, enabling the app that holds
  the key to access the API resources bundled in the API product.
  
  In addition, you can add
  attributes to a developer app key. This API replaces the
  existing attributes with those specified in the request.
  Include or exclude any existing attributes that you want to retain or
  delete, respectively.
  
  You can use the same key to access all API products
  associated with the app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn developers-apps-keys-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an app's consumer key and removes all API products
  associated with the app. After the consumer key is deleted,
  it cannot be used to access any APIs.
  
  **Note**: After you delete a consumer key, you may want to:
  1. Create a new consumer key and secret for the developer app using the
  CreateDeveloperAppKey API, and
  subsequently add an API product to the key using the
  UpdateDeveloperAppKey API.
  2. Delete the developer app, if it is no longer required."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-keys-apiproducts-updateDeveloperAppKeyApiProduct$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/apiproducts/updateDeveloperAppKeyApiProduct
  
  Required parameters: name
  
  Optional parameters: action
  
  Approve or revoke an app's consumer key. After a consumer key is approved,
  the app can use it to access APIs.
  
  A consumer key that is revoked or pending cannot be used to access an API.
  Any access tokens associated with a revoked consumer key will remain
  active. However, Apigee hybrid checks the status of the consumer key and
  if set to `revoked` will not allow access to the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-keys-apiproducts-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/apiproducts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes an API product from an app's consumer key. After the API product is
  removed, the app cannot access the API resources defined in
  that API product.
  
  **Note**: The consumer key is not removed, only its association with the
  API product."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-keys-create-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/create/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :expiresAt string,
   :attributes [{:value string, :name string}],
   :consumerKey string,
   :consumerSecret string,
   :apiProducts [any],
   :issuedAt string,
   :status string}
  
  Creates a custom consumer key and secret for a developer app. This is
  particularly useful if you want to migrate existing consumer keys and
  secrets to Apigee hybrid from another system.
  
  Consumer keys and secrets can contain letters, numbers, underscores, and
  hyphens. No other special characters are allowed.
  
  **Note**: To avoid service disruptions, a consumer key and secret
  should not exceed 2 KBs each.
  
  After creating the consumer key and secret, associate the key with
  an API product using the
  UpdateDeveloperAppKey API.
  
  If a consumer key and secret already exist, you can keep them or
  delete them using the
  DeleteDeveloperAppKey API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keys/create"
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

(defn developers-apps-attributes-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a developer app attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-attributes-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a developer app attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-attributes-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Returns a list of all developer app attributes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attributes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-attributes-updateDeveloperAppAttribute$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes/updateDeveloperAppAttribute
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:value string, :name string}
  
  Updates a developer app attribute.
  
  **Note**: OAuth access tokens and Key Management Service (KMS) entities
  (apps, developers, and API products) are cached for 180 seconds
  (current default). Any custom attributes associated with these entities
  are cached for at least 180 seconds after the entity is accessed at
  runtime. Therefore, an `ExpiresIn` element on the OAuthV2 policy
  won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn developers-attributes-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the value of the specified developer attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-attributes-updateDeveloperAttribute$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes/updateDeveloperAttribute
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:value string, :name string}
  
  Updates a developer attribute.
  
  **Note**: OAuth access tokens and Key Management Service (KMS) entities
  (apps, developers, and API products) are cached for 180 seconds
  (default). Any custom attributes associated with these entities
  are cached for at least 180 seconds after the entity is accessed at
  runtime. Therefore, an `ExpiresIn` element on the OAuthV2 policy
  won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn developers-attributes-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Returns a list of all developer attributes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attributes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-attributes-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a developer attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the zones for an Apigee organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/zones"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :samlConfig {},
   :hostWhitelistedDomains [string],
   :zoneId string,
   :name string,
   :portals [string],
   :manualApproval boolean,
   :copyright string,
   :created string,
   :organization string,
   :accountCreationEmail string,
   :modified string,
   :allowedDomains {:whitelistedDomains [string]},
   :tokenPolicy {:refreshTokenValidity string,
                 :accessTokenValidity string,
                 :keys {}},
   :customEmailTemplates {:accountNotify GoogleCloudApigeeV1ZoneCustomEmailTemplatesCustomEmailTemplate,
                          :resetPassword GoogleCloudApigeeV1ZoneCustomEmailTemplatesCustomEmailTemplate,
                          :accountVerify GoogleCloudApigeeV1ZoneCustomEmailTemplatesCustomEmailTemplate,
                          :activate GoogleCloudApigeeV1ZoneCustomEmailTemplatesCustomEmailTemplate},
   :active boolean,
   :id string,
   :productLogo string,
   :customRegistrationFields [{:active boolean,
                               :fieldName string,
                               :fieldType string,
                               :required boolean,
                               :sortOrder integer}],
   :companyName string,
   :squareLogo string,
   :smtpConfig {:serverUsername string,
                :sender string,
                :serverPassword string,
                :serverHost string,
                :secureAuthType string,
                :serverPort string},
   :links {:selfService GoogleCloudApigeeV1ZoneLinksSelfService,
           :homeRedirect string,
           :logout GoogleCloudApigeeV1ZoneLinksLogout},
   :footerLinks {}}
  
  Updates a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn zones-certificate$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/certificate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:certificate string, :requestType string}
  
  Validates a certificate in a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/zones/certificate"
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

(defn zones-testemail$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/testemail
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:body string, :subject string}
  
  ** Note**: This feature is not available to Apigee hybrid at this time.
  
  Sends a test email to verify the SMTP settings for an identity provider.
  Sends the email to the requester's email using the token."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/testemail"
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

(defn zones-identity_providers-updateConfig$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/identity_providers/updateConfig
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:entityId string,
   :loginUrl string,
   :logoutUrl string,
   :certificate {:validTo string,
                 :valid boolean,
                 :validFrom string,
                 :subject string,
                 :certificate string,
                 :message string,
                 :issuer string,
                 :fingerprint GoogleCloudApigeeV1SamlCertificateFingerprint},
   :spMetadataUrl string}
  
  Updates the configuration for an identity provider."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/config"
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

(defn zones-identity_providers-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/identity_providers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an identity provider in a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-identity_providers-patch$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/identity_providers/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:type string,
   :id string,
   :modified string,
   :created string,
   :active boolean,
   :config {:entityId string,
            :loginUrl string,
            :logoutUrl string,
            :certificate GoogleCloudApigeeV1SamlCertificate,
            :spMetadataUrl string},
   :name string}
  
  Updates an identity provider in a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn zones-identity_providers-updateCertificate$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/identity_providers/updateCertificate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:validTo string,
   :valid boolean,
   :validFrom string,
   :subject string,
   :certificate string,
   :message string,
   :issuer string,
   :fingerprint {:sha256 string, :sha1 string}}
  
  Updates the certificate for an identity provider."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/certificate"
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

(defn zones-identity_providers-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/identity_providers/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the identity providers in a zone.
  Underscore in URL"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/identity_providers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-identity_providers-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/zones/identity_providers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:type string,
   :id string,
   :modified string,
   :created string,
   :active boolean,
   :config {:entityId string,
            :loginUrl string,
            :logoutUrl string,
            :certificate GoogleCloudApigeeV1SamlCertificate,
            :spMetadataUrl string},
   :name string}
  
  Creates an identity provider in a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/identity_providers"
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

(defn operations-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-cancel$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn operations-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/list
  
  Required parameters: parent
  
  Optional parameters: includeRevisions, includeMetaData
  
  Lists the names of all API proxies in an organization. The names returned
  correspond to the names defined in the configuration files for each API
  proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apis"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an API proxy including a list of existing revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/create
  
  Required parameters: parent
  
  Optional parameters: validate, name, action
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Creates an API proxy.
  The API proxy created will not be accessible at runtime until it is
  deployed to an environment.
  
  Create a new API proxy by setting the `name` query parameter to the
  name of the API proxy.
  
  Import an API proxy configuration bundle stored in zip format
  on your local machine to your organization by doing the following:
  
  * Set the `name` query parameter to the name of the API proxy.
  * Set the `action` query parameter to `import`.
  * Set the `Content-Type` header to `multipart/form-data`.
  * Pass as a file the name of API proxy
    configuration bundle stored in zip format on your local machine using
    the `file` form field.
  
  **Note**: To validate the API proxy configuration bundle only
    without importing it, set the `action` query
    parameter to `validate`.
  
  When importing an API proxy configuration bundle, if the API proxy
  does not exist, it will be created.
  If the API proxy exists, then a new revision is created. Invalid API
  proxy configurations are rejected, and a list of validation errors is
  returned to the client."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apis"
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

(defn apis-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an API proxy and all associated endpoints, policies, resources, and
  revisions. The API proxy must be undeployed before you can delete it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-keyvaluemaps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/keyvaluemaps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a key value map in an api proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-keyvaluemaps-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/keyvaluemaps/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  List key value maps in an api proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keyvaluemaps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-keyvaluemaps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/keyvaluemaps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encrypted boolean, :name string}
  
  Creates a key value map in an api proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keyvaluemaps"
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

(defn apis-revisions-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/revisions/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all revisions for an API proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/revisions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-revisions-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/revisions/get
  
  Required parameters: name
  
  Optional parameters: format
  
  Gets an API proxy revision.
  
  To download the API proxy configuration bundle for the specified revision
  as a zip file, do the following:
  
   * Set the `format` query parameter to `bundle`.
   * Set the `Accept` header to `application/zip`.
  
  If you are using curl, specify `-o filename.zip` to save the output to a
  file; otherwise, it displays to `stdout`. Then, develop the API proxy
  configuration locally and upload the updated API proxy configuration
  revision, as described in
  [updateApiProxyRevision](updateApiProxyRevision)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-revisions-updateApiProxyRevision$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/revisions/updateApiProxyRevision
  
  Required parameters: name
  
  Optional parameters: validate
  
  Body: 
  
  {:extensions [{}], :data string, :contentType string}
  
  Updates an existing API proxy revision by uploading the API proxy
  configuration bundle as a zip file from your local machine.
  
  You can update only API proxy revisions
  that have never been deployed. After deployment, an API proxy revision
  becomes immutable, even if it is undeployed.
  
  Set the `Content-Type` header to either
  `multipart/form-data` or `application/octet-stream`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn apis-revisions-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/revisions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an API proxy revision and all policies, resources, endpoints,
  and revisions associated with it. The API proxy revision must be undeployed
  before you can delete it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-revisions-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/revisions/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of an API proxy revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of an API proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn companies-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing company."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn companies-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  List details for a company."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn companies-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/list
  
  Required parameters: parent
  
  Optional parameters: count, expand, includeDevelopers, startKey
  
  List all companies in an organization, and optionally returns an
  expanded list of companies, displaying a full profile for each company in
  the organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/companies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn companies-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/update
  
  Required parameters: name
  
  Optional parameters: action
  
  Body: 
  
  {:status string,
   :lastModifiedAt string,
   :name string,
   :attributes [{:value string, :name string}],
   :createdAt string,
   :apps [string],
   :organization string,
   :displayName string}
  
  Updates an existing company.
  Send the complete company record as a payload with any changes you want to
  make. Note that to change the status of the Company you use Set the Status
  of a Company. The attributes in the sample payload below apply to company
  configuration in monetization. For non-monetized companies, you need send
  only displayName."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn companies-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:status string,
   :lastModifiedAt string,
   :name string,
   :attributes [{:value string, :name string}],
   :createdAt string,
   :apps [string],
   :organization string,
   :displayName string}
  
  Creates an app for a company. Note that you must first create a profile
  for the company in your organization before you can register apps that
  are associated with the company."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/companies"
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

(defn companies-apps-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/apps/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the profile of a specific company app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn companies-apps-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/apps/list
  
  Required parameters: parent
  
  Optional parameters: startKey, count, expand
  
  List company apps in an organization. You can optionally expand the
  response to include the profile for each app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn companies-apps-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/apps/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :callbackUrl string,
   :apiProducts [string],
   :credentials [{:issuedAt string,
                  :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                  :status string,
                  :scopes [string],
                  :expiresAt string,
                  :consumerSecret string,
                  :consumerKey string,
                  :attributes [GoogleCloudApigeeV1Attribute]}],
   :name string,
   :appFamily string,
   :keyExpiresIn string,
   :createdAt string,
   :status string,
   :appId string,
   :lastModifiedAt string,
   :companyName string,
   :attributes [{:value string, :name string}]}
  
  Updates an existing company app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn companies-apps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/apps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :callbackUrl string,
   :apiProducts [string],
   :credentials [{:issuedAt string,
                  :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                  :status string,
                  :scopes [string],
                  :expiresAt string,
                  :consumerSecret string,
                  :consumerKey string,
                  :attributes [GoogleCloudApigeeV1Attribute]}],
   :name string,
   :appFamily string,
   :keyExpiresIn string,
   :createdAt string,
   :status string,
   :appId string,
   :lastModifiedAt string,
   :companyName string,
   :attributes [{:value string, :name string}]}
  
  Creates an app for a company."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apps"
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

(defn companies-apps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/apps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a company app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn companies-apps-keys-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/apps/keys/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a key for a company app and removes all API products associated
  with the app. The key can no longer be used to access any APIs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn companies-apps-keys-updateCompanyAppKey$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/apps/keys/updateCompanyAppKey
  
  Required parameters: name
  
  Optional parameters: action
  
  Body: 
  
  {:status string,
   :scopes [string],
   :attributes [{:value string, :name string}],
   :consumerKey string,
   :consumerSecret string,
   :expiresAt string,
   :apiProducts [any],
   :issuedAt string}
  
  Updates an existing company app key to add additional API products or
  attributes. Note that only a single API product can be resolved per app
  key at runtime. API products are resolved by name, in alphabetical order.
  The first API product found in the list will be returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn companies-apps-keys-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/companies/apps/keys/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about the consumer key issued to a specific company app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing custom report definition"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve a custom report definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/list
  
  Required parameters: parent
  
  Optional parameters: expand
  
  Return a list of Custom Reports"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/reports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:properties [{:value [GoogleCloudApigeeV1Attribute],
                 :property string}],
   :toTime string,
   :tags [string],
   :lastViewedAt string,
   :limit string,
   :chartType string,
   :offset string,
   :displayName string,
   :sortByCols [string],
   :fromTime string,
   :name string,
   :comments [string],
   :createdAt string,
   :topk string,
   :organization string,
   :dimensions [string],
   :filter string,
   :lastModifiedAt string,
   :sortOrder string,
   :timeUnit string,
   :environment string,
   :metrics [{:function string, :name string}]}
  
  Update an existing custom report definition"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
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

(defn reports-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:properties [{:value [GoogleCloudApigeeV1Attribute],
                 :property string}],
   :toTime string,
   :tags [string],
   :lastViewedAt string,
   :limit string,
   :chartType string,
   :offset string,
   :displayName string,
   :sortByCols [string],
   :fromTime string,
   :name string,
   :comments [string],
   :createdAt string,
   :topk string,
   :organization string,
   :dimensions [string],
   :filter string,
   :lastModifiedAt string,
   :sortOrder string,
   :timeUnit string,
   :environment string,
   :metrics [{:function string, :name string}]}
  
  Creates a Custom Report for an Organization. A Custom Report
  provides Apigee Customers to create custom dashboards in addition
  to the standard dashboards which are provided. The Custom Report in its
  simplest form contains specifications about metrics, dimensions and
  filters. It is important to note that the custom report by itself does not
  provide an executable entity. The Edge UI converts the custom report
  definition into an analytics query and displays the result in a chart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/reports"
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
