(ns happygapi.firebasedynamiclinks.v1
  "Firebase Dynamic Links API: v1.
  Programmatically creates and manages Firebase Dynamic Links.
  See: https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/getLinkStats
  
  Required parameters: dynamicLink
  
  Optional parameters: durationDays, sdkVersion
  Fetches analytics stats of a short Dynamic Link for a given
  duration. Metrics include number of clicks, redirects, installs,
  app first opens, and app reopens."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth args]
  {:pre [(util/has-keys? args #{:dynamicLink})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/{dynamicLink}/linkStats"
     #{:dynamicLink}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/installAttribution
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:uniqueMatchLinkToCheck string,
   :appInstallationTime string,
   :iosVersion string,
   :visualStyle string,
   :retrievalMethod string,
   :sdkVersion string,
   :bundleId string,
   :device {:languageCodeRaw string,
            :screenResolutionWidth string,
            :timezone string,
            :screenResolutionHeight string,
            :languageCode string,
            :deviceModelName string,
            :languageCodeFromWebview string}}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/reopenAttribution
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:sdkVersion string, :bundleId string, :requestedLink string}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
