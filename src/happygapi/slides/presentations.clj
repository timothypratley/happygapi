(ns happygapi.slides.presentations
  "Google Slides API
  Reads and writes Google Slides presentations.
  See: https://developers.google.com/slides/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "slides_schema.edn"))))

(defn get$
  "Required parameters: presentationId
  
  Optional parameters: none
  
  Gets the latest version of the specified presentation."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/presentations"
            "https://www.googleapis.com/auth/presentations.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"presentationId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations/{+presentationId}"
     #{"presentationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates a blank presentation using the title given in the request. If a
  `presentationId` is provided, it is used as the ID of the new presentation.
  Otherwise, a new ID is generated. Other fields in the request, including
  any provided content, are ignored.
  Returns the created presentation."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/presentations"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations"
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

(defn batchUpdate$
  "Required parameters: presentationId
  
  Optional parameters: none
  
  Applies one or more updates to the presentation.
  
  Each request is validated before
  being applied. If any request is not valid, then the entire request will
  fail and nothing will be applied.
  
  Some requests have replies to
  give you some information about how they are applied. Other requests do
  not need to return information; these each return an empty reply.
  The order of replies matches that of the requests.
  
  For example, suppose you call batchUpdate with four updates, and only the
  third one returns information. The response would have two empty replies:
  the reply to the third request, and another empty reply, in that order.
  
  Because other users may be editing the presentation, the presentation
  might not exactly reflect your changes: your changes may
  be altered with respect to collaborator changes. If there are no
  collaborators, the presentation should reflect your changes. In any case,
  the updates in your request are guaranteed to be applied together
  atomically."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/presentations"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"presentationId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations/{presentationId}:batchUpdate"
     #{"presentationId"}
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

(defn pages-get$
  "Required parameters: presentationId, pageObjectId
  
  Optional parameters: none
  
  Gets the latest version of the specified page in the presentation."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/presentations"
            "https://www.googleapis.com/auth/presentations.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"presentationId" "pageObjectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations/{presentationId}/pages/{pageObjectId}"
     #{"presentationId" "pageObjectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn pages-getThumbnail$
  "Required parameters: pageObjectId, presentationId
  
  Optional parameters: thumbnailProperties.mimeType, thumbnailProperties.thumbnailSize
  
  Generates a thumbnail of the latest version of the specified page in the
  presentation and returns a URL to the thumbnail image.
  
  This request counts as an [expensive read request](/slides/limits) for
  quota purposes."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/presentations"
            "https://www.googleapis.com/auth/presentations.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"presentationId" "pageObjectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations/{presentationId}/pages/{pageObjectId}/thumbnail"
     #{"presentationId" "pageObjectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
