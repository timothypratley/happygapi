(ns happygapi.dfareporting.accountUserProfiles
  "DCM/DFA Reporting And Trafficking API: accountUserProfiles.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountUserProfiles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountUserProfiles/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one account user profile by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accountUserProfiles/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountUserProfiles/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:campaignFilter {:kind string, :objectIds [string], :status string},
   :traffickerType string,
   :email string,
   :locale string,
   :userRoleId string,
   :name string,
   :comments string,
   :userRoleFilter {:kind string, :objectIds [string], :status string},
   :userAccessType string,
   :siteFilter {:kind string, :objectIds [string], :status string},
   :active boolean,
   :id string,
   :kind string,
   :advertiserFilter {:kind string, :objectIds [string], :status string},
   :subaccountId string,
   :accountId string}
  
  Inserts a new account user profile."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accountUserProfiles"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountUserProfiles/list
  
  Required parameters: profileId
  
  Optional parameters: userRoleId, ids, searchString, pageToken, sortField, active, sortOrder, subaccountId, maxResults
  
  Retrieves a list of account user profiles, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accountUserProfiles"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountUserProfiles/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:campaignFilter {:kind string, :objectIds [string], :status string},
   :traffickerType string,
   :email string,
   :locale string,
   :userRoleId string,
   :name string,
   :comments string,
   :userRoleFilter {:kind string, :objectIds [string], :status string},
   :userAccessType string,
   :siteFilter {:kind string, :objectIds [string], :status string},
   :active boolean,
   :id string,
   :kind string,
   :advertiserFilter {:kind string, :objectIds [string], :status string},
   :subaccountId string,
   :accountId string}
  
  Updates an existing account user profile. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accountUserProfiles"
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

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountUserProfiles/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:campaignFilter {:kind string, :objectIds [string], :status string},
   :traffickerType string,
   :email string,
   :locale string,
   :userRoleId string,
   :name string,
   :comments string,
   :userRoleFilter {:kind string, :objectIds [string], :status string},
   :userAccessType string,
   :siteFilter {:kind string, :objectIds [string], :status string},
   :active boolean,
   :id string,
   :kind string,
   :advertiserFilter {:kind string, :objectIds [string], :status string},
   :subaccountId string,
   :accountId string}
  
  Updates an existing account user profile."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accountUserProfiles"
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
