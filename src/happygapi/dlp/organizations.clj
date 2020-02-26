(ns happygapi.dlp.organizations
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
  "Required parameters: locationId, parent
  
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
  "Required parameters: locationId, parent
  
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
  "Required parameters: locationId, parent
  
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
