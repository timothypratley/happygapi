(ns happygapi.books.mylibrary
  "Books API: mylibrary.
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn annotations-delete$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/annotations/delete
  
  Required parameters: annotationId
  
  Optional parameters: source
  Deletes an annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:annotationId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/annotations/{annotationId}"
     #{:annotationId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn annotations-insert$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/annotations/insert
  
  Required parameters: none
  
  Optional parameters: annotationId, country, showOnlySummaryInResponse, source
  
  Body: 
  
  {:deleted boolean,
   :volumeId string,
   :selectedText string,
   :layerSummary {:allowedCharacterCount integer,
                  :limitType string,
                  :remainingCharacterCount integer},
   :updated string,
   :selfLink string,
   :highlightStyle string,
   :created string,
   :currentVersionRanges {:cfiRange {:endOffset string,
                                     :endPosition string,
                                     :startOffset string,
                                     :startPosition string},
                          :contentVersion string,
                          :gbImageRange {:endOffset string,
                                         :endPosition string,
                                         :startOffset string,
                                         :startPosition string},
                          :gbTextRange {:endOffset string,
                                        :endPosition string,
                                        :startOffset string,
                                        :startPosition string},
                          :imageCfiRange {:endOffset string,
                                          :endPosition string,
                                          :startOffset string,
                                          :startPosition string}},
   :afterSelectedText string,
   :id string,
   :kind string,
   :pageIds [string],
   :clientVersionRanges {:cfiRange {:endOffset string,
                                    :endPosition string,
                                    :startOffset string,
                                    :startPosition string},
                         :contentVersion string,
                         :gbImageRange {:endOffset string,
                                        :endPosition string,
                                        :startOffset string,
                                        :startPosition string},
                         :gbTextRange {:endOffset string,
                                       :endPosition string,
                                       :startOffset string,
                                       :startPosition string},
                         :imageCfiRange {:endOffset string,
                                         :endPosition string,
                                         :startOffset string,
                                         :startPosition string}},
   :beforeSelectedText string,
   :layerId string,
   :data string}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn annotations-list$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/annotations/list
  
  Required parameters: none
  
  Optional parameters: layerIds, volumeId, source, pageToken, contentVersion, updatedMax, layerId, showDeleted, updatedMin, maxResults
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
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/annotations/summary
  
  Required parameters: layerIds, volumeId
  
  Optional parameters: none
  Gets the summary of specified layers."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:layerIds :volumeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/annotations/summary"
     #{:layerIds :volumeId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn annotations-update$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/annotations/update
  
  Required parameters: annotationId
  
  Optional parameters: source
  
  Body: 
  
  {:deleted boolean,
   :volumeId string,
   :selectedText string,
   :layerSummary {:allowedCharacterCount integer,
                  :limitType string,
                  :remainingCharacterCount integer},
   :updated string,
   :selfLink string,
   :highlightStyle string,
   :created string,
   :currentVersionRanges {:cfiRange {:endOffset string,
                                     :endPosition string,
                                     :startOffset string,
                                     :startPosition string},
                          :contentVersion string,
                          :gbImageRange {:endOffset string,
                                         :endPosition string,
                                         :startOffset string,
                                         :startPosition string},
                          :gbTextRange {:endOffset string,
                                        :endPosition string,
                                        :startOffset string,
                                        :startPosition string},
                          :imageCfiRange {:endOffset string,
                                          :endPosition string,
                                          :startOffset string,
                                          :startPosition string}},
   :afterSelectedText string,
   :id string,
   :kind string,
   :pageIds [string],
   :clientVersionRanges {:cfiRange {:endOffset string,
                                    :endPosition string,
                                    :startOffset string,
                                    :startPosition string},
                         :contentVersion string,
                         :gbImageRange {:endOffset string,
                                        :endPosition string,
                                        :startOffset string,
                                        :startPosition string},
                         :gbTextRange {:endOffset string,
                                       :endPosition string,
                                       :startOffset string,
                                       :startPosition string},
                         :imageCfiRange {:endOffset string,
                                         :endPosition string,
                                         :startOffset string,
                                         :startPosition string}},
   :beforeSelectedText string,
   :layerId string,
   :data string}
  
  Updates an existing annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:annotationId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/annotations/{annotationId}"
     #{:annotationId}
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

(defn bookshelves-addVolume$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/bookshelves/addVolume
  
  Required parameters: shelf, volumeId
  
  Optional parameters: reason, source
  Adds a volume to a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:shelf :volumeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/addVolume"
     #{:shelf :volumeId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-clearVolumes$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/bookshelves/clearVolumes
  
  Required parameters: shelf
  
  Optional parameters: source
  Clears all volumes from a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:shelf})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/clearVolumes"
     #{:shelf}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/bookshelves/get
  
  Required parameters: shelf
  
  Optional parameters: source
  Retrieves metadata for a specific bookshelf belonging to the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:shelf})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}"
     #{:shelf}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-list$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/bookshelves/list
  
  Required parameters: none
  
  Optional parameters: source
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
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/bookshelves/moveVolume
  
  Required parameters: shelf, volumeId, volumePosition
  
  Optional parameters: source
  Moves a volume within a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:shelf :volumeId :volumePosition})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/moveVolume"
     #{:shelf :volumeId :volumePosition}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-removeVolume$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/bookshelves/removeVolume
  
  Required parameters: shelf, volumeId
  
  Optional parameters: reason, source
  Removes a volume from a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:shelf :volumeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/removeVolume"
     #{:shelf :volumeId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-volumes-list$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/bookshelves/volumes/list
  
  Required parameters: shelf
  
  Optional parameters: country, maxResults, projection, q, showPreorders, source, startIndex
  Gets volume information for volumes on a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:shelf})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/bookshelves/{shelf}/volumes"
     #{:shelf}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn readingpositions-get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/readingpositions/get
  
  Required parameters: volumeId
  
  Optional parameters: contentVersion, source
  Retrieves my reading position information for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:volumeId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/readingpositions/{volumeId}"
     #{:volumeId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn readingpositions-setPosition$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/mylibrary/readingpositions/setPosition
  
  Required parameters: position, timestamp, volumeId
  
  Optional parameters: action, contentVersion, deviceCookie, source
  Sets my reading position information for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:volumeId :position :timestamp})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "mylibrary/readingpositions/{volumeId}/setPosition"
     #{:volumeId :position :timestamp}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
