(ns happygapi.chat.spaces
  "Google Chat API: spaces.
  The Google Chat API lets you build Chat apps to integrate your services with Google Chat and manage Chat resources such as spaces, members, and messages.
  See: https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists spaces the caller is a member of. Group chats and DMs aren't listed until the first message is sent. For an example, see [List spaces](https://developers.google.com/chat/api/guides/v1/spaces/list). Requires [authentication](https://developers.google.com/chat/api/guides/auth). Supports [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts) and [user authentication](https://developers.google.com/chat/api/guides/auth/users). Lists spaces visible to the caller or authenticated user. Group chats and DMs aren't listed until the first message is sent."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.readonly"]}
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

(defn get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns details about a space. For an example, see [Get a space](https://developers.google.com/chat/api/guides/v1/spaces/get). Requires [authentication](https://developers.google.com/chat/api/guides/auth). Supports [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts) and [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.readonly"]}
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

(defn create$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/create
  
  Required parameters: none
  
  Optional parameters: requestId
  
  Body: 
  
  {:spaceDetails {:description string, :guidelines string},
   :importMode boolean,
   :adminInstalled boolean,
   :displayName string,
   :name string,
   :createTime string,
   :type string,
   :threaded boolean,
   :externalUserAllowed boolean,
   :singleUserBotDm boolean,
   :spaceType string,
   :spaceThreadingState string,
   :spaceHistoryState string}
  
  Creates a named space. Spaces grouped by topics aren't supported. For an example, see [Create a space](https://developers.google.com/chat/api/guides/v1/spaces/create). If you receive the error message `ALREADY_EXISTS` when creating a space, try a different `displayName`. An existing space within the Google Workspace organization might already use this display name. Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.create"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/spaces"
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

(defn setup$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/setup
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:space {:spaceDetails SpaceDetails,
           :importMode boolean,
           :adminInstalled boolean,
           :displayName string,
           :name string,
           :createTime string,
           :type string,
           :threaded boolean,
           :externalUserAllowed boolean,
           :singleUserBotDm boolean,
           :spaceType string,
           :spaceThreadingState string,
           :spaceHistoryState string},
   :requestId string,
   :memberships [{:name string,
                  :state string,
                  :role string,
                  :member User,
                  :groupMember Group,
                  :createTime string,
                  :deleteTime string}]}
  
  Creates a space and adds specified users to it. The calling user is automatically added to the space, and shouldn't be specified as a membership in the request. For an example, see [Set up a space](https://developers.google.com/chat/api/guides/v1/spaces/set-up). To specify the human members to add, add memberships with the appropriate `member.name` in the `SetUpSpaceRequest`. To add a human user, use `users/{user}`, where `{user}` can be the email address for the user. For users in the same Workspace organization `{user}` can also be the `id` for the person from the People API, or the `id` for the user in the Directory API. For example, if the People API Person profile ID for `user@example.com` is `123456789`, you can add the user to the space by setting the `membership.member.name` to `users/user@example.com` or `users/123456789`. For a space or group chat, if the caller blocks or is blocked by some members, then those members aren't added to the created space. To create a direct message (DM) between the calling user and another human user, specify exactly one membership to represent the human user. If one user blocks the other, the request fails and the DM isn't created. To create a DM between the calling user and the calling app, set `Space.singleUserBotDm` to `true` and don't specify any memberships. You can only use this method to set up a DM with the calling app. To add the calling app as a member of a space or an existing DM between two human users, see [create a membership](https://developers.google.com/chat/api/guides/v1/members/create). If a DM already exists between two users, even when one user blocks the other at the time a request is made, then the existing DM is returned. Spaces with threaded replies aren't supported. If you receive the error message `ALREADY_EXISTS` when setting up a space, try a different `displayName`. An existing space within the Google Workspace organization might already use this display name. Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.create"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/spaces:setup"
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

(defn patch$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:spaceDetails {:description string, :guidelines string},
   :importMode boolean,
   :adminInstalled boolean,
   :displayName string,
   :name string,
   :createTime string,
   :type string,
   :threaded boolean,
   :externalUserAllowed boolean,
   :singleUserBotDm boolean,
   :spaceType string,
   :spaceThreadingState string,
   :spaceHistoryState string}
  
  Updates a space. For an example, see [Update a space](https://developers.google.com/chat/api/guides/v1/spaces/update). If you're updating the `displayName` field and receive the error message `ALREADY_EXISTS`, try a different display name.. An existing space within the Google Workspace organization might already use this display name. Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.spaces"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
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

(defn delete$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a named space. Always performs a cascading delete, which means that the space's child resources—like messages posted in the space and memberships in the space—are also deleted. For an example, see [Delete a space](https://developers.google.com/chat/api/guides/v1/spaces/delete). Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users) from a user who has permission to delete the space."
  {:scopes ["https://www.googleapis.com/auth/chat.delete"
            "https://www.googleapis.com/auth/chat.import"]}
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

(defn completeImport$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/completeImport
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Completes the [import process](https://developers.google.com/chat/api/guides/import-data) for the specified space and makes it visible to users. Requires app authentication and domain-wide delegation. For more information, see [Authorize Google Chat apps to import data](https://developers.google.com/chat/api/guides/authorize-import)."
  {:scopes ["https://www.googleapis.com/auth/chat.import"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}:completeImport"
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

(defn findDirectMessage$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/findDirectMessage
  
  Required parameters: none
  
  Optional parameters: name
  
  Returns the existing direct message with the specified user. If no direct message space is found, returns a `404 NOT_FOUND` error. For an example, see [Find a direct message](/chat/api/guides/v1/spaces/find-direct-message). With [user authentication](https://developers.google.com/chat/api/guides/auth/users), returns the direct message space between the specified user and the authenticated user. With [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts), returns the direct message space between the specified user and the calling Chat app. Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users) or [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts)."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/spaces:findDirectMessage"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-create$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/create
  
  Required parameters: parent
  
  Optional parameters: threadKey, requestId, messageReplyOption, messageId
  
  Body: 
  
  {:attachedGifs [{:uri string}],
   :threadReply boolean,
   :space {:spaceDetails SpaceDetails,
           :importMode boolean,
           :adminInstalled boolean,
           :displayName string,
           :name string,
           :createTime string,
           :type string,
           :threaded boolean,
           :externalUserAllowed boolean,
           :singleUserBotDm boolean,
           :spaceType string,
           :spaceThreadingState string,
           :spaceHistoryState string},
   :deleteTime string,
   :deletionMetadata {:deletionType string},
   :fallbackText string,
   :quotedMessageMetadata {:name string, :lastUpdateTime string},
   :name string,
   :createTime string,
   :argumentText string,
   :emojiReactionSummaries [{:emoji Emoji, :reactionCount integer}],
   :matchedUrl {:url string},
   :thread {:name string, :threadKey string},
   :actionResponse {:type string,
                    :url string,
                    :dialogAction DialogAction,
                    :updatedWidget UpdatedWidget},
   :sender {:name string,
            :displayName string,
            :domainId string,
            :type string,
            :isAnonymous boolean},
   :cards [{:header CardHeader,
            :sections [Section],
            :cardActions [CardAction],
            :name string}],
   :lastUpdateTime string,
   :privateMessageViewer {:name string,
                          :displayName string,
                          :domainId string,
                          :type string,
                          :isAnonymous boolean},
   :formattedText string,
   :annotations [{:type string,
                  :startIndex integer,
                  :length integer,
                  :userMention UserMentionMetadata,
                  :slashCommand SlashCommandMetadata,
                  :richLinkMetadata RichLinkMetadata}],
   :slashCommand {:commandId string},
   :cardsV2 [{:cardId string, :card GoogleAppsCardV1Card}],
   :clientAssignedMessageId string,
   :attachment [{:name string,
                 :contentName string,
                 :contentType string,
                 :attachmentDataRef AttachmentDataRef,
                 :driveDataRef DriveDataRef,
                 :thumbnailUri string,
                 :downloadUri string,
                 :source string}],
   :text string}
  
  Creates a message in a Google Chat space. For an example, see [Create a message](https://developers.google.com/chat/api/guides/v1/messages/create). Calling this method requires [authentication](https://developers.google.com/chat/api/guides/auth) and supports the following authentication types: - For text messages, user authentication or app authentication are supported. - For card messages, only app authentication is supported. (Only Chat apps can create card messages.)"
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.create"]}
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

(defn messages-list$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy, showDeleted
  
  Lists messages in a space that the caller is a member of, including messages from blocked members and spaces. For an example, see [List messages](/chat/api/guides/v1/messages/list). Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/messages"
     #{:parent}
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
  
  Returns details about a message. For an example, see [Read a message](https://developers.google.com/chat/api/guides/v1/messages/get). Requires [authentication](https://developers.google.com/chat/api/guides/auth). Supports [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts) and [user authentication](https://developers.google.com/chat/api/guides/auth/users). Note: Might return a message from a blocked member or space."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.readonly"]}
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
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:attachedGifs [{:uri string}],
   :threadReply boolean,
   :space {:spaceDetails SpaceDetails,
           :importMode boolean,
           :adminInstalled boolean,
           :displayName string,
           :name string,
           :createTime string,
           :type string,
           :threaded boolean,
           :externalUserAllowed boolean,
           :singleUserBotDm boolean,
           :spaceType string,
           :spaceThreadingState string,
           :spaceHistoryState string},
   :deleteTime string,
   :deletionMetadata {:deletionType string},
   :fallbackText string,
   :quotedMessageMetadata {:name string, :lastUpdateTime string},
   :name string,
   :createTime string,
   :argumentText string,
   :emojiReactionSummaries [{:emoji Emoji, :reactionCount integer}],
   :matchedUrl {:url string},
   :thread {:name string, :threadKey string},
   :actionResponse {:type string,
                    :url string,
                    :dialogAction DialogAction,
                    :updatedWidget UpdatedWidget},
   :sender {:name string,
            :displayName string,
            :domainId string,
            :type string,
            :isAnonymous boolean},
   :cards [{:header CardHeader,
            :sections [Section],
            :cardActions [CardAction],
            :name string}],
   :lastUpdateTime string,
   :privateMessageViewer {:name string,
                          :displayName string,
                          :domainId string,
                          :type string,
                          :isAnonymous boolean},
   :formattedText string,
   :annotations [{:type string,
                  :startIndex integer,
                  :length integer,
                  :userMention UserMentionMetadata,
                  :slashCommand SlashCommandMetadata,
                  :richLinkMetadata RichLinkMetadata}],
   :slashCommand {:commandId string},
   :cardsV2 [{:cardId string, :card GoogleAppsCardV1Card}],
   :clientAssignedMessageId string,
   :attachment [{:name string,
                 :contentName string,
                 :contentType string,
                 :attachmentDataRef AttachmentDataRef,
                 :driveDataRef DriveDataRef,
                 :thumbnailUri string,
                 :downloadUri string,
                 :source string}],
   :text string}
  
  Updates a message. There's a difference between the `patch` and `update` methods. The `patch` method uses a `patch` request while the `update` method uses a `put` request. We recommend using the `patch` method. For an example, see [Update a message](https://developers.google.com/chat/api/guides/v1/messages/update). Requires [authentication](https://developers.google.com/chat/api/guides/auth). Supports [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts) and [user authentication](https://developers.google.com/chat/api/guides/auth/users). When using app authentication, requests can only update messages created by the calling Chat app."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.messages"]}
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

(defn messages-patch$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:attachedGifs [{:uri string}],
   :threadReply boolean,
   :space {:spaceDetails SpaceDetails,
           :importMode boolean,
           :adminInstalled boolean,
           :displayName string,
           :name string,
           :createTime string,
           :type string,
           :threaded boolean,
           :externalUserAllowed boolean,
           :singleUserBotDm boolean,
           :spaceType string,
           :spaceThreadingState string,
           :spaceHistoryState string},
   :deleteTime string,
   :deletionMetadata {:deletionType string},
   :fallbackText string,
   :quotedMessageMetadata {:name string, :lastUpdateTime string},
   :name string,
   :createTime string,
   :argumentText string,
   :emojiReactionSummaries [{:emoji Emoji, :reactionCount integer}],
   :matchedUrl {:url string},
   :thread {:name string, :threadKey string},
   :actionResponse {:type string,
                    :url string,
                    :dialogAction DialogAction,
                    :updatedWidget UpdatedWidget},
   :sender {:name string,
            :displayName string,
            :domainId string,
            :type string,
            :isAnonymous boolean},
   :cards [{:header CardHeader,
            :sections [Section],
            :cardActions [CardAction],
            :name string}],
   :lastUpdateTime string,
   :privateMessageViewer {:name string,
                          :displayName string,
                          :domainId string,
                          :type string,
                          :isAnonymous boolean},
   :formattedText string,
   :annotations [{:type string,
                  :startIndex integer,
                  :length integer,
                  :userMention UserMentionMetadata,
                  :slashCommand SlashCommandMetadata,
                  :richLinkMetadata RichLinkMetadata}],
   :slashCommand {:commandId string},
   :cardsV2 [{:cardId string, :card GoogleAppsCardV1Card}],
   :clientAssignedMessageId string,
   :attachment [{:name string,
                 :contentName string,
                 :contentType string,
                 :attachmentDataRef AttachmentDataRef,
                 :driveDataRef DriveDataRef,
                 :thumbnailUri string,
                 :downloadUri string,
                 :source string}],
   :text string}
  
  Updates a message. There's a difference between the `patch` and `update` methods. The `patch` method uses a `patch` request while the `update` method uses a `put` request. We recommend using the `patch` method. For an example, see [Update a message](https://developers.google.com/chat/api/guides/v1/messages/update). Requires [authentication](https://developers.google.com/chat/api/guides/auth). Supports [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts) and [user authentication](https://developers.google.com/chat/api/guides/auth/users). When using app authentication, requests can only update messages created by the calling Chat app."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.messages"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
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

(defn messages-delete$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a message. For an example, see [Delete a message](https://developers.google.com/chat/api/guides/v1/messages/delete). Requires [authentication](https://developers.google.com/chat/api/guides/auth). Supports [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts) and [user authentication](https://developers.google.com/chat/api/guides/auth/users). When using app authentication, requests can only delete messages created by the calling Chat app."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.messages"]}
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

(defn messages-attachments-get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/attachments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the metadata of a message attachment. The attachment data is fetched using the [media API](https://developers.google.com/chat/api/reference/rest/v1/media/download). For an example, see [Get a message attachment](https://developers.google.com/chat/api/guides/v1/media-and-attachments/get). Requires [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts)."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"]}
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

(defn messages-reactions-create$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/reactions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :user {:name string,
          :displayName string,
          :domainId string,
          :type string,
          :isAnonymous boolean},
   :emoji {:unicode string, :customEmoji CustomEmoji}}
  
  Creates a reaction and adds it to a message. For an example, see [Create a reaction](https://developers.google.com/chat/api/guides/v1/reactions/create). Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users). Only unicode emoji are supported."
  {:scopes ["https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.reactions"
            "https://www.googleapis.com/auth/chat.messages.reactions.create"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/reactions"
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

(defn messages-reactions-list$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/reactions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists reactions to a message. For an example, see [List reactions](https://developers.google.com/chat/api/guides/v1/reactions/list). Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.reactions"
            "https://www.googleapis.com/auth/chat.messages.reactions.readonly"
            "https://www.googleapis.com/auth/chat.messages.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/reactions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-reactions-delete$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/reactions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a reaction to a message. For an example, see [Delete a reaction](https://developers.google.com/chat/api/guides/v1/reactions/delete). Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.reactions"]}
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

(defn members-list$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/members/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, showGroups, showInvited
  
  Lists memberships in a space. For an example, see [List memberships](https://developers.google.com/chat/api/guides/v1/members/list). Listing memberships with [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts) lists memberships in spaces that the Chat app has access to, but excludes Chat app memberships, including its own. Listing memberships with [User authentication](https://developers.google.com/chat/api/guides/auth/users) lists memberships in spaces that the authenticated user has access to. Requires [authentication](https://developers.google.com/chat/api/guides/auth). Supports [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts) and [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.readonly"]}
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

(defn members-get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/members/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns details about a membership. For an example, see [Get a membership](https://developers.google.com/chat/api/guides/v1/members/get). Requires [authentication](https://developers.google.com/chat/api/guides/auth). Supports [app authentication](https://developers.google.com/chat/api/guides/auth/service-accounts) and [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.readonly"]}
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

(defn members-create$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/members/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :state string,
   :role string,
   :member {:name string,
            :displayName string,
            :domainId string,
            :type string,
            :isAnonymous boolean},
   :groupMember {:name string},
   :createTime string,
   :deleteTime string}
  
  Creates a human membership or app membership for the calling app. Creating memberships for other apps isn't supported. For an example, see [ Create a membership](https://developers.google.com/chat/api/guides/v1/members/create). When creating a membership, if the specified member has their auto-accept policy turned off, then they're invited, and must accept the space invitation before joining. Otherwise, creating a membership adds the member directly to the specified space. Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users). To specify the member to add, set the `membership.member.name` in the `CreateMembershipRequest`: - To add the calling app to a space or a direct message between two human users, use `users/app`. Unable to add other apps to the space. - To add a human user, use `users/{user}`, where `{user}` can be the email address for the user. For users in the same Workspace organization `{user}` can also be the `id` for the person from the People API, or the `id` for the user in the Directory API. For example, if the People API Person profile ID for `user@example.com` is `123456789`, you can add the user to the space by setting the `membership.member.name` to `users/user@example.com` or `users/123456789`."
  {:scopes ["https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.app"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/members"
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

(defn members-delete$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/members/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a membership. For an example, see [Delete a membership](https://developers.google.com/chat/api/guides/v1/members/delete). Requires [user authentication](https://developers.google.com/chat/api/guides/auth/users)."
  {:scopes ["https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.app"]}
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
