(ns happygapi.sheets.spreadsheets
  "Google Sheets API: spreadsheets.
  Reads and writes Google Sheets.
  See: https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/get
  
  Required parameters: spreadsheetId
  
  Optional parameters: includeGridData, ranges
  
  Returns the spreadsheet at the given ID. The caller must specify the spreadsheet ID. By default, data within grids will not be returned. You can include grid data one of two ways: * Specify a field mask listing your desired fields using the `fields` URL parameter in HTTP * Set the includeGridData URL parameter to true. If a field mask is set, the `includeGridData` parameter is ignored For large spreadsheets, it is recommended to retrieve only the specific fields of the spreadsheet that you want. To retrieve only subsets of the spreadsheet, use the ranges URL parameter. Multiple ranges can be specified. Limiting the range will return only the portions of the spreadsheet that intersect the requested ranges. Ranges are specified using A1 notation."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}"
     #{:spreadsheetId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:spreadsheetUrl string,
   :properties {:timeZone string,
                :iterativeCalculationSettings IterativeCalculationSettings,
                :locale string,
                :autoRecalc string,
                :defaultFormat CellFormat,
                :title string,
                :spreadsheetTheme SpreadsheetTheme},
   :namedRanges [{:namedRangeId string, :name string, :range GridRange}],
   :developerMetadata [{:location DeveloperMetadataLocation,
                        :metadataKey string,
                        :visibility string,
                        :metadataId integer,
                        :metadataValue string}],
   :sheets [{:properties SheetProperties,
             :filterViews [FilterView],
             :slicers [Slicer],
             :columnGroups [DimensionGroup],
             :developerMetadata [DeveloperMetadata],
             :protectedRanges [ProtectedRange],
             :rowGroups [DimensionGroup],
             :bandedRanges [BandedRange],
             :basicFilter BasicFilter,
             :merges [GridRange],
             :charts [EmbeddedChart],
             :conditionalFormats [ConditionalFormatRule],
             :data [GridData]}],
   :dataSources [{:spec DataSourceSpec,
                  :calculatedColumns [DataSourceColumn],
                  :dataSourceId string,
                  :sheetId integer}],
   :dataSourceSchedules [{:nextRun Interval,
                          :dailySchedule DataSourceRefreshDailySchedule,
                          :monthlySchedule DataSourceRefreshMonthlySchedule,
                          :weeklySchedule DataSourceRefreshWeeklySchedule,
                          :refreshScope string,
                          :enabled boolean}],
   :spreadsheetId string}
  
  Creates a spreadsheet, returning the newly created spreadsheet."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets"
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
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/batchUpdate
  
  Required parameters: spreadsheetId
  
  Optional parameters: none
  
  Body: 
  
  {:responseIncludeGridData boolean,
   :requests [{:moveDimension MoveDimensionRequest,
               :repeatCell RepeatCellRequest,
               :updateFilterView UpdateFilterViewRequest,
               :addSlicer AddSlicerRequest,
               :deleteEmbeddedObject DeleteEmbeddedObjectRequest,
               :deleteBanding DeleteBandingRequest,
               :addDimensionGroup AddDimensionGroupRequest,
               :addConditionalFormatRule AddConditionalFormatRuleRequest,
               :updateDimensionGroup UpdateDimensionGroupRequest,
               :updateCells UpdateCellsRequest,
               :updateProtectedRange UpdateProtectedRangeRequest,
               :addFilterView AddFilterViewRequest,
               :autoResizeDimensions AutoResizeDimensionsRequest,
               :insertDimension InsertDimensionRequest,
               :addDataSource AddDataSourceRequest,
               :updateChartSpec UpdateChartSpecRequest,
               :duplicateSheet DuplicateSheetRequest,
               :trimWhitespace TrimWhitespaceRequest,
               :pasteData PasteDataRequest,
               :deleteDataSource DeleteDataSourceRequest,
               :updateSpreadsheetProperties UpdateSpreadsheetPropertiesRequest,
               :addBanding AddBandingRequest,
               :updateBanding UpdateBandingRequest,
               :deleteDuplicates DeleteDuplicatesRequest,
               :deleteSheet DeleteSheetRequest,
               :deleteProtectedRange DeleteProtectedRangeRequest,
               :updateDeveloperMetadata UpdateDeveloperMetadataRequest,
               :updateSheetProperties UpdateSheetPropertiesRequest,
               :duplicateFilterView DuplicateFilterViewRequest,
               :updateDimensionProperties UpdateDimensionPropertiesRequest,
               :deleteDeveloperMetadata DeleteDeveloperMetadataRequest,
               :unmergeCells UnmergeCellsRequest,
               :createDeveloperMetadata CreateDeveloperMetadataRequest,
               :updateDataSource UpdateDataSourceRequest,
               :cutPaste CutPasteRequest,
               :appendDimension AppendDimensionRequest,
               :deleteFilterView DeleteFilterViewRequest,
               :deleteRange DeleteRangeRequest,
               :setDataValidation SetDataValidationRequest,
               :deleteConditionalFormatRule DeleteConditionalFormatRuleRequest,
               :refreshDataSource RefreshDataSourceRequest,
               :appendCells AppendCellsRequest,
               :textToColumns TextToColumnsRequest,
               :deleteDimensionGroup DeleteDimensionGroupRequest,
               :mergeCells MergeCellsRequest,
               :randomizeRange RandomizeRangeRequest,
               :insertRange InsertRangeRequest,
               :deleteNamedRange DeleteNamedRangeRequest,
               :updateNamedRange UpdateNamedRangeRequest,
               :findReplace FindReplaceRequest,
               :updateEmbeddedObjectPosition UpdateEmbeddedObjectPositionRequest,
               :addSheet AddSheetRequest,
               :updateBorders UpdateBordersRequest,
               :addNamedRange AddNamedRangeRequest,
               :addChart AddChartRequest,
               :addProtectedRange AddProtectedRangeRequest,
               :setBasicFilter SetBasicFilterRequest,
               :clearBasicFilter ClearBasicFilterRequest,
               :sortRange SortRangeRequest,
               :deleteDimension DeleteDimensionRequest,
               :updateSlicerSpec UpdateSlicerSpecRequest,
               :autoFill AutoFillRequest,
               :copyPaste CopyPasteRequest,
               :updateConditionalFormatRule UpdateConditionalFormatRuleRequest}],
   :includeSpreadsheetInResponse boolean,
   :responseRanges [string]}
  
  Applies one or more updates to the spreadsheet. Each request is validated before being applied. If any request is not valid then the entire request will fail and nothing will be applied. Some requests have replies to give you some information about how they are applied. The replies will mirror the requests. For example, if you applied 4 updates and the 3rd one had a reply, then the response will have 2 empty replies, the actual reply, and another empty reply, in that order. Due to the collaborative nature of spreadsheets, it is not guaranteed that the spreadsheet will reflect exactly your changes after this completes, however it is guaranteed that the updates in the request will be applied together atomically. Your changes may be altered with respect to collaborator changes. If there are no collaborators, the spreadsheet should reflect your changes."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}:batchUpdate"
     #{:spreadsheetId}
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

