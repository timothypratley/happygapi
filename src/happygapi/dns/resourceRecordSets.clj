(ns happygapi.dns.resourceRecordSets
  "Google Cloud DNS API: resourceRecordSets.
  Configures and serves authoritative DNS records.
  See: https://developers.google.com/cloud-dnsapi/reference/rest/v1/resourceRecordSets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/resourceRecordSets/list
  
  Required parameters: managedZone, project
  
  Optional parameters: maxResults, name, pageToken, type
  Enumerate ResourceRecordSets that have been created but not yet deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{:managedZone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/rrsets"
     #{:managedZone :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
