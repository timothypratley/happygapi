(ns happygapi.drive.replies
  "Drive API: replies.
  Manages files in Drive including uploading, downloading, searching, detecting changes, and updating sharing permissions.
  See: https://developers.google.com/drive/api/reference/rest/v3/replies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/drive/api/reference/rest/v3/replies/create
  
  Required parameters: commentId, fileId
  
  Optional parameters: none
  
  Body: 
  
  {:htmlContent string,
   :deleted boolean,
   :modifiedTime string,
   :content string,
   :author {:displayName string,
            :emailAddress string,
            :kind string,
            :me boolean,
            :permissionId string,
            :photoLink string},
   :createdTime string,
   :id string,
   :kind string,
   :action string}
  
  Creates a new reply to a comment."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:commentId :fileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies"
     #{:commentId :fileId}
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

(defn delete$
  "https://developers.google.com/drive/api/reference/rest/v3/replies/delete
  
  Required parameters: commentId, fileId, replyId
  
  Optional parameters: none
  Deletes a reply."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args]
  {:pre [(util/has-keys? args #{:commentId :replyId :fileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies/{replyId}"
     #{:commentId :replyId :fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/replies/get
  
  Required parameters: commentId, fileId, replyId
  
  Optional parameters: includeDeleted
  Gets a reply by ID."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:commentId :replyId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies/{replyId}"
     #{:commentId :replyId :fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/replies/list
  
  Required parameters: commentId, fileId
  
  Optional parameters: includeDeleted, pageSize, pageToken
  Lists a comment's replies."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:commentId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies"
     #{:commentId :fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/drive/api/reference/rest/v3/replies/update
  
  Required parameters: commentId, fileId, replyId
  
  Optional parameters: none
  
  Body: 
  
  {:htmlContent string,
   :deleted boolean,
   :modifiedTime string,
   :content string,
   :author {:displayName string,
            :emailAddress string,
            :kind string,
            :me boolean,
            :permissionId string,
            :photoLink string},
   :createdTime string,
   :id string,
   :kind string,
   :action string}
  
  Updates a reply with patch semantics."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:commentId :replyId :fileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/comments/{commentId}/replies/{replyId}"
     #{:commentId :replyId :fileId}
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
