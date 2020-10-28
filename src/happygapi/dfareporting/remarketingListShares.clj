(ns happygapi.dfareporting.remarketingListShares
  "DCM/DFA Reporting And Trafficking API: remarketingListShares.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingListShares"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingListShares/get
  
  Required parameters: remarketingListId, profileId
  
  Optional parameters: none
  
  Gets one remarketing list share by remarketing list ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:remarketingListId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingListShares/{remarketingListId}"
     #{:remarketingListId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingListShares/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:sharedAccountIds [string],
   :kind string,
   :remarketingListId string,
   :sharedAdvertiserIds [string]}
  
  Updates an existing remarketing list share."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingListShares"
     #{:profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingListShares/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:sharedAccountIds [string],
   :kind string,
   :remarketingListId string,
   :sharedAdvertiserIds [string]}
  
  Updates an existing remarketing list share. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingListShares"
     #{:id :profileId}
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
