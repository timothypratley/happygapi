(ns happygapi.ideahub.ideas
  "Idea Hub API: ideas.
  
  See: https://console.cloud.google.com/apis/library/ideahub.googleapis.comapi/reference/rest/v1alpha/ideas"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://console.cloud.google.com/apis/library/ideahub.googleapis.comapi/reference/rest/v1alpha/ideas/list
  
  Required parameters: none
  
  Optional parameters: pageSize, creator.platformId, parent, filter, pageToken, orderBy, creator.platform
  
  List ideas for a given Creator and filter and sort options."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ideahub.googleapis.com/"
     "v1alpha/ideas"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
