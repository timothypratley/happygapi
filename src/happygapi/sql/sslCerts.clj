(ns happygapi.sql.sslCerts
  "Cloud SQL Admin API: sslCerts.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/delete
  
  Required parameters: instance, project, sha1Fingerprint
  
  Optional parameters: resourceName
  Deletes the SSL certificate. For First Generation instances, the
  certificate remains valid until the instance is restarted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project :sha1Fingerprint})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}"
     #{:instance :project :sha1Fingerprint}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/insert
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:commonName string}
  
  Creates an SSL certificate and returns it along with the private key and
  server certificate authority.  The new certificate will not be usable until
  the instance is restarted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts"
     #{:instance :project}
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

(defn get$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/get
  
  Required parameters: project, sha1Fingerprint, instance
  
  Optional parameters: resourceName
  Retrieves a particular SSL certificate.  Does not include the private key
  (required for usage).  The private key must be saved from the response to
  initial creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project :sha1Fingerprint})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}"
     #{:instance :project :sha1Fingerprint}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/list
  
  Required parameters: instance, project
  
  Optional parameters: parent
  Lists all of the current SSL certificates for the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn createEphemeral$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/sslCerts/createEphemeral
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:public_key string}
  
  Generates a short-lived X509 certificate containing the provided public key
  and signed by a private key specific to the target instance. Users may use
  the certificate to authenticate as themselves when connecting to the
  database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/createEphemeral"
     #{:instance :project}
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
