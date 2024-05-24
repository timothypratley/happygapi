(ns happygapi.adsensehost.accounts
  "AdSense Host API: accounts.
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/docs/reference/rest/v4.1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/get
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Get information about the selected associated AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/list
  
  Required parameters: filterAdClientId
  
  Optional parameters: none
  
  List hosted accounts associated with this AdSense account by ad client id."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterAdClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts"
     #{:filterAdClientId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-get$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/adclients/get
  
  Required parameters: accountId, adClientId
  
  Optional parameters: none
  
  Get information about one of the ad clients in the specified publisher's AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}"
     #{:adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-list$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/adclients/list
  
  Required parameters: accountId
  
  Optional parameters: maxResults, pageToken
  
  List all hosted ad clients in the specified hosted account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-delete$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/adunits/delete
  
  Required parameters: accountId, adClientId, adUnitId
  
  Optional parameters: none
  
  Delete the specified ad unit from the specified publisher AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:adUnitId :adClientId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}"
     #{:adUnitId :adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-get$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/adunits/get
  
  Required parameters: accountId, adClientId, adUnitId
  
  Optional parameters: none
  
  Get the specified host ad unit in this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:adUnitId :adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}"
     #{:adUnitId :adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-getAdCode$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/adunits/getAdCode
  
  Required parameters: accountId, adClientId, adUnitId
  
  Optional parameters: hostCustomChannelId
  
  Get ad code for the specified ad unit, attaching the specified host custom channels."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:adUnitId :adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}/adcode"
     #{:adUnitId :adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-insert$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/adunits/insert
  
  Required parameters: accountId, adClientId
  
  Optional parameters: none
  
  Body: 
  
  {:code string,
   :contentAdsSettings {:backupOption {:color string,
                                       :type string,
                                       :url string},
                        :size string,
                        :type string},
   :customStyle {:colors {:background string,
                          :border string,
                          :text string,
                          :title string,
                          :url string},
                 :corners string,
                 :font {:family string, :size string},
                 :kind string},
   :id string,
   :kind string,
   :mobileContentAdsSettings {:markupLanguage string,
                              :scriptingLanguage string,
                              :size string,
                              :type string},
   :name string,
   :status string}
  
  Insert the supplied ad unit into the specified publisher AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:adClientId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{:adClientId :accountId}
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

(defn adunits-list$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/adunits/list
  
  Required parameters: accountId, adClientId
  
  Optional parameters: includeInactive, maxResults, pageToken
  
  List all ad units in the specified publisher's AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{:adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-patch$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/adunits/patch
  
  Required parameters: accountId, adClientId, adUnitId
  
  Optional parameters: none
  
  Body: 
  
  {:code string,
   :contentAdsSettings {:backupOption {:color string,
                                       :type string,
                                       :url string},
                        :size string,
                        :type string},
   :customStyle {:colors {:background string,
                          :border string,
                          :text string,
                          :title string,
                          :url string},
                 :corners string,
                 :font {:family string, :size string},
                 :kind string},
   :id string,
   :kind string,
   :mobileContentAdsSettings {:markupLanguage string,
                              :scriptingLanguage string,
                              :size string,
                              :type string},
   :name string,
   :status string}
  
  Update the supplied ad unit in the specified publisher AdSense account. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:adUnitId :adClientId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{:adUnitId :adClientId :accountId}
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

(defn adunits-update$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/adunits/update
  
  Required parameters: accountId, adClientId
  
  Optional parameters: none
  
  Body: 
  
  {:code string,
   :contentAdsSettings {:backupOption {:color string,
                                       :type string,
                                       :url string},
                        :size string,
                        :type string},
   :customStyle {:colors {:background string,
                          :border string,
                          :text string,
                          :title string,
                          :url string},
                 :corners string,
                 :font {:family string, :size string},
                 :kind string},
   :id string,
   :kind string,
   :mobileContentAdsSettings {:markupLanguage string,
                              :scriptingLanguage string,
                              :size string,
                              :type string},
   :name string,
   :status string}
  
  Update the supplied ad unit in the specified publisher AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:adClientId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{:adClientId :accountId}
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

(defn reports-generate$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/accounts/reports/generate
  
  Required parameters: startDate, endDate, accountId
  
  Optional parameters: locale, filter, dimension, startIndex, metric, sort, maxResults
  
  Generate an AdSense report based on the report request sent in the query parameters. Returns the result as JSON; to retrieve output in CSV format specify \"alt=csv\" as a query parameter."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:startDate :endDate :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/reports"
     #{:startDate :endDate :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
