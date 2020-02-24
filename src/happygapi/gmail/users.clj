(ns happygapi.gmail.users
  "Gmail API
  Access Gmail mailboxes including sending user email.
  See: https://developers.google.com/gmail/api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn getProfile$
  "Required parameters: userId
  
  Gets the current user's Gmail profile."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/profile"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn stop$
  "Required parameters: userId
  
  Stop receiving push notifications for the given user mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/stop"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn watch$
  "Required parameters: userId
  
  Set up or update a push notification watch on the given user mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/watch"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn drafts-create$
  "Required parameters: userId
  
  Creates a new draft with the DRAFT label."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/drafts"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn drafts-delete$
  "Required parameters: id,userId
  
  Immediately and permanently deletes the specified draft. Does not simply trash it."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/drafts/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn drafts-get$
  "Required parameters: id,userId
  
  Gets the specified draft."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/drafts/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn drafts-list$
  "Required parameters: userId
  
  Lists the drafts in the user's mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/drafts"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn drafts-send$
  "Required parameters: userId
  
  Sends the specified, existing draft to the recipients in the To, Cc, and Bcc headers."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/drafts/send"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn drafts-update$
  "Required parameters: id,userId
  
  Replaces a draft's content."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/drafts/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn history-list$
  "Required parameters: userId
  
  Lists the history of all changes to the given mailbox. History results are returned in chronological order (increasing historyId)."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/history"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn labels-create$
  "Required parameters: userId
  
  Creates a new label."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/labels"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn labels-delete$
  "Required parameters: id,userId
  
  Immediately and permanently deletes the specified label and removes it from any messages and threads that it is applied to."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/labels/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn labels-get$
  "Required parameters: id,userId
  
  Gets the specified label."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/labels/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn labels-list$
  "Required parameters: userId
  
  Lists all labels in the user's mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/labels"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn labels-patch$
  "Required parameters: id,userId
  
  Updates the specified label. This method supports patch semantics."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/labels/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn labels-update$
  "Required parameters: id,userId
  
  Updates the specified label."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.labels"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/labels/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn messages-get$
  "Required parameters: id,userId
  
  Gets the specified message."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.message.action"
            "https://www.googleapis.com/auth/gmail.addons.current.message.metadata"
            "https://www.googleapis.com/auth/gmail.addons.current.message.readonly"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn messages-insert$
  "Required parameters: userId
  
  Directly inserts a message into only this user's mailbox similar to IMAP APPEND, bypassing most scanning and classification. Does not send a message."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.insert"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn messages-untrash$
  "Required parameters: id,userId
  
  Removes the specified message from the trash."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/{id}/untrash"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn messages-delete$
  "Required parameters: id,userId
  
  Immediately and permanently deletes the specified message. This operation cannot be undone. Prefer messages.trash instead."
  {:scopes ["https://mail.google.com/"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn messages-batchDelete$
  "Required parameters: userId
  
  Deletes many messages by message ID. Provides no guarantees that messages were not already deleted or even existed at all."
  {:scopes ["https://mail.google.com/"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/batchDelete"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn messages-batchModify$
  "Required parameters: userId
  
  Modifies the labels on the specified messages."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/batchModify"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn messages-list$
  "Required parameters: userId
  
  Lists the messages in the user's mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn messages-send$
  "Required parameters: userId
  
  Sends the specified message to the recipients in the To, Cc, and Bcc headers."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
            "https://www.googleapis.com/auth/gmail.compose"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.send"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/send"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn messages-import$
  "Required parameters: userId
  
  Imports a message into only this user's mailbox, with standard email delivery scanning and classification similar to receiving via SMTP. Does not send a message."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.insert"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/import"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn messages-modify$
  "Required parameters: id,userId
  
  Modifies the labels on the specified message."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/{id}/modify"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn messages-trash$
  "Required parameters: id,userId
  
  Moves the specified message to the trash."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/{id}/trash"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn messages-attachments-get$
  "Required parameters: id,messageId,userId
  
  Gets the specified message attachment."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.message.action"
            "https://www.googleapis.com/auth/gmail.addons.current.message.readonly"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId" "messageId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/messages/{messageId}/attachments/{id}"
     #{"id" "userId" "messageId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-getLanguage$
  "Required parameters: userId
  
  Gets language settings."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/language"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-updateImap$
  "Required parameters: userId
  
  Updates IMAP settings."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/imap"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-getVacation$
  "Required parameters: userId
  
  Gets vacation responder settings."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/vacation"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-getAutoForwarding$
  "Required parameters: userId
  
  Gets the auto-forwarding setting for the specified account."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/autoForwarding"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-updateAutoForwarding$
  "Required parameters: userId
  
  Updates the auto-forwarding setting for the specified account. A verified forwarding address must be specified when auto-forwarding is enabled.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/autoForwarding"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-updateVacation$
  "Required parameters: userId
  
  Updates vacation responder settings."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/vacation"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-updateLanguage$
  "Required parameters: userId
  
  Updates language settings.
  
  If successful, the return object contains the displayLanguage that was saved for the user, which may differ from the value passed into the request. This is because the requested displayLanguage may not be directly supported by Gmail but have a close variant that is, and so the variant may be chosen and saved instead."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/language"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-getImap$
  "Required parameters: userId
  
  Gets IMAP settings."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/imap"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-getPop$
  "Required parameters: userId
  
  Gets POP settings."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/pop"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-updatePop$
  "Required parameters: userId
  
  Updates POP settings."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/pop"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-delegates-create$
  "Required parameters: userId
  
  Adds a delegate with its verification status set directly to accepted, without sending any verification email. The delegate user must be a member of the same G Suite organization as the delegator user.
  
  Gmail imposes limitations on the number of delegates and delegators each user in a G Suite organization can have. These limits depend on your organization, but in general each user can have up to 25 delegates and up to 10 delegators.
  
  Note that a delegate user must be referred to by their primary email address, and not an email alias.
  
  Also note that when a new delegate is created, there may be up to a one minute delay before the new delegate is available for use.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/delegates"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn settings-delegates-delete$
  "Required parameters: delegateEmail,userId
  
  Removes the specified delegate (which can be of any verification status), and revokes any verification that may have been required for using it.
  
  Note that a delegate user must be referred to by their primary email address, and not an email alias.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId" "delegateEmail"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/delegates/{delegateEmail}"
     #{"userId" "delegateEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-delegates-get$
  "Required parameters: delegateEmail,userId
  
  Gets the specified delegate.
  
  Note that a delegate user must be referred to by their primary email address, and not an email alias.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId" "delegateEmail"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/delegates/{delegateEmail}"
     #{"userId" "delegateEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-delegates-list$
  "Required parameters: userId
  
  Lists the delegates for the specified account.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/delegates"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-filters-create$
  "Required parameters: userId
  
  Creates a filter."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/filters"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn settings-filters-delete$
  "Required parameters: id,userId
  
  Deletes a filter."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/filters/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-filters-get$
  "Required parameters: id,userId
  
  Gets a filter."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/filters/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-filters-list$
  "Required parameters: userId
  
  Lists the message filters of a Gmail user."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/filters"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-forwardingAddresses-create$
  "Required parameters: userId
  
  Creates a forwarding address. If ownership verification is required, a message will be sent to the recipient and the resource's verification status will be set to pending; otherwise, the resource will be created with verification status set to accepted.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/forwardingAddresses"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn settings-forwardingAddresses-delete$
  "Required parameters: forwardingEmail,userId
  
  Deletes the specified forwarding address and revokes any verification that may have been required.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId" "forwardingEmail"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/forwardingAddresses/{forwardingEmail}"
     #{"userId" "forwardingEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-forwardingAddresses-get$
  "Required parameters: forwardingEmail,userId
  
  Gets the specified forwarding address."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId" "forwardingEmail"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/forwardingAddresses/{forwardingEmail}"
     #{"userId" "forwardingEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-forwardingAddresses-list$
  "Required parameters: userId
  
  Lists the forwarding addresses for the specified account."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/forwardingAddresses"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-create$
  "Required parameters: userId
  
  Creates a custom \"from\" send-as alias. If an SMTP MSA is specified, Gmail will attempt to connect to the SMTP service to validate the configuration before creating the alias. If ownership verification is required for the alias, a message will be sent to the email address and the resource's verification status will be set to pending; otherwise, the resource will be created with verification status set to accepted. If a signature is provided, Gmail will sanitize the HTML before saving it with the alias.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn settings-sendAs-delete$
  "Required parameters: sendAsEmail,userId
  
  Deletes the specified send-as alias. Revokes any verification that may have been required for using it.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId" "sendAsEmail"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}"
     #{"userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-get$
  "Required parameters: sendAsEmail,userId
  
  Gets the specified send-as alias. Fails with an HTTP 404 error if the specified address is not a member of the collection."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId" "sendAsEmail"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}"
     #{"userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-list$
  "Required parameters: userId
  
  Lists the send-as aliases for the specified account. The result includes the primary send-as address associated with the account as well as any custom \"from\" aliases."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-patch$
  "Required parameters: sendAsEmail,userId
  
  Updates a send-as alias. If a signature is provided, Gmail will sanitize the HTML before saving it with the alias.
  
  Addresses other than the primary address for the account can only be updated by service account clients that have been delegated domain-wide authority. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId" "sendAsEmail"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}"
     #{"userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-update$
  "Required parameters: sendAsEmail,userId
  
  Updates a send-as alias. If a signature is provided, Gmail will sanitize the HTML before saving it with the alias.
  
  Addresses other than the primary address for the account can only be updated by service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId" "sendAsEmail"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}"
     #{"userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-verify$
  "Required parameters: sendAsEmail,userId
  
  Sends a verification email to the specified send-as alias address. The verification status must be pending.
  
  This method is only available to service account clients that have been delegated domain-wide authority."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId" "sendAsEmail"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}/verify"
     #{"userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn settings-sendAs-smimeInfo-delete$
  "Required parameters: id,sendAsEmail,userId
  
  Deletes the specified S/MIME config for the specified send-as alias."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId" "sendAsEmail"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}"
     #{"id" "userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-smimeInfo-get$
  "Required parameters: id,sendAsEmail,userId
  
  Gets the specified S/MIME config for the specified send-as alias."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId" "sendAsEmail"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}"
     #{"id" "userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-smimeInfo-insert$
  "Required parameters: sendAsEmail,userId
  
  Insert (upload) the given S/MIME config for the specified send-as alias. Note that pkcs12 format is required for the key."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"userId" "sendAsEmail"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo"
     #{"userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn settings-sendAs-smimeInfo-list$
  "Required parameters: sendAsEmail,userId
  
  Lists S/MIME configs for the specified send-as alias."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"
            "https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId" "sendAsEmail"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo"
     #{"userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn settings-sendAs-smimeInfo-setDefault$
  "Required parameters: id,sendAsEmail,userId
  
  Sets the default S/MIME config for the specified send-as alias."
  {:scopes ["https://www.googleapis.com/auth/gmail.settings.basic"
            "https://www.googleapis.com/auth/gmail.settings.sharing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "userId" "sendAsEmail"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}/setDefault"
     #{"id" "userId" "sendAsEmail"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn threads-delete$
  "Required parameters: id,userId
  
  Immediately and permanently deletes the specified thread. This operation cannot be undone. Prefer threads.trash instead."
  {:scopes ["https://mail.google.com/"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/threads/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn threads-get$
  "Required parameters: id,userId
  
  Gets the specified thread."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.addons.current.message.action"
            "https://www.googleapis.com/auth/gmail.addons.current.message.metadata"
            "https://www.googleapis.com/auth/gmail.addons.current.message.readonly"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/threads/{id}"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn threads-list$
  "Required parameters: userId
  
  Lists the threads in the user's mailbox."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.metadata"
            "https://www.googleapis.com/auth/gmail.modify"
            "https://www.googleapis.com/auth/gmail.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/threads"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn threads-modify$
  "Required parameters: id,userId
  
  Modifies the labels applied to the thread. This applies to all messages in the thread."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/threads/{id}/modify"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn threads-trash$
  "Required parameters: id,userId
  
  Moves the specified thread to the trash."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/threads/{id}/trash"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn threads-untrash$
  "Required parameters: id,userId
  
  Removes the specified thread from the trash."
  {:scopes ["https://mail.google.com/"
            "https://www.googleapis.com/auth/gmail.modify"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "userId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/gmail/v1/users/"
     "{userId}/threads/{id}/untrash"
     #{"id" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
