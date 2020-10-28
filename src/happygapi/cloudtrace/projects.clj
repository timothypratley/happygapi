(ns happygapi.cloudtrace.projects
  "Cloud Trace API: projects.
  Sends application trace data to Cloud Trace for viewing. Trace data is collected for all App Engine applications by default. Trace data from other applications can be provided using this API. This library is used to interact with the Cloud Trace API directly. If you are looking to instrument your application for Cloud Trace, we recommend using OpenCensus. 
  See: https://cloud.google.com/traceapi/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn traces-batchWrite$
  "https://cloud.google.com/traceapi/reference/rest/v2/projects/traces/batchWrite
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:spans [{:spanId string,
            :startTime string,
            :displayName TruncatableString,
            :name string,
            :endTime string,
            :timeEvents TimeEvents,
            :childSpanCount integer,
            :status Status,
            :sameProcessAsParentSpan boolean,
            :parentSpanId string,
            :spanKind string,
            :attributes Attributes,
            :stackTrace StackTrace,
            :links Links}]}
  
  Sends new spans to new or existing traces. You cannot update existing spans."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/trace.append"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtrace.googleapis.com/"
     "v2/{+name}/traces:batchWrite"
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

(defn traces-spans-createSpan$
  "https://cloud.google.com/traceapi/reference/rest/v2/projects/traces/spans/createSpan
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:spanId string,
   :startTime string,
   :displayName {:truncatedByteCount integer, :value string},
   :name string,
   :endTime string,
   :timeEvents {:droppedMessageEventsCount integer,
                :droppedAnnotationsCount integer,
                :timeEvent [TimeEvent]},
   :childSpanCount integer,
   :status {:details [{}], :code integer, :message string},
   :sameProcessAsParentSpan boolean,
   :parentSpanId string,
   :spanKind string,
   :attributes {:attributeMap {}, :droppedAttributesCount integer},
   :stackTrace {:stackFrames StackFrames, :stackTraceHashId string},
   :links {:link [Link], :droppedLinksCount integer}}
  
  Creates a new span."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/trace.append"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtrace.googleapis.com/"
     "v2/{+name}"
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
