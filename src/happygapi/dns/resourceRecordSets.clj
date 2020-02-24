(ns happygapi.dns.resourceRecordSets
  "Google Cloud DNS API
  Configures and serves authoritative DNS records.
  See: https://developers.google.com/cloud-dns"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn list$
  "Required parameters: managedZone,project
  
  Enumerate ResourceRecordSets that have been created but not yet deleted."
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
     "{project}/managedZones/{managedZone}/rrsets"
     #{"project" "managedZone"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
