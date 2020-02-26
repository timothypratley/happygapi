(ns happygapi.iam.organizations
  "Identity and Access Management (IAM) API
  Manages identity and access control for Google Cloud Platform resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls.
  See: https://cloud.google.com/iam/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas (edn/read-string (slurp (io/resource "iam_schema.edn"))))

(defn roles-list$
  "Required parameters: parent
  
  Optional parameters: showDeleted, pageToken, pageSize, view
  
  Lists the Roles defined on a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/roles"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn roles-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new Role."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/roles"
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

(defn roles-undelete$
  "Required parameters: name
  
  Optional parameters: none
  
  Undelete a Role, bringing it back in its previous state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:undelete"
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

(defn roles-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a Role definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn roles-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a Role definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn roles-delete$
  "Required parameters: name
  
  Optional parameters: etag
  
  Soft deletes a role. The role is suspended and cannot be used to create new
  IAM Policy Bindings.
  The Role will not be included in `ListRoles()` unless `show_deleted` is set
  in the `ListRolesRequest`. The Role contains the deleted boolean set.
  Existing Bindings remains, but are inactive. The Role can be undeleted
  within 7 days. After 7 days the Role is deleted and all Bindings associated
  with the role are removed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
