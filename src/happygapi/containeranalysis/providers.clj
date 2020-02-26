(ns happygapi.containeranalysis.providers
  "Container Analysis API
  An implementation of the Grafeas API, which stores, and enables querying and retrieval of critical metadata about all of your software artifacts.
  See: https://cloud.google.com/container-analysis/api/reference/rest/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "containeranalysis_schema.edn"))))

(defn notes-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize, parent, filter
  
  Lists all `Notes` for a given project."
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
      :body (json/generate-string body)}
     auth))))

(defn notes-create$
  "Required parameters: name
  
  Optional parameters: parent, noteId
  
  Creates a new `Note`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
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
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
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
      :body (json/generate-string body)}
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
      :body (json/generate-string body)}
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

(defn notes-occurrences-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
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
