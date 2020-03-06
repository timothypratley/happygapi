(ns happygapi.gamesConfiguration.leaderboardConfigurations
  "Google Play Game Services Publishing API: leaderboardConfigurations.
  The Publishing API for Google Play Game Services.
  See: https://developers.google.com/games/servicesapi/reference/rest/v1configuration/leaderboardConfigurations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/leaderboardConfigurations/insert
  
  Required parameters: applicationId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :draft {:scoreFormat GamesNumberFormatConfiguration,
           :iconUrl string,
           :name LocalizedStringBundle,
           :sortRank integer,
           :kind string},
   :published {:scoreFormat GamesNumberFormatConfiguration,
               :iconUrl string,
               :name LocalizedStringBundle,
               :sortRank integer,
               :kind string},
   :token string,
   :kind string,
   :scoreMin string,
   :scoreMax string,
   :scoreOrder string}
  
  Insert a new leaderboard configuration in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:applicationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "applications/{applicationId}/leaderboards"
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
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/leaderboardConfigurations/get
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  Retrieves the metadata of the leaderboard configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:leaderboardId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "leaderboards/{leaderboardId}"
     #{:leaderboardId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/leaderboardConfigurations/patch
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :draft {:scoreFormat GamesNumberFormatConfiguration,
           :iconUrl string,
           :name LocalizedStringBundle,
           :sortRank integer,
           :kind string},
   :published {:scoreFormat GamesNumberFormatConfiguration,
               :iconUrl string,
               :name LocalizedStringBundle,
               :sortRank integer,
               :kind string},
   :token string,
   :kind string,
   :scoreMin string,
   :scoreMax string,
   :scoreOrder string}
  
  Update the metadata of the leaderboard configuration with the given ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:leaderboardId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "leaderboards/{leaderboardId}"
     #{:leaderboardId}
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
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/leaderboardConfigurations/update
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :draft {:scoreFormat GamesNumberFormatConfiguration,
           :iconUrl string,
           :name LocalizedStringBundle,
           :sortRank integer,
           :kind string},
   :published {:scoreFormat GamesNumberFormatConfiguration,
               :iconUrl string,
               :name LocalizedStringBundle,
               :sortRank integer,
               :kind string},
   :token string,
   :kind string,
   :scoreMin string,
   :scoreMax string,
   :scoreOrder string}
  
  Update the metadata of the leaderboard configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:leaderboardId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "leaderboards/{leaderboardId}"
     #{:leaderboardId}
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
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/leaderboardConfigurations/delete
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  Delete the leaderboard configuration with the given ID."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:leaderboardId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "leaderboards/{leaderboardId}"
     #{:leaderboardId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/leaderboardConfigurations/list
  
  Required parameters: applicationId
  
  Optional parameters: pageToken, maxResults
  Returns a list of the leaderboard configurations in this application."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "applications/{applicationId}/leaderboards"
     #{:applicationId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
