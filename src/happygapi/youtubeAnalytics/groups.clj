(ns happygapi.youtubeAnalytics.groups
  "YouTube Analytics API: groups.
  Retrieves your YouTube Analytics data.
  See: https://developers.google.com/youtube/analyticsdocs/reference/rest/v2/groups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/analyticsapi/reference/rest/v2/groups/list
  
  Required parameters: none
  
  Optional parameters: pageToken, mine, onBehalfOfContentOwner, id
  
  Returns a collection of groups that match the API request parameters. For example, you can retrieve all groups that the authenticated user owns, or you can retrieve one or more groups by their unique IDs."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubeanalytics.googleapis.com/"
     "v2/groups"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/analyticsapi/reference/rest/v2/groups/insert
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:etag string,
   :id string,
   :snippet {:publishedAt string, :title string},
   :errors {:error [ErrorProto], :code string, :requestId string},
   :kind string,
   :contentDetails {:itemCount string, :itemType string}}
  
  Creates a group."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtubeanalytics.googleapis.com/"
     "v2/groups"
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

(defn update$
  "https://developers.google.com/youtube/analyticsapi/reference/rest/v2/groups/update
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:etag string,
   :id string,
   :snippet {:publishedAt string, :title string},
   :errors {:error [ErrorProto], :code string, :requestId string},
   :kind string,
   :contentDetails {:itemCount string, :itemType string}}
  
  Modifies a group. For example, you could change a group's title."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtubeanalytics.googleapis.com/"
     "v2/groups"
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

(defn delete$
  "https://developers.google.com/youtube/analyticsapi/reference/rest/v2/groups/delete
  
  Required parameters: none
  
  Optional parameters: id, onBehalfOfContentOwner
  
  Deletes a group."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtubeanalytics.googleapis.com/"
     "v2/groups"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
