(ns happygapi.script.projects
  "Apps Script API: projects.
  Manages and executes Google Apps Script projects.
  
  See: https://developers.google.com/apps-script/api/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/get
  
  Required parameters: scriptId
  
  Optional parameters: none
  Gets a script project's metadata."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}"
     #{:scriptId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateContent$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/updateContent
  
  Required parameters: scriptId
  
  Optional parameters: none
  
  Body: 
  
  {:scriptId string,
   :files [{:source string,
            :lastModifyUser GoogleAppsScriptTypeUser,
            :createTime string,
            :functionSet GoogleAppsScriptTypeFunctionSet,
            :updateTime string,
            :name string,
            :type string}]}
  
  Updates the content of the specified script project.
  This content is stored as the HEAD version, and is used when the script is
  executed as a trigger, in the script editor, in add-on preview mode, or as
  a web app or Apps Script API in development mode. This clears all the
  existing files in the project."
  {:scopes ["https://www.googleapis.com/auth/script.projects"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:scriptId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/content"
     #{:scriptId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:parentId string, :title string}
  
  Creates a new, empty script project with no script files and a base
  manifest file."
  {:scopes ["https://www.googleapis.com/auth/script.projects"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getContent$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/getContent
  
  Required parameters: scriptId
  
  Optional parameters: versionNumber
  Gets the content of the script project, including the code source and
  metadata for each script file."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/content"
     #{:scriptId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getMetrics$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/getMetrics
  
  Required parameters: scriptId
  
  Optional parameters: metricsFilter.deploymentId, metricsGranularity
  Get metrics data for scripts, such as number of executions and
  active users."
  {:scopes ["https://www.googleapis.com/auth/script.metrics"]}
  [auth args]
  {:pre [(util/has-keys? args #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/metrics"
     #{:scriptId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-create$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/create
  
  Required parameters: scriptId
  
  Optional parameters: none
  
  Body: 
  
  {:manifestFileName string,
   :description string,
   :versionNumber integer,
   :scriptId string}
  
  Creates a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:scriptId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments"
     #{:scriptId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-delete$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/delete
  
  Required parameters: scriptId, deploymentId
  
  Optional parameters: none
  Deletes a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"]}
  [auth args]
  {:pre [(util/has-keys? args #{:deploymentId :scriptId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments/{deploymentId}"
     #{:deploymentId :scriptId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-get$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/get
  
  Required parameters: deploymentId, scriptId
  
  Optional parameters: none
  Gets a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"
            "https://www.googleapis.com/auth/script.deployments.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:deploymentId :scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments/{deploymentId}"
     #{:deploymentId :scriptId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-list$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/list
  
  Required parameters: scriptId
  
  Optional parameters: pageToken, pageSize
  Lists the deployments of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"
            "https://www.googleapis.com/auth/script.deployments.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments"
     #{:scriptId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-update$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/update
  
  Required parameters: deploymentId, scriptId
  
  Optional parameters: none
  
  Body: 
  
  {:deploymentConfig {:manifestFileName string,
                      :description string,
                      :versionNumber integer,
                      :scriptId string}}
  
  Updates a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:deploymentId :scriptId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments/{deploymentId}"
     #{:deploymentId :scriptId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn versions-get$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/versions/get
  
  Required parameters: versionNumber, scriptId
  
  Optional parameters: none
  Gets a version of a script project."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:scriptId :versionNumber})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/versions/{versionNumber}"
     #{:scriptId :versionNumber}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn versions-list$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/versions/list
  
  Required parameters: scriptId
  
  Optional parameters: pageToken, pageSize
  List the versions of a script project."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/versions"
     #{:scriptId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn versions-create$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/versions/create
  
  Required parameters: scriptId
  
  Optional parameters: none
  
  Body: 
  
  {:versionNumber integer,
   :scriptId string,
   :createTime string,
   :description string}
  
  Creates a new immutable version using the current code, with a unique
  version number."
  {:scopes ["https://www.googleapis.com/auth/script.projects"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:scriptId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/versions"
     #{:scriptId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
