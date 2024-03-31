(ns happygapi.cloudidentity.inboundSsoAssignments
  "Cloud Identity API: inboundSsoAssignments.
  API for provisioning and managing identity resources.
  See: https://cloud.google.com/identity/api/reference/rest/v1/inboundSsoAssignments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSsoAssignments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an InboundSsoAssignment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn create$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSsoAssignments/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:targetGroup string,
   :targetOrgUnit string,
   :name string,
   :customer string,
   :rank integer,
   :ssoMode string,
   :samlSsoInfo {:inboundSamlSsoProfile string},
   :signInBehavior {:redirectCondition string}}
  
  Creates an InboundSsoAssignment for users and devices in a `Customer` under a given `Group` or `OrgUnit`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/inboundSsoAssignments"
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

(defn patch$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSsoAssignments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:targetGroup string,
   :targetOrgUnit string,
   :name string,
   :customer string,
   :rank integer,
   :ssoMode string,
   :samlSsoInfo {:inboundSamlSsoProfile string},
   :signInBehavior {:redirectCondition string}}
  
  Updates an InboundSsoAssignment. The body of this request is the `inbound_sso_assignment` field and the `update_mask` is relative to that. For example: a PATCH to `/v1/inboundSsoAssignments/0abcdefg1234567&update_mask=rank` with a body of `{ \"rank\": 1 }` moves that (presumably group-targeted) SSO assignment to the highest priority and shifts any other group-targeted assignments down in priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}"
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

(defn delete$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSsoAssignments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an InboundSsoAssignment. To disable SSO, Create (or Update) an assignment that has `sso_mode` == `SSO_OFF`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSsoAssignments/list
  
  Required parameters: none
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists the InboundSsoAssignments for a `Customer`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/inboundSsoAssignments"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
