(ns happygapi.sql.sslCerts
  "Cloud SQL Admin API
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas (edn/read-string (slurp (io/resource "sql_schema.edn"))))

(defn delete$
  "Required parameters: project, sha1Fingerprint, instance
  
  Optional parameters: resourceName
  
  Deletes the SSL certificate. For First Generation instances, the
  certificate remains valid until the instance is restarted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"project" "sha1Fingerprint" "instance"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}"
     #{"project" "sha1Fingerprint" "instance"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: instance, project
  
  Optional parameters: parent
  
  Creates an SSL certificate and returns it along with the private key and
  server certificate authority.  The new certificate will not be usable until
  the instance is restarted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "instance"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts"
     #{"project" "instance"}
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

(defn get$
  "Required parameters: instance, project, sha1Fingerprint
  
  Optional parameters: resourceName
  
  Retrieves a particular SSL certificate.  Does not include the private key
  (required for usage).  The private key must be saved from the response to
  initial creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"project" "sha1Fingerprint" "instance"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}"
     #{"project" "sha1Fingerprint" "instance"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: instance, project
  
  Optional parameters: parent
  
  Lists all of the current SSL certificates for the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "instance"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/sslCerts"
     #{"project" "instance"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn createEphemeral$
  "Required parameters: instance, project
  
  Optional parameters: parent
  
  Generates a short-lived X509 certificate containing the provided public key
  and signed by a private key specific to the target instance. Users may use
  the certificate to authenticate as themselves when connecting to the
  database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "instance"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/createEphemeral"
     #{"project" "instance"}
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
