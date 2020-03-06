(ns happygapi.displayvideo.sdfdownloadtasks
  "Display & Video 360 API: sdfdownloadtasks.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/sdfdownloadtasks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/display-video/api/reference/rest/v1/sdfdownloadtasks/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :parentEntityFilter {:fileType [string],
                        :filterType string,
                        :filterIds [string]},
   :idFilter {:adGroupIds [string],
              :campaignIds [string],
              :insertionOrderIds [string],
              :mediaProductIds [string],
              :lineItemIds [string],
              :adGroupAdIds [string]},
   :partnerId string,
   :version string,
   :inventorySourceFilter {:inventorySourceIds [string]}}
  
  Creates an SDF Download Task. Returns an
  Operation.
  
  An SDF Download Task is a long-running, asynchronous operation. The
  metadata type of this operation is
  SdfDownloadTaskMetadata. If the request is successful, the
  response type of the operation is
  SdfDownloadTask. The response will not include the download files,
  which must be retrieved with
  media.download. The state of
  operation can be retrieved with
  sdfdownloadtask.operations.get.
  
  Any errors can be found in the
  error.message. Note
  that error.details is expected to be
  empty."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/sdfdownloadtasks"
     #{}
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

(defn operations-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/sdfdownloadtasks/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the latest state of an asynchronous SDF download task operation. Clients should poll this method at intervals of 30 seconds."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