(defn getByDataFilter$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/getByDataFilter
  
  Required parameters: spreadsheetId
  
  Optional parameters: none
  
  Body: 
  
  {:dataFilters [{:developerMetadataLookup DeveloperMetadataLookup,
                  :gridRange GridRange,
                  :a1Range string}],
   :includeGridData boolean}
  
  Returns the spreadsheet at the given ID. The caller must specify the spreadsheet ID. This method differs from GetSpreadsheet in that it allows selecting which subsets of spreadsheet data to return by specifying a dataFilters parameter. Multiple DataFilters can be specified. Specifying one or more data filters will return the portions of the spreadsheet that intersect ranges matched by any of the filters. By default, data within grids will not be returned. You can include grid data one of two ways: * Specify a field mask listing your desired fields using the `fields` URL parameter in HTTP * Set the includeGridData parameter to true. If a field mask is set, the `includeGridData` parameter is ignored For large spreadsheets, it is recommended to retrieve only the specific fields of the spreadsheet that you want."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}:getByDataFilter"
     #{:spreadsheetId}
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

(defn developerMetadata-search$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/developerMetadata/search
  
  Required parameters: spreadsheetId
  
  Optional parameters: none
  
  Body: 
  
  {:dataFilters [{:developerMetadataLookup DeveloperMetadataLookup,
                  :gridRange GridRange,
                  :a1Range string}]}
  
  Returns all developer metadata matching the specified DataFilter. If the provided DataFilter represents a DeveloperMetadataLookup object, this will return all DeveloperMetadata entries selected by it. If the DataFilter represents a location in a spreadsheet, this will return all developer metadata associated with locations intersecting that region."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/developerMetadata:search"
     #{:spreadsheetId}
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

(defn developerMetadata-get$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/developerMetadata/get
  
  Required parameters: metadataId, spreadsheetId
  
  Optional parameters: none
  
  Returns the developer metadata with the specified ID. The caller must specify the spreadsheet ID and the developer metadata's unique metadataId."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:spreadsheetId :metadataId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/developerMetadata/{metadataId}"
     #{:spreadsheetId :metadataId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sheets-copyTo$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/sheets/copyTo
  
  Required parameters: spreadsheetId, sheetId
  
  Optional parameters: none
  
  Body: 
  
  {:destinationSpreadsheetId string}
  
  Copies a single sheet from a spreadsheet to another spreadsheet. Returns the properties of the newly created sheet."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sheetId :spreadsheetId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/sheets/{sheetId}:copyTo"
     #{:sheetId :spreadsheetId}
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

(defn values-batchGetByDataFilter$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/batchGetByDataFilter
  
  Required parameters: spreadsheetId
  
  Optional parameters: none
  
  Body: 
  
  {:dataFilters [{:developerMetadataLookup DeveloperMetadataLookup,
                  :gridRange GridRange,
                  :a1Range string}],
   :dateTimeRenderOption string,
   :valueRenderOption string,
   :majorDimension string}
  
  Returns one or more ranges of values that match the specified data filters. The caller must specify the spreadsheet ID and one or more DataFilters. Ranges that match any of the data filters in the request will be returned."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchGetByDataFilter"
     #{:spreadsheetId}
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

(defn values-get$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/get
  
  Required parameters: range, spreadsheetId
  
  Optional parameters: majorDimension, dateTimeRenderOption, valueRenderOption
  
  Returns a range of values from a spreadsheet. The caller must specify the spreadsheet ID and a range."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:spreadsheetId :range})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values/{range}"
     #{:spreadsheetId :range}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn values-batchUpdate$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/batchUpdate
  
  Required parameters: spreadsheetId
  
  Optional parameters: none
  
  Body: 
  
  {:valueInputOption string,
   :data [{:values [[any]], :majorDimension string, :range string}],
   :includeValuesInResponse boolean,
   :responseDateTimeRenderOption string,
   :responseValueRenderOption string}
  
  Sets values in one or more ranges of a spreadsheet. The caller must specify the spreadsheet ID, a valueInputOption, and one or more ValueRanges."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchUpdate"
     #{:spreadsheetId}
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

(defn values-batchGet$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/batchGet
  
  Required parameters: spreadsheetId
  
  Optional parameters: ranges, majorDimension, valueRenderOption, dateTimeRenderOption
  
  Returns one or more ranges of values from a spreadsheet. The caller must specify the spreadsheet ID and one or more ranges."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchGet"
     #{:spreadsheetId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn values-batchClearByDataFilter$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/batchClearByDataFilter
  
  Required parameters: spreadsheetId
  
  Optional parameters: none
  
  Body: 
  
  {:dataFilters [{:developerMetadataLookup DeveloperMetadataLookup,
                  :gridRange GridRange,
                  :a1Range string}]}
  
  Clears one or more ranges of values from a spreadsheet. The caller must specify the spreadsheet ID and one or more DataFilters. Ranges matching any of the specified data filters will be cleared. Only values are cleared -- all other properties of the cell (such as formatting, data validation, etc..) are kept."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchClearByDataFilter"
     #{:spreadsheetId}
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

(defn values-append$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/append
  
  Required parameters: range, spreadsheetId
  
  Optional parameters: insertDataOption, responseValueRenderOption, responseDateTimeRenderOption, includeValuesInResponse, valueInputOption
  
  Body: 
  
  {:values [[any]], :majorDimension string, :range string}
  
  Appends values to a spreadsheet. The input range is used to search for existing data and find a \"table\" within that range. Values will be appended to the next row of the table, starting with the first column of the table. See the [guide](/sheets/api/guides/values#appending_values) and [sample code](/sheets/api/samples/writing#append_values) for specific details of how tables are detected and data is appended. The caller must specify the spreadsheet ID, range, and a valueInputOption. The `valueInputOption` only controls how the input data will be added to the sheet (column-wise or row-wise), it does not influence what cell the data starts being written to."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId :range})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values/{range}:append"
     #{:spreadsheetId :range}
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

(defn values-update$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/update
  
  Required parameters: range, spreadsheetId
  
  Optional parameters: responseValueRenderOption, responseDateTimeRenderOption, valueInputOption, includeValuesInResponse
  
  Body: 
  
  {:values [[any]], :majorDimension string, :range string}
  
  Sets values in a range of a spreadsheet. The caller must specify the spreadsheet ID, range, and a valueInputOption."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId :range})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values/{range}"
     #{:spreadsheetId :range}
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

(defn values-batchUpdateByDataFilter$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/batchUpdateByDataFilter
  
  Required parameters: spreadsheetId
  
  Optional parameters: none
  
  Body: 
  
  {:data [{:dataFilter DataFilter,
           :majorDimension string,
           :values [[any]]}],
   :responseValueRenderOption string,
   :valueInputOption string,
   :responseDateTimeRenderOption string,
   :includeValuesInResponse boolean}
  
  Sets values in one or more ranges of a spreadsheet. The caller must specify the spreadsheet ID, a valueInputOption, and one or more DataFilterValueRanges."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchUpdateByDataFilter"
     #{:spreadsheetId}
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

(defn values-batchClear$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/batchClear
  
  Required parameters: spreadsheetId
  
  Optional parameters: none
  
  Body: 
  
  {:ranges [string]}
  
  Clears one or more ranges of values from a spreadsheet. The caller must specify the spreadsheet ID and one or more ranges. Only values are cleared -- all other properties of the cell (such as formatting, data validation, etc..) are kept."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values:batchClear"
     #{:spreadsheetId}
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

(defn values-clear$
  "https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets/values/clear
  
  Required parameters: spreadsheetId, range
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Clears values from a spreadsheet. The caller must specify the spreadsheet ID and range. Only values are cleared -- all other properties of the cell (such as formatting, data validation, etc..) are kept."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:spreadsheetId :range})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sheets.googleapis.com/"
     "v4/spreadsheets/{spreadsheetId}/values/{range}:clear"
     #{:spreadsheetId :range}
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
