(ns happygapi.gamesConfiguration.leaderboardConfigurations
  "Google Play Game Services Publishing API: leaderboardConfigurations.
  The Google Play Game Services Publishing API allows developers to configure their games in Game Services.
  See: https://developers.google.com/games/api/reference/rest/v1configuration/leaderboardConfigurations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/games/api/reference/rest/v1configuration/leaderboardConfigurations/insert
  
  Required parameters: applicationId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :kind string,
   :scoreMin string,
   :draft {:kind string,
           :name LocalizedStringBundle,
           :sortRank integer,
           :scoreFormat GamesNumberFormatConfiguration,
           :iconUrl string},
   :published {:kind string,
               :name LocalizedStringBundle,
               :sortRank integer,
               :scoreFormat GamesNumberFormatConfiguration,
               :iconUrl string},
   :token string,
   :scoreOrder string,
   :scoreMax string}
  
  Insert a new leaderboard configuration in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/applications/{applicationId}/leaderboards"
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

(defn delete$
  "https://developers.google.com/games/api/reference/rest/v1configuration/leaderboardConfigurations/delete
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Delete the leaderboard configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:leaderboardId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/leaderboards/{leaderboardId}"
     #{:leaderboardId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/api/reference/rest/v1configuration/leaderboardConfigurations/list
  
  Required parameters: applicationId
  
  Optional parameters: pageToken, maxResults
  
  Returns a list of the leaderboard configurations in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/applications/{applicationId}/leaderboards"
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
  "https://developers.google.com/games/api/reference/rest/v1configuration/leaderboardConfigurations/update
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :kind string,
   :scoreMin string,
   :draft {:kind string,
           :name LocalizedStringBundle,
           :sortRank integer,
           :scoreFormat GamesNumberFormatConfiguration,
           :iconUrl string},
   :published {:kind string,
               :name LocalizedStringBundle,
               :sortRank integer,
               :scoreFormat GamesNumberFormatConfiguration,
               :iconUrl string},
   :token string,
   :scoreOrder string,
   :scoreMax string}
  
  Update the metadata of the leaderboard configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:leaderboardId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/leaderboards/{leaderboardId}"
     #{:leaderboardId}
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
  "https://developers.google.com/games/api/reference/rest/v1configuration/leaderboardConfigurations/get
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Retrieves the metadata of the leaderboard configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:leaderboardId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/leaderboards/{leaderboardId}"
     #{:leaderboardId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
