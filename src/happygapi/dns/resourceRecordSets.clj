(ns happygapi.dns.resourceRecordSets
  "Cloud DNS API: resourceRecordSets.
  
  See: https://cloud.google.com/dns/docsapi/reference/rest/v1/resourceRecordSets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/resourceRecordSets/list
  
  Required parameters: managedZone, project
  
  Optional parameters: name, maxResults, pageToken, type
  
  Enumerates ResourceRecordSets that you have created but not yet deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:managedZone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}/rrsets"
     #{:managedZone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
