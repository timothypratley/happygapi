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
  
  {:pageSize integer,
   :view string,
   :pageToken string,
   :fullResourceName string}
  
  Lists roles that can be granted on a Google Cloud resource. A role is grantable if the IAM policy for the resource can contain bindings to the role."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/roles:queryGrantableRoles"
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

(defn get$
  "https://cloud.google.com/iam/api/reference/rest/v1/roles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the definition of a Role."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn list$
  "https://cloud.google.com/iam/api/reference/rest/v1/roles/list
  
  Required parameters: none
  
  Optional parameters: view, showDeleted, pageSize, parent, pageToken
  
  Lists every predefined Role that IAM supports, or every custom role that is defined for an organization or project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/roles"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
