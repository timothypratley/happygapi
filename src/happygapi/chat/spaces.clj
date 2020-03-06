(ns happygapi.chat.spaces
  "Hangouts Chat API: spaces.
  Enables bots to fetch information and perform actions in Hangouts Chat.
  See: https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  Lists spaces the caller is a member of."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url "https://chat.googleapis.com/" "v1/spaces" #{} args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns a space."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn members-list$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/members/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Lists human memberships in a space."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/members"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn members-get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/members/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns a membership."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn messages-delete$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a message."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn messages-get$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns a message."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn messages-update$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/update
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:space {:type string, :name string, :displayName string},
   :fallbackText string,
   :name string,
   :createTime string,
   :previewText string,
   :argumentText string,
   :thread {:name string},
   :actionResponse {:url string, :type string},
   :sender {:name string,
            :displayName string,
            :type string,
            :domainId string},
   :cards [{:name string,
            :sections [Section],
            :cardActions [CardAction],
            :header CardHeader}],
   :annotations [{:userMention UserMentionMetadata,
                  :type string,
                  :length integer,
                  :startIndex integer}],
   :text string}
  
  Updates a message."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn messages-create$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/spaces/messages/create
  
  Required parameters: parent
  
  Optional parameters: threadKey
  
  Body: 
  
  {:space {:type string, :name string, :displayName string},
   :fallbackText string,
   :name string,
   :createTime string,
   :previewText string,
   :argumentText string,
   :thread {:name string},
   :actionResponse {:url string, :type string},
   :sender {:name string,
            :displayName string,
            :type string,
            :domainId string},
   :cards [{:name string,
            :sections [Section],
            :cardActions [CardAction],
            :header CardHeader}],
   :annotations [{:userMention UserMentionMetadata,
                  :type string,
                  :length integer,
                  :startIndex integer}],
   :text string}
  
  Creates a message."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/messages"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
