(ns happygapi.marketingplatformadmin.organizations
  "Google Marketing Platform Admin API: organizations.
  The Google Marketing Platform Admin API allows for programmatic access to the Google Marketing Platform configuration data. You can use the Google Marketing Platform Admin API to manage links between your Google Marketing Platform organization and Google Analytics accounts, set the service level of your GA4 properties.
  See: https://developers.google.com/analytics/devguides/config/gmp/v1api/reference/rest/v1alpha/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn analyticsAccountLinks-delete$
  "https://developers.google.com/analytics/devguides/config/gmp/v1api/reference/rest/v1alpha/organizations/analyticsAccountLinks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google Marketing Platform organization. User needs to be an org user, and admin on the Analytics account in order to delete the link."
  {:scopes ["https://www.googleapis.com/auth/marketingplatformadmin.analytics.update"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://marketingplatformadmin.googleapis.com/"
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

(defn analyticsAccountLinks-list$
  "https://developers.google.com/analytics/devguides/config/gmp/v1api/reference/rest/v1alpha/organizations/analyticsAccountLinks/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the Google Analytics accounts link to the specified Google Marketing Platform organization."
  {:scopes ["https://www.googleapis.com/auth/marketingplatformadmin.analytics.read"
            "https://www.googleapis.com/auth/marketingplatformadmin.analytics.update"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://marketingplatformadmin.googleapis.com/"
     "v1alpha/{+parent}/analyticsAccountLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn analyticsAccountLinks-create$
  "https://developers.google.com/analytics/devguides/config/gmp/v1api/reference/rest/v1alpha/organizations/analyticsAccountLinks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :displayName string,
   :analyticsAccount string,
   :linkVerificationState string}
  
  Creates the link between the Analytics account and the Google Marketing Platform organization. User needs to be an org user, and admin on the Analytics account to create the link. If the account is already linked to an organization, user needs to unlink the account from the current organization, then try link again."
  {:scopes ["https://www.googleapis.com/auth/marketingplatformadmin.analytics.update"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://marketingplatformadmin.googleapis.com/"
     "v1alpha/{+parent}/analyticsAccountLinks"
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

(defn analyticsAccountLinks-setPropertyServiceLevel$
  "https://developers.google.com/analytics/devguides/config/gmp/v1api/reference/rest/v1alpha/organizations/analyticsAccountLinks/setPropertyServiceLevel
  
  Required parameters: analyticsAccountLink
  
  Optional parameters: none
  
  Body: 
  
  {:serviceLevel string, :analyticsProperty string}
  
  Updates the service level for an Analytics property."
  {:scopes ["https://www.googleapis.com/auth/marketingplatformadmin.analytics.update"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:analyticsAccountLink})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://marketingplatformadmin.googleapis.com/"
     "v1alpha/{+analyticsAccountLink}:setPropertyServiceLevel"
     #{:analyticsAccountLink}
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
