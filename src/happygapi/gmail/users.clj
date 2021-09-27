(ns happygapi.gmail.users
  "Gmail API: users.
  The Gmail API lets you view and manage Gmail mailbox data like threads, messages, and labels.
  See: https://developers.google.com/gmail/api/api/reference/rest/v1/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn watch$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/watch
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:labelFilterAction string, :topicName string, :labelIds [string]}
  
  Set up or update a push notification watch on the given user mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/watch"
     #{:userId}
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

(defn stop$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/stop
  
  Required parameters: userId
  
  Optional parameters: none
  
  Stop receiving push notifications for the given user mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/stop"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getProfile$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/getProfile
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets the current user's Gmail profile."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/profile"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn labels-list$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/labels/list
  
  Required parameters: userId
  
  Optional parameters: none
  
  Lists all labels in the user's mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/labels"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn labels-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/labels/get
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Gets the specified label."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/labels/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn labels-update$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/labels/update
  
  Required parameters: userId, id
  
  Optional parameters: none
  
  Body: 
  
  {:threadsUnread integer,
   :threadsTotal integer,
   :messagesTotal integer,
   :labelListVisibility string,
   :color {:textColor string, :backgroundColor string},
   :messagesUnread integer,
   :name string,
   :messageListVisibility string,
   :type string,
   :id string}
  
  Updates the specified label."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/labels/{id}"
     #{:id :userId}
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

(defn labels-create$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/labels/create
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:threadsUnread integer,
   :threadsTotal integer,
   :messagesTotal integer,
   :labelListVisibility string,
   :color {:textColor string, :backgroundColor string},
   :messagesUnread integer,
   :name string,
   :messageListVisibility string,
   :type string,
   :id string}
  
  Creates a new label."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/labels"
     #{:userId}
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

(defn labels-patch$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/labels/patch
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Body: 
  
  {:threadsUnread integer,
   :threadsTotal integer,
   :messagesTotal integer,
   :labelListVisibility string,
   :color {:textColor string, :backgroundColor string},
   :messagesUnread integer,
   :name string,
   :messageListVisibility string,
   :type string,
   :id string}
  
  Patch the specified label."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/labels/{id}"
     #{:id :userId}
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

(defn labels-delete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/labels/delete
  
  Required parameters: userId, id
  
  Optional parameters: none
  
  Immediately and permanently deletes the specified label and removes it from any messages and threads that it is applied to."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/labels/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn drafts-update$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/drafts/update
  
  Required parameters: userId, id
  
  Optional parameters: none
  
  Body: 
  
  {:message {:threadId string,
             :payload MessagePart,
             :historyId string,
             :raw string,
             :labelIds [string],
             :snippet string,
             :id string,
             :sizeEstimate integer,
             :internalDate string},
   :id string}
  
  Replaces a draft's content."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/drafts/{id}"
     #{:id :userId}
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

(defn drafts-send$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/drafts/send
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:message {:threadId string,
             :payload MessagePart,
             :historyId string,
             :raw string,
             :labelIds [string],
             :snippet string,
             :id string,
             :sizeEstimate integer,
             :internalDate string},
   :id string}
  
  Sends the specified, existing draft to the recipients in the `To`, `Cc`, and `Bcc` headers."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/drafts/send"
     #{:userId}
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

(defn drafts-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/drafts/get
  
  Required parameters: userId, id
  
  Optional parameters: format
  
  Gets the specified draft."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/drafts/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn drafts-delete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/drafts/delete
  
  Required parameters: userId, id
  
  Optional parameters: none
  
  Immediately and permanently deletes the specified draft. Does not simply trash it."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/drafts/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn drafts-create$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/drafts/create
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:message {:threadId string,
             :payload MessagePart,
             :historyId string,
             :raw string,
             :labelIds [string],
             :snippet string,
             :id string,
             :sizeEstimate integer,
             :internalDate string},
   :id string}
  
  Creates a new draft with the `DRAFT` label."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/drafts"
     #{:userId}
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

(defn drafts-list$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/drafts/list
  
  Required parameters: userId
  
  Optional parameters: includeSpamTrash, pageToken, maxResults, q
  
  Lists the drafts in the user's mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/drafts"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-getLanguage$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/getLanguage
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets language settings."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/language"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-updateImap$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/updateImap
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:expungeBehavior string,
   :maxFolderSize integer,
   :autoExpunge boolean,
   :enabled boolean}
  
  Updates IMAP settings."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/imap"
     #{:userId}
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

(defn settings-getVacation$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/getVacation
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets vacation responder settings."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/vacation"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-getAutoForwarding$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/getAutoForwarding
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets the auto-forwarding setting for the specified account."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/autoForwarding"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-updateAutoForwarding$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/updateAutoForwarding
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:disposition string, :emailAddress string, :enabled boolean}
  
  Updates the auto-forwarding setting for the specified account. A verified forwarding address must be specified when auto-forwarding is enabled. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/autoForwarding"
     #{:userId}
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

(defn settings-updateVacation$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/updateVacation
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:startTime string,
   :responseBodyPlainText string,
   :enableAutoReply boolean,
   :responseSubject string,
   :restrictToDomain boolean,
   :responseBodyHtml string,
   :endTime string,
   :restrictToContacts boolean}
  
  Updates vacation responder settings."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/vacation"
     #{:userId}
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

(defn settings-updateLanguage$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/updateLanguage
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:displayLanguage string}
  
  Updates language settings. If successful, the return object contains the `displayLanguage` that was saved for the user, which may differ from the value passed into the request. This is because the requested `displayLanguage` may not be directly supported by Gmail but have a close variant that is, and so the variant may be chosen and saved instead."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/language"
     #{:userId}
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

(defn settings-getImap$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/getImap
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets IMAP settings."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/imap"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-getPop$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/getPop
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets POP settings."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/pop"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-updatePop$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/updatePop
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:accessWindow string, :disposition string}
  
  Updates POP settings."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/pop"
     #{:userId}
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

(defn settings-forwardingAddresses-list$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/forwardingAddresses/list
  
  Required parameters: userId
  
  Optional parameters: none
  
  Lists the forwarding addresses for the specified account."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/forwardingAddresses"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-forwardingAddresses-create$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/forwardingAddresses/create
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:verificationStatus string, :forwardingEmail string}
  
  Creates a forwarding address. If ownership verification is required, a message will be sent to the recipient and the resource's verification status will be set to `pending`; otherwise, the resource will be created with verification status set to `accepted`. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/forwardingAddresses"
     #{:userId}
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

(defn settings-forwardingAddresses-delete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/forwardingAddresses/delete
  
  Required parameters: userId, forwardingEmail
  
  Optional parameters: none
  
  Deletes the specified forwarding address and revokes any verification that may have been required. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:forwardingEmail :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/forwardingAddresses/{forwardingEmail}"
     #{:forwardingEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-forwardingAddresses-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/forwardingAddresses/get
  
  Required parameters: forwardingEmail, userId
  
  Optional parameters: none
  
  Gets the specified forwarding address."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:forwardingEmail :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/forwardingAddresses/{forwardingEmail}"
     #{:forwardingEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-filters-list$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/filters/list
  
  Required parameters: userId
  
  Optional parameters: none
  
  Lists the message filters of a Gmail user."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/filters"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-filters-delete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/filters/delete
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Deletes a filter."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/filters/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-filters-create$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/filters/create
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:criteria {:excludeChats boolean,
              :hasAttachment boolean,
              :sizeComparison string,
              :size integer,
              :negatedQuery string,
              :from string,
              :query string,
              :subject string,
              :to string},
   :id string,
   :action {:addLabelIds [string],
            :removeLabelIds [string],
            :forward string}}
  
  Creates a filter. Note: you can only create a maximum of 1,000 filters."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/filters"
     #{:userId}
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

(defn settings-filters-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/filters/get
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Gets a filter."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/filters/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-verify$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/verify
  
  Required parameters: sendAsEmail, userId
  
  Optional parameters: none
  
  Sends a verification email to the specified send-as alias address. The verification status must be `pending`. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sendAsEmail :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/verify"
     #{:sendAsEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-list$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/list
  
  Required parameters: userId
  
  Optional parameters: none
  
  Lists the send-as aliases for the specified account. The result includes the primary send-as address associated with the account as well as any custom \"from\" aliases."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-update$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/update
  
  Required parameters: sendAsEmail, userId
  
  Optional parameters: none
  
  Body: 
  
  {:treatAsAlias boolean,
   :isDefault boolean,
   :displayName string,
   :isPrimary boolean,
   :signature string,
   :sendAsEmail string,
   :verificationStatus string,
   :replyToAddress string,
   :smtpMsa {:host string,
             :password string,
             :username string,
             :securityMode string,
             :port integer}}
  
  Updates a send-as alias. If a signature is provided, Gmail will sanitize the HTML before saving it with the alias. Addresses other than the primary address for the account can only be updated by service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sendAsEmail :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}"
     #{:sendAsEmail :userId}
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

(defn settings-sendAs-create$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/create
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:treatAsAlias boolean,
   :isDefault boolean,
   :displayName string,
   :isPrimary boolean,
   :signature string,
   :sendAsEmail string,
   :verificationStatus string,
   :replyToAddress string,
   :smtpMsa {:host string,
             :password string,
             :username string,
             :securityMode string,
             :port integer}}
  
  Creates a custom \"from\" send-as alias. If an SMTP MSA is specified, Gmail will attempt to connect to the SMTP service to validate the configuration before creating the alias. If ownership verification is required for the alias, a message will be sent to the email address and the resource's verification status will be set to `pending`; otherwise, the resource will be created with verification status set to `accepted`. If a signature is provided, Gmail will sanitize the HTML before saving it with the alias. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs"
     #{:userId}
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

(defn settings-sendAs-delete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/delete
  
  Required parameters: sendAsEmail, userId
  
  Optional parameters: none
  
  Deletes the specified send-as alias. Revokes any verification that may have been required for using it. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sendAsEmail :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}"
     #{:sendAsEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/get
  
  Required parameters: userId, sendAsEmail
  
  Optional parameters: none
  
  Gets the specified send-as alias. Fails with an HTTP 404 error if the specified address is not a member of the collection."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sendAsEmail :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}"
     #{:sendAsEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-patch$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/patch
  
  Required parameters: sendAsEmail, userId
  
  Optional parameters: none
  
  Body: 
  
  {:treatAsAlias boolean,
   :isDefault boolean,
   :displayName string,
   :isPrimary boolean,
   :signature string,
   :sendAsEmail string,
   :verificationStatus string,
   :replyToAddress string,
   :smtpMsa {:host string,
             :password string,
             :username string,
             :securityMode string,
             :port integer}}
  
  Patch the specified send-as alias."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sendAsEmail :userId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}"
     #{:sendAsEmail :userId}
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

(defn settings-sendAs-smimeInfo-delete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/smimeInfo/delete
  
  Required parameters: id, sendAsEmail, userId
  
  Optional parameters: none
  
  Deletes the specified S/MIME config for the specified send-as alias."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :sendAsEmail :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}"
     #{:id :sendAsEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-smimeInfo-insert$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/smimeInfo/insert
  
  Required parameters: sendAsEmail, userId
  
  Optional parameters: none
  
  Body: 
  
  {:pkcs12 string,
   :isDefault boolean,
   :pem string,
   :expiration string,
   :id string,
   :encryptedKeyPassword string,
   :issuerCn string}
  
  Insert (upload) the given S/MIME config for the specified send-as alias. Note that pkcs12 format is required for the key."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sendAsEmail :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo"
     #{:sendAsEmail :userId}
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

(defn settings-sendAs-smimeInfo-setDefault$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/smimeInfo/setDefault
  
  Required parameters: id, sendAsEmail, userId
  
  Optional parameters: none
  
  Sets the default S/MIME config for the specified send-as alias."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :sendAsEmail :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}/setDefault"
     #{:id :sendAsEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-smimeInfo-list$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/smimeInfo/list
  
  Required parameters: userId, sendAsEmail
  
  Optional parameters: none
  
  Lists S/MIME configs for the specified send-as alias."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sendAsEmail :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo"
     #{:sendAsEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-smimeInfo-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/sendAs/smimeInfo/get
  
  Required parameters: sendAsEmail, userId, id
  
  Optional parameters: none
  
  Gets the specified S/MIME config for the specified send-as alias."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :sendAsEmail :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}"
     #{:id :sendAsEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-delegates-delete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/delegates/delete
  
  Required parameters: delegateEmail, userId
  
  Optional parameters: none
  
  Removes the specified delegate (which can be of any verification status), and revokes any verification that may have been required for using it. Note that a delegate user must be referred to by their primary email address, and not an email alias. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:delegateEmail :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/delegates/{delegateEmail}"
     #{:delegateEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-delegates-list$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/delegates/list
  
  Required parameters: userId
  
  Optional parameters: none
  
  Lists the delegates for the specified account. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/delegates"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-delegates-create$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/delegates/create
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:delegateEmail string, :verificationStatus string}
  
  Adds a delegate with its verification status set directly to `accepted`, without sending any verification email. The delegate user must be a member of the same G Suite organization as the delegator user. Gmail imposes limitations on the number of delegates and delegators each user in a G Suite organization can have. These limits depend on your organization, but in general each user can have up to 25 delegates and up to 10 delegators. Note that a delegate user must be referred to by their primary email address, and not an email alias. Also note that when a new delegate is created, there may be up to a one minute delay before the new delegate is available for use. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/delegates"
     #{:userId}
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

(defn settings-delegates-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/settings/delegates/get
  
  Required parameters: userId, delegateEmail
  
  Optional parameters: none
  
  Gets the specified delegate. Note that a delegate user must be referred to by their primary email address, and not an email alias. This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:delegateEmail :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/settings/delegates/{delegateEmail}"
     #{:delegateEmail :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn threads-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/threads/get
  
  Required parameters: userId, id
  
  Optional parameters: format, metadataHeaders
  
  Gets the specified thread."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.message.action"
            "https://www.googleapis.com/auth/gmail.addons.current.message.metadata"
            "https://www.googleapis.com/auth/gmail.addons.current.message.readonly"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/threads/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn threads-trash$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/threads/trash
  
  Required parameters: userId, id
  
  Optional parameters: none
  
  Moves the specified thread to the trash."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/threads/{id}/trash"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn threads-modify$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/threads/modify
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Body: 
  
  {:addLabelIds [string], :removeLabelIds [string]}
  
  Modifies the labels applied to the thread. This applies to all messages in the thread."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/threads/{id}/modify"
     #{:id :userId}
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

(defn threads-delete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/threads/delete
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Immediately and permanently deletes the specified thread. This operation cannot be undone. Prefer `threads.trash` instead."
  {:scopes ["https://mail.google.com/"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/threads/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn threads-untrash$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/threads/untrash
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Removes the specified thread from the trash."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/threads/{id}/untrash"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn threads-list$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/threads/list
  
  Required parameters: userId
  
  Optional parameters: q, maxResults, pageToken, includeSpamTrash, labelIds
  
  Lists the threads in the user's mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/threads"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn history-list$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/history/list
  
  Required parameters: userId
  
  Optional parameters: startHistoryId, maxResults, historyTypes, pageToken, labelId
  
  Lists the history of all changes to the given mailbox. History results are returned in chronological order (increasing `historyId`)."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/history"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/get
  
  Required parameters: id, userId
  
  Optional parameters: metadataHeaders, format
  
  Gets the specified message."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.message.action"
            "https://www.googleapis.com/auth/gmail.addons.current.message.metadata"
            "https://www.googleapis.com/auth/gmail.addons.current.message.readonly"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-insert$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/insert
  
  Required parameters: userId
  
  Optional parameters: internalDateSource, deleted
  
  Body: 
  
  {:threadId string,
   :payload {:headers [MessagePartHeader],
             :body MessagePartBody,
             :mimeType string,
             :filename string,
             :parts [MessagePart],
             :partId string},
   :historyId string,
   :raw string,
   :labelIds [string],
   :snippet string,
   :id string,
   :sizeEstimate integer,
   :internalDate string}
  
  Directly inserts a message into only this user's mailbox similar to `IMAP APPEND`, bypassing most scanning and classification. Does not send a message."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.insert"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages"
     #{:userId}
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

(defn messages-untrash$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/untrash
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Removes the specified message from the trash."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/{id}/untrash"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-delete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/delete
  
  Required parameters: userId, id
  
  Optional parameters: none
  
  Immediately and permanently deletes the specified message. This operation cannot be undone. Prefer `messages.trash` instead."
  {:scopes ["https://mail.google.com/"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/{id}"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-batchDelete$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/batchDelete
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:ids [string]}
  
  Deletes many messages by message ID. Provides no guarantees that messages were not already deleted or even existed at all."
  {:scopes ["https://mail.google.com/"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/batchDelete"
     #{:userId}
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

(defn messages-batchModify$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/batchModify
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:removeLabelIds [string], :ids [string], :addLabelIds [string]}
  
  Modifies the labels on the specified messages."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/batchModify"
     #{:userId}
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
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/list
  
  Required parameters: userId
  
  Optional parameters: pageToken, includeSpamTrash, maxResults, labelIds, q
  
  Lists the messages in the user's mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-send$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/send
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:threadId string,
   :payload {:headers [MessagePartHeader],
             :body MessagePartBody,
             :mimeType string,
             :filename string,
             :parts [MessagePart],
             :partId string},
   :historyId string,
   :raw string,
   :labelIds [string],
   :snippet string,
   :id string,
   :sizeEstimate integer,
   :internalDate string}
  
  Sends the specified message to the recipients in the `To`, `Cc`, and `Bcc` headers."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.send"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/send"
     #{:userId}
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

(defn messages-import$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/import
  
  Required parameters: userId
  
  Optional parameters: deleted, processForCalendar, internalDateSource, neverMarkSpam
  
  Body: 
  
  {:threadId string,
   :payload {:headers [MessagePartHeader],
             :body MessagePartBody,
             :mimeType string,
             :filename string,
             :parts [MessagePart],
             :partId string},
   :historyId string,
   :raw string,
   :labelIds [string],
   :snippet string,
   :id string,
   :sizeEstimate integer,
   :internalDate string}
  
  Imports a message into only this user's mailbox, with standard email delivery scanning and classification similar to receiving via SMTP. Does not send a message. Note: This function doesn't trigger forwarding rules or filters set up by the user."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.insert"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/import"
     #{:userId}
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

(defn messages-modify$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/modify
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Body: 
  
  {:addLabelIds [string], :removeLabelIds [string]}
  
  Modifies the labels on the specified message."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/{id}/modify"
     #{:id :userId}
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

(defn messages-trash$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/trash
  
  Required parameters: id, userId
  
  Optional parameters: none
  
  Moves the specified message to the trash."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/{id}/trash"
     #{:id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn messages-attachments-get$
  "https://developers.google.com/gmail/api/api/reference/rest/v1/users/messages/attachments/get
  
  Required parameters: id, userId, messageId
  
  Optional parameters: none
  
  Gets the specified message attachment."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.message.action"
            "https://www.googleapis.com/auth/gmail.addons.current.message.readonly"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:messageId :id :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmail.googleapis.com/"
     "gmail/v1/users/{userId}/messages/{messageId}/attachments/{id}"
     #{:messageId :id :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
