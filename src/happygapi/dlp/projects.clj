(ns happygapi.dlp.projects
  "Cloud Data Loss Prevention (DLP) API
  Provides methods for detection, risk analysis, and de-identification of privacy-sensitive fragments in text, images, and Google Cloud Platform storage repositories.
  See: https://cloud.google.com/dlp/docs/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas (edn/read-string (slurp (io/resource "dlp_schema.edn"))))

(defn storedInfoTypes-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the stored infoType by creating a new version. The existing version
  will continue to be used until the new version is ready.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn storedInfoTypes-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a stored infoType.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn storedInfoTypes-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, locationId
  
  Lists stored infoTypes.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn storedInfoTypes-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a pre-built stored infoType to be used for inspection.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
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

(defn storedInfoTypes-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a stored infoType.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn deidentifyTemplates-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn deidentifyTemplates-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn deidentifyTemplates-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn deidentifyTemplates-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, locationId
  
  Lists DeidentifyTemplates.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a DeidentifyTemplate for re-using frequently used configuration
  for de-identifying content, images, and storage.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
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

(defn image-redact$
  "Required parameters: parent
  
  Optional parameters: none
  
  Redacts potentially sensitive info from an image.
  This method has limits on input size, processing time, and output size.
  See https://cloud.google.com/dlp/docs/redacting-sensitive-data-images to
  learn more.
  
  When no InfoTypes or CustomInfoTypes are specified in this request, the
  system will automatically choose what detectors to run. By default this may
  be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/image:redact"
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

(defn dlpJobs-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new job to inspect storage or calculate risk metrics.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
  
  When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the
  system will automatically choose what detectors to run. By default this may
  be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
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

(defn dlpJobs-cancel$
  "Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running DlpJob. The server
  makes a best effort to cancel the DlpJob, but success is not
  guaranteed.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn dlpJobs-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running DlpJob. This method indicates that the client is
  no longer interested in the DlpJob result. The job will be cancelled if
  possible.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn dlpJobs-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, locationId, pageSize, orderBy, type, filter
  
  Lists DlpJobs that match the specified filter in the request.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn dlpJobs-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running DlpJob.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn inspectTemplates-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes an InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn inspectTemplates-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn inspectTemplates-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets an InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn inspectTemplates-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, locationId
  
  Lists InspectTemplates.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn inspectTemplates-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates an InspectTemplate for re-using frequently used configuration
  for inspecting content, images, and storage.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
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

(defn content-reidentify$
  "Required parameters: parent
  
  Optional parameters: none
  
  Re-identifies content that has been de-identified.
  See
  https://cloud.google.com/dlp/docs/pseudonymization#re-identification_in_free_text_code_example
  to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:reidentify"
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

(defn content-deidentify$
  "Required parameters: parent
  
  Optional parameters: none
  
  De-identifies potentially sensitive info from a ContentItem.
  This method has limits on input size and output size.
  See https://cloud.google.com/dlp/docs/deidentify-sensitive-data to
  learn more.
  
  When no InfoTypes or CustomInfoTypes are specified in this request, the
  system will automatically choose what detectors to run. By default this may
  be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:deidentify"
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

(defn content-inspect$
  "Required parameters: parent
  
  Optional parameters: none
  
  Finds potentially sensitive info in content.
  This method has limits on input size, processing time, and output size.
  
  When no InfoTypes or CustomInfoTypes are specified in this request, the
  system will automatically choose what detectors to run. By default this may
  be all types, but may change over time as detectors are updated.
  
  For how to guides, see https://cloud.google.com/dlp/docs/inspecting-images
  and https://cloud.google.com/dlp/docs/inspecting-text,"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:inspect"
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

(defn locations-deidentifyTemplates-create$
  "Required parameters: locationId, parent
  
  Optional parameters: none
  
  Creates a DeidentifyTemplate for re-using frequently used configuration
  for de-identifying content, images, and storage.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/deidentifyTemplates"
     #{"locationId" "parent"}
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

(defn locations-deidentifyTemplates-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-deidentifyTemplates-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-deidentifyTemplates-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-deidentifyTemplates-list$
  "Required parameters: parent, locationId
  
  Optional parameters: pageToken, orderBy, pageSize
  
  Lists DeidentifyTemplates.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/deidentifyTemplates"
     #{"locationId" "parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-image-redact$
  "Required parameters: parent, locationId
  
  Optional parameters: none
  
  Redacts potentially sensitive info from an image.
  This method has limits on input size, processing time, and output size.
  See https://cloud.google.com/dlp/docs/redacting-sensitive-data-images to
  learn more.
  
  When no InfoTypes or CustomInfoTypes are specified in this request, the
  system will automatically choose what detectors to run. By default this may
  be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/image:redact"
     #{"locationId" "parent"}
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

(defn locations-dlpJobs-create$
  "Required parameters: locationId, parent
  
  Optional parameters: none
  
  Creates a new job to inspect storage or calculate risk metrics.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more.
  
  When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the
  system will automatically choose what detectors to run. By default this may
  be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/dlpJobs"
     #{"locationId" "parent"}
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

(defn locations-dlpJobs-cancel$
  "Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running DlpJob. The server
  makes a best effort to cancel the DlpJob, but success is not
  guaranteed.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn locations-dlpJobs-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running DlpJob. This method indicates that the client is
  no longer interested in the DlpJob result. The job will be cancelled if
  possible.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-dlpJobs-list$
  "Required parameters: locationId, parent
  
  Optional parameters: pageToken, pageSize, orderBy, type, filter
  
  Lists DlpJobs that match the specified filter in the request.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/dlpJobs"
     #{"locationId" "parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dlpJobs-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running DlpJob.
  See https://cloud.google.com/dlp/docs/inspecting-storage and
  https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-inspectTemplates-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes an InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-inspectTemplates-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-inspectTemplates-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets an InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-inspectTemplates-list$
  "Required parameters: parent, locationId
  
  Optional parameters: pageToken, orderBy, pageSize
  
  Lists InspectTemplates.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/inspectTemplates"
     #{"locationId" "parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-inspectTemplates-create$
  "Required parameters: parent, locationId
  
  Optional parameters: none
  
  Creates an InspectTemplate for re-using frequently used configuration
  for inspecting content, images, and storage.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/inspectTemplates"
     #{"locationId" "parent"}
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

(defn locations-content-inspect$
  "Required parameters: parent, locationId
  
  Optional parameters: none
  
  Finds potentially sensitive info in content.
  This method has limits on input size, processing time, and output size.
  
  When no InfoTypes or CustomInfoTypes are specified in this request, the
  system will automatically choose what detectors to run. By default this may
  be all types, but may change over time as detectors are updated.
  
  For how to guides, see https://cloud.google.com/dlp/docs/inspecting-images
  and https://cloud.google.com/dlp/docs/inspecting-text,"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/content:inspect"
     #{"locationId" "parent"}
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

(defn locations-content-reidentify$
  "Required parameters: locationId, parent
  
  Optional parameters: none
  
  Re-identifies content that has been de-identified.
  See
  https://cloud.google.com/dlp/docs/pseudonymization#re-identification_in_free_text_code_example
  to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/content:reidentify"
     #{"locationId" "parent"}
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

(defn locations-content-deidentify$
  "Required parameters: locationId, parent
  
  Optional parameters: none
  
  De-identifies potentially sensitive info from a ContentItem.
  This method has limits on input size and output size.
  See https://cloud.google.com/dlp/docs/deidentify-sensitive-data to
  learn more.
  
  When no InfoTypes or CustomInfoTypes are specified in this request, the
  system will automatically choose what detectors to run. By default this may
  be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/content:deidentify"
     #{"locationId" "parent"}
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

(defn locations-jobTriggers-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a job trigger.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-jobTriggers-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates a job trigger.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-jobTriggers-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a job trigger.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-jobTriggers-list$
  "Required parameters: locationId, parent
  
  Optional parameters: orderBy, filter, pageToken, pageSize
  
  Lists job triggers.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/jobTriggers"
     #{"locationId" "parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobTriggers-create$
  "Required parameters: locationId, parent
  
  Optional parameters: none
  
  Creates a job trigger to run DLP actions such as scanning storage for
  sensitive information on a set schedule.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/jobTriggers"
     #{"locationId" "parent"}
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

(defn locations-jobTriggers-activate$
  "Required parameters: name
  
  Optional parameters: none
  
  Activate a job trigger. Causes the immediate execute of a trigger
  instead of waiting on the trigger event to occur."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:activate"
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

(defn locations-storedInfoTypes-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a stored infoType.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-storedInfoTypes-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the stored infoType by creating a new version. The existing version
  will continue to be used until the new version is ready.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-storedInfoTypes-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a stored infoType.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn locations-storedInfoTypes-list$
  "Required parameters: locationId, parent
  
  Optional parameters: pageToken, orderBy, pageSize
  
  Lists stored infoTypes.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/storedInfoTypes"
     #{"locationId" "parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-storedInfoTypes-create$
  "Required parameters: parent, locationId
  
  Optional parameters: none
  
  Creates a pre-built stored infoType to be used for inspection.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"locationId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/storedInfoTypes"
     #{"locationId" "parent"}
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

(defn jobTriggers-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates a job trigger.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn jobTriggers-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a job trigger.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn jobTriggers-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a job trigger.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
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

(defn jobTriggers-list$
  "Required parameters: parent
  
  Optional parameters: filter, pageToken, locationId, pageSize, orderBy
  
  Lists job triggers.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobTriggers-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a job trigger to run DLP actions such as scanning storage for
  sensitive information on a set schedule.
  See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
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

(defn jobTriggers-activate$
  "Required parameters: name
  
  Optional parameters: none
  
  Activate a job trigger. Causes the immediate execute of a trigger
  instead of waiting on the trigger event to occur."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:activate"
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
