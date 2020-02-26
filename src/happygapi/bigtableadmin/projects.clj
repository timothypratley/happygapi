(ns happygapi.bigtableadmin.projects
  "Cloud Bigtable Admin API
  Administer your Cloud Bigtable tables and instances.
  See: https://cloud.google.com/bigtable/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "bigtableadmin_schema.edn"))))

(defn instances-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on an instance resource. Replaces any
  existing policy."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn instances-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that the caller has on the specified instance resource."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn instances-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Create an instance within a project."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/instances"
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

(defn instances-update$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates an instance within a project. This method updates only the display
  name and type for an Instance. To update other Instance properties, such as
  labels, use PartialUpdateInstance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
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

(defn instances-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Delete an instance from a project."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for an instance resource. Returns an empty
  policy if an instance exists but does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn instances-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists information about instances in a project."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/instances"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-partialUpdateInstance$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Partially updates an instance within a project. This method can modify all
  fields of an Instance and is the preferred way to update an Instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a cluster from an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about a cluster."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists information about clusters in an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/clusters"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-update$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates a cluster within an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
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

(defn instances-clusters-create$
  "Required parameters: parent
  
  Optional parameters: clusterId
  
  Creates a cluster within an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/clusters"
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

(defn instances-clusters-backups-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for a Table or Backup resource.
  Returns an empty policy if the resource exists but does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn instances-clusters-backups-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on a Table or Backup resource.
  Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn instances-appProfiles-create$
  "Required parameters: parent
  
  Optional parameters: appProfileId, ignoreWarnings
  
  Creates an app profile within an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/appProfiles"
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

(defn instances-appProfiles-delete$
  "Required parameters: name
  
  Optional parameters: ignoreWarnings
  
  Deletes an app profile from an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-appProfiles-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about an app profile."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-appProfiles-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists information about app profiles in an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/appProfiles"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-appProfiles-patch$
  "Required parameters: name
  
  Optional parameters: ignoreWarnings, updateMask
  
  Updates an app profile within an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-tables-get$
  "Required parameters: name
  
  Optional parameters: view
  
  Gets metadata information about the specified table."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-tables-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on a Table or Backup resource.
  Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn instances-tables-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that the caller has on the specified table resource."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn instances-tables-generateConsistencyToken$
  "Required parameters: name
  
  Optional parameters: none
  
  Generates a consistency token for a Table, which can be used in
  CheckConsistency to check whether mutations to the table that finished
  before this call started have been replicated. The tokens will be available
  for 90 days."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:generateConsistencyToken"
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

(defn instances-tables-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new table in the specified instance.
  The table can be created with a full set of initial column families,
  specified in the request."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/tables"
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

(defn instances-tables-modifyColumnFamilies$
  "Required parameters: name
  
  Optional parameters: none
  
  Performs a series of column family modifications on the specified table.
  Either all or none of the modifications will occur before this method
  returns, but data requests received prior to that point may see a table
  where only some modifications have taken effect."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:modifyColumnFamilies"
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

(defn instances-tables-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Permanently deletes a specified table and all of its data."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-tables-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for a Table or Backup resource.
  Returns an empty policy if the resource exists but does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn instances-tables-dropRowRange$
  "Required parameters: name
  
  Optional parameters: none
  
  Permanently drop/delete a row range from a specified table. The request can
  specify whether to delete all rows in a table, or only those that match a
  particular prefix."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:dropRowRange"
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

(defn instances-tables-checkConsistency$
  "Required parameters: name
  
  Optional parameters: none
  
  Checks replication consistency based on a consistency token, that is, if
  replication has caught up based on the conditions specified in the token
  and the check request."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:checkConsistency"
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

(defn instances-tables-list$
  "Required parameters: parent
  
  Optional parameters: view, pageToken, pageSize
  
  Lists all tables served from a specified instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/tables"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}/locations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
