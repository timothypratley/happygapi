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

(defn debuggees-breakpoints-get$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/debugger/debuggees/breakpoints/get
  
  Required parameters: debuggeeId, breakpointId
  
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

(defn debuggees-breakpoints-list$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/debugger/debuggees/breakpoints/list
  
  Required parameters: debuggeeId
  
  Optional parameters: clientVersion, waitToken, includeInactive, action.value, includeAllUsers, stripResults
  
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

(defn debuggees-breakpoints-set$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/debugger/debuggees/breakpoints/set
  
  Required parameters: debuggeeId
  
  Optional parameters: canaryOption, clientVersion
  
  Body: 
  
  {:finalTime string,
   :labels {},
   :isFinalState boolean,
   :canaryExpireTime string,
   :stackFrames [{:arguments [Variable],
                  :locals [Variable],
                  :function string,
                  :location SourceLocation}],
   :createTime string,
   :state string,
   :evaluatedExpressions [{:type string,
                           :members [Variable],
                           :value string,
                           :name string,
                           :status StatusMessage,
                           :varTableIndex integer}],
   :status {:description FormatMessage,
            :isError boolean,
            :refersTo string},
   :id string,
   :condition string,
   :expressions [string],
   :logLevel string,
   :variableTable [{:type string,
                    :members [Variable],
                    :value string,
                    :name string,
                    :status StatusMessage,
                    :varTableIndex integer}],
   :action string,
   :location {:column integer, :path string, :line integer},
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

(defn debuggees-breakpoints-delete$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/debugger/debuggees/breakpoints/delete
  
  Required parameters: debuggeeId, breakpointId
  
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
