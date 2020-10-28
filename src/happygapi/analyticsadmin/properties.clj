(ns happygapi.analyticsadmin.properties
  "Google Analytics Admin API: properties.
  
  See: http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:timeZone string,
   :deleted boolean,
   :parent string,
   :industryCategory string,
   :displayName string,
   :name string,
   :createTime string,
   :updateTime string,
   :currencyCode string}
  
  Updates a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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

(defn get$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single \"GA4\" Property. Throws \"Target not found\" if no such property found, if property is not of the type \"GA4\", or if caller does not have permissions to access it."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:timeZone string,
   :deleted boolean,
   :parent string,
   :industryCategory string,
   :displayName string,
   :name string,
   :createTime string,
   :updateTime string,
   :currencyCode string}
  
  Creates an \"GA4\" property with the specified location and attributes."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/properties"
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

(defn delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Marks target Property as soft-deleted (ie: \"trashed\") and returns it. This API does not have a method to restore soft-deleted properties. However, they can be restored using the Trash Can UI. If the properties are not restored before the expiration time, the Property and all child resources (eg: GoogleAdsLinks, Streams, UserLinks) will be permanently purged. https://support.google.com/analytics/answer/6154772 Returns an error if the target is not found, or is not an GA4 Property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/list
  
  Required parameters: none
  
  Optional parameters: filter, showDeleted, pageSize, pageToken
  
  Returns child Properties under the specified parent Account. Only \"GA4\" properties will be returned. Properties will be excluded if the caller does not have access. Soft-deleted (ie: \"trashed\") properties are excluded by default. Returns an empty list if no relevant properties are found."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/properties"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn iosAppDataStreams-delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/iosAppDataStreams/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an iOS app stream on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn iosAppDataStreams-create$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/iosAppDataStreams/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:bundleId string,
   :displayName string,
   :createTime string,
   :firebaseAppId string,
   :name string,
   :updateTime string}
  
  Creates an iOS app data stream with the specified location and attributes."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/iosAppDataStreams"
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

(defn iosAppDataStreams-patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/iosAppDataStreams/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:bundleId string,
   :displayName string,
   :createTime string,
   :firebaseAppId string,
   :name string,
   :updateTime string}
  
  Updates an iOS app stream on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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

(defn iosAppDataStreams-list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/iosAppDataStreams/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns child iOS app data streams under the specified parent property. iOS app data streams will be excluded if the caller does not have access. Returns an empty list if no relevant iOS app data streams are found."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/iosAppDataStreams"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn iosAppDataStreams-get$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/iosAppDataStreams/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single IosAppDataStream Throws \"Target not found\" if no such iOS app data stream found, or if the caller does not have permissions to access it."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn androidAppDataStreams-patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/androidAppDataStreams/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :firebaseAppId string,
   :packageName string,
   :displayName string}
  
  Updates an android app stream on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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

(defn androidAppDataStreams-delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/androidAppDataStreams/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an android app stream on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn androidAppDataStreams-list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/androidAppDataStreams/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns child android app streams under the specified parent property. Android app streams will be excluded if the caller does not have access. Returns an empty list if no relevant android app streams are found."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/androidAppDataStreams"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn androidAppDataStreams-create$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/androidAppDataStreams/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :firebaseAppId string,
   :packageName string,
   :displayName string}
  
  Creates an android app stream with the specified location and attributes."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/androidAppDataStreams"
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

(defn androidAppDataStreams-get$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/androidAppDataStreams/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single AndroidAppDataStream Throws \"Target not found\" if no such android app data stream found, or if the caller does not have permissions to access it."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn googleAdsLinks-delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/googleAdsLinks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a GoogleAdsLink on a property"
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn googleAdsLinks-create$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/googleAdsLinks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :canManageClients boolean,
   :createTime string,
   :customerId string,
   :emailAddress string,
   :adsPersonalizationEnabled boolean,
   :parent string,
   :updateTime string}
  
  Creates a GoogleAdsLink."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/googleAdsLinks"
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

(defn googleAdsLinks-list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/googleAdsLinks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists GoogleAdsLinks on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/googleAdsLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn googleAdsLinks-patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/googleAdsLinks/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :canManageClients boolean,
   :createTime string,
   :customerId string,
   :emailAddress string,
   :adsPersonalizationEnabled boolean,
   :parent string,
   :updateTime string}
  
  Updates a GoogleAdsLink on a property"
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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

(defn firebaseLinks-create$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/firebaseLinks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :project string,
   :createTime string,
   :maximumUserAccess string}
  
  Creates a FirebaseLink. Properties can have at most one FirebaseLink."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/firebaseLinks"
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

(defn firebaseLinks-patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/firebaseLinks/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :project string,
   :createTime string,
   :maximumUserAccess string}
  
  Updates a FirebaseLink on a property"
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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

(defn firebaseLinks-list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/firebaseLinks/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists FirebaseLinks on a property. Properties can have at most one FirebaseLink."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/firebaseLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn firebaseLinks-delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/firebaseLinks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a FirebaseLink on a property"
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webDataStreams-create$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/webDataStreams/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :firebaseAppId string,
   :defaultUri string,
   :measurementId string,
   :createTime string,
   :updateTime string,
   :displayName string}
  
  Creates a web stream with the specified location and attributes."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/webDataStreams"
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

(defn webDataStreams-get$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/webDataStreams/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single WebDataStream Throws \"Target not found\" if no such web data stream found, or if the caller does not have permissions to access it."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webDataStreams-delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/webDataStreams/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a web stream on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webDataStreams-updateEnhancedMeasurementSettings$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/webDataStreams/updateEnhancedMeasurementSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:excludedDomains string,
   :streamEnabled boolean,
   :productsAndEcommerceEnabled boolean,
   :dataTaggedElementClicksEnabled boolean,
   :scrollsEnabled boolean,
   :name string,
   :contentViewsEnabled boolean,
   :siteSearchEnabled boolean,
   :pageLoadsEnabled boolean,
   :articlesAndBlogsEnabled boolean,
   :pageChangesEnabled boolean,
   :videoEngagementEnabled boolean,
   :outboundClicksEnabled boolean,
   :formInteractionsEnabled boolean,
   :urlQueryParameter string,
   :pageViewsEnabled boolean,
   :fileDownloadsEnabled boolean,
   :searchQueryParameter string}
  
  Updates the singleton enhanced measurement settings for this web stream. Note that the stream must enable enhanced measurement for these settings to take effect."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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

(defn webDataStreams-patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/webDataStreams/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :firebaseAppId string,
   :defaultUri string,
   :measurementId string,
   :createTime string,
   :updateTime string,
   :displayName string}
  
  Updates a web stream on a property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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

(defn webDataStreams-list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/webDataStreams/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns child web data streams under the specified parent property. Web data streams will be excluded if the caller does not have access. Returns an empty list if no relevant web data streams are found."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/webDataStreams"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webDataStreams-getGlobalSiteTag$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/webDataStreams/getGlobalSiteTag
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the Site Tag for the specified web stream. Site Tags are immutable singletons."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webDataStreams-getEnhancedMeasurementSettings$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/webDataStreams/getEnhancedMeasurementSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the singleton enhanced measurement settings for this web stream. Note that the stream must enable enhanced measurement for these settings to take effect."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-get$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a user's link to an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :emailAddress string, :directRoles [string]}
  
  Updates a user link on an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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

(defn userLinks-batchUpdate$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:userLink GoogleAnalyticsAdminV1alphaUserLink}]}
  
  Updates information about multiple users' links to an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:batchUpdate"
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

