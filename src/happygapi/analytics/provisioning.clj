(ns happygapi.analytics.provisioning
  "Google Analytics API: provisioning.
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/api/reference/rest/v3/provisioning"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn createAccountTree$
  "https://developers.google.com/analytics/api/reference/rest/v3/provisioning/createAccountTree
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:timezone string,
   :accountName string,
   :profileName string,
   :webpropertyName string,
   :websiteUrl string,
   :kind string}
  
  Provision account."
  {:scopes ["https://www.googleapis.com/auth/analytics.provision"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "provisioning/createAccountTree"
     #{}
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

(defn createAccountTicket$
  "https://developers.google.com/analytics/api/reference/rest/v3/provisioning/createAccountTicket
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:profile {:timezone string,
             :permissions {:effective [string]},
             :starred boolean,
             :websiteUrl string,
             :botFilteringEnabled boolean,
             :updated string,
             :name string,
             :defaultPage string,
             :selfLink string,
             :type string,
             :created string,
             :parentLink {:href string, :type string},
             :webPropertyId string,
             :stripSiteSearchCategoryParameters boolean,
             :siteSearchCategoryParameters string,
             :currency string,
             :enhancedECommerceTracking boolean,
             :id string,
             :kind string,
             :childLink {:href string, :type string},
             :internalWebPropertyId string,
             :stripSiteSearchQueryParameters boolean,
             :excludeQueryParameters string,
             :accountId string,
             :eCommerceTracking boolean,
             :siteSearchQueryParameters string},
   :account {:permissions {:effective [string]},
             :starred boolean,
             :updated string,
             :name string,
             :selfLink string,
             :created string,
             :id string,
             :kind string,
             :childLink {:href string, :type string}},
   :id string,
   :redirectUri string,
   :webproperty {:permissions {:effective [string]},
                 :defaultProfileId string,
                 :starred boolean,
                 :websiteUrl string,
                 :updated string,
                 :name string,
                 :industryVertical string,
                 :selfLink string,
                 :created string,
                 :parentLink {:type string, :href string},
                 :level string,
                 :id string,
                 :kind string,
                 :childLink {:type string, :href string},
                 :internalWebPropertyId string,
                 :dataRetentionTtl string,
                 :profileCount integer,
                 :dataRetentionResetOnNewActivity boolean,
                 :accountId string},
   :kind string}
  
  Creates an account ticket."
  {:scopes ["https://www.googleapis.com/auth/analytics.provision"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "provisioning/createAccountTicket"
     #{}
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
