(ns happygapi.containeranalysis.projects
  "Container Analysis API: projects.
  An implementation of the Grafeas API, which stores, and enables querying and retrieval of critical metadata about all of your software artifacts.
  See: https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn scanConfigs-get$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/scanConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified scan configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-update$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/scanConfigs/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:enabled boolean,
   :name string,
   :createTime string,
   :description string,
   :updateTime string}
  
  Updates the specified scan configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}"
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

(defn scanConfigs-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/scanConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists scan configurations for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+parent}/scanConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-get$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified occurrence."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-setIamPolicy$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
  Sets the access control policy on the specified note or occurrence. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or an occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn occurrences-patch$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:noteName string,
   :remediation string,
   :name string,
   :createTime string,
   :discovered {:discovered Discovered},
   :vulnerability {:shortDescription string,
                   :longDescription string,
                   :severity string,
                   :effectiveSeverity string,
                   :type string,
                   :relatedUrls [RelatedUrl],
                   :cvssScore number,
                   :packageIssue [PackageIssue]},
   :updateTime string,
   :build {:provenance BuildProvenance, :provenanceBytes string},
   :installation {:installation Installation},
   :derivedImage {:derivedImage Derived},
   :attestation {:attestation Attestation},
   :resource {:contentHash Hash, :name string, :uri string},
   :kind string,
   :deployment {:deployment Deployment},
   :intoto {:signatures [GrafeasV1beta1IntotoSignature], :signed Link}}
  
  Updates the specified occurrence."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}"
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

(defn occurrences-testIamPermissions$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the permissions that a caller has on the specified note or occurrence. Requires list permission on the project (for example, `containeranalysis.notes.list`). The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn occurrences-create$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:noteName string,
   :remediation string,
   :name string,
   :createTime string,
   :discovered {:discovered Discovered},
   :vulnerability {:shortDescription string,
                   :longDescription string,
                   :severity string,
                   :effectiveSeverity string,
                   :type string,
                   :relatedUrls [RelatedUrl],
                   :cvssScore number,
                   :packageIssue [PackageIssue]},
   :updateTime string,
   :build {:provenance BuildProvenance, :provenanceBytes string},
   :installation {:installation Installation},
   :derivedImage {:derivedImage Derived},
   :attestation {:attestation Attestation},
   :resource {:contentHash Hash, :name string, :uri string},
   :kind string,
   :deployment {:deployment Deployment},
   :intoto {:signatures [GrafeasV1beta1IntotoSignature], :signed Link}}
  
  Creates a new occurrence."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+parent}/occurrences"
     #{:parent}
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

(defn occurrences-batchCreate$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:occurrences [{:noteName string,
                  :remediation string,
                  :name string,
                  :createTime string,
                  :discovered GrafeasV1beta1DiscoveryDetails,
                  :vulnerability GrafeasV1beta1VulnerabilityDetails,
                  :updateTime string,
                  :build GrafeasV1beta1BuildDetails,
                  :installation GrafeasV1beta1PackageDetails,
                  :derivedImage GrafeasV1beta1ImageDetails,
                  :attestation Details,
                  :resource Resource,
                  :kind string,
                  :deployment GrafeasV1beta1DeploymentDetails,
                  :intoto GrafeasV1beta1IntotoDetails}]}
  
  Creates new occurrences in batch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+parent}/occurrences:batchCreate"
     #{:parent}
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

(defn occurrences-delete$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified occurrence. For example, use this method to delete an occurrence when the occurrence is no longer applicable for the given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-getVulnerabilitySummary$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/getVulnerabilitySummary
  
  Required parameters: parent
  
  Optional parameters: filter
  
  Gets a summary of the number and severity of occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+parent}/occurrences:vulnerabilitySummary"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-getIamPolicy$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a note or an occurrence resource. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{:resource}
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

(defn occurrences-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists occurrences for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+parent}/occurrences"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn occurrences-getNotes$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/occurrences/getNotes
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the note attached to the specified occurrence. Consumer projects can use this method to get a note that belongs to a provider project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}/notes"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notes-get$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notes-setIamPolicy$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
  Sets the access control policy on the specified note or occurrence. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or an occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn notes-patch$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:relatedUrl [{:url string, :label string}],
   :package {:distribution [Distribution], :name string},
   :discovery {:analysisKind string},
   :relatedNoteNames [string],
   :deployable {:resourceUri [string]},
   :expirationTime string,
   :name string,
   :createTime string,
   :vulnerability {:cvssScore number,
                   :severity string,
                   :cvssV3 CVSSv3,
                   :details [Detail],
                   :sourceUpdateTime string,
                   :windowsDetails [WindowsDetail]},
   :updateTime string,
   :attestationAuthority {:hint Hint},
   :shortDescription string,
   :baseImage {:resourceUrl string, :fingerprint Fingerprint},
   :build {:signature BuildSignature, :builderVersion string},
   :kind string,
   :intoto {:threshold string,
            :expectedProducts [ArtifactRule],
            :stepName string,
            :expectedCommand [string],
            :expectedMaterials [ArtifactRule],
            :signingKeys [SigningKey]},
   :longDescription string}
  
  Updates the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}"
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

(defn notes-testIamPermissions$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the permissions that a caller has on the specified note or occurrence. Requires list permission on the project (for example, `containeranalysis.notes.list`). The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn notes-create$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/create
  
  Required parameters: parent
  
  Optional parameters: noteId
  
  Body: 
  
  {:relatedUrl [{:url string, :label string}],
   :package {:distribution [Distribution], :name string},
   :discovery {:analysisKind string},
   :relatedNoteNames [string],
   :deployable {:resourceUri [string]},
   :expirationTime string,
   :name string,
   :createTime string,
   :vulnerability {:cvssScore number,
                   :severity string,
                   :cvssV3 CVSSv3,
                   :details [Detail],
                   :sourceUpdateTime string,
                   :windowsDetails [WindowsDetail]},
   :updateTime string,
   :attestationAuthority {:hint Hint},
   :shortDescription string,
   :baseImage {:resourceUrl string, :fingerprint Fingerprint},
   :build {:signature BuildSignature, :builderVersion string},
   :kind string,
   :intoto {:threshold string,
            :expectedProducts [ArtifactRule],
            :stepName string,
            :expectedCommand [string],
            :expectedMaterials [ArtifactRule],
            :signingKeys [SigningKey]},
   :longDescription string}
  
  Creates a new note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+parent}/notes"
     #{:parent}
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

(defn notes-batchCreate$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:notes {}}
  
  Creates new notes in batch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+parent}/notes:batchCreate"
     #{:parent}
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

(defn notes-delete$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notes-getIamPolicy$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a note or an occurrence resource. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{:resource}
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

(defn notes-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists notes for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+parent}/notes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notes-occurrences-list$
  "https://cloud.google.com/container-analysis/api/reference/rest/api/reference/rest/v1beta1/projects/notes/occurrences/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists occurrences referencing the specified note. Provider projects can use this method to get all occurrences across consumer projects referencing the specified note."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://containeranalysis.googleapis.com/"
     "v1beta1/{+name}/occurrences"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
