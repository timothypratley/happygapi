(ns happygapi.dfareporting.campaignCreativeAssociations
  "DCM/DFA Reporting And Trafficking API
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn insert$
  "Required parameters: campaignId,profileId
  
  Associates a creative with the specified campaign. This method creates a default ad with dimensions matching the creative in the campaign if such a default ad does not exist already."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"campaignId" "profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/campaigns/{campaignId}/campaignCreativeAssociations"
     #{"campaignId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn list$
  "Required parameters: campaignId,profileId
  
  Retrieves the list of creative IDs associated with the specified campaign. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"campaignId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/campaigns/{campaignId}/campaignCreativeAssociations"
     #{"campaignId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
