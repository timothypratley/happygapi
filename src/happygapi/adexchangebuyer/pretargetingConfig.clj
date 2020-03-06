(ns happygapi.adexchangebuyer.pretargetingConfig
  "Ad Exchange Buyer API: pretargetingConfig.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/pretargetingConfig"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/pretargetingConfig/delete
  
  Required parameters: accountId, configId
  
  Optional parameters: none
  Deletes an existing pretargeting config."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{:accountId :configId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "pretargetingconfigs/{accountId}/{configId}"
     #{:accountId :configId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/pretargetingConfig/get
  
  Required parameters: accountId, configId
  
  Optional parameters: none
  Gets a specific pretargeting configuration"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{:accountId :configId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "pretargetingconfigs/{accountId}/{configId}"
     #{:accountId :configId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/pretargetingConfig/insert
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:configName string,
   :billingId string,
   :supportedCreativeAttributes [string],
   :mobileDevices [string],
   :excludedVerticals [string],
   :mobileCarriers [string],
   :excludedGeoCriteriaIds [string],
   :userLists [string],
   :creativeType [string],
   :placements [{:token string, :type string}],
   :verticals [string],
   :maximumQps string,
   :dimensions [{:height string, :width string}],
   :userIdentifierDataRequired [string],
   :isActive boolean,
   :vendorTypes [string],
   :excludedPlacements [{:token string, :type string}],
   :kind string,
   :excludedContentLabels [string],
   :minimumViewabilityDecile integer,
   :languages [string],
   :geoCriteriaIds [string],
   :excludedUserLists [string],
   :platforms [string],
   :videoPlayerSizes [{:aspectRatio string,
                       :minHeight string,
                       :minWidth string}],
   :mobileOperatingSystemVersions [string],
   :configId string}
  
  Inserts a new pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "pretargetingconfigs/{accountId}"
     #{:accountId}
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

(defn list$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/pretargetingConfig/list
  
  Required parameters: accountId
  
  Optional parameters: none
  Retrieves a list of the authenticated user's pretargeting configurations."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "pretargetingconfigs/{accountId}"
     #{:accountId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/pretargetingConfig/patch
  
  Required parameters: accountId, configId
  
  Optional parameters: none
  
  Body: 
  
  {:configName string,
   :billingId string,
   :supportedCreativeAttributes [string],
   :mobileDevices [string],
   :excludedVerticals [string],
   :mobileCarriers [string],
   :excludedGeoCriteriaIds [string],
   :userLists [string],
   :creativeType [string],
   :placements [{:token string, :type string}],
   :verticals [string],
   :maximumQps string,
   :dimensions [{:height string, :width string}],
   :userIdentifierDataRequired [string],
   :isActive boolean,
   :vendorTypes [string],
   :excludedPlacements [{:token string, :type string}],
   :kind string,
   :excludedContentLabels [string],
   :minimumViewabilityDecile integer,
   :languages [string],
   :geoCriteriaIds [string],
   :excludedUserLists [string],
   :platforms [string],
   :videoPlayerSizes [{:aspectRatio string,
                       :minHeight string,
                       :minWidth string}],
   :mobileOperatingSystemVersions [string],
   :configId string}
  
  Updates an existing pretargeting config. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:accountId :configId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "pretargetingconfigs/{accountId}/{configId}"
     #{:accountId :configId}
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

(defn update$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/pretargetingConfig/update
  
  Required parameters: accountId, configId
  
  Optional parameters: none
  
  Body: 
  
  {:configName string,
   :billingId string,
   :supportedCreativeAttributes [string],
   :mobileDevices [string],
   :excludedVerticals [string],
   :mobileCarriers [string],
   :excludedGeoCriteriaIds [string],
   :userLists [string],
   :creativeType [string],
   :placements [{:token string, :type string}],
   :verticals [string],
   :maximumQps string,
   :dimensions [{:height string, :width string}],
   :userIdentifierDataRequired [string],
   :isActive boolean,
   :vendorTypes [string],
   :excludedPlacements [{:token string, :type string}],
   :kind string,
   :excludedContentLabels [string],
   :minimumViewabilityDecile integer,
   :languages [string],
   :geoCriteriaIds [string],
   :excludedUserLists [string],
   :platforms [string],
   :videoPlayerSizes [{:aspectRatio string,
                       :minHeight string,
                       :minWidth string}],
   :mobileOperatingSystemVersions [string],
   :configId string}
  
  Updates an existing pretargeting config."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:accountId :configId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "pretargetingconfigs/{accountId}/{configId}"
     #{:accountId :configId}
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
