(ns happygapi.dfareporting.sites
  "DCM/DFA Reporting And Trafficking API: sites.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Gets one site by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites/{id}"
     #{:id :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :name string,
   :approved boolean,
   :videoSettings {:companionSettings SiteCompanionSetting,
                   :kind string,
                   :orientation string,
                   :skippableSettings SiteSkippableSetting,
                   :transcodeSettings SiteTranscodeSetting},
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :etag string,
                                   :id string,
                                   :kind string,
                                   :matchType string,
                                   :value string},
   :id string,
   :kind string,
   :siteSettings {:activeViewOptOut boolean,
                  :adBlockingOptOut boolean,
                  :disableNewCookie boolean,
                  :tagSetting TagSetting,
                  :videoActiveViewOptOutTemplate boolean,
                  :vpaidAdapterChoiceTemplate string},
   :subaccountId string,
   :siteContacts [{:address string,
                   :contactType string,
                   :email string,
                   :firstName string,
                   :id string,
                   :lastName string,
                   :phone string,
                   :title string}],
   :accountId string}
  
  Inserts a new site."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites/list
  
  Required parameters: profileId
  
  Optional parameters: acceptsInterstitialPlacements, campaignIds, unmappedSite, ids, acceptsInStreamVideoPlacements, approved, searchString, pageToken, sortField, sortOrder, acceptsPublisherPaidPlacements, adWordsSite, directorySiteIds, subaccountId, maxResults
  Retrieves a list of sites, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites"
     #{:profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :name string,
   :approved boolean,
   :videoSettings {:companionSettings SiteCompanionSetting,
                   :kind string,
                   :orientation string,
                   :skippableSettings SiteSkippableSetting,
                   :transcodeSettings SiteTranscodeSetting},
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :etag string,
                                   :id string,
                                   :kind string,
                                   :matchType string,
                                   :value string},
   :id string,
   :kind string,
   :siteSettings {:activeViewOptOut boolean,
                  :adBlockingOptOut boolean,
                  :disableNewCookie boolean,
                  :tagSetting TagSetting,
                  :videoActiveViewOptOutTemplate boolean,
                  :vpaidAdapterChoiceTemplate string},
   :subaccountId string,
   :siteContacts [{:address string,
                   :contactType string,
                   :email string,
                   :firstName string,
                   :id string,
                   :lastName string,
                   :phone string,
                   :title string}],
   :accountId string}
  
  Updates an existing site. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites"
     #{:id :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/sites/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :keyName string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :name string,
   :approved boolean,
   :videoSettings {:companionSettings SiteCompanionSetting,
                   :kind string,
                   :orientation string,
                   :skippableSettings SiteSkippableSetting,
                   :transcodeSettings SiteTranscodeSetting},
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :etag string,
                                   :id string,
                                   :kind string,
                                   :matchType string,
                                   :value string},
   :id string,
   :kind string,
   :siteSettings {:activeViewOptOut boolean,
                  :adBlockingOptOut boolean,
                  :disableNewCookie boolean,
                  :tagSetting TagSetting,
                  :videoActiveViewOptOutTemplate boolean,
                  :vpaidAdapterChoiceTemplate string},
   :subaccountId string,
   :siteContacts [{:address string,
                   :contactType string,
                   :email string,
                   :firstName string,
                   :id string,
                   :lastName string,
                   :phone string,
                   :title string}],
   :accountId string}
  
  Updates an existing site."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/sites"
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
