(ns happygapi.books.volumes
  "Books API
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: volumeId
  
  Gets volume information for a single volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"volumeId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}"
     #{"volumeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: q
  
  Performs a book search."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"q"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn associated-list$
  "Required parameters: volumeId
  
  Return a list of associated books."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"volumeId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/associated"
     #{"volumeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn mybooks-list$
  "Required parameters: none
  
  Return a list of books in My Library."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/mybooks"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn recommended-list$
  "Required parameters: none
  
  Return a list of recommended books for the current user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/recommended"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn recommended-rate$
  "Required parameters: rating,volumeId
  
  Rate a recommended book for the current user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"volumeId" "rating"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/recommended/rate"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn useruploaded-list$
  "Required parameters: none
  
  Return a list of books uploaded by the current user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/useruploaded"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
