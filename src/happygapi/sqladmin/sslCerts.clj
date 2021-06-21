(ns happygapi.sqladmin.sslCerts
  "Cloud SQL Admin API: sslCerts.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn createEphemeral$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/createEphemeral
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:access_token string, :public_key string}
  
  Generates a short-lived X509 certificate containing the provided public key and signed by a private key specific to the target instance. Users may use the certificate to authenticate as themselves when connecting to the database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/createEphemeral"
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

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/list
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Lists all of the current SSL certificates for the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/delete
  
  Required parameters: instance, sha1Fingerprint, project
  
  Optional parameters: none
  
  Deletes the SSL certificate. For First Generation instances, the certificate remains valid until the instance is restarted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instance :project :sha1Fingerprint})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}"
     #{:instance :project :sha1Fingerprint}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/insert
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:commonName string}
  
  Creates an SSL certificate and returns it along with the private key and server certificate authority. The new certificate will not be usable until the instance is restarted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts"
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

(defn get$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/get
  
  Required parameters: sha1Fingerprint, project, instance
  
  Optional parameters: none
  
  Retrieves a particular SSL certificate. Does not include the private key (required for usage). The private key must be saved from the response to initial creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instance :project :sha1Fingerprint})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}"
     #{:instance :project :sha1Fingerprint}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
