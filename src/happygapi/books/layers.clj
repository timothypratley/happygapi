(ns happygapi.books.layers
  "Books API: layers.
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/layers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/layers/get
  
  Required parameters: summaryId, volumeId
  
  Optional parameters: contentVersion, source
  
  Gets the layer summary for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId :summaryId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layersummary/{summaryId}"
     #{:volumeId :summaryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/layers/list
  
  Required parameters: volumeId
  
  Optional parameters: contentVersion, maxResults, pageToken, source
  
  List the layer summaries for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:volumeId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layersummary"
     #{:volumeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn annotationData-get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/layers/annotationData/get
  
  Required parameters: volumeId, contentVersion, layerId, annotationDataId
  
  Optional parameters: scale, locale, w, source, allowWebDefinitions, h
  
  Gets the annotation data."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:volumeId :contentVersion :layerId :annotationDataId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layers/{layerId}/data/{annotationDataId}"
     #{:volumeId :contentVersion :layerId :annotationDataId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn annotationData-list$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/layers/annotationData/list
  
  Required parameters: volumeId, contentVersion, layerId
  
  Optional parameters: scale, locale, w, source, pageToken, h, updatedMax, annotationDataId, updatedMin, maxResults
  
  Gets the annotation data for a volume and layer."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:volumeId :contentVersion :layerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layers/{layerId}/data"
     #{:volumeId :contentVersion :layerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn volumeAnnotations-get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/layers/volumeAnnotations/get
  
  Required parameters: annotationId, layerId, volumeId
  
  Optional parameters: locale, source
  
  Gets the volume annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:volumeId :annotationId :layerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layers/{layerId}/annotations/{annotationId}"
     #{:volumeId :annotationId :layerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn volumeAnnotations-list$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/layers/volumeAnnotations/list
  
  Required parameters: volumeId, contentVersion, layerId
  
  Optional parameters: startOffset, endPosition, locale, endOffset, source, pageToken, startPosition, volumeAnnotationsVersion, updatedMax, showDeleted, updatedMin, maxResults
  
  Gets the volume annotations for a volume and layer."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:volumeId :contentVersion :layerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layers/{layerId}"
     #{:volumeId :contentVersion :layerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
