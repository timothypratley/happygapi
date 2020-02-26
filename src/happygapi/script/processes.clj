(ns happygapi.script.processes
  "Apps Script API
  Manages and executes Google Apps Script projects.
  
  See: https://developers.google.com/apps-script/api/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "script_schema.edn"))))

(defn listScriptProcesses$
  "Required parameters: none
  
  Optional parameters: scriptProcessFilter.startTime, scriptProcessFilter.endTime, scriptProcessFilter.userAccessLevels, scriptId, scriptProcessFilter.deploymentId, pageToken, pageSize, scriptProcessFilter.functionName, scriptProcessFilter.statuses, scriptProcessFilter.types
  
  List information about a script's executed processes, such as process type
  and current status."
  {:scopes ["https://www.googleapis.com/auth/script.processes"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/processes:listScriptProcesses"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: userProcessFilter.deploymentId, userProcessFilter.functionName, userProcessFilter.userAccessLevels, userProcessFilter.scriptId, pageToken, userProcessFilter.statuses, pageSize, userProcessFilter.types, userProcessFilter.startTime, userProcessFilter.endTime, userProcessFilter.projectName
  
  List information about processes made by or on behalf of a user,
  such as process type and current status."
  {:scopes ["https://www.googleapis.com/auth/script.processes"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/processes"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
