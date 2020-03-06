(ns happygapi.gamesConfiguration.achievementConfigurations
  "Google Play Game Services Publishing API: achievementConfigurations.
  The Publishing API for Google Play Game Services.
  See: https://developers.google.com/games/servicesapi/reference/rest/v1configuration/achievementConfigurations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/achievementConfigurations/list
  
  Required parameters: applicationId
  
  Optional parameters: maxResults, pageToken
  Returns a list of the achievement configurations in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "applications/{applicationId}/achievements"
     #{:applicationId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/achievementConfigurations/insert
  
  Required parameters: applicationId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :draft {:pointValue integer,
           :name LocalizedStringBundle,
           :sortRank integer,
           :iconUrl string,
           :description LocalizedStringBundle,
           :kind string},
   :published {:pointValue integer,
               :name LocalizedStringBundle,
               :sortRank integer,
               :iconUrl string,
               :description LocalizedStringBundle,
               :kind string},
   :achievementType string,
   :token string,
   :kind string,
   :initialState string,
   :stepsToUnlock integer}
  
  Insert a new achievement configuration in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:applicationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "applications/{applicationId}/achievements"
     #{:applicationId}
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

(defn get$
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/achievementConfigurations/get
  
  Required parameters: achievementId
  
  Optional parameters: none
  Retrieves the metadata of the achievement configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:achievementId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "achievements/{achievementId}"
     #{:achievementId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/achievementConfigurations/patch
  
  Required parameters: achievementId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :draft {:pointValue integer,
           :name LocalizedStringBundle,
           :sortRank integer,
           :iconUrl string,
           :description LocalizedStringBundle,
           :kind string},
   :published {:pointValue integer,
               :name LocalizedStringBundle,
               :sortRank integer,
               :iconUrl string,
               :description LocalizedStringBundle,
               :kind string},
   :achievementType string,
   :token string,
   :kind string,
   :initialState string,
   :stepsToUnlock integer}
  
  Update the metadata of the achievement configuration with the given ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:achievementId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "achievements/{achievementId}"
     #{:achievementId}
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
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/achievementConfigurations/update
  
  Required parameters: achievementId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :draft {:pointValue integer,
           :name LocalizedStringBundle,
           :sortRank integer,
           :iconUrl string,
           :description LocalizedStringBundle,
           :kind string},
   :published {:pointValue integer,
               :name LocalizedStringBundle,
               :sortRank integer,
               :iconUrl string,
               :description LocalizedStringBundle,
               :kind string},
   :achievementType string,
   :token string,
   :kind string,
   :initialState string,
   :stepsToUnlock integer}
  
  Update the metadata of the achievement configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:achievementId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "achievements/{achievementId}"
     #{:achievementId}
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

(defn delete$
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/achievementConfigurations/delete
  
  Required parameters: achievementId
  
  Optional parameters: none
  Delete the achievement configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:achievementId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "achievements/{achievementId}"
     #{:achievementId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
