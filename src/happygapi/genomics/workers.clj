(ns happygapi.genomics.workers
  "Genomics API: workers.
  Uploads, processes, queries, and searches Genomics data in the cloud.
  See: https://cloud.google.com/genomicsapi/reference/rest/v2alpha1/workers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn checkIn$
  "https://cloud.google.com/genomicsapi/reference/rest/v2alpha1/workers/checkIn
  
  Required parameters: id
  
  Optional parameters: none
  
  Body: 
  
  {:event {},
   :workerStatus {:attachedDisks {},
                  :uptimeSeconds string,
                  :freeRamBytes string,
                  :totalRamBytes string,
                  :bootDisk DiskStatus},
   :result {:code integer, :message string, :details [{}]},
   :deadlineExpired {},
   :events [{:timestamp string, :data {}}],
   :sosReport string}
  
  The worker uses this method to retrieve the assigned operation and provide periodic status updates."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/genomics"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://genomics.googleapis.com/"
     "v2alpha1/workers/{id}:checkIn"
     #{:id}
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
