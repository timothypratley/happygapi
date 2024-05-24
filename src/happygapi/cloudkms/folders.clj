(ns happygapi.cloudkms.folders
  "Cloud Key Management Service (KMS) API: folders.
  Manages keys and performs cryptographic operations in a central cloud service, for direct use by other cloud resources and applications. 
  See: https://cloud.google.com/kms/docs/reference/rest/v1/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn updateAutokeyConfig$
  "https://cloud.google.com/kms/api/reference/rest/v1/folders/updateAutokeyConfig
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :keyProject string}
  
  Updates the AutokeyConfig for a folder. The caller must have both `cloudkms.autokeyConfigs.update` permission on the parent folder and `cloudkms.cryptoKeys.setIamPolicy` permission on the provided key project. A KeyHandle creation in the folder's descendant projects will use this configuration to determine where to create the resulting CryptoKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
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

(defn getAutokeyConfig$
  "https://cloud.google.com/kms/api/reference/rest/v1/folders/getAutokeyConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the AutokeyConfig for a folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
