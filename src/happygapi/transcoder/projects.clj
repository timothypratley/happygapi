(ns happygapi.transcoder.projects
  "Transcoder API: projects.
  This API converts video files into formats suitable for consumer distribution. For more information, see the Transcoder API overview. 
  See: https://cloud.google.com/transcoder/docs/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-jobs-create$
  "https://cloud.google.com/transcoder/docs/api/reference/rest/v1/projects/locations/jobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :outputUri string,
   :ttlAfterCompletionDays integer,
   :startTime string,
   :config {:overlays [Overlay],
            :manifests [Manifest],
            :adBreaks [AdBreak],
            :output Output,
            :inputs [Input],
            :spriteSheets [SpriteSheet],
            :elementaryStreams [ElementaryStream],
            :muxStreams [MuxStream],
            :pubsubDestination PubsubDestination,
            :encryptions [Encryption],
            :editList [EditAtom]},
   :name string,
   :endTime string,
   :batchModePriority integer,
   :mode string,
   :createTime string,
   :state string,
   :optimization string,
   :error {:code integer, :message string, :details [{}]},
   :templateId string,
   :inputUri string}
  
  Creates a job in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://transcoder.googleapis.com/"
     "v1/{+parent}/jobs"
     #{:parent}
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

(defn locations-jobs-list$
  "https://cloud.google.com/transcoder/docs/api/reference/rest/v1/projects/locations/jobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists jobs in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://transcoder.googleapis.com/"
     "v1/{+parent}/jobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-get$
  "https://cloud.google.com/transcoder/docs/api/reference/rest/v1/projects/locations/jobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the job data."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://transcoder.googleapis.com/"
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

(defn locations-jobs-delete$
  "https://cloud.google.com/transcoder/docs/api/reference/rest/v1/projects/locations/jobs/delete
  
  Required parameters: name
  
  Optional parameters: allowMissing
  
  Deletes a job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://transcoder.googleapis.com/"
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

(defn locations-jobTemplates-create$
  "https://cloud.google.com/transcoder/docs/api/reference/rest/v1/projects/locations/jobTemplates/create
  
  Required parameters: parent
  
  Optional parameters: jobTemplateId
  
  Body: 
  
  {:name string,
   :config {:overlays [Overlay],
            :manifests [Manifest],
            :adBreaks [AdBreak],
            :output Output,
            :inputs [Input],
            :spriteSheets [SpriteSheet],
            :elementaryStreams [ElementaryStream],
            :muxStreams [MuxStream],
            :pubsubDestination PubsubDestination,
            :encryptions [Encryption],
            :editList [EditAtom]},
   :labels {}}
  
  Creates a job template in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://transcoder.googleapis.com/"
     "v1/{+parent}/jobTemplates"
     #{:parent}
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

(defn locations-jobTemplates-list$
  "https://cloud.google.com/transcoder/docs/api/reference/rest/v1/projects/locations/jobTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists job templates in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://transcoder.googleapis.com/"
     "v1/{+parent}/jobTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobTemplates-get$
  "https://cloud.google.com/transcoder/docs/api/reference/rest/v1/projects/locations/jobTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the job template data."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://transcoder.googleapis.com/"
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

(defn locations-jobTemplates-delete$
  "https://cloud.google.com/transcoder/docs/api/reference/rest/v1/projects/locations/jobTemplates/delete
  
  Required parameters: name
  
  Optional parameters: allowMissing
  
  Deletes a job template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://transcoder.googleapis.com/"
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
