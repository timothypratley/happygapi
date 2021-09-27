(ns happygapi.script.processes
  "Apps Script API: processes.
  Manages and executes Google Apps Script projects. 
  See: https://developers.google.com/apps-script/api/api/reference/rest/v1/processes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/processes/list
  
  Required parameters: none
  
  Optional parameters: userProcessFilter.deploymentId, userProcessFilter.functionName, userProcessFilter.userAccessLevels, userProcessFilter.scriptId, pageToken, userProcessFilter.statuses, pageSize, userProcessFilter.types, userProcessFilter.startTime, userProcessFilter.endTime, userProcessFilter.projectName
  
  List information about processes made by or on behalf of a user, such as process type and current status."
  {:scopes ["https://www.googleapis.com/auth/script.processes"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/processes"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listScriptProcesses$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/processes/listScriptProcesses
  
  Required parameters: none
  
  Optional parameters: scriptProcessFilter.startTime, scriptProcessFilter.endTime, scriptProcessFilter.userAccessLevels, scriptId, scriptProcessFilter.deploymentId, pageToken, pageSize, scriptProcessFilter.functionName, scriptProcessFilter.statuses, scriptProcessFilter.types
  
  List information about a script's executed processes, such as process type and current status."
  {:scopes ["https://www.googleapis.com/auth/script.processes"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/processes:listScriptProcesses"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
