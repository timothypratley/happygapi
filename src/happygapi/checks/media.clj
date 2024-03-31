(ns happygapi.checks.media
  "Checks API: media.
  The Checks API contains powerful and easy-to-use privacy and compliance APIs that interact with the Checks product and its underlying technology.
  See: https://developers.google.com/checksapi/reference/rest/v1alpha/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn upload$
  "https://developers.google.com/checksapi/reference/rest/v1alpha/media/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:appBinaryFileType string, :codeReferenceId string}
  
  Analyzes the uploaded app bundle and returns a google.longrunning.Operation containing the generated Report. ## Example (upload only) Send a regular POST request with the header `X-Goog-Upload-Protocol: raw`. ``` POST https://checks.googleapis.com/upload/v1alpha/{parent=accounts/*/apps/*}/reports:analyzeUpload HTTP/1.1 X-Goog-Upload-Protocol: raw Content-Length: Content-Type: application/octet-stream ``` ## Example (upload with metadata) Send a multipart POST request where the first body part contains the metadata JSON and the second body part contains the binary upload. Include the header `X-Goog-Upload-Protocol: multipart`. ``` POST https://checks.googleapis.com/upload/v1alpha/{parent=accounts/*/apps/*}/reports:analyzeUpload HTTP/1.1 X-Goog-Upload-Protocol: multipart Content-Length: ? Content-Type: multipart/related; boundary=BOUNDARY --BOUNDARY Content-Type: application/json {\"code_reference_id\":\"db5bcc20f94055fb5bc08cbb9b0e7a5530308786\"} --BOUNDARY --BOUNDARY-- ``` *Note:* Metadata-only requests are not supported. "
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://checks.googleapis.com/"
     "v1alpha/{+parent}/reports:analyzeUpload"
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
