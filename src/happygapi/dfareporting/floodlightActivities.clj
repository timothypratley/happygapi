(ns happygapi.dfareporting.floodlightActivities
  "Campaign Manager 360 API: floodlightActivities.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivities"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivities/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:tagString string,
   :attributionEnabled boolean,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :floodlightConfigurationIdDimensionValue {:dimensionName string,
                                             :value string,
                                             :kind string,
                                             :matchType string,
                                             :id string,
                                             :etag string},
   :expectedUrl string,
   :floodlightActivityGroupTagString string,
   :sslCompliant boolean,
   :floodlightConfigurationId string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :name string,
   :publisherTags [{:dynamicTag FloodlightActivityDynamicTag,
                    :clickThrough boolean,
                    :viewThrough boolean,
                    :directorySiteId string,
                    :siteIdDimensionValue DimensionValue,
                    :siteId string}],
   :floodlightTagType string,
   :tagFormat string,
   :advertiserId string,
   :status string,
   :countingMethod string,
   :sslRequired boolean,
   :id string,
   :kind string,
   :notes string,
   :floodlightActivityGroupName string,
   :defaultTags [{:id string, :name string, :tag string}],
   :cacheBustingType string,
   :subaccountId string,
   :secure boolean,
   :floodlightActivityGroupId string,
   :accountId string,
   :floodlightActivityGroupType string,
   :userDefinedVariableTypes [string]}
  
  Updates an existing floodlight activity."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivities"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivities/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:tagString string,
   :attributionEnabled boolean,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :floodlightConfigurationIdDimensionValue {:dimensionName string,
                                             :value string,
                                             :kind string,
                                             :matchType string,
                                             :id string,
                                             :etag string},
   :expectedUrl string,
   :floodlightActivityGroupTagString string,
   :sslCompliant boolean,
   :floodlightConfigurationId string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :name string,
   :publisherTags [{:dynamicTag FloodlightActivityDynamicTag,
                    :clickThrough boolean,
                    :viewThrough boolean,
                    :directorySiteId string,
                    :siteIdDimensionValue DimensionValue,
                    :siteId string}],
   :floodlightTagType string,
   :tagFormat string,
   :advertiserId string,
   :status string,
   :countingMethod string,
   :sslRequired boolean,
   :id string,
   :kind string,
   :notes string,
   :floodlightActivityGroupName string,
   :defaultTags [{:id string, :name string, :tag string}],
   :cacheBustingType string,
   :subaccountId string,
   :secure boolean,
   :floodlightActivityGroupId string,
   :accountId string,
   :floodlightActivityGroupType string,
   :userDefinedVariableTypes [string]}
  
  Updates an existing floodlight activity. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivities"
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

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivities/delete
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Deletes an existing floodlight activity."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivities/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivities/list
  
  Required parameters: profileId
  
  Optional parameters: tagString, floodlightActivityGroupTagString, floodlightConfigurationId, ids, searchString, pageToken, sortField, advertiserId, floodlightActivityGroupIds, sortOrder, floodlightActivityGroupName, floodlightActivityGroupType, maxResults
  
  Retrieves a list of floodlight activities, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivities"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn generatetag$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivities/generatetag
  
  Required parameters: profileId
  
  Optional parameters: floodlightActivityId
  
  Generates a tag for a floodlight activity."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivities/generatetag"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivities/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:tagString string,
   :attributionEnabled boolean,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :floodlightConfigurationIdDimensionValue {:dimensionName string,
                                             :value string,
                                             :kind string,
                                             :matchType string,
                                             :id string,
                                             :etag string},
   :expectedUrl string,
   :floodlightActivityGroupTagString string,
   :sslCompliant boolean,
   :floodlightConfigurationId string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :name string,
   :publisherTags [{:dynamicTag FloodlightActivityDynamicTag,
                    :clickThrough boolean,
                    :viewThrough boolean,
                    :directorySiteId string,
                    :siteIdDimensionValue DimensionValue,
                    :siteId string}],
   :floodlightTagType string,
   :tagFormat string,
   :advertiserId string,
   :status string,
   :countingMethod string,
   :sslRequired boolean,
   :id string,
   :kind string,
   :notes string,
   :floodlightActivityGroupName string,
   :defaultTags [{:id string, :name string, :tag string}],
   :cacheBustingType string,
   :subaccountId string,
   :secure boolean,
   :floodlightActivityGroupId string,
   :accountId string,
   :floodlightActivityGroupType string,
   :userDefinedVariableTypes [string]}
  
  Inserts a new floodlight activity."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivities"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivities/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one floodlight activity by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivities/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
