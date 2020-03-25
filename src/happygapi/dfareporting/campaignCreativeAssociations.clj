(ns happygapi.dfareporting.campaignCreativeAssociations
  "DCM/DFA Reporting And Trafficking API: campaignCreativeAssociations.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/campaignCreativeAssociations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/campaignCreativeAssociations/insert
  
  Required parameters: campaignId, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:creativeId string, :kind string}
  
  Associates a creative with the specified campaign. This method creates a default ad with dimensions matching the creative in the campaign if such a default ad does not exist already."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:campaignId :profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/campaigns/{campaignId}/campaignCreativeAssociations"
     #{:campaignId :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/campaignCreativeAssociations/list
  
  Required parameters: campaignId, profileId
  
  Optional parameters: maxResults, pageToken, sortOrder
  
  Retrieves the list of creative IDs associated with the specified campaign. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:campaignId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/campaigns/{campaignId}/campaignCreativeAssociations"
     #{:campaignId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
