(ns happygapi.firebasedynamiclinks.managedShortLinks
  "Firebase Dynamic Links API
  Programmatically creates and manages Firebase Dynamic Links.
  See: https://firebase.google.com/docs/dynamic-links/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn create$
  "Required parameters: none
  
  Creates a managed short Dynamic Link given either a valid long Dynamic Link
  or details such as Dynamic Link domain, Android and iOS app information.
  The created short Dynamic Link will not expire.
  
  This differs from CreateShortDynamicLink in the following ways:
    - The request will also contain a name for the link (non unique name
      for the front end).
    - The response must be authenticated with an auth token (generated with
      the admin service account).
    - The link will appear in the FDL list of links in the console front end.
  
  The Dynamic Link domain in the request must be owned by requester's
  Firebase project."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/managedShortLinks:create"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
