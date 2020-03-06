(ns happygapi.iam.roles
  "Identity and Access Management (IAM) API: roles.
  Manages identity and access control for Google Cloud Platform resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls.
  See: https://cloud.google.com/iam/api/reference/rest/v1/roles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn queryGrantableRoles$
  "https://cloud.google.com/iam/api/reference/rest/v1/roles/queryGrantableRoles
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:fullResourceName string,
   :pageToken string,
   :pageSize integer,
   :view string}
  
  Queries roles that can be granted on a particular resource.
  A role is grantable if it can be used as the role in a binding for a policy
  for that resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/roles:queryGrantableRoles"
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

(defn list$
  "https://cloud.google.com/iam/api/reference/rest/v1/roles/list
  
  Required parameters: none
  
  Optional parameters: parent, showDeleted, pageToken, pageSize, view
  Lists the Roles defined on a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url "https://iam.googleapis.com/" "v1/roles" #{} args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/iam/api/reference/rest/v1/roles/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets a Role definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
