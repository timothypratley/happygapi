(ns happygapi.logging.v2
  "Stackdriver Logging API: v2.
  Writes log entries and manages your Stackdriver Logging configuration. The table entries below are presented in alphabetical order, not in order of common use. For explanations of the concepts found in the table entries, read the <a href=https://cloud.google.com/logging/docs>Stackdriver Logging documentation</a>.
  See: https://cloud.google.com/logging/docs/api/reference/rest/v2/v2"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/getCmekSettings
  
  Required parameters: name
  
  Optional parameters: none
  Gets the Logs Router CMEK settings for the given resource.Note: CMEK for the Logs Router can currently only be configured for GCP organizations. Once configured, it applies to all projects and folders in the GCP organization.See Enabling CMEK for Logs Router for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}/cmekSettings"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/updateCmekSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:kmsKeyName string, :name string, :serviceAccountId string}
  
  Updates the Logs Router CMEK settings for the given resource.Note: CMEK for the Logs Router can currently only be configured for GCP organizations. Once configured, it applies to all projects and folders in the GCP organization.UpdateCmekSettings will fail if 1) kms_key_name is invalid, or 2) the associated service account does not have the required roles/cloudkms.cryptoKeyEncrypterDecrypter role assigned for the key, or 3) access to the key is disabled.See Enabling CMEK for Logs Router for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}/cmekSettings"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
