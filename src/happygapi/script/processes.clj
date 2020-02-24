(ns happygapi.script.processes
  "Apps Script API
  Manages and executes Google Apps Script projects.
  
  See: https://developers.google.com/apps-script/api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn listScriptProcesses$
  "Required parameters: none
  
  List information about a script's executed processes, such as process type
  and current status."
  {:scopes ["https://www.googleapis.com/auth/script.processes"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
  
  List information about processes made by or on behalf of a user,
  such as process type and current status."
  {:scopes ["https://www.googleapis.com/auth/script.processes"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
