(ns happygapi.displayvideo.firstAndThirdPartyAudiences
  "Display & Video 360 API: firstAndThirdPartyAudiences.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/firstAndThirdPartyAudiences"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/firstAndThirdPartyAudiences/get
  
  Required parameters: firstAndThirdPartyAudienceId
  
  Optional parameters: partnerId, advertiserId
  
  Gets a first and third party audience."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firstAndThirdPartyAudienceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/firstAndThirdPartyAudiences/{+firstAndThirdPartyAudienceId}"
     #{:firstAndThirdPartyAudienceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v3/firstAndThirdPartyAudiences/list
  
  Required parameters: none
  
  Optional parameters: partnerId, advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists first and third party audiences. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/firstAndThirdPartyAudiences"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/display-video/api/reference/rest/v3/firstAndThirdPartyAudiences/create
  
  Required parameters: none
  
  Optional parameters: advertiserId
  
  Body: 
  
  {:description string,
   :firstAndThirdPartyAudienceType string,
   :audienceSource string,
   :displayName string,
   :contactInfoList {:contactInfos [ContactInfo], :consent Consent},
   :name string,
   :audienceType string,
   :gmailAudienceSize string,
   :activeDisplayAudienceSize string,
   :membershipDurationDays string,
   :displayDesktopAudienceSize string,
   :appId string,
   :firstAndThirdPartyAudienceId string,
   :displayMobileWebAudienceSize string,
   :youtubeAudienceSize string,
   :mobileDeviceIdList {:mobileDeviceIds [string], :consent Consent},
   :displayAudienceSize string,
   :displayMobileAppAudienceSize string}
  
  Creates a FirstAndThirdPartyAudience. Only supported for the following audience_type: * `CUSTOMER_MATCH_CONTACT_INFO` * `CUSTOMER_MATCH_DEVICE_ID`"
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/firstAndThirdPartyAudiences"
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

(defn patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/firstAndThirdPartyAudiences/patch
  
  Required parameters: firstAndThirdPartyAudienceId
  
  Optional parameters: updateMask, advertiserId
  
  Body: 
  
  {:description string,
   :firstAndThirdPartyAudienceType string,
   :audienceSource string,
   :displayName string,
   :contactInfoList {:contactInfos [ContactInfo], :consent Consent},
   :name string,
   :audienceType string,
   :gmailAudienceSize string,
   :activeDisplayAudienceSize string,
   :membershipDurationDays string,
   :displayDesktopAudienceSize string,
   :appId string,
   :firstAndThirdPartyAudienceId string,
   :displayMobileWebAudienceSize string,
   :youtubeAudienceSize string,
   :mobileDeviceIdList {:mobileDeviceIds [string], :consent Consent},
   :displayAudienceSize string,
   :displayMobileAppAudienceSize string}
  
  Updates an existing FirstAndThirdPartyAudience. Only supported for the following audience_type: * `CUSTOMER_MATCH_CONTACT_INFO` * `CUSTOMER_MATCH_DEVICE_ID`"
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:firstAndThirdPartyAudienceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/firstAndThirdPartyAudiences/{+firstAndThirdPartyAudienceId}"
     #{:firstAndThirdPartyAudienceId}
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

(defn editCustomerMatchMembers$
  "https://developers.google.com/display-video/api/reference/rest/v3/firstAndThirdPartyAudiences/editCustomerMatchMembers
  
  Required parameters: firstAndThirdPartyAudienceId
  
  Optional parameters: none
  
  Body: 
  
  {:addedContactInfoList {:contactInfos [ContactInfo], :consent Consent},
   :addedMobileDeviceIdList {:mobileDeviceIds [string],
                             :consent Consent},
   :removedContactInfoList {:contactInfos [ContactInfo],
                            :consent Consent},
   :removedMobileDeviceIdList {:mobileDeviceIds [string],
                               :consent Consent},
   :advertiserId string}
  
  Updates the member list of a Customer Match audience. Only supported for the following audience_type: * `CUSTOMER_MATCH_CONTACT_INFO` * `CUSTOMER_MATCH_DEVICE_ID`"
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:firstAndThirdPartyAudienceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/firstAndThirdPartyAudiences/{+firstAndThirdPartyAudienceId}:editCustomerMatchMembers"
     #{:firstAndThirdPartyAudienceId}
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
