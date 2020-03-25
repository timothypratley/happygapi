(ns happygapi.youtube.videos
  "YouTube Data API: videos.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/videos"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/videos/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner
  
  Deletes a YouTube video."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getRating$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/videos/getRating
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner
  
  Retrieves the ratings that the authorized user gave to a list of specified videos."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos/getRating"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/videos/insert
  
  Required parameters: part
  
  Optional parameters: autoLevels, notifySubscribers, onBehalfOfContentOwner, onBehalfOfContentOwnerChannel, stabilize
  
  Body: 
  
  {:monetizationDetails {:access AccessPolicy},
   :localizations {},
   :snippet {:description string,
             :tags [string],
             :publishedAt string,
             :channelId string,
             :categoryId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :defaultAudioLanguage string,
             :liveBroadcastContent string,
             :localized VideoLocalization,
             :channelTitle string,
             :defaultLanguage string},
   :fileDetails {:creationTime string,
                 :fileSize string,
                 :fileType string,
                 :fileName string,
                 :bitrateBps string,
                 :videoStreams [VideoFileDetailsVideoStream],
                 :container string,
                 :durationMs string,
                 :audioStreams [VideoFileDetailsAudioStream]},
   :etag string,
   :recordingDetails {:location GeoPoint,
                      :locationDescription string,
                      :recordingDate string},
   :statistics {:commentCount string,
                :dislikeCount string,
                :favoriteCount string,
                :likeCount string,
                :viewCount string},
   :ageGating {:alcoholContent boolean,
               :restricted boolean,
               :videoGameRating string},
   :status {:uploadStatus string,
            :publicStatsViewable boolean,
            :license string,
            :embeddable boolean,
            :publishAt string,
            :madeForKids boolean,
            :privacyStatus string,
            :failureReason string,
            :rejectionReason string,
            :selfDeclaredMadeForKids boolean},
   :processingDetails {:editorSuggestionsAvailability string,
                       :fileDetailsAvailability string,
                       :processingFailureReason string,
                       :processingIssuesAvailability string,
                       :processingProgress VideoProcessingDetailsProcessingProgress,
                       :processingStatus string,
                       :tagSuggestionsAvailability string,
                       :thumbnailsAvailability string},
   :id string,
   :kind string,
   :liveStreamingDetails {:activeLiveChatId string,
                          :actualEndTime string,
                          :actualStartTime string,
                          :concurrentViewers string,
                          :scheduledEndTime string,
                          :scheduledStartTime string},
   :suggestions {:editorSuggestions [string],
                 :processingErrors [string],
                 :processingHints [string],
                 :processingWarnings [string],
                 :tagSuggestions [VideoSuggestionsTagSuggestion]},
   :contentDetails {:caption string,
                    :definition string,
                    :licensedContent boolean,
                    :duration string,
                    :contentRating ContentRating,
                    :countryRestriction AccessPolicy,
                    :regionRestriction VideoContentDetailsRegionRestriction,
                    :dimension string,
                    :projection string,
                    :hasCustomThumbnail boolean},
   :player {:embedHeight string, :embedHtml string, :embedWidth string},
   :projectDetails {:tags [string]},
   :topicDetails {:relevantTopicIds [string],
                  :topicCategories [string],
                  :topicIds [string]}}
  
  Uploads a video to YouTube and optionally sets the video's metadata."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.upload"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos"
     #{:part}
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/videos/list
  
  Required parameters: part
  
  Optional parameters: maxHeight, maxWidth, locale, pageToken, chart, hl, id, regionCode, myRating, onBehalfOfContentOwner, maxResults, videoCategoryId
  
  Returns a list of videos that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rate$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/videos/rate
  
  Required parameters: id, rating
  
  Optional parameters: none
  
  Add a like or dislike rating to a video or remove a rating from a video."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :rating})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos/rate"
     #{:id :rating}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reportAbuse$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/videos/reportAbuse
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:comments string,
   :language string,
   :reasonId string,
   :secondaryReasonId string,
   :videoId string}
  
  Report abuse for a video."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos/reportAbuse"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/videos/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:monetizationDetails {:access AccessPolicy},
   :localizations {},
   :snippet {:description string,
             :tags [string],
             :publishedAt string,
             :channelId string,
             :categoryId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :defaultAudioLanguage string,
             :liveBroadcastContent string,
             :localized VideoLocalization,
             :channelTitle string,
             :defaultLanguage string},
   :fileDetails {:creationTime string,
                 :fileSize string,
                 :fileType string,
                 :fileName string,
                 :bitrateBps string,
                 :videoStreams [VideoFileDetailsVideoStream],
                 :container string,
                 :durationMs string,
                 :audioStreams [VideoFileDetailsAudioStream]},
   :etag string,
   :recordingDetails {:location GeoPoint,
                      :locationDescription string,
                      :recordingDate string},
   :statistics {:commentCount string,
                :dislikeCount string,
                :favoriteCount string,
                :likeCount string,
                :viewCount string},
   :ageGating {:alcoholContent boolean,
               :restricted boolean,
               :videoGameRating string},
   :status {:uploadStatus string,
            :publicStatsViewable boolean,
            :license string,
            :embeddable boolean,
            :publishAt string,
            :madeForKids boolean,
            :privacyStatus string,
            :failureReason string,
            :rejectionReason string,
            :selfDeclaredMadeForKids boolean},
   :processingDetails {:editorSuggestionsAvailability string,
                       :fileDetailsAvailability string,
                       :processingFailureReason string,
                       :processingIssuesAvailability string,
                       :processingProgress VideoProcessingDetailsProcessingProgress,
                       :processingStatus string,
                       :tagSuggestionsAvailability string,
                       :thumbnailsAvailability string},
   :id string,
   :kind string,
   :liveStreamingDetails {:activeLiveChatId string,
                          :actualEndTime string,
                          :actualStartTime string,
                          :concurrentViewers string,
                          :scheduledEndTime string,
                          :scheduledStartTime string},
   :suggestions {:editorSuggestions [string],
                 :processingErrors [string],
                 :processingHints [string],
                 :processingWarnings [string],
                 :tagSuggestions [VideoSuggestionsTagSuggestion]},
   :contentDetails {:caption string,
                    :definition string,
                    :licensedContent boolean,
                    :duration string,
                    :contentRating ContentRating,
                    :countryRestriction AccessPolicy,
                    :regionRestriction VideoContentDetailsRegionRestriction,
                    :dimension string,
                    :projection string,
                    :hasCustomThumbnail boolean},
   :player {:embedHeight string, :embedHtml string, :embedWidth string},
   :projectDetails {:tags [string]},
   :topicDetails {:relevantTopicIds [string],
                  :topicCategories [string],
                  :topicIds [string]}}
  
  Updates a video's metadata."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "videos"
     #{:part}
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
