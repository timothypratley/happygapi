(ns happygapi.books.bookshelves
  "Books API: bookshelves.
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/bookshelves"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/bookshelves/get
  
  Required parameters: shelf, userId
  
  Optional parameters: source
  Retrieves metadata for a specific bookshelf for the specified user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:shelf :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "users/{userId}/bookshelves/{shelf}"
     #{:shelf :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/bookshelves/list
  
  Required parameters: userId
  
  Optional parameters: source
  Retrieves a list of public bookshelves for the specified user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "users/{userId}/bookshelves"
     #{:userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn volumes-list$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/bookshelves/volumes/list
  
  Required parameters: shelf, userId
  
  Optional parameters: maxResults, showPreorders, source, startIndex
  Retrieves volumes in a specific bookshelf for the specified user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:shelf :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "users/{userId}/bookshelves/{shelf}/volumes"
     #{:shelf :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
