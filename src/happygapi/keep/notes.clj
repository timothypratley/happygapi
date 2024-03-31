(ns happygapi.keep.notes
  "Google Keep API: notes.
  The Google Keep API is used in an enterprise environment to manage Google Keep content and resolve issues identified by cloud security software.
  See: https://developers.google.com/keep/apiapi/reference/rest/v1/notes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/keep/apiapi/reference/rest/v1/notes/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [{:name string,
                  :role string,
                  :email string,
                  :user User,
                  :group Group,
                  :family Family,
                  :deleted boolean}],
   :trashTime string,
   :name string,
   :attachments [{:name string, :mimeType [string]}],
   :createTime string,
   :title string,
   :updateTime string,
   :trashed boolean,
   :body {:text TextContent, :list ListContent}}
  
  Creates a new note."
  {:scopes ["https://www.googleapis.com/auth/keep"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://keep.googleapis.com/"
     "v1/notes"
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

(defn get$
  "https://developers.google.com/keep/apiapi/reference/rest/v1/notes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a note."
  {:scopes ["https://www.googleapis.com/auth/keep"
            "https://www.googleapis.com/auth/keep.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://keep.googleapis.com/"
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
  "https://developers.google.com/keep/apiapi/reference/rest/v1/notes/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists notes. Every list call returns a page of results with `page_size` as the upper bound of returned items. A `page_size` of zero allows the server to choose the upper bound. The ListNotesResponse contains at most `page_size` entries. If there are more things left to list, it provides a `next_page_token` value. (Page tokens are opaque values.) To get the next page of results, copy the result's `next_page_token` into the next request's `page_token`. Repeat until the `next_page_token` returned with a page of results is empty. ListNotes return consistent results in the face of concurrent changes, or signals that it cannot with an ABORTED error."
  {:scopes ["https://www.googleapis.com/auth/keep"
            "https://www.googleapis.com/auth/keep.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://keep.googleapis.com/"
     "v1/notes"
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
  "https://developers.google.com/keep/apiapi/reference/rest/v1/notes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a note. Caller must have the `OWNER` role on the note to delete. Deleting a note removes the resource immediately and cannot be undone. Any collaborators will lose access to the note."
  {:scopes ["https://www.googleapis.com/auth/keep"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://keep.googleapis.com/"
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

(defn permissions-batchCreate$
  "https://developers.google.com/keep/apiapi/reference/rest/v1/notes/permissions/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:parent string, :permission Permission}]}
  
  Creates one or more permissions on the note. Only permissions with the `WRITER` role may be created. If adding any permission fails, then the entire request fails and no changes are made."
  {:scopes ["https://www.googleapis.com/auth/keep"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://keep.googleapis.com/"
     "v1/{+parent}/permissions:batchCreate"
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

(defn permissions-batchDelete$
  "https://developers.google.com/keep/apiapi/reference/rest/v1/notes/permissions/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Deletes one or more permissions on the note. The specified entities will immediately lose access. A permission with the `OWNER` role can't be removed. If removing a permission fails, then the entire request fails and no changes are made. Returns a 400 bad request error if a specified permission does not exist on the note."
  {:scopes ["https://www.googleapis.com/auth/keep"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://keep.googleapis.com/"
     "v1/{+parent}/permissions:batchDelete"
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
