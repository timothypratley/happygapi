(ns happygapi.books.layers
  "Books API
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: summaryId,volumeId
  
  Gets the layer summary for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"summaryId" "volumeId"})]}
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
  
  List the layer summaries for a volume."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"volumeId"})]}
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
  "Required parameters: volumeId,contentVersion,layerId,annotationDataId
  
  Gets the annotation data."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"contentVersion" "layerId" "volumeId" "annotationDataId"})]}
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
  "Required parameters: volumeId,contentVersion,layerId
  
  Gets the annotation data for a volume and layer."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"contentVersion" "layerId" "volumeId"})]}
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
  "Required parameters: annotationId,layerId,volumeId
  
  Gets the volume annotation."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"layerId" "volumeId" "annotationId"})]}
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
  "Required parameters: volumeId,contentVersion,layerId
  
  Gets the volume annotations for a volume and layer."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"contentVersion" "layerId" "volumeId"})]}
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
