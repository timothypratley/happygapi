(ns happygapi.books.mylibrary
  "Books API: mylibrary.
  The Google Books API allows clients to access the Google Books repository.
  See: https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn bookshelves-removeVolume$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/bookshelves/removeVolume
  
  Required parameters: volumeId, shelf
  
  Optional parameters: reason, source
  
  Removes a volume from a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:shelf :volumeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/bookshelves/{shelf}/removeVolume"
     #{:shelf :volumeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-get$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/bookshelves/get
  
  Required parameters: shelf
  
  Optional parameters: source
  
  Retrieves metadata for a specific bookshelf belonging to the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:shelf})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/bookshelves/{shelf}"
     #{:shelf}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-moveVolume$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/bookshelves/moveVolume
  
  Required parameters: volumeId, volumePosition, shelf
  
  Optional parameters: source
  
  Moves a volume within a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:shelf :volumeId :volumePosition})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/bookshelves/{shelf}/moveVolume"
     #{:shelf :volumeId :volumePosition}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-clearVolumes$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/bookshelves/clearVolumes
  
  Required parameters: shelf
  
  Optional parameters: source
  
  Clears all volumes from a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:shelf})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/bookshelves/{shelf}/clearVolumes"
     #{:shelf}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-list$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/bookshelves/list
  
  Required parameters: none
  
  Optional parameters: source
  
  Retrieves a list of bookshelves belonging to the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/bookshelves"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-addVolume$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/bookshelves/addVolume
  
  Required parameters: shelf, volumeId
  
  Optional parameters: source, reason
  
  Adds a volume to a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:shelf :volumeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/bookshelves/{shelf}/addVolume"
     #{:shelf :volumeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bookshelves-volumes-list$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/bookshelves/volumes/list
  
  Required parameters: shelf
  
  Optional parameters: q, maxResults, showPreorders, startIndex, country, source, projection
  
  Gets volume information for volumes on a bookshelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:shelf})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/bookshelves/{shelf}/volumes"
     #{:shelf}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn annotations-update$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/annotations/update
  
  Required parameters: annotationId
  
  Optional parameters: source
  
  Body: 
  
  {:deleted boolean,
   :volumeId string,
   :selectedText string,
   :layerSummary {:allowedCharacterCount integer,
                  :remainingCharacterCount integer,
                  :limitType string},
   :updated string,
   :selfLink string,
   :highlightStyle string,
   :created string,
   :currentVersionRanges {:contentVersion string,
                          :gbImageRange {:startPosition string,
                                         :endPosition string,
                                         :endOffset string,
                                         :startOffset string},
                          :cfiRange {:startPosition string,
                                     :endPosition string,
                                     :endOffset string,
                                     :startOffset string},
                          :imageCfiRange {:startPosition string,
                                          :endPosition string,
                                          :endOffset string,
                                          :startOffset string},
                          :gbTextRange {:startPosition string,
                                        :endPosition string,
                                        :endOffset string,
                                        :startOffset string}},
   :afterSelectedText string,
   :id string,
   :kind string,
   :pageIds [string],
   :clientVersionRanges {:contentVersion string,
                         :gbTextRange {:startPosition string,
                                       :endPosition string,
                                       :endOffset string,
                                       :startOffset string},
                         :gbImageRange {:startPosition string,
                                        :endPosition string,
                                        :endOffset string,
                                        :startOffset string},
                         :imageCfiRange {:startPosition string,
                                         :endPosition string,
                                         :endOffset string,
                                         :startOffset string},
                         :cfiRange {:startPosition string,
                                    :endPosition string,
                                    :endOffset string,
                                    :startOffset string}},
   :beforeSelectedText string,
   :layerId string,
   :data string}
  
  Updates an existing annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:annotationId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/annotations/{annotationId}"
     #{:annotationId}
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

(defn annotations-summary$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/annotations/summary
  
  Required parameters: volumeId, layerIds
  
  Optional parameters: none
  
  Gets the summary of specified layers."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:layerIds :volumeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/annotations/summary"
     #{:layerIds :volumeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn annotations-list$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/annotations/list
  
  Required parameters: none
  
  Optional parameters: layerIds, volumeId, source, pageToken, contentVersion, updatedMax, layerId, showDeleted, updatedMin, maxResults
  
  Retrieves a list of annotations, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/annotations"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn annotations-insert$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/annotations/insert
  
  Required parameters: none
  
  Optional parameters: showOnlySummaryInResponse, country, annotationId, source
  
  Body: 
  
  {:deleted boolean,
   :volumeId string,
   :selectedText string,
   :layerSummary {:allowedCharacterCount integer,
                  :remainingCharacterCount integer,
                  :limitType string},
   :updated string,
   :selfLink string,
   :highlightStyle string,
   :created string,
   :currentVersionRanges {:contentVersion string,
                          :gbImageRange {:startPosition string,
                                         :endPosition string,
                                         :endOffset string,
                                         :startOffset string},
                          :cfiRange {:startPosition string,
                                     :endPosition string,
                                     :endOffset string,
                                     :startOffset string},
                          :imageCfiRange {:startPosition string,
                                          :endPosition string,
                                          :endOffset string,
                                          :startOffset string},
                          :gbTextRange {:startPosition string,
                                        :endPosition string,
                                        :endOffset string,
                                        :startOffset string}},
   :afterSelectedText string,
   :id string,
   :kind string,
   :pageIds [string],
   :clientVersionRanges {:contentVersion string,
                         :gbTextRange {:startPosition string,
                                       :endPosition string,
                                       :endOffset string,
                                       :startOffset string},
                         :gbImageRange {:startPosition string,
                                        :endPosition string,
                                        :endOffset string,
                                        :startOffset string},
                         :imageCfiRange {:startPosition string,
                                         :endPosition string,
                                         :endOffset string,
                                         :startOffset string},
                         :cfiRange {:startPosition string,
                                    :endPosition string,
                                    :endOffset string,
                                    :startOffset string}},
   :beforeSelectedText string,
   :layerId string,
   :data string}
  
  Inserts a new annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/annotations"
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

(defn annotations-delete$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/annotations/delete
  
  Required parameters: annotationId
  
  Optional parameters: source
  
  Deletes an annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:annotationId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/annotations/{annotationId}"
     #{:annotationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn readingpositions-setPosition$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/readingpositions/setPosition
  
  Required parameters: position, volumeId, timestamp
  
  Optional parameters: deviceCookie, source, contentVersion, action
  
  Sets my reading position information for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId :position :timestamp})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/readingpositions/{volumeId}/setPosition"
     #{:volumeId :position :timestamp}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn readingpositions-get$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/mylibrary/readingpositions/get
  
  Required parameters: volumeId
  
  Optional parameters: contentVersion, source
  
  Retrieves my reading position information for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/mylibrary/readingpositions/{volumeId}"
     #{:volumeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
