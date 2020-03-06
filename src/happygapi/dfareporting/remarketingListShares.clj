(ns happygapi.dfareporting.remarketingListShares
  "DCM/DFA Reporting And Trafficking API: remarketingListShares.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingListShares"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingListShares/get
  
  Required parameters: profileId, remarketingListId
  
  Optional parameters: none
  Gets one remarketing list share by remarketing list ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:remarketingListId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingListShares/{remarketingListId}"
     #{:remarketingListId :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingListShares/patch
  
  Required parameters: profileId, remarketingListId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :remarketingListId string,
   :sharedAccountIds [string],
   :sharedAdvertiserIds [string]}
  
  Updates an existing remarketing list share. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:remarketingListId :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingListShares"
     #{:remarketingListId :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingListShares/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :remarketingListId string,
   :sharedAccountIds [string],
   :sharedAdvertiserIds [string]}
  
  Updates an existing remarketing list share."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingListShares"
     #{:profileId}
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
