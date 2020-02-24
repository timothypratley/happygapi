(ns happygapi.books.bookshelves
  "Books API
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: shelf,userId
  
  Retrieves metadata for a specific bookshelf for the specified user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"shelf" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "users/{userId}/bookshelves/{shelf}"
     #{"shelf" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: userId
  
  Retrieves a list of public bookshelves for the specified user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "users/{userId}/bookshelves"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn volumes-list$
  "Required parameters: shelf,userId
  
  Retrieves volumes in a specific bookshelf for the specified user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"shelf" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "users/{userId}/bookshelves/{shelf}/volumes"
     #{"shelf" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
