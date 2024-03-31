(ns happygapi.cloudsupport.media
  "Google Cloud Support API: media.
  Manages Google Cloud technical support cases for Customer Care support offerings. 
  See: https://cloud.google.com/support/docs/apisapi/reference/rest/v2/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn upload$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/media/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:attachment {:sizeBytes string,
                :name string,
                :filename string,
                :creator Actor,
                :mimeType string,
                :createTime string}}
  
  Create a file attachment on a case or Cloud resource. The attachment must have the following fields set: `filename`. EXAMPLES: cURL: ```shell echo \"This text is in a file I'm uploading using CSAPI.\" \\ > \"./example_file.txt\" case=\"projects/some-project/cases/43594844\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --data-binary @\"./example_file.txt\" \\ \"https://cloudsupport.googleapis.com/upload/v2beta/$case/attachments?attachment.filename=uploaded_via_curl.txt\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) file_path = \"./example_file.txt\" with open(file_path, \"w\") as file: file.write( \"This text is inside a file I'm going to upload using the Cloud Support API.\", ) request = supportApiService.media().upload( parent=\"projects/some-project/cases/43595344\", media_body=file_path ) request.uri = request.uri.split(\"?\")[0] + \"?attachment.filename=uploaded_via_python.txt\" print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+parent}/attachments"
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

(defn download$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/media/download
  
  Required parameters: name
  
  Optional parameters: none
  
  Download a file attached to a case. Note: HTTP requests must append \"?alt=media\" to the URL. EXAMPLES: cURL: ```shell name=\"projects/some-project/cases/43594844/attachments/0674M00000WijAnZAJ\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$name:download?alt=media\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.media().download( name=\"projects/some-project/cases/43595344/attachments/0684M00000Pw6pHQAR\" ) request.uri = request.uri.split(\"?\")[0] + \"?alt=media\" print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+name}:download"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
