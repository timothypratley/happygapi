(ns happygapi.books.cloudloading
  "Books API: cloudloading.
  The Google Books API allows clients to access the Google Books repository.
  See: https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/cloudloading"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn addBook$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/cloudloading/addBook
  
  Required parameters: none
  
  Optional parameters: drive_document_id, name, upload_client_token, mime_type
  
  Add a user-upload volume and triggers processing."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/cloudloading/addBook"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deleteBook$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/cloudloading/deleteBook
  
  Required parameters: volumeId
  
  Optional parameters: none
  
  Remove the book and its contents"
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/cloudloading/deleteBook"
     #{:volumeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateBook$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/cloudloading/updateBook
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:volumeId string,
   :title string,
   :processingState string,
   :author string}
  
  Updates a user-upload volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/cloudloading/updateBook"
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
