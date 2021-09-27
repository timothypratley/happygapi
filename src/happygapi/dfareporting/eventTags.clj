(ns happygapi.dfareporting.eventTags
  "Campaign Manager 360 API: eventTags.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/eventTags"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/eventTags/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:sslCompliant boolean,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :name string,
   :campaignId string,
   :urlEscapeLevels integer,
   :type string,
   :siteFilterType string,
   :campaignIdDimensionValue {:kind string,
                              :dimensionName string,
                              :matchType string,
                              :value string,
                              :etag string,
                              :id string},
   :excludeFromAdxRequests boolean,
   :advertiserId string,
   :status string,
   :id string,
   :kind string,
   :url string,
   :enabledByDefault boolean,
   :subaccountId string,
   :accountId string,
   :siteIds [string]}
  
  Updates an existing event tag. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/eventTags"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/eventTags/list
  
  Required parameters: profileId
  
  Optional parameters: adId, campaignId, ids, searchString, eventTagTypes, sortField, definitionsOnly, advertiserId, sortOrder, enabled
  
  Retrieves a list of event tags, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/eventTags"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/eventTags/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:sslCompliant boolean,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :name string,
   :campaignId string,
   :urlEscapeLevels integer,
   :type string,
   :siteFilterType string,
   :campaignIdDimensionValue {:kind string,
                              :dimensionName string,
                              :matchType string,
                              :value string,
                              :etag string,
                              :id string},
   :excludeFromAdxRequests boolean,
   :advertiserId string,
   :status string,
   :id string,
   :kind string,
   :url string,
   :enabledByDefault boolean,
   :subaccountId string,
   :accountId string,
   :siteIds [string]}
  
  Updates an existing event tag."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/eventTags"
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

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/eventTags/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:sslCompliant boolean,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :name string,
   :campaignId string,
   :urlEscapeLevels integer,
   :type string,
   :siteFilterType string,
   :campaignIdDimensionValue {:kind string,
                              :dimensionName string,
                              :matchType string,
                              :value string,
                              :etag string,
                              :id string},
   :excludeFromAdxRequests boolean,
   :advertiserId string,
   :status string,
   :id string,
   :kind string,
   :url string,
   :enabledByDefault boolean,
   :subaccountId string,
   :accountId string,
   :siteIds [string]}
  
  Inserts a new event tag."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/eventTags"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/eventTags/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one event tag by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/eventTags/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/eventTags/delete
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Deletes an existing event tag."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/eventTags/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
