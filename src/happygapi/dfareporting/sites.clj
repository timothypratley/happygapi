(ns happygapi.dfareporting.sites
  "Campaign Manager 360 API: sites.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/sites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/sites/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :keyName string,
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :name string,
   :approved boolean,
   :videoSettings {:skippableSettings SiteSkippableSetting,
                   :obaEnabled boolean,
                   :orientation string,
                   :transcodeSettings SiteTranscodeSetting,
                   :kind string,
                   :obaSettings ObaIcon,
                   :companionSettings SiteCompanionSetting},
   :directorySiteIdDimensionValue {:kind string,
                                   :dimensionName string,
                                   :matchType string,
                                   :value string,
                                   :etag string,
                                   :id string},
   :id string,
   :kind string,
   :siteSettings {:disableNewCookie boolean,
                  :activeViewOptOut boolean,
                  :adBlockingOptOut boolean,
                  :vpaidAdapterChoiceTemplate string,
                  :videoActiveViewOptOutTemplate boolean,
                  :tagSetting TagSetting},
   :subaccountId string,
   :siteContacts [{:lastName string,
                   :title string,
                   :email string,
                   :firstName string,
                   :id string,
                   :phone string,
                   :address string,
                   :contactType string}],
   :accountId string}
  
  Updates an existing site. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/sites"
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

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/sites/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :keyName string,
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :name string,
   :approved boolean,
   :videoSettings {:skippableSettings SiteSkippableSetting,
                   :obaEnabled boolean,
                   :orientation string,
                   :transcodeSettings SiteTranscodeSetting,
                   :kind string,
                   :obaSettings ObaIcon,
                   :companionSettings SiteCompanionSetting},
   :directorySiteIdDimensionValue {:kind string,
                                   :dimensionName string,
                                   :matchType string,
                                   :value string,
                                   :etag string,
                                   :id string},
   :id string,
   :kind string,
   :siteSettings {:disableNewCookie boolean,
                  :activeViewOptOut boolean,
                  :adBlockingOptOut boolean,
                  :vpaidAdapterChoiceTemplate string,
                  :videoActiveViewOptOutTemplate boolean,
                  :tagSetting TagSetting},
   :subaccountId string,
   :siteContacts [{:lastName string,
                   :title string,
                   :email string,
                   :firstName string,
                   :id string,
                   :phone string,
                   :address string,
                   :contactType string}],
   :accountId string}
  
  Inserts a new site."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/sites"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/sites/list
  
  Required parameters: profileId
  
  Optional parameters: acceptsInterstitialPlacements, campaignIds, unmappedSite, ids, acceptsInStreamVideoPlacements, approved, searchString, pageToken, sortField, sortOrder, acceptsPublisherPaidPlacements, adWordsSite, directorySiteIds, subaccountId, maxResults
  
  Retrieves a list of sites, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/sites"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/sites/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:directorySiteId string,
   :keyName string,
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :name string,
   :approved boolean,
   :videoSettings {:skippableSettings SiteSkippableSetting,
                   :obaEnabled boolean,
                   :orientation string,
                   :transcodeSettings SiteTranscodeSetting,
                   :kind string,
                   :obaSettings ObaIcon,
                   :companionSettings SiteCompanionSetting},
   :directorySiteIdDimensionValue {:kind string,
                                   :dimensionName string,
                                   :matchType string,
                                   :value string,
                                   :etag string,
                                   :id string},
   :id string,
   :kind string,
   :siteSettings {:disableNewCookie boolean,
                  :activeViewOptOut boolean,
                  :adBlockingOptOut boolean,
                  :vpaidAdapterChoiceTemplate string,
                  :videoActiveViewOptOutTemplate boolean,
                  :tagSetting TagSetting},
   :subaccountId string,
   :siteContacts [{:lastName string,
                   :title string,
                   :email string,
                   :firstName string,
                   :id string,
                   :phone string,
                   :address string,
                   :contactType string}],
   :accountId string}
  
  Updates an existing site."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/sites"
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

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/sites/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one site by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/sites/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
