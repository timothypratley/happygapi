(ns happygapi.sqladmin.connect
  "Cloud SQL Admin API: connect.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1/connect"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/connect/get
  
  Required parameters: project, instance
  
  Optional parameters: readTime
  
  Retrieves connect settings about a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/connectSettings"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn generateEphemeral$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/connect/generateEphemeral
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:public_key string,
   :access_token string,
   :readTime string,
   :validDuration string}
  
  Generates a short-lived X509 certificate containing the provided public key and signed by a private key specific to the target instance. Users may use the certificate to authenticate as themselves when connecting to the database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}:generateEphemeralCert"
     #{:instance :project}
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
