(ns happygapi.datacatalog.projects
  "Google Cloud Data Catalog API
  A fully managed and highly scalable data discovery and metadata management service.
  
  See: https://cloud.google.com/data-catalog/docs/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "datacatalog_schema.edn"))))

(defn locations-entryGroups-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy for a resource. Replaces any existing
  policy.
  Supported resources are:
    - Tag templates.
    - Entries.
    - Entry groups.
  Note, this method cannot be used to manage policies for BigQuery, Cloud
  Pub/Sub and any external Google Cloud Platform resources synced to Cloud
  Data Catalog.
  
  Callers must have following Google IAM permission
    - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag
      templates.
    - `datacatalog.entries.setIamPolicy` to set policies on entries.
    - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
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

(defn locations-entryGroups-create$
  "Required parameters: parent
  
  Optional parameters: entryGroupId
  
  A maximum of 10,000 entry groups may be created per organization across all
  locations.
  
  Users should enable the Data Catalog API in the project identified by
  the `parent` parameter (see [Data Catalog Resource Project]
  (/data-catalog/docs/concepts/resource-project) for more information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/entryGroups"
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

(defn locations-entryGroups-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for a resource. A `NOT_FOUND` error
  is returned if the resource does not exist. An empty policy is returned
  if the resource exists but does not have a policy set on it.
  
  Supported resources are:
    - Tag templates.
    - Entries.
    - Entry groups.
  Note, this method cannot be used to manage policies for BigQuery, Cloud
  Pub/Sub and any external Google Cloud Platform resources synced to Cloud
  Data Catalog.
  
  Callers must have following Google IAM permission
    - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag
      templates.
    - `datacatalog.entries.getIamPolicy` to get policies on entries.
    - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
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

(defn locations-entryGroups-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates an EntryGroup. The user should enable the Data Catalog API in the
  project identified by the `entry_group.name` parameter (see [Data Catalog
  Resource Project] (/data-catalog/docs/concepts/resource-project) for more
  information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-get$
  "Required parameters: name
  
  Optional parameters: readMask
  
  Gets an EntryGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns the caller's permissions on a resource.
  If the resource does not exist, an empty set of permissions is returned
  (We don't return a `NOT_FOUND` error).
  
  Supported resources are:
    - Tag templates.
    - Entries.
    - Entry groups.
  Note, this method cannot be used to manage policies for BigQuery, Cloud
  Pub/Sub and any external Google Cloud Platform resources synced to Cloud
  Data Catalog.
  
  A caller is not required to have Google IAM permission to make this
  request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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

(defn locations-entryGroups-delete$
  "Required parameters: name
  
  Optional parameters: force
  
  Deletes an EntryGroup. Only entry groups that do not contain entries can be
  deleted. Users should enable the Data Catalog API in the project
  identified by the `name` parameter (see [Data Catalog Resource Project]
  (/data-catalog/docs/concepts/resource-project) for more information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing entry. Only entries created through
  CreateEntry
  method can be deleted.
  Users should enable the Data Catalog API in the project identified by
  the `name` parameter (see [Data Catalog Resource Project]
  (/data-catalog/docs/concepts/resource-project) for more information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-list$
  "Required parameters: parent
  
  Optional parameters: readMask, pageToken, pageSize
  
  Lists entries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/entries"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-create$
  "Required parameters: parent
  
  Optional parameters: entryId
  
  Creates an entry. Only entries of 'FILESET' type or user-specified type can
  be created.
  
  Users should enable the Data Catalog API in the project identified by
  the `parent` parameter (see [Data Catalog Resource Project]
  (/data-catalog/docs/concepts/resource-project) for more information).
  
  A maximum of 100,000 entries may be created per entry group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/entries"
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

(defn locations-entryGroups-entries-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for a resource. A `NOT_FOUND` error
  is returned if the resource does not exist. An empty policy is returned
  if the resource exists but does not have a policy set on it.
  
  Supported resources are:
    - Tag templates.
    - Entries.
    - Entry groups.
  Note, this method cannot be used to manage policies for BigQuery, Cloud
  Pub/Sub and any external Google Cloud Platform resources synced to Cloud
  Data Catalog.
  
  Callers must have following Google IAM permission
    - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag
      templates.
    - `datacatalog.entries.getIamPolicy` to get policies on entries.
    - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
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

(defn locations-entryGroups-entries-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates an existing entry.
  Users should enable the Data Catalog API in the project identified by
  the `entry.name` parameter (see [Data Catalog Resource Project]
  (/data-catalog/docs/concepts/resource-project) for more information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets an entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns the caller's permissions on a resource.
  If the resource does not exist, an empty set of permissions is returned
  (We don't return a `NOT_FOUND` error).
  
  Supported resources are:
    - Tag templates.
    - Entries.
    - Entry groups.
  Note, this method cannot be used to manage policies for BigQuery, Cloud
  Pub/Sub and any external Google Cloud Platform resources synced to Cloud
  Data Catalog.
  
  A caller is not required to have Google IAM permission to make this
  request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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

(defn locations-entryGroups-entries-tags-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a tag on an Entry.
  Note: The project identified by the `parent` parameter for the
  [tag](/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
  and the
  [tag
  template](/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
  used to create the tag must be from the same organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/tags"
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

(defn locations-entryGroups-entries-tags-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-tags-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates an existing tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-tags-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the tags on an Entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/tags"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-tags-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a tag on an Entry.
  Note: The project identified by the `parent` parameter for the
  [tag](/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
  and the
  [tag
  template](/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
  used to create the tag must be from the same organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/tags"
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

(defn locations-entryGroups-tags-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-tags-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates an existing tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-tags-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the tags on an Entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/tags"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tagTemplates-create$
  "Required parameters: parent
  
  Optional parameters: tagTemplateId
  
  Creates a tag template. The user should enable the Data Catalog API in
  the project identified by the `parent` parameter (see [Data Catalog
  Resource Project](/data-catalog/docs/concepts/resource-project) for more
  information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/tagTemplates"
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

(defn locations-tagTemplates-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy for a resource. Replaces any existing
  policy.
  Supported resources are:
    - Tag templates.
    - Entries.
    - Entry groups.
  Note, this method cannot be used to manage policies for BigQuery, Cloud
  Pub/Sub and any external Google Cloud Platform resources synced to Cloud
  Data Catalog.
  
  Callers must have following Google IAM permission
    - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag
      templates.
    - `datacatalog.entries.setIamPolicy` to set policies on entries.
    - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
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

(defn locations-tagTemplates-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for a resource. A `NOT_FOUND` error
  is returned if the resource does not exist. An empty policy is returned
  if the resource exists but does not have a policy set on it.
  
  Supported resources are:
    - Tag templates.
    - Entries.
    - Entry groups.
  Note, this method cannot be used to manage policies for BigQuery, Cloud
  Pub/Sub and any external Google Cloud Platform resources synced to Cloud
  Data Catalog.
  
  Callers must have following Google IAM permission
    - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag
      templates.
    - `datacatalog.entries.getIamPolicy` to get policies on entries.
    - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
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

(defn locations-tagTemplates-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a tag template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tagTemplates-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a tag template. This method cannot be used to update the fields of
  a template. The tag template fields are represented as separate resources
  and should be updated using their own create/update/delete methods.
  Users should enable the Data Catalog API in the project identified by
  the `tag_template.name` parameter (see [Data Catalog Resource Project]
  (/data-catalog/docs/concepts/resource-project) for more information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tagTemplates-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns the caller's permissions on a resource.
  If the resource does not exist, an empty set of permissions is returned
  (We don't return a `NOT_FOUND` error).
  
  Supported resources are:
    - Tag templates.
    - Entries.
    - Entry groups.
  Note, this method cannot be used to manage policies for BigQuery, Cloud
  Pub/Sub and any external Google Cloud Platform resources synced to Cloud
  Data Catalog.
  
  A caller is not required to have Google IAM permission to make this
  request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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

(defn locations-tagTemplates-delete$
  "Required parameters: name
  
  Optional parameters: force
  
  Deletes a tag template and all tags using the template.
  Users should enable the Data Catalog API in the project identified by
  the `name` parameter (see [Data Catalog Resource Project]
  (/data-catalog/docs/concepts/resource-project) for more information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tagTemplates-fields-delete$
  "Required parameters: name
  
  Optional parameters: force
  
  Deletes a field in a tag template and all uses of that field.
  Users should enable the Data Catalog API in the project identified by
  the `name` parameter (see [Data Catalog Resource Project]
  (/data-catalog/docs/concepts/resource-project) for more information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tagTemplates-fields-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a field in a tag template. This method cannot be used to update the
  field type. Users should enable the Data Catalog API in the project
  identified by the `name` parameter (see [Data Catalog Resource Project]
  (/data-catalog/docs/concepts/resource-project) for more information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tagTemplates-fields-rename$
  "Required parameters: name
  
  Optional parameters: none
  
  Renames a field in a tag template. The user should enable the Data Catalog
  API in the project identified by the `name` parameter (see [Data Catalog
  Resource Project](/data-catalog/docs/concepts/resource-project) for more
  information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}:rename"
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

(defn locations-tagTemplates-fields-create$
  "Required parameters: parent
  
  Optional parameters: tagTemplateFieldId
  
  Creates a field in a tag template. The user should enable the Data Catalog
  API in the project identified by the `parent` parameter (see
  [Data Catalog Resource
  Project](/data-catalog/docs/concepts/resource-project) for more
  information)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/fields"
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

(defn locations-taxonomies-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the IAM policy for a taxonomy or a policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
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

(defn locations-taxonomies-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns the permissions that a caller has on the specified taxonomy or
  policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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

(defn locations-taxonomies-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a taxonomy in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/taxonomies"
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

(defn locations-taxonomies-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a taxonomy. This operation will also delete all
  policy tags in this taxonomy along with their associated policies."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-export$
  "Required parameters: parent
  
  Optional parameters: taxonomies, serializedTaxonomies
  
  Exports all taxonomies and their policy tags in a project.
  
  This method generates SerializedTaxonomy protos with nested policy tags
  that can be used as an input for future ImportTaxonomies calls."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/taxonomies:export"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the IAM policy for a taxonomy or a policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
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

(defn locations-taxonomies-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all taxonomies in a project in a particular location that the caller
  has permission to view."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/taxonomies"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-import$
  "Required parameters: parent
  
  Optional parameters: none
  
  Imports all taxonomies and their policy tags to a project as new
  taxonomies.
  
  This method provides a bulk taxonomy / policy tag creation using nested
  proto structure."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/taxonomies:import"
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

(defn locations-taxonomies-policyTags-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all policy tags in a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/policyTags"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-policyTags-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a policy tag in the specified taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+parent}/policyTags"
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

(defn locations-taxonomies-policyTags-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the IAM policy for a taxonomy or a policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
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

(defn locations-taxonomies-policyTags-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the IAM policy for a taxonomy or a policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
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

(defn locations-taxonomies-policyTags-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-policyTags-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-policyTags-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns the permissions that a caller has on the specified taxonomy or
  policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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

(defn locations-taxonomies-policyTags-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a policy tag. Also deletes all of its descendant policy tags."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
