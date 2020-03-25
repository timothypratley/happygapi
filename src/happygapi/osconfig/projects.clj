(ns happygapi.osconfig.projects
  "Cloud OS Config API: projects.
  OS management tools that can be used for patch management, patch compliance, and configuration management on VM instances.
  See: https://cloud.google.com/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patchJobs-get$
  "https://cloud.google.com/api/reference/rest/v1/projects/patchJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get the patch job. This can be used to track the progress of an
  ongoing patch job or review the details of completed jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn patchJobs-list$
  "https://cloud.google.com/api/reference/rest/v1/projects/patchJobs/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Get a list of patch jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/patchJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchJobs-execute$
  "https://cloud.google.com/api/reference/rest/v1/projects/patchJobs/execute
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:patchConfig {:rebootConfig string,
                 :preStep ExecStep,
                 :windowsUpdate WindowsUpdateSettings,
                 :zypper ZypperSettings,
                 :postStep ExecStep,
                 :yum YumSettings,
                 :apt AptSettings,
                 :goo GooSettings},
   :instanceFilter {:zones [string],
                    :groupLabels [PatchInstanceFilterGroupLabel],
                    :all boolean,
                    :instances [string],
                    :instanceNamePrefixes [string]},
   :duration string,
   :displayName string,
   :description string,
   :dryRun boolean}
  
  Patch VM instances by creating and running a patch job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/patchJobs:execute"
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

(defn patchJobs-cancel$
  "https://cloud.google.com/api/reference/rest/v1/projects/patchJobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancel a patch job. The patch job must be active. Canceled patch jobs
  cannot be restarted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
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

(defn patchJobs-instanceDetails-list$
  "https://cloud.google.com/api/reference/rest/v1/projects/patchJobs/instanceDetails/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Get a list of instance details for a given patch job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/instanceDetails"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchDeployments-create$
  "https://cloud.google.com/api/reference/rest/v1/projects/patchDeployments/create
  
  Required parameters: parent
  
  Optional parameters: patchDeploymentId
  
  Body: 
  
  {:description string,
   :lastExecuteTime string,
   :name string,
   :patchConfig {:rebootConfig string,
                 :preStep ExecStep,
                 :windowsUpdate WindowsUpdateSettings,
                 :zypper ZypperSettings,
                 :postStep ExecStep,
                 :yum YumSettings,
                 :apt AptSettings,
                 :goo GooSettings},
   :createTime string,
   :duration string,
   :updateTime string,
   :recurringSchedule {:timeZone TimeZone,
                       :lastExecuteTime string,
                       :nextExecuteTime string,
                       :startTime string,
                       :endTime string,
                       :frequency string,
                       :monthly MonthlySchedule,
                       :weekly WeeklySchedule,
                       :timeOfDay TimeOfDay},
   :oneTimeSchedule {:executeTime string},
   :instanceFilter {:zones [string],
                    :groupLabels [PatchInstanceFilterGroupLabel],
                    :all boolean,
                    :instances [string],
                    :instanceNamePrefixes [string]}}
  
  Create an OS Config patch deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/patchDeployments"
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

(defn patchDeployments-delete$
  "https://cloud.google.com/api/reference/rest/v1/projects/patchDeployments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete an OS Config patch deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn patchDeployments-get$
  "https://cloud.google.com/api/reference/rest/v1/projects/patchDeployments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get an OS Config patch deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn patchDeployments-list$
  "https://cloud.google.com/api/reference/rest/v1/projects/patchDeployments/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Get a page of OS Config patch deployments."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/patchDeployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
