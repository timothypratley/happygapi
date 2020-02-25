(ns happygapi.cloudidentity.groups
  "Cloud Identity API
  API for provisioning and managing identity resources.
  See: https://cloud.google.com/identity/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudidentity_schema.edn"))))

(defn delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: parent, pageToken, pageSize, view
  
  Lists groups within a customer or a domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Creates a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: groupKey.namespace, groupKey.id
  
  Looks up [resource
  name](https://cloud.google.com/apis/design/resource_names) of a Group by
  its EntityKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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

(defn search$
  "Required parameters: none
  
  Optional parameters: pageSize, query, view, pageToken
  
  Searches for Groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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

(defn patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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

(defn get$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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

(defn memberships-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a Membership."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Retrieves a Membership."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: pageToken, pageSize, view
  
  Lists Memberships within a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Creates a Membership."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: memberKey.id, memberKey.namespace
  
  Looks up [resource
  name](https://cloud.google.com/apis/design/resource_names) of a Membership
  within a Group by member's EntityKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
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
