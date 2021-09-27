(ns happygapi.clouddebugger.debugger
  "Cloud Debugger API: debugger.
  Examines the call stack and variables of a running application without stopping or slowing it down. 
  See: https://cloud.google.com/debuggerapi/reference/rest/v2/debugger"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn debuggees-list$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/debugger/debuggees/list
  
  Required parameters: none
  
  Optional parameters: project, includeInactive, clientVersion
  
  Lists all the debuggees that the user has access to."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn debuggees-breakpoints-list$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/debugger/debuggees/breakpoints/list
  
  Required parameters: debuggeeId
  
  Optional parameters: action.value, includeInactive, clientVersion, includeAllUsers, stripResults, waitToken
  
  Lists all breakpoints for the debuggee."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:debuggeeId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees/{debuggeeId}/breakpoints"
     #{:debuggeeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn debuggees-breakpoints-get$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/debugger/debuggees/breakpoints/get
  
  Required parameters: breakpointId, debuggeeId
  
  Optional parameters: clientVersion
  
  Gets breakpoint information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:debuggeeId :breakpointId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees/{debuggeeId}/breakpoints/{breakpointId}"
     #{:debuggeeId :breakpointId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn debuggees-breakpoints-delete$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/debugger/debuggees/breakpoints/delete
  
  Required parameters: breakpointId, debuggeeId
  
  Optional parameters: clientVersion
  
  Deletes the breakpoint from the debuggee."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:debuggeeId :breakpointId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees/{debuggeeId}/breakpoints/{breakpointId}"
     #{:debuggeeId :breakpointId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn debuggees-breakpoints-set$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/debugger/debuggees/breakpoints/set
  
  Required parameters: debuggeeId
  
  Optional parameters: clientVersion, canaryOption
  
  Body: 
  
  {:finalTime string,
   :labels {},
   :isFinalState boolean,
   :canaryExpireTime string,
   :stackFrames [{:arguments [Variable],
                  :location SourceLocation,
                  :function string,
                  :locals [Variable]}],
   :createTime string,
   :state string,
   :evaluatedExpressions [{:name string,
                           :type string,
                           :value string,
                           :members [Variable],
                           :varTableIndex integer,
                           :status StatusMessage}],
   :status {:refersTo string,
            :description FormatMessage,
            :isError boolean},
   :id string,
   :condition string,
   :expressions [string],
   :logLevel string,
   :variableTable [{:name string,
                    :type string,
                    :value string,
                    :members [Variable],
                    :varTableIndex integer,
                    :status StatusMessage}],
   :action string,
   :location {:path string, :line integer, :column integer},
   :logMessageFormat string,
   :userEmail string}
  
  Sets the breakpoint to the debuggee."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:debuggeeId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/debugger/debuggees/{debuggeeId}/breakpoints/set"
     #{:debuggeeId}
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
