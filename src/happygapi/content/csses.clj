(ns happygapi.content.csses
  "Content API for Shopping: csses.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/csses"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/csses/get
  
  Required parameters: cssGroupId, cssDomainId
  
  Optional parameters: none
  
  Retrieves a single CSS domain by ID."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:cssGroupId :cssDomainId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{cssGroupId}/csses/{cssDomainId}"
     #{:cssGroupId :cssDomainId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updatelabels$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/csses/updatelabels
  
  Required parameters: cssDomainId, cssGroupId
  
  Optional parameters: none
  
  Body: 
  
  {:labelIds [string]}
  
  Updates labels that are assigned to a CSS domain by its CSS group."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:cssGroupId :cssDomainId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{cssGroupId}/csses/{cssDomainId}/updatelabels"
     #{:cssGroupId :cssDomainId}
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

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/csses/list
  
  Required parameters: cssGroupId
  
  Optional parameters: pageToken, pageSize
  
  Lists CSS domains affiliated with a CSS group."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:cssGroupId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{cssGroupId}/csses"
     #{:cssGroupId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
