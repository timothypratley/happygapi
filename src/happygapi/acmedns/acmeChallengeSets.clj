(ns happygapi.acmedns.acmeChallengeSets
  "ACME DNS API: acmeChallengeSets.
  Google Domains ACME DNS API that allows users to complete ACME DNS-01 challenges for a domain.
  See: https://developers.google.com/domains/acme-dns/api/reference/rest/v1/acmeChallengeSets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/domains/acme-dns/api/reference/rest/v1/acmeChallengeSets/get
  
  Required parameters: rootDomain
  
  Optional parameters: none
  
  Gets the ACME challenge set for a given domain name. Domain names must be provided in Punycode."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:rootDomain})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://acmedns.googleapis.com/"
     "v1/acmeChallengeSets/{rootDomain}"
     #{:rootDomain}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rotateChallenges$
  "https://developers.google.com/domains/acme-dns/api/reference/rest/v1/acmeChallengeSets/rotateChallenges
  
  Required parameters: rootDomain
  
  Optional parameters: none
  
  Body: 
  
  {:recordsToRemove [{:fqdn string, :updateTime string, :digest string}],
   :recordsToAdd [{:fqdn string, :updateTime string, :digest string}],
   :accessToken string,
   :keepExpiredRecords boolean}
  
  Rotate the ACME challenges for a given domain name. By default, removes any challenges that are older than 30 days. Domain names must be provided in Punycode."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:rootDomain})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://acmedns.googleapis.com/"
     "v1/acmeChallengeSets/{rootDomain}:rotateChallenges"
     #{:rootDomain}
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
