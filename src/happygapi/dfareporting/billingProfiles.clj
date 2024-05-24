(ns happygapi.dfareporting.billingProfiles
  "Campaign Manager 360 API: billingProfiles.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/docs/reference/rest/v4/billingProfiles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/billingProfiles/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one billing profile by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/billingProfiles/{+id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/billingProfiles/list
  
  Required parameters: profileId
  
  Optional parameters: name, ids, pageToken, sortField, status, sortOrder, onlySuggestion, subaccountIds, maxResults, currency_code
  
  Retrieves a list of billing profiles, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/billingProfiles"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/billingProfiles/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:paymentsAccountId string,
   :secondaryPaymentsCustomerId string,
   :isDefault boolean,
   :consolidatedInvoice boolean,
   :purchaseOrder string,
   :name string,
   :paymentsCustomerId string,
   :invoiceLevel string,
   :status string,
   :id string,
   :kind string,
   :currencyCode string,
   :countryCode string}
  
  Updates an existing billing profile."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/billingProfiles"
     #{:profileId}
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
