(ns happygapi.books.cloudloading
  "Books API: cloudloading.
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/cloudloading"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn addBook$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/cloudloading/addBook
  
  Required parameters: none
  
  Optional parameters: drive_document_id, mime_type, name, upload_client_token
  
  "
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "cloudloading/addBook"
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
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/cloudloading/deleteBook
  
  Required parameters: volumeId
  
  Optional parameters: none
  
  Remove the book and its contents"
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "cloudloading/deleteBook"
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
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/cloudloading/updateBook
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:author string,
   :processingState string,
   :title string,
   :volumeId string}
  
  "
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "cloudloading/updateBook"
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
