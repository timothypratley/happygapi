(ns happygapi.slides.presentations
  "Google Slides API: presentations.
  Reads and writes Google Slides presentations.
  See: https://developers.google.com/slides/api/reference/rest/v1/presentations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/slides/api/reference/rest/v1/presentations/get
  
  Required parameters: presentationId
  
  Optional parameters: none
  
  Gets the latest version of the specified presentation."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/presentations"
            "https://www.googleapis.com/auth/presentations.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:presentationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations/{+presentationId}"
     #{:presentationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/slides/api/reference/rest/v1/presentations/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:locale string,
   :notesMaster {:notesProperties NotesProperties,
                 :objectId string,
                 :revisionId string,
                 :pageElements [PageElement],
                 :slideProperties SlideProperties,
                 :pageType string,
                 :masterProperties MasterProperties,
                 :layoutProperties LayoutProperties,
                 :pageProperties PageProperties},
   :slides [{:notesProperties NotesProperties,
             :objectId string,
             :revisionId string,
             :pageElements [PageElement],
             :slideProperties SlideProperties,
             :pageType string,
             :masterProperties MasterProperties,
             :layoutProperties LayoutProperties,
             :pageProperties PageProperties}],
   :revisionId string,
   :title string,
   :layouts [{:notesProperties NotesProperties,
              :objectId string,
              :revisionId string,
              :pageElements [PageElement],
              :slideProperties SlideProperties,
              :pageType string,
              :masterProperties MasterProperties,
              :layoutProperties LayoutProperties,
              :pageProperties PageProperties}],
   :pageSize {:height Dimension, :width Dimension},
   :masters [{:notesProperties NotesProperties,
              :objectId string,
              :revisionId string,
              :pageElements [PageElement],
              :slideProperties SlideProperties,
              :pageType string,
              :masterProperties MasterProperties,
              :layoutProperties LayoutProperties,
              :pageProperties PageProperties}],
   :presentationId string}
  
  Creates a blank presentation using the title given in the request. If a
  `presentationId` is provided, it is used as the ID of the new presentation.
  Otherwise, a new ID is generated. Other fields in the request, including
  any provided content, are ignored.
  Returns the created presentation."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/presentations"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations"
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

(defn batchUpdate$
  "https://developers.google.com/slides/api/reference/rest/v1/presentations/batchUpdate
  
  Required parameters: presentationId
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:updateImageProperties UpdateImagePropertiesRequest,
               :updatePageElementsZOrder UpdatePageElementsZOrderRequest,
               :updatePageElementTransform UpdatePageElementTransformRequest,
               :createLine CreateLineRequest,
               :createImage CreateImageRequest,
               :deleteText DeleteTextRequest,
               :createSheetsChart CreateSheetsChartRequest,
               :replaceAllShapesWithImage ReplaceAllShapesWithImageRequest,
               :updatePageElementAltText UpdatePageElementAltTextRequest,
               :duplicateObject DuplicateObjectRequest,
               :rerouteLine RerouteLineRequest,
               :deleteTableRow DeleteTableRowRequest,
               :createVideo CreateVideoRequest,
               :replaceAllShapesWithSheetsChart ReplaceAllShapesWithSheetsChartRequest,
               :insertTableRows InsertTableRowsRequest,
               :updateTextStyle UpdateTextStyleRequest,
               :replaceAllText ReplaceAllTextRequest,
               :updateLineCategory UpdateLineCategoryRequest,
               :refreshSheetsChart RefreshSheetsChartRequest,
               :mergeTableCells MergeTableCellsRequest,
               :updateTableColumnProperties UpdateTableColumnPropertiesRequest,
               :updateTableRowProperties UpdateTableRowPropertiesRequest,
               :updateParagraphStyle UpdateParagraphStyleRequest,
               :replaceImage ReplaceImageRequest,
               :updateShapeProperties UpdateShapePropertiesRequest,
               :groupObjects GroupObjectsRequest,
               :updateLineProperties UpdateLinePropertiesRequest,
               :updateTableCellProperties UpdateTableCellPropertiesRequest,
               :updatePageProperties UpdatePagePropertiesRequest,
               :createShape CreateShapeRequest,
               :insertText InsertTextRequest,
               :deleteParagraphBullets DeleteParagraphBulletsRequest,
               :updateTableBorderProperties UpdateTableBorderPropertiesRequest,
               :deleteObject DeleteObjectRequest,
               :createParagraphBullets CreateParagraphBulletsRequest,
               :deleteTableColumn DeleteTableColumnRequest,
               :updateVideoProperties UpdateVideoPropertiesRequest,
               :createSlide CreateSlideRequest,
               :unmergeTableCells UnmergeTableCellsRequest,
               :ungroupObjects UngroupObjectsRequest,
               :updateSlidesPosition UpdateSlidesPositionRequest,
               :insertTableColumns InsertTableColumnsRequest,
               :createTable CreateTableRequest}],
   :writeControl {:requiredRevisionId string}}
  
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:presentationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations/{presentationId}:batchUpdate"
     #{:presentationId}
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

(defn pages-get$
  "https://developers.google.com/slides/api/reference/rest/v1/presentations/pages/get
  
  Required parameters: presentationId, pageObjectId
  
  Optional parameters: none
  
  Gets the latest version of the specified page in the presentation."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/presentations"
            "https://www.googleapis.com/auth/presentations.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:pageObjectId :presentationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations/{presentationId}/pages/{pageObjectId}"
     #{:pageObjectId :presentationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn pages-getThumbnail$
  "https://developers.google.com/slides/api/reference/rest/v1/presentations/pages/getThumbnail
  
  Required parameters: presentationId, pageObjectId
  
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
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:pageObjectId :presentationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://slides.googleapis.com/"
     "v1/presentations/{presentationId}/pages/{pageObjectId}/thumbnail"
     #{:pageObjectId :presentationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
