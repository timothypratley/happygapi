(ns happygapi.books.layers
  "Books API
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_started"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "books_schema.edn"))))

(defn get$
  "Required parameters: summaryId, volumeId
  
  Optional parameters: contentVersion, source
  
  Gets the layer summary for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"summaryId" "volumeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layersummary/{summaryId}"
     #{"summaryId" "volumeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: volumeId
  
  Optional parameters: contentVersion, maxResults, pageToken, source
  
  List the layer summaries for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"volumeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layersummary"
     #{"volumeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn annotationData-get$
  "Required parameters: volumeId, contentVersion, layerId, annotationDataId
  
  Optional parameters: scale, locale, w, source, allowWebDefinitions, h
  
  Gets the annotation data."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"contentVersion" "layerId" "volumeId" "annotationDataId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layers/{layerId}/data/{annotationDataId}"
     #{"layerId" "volumeId" "annotationDataId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn annotationData-list$
  "Required parameters: volumeId, contentVersion, layerId
  
  Optional parameters: scale, locale, w, source, pageToken, h, updatedMax, annotationDataId, updatedMin, maxResults
  
  Gets the annotation data for a volume and layer."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"contentVersion" "layerId" "volumeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layers/{layerId}/data"
     #{"layerId" "volumeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn volumeAnnotations-get$
  "Required parameters: annotationId, layerId, volumeId
  
  Optional parameters: locale, source
  
  Gets the volume annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"layerId" "volumeId" "annotationId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layers/{layerId}/annotations/{annotationId}"
     #{"layerId" "volumeId" "annotationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn volumeAnnotations-list$
  "Required parameters: volumeId, contentVersion, layerId
  
  Optional parameters: startOffset, endPosition, locale, endOffset, source, pageToken, startPosition, volumeAnnotationsVersion, updatedMax, showDeleted, updatedMin, maxResults
  
  Gets the volume annotations for a volume and layer."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"contentVersion" "layerId" "volumeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "volumes/{volumeId}/layers/{layerId}"
     #{"layerId" "volumeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
