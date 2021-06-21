(ns happygapi.ideahub.platforms
  "Idea Hub API: platforms.
  
  See: https://console.cloud.google.com/apis/library/ideahub.googleapis.comapi/reference/rest/v1alpha/platforms"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn properties-ideas-list$
  "https://console.cloud.google.com/apis/library/ideahub.googleapis.comapi/reference/rest/v1alpha/platforms/properties/ideas/list
  
  Required parameters: parent
  
  Optional parameters: creator.platformId, filter, pageSize, pageToken, orderBy, creator.platform
  
  List ideas for a given Creator and filter and sort options."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ideahub.googleapis.com/"
     "v1alpha/{+parent}/ideas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn properties-ideaStates-patch$
  "https://console.cloud.google.com/apis/library/ideahub.googleapis.comapi/reference/rest/v1alpha/platforms/properties/ideaStates/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :saved boolean, :dismissed boolean}
  
  Update an idea state resource."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://ideahub.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
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

(defn properties-locales-list$
  "https://console.cloud.google.com/apis/library/ideahub.googleapis.comapi/reference/rest/v1alpha/platforms/properties/locales/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns which locales ideas are available in for a given Creator."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ideahub.googleapis.com/"
     "v1alpha/{+parent}/locales"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
