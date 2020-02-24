(ns happygapi.cloudidentity.groups
  "Cloud Identity API
  API for provisioning and managing identity resources.
  See: https://cloud.google.com/identity/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn search$
  "Required parameters: none
  
  Searches for Groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/groups:search"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: name
  
  Retrieves a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn patch$
  "Required parameters: name
  
  Updates a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn delete$
  "Required parameters: name
  
  Deletes a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn list$
  "Required parameters: none
  
  Lists groups within a customer or a domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/groups"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "Required parameters: none
  
  Creates a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/groups"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn lookup$
  "Required parameters: none
  
  Looks up [resource
  name](https://cloud.google.com/apis/design/resource_names) of a Group by
  its EntityKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/groups:lookup"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn memberships-delete$
  "Required parameters: name
  
  Deletes a Membership."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn memberships-get$
  "Required parameters: name
  
  Retrieves a Membership."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn memberships-list$
  "Required parameters: parent
  
  Lists Memberships within a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn memberships-create$
  "Required parameters: parent
  
  Creates a Membership."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn memberships-lookup$
  "Required parameters: parent
  
  Looks up [resource
  name](https://cloud.google.com/apis/design/resource_names) of a Membership
  within a Group by member's EntityKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships:lookup"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
