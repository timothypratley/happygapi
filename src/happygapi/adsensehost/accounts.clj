(ns happygapi.adsensehost.accounts
  "AdSense Host API
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: accountId
  
  Get information about the selected associated AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: filterAdClientId
  
  List hosted accounts associated with this AdSense account by ad client id."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterAdClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-get$
  "Required parameters: accountId,adClientId
  
  Get information about one of the ad clients in the specified publisher's AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}"
     #{"accountId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-list$
  "Required parameters: accountId
  
  List all hosted ad clients in the specified hosted account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-delete$
  "Required parameters: accountId,adClientId,adUnitId
  
  Delete the specified ad unit from the specified publisher AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adUnitId" "adClientId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}"
     #{"accountId" "adUnitId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-get$
  "Required parameters: accountId,adClientId,adUnitId
  
  Get the specified host ad unit in this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adUnitId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}"
     #{"accountId" "adUnitId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-getAdCode$
  "Required parameters: accountId,adClientId,adUnitId
  
  Get ad code for the specified ad unit, attaching the specified host custom channels."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adUnitId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}/adcode"
     #{"accountId" "adUnitId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-insert$
  "Required parameters: accountId,adClientId
  
  Insert the supplied ad unit into the specified publisher AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "adClientId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{"accountId" "adClientId"}
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

(defn adunits-list$
  "Required parameters: accountId,adClientId
  
  List all ad units in the specified publisher's AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{"accountId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-patch$
  "Required parameters: accountId,adClientId,adUnitId
  
  Update the supplied ad unit in the specified publisher AdSense account. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adUnitId" "adClientId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{"accountId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-update$
  "Required parameters: accountId,adClientId
  
  Update the supplied ad unit in the specified publisher AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adClientId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{"accountId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reports-generate$
  "Required parameters: startDate,endDate,accountId
  
  Generate an AdSense report based on the report request sent in the query parameters. Returns the result as JSON; to retrieve output in CSV format specify \"alt=csv\" as a query parameter."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"startDate" "accountId" "endDate"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "accounts/{accountId}/reports"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
