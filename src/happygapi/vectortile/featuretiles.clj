(ns happygapi.vectortile.featuretiles
  "Semantic Tile API: featuretiles.
  Serves vector tiles containing geospatial data. 
  See: https://developers.google.com/maps/contact-sales/api/reference/rest/v1/featuretiles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/maps/contact-sales/api/reference/rest/v1/featuretiles/get
  
  Required parameters: name
  
  Optional parameters: clientInfo.platform, clientInfo.applicationId, clientInfo.operatingSystem, enablePoliticalFeatures, enableDetailedHighwayTypes, clientInfo.userId, enableFeatureNames, enablePrivateRoads, clientInfo.deviceModel, enableModeledVolumes, clientInfo.apiClient, languageCode, clientTileVersionId, regionCode, enableUnclippedBuildings, clientInfo.applicationVersion, alwaysIncludeBuildingFootprints
  
  Gets a feature tile by its tile resource name."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vectortile.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
