(ns happygapi.chat.rooms
  "Google Chat API: rooms.
  Enables bots to fetch information and perform actions in Google Chat. Authentication using a service account is a prerequisite for using the Google Chat REST API.
  See: https://developers.google.com/hangouts/chatapi/reference/rest/v1/rooms"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn messages$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/rooms/messages
  
  Required parameters: parent
  
  Optional parameters: threadKey
  
  Body: 
  
  {:space {:type string,
           :displayName string,
           :name string,
           :threaded boolean,
           :singleUserBotDm boolean},
   :fallbackText string,
   :name string,
   :createTime string,
   :previewText string,
   :argumentText string,
   :thread {:name string},
   :actionResponse {:type string, :url string},
   :sender {:type string,
            :name string,
            :domainId string,
            :displayName string,
            :isAnonymous boolean},
   :cards [{:cardActions [CardAction],
            :name string,
            :header CardHeader,
            :sections [Section]}],
   :annotations [{:startIndex integer,
                  :type string,
                  :slashCommand SlashCommandMetadata,
                  :length integer,
                  :userMention UserMentionMetadata}],
   :slashCommand {:commandId string},
   :cardsV2 [{:card GoogleAppsCardV1Card, :cardId string}],
   :attachment [{:source string,
                 :downloadUri string,
                 :driveDataRef DriveDataRef,
                 :attachmentDataRef AttachmentDataRef,
                 :contentName string,
                 :name string,
                 :thumbnailUri string,
                 :contentType string}],
   :text string}
  
  Legacy path for creating message. Calling these will result in a BadRequest response."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/messages"
     #{:parent}
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

(defn webhooks$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/rooms/webhooks
  
  Required parameters: parent
  
  Optional parameters: threadKey
  
  Body: 
  
  {:space {:type string,
           :displayName string,
           :name string,
           :threaded boolean,
           :singleUserBotDm boolean},
   :fallbackText string,
   :name string,
   :createTime string,
   :previewText string,
   :argumentText string,
   :thread {:name string},
   :actionResponse {:type string, :url string},
   :sender {:type string,
            :name string,
            :domainId string,
            :displayName string,
            :isAnonymous boolean},
   :cards [{:cardActions [CardAction],
            :name string,
            :header CardHeader,
            :sections [Section]}],
   :annotations [{:startIndex integer,
                  :type string,
                  :slashCommand SlashCommandMetadata,
                  :length integer,
                  :userMention UserMentionMetadata}],
   :slashCommand {:commandId string},
   :cardsV2 [{:card GoogleAppsCardV1Card, :cardId string}],
   :attachment [{:source string,
                 :downloadUri string,
                 :driveDataRef DriveDataRef,
                 :attachmentDataRef AttachmentDataRef,
                 :contentName string,
                 :name string,
                 :thumbnailUri string,
                 :contentType string}],
   :text string}
  
  Legacy path for creating message. Calling these will result in a BadRequest response."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/webhooks"
     #{:parent}
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

(defn conversations-messages$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/rooms/conversations/messages
  
  Required parameters: parent
  
  Optional parameters: threadKey
  
  Body: 
  
  {:space {:type string,
           :displayName string,
           :name string,
           :threaded boolean,
           :singleUserBotDm boolean},
   :fallbackText string,
   :name string,
   :createTime string,
   :previewText string,
   :argumentText string,
   :thread {:name string},
   :actionResponse {:type string, :url string},
   :sender {:type string,
            :name string,
            :domainId string,
            :displayName string,
            :isAnonymous boolean},
   :cards [{:cardActions [CardAction],
            :name string,
            :header CardHeader,
            :sections [Section]}],
   :annotations [{:startIndex integer,
                  :type string,
                  :slashCommand SlashCommandMetadata,
                  :length integer,
                  :userMention UserMentionMetadata}],
   :slashCommand {:commandId string},
   :cardsV2 [{:card GoogleAppsCardV1Card, :cardId string}],
   :attachment [{:source string,
                 :downloadUri string,
                 :driveDataRef DriveDataRef,
                 :attachmentDataRef AttachmentDataRef,
                 :contentName string,
                 :name string,
                 :thumbnailUri string,
                 :contentType string}],
   :text string}
  
  Legacy path for creating message. Calling these will result in a BadRequest response."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/messages"
     #{:parent}
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
