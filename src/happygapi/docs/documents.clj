(ns happygapi.docs.documents
  "Google Docs API: documents.
  Reads and writes Google Docs documents.
  See: https://developers.google.com/docs/api/reference/rest/v1/documents"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/docs/api/reference/rest/v1/documents/get
  
  Required parameters: documentId
  
  Optional parameters: suggestionsViewMode
  
  Gets the latest version of the specified document."
  {:scopes ["https://www.googleapis.com/auth/documents"
            "https://www.googleapis.com/auth/documents.readonly"
            "https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:documentId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://docs.googleapis.com/"
     "v1/documents/{documentId}"
     #{:documentId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/docs/api/reference/rest/v1/documents/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:suggestedDocumentStyleChanges {},
   :footnotes {},
   :lists {},
   :positionedObjects {},
   :footers {},
   :inlineObjects {},
   :namedRanges {},
   :revisionId string,
   :namedStyles {:styles [NamedStyle]},
   :suggestedNamedStylesChanges {},
   :documentStyle {:defaultHeaderId string,
                   :marginLeft Dimension,
                   :evenPageFooterId string,
                   :useFirstPageHeaderFooter boolean,
                   :useCustomHeaderFooterMargins boolean,
                   :background Background,
                   :marginTop Dimension,
                   :pageNumberStart integer,
                   :firstPageHeaderId string,
                   :defaultFooterId string,
                   :firstPageFooterId string,
                   :pageSize Size,
                   :evenPageHeaderId string,
                   :marginBottom Dimension,
                   :marginHeader Dimension,
                   :useEvenPageHeaderFooter boolean,
                   :marginFooter Dimension,
                   :marginRight Dimension},
   :title string,
   :suggestionsViewMode string,
   :headers {},
   :documentId string,
   :body {:content [StructuralElement]}}
  
  Creates a blank document using the title given in the request. Other fields
  in the request, including any provided content, are ignored.
  
  Returns the created document."
  {:scopes ["https://www.googleapis.com/auth/documents"
            "https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://docs.googleapis.com/"
     "v1/documents"
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
  "https://developers.google.com/docs/api/reference/rest/v1/documents/batchUpdate
  
  Required parameters: documentId
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:updateSectionStyle UpdateSectionStyleRequest,
               :deletePositionedObject DeletePositionedObjectRequest,
               :createNamedRange CreateNamedRangeRequest,
               :replaceNamedRangeContent ReplaceNamedRangeContentRequest,
               :deleteContentRange DeleteContentRangeRequest,
               :createFooter CreateFooterRequest,
               :insertTable InsertTableRequest,
               :deleteTableRow DeleteTableRowRequest,
               :insertTableColumn InsertTableColumnRequest,
               :updateTextStyle UpdateTextStyleRequest,
               :replaceAllText ReplaceAllTextRequest,
               :updateTableCellStyle UpdateTableCellStyleRequest,
               :insertInlineImage InsertInlineImageRequest,
               :updateDocumentStyle UpdateDocumentStyleRequest,
               :deleteHeader DeleteHeaderRequest,
               :mergeTableCells MergeTableCellsRequest,
               :updateTableColumnProperties UpdateTableColumnPropertiesRequest,
               :createHeader CreateHeaderRequest,
               :updateTableRowStyle UpdateTableRowStyleRequest,
               :updateParagraphStyle UpdateParagraphStyleRequest,
               :replaceImage ReplaceImageRequest,
               :deleteFooter DeleteFooterRequest,
               :insertPageBreak InsertPageBreakRequest,
               :insertText InsertTextRequest,
               :deleteParagraphBullets DeleteParagraphBulletsRequest,
               :deleteNamedRange DeleteNamedRangeRequest,
               :createParagraphBullets CreateParagraphBulletsRequest,
               :deleteTableColumn DeleteTableColumnRequest,
               :unmergeTableCells UnmergeTableCellsRequest,
               :createFootnote CreateFootnoteRequest,
               :insertTableRow InsertTableRowRequest,
               :insertSectionBreak InsertSectionBreakRequest}],
   :writeControl {:targetRevisionId string, :requiredRevisionId string}}
  
  Applies one or more updates to the document.
  
  Each request is validated before
  being applied. If any request is not valid, then the entire request will
  fail and nothing will be applied.
  
  Some requests have replies to
  give you some information about how they are applied. Other requests do
  not need to return information; these each return an empty reply.
  The order of replies matches that of the requests.
  
  For example, suppose you call batchUpdate with four updates, and only the
  third one returns information. The response would have two empty replies,
  the reply to the third request, and another empty reply, in that order.
  
  Because other users may be editing the document, the document
  might not exactly reflect your changes: your changes may
  be altered with respect to collaborator changes. If there are no
  collaborators, the document should reflect your changes. In any case,
  the updates in your request are guaranteed to be applied together
  atomically."
  {:scopes ["https://www.googleapis.com/auth/documents"
            "https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:documentId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://docs.googleapis.com/"
     "v1/documents/{documentId}:batchUpdate"
     #{:documentId}
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
