(ns happygapi.proximitybeacon.beacons
  "Proximity Beacon API
  Registers, manages, indexes, and searches beacons.
  See: https://developers.google.com/beacons/proximity/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "proximitybeacon_schema.edn"))))

(defn get$
  "Required parameters: beaconName
  
  Optional parameters: projectId
  
  Returns detailed information about the specified beacon.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **viewer**, **Is owner** or **Can edit** permissions in
  the Google Developers Console project.
  
  Requests may supply an Eddystone-EID beacon name in the form:
  `beacons/4!beaconId` where the `beaconId` is the base16 ephemeral ID
  broadcast by the beacon. The returned `Beacon` object will contain the
  beacon's stable Eddystone-UID. Clients not authorized to resolve the
  beacon's ephemeral Eddystone-EID broadcast will receive an error."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}"
     #{"beaconName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: beaconName
  
  Optional parameters: projectId
  
  Updates the information about the specified beacon. **Any field that you do
  not populate in the submitted beacon will be permanently erased**, so you
  should follow the \"read, modify, write\" pattern to avoid inadvertently
  destroying data.
  
  Changes to the beacon status via this method will be  silently ignored.
  To update beacon status, use the separate methods on this API for
  activation, deactivation, and decommissioning.
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **Is owner** or **Can edit** permissions in the Google
  Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}"
     #{"beaconName"}
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

(defn decommission$
  "Required parameters: beaconName
  
  Optional parameters: projectId
  
  Decommissions the specified beacon in the service. This beacon will no
  longer be returned from `beaconinfo.getforobserved`. This operation is
  permanent -- you will not be able to re-register a beacon with this ID
  again.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **Is owner** or **Can edit** permissions in the Google
  Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}:decommission"
     #{"beaconName"}
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

(defn delete$
  "Required parameters: beaconName
  
  Optional parameters: projectId
  
  Deletes the specified beacon including all diagnostics data for the beacon
  as well as any attachments on the beacon (including those belonging to
  other projects). This operation cannot be undone.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **Is owner** or **Can edit** permissions in the Google
  Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}"
     #{"beaconName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deactivate$
  "Required parameters: beaconName
  
  Optional parameters: projectId
  
  Deactivates a beacon. Once deactivated, the API will not return
  information nor attachment data for the beacon when queried via
  `beaconinfo.getforobserved`. Calling this method on an already inactive
  beacon will do nothing (but will return a successful response code).
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **Is owner** or **Can edit** permissions in the Google
  Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}:deactivate"
     #{"beaconName"}
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

(defn list$
  "Required parameters: none
  
  Optional parameters: pageToken, q, pageSize, projectId
  
  Searches the beacon registry for beacons that match the given search
  criteria. Only those beacons that the client has permission to list
  will be returned.
  
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
     "v1beta1/beacons"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn register$
  "Required parameters: none
  
  Optional parameters: projectId
  
  Registers a previously unregistered beacon given its `advertisedId`.
  These IDs are unique within the system. An ID can be registered only once.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **Is owner** or **Can edit** permissions in the Google
  Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/beacons:register"
     #{}
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

(defn activate$
  "Required parameters: beaconName
  
  Optional parameters: projectId
  
  Activates a beacon. A beacon that is active will return information
  and attachment data when queried via `beaconinfo.getforobserved`.
  Calling this method on an already active beacon will do nothing (but
  will return a successful response code).
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **Is owner** or **Can edit** permissions in the Google
  Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}:activate"
     #{"beaconName"}
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

(defn attachments-delete$
  "Required parameters: attachmentName
  
  Optional parameters: projectId
  
  Deletes the specified attachment for the given beacon. Each attachment has
  a unique attachment name (`attachmentName`) which is returned when you
  fetch the attachment data via this API. You specify this with the delete
  request to control which attachment is removed. This operation cannot be
  undone.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **Is owner** or **Can edit** permissions in the Google
  Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args]
  {:pre [(util/has-keys? args #{"attachmentName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+attachmentName}"
     #{"attachmentName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn attachments-list$
  "Required parameters: beaconName
  
  Optional parameters: namespacedType, projectId
  
  Returns the attachments for the specified beacon that match the specified
  namespaced-type pattern.
  
  To control which namespaced types are returned, you add the
  `namespacedType` query parameter to the request. You must either use
  `*/*`, to return all attachments, or the namespace must be one of
  the ones returned from the  `namespaces` endpoint.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **viewer**, **Is owner** or **Can edit** permissions in
  the Google Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}/attachments"
     #{"beaconName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn attachments-create$
  "Required parameters: beaconName
  
  Optional parameters: projectId
  
  Associates the given data with the specified beacon. Attachment data must
  contain two parts:
  <ul>
  <li>A namespaced type.</li>
  <li>The actual attachment data itself.</li>
  </ul>
  The namespaced type consists of two parts, the namespace and the type.
  The namespace must be one of the values returned by the `namespaces`
  endpoint, while the type can be a string of any characters except for the
  forward slash (`/`) up to 100 characters in length.
  
  Attachment data can be up to 1024 bytes long.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **Is owner** or **Can edit** permissions in the Google
  Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}/attachments"
     #{"beaconName"}
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

(defn attachments-batchDelete$
  "Required parameters: beaconName
  
  Optional parameters: projectId, namespacedType
  
  Deletes multiple attachments on a given beacon. This operation is
  permanent and cannot be undone.
  
  You can optionally specify `namespacedType` to choose which attachments
  should be deleted. If you do not specify `namespacedType`,  all your
  attachments on the given beacon will be deleted. You also may explicitly
  specify `*/*` to delete all.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **Is owner** or **Can edit** permissions in the Google
  Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}/attachments:batchDelete"
     #{"beaconName"}
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

(defn diagnostics-list$
  "Required parameters: beaconName
  
  Optional parameters: pageToken, pageSize, alertFilter, projectId
  
  List the diagnostics for a single beacon. You can also list diagnostics for
  all the beacons owned by your Google Developers Console project by using
  the beacon name `beacons/-`.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **viewer**, **Is owner** or **Can edit** permissions in
  the Google Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args]
  {:pre [(util/has-keys? args #{"beaconName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+beaconName}/diagnostics"
     #{"beaconName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
