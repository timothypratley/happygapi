(ns happygapi.dns.changes
  "Google Cloud DNS API
  Configures and serves authoritative DNS records.
  See: https://developers.google.com/cloud-dns"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas (edn/read-string (slurp (io/resource "dns_schema.edn"))))

(defn create$
  "Required parameters: managedZone, project
  
  Optional parameters: clientOperationId
  
  Atomically update the ResourceRecordSet collection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "managedZone"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/changes"
     #{"project" "managedZone"}
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
  "Required parameters: changeId, managedZone, project
  
  Optional parameters: clientOperationId
  
  Fetch the representation of an existing Change."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "managedZone" "changeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/changes/{changeId}"
     #{"project" "managedZone" "changeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: managedZone, project
  
  Optional parameters: maxResults, pageToken, sortBy, sortOrder
  
  Enumerate Changes to a ResourceRecordSet collection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "managedZone"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/changes"
     #{"project" "managedZone"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
