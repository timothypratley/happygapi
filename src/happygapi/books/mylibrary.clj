(ns happygapi.books.mylibrary
  "Books API
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn annotations-delete$
  "Required parameters: annotationId
  
  Deletes an annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"annotationId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/annotations/{annotationId}"
     #{"annotationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn annotations-insert$
  "Required parameters: none
  
  Inserts a new annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/annotations"
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

(defn annotations-list$
  "Required parameters: none
  
  Retrieves a list of annotations, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/annotations"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn annotations-summary$
  "Required parameters: layerIds,volumeId
  
  Gets the summary of specified layers."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"volumeId" "layerIds"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/annotations/summary"
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

(defn annotations-update$
  "Required parameters: annotationId
  
  Updates an existing annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"annotationId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/annotations/{annotationId}"
     #{"annotationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-addVolume$
  "Required parameters: shelf,volumeId
  
  Adds a volume to a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"shelf" "volumeId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/addVolume"
     #{"shelf"}
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

(defn bookshelves-clearVolumes$
  "Required parameters: shelf
  
  Clears all volumes from a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"shelf"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/clearVolumes"
     #{"shelf"}
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

(defn bookshelves-get$
  "Required parameters: shelf
  
  Retrieves metadata for a specific bookshelf belonging to the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"shelf"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}"
     #{"shelf"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-list$
  "Required parameters: none
  
  Retrieves a list of bookshelves belonging to the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-moveVolume$
  "Required parameters: shelf,volumeId,volumePosition
  
  Moves a volume within a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"shelf" "volumePosition" "volumeId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/moveVolume"
     #{"shelf"}
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

(defn bookshelves-removeVolume$
  "Required parameters: shelf,volumeId
  
  Removes a volume from a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"shelf" "volumeId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/removeVolume"
     #{"shelf"}
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

(defn bookshelves-volumes-list$
  "Required parameters: shelf
  
  Gets volume information for volumes on a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"shelf"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/volumes"
     #{"shelf"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn readingpositions-get$
  "Required parameters: volumeId
  
  Retrieves my reading position information for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"volumeId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/readingpositions/{volumeId}"
     #{"volumeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn readingpositions-setPosition$
  "Required parameters: position,timestamp,volumeId
  
  Sets my reading position information for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"timestamp" "position" "volumeId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/readingpositions/{volumeId}/setPosition"
     #{"volumeId"}
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
