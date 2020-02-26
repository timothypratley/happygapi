(ns happygapi.policytroubleshooter.iam
  "Policy Troubleshooter API
  
  See: https://cloud.google.com/iam/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "policytroubleshooter_schema.edn"))))

(defn troubleshoot$
  "Required parameters: none
  
  Optional parameters: none
  
  Checks whether a member has a specific permission for a specific resource,
  and explains why the member does or does not have that permission."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://policytroubleshooter.googleapis.com/"
     "v1/iam:troubleshoot"
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
