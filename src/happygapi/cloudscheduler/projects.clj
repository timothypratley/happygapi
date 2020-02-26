(ns happygapi.cloudscheduler.projects
  "Cloud Scheduler API
  Creates and manages jobs run on a regular recurring schedule.
  See: https://cloud.google.com/scheduler/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudscheduler_schema.edn"))))

(defn locations-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}/locations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-pause$
  "Required parameters: name
  
  Optional parameters: none
  
  Pauses a job.
  
  If a job is paused then the system will stop executing the job
  until it is re-enabled via ResumeJob. The
  state of the job is stored in state; if paused it
  will be set to Job.State.PAUSED. A job must be in Job.State.ENABLED
  to be paused."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}:pause"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-jobs-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+parent}/jobs"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+parent}/jobs"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-jobs-run$
  "Required parameters: name
  
  Optional parameters: none
  
  Forces a job to run now.
  
  When this method is called, Cloud Scheduler will dispatch the job, even
  if the job is already running."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}:run"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-jobs-resume$
  "Required parameters: name
  
  Optional parameters: none
  
  Resume a job.
  
  This method reenables a job after it has been Job.State.PAUSED. The
  state of a job is stored in Job.state; after calling this method it
  will be set to Job.State.ENABLED. A job must be in
  Job.State.PAUSED to be resumed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}:resume"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-jobs-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a job.
  
  If successful, the updated Job is returned. If the job does
  not exist, `NOT_FOUND` is returned.
  
  If UpdateJob does not successfully return, it is possible for the
  job to be in an Job.State.UPDATE_FAILED state. A job in this state may
  not be executed. If this happens, retry the UpdateJob request
  until a successful response is received."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
