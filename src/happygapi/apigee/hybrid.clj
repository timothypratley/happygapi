(ns happygapi.apigee.hybrid
  "Apigee API: hybrid.
  Use the Apigee API to programmatically develop and manage APIs with a set of RESTful operations. Develop and secure API proxies, deploy and undeploy API proxy revisions, monitor APIs, configure environments, manage users, and more. Note: This product is available as a free trial for a time period of 60 days.
  See: https://cloud.google.com/apigee-api-management/api/reference/rest/v1/hybrid"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn issuers-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/hybrid/issuers/list
  
  Required parameters: name
  
  Optional parameters: none
  
  Lists hybrid services and its trusted issuers service account ids. This api is authenticated and unauthorized(allow all the users) and used by runtime authn-authz service to query control plane's issuer service account ids."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
