(ns happygapi.proximitybeacon.namespaces
  "Proximity Beacon API: namespaces.
  Registers, manages, indexes, and searches beacons.
  See: https://developers.google.com/beacons/proximity/api/reference/rest/v1beta1/namespaces"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/beacons/proximity/api/reference/rest/v1beta1/namespaces/list
  
  Required parameters: none
  
  Optional parameters: projectId
  
  Lists all attachment namespaces owned by your Google Developers Console
  project. Attachment data associated with a beacon must include a
  namespaced type, and the namespace must be owned by your project.
  
  Authenticate using an [OAuth access
  token](https://developers.google.com/identity/protocols/OAuth2) from a
  signed-in user with **viewer**, **Is owner** or **Can edit** permissions in
  the Google Developers Console project."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/namespaces"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/beacons/proximity/api/reference/rest/v1beta1/namespaces/update
  
  Required parameters: namespaceName
  
  Optional parameters: projectId
  
  Body: 
  
  {:namespaceName string, :servingVisibility string}
  
  Updates the information about the specified namespace. Only the namespace
  visibility can be updated."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:namespaceName})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/{+namespaceName}"
     #{:namespaceName}
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
