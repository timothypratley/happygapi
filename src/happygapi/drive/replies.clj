(ns happygapi.drive.replies
  "Google Drive API: replies.
  The Google Drive API allows clients to access resources from Google Drive.
  See: https://developers.google.com/drive/docs/reference/rest/v3/replies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/drive/api/reference/rest/v3/replies/create
  
  Required parameters: fileId, commentId
  
  Optional parameters: none
  
  Body: 
  
  {:htmlContent string,
   :deleted boolean,
   :modifiedTime string,
   :content string,
   :author {:displayName string,
            :kind string,
            :me boolean,
            :permissionId string,
            :emailAddress string,
            :photoLink string},
   :createdTime string,
   :id string,
   :kind string,
   :action string}
  
  Creates a reply to a comment."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:commentId :fileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies"
     #{:commentId :fileId}
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
  "https://developers.google.com/drive/api/reference/rest/v3/replies/delete
  
  Required parameters: fileId, commentId, replyId
  
  Optional parameters: none
  
  Deletes a reply."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:commentId :replyId :fileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies/{replyId}"
     #{:commentId :replyId :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/replies/get
  
  Required parameters: fileId, commentId, replyId
  
  Optional parameters: includeDeleted
  
  Gets a reply by ID."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:commentId :replyId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies/{replyId}"
     #{:commentId :replyId :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/replies/list
  
  Required parameters: fileId, commentId
  
  Optional parameters: includeDeleted, pageSize, pageToken
  
  Lists a comment's replies."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:commentId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies"
     #{:commentId :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/drive/api/reference/rest/v3/replies/update
  
  Required parameters: fileId, commentId, replyId
  
  Optional parameters: none
  
  Body: 
  
  {:htmlContent string,
   :deleted boolean,
   :modifiedTime string,
   :content string,
   :author {:displayName string,
            :kind string,
            :me boolean,
            :permissionId string,
            :emailAddress string,
            :photoLink string},
   :createdTime string,
   :id string,
   :kind string,
   :action string}
  
  Updates a reply with patch semantics."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:commentId :replyId :fileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies/{replyId}"
     #{:commentId :replyId :fileId}
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
