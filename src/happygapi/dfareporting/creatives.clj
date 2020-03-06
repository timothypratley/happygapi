(ns happygapi.dfareporting.creatives
  "DCM/DFA Reporting And Trafficking API: creatives.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creatives"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creatives/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Gets one creative by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creatives/{id}"
     #{:id :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creatives/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :counterCustomEvents [{:advertiserCustomEventName string,
                          :popupWindowProperties PopupWindowProperties,
                          :artworkType string,
                          :artworkLabel string,
                          :videoReportingId string,
                          :advertiserCustomEventId string,
                          :id string,
                          :targetType string,
                          :exitClickThroughUrl CreativeClickThroughUrl,
                          :advertiserCustomEventType string}],
   :thirdPartyBackupImageImpressionsUrl string,
   :overrideCss string,
   :adParameters string,
   :skippable boolean,
   :allowScriptAccess boolean,
   :customKeyValues [string],
   :studioCreativeId string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :additionalSizes [{:height integer,
                      :iab boolean,
                      :id string,
                      :kind string,
                      :width integer}],
   :fsCommand {:left integer,
               :positionOption string,
               :top integer,
               :windowHeight integer,
               :windowWidth integer},
   :backupImageClickThroughUrl {:computedClickThroughUrl string,
                                :customClickThroughUrl string,
                                :landingPageId string},
   :timerCustomEvents [{:advertiserCustomEventName string,
                        :popupWindowProperties PopupWindowProperties,
                        :artworkType string,
                        :artworkLabel string,
                        :videoReportingId string,
                        :advertiserCustomEventId string,
                        :id string,
                        :targetType string,
                        :exitClickThroughUrl CreativeClickThroughUrl,
                        :advertiserCustomEventType string}],
   :sslOverride boolean,
   :compatibility [string],
   :sslCompliant boolean,
   :skipOffset {:offsetPercentage integer, :offsetSeconds integer},
   :thirdPartyRichMediaImpressionsUrl string,
   :name string,
   :convertFlashToHtml5 boolean,
   :universalAdId {:registry string, :value string},
   :artworkType string,
   :authoringSource string,
   :type string,
   :creativeAssets [{:role string,
                     :fileSize string,
                     :idDimensionValue DimensionValue,
                     :additionalSizes [Size],
                     :windowMode string,
                     :bitRate integer,
                     :verticallyLocked boolean,
                     :offset OffsetPosition,
                     :horizontallyLocked boolean,
                     :sslCompliant boolean,
                     :positionLeftUnit string,
                     :frameRate number,
                     :alignment string,
                     :pushdownDuration number,
                     :artworkType string,
                     :zipFilesize string,
                     :childAssetType string,
                     :startTimeType string,
                     :orientation string,
                     :flashVersion integer,
                     :duration integer,
                     :streamingServingUrl string,
                     :audioSampleRate integer,
                     :displayType string,
                     :detectedFeatures [string],
                     :size Size,
                     :progressiveServingUrl string,
                     :originalBackup boolean,
                     :collapsedSize Size,
                     :durationType string,
                     :hideFlashObjects boolean,
                     :positionTopUnit string,
                     :active boolean,
                     :id string,
                     :customStartTimeValue integer,
                     :pushdown boolean,
                     :mimeType string,
                     :zIndex integer,
                     :position OffsetPosition,
                     :hideSelectionBoxes boolean,
                     :politeLoad boolean,
                     :expandedDimension Size,
                     :companionCreativeIds [string],
                     :zipFilename string,
                     :assetIdentifier CreativeAssetId,
                     :mediaDuration number,
                     :audioBitRate integer,
                     :actionScript3 boolean,
                     :transparency boolean,
                     :backupImageExit CreativeCustomEvent}],
   :exitCustomEvents [{:advertiserCustomEventName string,
                       :popupWindowProperties PopupWindowProperties,
                       :artworkType string,
                       :artworkLabel string,
                       :videoReportingId string,
                       :advertiserCustomEventId string,
                       :id string,
                       :targetType string,
                       :exitClickThroughUrl CreativeClickThroughUrl,
                       :advertiserCustomEventType string}],
   :size {:height integer,
          :iab boolean,
          :id string,
          :kind string,
          :width integer},
   :studioAdvertiserId string,
   :creativeFieldAssignments [{:creativeFieldId string,
                               :creativeFieldValueId string}],
   :thirdPartyUrls [{:thirdPartyUrlType string, :url string}],
   :commercialId string,
   :backupImageFeatures [string],
   :authoringTool string,
   :advertiserId string,
   :htmlCode string,
   :active boolean,
   :id string,
   :requiredFlashPluginVersion string,
   :kind string,
   :progressOffset {:offsetPercentage integer, :offsetSeconds integer},
   :creativeAssetSelection {:defaultAssetId string, :rules [Rule]},
   :adTagKeys [string],
   :clickTags [{:clickThroughUrl CreativeClickThroughUrl,
                :eventName string,
                :name string}],
   :lastModifiedInfo {:time string},
   :latestTraffickedCreativeId string,
   :totalFileSize string,
   :redirectUrl string,
   :requiredFlashVersion integer,
   :backupImageTargetWindow {:customHtml string,
                             :targetWindowOption string},
   :subaccountId string,
   :version integer,
   :dynamicAssetSelection boolean,
   :renderingIdDimensionValue {:dimensionName string,
                               :etag string,
                               :id string,
                               :kind string,
                               :matchType string,
                               :value string},
   :mediaDuration number,
   :autoAdvanceImages boolean,
   :backgroundColor string,
   :companionCreatives [string],
   :accountId string,
   :backupImageReportingLabel string,
   :studioTraffickedCreativeId string,
   :mediaDescription string,
   :htmlCodeLocked boolean,
   :renderingId string}
  
  Inserts a new creative."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creatives"
     #{:profileId}
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creatives/list
  
  Required parameters: profileId
  
  Optional parameters: archived, studioCreativeId, campaignId, renderingIds, ids, searchString, types, pageToken, sortField, advertiserId, active, sortOrder, creativeFieldIds, companionCreativeIds, sizeIds, maxResults
  Retrieves a list of creatives, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creatives"
     #{:profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creatives/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :counterCustomEvents [{:advertiserCustomEventName string,
                          :popupWindowProperties PopupWindowProperties,
                          :artworkType string,
                          :artworkLabel string,
                          :videoReportingId string,
                          :advertiserCustomEventId string,
                          :id string,
                          :targetType string,
                          :exitClickThroughUrl CreativeClickThroughUrl,
                          :advertiserCustomEventType string}],
   :thirdPartyBackupImageImpressionsUrl string,
   :overrideCss string,
   :adParameters string,
   :skippable boolean,
   :allowScriptAccess boolean,
   :customKeyValues [string],
   :studioCreativeId string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :additionalSizes [{:height integer,
                      :iab boolean,
                      :id string,
                      :kind string,
                      :width integer}],
   :fsCommand {:left integer,
               :positionOption string,
               :top integer,
               :windowHeight integer,
               :windowWidth integer},
   :backupImageClickThroughUrl {:computedClickThroughUrl string,
                                :customClickThroughUrl string,
                                :landingPageId string},
   :timerCustomEvents [{:advertiserCustomEventName string,
                        :popupWindowProperties PopupWindowProperties,
                        :artworkType string,
                        :artworkLabel string,
                        :videoReportingId string,
                        :advertiserCustomEventId string,
                        :id string,
                        :targetType string,
                        :exitClickThroughUrl CreativeClickThroughUrl,
                        :advertiserCustomEventType string}],
   :sslOverride boolean,
   :compatibility [string],
   :sslCompliant boolean,
   :skipOffset {:offsetPercentage integer, :offsetSeconds integer},
   :thirdPartyRichMediaImpressionsUrl string,
   :name string,
   :convertFlashToHtml5 boolean,
   :universalAdId {:registry string, :value string},
   :artworkType string,
   :authoringSource string,
   :type string,
   :creativeAssets [{:role string,
                     :fileSize string,
                     :idDimensionValue DimensionValue,
                     :additionalSizes [Size],
                     :windowMode string,
                     :bitRate integer,
                     :verticallyLocked boolean,
                     :offset OffsetPosition,
                     :horizontallyLocked boolean,
                     :sslCompliant boolean,
                     :positionLeftUnit string,
                     :frameRate number,
                     :alignment string,
                     :pushdownDuration number,
                     :artworkType string,
                     :zipFilesize string,
                     :childAssetType string,
                     :startTimeType string,
                     :orientation string,
                     :flashVersion integer,
                     :duration integer,
                     :streamingServingUrl string,
                     :audioSampleRate integer,
                     :displayType string,
                     :detectedFeatures [string],
                     :size Size,
                     :progressiveServingUrl string,
                     :originalBackup boolean,
                     :collapsedSize Size,
                     :durationType string,
                     :hideFlashObjects boolean,
                     :positionTopUnit string,
                     :active boolean,
                     :id string,
                     :customStartTimeValue integer,
                     :pushdown boolean,
                     :mimeType string,
                     :zIndex integer,
                     :position OffsetPosition,
                     :hideSelectionBoxes boolean,
                     :politeLoad boolean,
                     :expandedDimension Size,
                     :companionCreativeIds [string],
                     :zipFilename string,
                     :assetIdentifier CreativeAssetId,
                     :mediaDuration number,
                     :audioBitRate integer,
                     :actionScript3 boolean,
                     :transparency boolean,
                     :backupImageExit CreativeCustomEvent}],
   :exitCustomEvents [{:advertiserCustomEventName string,
                       :popupWindowProperties PopupWindowProperties,
                       :artworkType string,
                       :artworkLabel string,
                       :videoReportingId string,
                       :advertiserCustomEventId string,
                       :id string,
                       :targetType string,
                       :exitClickThroughUrl CreativeClickThroughUrl,
                       :advertiserCustomEventType string}],
   :size {:height integer,
          :iab boolean,
          :id string,
          :kind string,
          :width integer},
   :studioAdvertiserId string,
   :creativeFieldAssignments [{:creativeFieldId string,
                               :creativeFieldValueId string}],
   :thirdPartyUrls [{:thirdPartyUrlType string, :url string}],
   :commercialId string,
   :backupImageFeatures [string],
   :authoringTool string,
   :advertiserId string,
   :htmlCode string,
   :active boolean,
   :id string,
   :requiredFlashPluginVersion string,
   :kind string,
   :progressOffset {:offsetPercentage integer, :offsetSeconds integer},
   :creativeAssetSelection {:defaultAssetId string, :rules [Rule]},
   :adTagKeys [string],
   :clickTags [{:clickThroughUrl CreativeClickThroughUrl,
                :eventName string,
                :name string}],
   :lastModifiedInfo {:time string},
   :latestTraffickedCreativeId string,
   :totalFileSize string,
   :redirectUrl string,
   :requiredFlashVersion integer,
   :backupImageTargetWindow {:customHtml string,
                             :targetWindowOption string},
   :subaccountId string,
   :version integer,
   :dynamicAssetSelection boolean,
   :renderingIdDimensionValue {:dimensionName string,
                               :etag string,
                               :id string,
                               :kind string,
                               :matchType string,
                               :value string},
   :mediaDuration number,
   :autoAdvanceImages boolean,
   :backgroundColor string,
   :companionCreatives [string],
   :accountId string,
   :backupImageReportingLabel string,
   :studioTraffickedCreativeId string,
   :mediaDescription string,
   :htmlCodeLocked boolean,
   :renderingId string}
  
  Updates an existing creative. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creatives"
     #{:id :profileId}
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

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creatives/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :counterCustomEvents [{:advertiserCustomEventName string,
                          :popupWindowProperties PopupWindowProperties,
                          :artworkType string,
                          :artworkLabel string,
                          :videoReportingId string,
                          :advertiserCustomEventId string,
                          :id string,
                          :targetType string,
                          :exitClickThroughUrl CreativeClickThroughUrl,
                          :advertiserCustomEventType string}],
   :thirdPartyBackupImageImpressionsUrl string,
   :overrideCss string,
   :adParameters string,
   :skippable boolean,
   :allowScriptAccess boolean,
   :customKeyValues [string],
   :studioCreativeId string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :additionalSizes [{:height integer,
                      :iab boolean,
                      :id string,
                      :kind string,
                      :width integer}],
   :fsCommand {:left integer,
               :positionOption string,
               :top integer,
               :windowHeight integer,
               :windowWidth integer},
   :backupImageClickThroughUrl {:computedClickThroughUrl string,
                                :customClickThroughUrl string,
                                :landingPageId string},
   :timerCustomEvents [{:advertiserCustomEventName string,
                        :popupWindowProperties PopupWindowProperties,
                        :artworkType string,
                        :artworkLabel string,
                        :videoReportingId string,
                        :advertiserCustomEventId string,
                        :id string,
                        :targetType string,
                        :exitClickThroughUrl CreativeClickThroughUrl,
                        :advertiserCustomEventType string}],
   :sslOverride boolean,
   :compatibility [string],
   :sslCompliant boolean,
   :skipOffset {:offsetPercentage integer, :offsetSeconds integer},
   :thirdPartyRichMediaImpressionsUrl string,
   :name string,
   :convertFlashToHtml5 boolean,
   :universalAdId {:registry string, :value string},
   :artworkType string,
   :authoringSource string,
   :type string,
   :creativeAssets [{:role string,
                     :fileSize string,
                     :idDimensionValue DimensionValue,
                     :additionalSizes [Size],
                     :windowMode string,
                     :bitRate integer,
                     :verticallyLocked boolean,
                     :offset OffsetPosition,
                     :horizontallyLocked boolean,
                     :sslCompliant boolean,
                     :positionLeftUnit string,
                     :frameRate number,
                     :alignment string,
                     :pushdownDuration number,
                     :artworkType string,
                     :zipFilesize string,
                     :childAssetType string,
                     :startTimeType string,
                     :orientation string,
                     :flashVersion integer,
                     :duration integer,
                     :streamingServingUrl string,
                     :audioSampleRate integer,
                     :displayType string,
                     :detectedFeatures [string],
                     :size Size,
                     :progressiveServingUrl string,
                     :originalBackup boolean,
                     :collapsedSize Size,
                     :durationType string,
                     :hideFlashObjects boolean,
                     :positionTopUnit string,
                     :active boolean,
                     :id string,
                     :customStartTimeValue integer,
                     :pushdown boolean,
                     :mimeType string,
                     :zIndex integer,
                     :position OffsetPosition,
                     :hideSelectionBoxes boolean,
                     :politeLoad boolean,
                     :expandedDimension Size,
                     :companionCreativeIds [string],
                     :zipFilename string,
                     :assetIdentifier CreativeAssetId,
                     :mediaDuration number,
                     :audioBitRate integer,
                     :actionScript3 boolean,
                     :transparency boolean,
                     :backupImageExit CreativeCustomEvent}],
   :exitCustomEvents [{:advertiserCustomEventName string,
                       :popupWindowProperties PopupWindowProperties,
                       :artworkType string,
                       :artworkLabel string,
                       :videoReportingId string,
                       :advertiserCustomEventId string,
                       :id string,
                       :targetType string,
                       :exitClickThroughUrl CreativeClickThroughUrl,
                       :advertiserCustomEventType string}],
   :size {:height integer,
          :iab boolean,
          :id string,
          :kind string,
          :width integer},
   :studioAdvertiserId string,
   :creativeFieldAssignments [{:creativeFieldId string,
                               :creativeFieldValueId string}],
   :thirdPartyUrls [{:thirdPartyUrlType string, :url string}],
   :commercialId string,
   :backupImageFeatures [string],
   :authoringTool string,
   :advertiserId string,
   :htmlCode string,
   :active boolean,
   :id string,
   :requiredFlashPluginVersion string,
   :kind string,
   :progressOffset {:offsetPercentage integer, :offsetSeconds integer},
   :creativeAssetSelection {:defaultAssetId string, :rules [Rule]},
   :adTagKeys [string],
   :clickTags [{:clickThroughUrl CreativeClickThroughUrl,
                :eventName string,
                :name string}],
   :lastModifiedInfo {:time string},
   :latestTraffickedCreativeId string,
   :totalFileSize string,
   :redirectUrl string,
   :requiredFlashVersion integer,
   :backupImageTargetWindow {:customHtml string,
                             :targetWindowOption string},
   :subaccountId string,
   :version integer,
   :dynamicAssetSelection boolean,
   :renderingIdDimensionValue {:dimensionName string,
                               :etag string,
                               :id string,
                               :kind string,
                               :matchType string,
                               :value string},
   :mediaDuration number,
   :autoAdvanceImages boolean,
   :backgroundColor string,
   :companionCreatives [string],
   :accountId string,
   :backupImageReportingLabel string,
   :studioTraffickedCreativeId string,
   :mediaDescription string,
   :htmlCodeLocked boolean,
   :renderingId string}
  
  Updates an existing creative."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creatives"
     #{:profileId}
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
