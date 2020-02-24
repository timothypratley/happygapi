(ns happygapi.clouddebugger.debugger
  "Stackdriver Debugger API
  Examines the call stack and variables of a running application without stopping or slowing it down.
  
  See: https://cloud.google.com/debugger"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn debuggees-list$
  "Required parameters: none
  
  Lists all the debuggees that the user has access to."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn debuggees-breakpoints-set$
  "Required parameters: debuggeeId
  
  Sets the breakpoint to the debuggee."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"debuggeeId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees/{debuggeeId}/breakpoints/set"
     #{"debuggeeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn debuggees-breakpoints-delete$
  "Required parameters: breakpointId,debuggeeId
  
  Deletes the breakpoint from the debuggee."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"breakpointId" "debuggeeId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees/{debuggeeId}/breakpoints/{breakpointId}"
     #{"breakpointId" "debuggeeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn debuggees-breakpoints-get$
  "Required parameters: breakpointId,debuggeeId
  
  Gets breakpoint information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"breakpointId" "debuggeeId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees/{debuggeeId}/breakpoints/{breakpointId}"
     #{"breakpointId" "debuggeeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn debuggees-breakpoints-list$
  "Required parameters: debuggeeId
  
  Lists all breakpoints for the debuggee."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"debuggeeId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees/{debuggeeId}/breakpoints"
     #{"debuggeeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
