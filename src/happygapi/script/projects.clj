(ns happygapi.script.projects
  "Apps Script API: projects.
  Manages and executes Google Apps Script projects. 
  See: https://developers.google.com/apps-script/api/docs/reference/rest/v1/projects"
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
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}"
     #{:scriptId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:parentId string, :title string}
  
  Creates a new, empty script project with no script files and a base manifest file."
  {:scopes ["https://www.googleapis.com/auth/script.projects"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects"
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

(defn getContent$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/getContent
  
  Required parameters: scriptId
  
  Optional parameters: versionNumber
  
  Gets the content of the script project, including the code source and metadata for each script file."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/content"
     #{:scriptId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateContent$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/updateContent
  
  Required parameters: scriptId
  
  Optional parameters: none
  
  Body: 
  
  {:files [{:type string,
            :name string,
            :source string,
            :lastModifyUser GoogleAppsScriptTypeUser,
            :createTime string,
            :functionSet GoogleAppsScriptTypeFunctionSet,
            :updateTime string}],
   :scriptId string}
  
  Updates the content of the specified script project. This content is stored as the HEAD version, and is used when the script is executed as a trigger, in the script editor, in add-on preview mode, or as a web app or Apps Script API in development mode. This clears all the existing files in the project."
  {:scopes ["https://www.googleapis.com/auth/script.projects"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:scriptId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/content"
     #{:scriptId}
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

(defn getMetrics$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/getMetrics
  
  Required parameters: scriptId
  
  Optional parameters: metricsGranularity, metricsFilter.deploymentId
  
  Get metrics data for scripts, such as number of executions and active users."
  {:scopes ["https://www.googleapis.com/auth/script.metrics"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/metrics"
     #{:scriptId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-create$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/create
  
  Required parameters: scriptId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :scriptId string,
   :versionNumber integer,
   :manifestFileName string}
  
  Creates a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:scriptId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments"
     #{:scriptId}
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

(defn deployments-delete$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/delete
  
  Required parameters: deploymentId, scriptId
  
  Optional parameters: none
  
  Deletes a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:deploymentId :scriptId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments/{deploymentId}"
     #{:deploymentId :scriptId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-list$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/list
  
  Required parameters: scriptId
  
  Optional parameters: pageSize, pageToken
  
  Lists the deployments of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"
            "https://www.googleapis.com/auth/script.deployments.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments"
     #{:scriptId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-get$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/get
  
  Required parameters: scriptId, deploymentId
  
  Optional parameters: none
  
  Gets a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"
            "https://www.googleapis.com/auth/script.deployments.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:deploymentId :scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments/{deploymentId}"
     #{:deploymentId :scriptId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-update$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/deployments/update
  
  Required parameters: scriptId, deploymentId
  
  Optional parameters: none
  
  Body: 
  
  {:deploymentConfig {:description string,
                      :scriptId string,
                      :versionNumber integer,
                      :manifestFileName string}}
  
  Updates a deployment of an Apps Script project."
  {:scopes ["https://www.googleapis.com/auth/script.deployments"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:deploymentId :scriptId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/deployments/{deploymentId}"
     #{:deploymentId :scriptId}
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

(defn versions-create$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/versions/create
  
  Required parameters: scriptId
  
  Optional parameters: none
  
  Body: 
  
  {:createTime string,
   :versionNumber integer,
   :description string,
   :scriptId string}
  
  Creates a new immutable version using the current code, with a unique version number."
  {:scopes ["https://www.googleapis.com/auth/script.projects"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:scriptId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/versions"
     #{:scriptId}
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

(defn versions-get$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/projects/versions/get
  
  Required parameters: versionNumber, scriptId
  
  Optional parameters: none
  
  Gets a version of a script project."
  {:scopes ["https://www.googleapis.com/auth/script.projects"
            "https://www.googleapis.com/auth/script.projects.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scriptId :versionNumber})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/versions/{versionNumber}"
     #{:scriptId :versionNumber}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
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
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scriptId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://script.googleapis.com/"
     "v1/projects/{scriptId}/versions"
     #{:scriptId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
