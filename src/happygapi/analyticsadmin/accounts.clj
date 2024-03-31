(ns happygapi.analyticsadmin.accounts
  "Google Analytics Admin API: accounts.
  Manage properties in Google Analytics. Warning: Creating multiple Customer Applications, Accounts, or Projects to simulate or act as a single Customer Application, Account, or Project (respectively) or to circumvent Service-specific usage limits or quotas is a direct violation of Google Cloud Platform Terms of Service as well as Google APIs Terms of Service. These actions can result in immediate termination of your GCP project(s) without any warning.
  See: http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accounts/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:createTime string,
   :regionCode string,
   :updateTime string,
   :deleted boolean,
   :name string,
   :displayName string}
  
  Updates an account."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+name}"
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

(defn searchChangeHistoryEvents$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accounts/searchChangeHistoryEvents
  
  Required parameters: account
  
  Optional parameters: none
  
  Body: 
  
  {:latestChangeTime string,
   :resourceType [string],
   :property string,
   :pageToken string,
   :pageSize integer,
   :action [string],
   :actorEmail [string],
   :earliestChangeTime string}
  
  Searches through all changes to an account or its children given the specified set of filters."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:account})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+account}:searchChangeHistoryEvents"
     #{:account}
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

(defn list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accounts/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, showDeleted
  
  Returns all accounts accessible by the caller. Note that these accounts might not currently have GA4 properties. Soft-deleted (ie: \"trashed\") accounts are excluded by default. Returns an empty list if no relevant accounts are found."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/accounts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getDataSharingSettings$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accounts/getDataSharingSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Get data sharing settings on an account. Data sharing settings are singletons."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
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

(defn delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accounts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Marks target Account as soft-deleted (ie: \"trashed\") and returns it. This API does not have a method to restore soft-deleted accounts. However, they can be restored using the Trash Can UI. If the accounts are not restored before the expiration time, the account and all child resources (eg: Properties, GoogleAdsLinks, Streams, AccessBindings) will be permanently purged. https://support.google.com/analytics/answer/6154772 Returns an error if the target is not found."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
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

(defn runAccessReport$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accounts/runAccessReport
  
  Required parameters: entity
  
  Optional parameters: none
  
  Body: 
  
  {:timeZone string,
   :limit string,
   :offset string,
   :dimensionFilter {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
                     :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
                     :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
                     :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression},
   :dimensions [{:dimensionName string}],
   :metricFilter {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
                  :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
                  :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
                  :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression},
   :dateRanges [{:endDate string, :startDate string}],
   :expandGroups boolean,
   :orderBys [{:dimension GoogleAnalyticsAdminV1betaAccessOrderByDimensionOrderBy,
               :metric GoogleAnalyticsAdminV1betaAccessOrderByMetricOrderBy,
               :desc boolean}],
   :metrics [{:metricName string}],
   :includeAllUsers boolean,
   :returnEntityQuota boolean}
  
  Returns a customized report of data access records. The report provides records of each time a user reads Google Analytics reporting data. Access records are retained for up to 2 years. Data Access Reports can be requested for a property. Reports may be requested for any property, but dimensions that aren't related to quota can only be requested on Google Analytics 360 properties. This method is only available to Administrators. These data access records include GA4 UI Reporting, GA4 UI Explorations, GA4 Data API, and other products like Firebase & Admob that can retrieve data from Google Analytics through a linkage. These records don't include property configuration changes like adding a stream or changing a property's time zone. For configuration change history, see [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents)."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entity})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/{+entity}:runAccessReport"
     #{:entity}
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
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accounts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single Account."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
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

(defn provisionAccountTicket$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accounts/provisionAccountTicket
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:redirectUri string,
   :account {:createTime string,
             :regionCode string,
             :updateTime string,
             :deleted boolean,
             :name string,
             :displayName string}}
  
  Requests a ticket for creating an account."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/accounts:provisionAccountTicket"
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
