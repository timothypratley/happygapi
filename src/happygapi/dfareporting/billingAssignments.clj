(ns happygapi.dfareporting.billingAssignments
  "Campaign Manager 360 API: billingAssignments.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/billingAssignments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/billingAssignments/insert
  
  Required parameters: profileId, billingProfileId
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string,
   :subaccountId string,
   :advertiserId string,
   :campaignId string,
   :kind string}
  
  Inserts a new billing assignment and returns the new assignment. Only one of advertiser_id or campaign_id is support per request. If the new assignment has no effect (assigning a campaign to the parent advertiser billing profile or assigning an advertiser to the account billing profile), no assignment will be returned."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:billingProfileId :profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/billingProfiles/{+billingProfileId}/billingAssignments"
     #{:billingProfileId :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/billingAssignments/list
  
  Required parameters: profileId, billingProfileId
  
  Optional parameters: none
  
  Retrieves a list of billing assignments."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:billingProfileId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/billingProfiles/{+billingProfileId}/billingAssignments"
     #{:billingProfileId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
