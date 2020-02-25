(ns happygapi.firebasedynamiclinks.shortLinks
  "Firebase Dynamic Links API
  Programmatically creates and manages Firebase Dynamic Links.
  See: https://firebase.google.com/docs/dynamic-links/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "firebasedynamiclinks_schema.edn"))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates a short Dynamic Link given either a valid long Dynamic Link or
  details such as Dynamic Link domain, Android and iOS app information.
  The created short Dynamic Link will not expire.
  
  Repeated calls with the same long Dynamic Link or Dynamic Link information
  will produce the same short Dynamic Link.
  
  The Dynamic Link domain in the request must be owned by requester's
  Firebase project."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/shortLinks"
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
