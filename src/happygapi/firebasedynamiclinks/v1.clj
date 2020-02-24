(ns happygapi.firebasedynamiclinks.v1
  "Firebase Dynamic Links API
  Programmatically creates and manages Firebase Dynamic Links.
  See: https://firebase.google.com/docs/dynamic-links/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn $
  "Required parameters: dynamicLink
  
  Fetches analytics stats of a short Dynamic Link for a given
  duration. Metrics include number of clicks, redirects, installs,
  app first opens, and app reopens."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth args]
  {:pre [(util/has-keys? args #{"dynamicLink"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/{dynamicLink}/linkStats"
     #{"dynamicLink"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "Required parameters: none
  
  Get iOS strong/weak-match info for post-install attribution."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/installAttribution"
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

(defn $
  "Required parameters: none
  
  Get iOS reopen attribution for app universal link open deeplinking."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/reopenAttribution"
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
