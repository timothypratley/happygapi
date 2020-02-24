(ns happygapi.sheets.spreadsheets
  "Google Sheets API
  Reads and writes Google Sheets.
  See: https://developers.google.com/sheets/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn create$
  "Required parameters: none
  
  Creates a spreadsheet, returning the newly created spreadsheet."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets"
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

(defn batchUpdate$
  "Required parameters: spreadsheetId
  
  Applies one or more updates to the spreadsheet.
  
  Each request is validated before
  being applied. If any request is not valid then the entire request will
  fail and nothing will be applied.
  
  Some requests have replies to
  give you some information about how
  they are applied. The replies will mirror the requests.  For example,
  if you applied 4 updates and the 3rd one had a reply, then the
  response will have 2 empty replies, the actual reply, and another empty
  reply, in that order.
  
  Due to the collaborative nature of spreadsheets, it is not guaranteed that
  the spreadsheet will reflect exactly your changes after this completes,
  however it is guaranteed that the updates in the request will be
  applied together atomically. Your changes may be altered with respect to
  collaborator changes. If there are no collaborators, the spreadsheet
  should reflect your changes."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}:batchUpdate"
     #{"spreadsheetId"}
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

(defn get$
  "Required parameters: spreadsheetId
  
  Returns the spreadsheet at the given ID.
  The caller must specify the spreadsheet ID.
  
  By default, data within grids will not be returned.
  You can include grid data one of two ways:
  
  * Specify a field mask listing your desired fields using the `fields` URL
  parameter in HTTP
  
  * Set the includeGridData
  URL parameter to true.  If a field mask is set, the `includeGridData`
  parameter is ignored
  
  For large spreadsheets, it is recommended to retrieve only the specific
  fields of the spreadsheet that you want.
  
  To retrieve only subsets of the spreadsheet, use the
  ranges URL parameter.
  Multiple ranges can be specified.  Limiting the range will
  return only the portions of the spreadsheet that intersect the requested
  ranges. Ranges are specified using A1 notation."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}"
     #{"spreadsheetId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getByDataFilter$
  "Required parameters: spreadsheetId
  
  Returns the spreadsheet at the given ID.
  The caller must specify the spreadsheet ID.
  
  This method differs from GetSpreadsheet in that it allows selecting
  which subsets of spreadsheet data to return by specifying a
  dataFilters parameter.
  Multiple DataFilters can be specified.  Specifying one or
  more data filters will return the portions of the spreadsheet that
  intersect ranges matched by any of the filters.
  
  By default, data within grids will not be returned.
  You can include grid data one of two ways:
  
  * Specify a field mask listing your desired fields using the `fields` URL
  parameter in HTTP
  
  * Set the includeGridData
  parameter to true.  If a field mask is set, the `includeGridData`
  parameter is ignored
  
  For large spreadsheets, it is recommended to retrieve only the specific
  fields of the spreadsheet that you want."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}:getByDataFilter"
     #{"spreadsheetId"}
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

(defn developerMetadata-search$
  "Required parameters: spreadsheetId
  
  Returns all developer metadata matching the specified DataFilter.
  If the provided DataFilter represents a DeveloperMetadataLookup object,
  this will return all DeveloperMetadata entries selected by it. If the
  DataFilter represents a location in a spreadsheet, this will return all
  developer metadata associated with locations intersecting that region."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/developerMetadata:search"
     #{"spreadsheetId"}
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

(defn developerMetadata-get$
  "Required parameters: spreadsheetId,metadataId
  
  Returns the developer metadata with the specified ID.
  The caller must specify the spreadsheet ID and the developer metadata's
  unique metadataId."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args]
  {:pre [(util/has-keys? args #{"metadataId" "spreadsheetId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/developerMetadata/{metadataId}"
     #{"metadataId" "spreadsheetId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn values-batchGetByDataFilter$
  "Required parameters: spreadsheetId
  
  Returns one or more ranges of values that match the specified data filters.
  The caller must specify the spreadsheet ID and one or more
  DataFilters.  Ranges that match any of the data filters in
  the request will be returned."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchGetByDataFilter"
     #{"spreadsheetId"}
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

(defn values-get$
  "Required parameters: range,spreadsheetId
  
  Returns a range of values from a spreadsheet.
  The caller must specify the spreadsheet ID and a range."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"range" "spreadsheetId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values/{range}"
     #{"range" "spreadsheetId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn values-batchUpdate$
  "Required parameters: spreadsheetId
  
  Sets values in one or more ranges of a spreadsheet.
  The caller must specify the spreadsheet ID,
  a valueInputOption, and one or more
  ValueRanges."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchUpdate"
     #{"spreadsheetId"}
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

(defn values-batchGet$
  "Required parameters: spreadsheetId
  
  Returns one or more ranges of values from a spreadsheet.
  The caller must specify the spreadsheet ID and one or more ranges."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchGet"
     #{"spreadsheetId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn values-batchClearByDataFilter$
  "Required parameters: spreadsheetId
  
  Clears one or more ranges of values from a spreadsheet.
  The caller must specify the spreadsheet ID and one or more
  DataFilters. Ranges matching any of the specified data
  filters will be cleared.  Only values are cleared -- all other properties
  of the cell (such as formatting, data validation, etc..) are kept."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchClearByDataFilter"
     #{"spreadsheetId"}
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

(defn values-append$
  "Required parameters: range,spreadsheetId
  
  Appends values to a spreadsheet. The input range is used to search for
  existing data and find a \"table\" within that range. Values will be
  appended to the next row of the table, starting with the first column of
  the table. See the
  [guide](/sheets/api/guides/values#appending_values)
  and
  [sample code](/sheets/api/samples/writing#append_values)
  for specific details of how tables are detected and data is appended.
  
  The caller must specify the spreadsheet ID, range, and
  a valueInputOption.  The `valueInputOption` only
  controls how the input data will be added to the sheet (column-wise or
  row-wise), it does not influence what cell the data starts being written
  to."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"range" "spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values/{range}:append"
     #{"range" "spreadsheetId"}
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

(defn values-update$
  "Required parameters: range,spreadsheetId
  
  Sets values in a range of a spreadsheet.
  The caller must specify the spreadsheet ID, range, and
  a valueInputOption."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args]
  {:pre [(util/has-keys? args #{"range" "spreadsheetId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values/{range}"
     #{"range" "spreadsheetId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn values-batchUpdateByDataFilter$
  "Required parameters: spreadsheetId
  
  Sets values in one or more ranges of a spreadsheet.
  The caller must specify the spreadsheet ID,
  a valueInputOption, and one or more
  DataFilterValueRanges."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchUpdateByDataFilter"
     #{"spreadsheetId"}
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

(defn values-batchClear$
  "Required parameters: spreadsheetId
  
  Clears one or more ranges of values from a spreadsheet.
  The caller must specify the spreadsheet ID and one or more ranges.
  Only values are cleared -- all other properties of the cell (such as
  formatting, data validation, etc..) are kept."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchClear"
     #{"spreadsheetId"}
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

(defn values-clear$
  "Required parameters: spreadsheetId,range
  
  Clears values from a spreadsheet.
  The caller must specify the spreadsheet ID and range.
  Only values are cleared -- all other properties of the cell (such as
  formatting, data validation, etc..) are kept."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"range" "spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values/{range}:clear"
     #{"range" "spreadsheetId"}
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

(defn sheets-copyTo$
  "Required parameters: sheetId,spreadsheetId
  
  Copies a single sheet from a spreadsheet to another spreadsheet.
  Returns the properties of the newly created sheet."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"sheetId" "spreadsheetId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/sheets/{sheetId}:copyTo"
     #{"sheetId" "spreadsheetId"}
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
