(ns happygapi.chat.spaces
  "Google Chat API: spaces.
  Enables bots to fetch information and perform actions in Google Chat. Authentication using a service account is a prerequisite for using the Google Chat REST API.
  See: https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn webhooks$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/webhooks
  
  Required parameters: parent
  
  Optional parameters: threadKey
  
  Body: 
  
  {:space {:type string,
           :displayName string,
           :singleUserBotDm boolean,
           :name string,
           :threaded boolean},
   :fallbackText string,
   :name string,
   :createTime string,
   :previewText string,
   :argumentText string,
   :thread {:name string},
   :actionResponse {:type string,
                    :dialogAction DialogAction,
                    :url string},
   :sender {:domainId string,
            :type string,
            :name string,
            :isAnonymous boolean,
            :displayName string},
   :cards [{:name string,
            :cardActions [CardAction],
            :sections [Section],
            :header CardHeader}],
   :lastUpdateTime string,
   :annotations [{:userMention UserMentionMetadata,
                  :startIndex integer,
                  :type string,
                  :slashCommand SlashCommandMetadata,
                  :length integer}],
   :slashCommand {:commandId string},
   :attachment [{:contentType string,
                 :thumbnailUri string,
                 :name string,
                 :downloadUri string,
                 :contentName string,
                 :source string,
                 :driveDataRef DriveDataRef,
                 :attachmentDataRef AttachmentDataRef}],
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

(defn get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a space."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Lists spaces the caller is a member of."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/spaces"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn members-get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/members/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a membership."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn members-list$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/members/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists human memberships in a space."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/members"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-delete$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a message."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a message."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-update$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/update
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:space {:type string,
           :displayName string,
           :singleUserBotDm boolean,
           :name string,
           :threaded boolean},
   :fallbackText string,
   :name string,
   :createTime string,
   :previewText string,
   :argumentText string,
   :thread {:name string},
   :actionResponse {:type string,
                    :dialogAction DialogAction,
                    :url string},
   :sender {:domainId string,
            :type string,
            :name string,
            :isAnonymous boolean,
            :displayName string},
   :cards [{:name string,
            :cardActions [CardAction],
            :sections [Section],
            :header CardHeader}],
   :lastUpdateTime string,
   :annotations [{:userMention UserMentionMetadata,
                  :startIndex integer,
                  :type string,
                  :slashCommand SlashCommandMetadata,
                  :length integer}],
   :slashCommand {:commandId string},
   :attachment [{:contentType string,
                 :thumbnailUri string,
                 :name string,
                 :downloadUri string,
                 :contentName string,
                 :source string,
                 :driveDataRef DriveDataRef,
                 :attachmentDataRef AttachmentDataRef}],
   :text string}
  
  Updates a message."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn messages-create$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/create
  
  Required parameters: parent
  
  Optional parameters: threadKey
  
  Body: 
  
  {:space {:type string,
           :displayName string,
           :singleUserBotDm boolean,
           :name string,
           :threaded boolean},
   :fallbackText string,
   :name string,
   :createTime string,
   :previewText string,
   :argumentText string,
   :thread {:name string},
   :actionResponse {:type string,
                    :dialogAction DialogAction,
                    :url string},
   :sender {:domainId string,
            :type string,
            :name string,
            :isAnonymous boolean,
            :displayName string},
   :cards [{:name string,
            :cardActions [CardAction],
            :sections [Section],
            :header CardHeader}],
   :lastUpdateTime string,
   :annotations [{:userMention UserMentionMetadata,
                  :startIndex integer,
                  :type string,
                  :slashCommand SlashCommandMetadata,
                  :length integer}],
   :slashCommand {:commandId string},
   :attachment [{:contentType string,
                 :thumbnailUri string,
                 :name string,
                 :downloadUri string,
                 :contentName string,
                 :source string,
                 :driveDataRef DriveDataRef,
                 :attachmentDataRef AttachmentDataRef}],
   :text string}
  
  Creates a message."
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

(defn messages-attachments-get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/attachments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the metadata of a message attachment. The attachment data is fetched using the media API."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
