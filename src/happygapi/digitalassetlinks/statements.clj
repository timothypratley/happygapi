(ns happygapi.digitalassetlinks.statements
  "Digital Asset Links API
  Discovers relationships between online assets such as websites or mobile apps.
  See: https://developers.google.com/digital-asset-links/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "digitalassetlinks_schema.edn"))))

(defn list$
  "Required parameters: none
  
  Optional parameters: relation, source.web.site, source.androidApp.packageName, source.androidApp.certificate.sha256Fingerprint
  
  Retrieves a list of all statements from a given source that match the
  specified target and statement string.
  
  The API guarantees that all statements with secure source assets, such as
  HTTPS websites or Android apps, have been made in a secure way by the owner
  of those assets, as described in the [Digital Asset Links technical design
  specification](https://github.com/google/digitalassetlinks/blob/master/well-known/details.md).
  Specifically, you should consider that for insecure websites (that is,
  where the URL starts with `http://` instead of `https://`), this guarantee
  cannot be made.
  
  The `List` command is most useful in cases where the API client wants to
  know all the ways in which two assets are related, or enumerate all the
  relationships from a particular source asset.  Example: a feature that
  helps users navigate to related items.  When a mobile app is running on a
  device, the feature would make it easy to navigate to the corresponding web
  site or Google+ profile."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://digitalassetlinks.googleapis.com/"
     "v1/statements:list"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
