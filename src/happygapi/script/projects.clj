(ns happygapi.script.projects
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

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates a new, empty script project with no script files and a base
  manifest file."
  {:scopes ["https://www.googleapis.com/auth/script.projects"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects"
     #{}
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

(defn getContent$
  "Required parameters: scriptId
  
  Optional parameters: versionNumber
  
  Gets the content of the script project, including the code source and
  metadata for each script file."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/content"
     #{"scriptId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getMetrics$
  "Required parameters: scriptId
  
  Optional parameters: metricsFilter.deploymentId, metricsGranularity
  
  Get metrics data for scripts, such as number of executions and
  active users."
  {:scopes ["https://www.googleapis.com/auth/script.metrics"]}
  [auth args]
  {:pre [(util/has-keys? args #{"scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/metrics"
     #{"scriptId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: scriptId
  
  Optional parameters: none
  
  Gets a script project's metadata."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}"
     #{"scriptId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateContent$
  "Required parameters: scriptId
  
  Optional parameters: none
  
  Updates the content of the specified script project.
  This content is stored as the HEAD version, and is used when the script is
  executed as a trigger, in the script editor, in add-on preview mode, or as
  a web app or Apps Script API in development mode. This clears all the
  existing files in the project."
  {:scopes ["https://www.googleapis.com/auth/script.projects"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/content"
     #{"scriptId"}
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

(defn deployments-create$
  "Required parameters: scriptId
  
  Optional parameters: none
  
  Creates a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments"
     #{"scriptId"}
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

(defn deployments-delete$
  "Required parameters: scriptId, deploymentId
  
  Optional parameters: none
  
  Deletes a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"]}
  [auth args]
  {:pre [(util/has-keys? args #{"deploymentId" "scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments/{deploymentId}"
     #{"deploymentId" "scriptId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-get$
  "Required parameters: scriptId, deploymentId
  
  Optional parameters: none
  
  Gets a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"
            "https://www.googleapis.com/auth/script.deployments.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"deploymentId" "scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments/{deploymentId}"
     #{"deploymentId" "scriptId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-list$
  "Required parameters: scriptId
  
  Optional parameters: pageToken, pageSize
  
  Lists the deployments of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"
            "https://www.googleapis.com/auth/script.deployments.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments"
     #{"scriptId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-update$
  "Required parameters: scriptId, deploymentId
  
  Optional parameters: none
  
  Updates a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"deploymentId" "scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments/{deploymentId}"
     #{"deploymentId" "scriptId"}
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

(defn versions-create$
  "Required parameters: scriptId
  
  Optional parameters: none
  
  Creates a new immutable version using the current code, with a unique
  version number."
  {:scopes ["https://www.googleapis.com/auth/script.projects"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/versions"
     #{"scriptId"}
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

(defn versions-get$
  "Required parameters: versionNumber, scriptId
  
  Optional parameters: none
  
  Gets a version of a script project."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"scriptId" "versionNumber"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/versions/{versionNumber}"
     #{"scriptId" "versionNumber"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn versions-list$
  "Required parameters: scriptId
  
  Optional parameters: pageToken, pageSize
  
  List the versions of a script project."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"scriptId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/versions"
     #{"scriptId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
