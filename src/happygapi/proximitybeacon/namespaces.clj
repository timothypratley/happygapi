(ns happygapi.proximitybeacon.namespaces
  "Proximity Beacon API
  Registers, manages, indexes, and searches beacons.
  See: https://developers.google.com/beacons/proximity/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "proximitybeacon_schema.edn"))))

(defn list$
  "Required parameters: none
  
  Optional parameters: projectId
  
  Lists all attachment namespaces owned by your Google Developers Console
  project. Attachment data associated with a beacon must include a
  namespaced type, and the namespace must be owned by your project.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **viewer**, **Is owner** or **Can edit** permissions in
  the Google Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/namespaces"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: namespaceName
  
  Optional parameters: projectId
  
  Updates the information about the specified namespace. Only the namespace
  visibility can be updated."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args]
  {:pre [(util/has-keys? args #{"namespaceName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+namespaceName}"
     #{"namespaceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
