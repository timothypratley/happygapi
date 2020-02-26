(ns happygapi.books.mylibrary
  "Books API
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_started"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "books_schema.edn"))))

(defn annotations-delete$
  "Required parameters: annotationId
  
  Optional parameters: source
  
  Deletes an annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"annotationId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: annotationId, country, showOnlySummaryInResponse, source
  
  Inserts a new annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn annotations-list$
  "Required parameters: none
  
  Optional parameters: layerIds, volumeId, source, pageToken, contentVersion, updatedMax, layerId, showDeleted, updatedMin, maxResults
  
  Retrieves a list of annotations, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
  "Required parameters: layerIds, volumeId
  
  Optional parameters: none
  
  Gets the summary of specified layers."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"volumeId" "layerIds"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn annotations-update$
  "Required parameters: annotationId
  
  Optional parameters: source
  
  Updates an existing annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"annotationId"})
         (json-schema/validate schemas args)]}
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
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn bookshelves-addVolume$
  "Required parameters: shelf, volumeId
  
  Optional parameters: reason, source
  
  Adds a volume to a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"shelf" "volumeId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn bookshelves-clearVolumes$
  "Required parameters: shelf
  
  Optional parameters: source
  
  Clears all volumes from a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"shelf"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn bookshelves-get$
  "Required parameters: shelf
  
  Optional parameters: source
  
  Retrieves metadata for a specific bookshelf belonging to the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"shelf"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: source
  
  Retrieves a list of bookshelves belonging to the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
  "Required parameters: shelf, volumeId, volumePosition
  
  Optional parameters: source
  
  Moves a volume within a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"shelf" "volumePosition" "volumeId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn bookshelves-removeVolume$
  "Required parameters: shelf, volumeId
  
  Optional parameters: reason, source
  
  Removes a volume from a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"shelf" "volumeId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn bookshelves-volumes-list$
  "Required parameters: shelf
  
  Optional parameters: country, maxResults, projection, q, showPreorders, source, startIndex
  
  Gets volume information for volumes on a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"shelf"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: contentVersion, source
  
  Retrieves my reading position information for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"volumeId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: position, timestamp, volumeId
  
  Optional parameters: action, contentVersion, deviceCookie, source
  
  Sets my reading position information for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"timestamp" "position" "volumeId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))
