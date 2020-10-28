(ns happygapi.reseller.customers
  "Workspace Reseller API: customers.
  Creates and manages your customers and their subscriptions.
  See: https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/insert
  
  Required parameters: none
  
  Optional parameters: customerAuthToken
  
  Body: 
  
  {:kind string,
   :phoneNumber string,
   :customerDomainVerified boolean,
   :resourceUiUrl string,
   :customerId string,
   :alternateEmail string,
   :postalAddress {:locality string,
                   :contactName string,
                   :addressLine1 string,
                   :organizationName string,
                   :region string,
                   :addressLine3 string,
                   :addressLine2 string,
                   :kind string,
                   :postalCode string,
                   :countryCode string},
   :customerDomain string}
  
  Order a new customer's account."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers"
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

(defn get$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/get
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Get a customer account."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}"
     #{:customerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/update
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :phoneNumber string,
   :customerDomainVerified boolean,
   :resourceUiUrl string,
   :customerId string,
   :alternateEmail string,
   :postalAddress {:locality string,
                   :contactName string,
                   :addressLine1 string,
                   :organizationName string,
                   :region string,
                   :addressLine3 string,
                   :addressLine2 string,
                   :kind string,
                   :postalCode string,
                   :countryCode string},
   :customerDomain string}
  
  Update a customer account's settings."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customerId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}"
     #{:customerId}
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

(defn patch$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/patch
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :phoneNumber string,
   :customerDomainVerified boolean,
   :resourceUiUrl string,
   :customerId string,
   :alternateEmail string,
   :postalAddress {:locality string,
                   :contactName string,
                   :addressLine1 string,
                   :organizationName string,
                   :region string,
                   :addressLine3 string,
                   :addressLine2 string,
                   :kind string,
                   :postalCode string,
                   :countryCode string},
   :customerDomain string}
  
  Update a customer account's settings. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customerId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}"
     #{:customerId}
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