(defn userLinks-create$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/create
  
  Required parameters: parent
  
  Optional parameters: notifyNewUser
  
  Body: 
  
  {:name string, :emailAddress string, :directRoles [string]}
  
  Creates a user link on an account or property. If the user with the specified email already has permissions on the account or property, then the user's existing permissions will be unioned with the permissions specified in the new UserLink."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks"
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

(defn userLinks-batchGet$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/batchGet
  
  Required parameters: parent
  
  Optional parameters: names
  
  Gets information about multiple users' links to an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-batchCreate$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:notifyNewUsers boolean,
   :requests [{:parent string,
               :userLink GoogleAnalyticsAdminV1alphaUserLink,
               :notifyNewUser boolean}]}
  
  Creates information about multiple users' links to an account or property. This method is transactional. If any UserLink cannot be created, none of the UserLinks will be created."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:batchCreate"
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

(defn userLinks-delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a user link on an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-batchDelete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:name string}]}
  
  Deletes information about multiple users' links to an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:batchDelete"
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

(defn userLinks-list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all user links on an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-audit$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/properties/userLinks/audit
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string, :pageSize integer}
  
  Lists all user links on an account or property, including implicit ones that come from effective permissions granted by groups or organization admin roles. If a returned user link does not have direct permissions, they cannot be removed from the account or property directly with the DeleteUserLink command. They have to be removed from the group/etc that gives them permissions, which is currently only usable/discoverable in the GA or GMP UIs."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:audit"
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
