(ns happygapi.publicca.projects
  "Public Certificate Authority API: projects.
  The Public Certificate Authority API may be used to create and manage ACME external account binding keys associated with Google Trust Services' publicly trusted certificate authority. 
  See: https://cloud.google.com/public-certificate-authority/docsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-externalAccountKeys-create$
  "https://cloud.google.com/public-certificate-authority/docsapi/reference/rest/v1/projects/locations/externalAccountKeys/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :keyId string, :b64MacKey string}
  
  Creates a new ExternalAccountKey bound to the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://publicca.googleapis.com/"
     "v1/{+parent}/externalAccountKeys"
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
