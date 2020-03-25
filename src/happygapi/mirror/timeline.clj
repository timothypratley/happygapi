(ns happygapi.mirror.timeline
  "Google Mirror API: timeline.
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glassapi/reference/rest/v1/timeline"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Deletes a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/get
  
  Required parameters: id
  
  Optional parameters: none
  
  Gets a single timeline item by ID."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{id}"
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
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:isDeleted boolean,
   :creator {:displayName string,
             :speakableName string,
             :sharingFeatures [string],
             :acceptCommands [Command],
             :type string,
             :source string,
             :acceptTypes [string],
             :imageUrls [string],
             :priority integer,
             :id string,
             :kind string,
             :phoneNumber string},
   :menuItems [{:action string,
                :contextual_command string,
                :id string,
                :payload string,
                :removeWhenSelected boolean,
                :values [MenuValue]}],
   :inReplyTo string,
   :pinScore integer,
   :notification {:deliveryTime string, :level string},
   :updated string,
   :attachments [{:contentType string,
                  :contentUrl string,
                  :id string,
                  :isProcessingContent boolean}],
   :speakableType string,
   :selfLink string,
   :etag string,
   :created string,
   :bundleId string,
   :recipients [{:displayName string,
                 :speakableName string,
                 :sharingFeatures [string],
                 :acceptCommands [Command],
                 :type string,
                 :source string,
                 :acceptTypes [string],
                 :imageUrls [string],
                 :priority integer,
                 :id string,
                 :kind string,
                 :phoneNumber string}],
   :title string,
   :displayTime string,
   :speakableText string,
   :sourceItemId string,
   :id string,
   :kind string,
   :isBundleCover boolean,
   :location {:accuracy number,
              :address string,
              :displayName string,
              :id string,
              :kind string,
              :latitude number,
              :longitude number,
              :timestamp string},
   :isPinned boolean,
   :html string,
   :text string,
   :canonicalUrl string}
  
  Inserts a new item into the timeline."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline"
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

(defn list$
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/list
  
  Required parameters: none
  
  Optional parameters: bundleId, includeDeleted, maxResults, orderBy, pageToken, pinnedOnly, sourceItemId
  
  Retrieves a list of timeline items for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/patch
  
  Required parameters: id
  
  Optional parameters: none
  
  Body: 
  
  {:isDeleted boolean,
   :creator {:displayName string,
             :speakableName string,
             :sharingFeatures [string],
             :acceptCommands [Command],
             :type string,
             :source string,
             :acceptTypes [string],
             :imageUrls [string],
             :priority integer,
             :id string,
             :kind string,
             :phoneNumber string},
   :menuItems [{:action string,
                :contextual_command string,
                :id string,
                :payload string,
                :removeWhenSelected boolean,
                :values [MenuValue]}],
   :inReplyTo string,
   :pinScore integer,
   :notification {:deliveryTime string, :level string},
   :updated string,
   :attachments [{:contentType string,
                  :contentUrl string,
                  :id string,
                  :isProcessingContent boolean}],
   :speakableType string,
   :selfLink string,
   :etag string,
   :created string,
   :bundleId string,
   :recipients [{:displayName string,
                 :speakableName string,
                 :sharingFeatures [string],
                 :acceptCommands [Command],
                 :type string,
                 :source string,
                 :acceptTypes [string],
                 :imageUrls [string],
                 :priority integer,
                 :id string,
                 :kind string,
                 :phoneNumber string}],
   :title string,
   :displayTime string,
   :speakableText string,
   :sourceItemId string,
   :id string,
   :kind string,
   :isBundleCover boolean,
   :location {:accuracy number,
              :address string,
              :displayName string,
              :id string,
              :kind string,
              :latitude number,
              :longitude number,
              :timestamp string},
   :isPinned boolean,
   :html string,
   :text string,
   :canonicalUrl string}
  
  Updates a timeline item in place. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{id}"
     #{:id}
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
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/update
  
  Required parameters: id
  
  Optional parameters: none
  
  Body: 
  
  {:isDeleted boolean,
   :creator {:displayName string,
             :speakableName string,
             :sharingFeatures [string],
             :acceptCommands [Command],
             :type string,
             :source string,
             :acceptTypes [string],
             :imageUrls [string],
             :priority integer,
             :id string,
             :kind string,
             :phoneNumber string},
   :menuItems [{:action string,
                :contextual_command string,
                :id string,
                :payload string,
                :removeWhenSelected boolean,
                :values [MenuValue]}],
   :inReplyTo string,
   :pinScore integer,
   :notification {:deliveryTime string, :level string},
   :updated string,
   :attachments [{:contentType string,
                  :contentUrl string,
                  :id string,
                  :isProcessingContent boolean}],
   :speakableType string,
   :selfLink string,
   :etag string,
   :created string,
   :bundleId string,
   :recipients [{:displayName string,
                 :speakableName string,
                 :sharingFeatures [string],
                 :acceptCommands [Command],
                 :type string,
                 :source string,
                 :acceptTypes [string],
                 :imageUrls [string],
                 :priority integer,
                 :id string,
                 :kind string,
                 :phoneNumber string}],
   :title string,
   :displayTime string,
   :speakableText string,
   :sourceItemId string,
   :id string,
   :kind string,
   :isBundleCover boolean,
   :location {:accuracy number,
              :address string,
              :displayName string,
              :id string,
              :kind string,
              :latitude number,
              :longitude number,
              :timestamp string},
   :isPinned boolean,
   :html string,
   :text string,
   :canonicalUrl string}
  
  Updates a timeline item in place."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{id}"
     #{:id}
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

(defn attachments-delete$
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/attachments/delete
  
  Required parameters: attachmentId, itemId
  
  Optional parameters: none
  
  Deletes an attachment from a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:attachmentId :itemId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{itemId}/attachments/{attachmentId}"
     #{:attachmentId :itemId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn attachments-get$
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/attachments/get
  
  Required parameters: attachmentId, itemId
  
  Optional parameters: none
  
  Retrieves an attachment on a timeline item by item ID and attachment ID."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:attachmentId :itemId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{itemId}/attachments/{attachmentId}"
     #{:attachmentId :itemId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn attachments-insert$
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/attachments/insert
  
  Required parameters: itemId
  
  Optional parameters: none
  
  Adds a new attachment to a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:itemId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{itemId}/attachments"
     #{:itemId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn attachments-list$
  "https://developers.google.com/glassapi/reference/rest/v1/timeline/attachments/list
  
  Required parameters: itemId
  
  Optional parameters: none
  
  Returns a list of attachments for a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:itemId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{itemId}/attachments"
     #{:itemId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
