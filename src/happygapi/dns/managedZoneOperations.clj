(ns happygapi.dns.managedZoneOperations
  "Google Cloud DNS API
  Configures and serves authoritative DNS records.
  See: https://developers.google.com/cloud-dns"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: managedZone,operation,project
  
  Fetch the representation of an existing Operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "managedZone" "operation"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/operations/{operation}"
     #{"project" "managedZone" "operation"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: managedZone,project
  
  Enumerate Operations for the given ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "managedZone"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/operations"
     #{"project" "managedZone"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
