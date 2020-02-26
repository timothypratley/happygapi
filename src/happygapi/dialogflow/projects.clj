(ns happygapi.dialogflow.projects
  "Dialogflow API
  Builds conversational interfaces (for example, chatbots, and voice-powered apps and devices).
  See: https://cloud.google.com/dialogflow/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "dialogflow_schema.edn"))))

(defn agent$
  "Required parameters: parent
  
  Optional parameters: updateMask
  
  Creates/updates the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent"
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

(defn getAgent$
  "Required parameters: parent
  
  Optional parameters: none
  
  Retrieves the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deleteAgent$
  "Required parameters: parent
  
  Optional parameters: none
  
  Deletes the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-train$
  "Required parameters: parent
  
  Optional parameters: none
  
  Trains the specified agent.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:train"
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

(defn agent-getValidationResult$
  "Required parameters: parent
  
  Optional parameters: languageCode
  
  Gets agent validation result. Agent validation is performed during
  training time and is updated automatically when training is completed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent/validationResult"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-import$
  "Required parameters: parent
  
  Optional parameters: none
  
  Imports the specified agent from a ZIP file.
  
  Uploads new intents and entity types without deleting the existing ones.
  Intents and entity types with the same name are replaced with the new
  versions from ImportAgentRequest.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:import"
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

(defn agent-getFulfillment$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves the fulfillment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-export$
  "Required parameters: parent
  
  Optional parameters: none
  
  Exports the specified agent to a ZIP file.
  
  Operation <response: ExportAgentResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:export"
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

(defn agent-restore$
  "Required parameters: parent
  
  Optional parameters: none
  
  Restores the specified agent from a ZIP file.
  
  Replaces the current agent version with a new one. All the intents and
  entity types in the older version are deleted.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:restore"
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

(defn agent-updateFulfillment$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the fulfillment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-search$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of agents.
  
  Since there is at most one conversational agent per project, this method is
  useful primarily for listing all agents across projects the caller has
  access to. One can achieve that with a wildcard project collection id \"-\".
  Refer to [List
  Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:search"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-intents-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize, intentView, languageCode
  
  Returns the list of all intents in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/intents"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-intents-create$
  "Required parameters: parent
  
  Optional parameters: languageCode, intentView
  
  Creates an intent in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/intents"
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

(defn agent-intents-batchDelete$
  "Required parameters: parent
  
  Optional parameters: none
  
  Deletes intents in the specified agent.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/intents:batchDelete"
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

(defn agent-intents-get$
  "Required parameters: name
  
  Optional parameters: intentView, languageCode
  
  Retrieves the specified intent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-intents-patch$
  "Required parameters: name
  
  Optional parameters: intentView, languageCode, updateMask
  
  Updates the specified intent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-intents-batchUpdate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Updates/Creates multiple intents in the specified agent.
  
  Operation <response: BatchUpdateIntentsResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/intents:batchUpdate"
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

(defn agent-intents-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified intent and its direct or indirect followup intents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-entityTypes-batchUpdate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Updates/Creates multiple entity types in the specified agent.
  
  Operation <response: BatchUpdateEntityTypesResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes:batchUpdate"
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

(defn agent-entityTypes-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-entityTypes-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize, languageCode
  
  Returns the list of all entity types in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-entityTypes-create$
  "Required parameters: parent
  
  Optional parameters: languageCode
  
  Creates an entity type in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
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

(defn agent-entityTypes-batchDelete$
  "Required parameters: parent
  
  Optional parameters: none
  
  Deletes entity types in the specified agent.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes:batchDelete"
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

(defn agent-entityTypes-get$
  "Required parameters: name
  
  Optional parameters: languageCode
  
  Retrieves the specified entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-entityTypes-patch$
  "Required parameters: name
  
  Optional parameters: languageCode, updateMask
  
  Updates the specified entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-entityTypes-entities-batchUpdate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Updates or creates multiple entities in the specified entity type. This
  method does not affect entities in the entity type that aren't explicitly
  specified in the request.
  
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entities:batchUpdate"
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

(defn agent-entityTypes-entities-batchDelete$
  "Required parameters: parent
  
  Optional parameters: none
  
  Deletes entities in the specified entity type.
  
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entities:batchDelete"
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

(defn agent-entityTypes-entities-batchCreate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates multiple new entities in the specified entity type.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entities:batchCreate"
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

(defn agent-environments-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified agent environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all environments of the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/environments"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-getHistory$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Gets the history of the specified environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/history"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-create$
  "Required parameters: parent
  
  Optional parameters: environmentId
  
  Creates an agent environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/environments"
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

(defn agent-environments-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified agent environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the specified agent environment.
  
  This method allows you to deploy new agent versions into the environment.
  When a environment is pointed to a new agent version by setting
  `environment.agent_version`, the environment is temporarily set to the
  `LOADING` state. During that time, the environment keeps on serving the
  previous version of the agent. After the new agent version is done loading,
  the environment is set back to the `RUNNING` state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-deleteContexts$
  "Required parameters: parent
  
  Optional parameters: none
  
  Deletes all active contexts in the specified session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/contexts"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-detectIntent$
  "Required parameters: session
  
  Optional parameters: none
  
  Processes a natural language query and returns structured, actionable data
  as a result. This method is not idempotent, because it may cause contexts
  and session entity types to be updated, which in turn might affect
  results of future queries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+session}:detectIntent"
     #{"session"}
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

(defn agent-sessions-contexts-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-contexts-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all contexts in the specified session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/contexts"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-contexts-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-contexts-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the specified context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-contexts-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a context.
  
  If the specified context already exists, overrides the context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/contexts"
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

(defn agent-sessions-entityTypes-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified session entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-entityTypes-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all session entity types in the specified session.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-entityTypes-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified session entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-entityTypes-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the specified session entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-entityTypes-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a session entity type.
  
  If the specified session entity type already exists, overrides the session
  entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
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

(defn agent-versions-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all versions of the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/versions"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-versions-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified agent version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-versions-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the specified agent version.
  
  Note that this method does not allow you to update the state of the agent
  the given version points to. It allows you to update only mutable
  properties of the version resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn agent-versions-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates an agent version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/versions"
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

(defn operations-list$
  "Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}/operations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn operations-cancel$
  "Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn locations-operations-cancel$
  "Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn locations-operations-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}/operations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
