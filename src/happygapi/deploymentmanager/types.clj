(ns happygapi.deploymentmanager.types
  "Google Cloud Deployment Manager API
  Declares, configures, and deploys complex solutions on Google Cloud Platform.
  See: https://cloud.google.com/deployment-manager/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "deploymentmanager_schema.edn"))))

(defn list$
  "Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Lists all resource types for Deployment Manager."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/types"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
