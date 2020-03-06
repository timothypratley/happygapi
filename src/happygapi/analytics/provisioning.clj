(ns happygapi.analytics.provisioning
  "Google Analytics API: provisioning.
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/api/reference/rest/v3/provisioning"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn createAccountTicket$
  "https://developers.google.com/analytics/api/reference/rest/v3/provisioning/createAccountTicket
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:account {:permissions {:effective [string]},
             :starred boolean,
             :updated string,
             :name string,
             :selfLink string,
             :created string,
             :id string,
             :kind string,
             :childLink {:href string, :type string}},
   :id string,
   :kind string,
   :profile {:timezone string,
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
                 :parentLink {:href string, :type string},
                 :level string,
                 :id string,
                 :kind string,
                 :childLink {:href string, :type string},
                 :internalWebPropertyId string,
                 :dataRetentionTtl string,
                 :profileCount integer,
                 :dataRetentionResetOnNewActivity boolean,
                 :accountId string}}
  
  Creates an account ticket."
  {:scopes ["https://www.googleapis.com/auth/analytics.provision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "provisioning/createAccountTicket"
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

(defn createAccountTree$
  "https://developers.google.com/analytics/api/reference/rest/v3/provisioning/createAccountTree
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:accountName string,
   :kind string,
   :profileName string,
   :timezone string,
   :webpropertyName string,
   :websiteUrl string}
  
  Provision account."
  {:scopes ["https://www.googleapis.com/auth/analytics.provision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "provisioning/createAccountTree"
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
