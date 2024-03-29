(ns happygapi.playablelocations.v3
  "Playable Locations API: v3.
  
  See: https://developers.google.com/maps/contact-sales/api/reference/rest/v3/v3"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://developers.google.com/maps/contact-sales/api/reference/rest/v3/logPlayerReports
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:playerReports [{:languageCode string,
                    :locationName string,
                    :reasons [string],
                    :reasonDetails string}],
   :requestId string,
   :clientInfo {:apiClient string,
                :operatingSystem string,
                :deviceModel string,
                :applicationId string,
                :applicationVersion string,
                :platform string,
                :languageCode string,
                :operatingSystemBuild string}}
  
  Logs bad playable location reports submitted by players. Reports are not partially saved; either all reports are saved and this request succeeds, or no reports are saved, and this request fails."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playablelocations.googleapis.com/"
     "v3:logPlayerReports"
     #{}
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

(defn $
  "https://developers.google.com/maps/contact-sales/api/reference/rest/v3/logImpressions
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:impressions [{:impressionType string,
                  :locationName string,
                  :gameObjectType integer}],
   :requestId string,
   :clientInfo {:apiClient string,
                :operatingSystem string,
                :deviceModel string,
                :applicationId string,
                :applicationVersion string,
                :platform string,
                :languageCode string,
                :operatingSystemBuild string}}
  
  Logs new events when playable locations are displayed, and when they are interacted with. Impressions are not partially saved; either all impressions are saved and this request succeeds, or no impressions are saved, and this request fails."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playablelocations.googleapis.com/"
     "v3:logImpressions"
     #{}
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

(defn $
  "https://developers.google.com/maps/contact-sales/api/reference/rest/v3/samplePlayableLocations
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:areaFilter {:s2CellId string},
   :criteria [{:gameObjectType integer,
               :fieldsToReturn string,
               :filter GoogleMapsPlayablelocationsV3SampleFilter}]}
  
  Returns a set of playable locations that lie within a specified area, that satisfy optional filter criteria. Note: Identical `SamplePlayableLocations` requests can return different results as the state of the world changes over time."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playablelocations.googleapis.com/"
     "v3:samplePlayableLocations"
     #{}
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
