(ns happygapi.libraryagent.shelves
  "Library Agent API: shelves.
  A simple Google Example Library API.
  See: https://cloud.google.com/docs/quotaapi/reference/rest/v1/shelves"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/docs/quotaapi/reference/rest/v1/shelves/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a shelf. Returns NOT_FOUND if the shelf does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://libraryagent.googleapis.com/"
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
  "https://cloud.google.com/docs/quotaapi/reference/rest/v1/shelves/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Lists shelves. The order is unspecified but deterministic. Newly created
  shelves will not necessarily be added to the end of this list."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/shelves"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn books-get$
  "https://cloud.google.com/docs/quotaapi/reference/rest/v1/shelves/books/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a book. Returns NOT_FOUND if the book does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://libraryagent.googleapis.com/"
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

(defn books-list$
  "https://cloud.google.com/docs/quotaapi/reference/rest/v1/shelves/books/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists books in a shelf. The order is unspecified but deterministic. Newly
  created books will not necessarily be added to the end of this list.
  Returns NOT_FOUND if the shelf does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/{+parent}/books"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn books-return$
  "https://cloud.google.com/docs/quotaapi/reference/rest/v1/shelves/books/return
  
  Required parameters: name
  
  Optional parameters: none
  
  Return a book to the library. Returns the book if it is returned to the
  library successfully.
  Returns error if the book does not belong to the library
  or the users didn't borrow before."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/{+name}:return"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn books-borrow$
  "https://cloud.google.com/docs/quotaapi/reference/rest/v1/shelves/books/borrow
  
  Required parameters: name
  
  Optional parameters: none
  
  Borrow a book from the library. Returns the book if it is borrowed
  successfully. Returns NOT_FOUND if the book does not exist in the library.
  Returns quota exceeded error if the amount of books borrowed exceeds
  allocation quota in any dimensions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/{+name}:borrow"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
