(ns happygapi.dfareporting.sites
  "DCM/DFA Reporting And Trafficking API: sites.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :keyName string,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :name string,
   :approved boolean,
   :videoSettings {:skippableSettings SiteSkippableSetting,
                   :kind string,
                   :companionSettings SiteCompanionSetting,
                   :transcodeSettings SiteTranscodeSetting,
                   :obaSettings ObaIcon,
                   :orientation string,
                   :obaEnabled boolean},
   :directorySiteIdDimensionValue {:etag string,
                                   :value string,
                                   :id string,
                                   :kind string,
                                   :dimensionName string,
                                   :matchType string},
   :id string,
   :kind string,
   :siteSettings {:adBlockingOptOut boolean,
                  :disableNewCookie boolean,
                  :vpaidAdapterChoiceTemplate string,
                  :tagSetting TagSetting,
                  :activeViewOptOut boolean,
                  :videoActiveViewOptOutTemplate boolean},
   :subaccountId string,
   :siteContacts [{:phone string,
                   :firstName string,
                   :id string,
                   :email string,
                   :contactType string,
                   :address string,
                   :title string,
                   :lastName string}],
   :accountId string}
  
  Updates an existing site."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites/list
  
  Required parameters: profileId
  
  Optional parameters: acceptsInterstitialPlacements, campaignIds, unmappedSite, ids, acceptsInStreamVideoPlacements, approved, searchString, pageToken, sortField, sortOrder, acceptsPublisherPaidPlacements, adWordsSite, directorySiteIds, subaccountId, maxResults
  
  Retrieves a list of sites, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :keyName string,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :name string,
   :approved boolean,
   :videoSettings {:skippableSettings SiteSkippableSetting,
                   :kind string,
                   :companionSettings SiteCompanionSetting,
                   :transcodeSettings SiteTranscodeSetting,
                   :obaSettings ObaIcon,
                   :orientation string,
                   :obaEnabled boolean},
   :directorySiteIdDimensionValue {:etag string,
                                   :value string,
                                   :id string,
                                   :kind string,
                                   :dimensionName string,
                                   :matchType string},
   :id string,
   :kind string,
   :siteSettings {:adBlockingOptOut boolean,
                  :disableNewCookie boolean,
                  :vpaidAdapterChoiceTemplate string,
                  :tagSetting TagSetting,
                  :activeViewOptOut boolean,
                  :videoActiveViewOptOutTemplate boolean},
   :subaccountId string,
   :siteContacts [{:phone string,
                   :firstName string,
                   :id string,
                   :email string,
                   :contactType string,
                   :address string,
                   :title string,
                   :lastName string}],
   :accountId string}
  
  Updates an existing site. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites"
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

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one site by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :keyName string,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :name string,
   :approved boolean,
   :videoSettings {:skippableSettings SiteSkippableSetting,
                   :kind string,
                   :companionSettings SiteCompanionSetting,
                   :transcodeSettings SiteTranscodeSetting,
                   :obaSettings ObaIcon,
                   :orientation string,
                   :obaEnabled boolean},
   :directorySiteIdDimensionValue {:etag string,
                                   :value string,
                                   :id string,
                                   :kind string,
                                   :dimensionName string,
                                   :matchType string},
   :id string,
   :kind string,
   :siteSettings {:adBlockingOptOut boolean,
                  :disableNewCookie boolean,
                  :vpaidAdapterChoiceTemplate string,
                  :tagSetting TagSetting,
                  :activeViewOptOut boolean,
                  :videoActiveViewOptOutTemplate boolean},
   :subaccountId string,
   :siteContacts [{:phone string,
                   :firstName string,
                   :id string,
                   :email string,
                   :contactType string,
                   :address string,
                   :title string,
                   :lastName string}],
   :accountId string}
  
  Inserts a new site."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites"
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
