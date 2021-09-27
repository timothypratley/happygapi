(ns happygapi.realtimebidding.bidders
  "Real-time Bidding API: bidders.
  Allows external bidders to manage their RTB integration with Google. This includes managing bidder endpoints, QPS quotas, configuring what ad inventory to receive via pretargeting, submitting creatives for verification, and accessing creative metadata such as approval status.
  See: https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a bidder account by its name."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
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

(defn list$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Lists all the bidder accounts that belong to the caller."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/bidders"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-list$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/creatives/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, view
  
  Lists creatives."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/creatives"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-watch$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/creatives/watch
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Watches all creatives pertaining to a bidder. It is sufficient to invoke this endpoint once per bidder. A Pub/Sub topic will be created and notifications will be pushed to the topic when any of the bidder's creatives change status. All of the bidder's service accounts will have access to read from the topic. Subsequent invocations of this method will return the existing Pub/Sub configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/creatives:watch"
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

(defn pretargetingConfigs-get$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
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

(defn pretargetingConfigs-addTargetedSites$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/addTargetedSites
  
  Required parameters: pretargetingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:sites [string], :targetingMode string}
  
  Adds targeted sites to the pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:pretargetingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+pretargetingConfig}:addTargetedSites"
     #{:pretargetingConfig}
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

(defn pretargetingConfigs-patch$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:billingId string,
   :geoTargeting {:excludedIds [string], :includedIds [string]},
   :includedMobileOperatingSystemIds [string],
   :invalidGeoIds [string],
   :verticalTargeting {:excludedIds [string], :includedIds [string]},
   :displayName string,
   :name string,
   :userListTargeting {:excludedIds [string], :includedIds [string]},
   :includedLanguages [string],
   :appTargeting {:mobileAppTargeting StringTargetingDimension,
                  :mobileAppCategoryTargeting NumericTargetingDimension},
   :webTargeting {:targetingMode string, :values [string]},
   :allowedUserTargetingModes [string],
   :state string,
   :maximumQps string,
   :includedUserIdTypes [string],
   :includedPlatforms [string],
   :excludedContentLabelIds [string],
   :interstitialTargeting string,
   :includedEnvironments [string],
   :includedFormats [string],
   :minimumViewabilityDecile integer,
   :includedCreativeDimensions [{:height string, :width string}],
   :publisherTargeting {:targetingMode string, :values [string]}}
  
  Updates a pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://realtimebidding.googleapis.com/"
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

(defn pretargetingConfigs-removeTargetedApps$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/removeTargetedApps
  
  Required parameters: pretargetingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:appIds [string]}
  
  Removes targeted apps from the pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:pretargetingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+pretargetingConfig}:removeTargetedApps"
     #{:pretargetingConfig}
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

(defn pretargetingConfigs-removeTargetedPublishers$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/removeTargetedPublishers
  
  Required parameters: pretargetingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:publisherIds [string]}
  
  Removes targeted publishers from the pretargeting config."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:pretargetingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+pretargetingConfig}:removeTargetedPublishers"
     #{:pretargetingConfig}
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

(defn pretargetingConfigs-create$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:billingId string,
   :geoTargeting {:excludedIds [string], :includedIds [string]},
   :includedMobileOperatingSystemIds [string],
   :invalidGeoIds [string],
   :verticalTargeting {:excludedIds [string], :includedIds [string]},
   :displayName string,
   :name string,
   :userListTargeting {:excludedIds [string], :includedIds [string]},
   :includedLanguages [string],
   :appTargeting {:mobileAppTargeting StringTargetingDimension,
                  :mobileAppCategoryTargeting NumericTargetingDimension},
   :webTargeting {:targetingMode string, :values [string]},
   :allowedUserTargetingModes [string],
   :state string,
   :maximumQps string,
   :includedUserIdTypes [string],
   :includedPlatforms [string],
   :excludedContentLabelIds [string],
   :interstitialTargeting string,
   :includedEnvironments [string],
   :includedFormats [string],
   :minimumViewabilityDecile integer,
   :includedCreativeDimensions [{:height string, :width string}],
   :publisherTargeting {:targetingMode string, :values [string]}}
  
  Creates a pretargeting configuration. A pretargeting configuration's state (PretargetingConfig.state) is active upon creation, and it will start to affect traffic shortly after. A bidder may create a maximum of 10 pretargeting configurations. Attempts to exceed this maximum results in a 400 bad request error."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/pretargetingConfigs"
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

(defn pretargetingConfigs-delete$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://realtimebidding.googleapis.com/"
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

(defn pretargetingConfigs-suspend$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/suspend
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Suspends a pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}:suspend"
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

(defn pretargetingConfigs-list$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all pretargeting configurations for a single bidder."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/pretargetingConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn pretargetingConfigs-removeTargetedSites$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/removeTargetedSites
  
  Required parameters: pretargetingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:sites [string]}
  
  Removes targeted sites from the pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:pretargetingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+pretargetingConfig}:removeTargetedSites"
     #{:pretargetingConfig}
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

(defn pretargetingConfigs-addTargetedApps$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/addTargetedApps
  
  Required parameters: pretargetingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:targetingMode string, :appIds [string]}
  
  Adds targeted apps to the pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:pretargetingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+pretargetingConfig}:addTargetedApps"
     #{:pretargetingConfig}
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

(defn pretargetingConfigs-activate$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Activates a pretargeting configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}:activate"
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

(defn pretargetingConfigs-addTargetedPublishers$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/pretargetingConfigs/addTargetedPublishers
  
  Required parameters: pretargetingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:targetingMode string, :publisherIds [string]}
  
  Adds targeted publishers to the pretargeting config."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:pretargetingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+pretargetingConfig}:addTargetedPublishers"
     #{:pretargetingConfig}
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

(defn endpoints-get$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/endpoints/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a bidder endpoint by its name."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
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

(defn endpoints-list$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/endpoints/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all the bidder's endpoints."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/endpoints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
