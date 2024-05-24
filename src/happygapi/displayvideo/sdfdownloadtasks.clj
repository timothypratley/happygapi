(ns happygapi.displayvideo.sdfdownloadtasks
  "Display & Video 360 API: sdfdownloadtasks.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/sdfdownloadtasks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/display-video/api/reference/rest/v3/sdfdownloadtasks/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:partnerId string,
   :advertiserId string,
   :parentEntityFilter {:fileType [string],
                        :filterType string,
                        :filterIds [string]},
   :idFilter {:campaignIds [string],
              :mediaProductIds [string],
              :insertionOrderIds [string],
              :lineItemIds [string],
              :adGroupIds [string],
              :adGroupAdIds [string]},
   :inventorySourceFilter {:inventorySourceIds [string]},
   :version string}
  
  Creates an SDF Download Task. Returns an Operation. An SDF Download Task is a long-running, asynchronous operation. The metadata type of this operation is SdfDownloadTaskMetadata. If the request is successful, the response type of the operation is SdfDownloadTask. The response will not include the download files, which must be retrieved with media.download. The state of operation can be retrieved with sdfdownloadtask.operations.get. Any errors can be found in the error.message. Note that error.details is expected to be empty."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/sdfdownloadtasks"
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

(defn operations-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/sdfdownloadtasks/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of an asynchronous SDF download task operation. Clients should poll this method at intervals of 30 seconds."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
