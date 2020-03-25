(ns happygapi.gamesConfiguration.achievementConfigurations
  "Google Play Game Services Publishing API: achievementConfigurations.
  The Google Play Game Services Publishing API allows developers to configure their games in Game Services.
  See: https://developers.google.com/games/api/reference/rest/v1configuration/achievementConfigurations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/games/api/reference/rest/v1configuration/achievementConfigurations/delete
  
  Required parameters: achievementId
  
  Optional parameters: none
  
  Delete the achievement configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:achievementId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "games/v1configuration/achievements/{achievementId}"
     #{:achievementId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/games/api/reference/rest/v1configuration/achievementConfigurations/insert
  
  Required parameters: applicationId
  
  Optional parameters: none
  
  Body: 
  
  {:published {:kind string,
               :description LocalizedStringBundle,
               :pointValue integer,
               :sortRank integer,
               :name LocalizedStringBundle,
               :iconUrl string},
   :achievementType string,
   :kind string,
   :token string,
   :initialState string,
   :stepsToUnlock integer,
   :id string,
   :draft {:kind string,
           :description LocalizedStringBundle,
           :pointValue integer,
           :sortRank integer,
           :name LocalizedStringBundle,
           :iconUrl string}}
  
  Insert a new achievement configuration in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "games/v1configuration/applications/{applicationId}/achievements"
     #{:applicationId}
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
  "https://developers.google.com/games/api/reference/rest/v1configuration/achievementConfigurations/get
  
  Required parameters: achievementId
  
  Optional parameters: none
  
  Retrieves the metadata of the achievement configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:achievementId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "games/v1configuration/achievements/{achievementId}"
     #{:achievementId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/api/reference/rest/v1configuration/achievementConfigurations/list
  
  Required parameters: applicationId
  
  Optional parameters: pageToken, maxResults
  
  Returns a list of the achievement configurations in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "games/v1configuration/applications/{applicationId}/achievements"
     #{:applicationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/games/api/reference/rest/v1configuration/achievementConfigurations/update
  
  Required parameters: achievementId
  
  Optional parameters: none
  
  Body: 
  
  {:published {:kind string,
               :description LocalizedStringBundle,
               :pointValue integer,
               :sortRank integer,
               :name LocalizedStringBundle,
               :iconUrl string},
   :achievementType string,
   :kind string,
   :token string,
   :initialState string,
   :stepsToUnlock integer,
   :id string,
   :draft {:kind string,
           :description LocalizedStringBundle,
           :pointValue integer,
           :sortRank integer,
           :name LocalizedStringBundle,
           :iconUrl string}}
  
  Update the metadata of the achievement configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:achievementId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "games/v1configuration/achievements/{achievementId}"
     #{:achievementId}
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
