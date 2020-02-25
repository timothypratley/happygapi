(ns happygapi.admob.accounts
  "AdMob API
  The Google AdMob API lets you programmatically get reports on earnings.
  
  See: https://developers.google.com/admob/api/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "admob_schema.edn"))))

(defn get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about the specified AdMob publisher account."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Lists the AdMob publisher account accessible with the client credential.
  Currently, all credentials have access to at most one AdMob account."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/accounts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn mediationReport-generate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Generates an AdMob Mediation report based on the provided report
  specification."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+parent}/mediationReport:generate"
     #{"parent"}
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

(defn networkReport-generate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Generates an AdMob Network report based on the provided report
  specification."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+parent}/networkReport:generate"
     #{"parent"}
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
