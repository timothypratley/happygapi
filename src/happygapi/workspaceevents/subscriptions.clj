(ns happygapi.workspaceevents.subscriptions
  "Google Workspace Events API: subscriptions.
  The Google Workspace Events API lets you subscribe to events and manage change notifications across Google Workspace applications.
  See: https://developers.google.com/workspace/eventsdocs/reference/rest/v1/subscriptions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn reactivate$
  "https://developers.google.com/workspace/eventsapi/reference/rest/v1/subscriptions/reactivate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  [Developer Preview](https://developers.google.com/workspace/preview): Reactivates a suspended Google Workspace subscription. This method resets your subscription's `State` field to `ACTIVE`. Before you use this method, you must fix the error that suspended the subscription. To learn how to use this method, see [Reactivate a Google Workspace subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription)."
  {:scopes ["https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.readonly"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.reactions"
            "https://www.googleapis.com/auth/chat.messages.reactions.readonly"
            "https://www.googleapis.com/auth/chat.messages.readonly"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.readonly"
            "https://www.googleapis.com/auth/meetings.space.created"
            "https://www.googleapis.com/auth/meetings.space.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workspaceevents.googleapis.com/"
     "v1/{+name}:reactivate"
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

(defn patch$
  "https://developers.google.com/workspace/eventsapi/reference/rest/v1/subscriptions/patch
  
  Required parameters: name
  
  Optional parameters: validateOnly, updateMask
  
  Body: 
  
  {:targetResource string,
   :uid string,
   :name string,
   :authority string,
   :createTime string,
   :notificationEndpoint {:pubsubTopic string},
   :etag string,
   :state string,
   :payloadOptions {:includeResource boolean, :fieldMask string},
   :updateTime string,
   :reconciling boolean,
   :ttl string,
   :eventTypes [string],
   :expireTime string,
   :suspensionReason string}
  
  [Developer Preview](https://developers.google.com/workspace/preview): Updates or renews a Google Workspace subscription. To learn how to use this method, see [Update or renew a Google Workspace subscription](https://developers.google.com/workspace/events/guides/update-subscription)."
  {:scopes ["https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.readonly"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.reactions"
            "https://www.googleapis.com/auth/chat.messages.reactions.readonly"
            "https://www.googleapis.com/auth/chat.messages.readonly"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.readonly"
            "https://www.googleapis.com/auth/meetings.space.created"
            "https://www.googleapis.com/auth/meetings.space.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://workspaceevents.googleapis.com/"
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

(defn get$
  "https://developers.google.com/workspace/eventsapi/reference/rest/v1/subscriptions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  [Developer Preview](https://developers.google.com/workspace/preview): Gets details about a Google Workspace subscription. To learn how to use this method, see [Get details about a Google Workspace subscription](https://developers.google.com/workspace/events/guides/get-subscription)."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.readonly"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.reactions"
            "https://www.googleapis.com/auth/chat.messages.reactions.readonly"
            "https://www.googleapis.com/auth/chat.messages.readonly"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.readonly"
            "https://www.googleapis.com/auth/meetings.space.created"
            "https://www.googleapis.com/auth/meetings.space.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workspaceevents.googleapis.com/"
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
  "https://developers.google.com/workspace/eventsapi/reference/rest/v1/subscriptions/create
  
  Required parameters: none
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:targetResource string,
   :uid string,
   :name string,
   :authority string,
   :createTime string,
   :notificationEndpoint {:pubsubTopic string},
   :etag string,
   :state string,
   :payloadOptions {:includeResource boolean, :fieldMask string},
   :updateTime string,
   :reconciling boolean,
   :ttl string,
   :eventTypes [string],
   :expireTime string,
   :suspensionReason string}
  
  [Developer Preview](https://developers.google.com/workspace/preview): Creates a Google Workspace subscription. To learn how to use this method, see [Create a Google Workspace subscription](https://developers.google.com/workspace/events/guides/create-subscription)."
  {:scopes ["https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.readonly"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.reactions"
            "https://www.googleapis.com/auth/chat.messages.reactions.readonly"
            "https://www.googleapis.com/auth/chat.messages.readonly"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.readonly"
            "https://www.googleapis.com/auth/meetings.space.created"
            "https://www.googleapis.com/auth/meetings.space.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workspaceevents.googleapis.com/"
     "v1/subscriptions"
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
  "https://developers.google.com/workspace/eventsapi/reference/rest/v1/subscriptions/list
  
  Required parameters: none
  
  Optional parameters: pageSize, filter, pageToken
  
  [Developer Preview](https://developers.google.com/workspace/preview): Lists Google Workspace subscriptions. To learn how to use this method, see [List Google Workspace subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions)."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.readonly"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.reactions"
            "https://www.googleapis.com/auth/chat.messages.reactions.readonly"
            "https://www.googleapis.com/auth/chat.messages.readonly"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.readonly"
            "https://www.googleapis.com/auth/meetings.space.created"
            "https://www.googleapis.com/auth/meetings.space.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workspaceevents.googleapis.com/"
     "v1/subscriptions"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/workspace/eventsapi/reference/rest/v1/subscriptions/delete
  
  Required parameters: name
  
  Optional parameters: allowMissing, etag, validateOnly
  
  [Developer Preview](https://developers.google.com/workspace/preview): Deletes a Google Workspace subscription. To learn how to use this method, see [Delete a Google Workspace subscription](https://developers.google.com/workspace/events/guides/delete-subscription)."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.memberships"
            "https://www.googleapis.com/auth/chat.memberships.readonly"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.reactions"
            "https://www.googleapis.com/auth/chat.messages.reactions.readonly"
            "https://www.googleapis.com/auth/chat.messages.readonly"
            "https://www.googleapis.com/auth/chat.spaces"
            "https://www.googleapis.com/auth/chat.spaces.readonly"
            "https://www.googleapis.com/auth/meetings.space.created"
            "https://www.googleapis.com/auth/meetings.space.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://workspaceevents.googleapis.com/"
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
