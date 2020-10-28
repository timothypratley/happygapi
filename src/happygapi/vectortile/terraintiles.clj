(ns happygapi.vectortile.terraintiles
  "Semantic Tile API: terraintiles.
  Serves vector tiles containing geospatial data. 
  See: https://developers.google.com/maps/contact-sales/api/reference/rest/v1/terraintiles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/maps/contact-sales/api/reference/rest/v1/terraintiles/get
  
  Required parameters: name
  
  Optional parameters: clientInfo.platform, altitudePrecisionCentimeters, clientInfo.applicationId, clientInfo.operatingSystem, clientInfo.userId, clientInfo.deviceModel, terrainFormats, clientInfo.apiClient, minElevationResolutionCells, maxElevationResolutionCells, clientInfo.applicationVersion
  
  Gets a terrain tile by its tile resource name."
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
