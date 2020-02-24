(ns happygapi.admob.accounts
  "AdMob API
  The Google AdMob API lets you programmatically get reports on earnings.
  
  See: https://developers.google.com/admob/api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: name
  
  Gets information about the specified AdMob publisher account."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
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
  
  Lists the AdMob publisher account accessible with the client credential.
  Currently, all credentials have access to at most one AdMob account."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
  
  Generates an AdMob Mediation report based on the provided report
  specification."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
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
  
  Generates an AdMob Network report based on the provided report
  specification."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
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
