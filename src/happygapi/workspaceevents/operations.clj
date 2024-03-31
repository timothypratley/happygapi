(ns happygapi.workspaceevents.operations
  "Google Workspace Events API: operations.
  The Google Workspace Events API lets you subscribe to events and manage change notifications across Google Workspace applications.
  See: https://developers.google.com/workspace/eventsapi/reference/rest/v1/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/workspace/eventsapi/reference/rest/v1/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
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
