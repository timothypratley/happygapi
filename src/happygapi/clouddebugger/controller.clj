(ns happygapi.clouddebugger.controller
  "Cloud Debugger API: controller.
  Examines the call stack and variables of a running application without stopping or slowing it down. 
  See: https://cloud.google.com/debuggerapi/reference/rest/v2/controller"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn debuggees-register$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/controller/debuggees/register
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:debuggee {:description string,
              :labels {},
              :isDisabled boolean,
              :agentVersion string,
              :isInactive boolean,
              :canaryMode string,
              :sourceContexts [SourceContext],
              :uniquifier string,
              :project string,
              :status StatusMessage,
              :id string,
              :extSourceContexts [ExtendedSourceContext]}}
  
  Registers the debuggee with the controller service. All agents attached to the same application must call this method with exactly the same request content to get back the same stable `debuggee_id`. Agents should call this method again whenever `google.rpc.Code.NOT_FOUND` is returned from any controller method. This protocol allows the controller service to disable debuggees, recover from data loss, or change the `debuggee_id` format. Agents must handle `debuggee_id` value changing upon re-registration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/controller/debuggees/register"
     #{}
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

(defn debuggees-breakpoints-list$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/controller/debuggees/breakpoints/list
  
  Required parameters: debuggeeId
  
  Optional parameters: successOnTimeout, waitToken, agentId
  
  Returns the list of all active breakpoints for the debuggee. The breakpoint specification (`location`, `condition`, and `expressions` fields) is semantically immutable, although the field values may change. For example, an agent may update the location line number to reflect the actual line where the breakpoint was set, but this doesn't change the breakpoint semantics. This means that an agent does not need to check if a breakpoint has changed when it encounters the same breakpoint on a successive call. Moreover, an agent should remember the breakpoints that are completed until the controller removes them from the active list to avoid setting those breakpoints again."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:debuggeeId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/controller/debuggees/{debuggeeId}/breakpoints"
     #{:debuggeeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn debuggees-breakpoints-update$
  "https://cloud.google.com/debuggerapi/reference/rest/v2/controller/debuggees/breakpoints/update
  
  Required parameters: debuggeeId, id
  
  Optional parameters: none
  
  Body: 
  
  {:breakpoint {:finalTime string,
                :labels {},
                :isFinalState boolean,
                :canaryExpireTime string,
                :stackFrames [StackFrame],
                :createTime string,
                :state string,
                :evaluatedExpressions [Variable],
                :status StatusMessage,
                :id string,
                :condition string,
                :expressions [string],
                :logLevel string,
                :variableTable [Variable],
                :action string,
                :location SourceLocation,
                :logMessageFormat string,
                :userEmail string}}
  
  Updates the breakpoint state or mutable fields. The entire Breakpoint message must be sent back to the controller service. Updates to active breakpoint fields are only allowed if the new value does not change the breakpoint specification. Updates to the `location`, `condition` and `expressions` fields should not alter the breakpoint semantics. These may only make changes such as canonicalizing a value or snapping the location to the correct line of code."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud_debugger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:debuggeeId :id})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://clouddebugger.googleapis.com/"
     "v2/controller/debuggees/{debuggeeId}/breakpoints/{id}"
     #{:debuggeeId :id}
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
