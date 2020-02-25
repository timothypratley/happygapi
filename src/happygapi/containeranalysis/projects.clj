(ns happygapi.containeranalysis.projects
  "Container Analysis API
  An implementation of the Grafeas API, which stores, and enables querying and retrieval of critical metadata about all of your software artifacts.
  See: https://cloud.google.com/container-analysis/api/reference/rest/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "containeranalysis_schema.edn"))))

(defn operations-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates an existing operation returns an error if operation
   does not exist. The only valid operations are to update mark the done bit
  change the result."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn operations-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new `Operation`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+parent}/operations"
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

(defn occurrences-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Returns the requested `Occurrence`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on the specified `Note` or `Occurrence`.
  Requires `containeranalysis.notes.setIamPolicy` or
  `containeranalysis.occurrences.setIamPolicy` permission if the resource is
  a `Note` or an `Occurrence`, respectively.
  Attempting to call this method without these permissions will result in a `
  `PERMISSION_DENIED` error.
  Attempting to call this method on a non-existent resource will result in a
  `NOT_FOUND` error if the user has `containeranalysis.notes.list` permission
  on a `Note` or `containeranalysis.occurrences.list` on an `Occurrence`, or
  a `PERMISSION_DENIED` error otherwise. The resource takes the following
  formats: `projects/{projectid}/occurrences/{occurrenceid}` for occurrences
  and projects/{projectid}/notes/{noteid} for notes"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn occurrences-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates an existing occurrence."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns the permissions that a caller has on the specified note or
  occurrence resource. Requires list permission on the project (for example,
  \"storage.objects.list\" on the containing bucket for testing permission of
  an object). Attempting to call this method on a non-existent resource will
  result in a `NOT_FOUND` error if the user has list permission on the
  project, or a `PERMISSION_DENIED` error otherwise. The resource takes the
  following formats: `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for
  `Occurrences` and `projects/{PROJECT_ID}/notes/{NOTE_ID}` for `Notes`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn occurrences-create$
  "Required parameters: parent
  
  Optional parameters: name
  
  Creates a new `Occurrence`. Use this method to create `Occurrences`
  for a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+parent}/occurrences"
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

(defn occurrences-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the given `Occurrence` from the system. Use this when
  an `Occurrence` is no longer applicable for the given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-getVulnerabilitySummary$
  "Required parameters: parent
  
  Optional parameters: filter
  
  Gets a summary of the number and severity of occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+parent}/occurrences:vulnerabilitySummary"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for a note or an `Occurrence` resource.
  Requires `containeranalysis.notes.setIamPolicy` or
  `containeranalysis.occurrences.setIamPolicy` permission if the resource is
  a note or occurrence, respectively.
  Attempting to call this method on a resource without the required
  permission will result in a `PERMISSION_DENIED` error. Attempting to call
  this method on a non-existent resource will result in a `NOT_FOUND` error
  if the user has list permission on the project, or a `PERMISSION_DENIED`
  error otherwise. The resource takes the following formats:
  `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for occurrences and
  projects/{PROJECT_ID}/notes/{NOTE_ID} for notes"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn occurrences-list$
  "Required parameters: parent
  
  Optional parameters: name, filter, pageToken, kind, pageSize
  
  Lists active `Occurrences` for a given project matching the filters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+parent}/occurrences"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-getNotes$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the `Note` attached to the given `Occurrence`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}/notes"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn notes-create$
  "Required parameters: parent
  
  Optional parameters: noteId, name
  
  Creates a new `Note`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+parent}/notes"
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

(defn notes-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on the specified `Note` or `Occurrence`.
  Requires `containeranalysis.notes.setIamPolicy` or
  `containeranalysis.occurrences.setIamPolicy` permission if the resource is
  a `Note` or an `Occurrence`, respectively.
  Attempting to call this method without these permissions will result in a `
  `PERMISSION_DENIED` error.
  Attempting to call this method on a non-existent resource will result in a
  `NOT_FOUND` error if the user has `containeranalysis.notes.list` permission
  on a `Note` or `containeranalysis.occurrences.list` on an `Occurrence`, or
  a `PERMISSION_DENIED` error otherwise. The resource takes the following
  formats: `projects/{projectid}/occurrences/{occurrenceid}` for occurrences
  and projects/{projectid}/notes/{noteid} for notes"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn notes-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for a note or an `Occurrence` resource.
  Requires `containeranalysis.notes.setIamPolicy` or
  `containeranalysis.occurrences.setIamPolicy` permission if the resource is
  a note or occurrence, respectively.
  Attempting to call this method on a resource without the required
  permission will result in a `PERMISSION_DENIED` error. Attempting to call
  this method on a non-existent resource will result in a `NOT_FOUND` error
  if the user has list permission on the project, or a `PERMISSION_DENIED`
  error otherwise. The resource takes the following formats:
  `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for occurrences and
  projects/{PROJECT_ID}/notes/{NOTE_ID} for notes"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn notes-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Returns the requested `Note`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn notes-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates an existing `Note`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn notes-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns the permissions that a caller has on the specified note or
  occurrence resource. Requires list permission on the project (for example,
  \"storage.objects.list\" on the containing bucket for testing permission of
  an object). Attempting to call this method on a non-existent resource will
  result in a `NOT_FOUND` error if the user has list permission on the
  project, or a `PERMISSION_DENIED` error otherwise. The resource takes the
  following formats: `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for
  `Occurrences` and `projects/{PROJECT_ID}/notes/{NOTE_ID}` for `Notes`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn notes-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the given `Note` from the system."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn notes-list$
  "Required parameters: parent
  
  Optional parameters: name, pageToken, pageSize, filter
  
  Lists all `Notes` for a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+parent}/notes"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn notes-occurrences-list$
  "Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists `Occurrences` referencing the specified `Note`. Use this method to
  get all occurrences referencing your `Note` across all your customer
  projects."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}/occurrences"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a specific scan configuration for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists scan configurations for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+parent}/scanConfigs"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the scan configuration to a new value."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
