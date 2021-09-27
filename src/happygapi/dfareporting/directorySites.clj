(ns happygapi.dfareporting.directorySites
  "Campaign Manager 360 API: directorySites.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/directorySites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/directorySites/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one directory site by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/directorySites/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/directorySites/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:inpageTagFormats [string],
   :id string,
   :name string,
   :url string,
   :settings {:interstitialPlacementAccepted boolean,
              :activeViewOptOut boolean,
              :dfpSettings DfpSettings,
              :instreamVideoPlacementAccepted boolean},
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :interstitialTagFormats [string],
   :kind string}
  
  Inserts a new directory site."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/directorySites"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/directorySites/list
  
  Required parameters: profileId
  
  Optional parameters: acceptsInterstitialPlacements, dfpNetworkCode, ids, acceptsInStreamVideoPlacements, searchString, pageToken, sortField, active, sortOrder, acceptsPublisherPaidPlacements, maxResults
  
  Retrieves a list of directory sites, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/directorySites"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
