(ns happygapi.reseller.customers
  "Enterprise Apps Reseller API: customers.
  Creates and manages your customers and their subscriptions.
  See: https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/get
  
  Required parameters: customerId
  
  Optional parameters: none
  Get a customer account."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:customerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}"
     #{:customerId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/insert
  
  Required parameters: none
  
  Optional parameters: customerAuthToken
  
  Body: 
  
  {:alternateEmail string,
   :customerDomain string,
   :customerDomainVerified boolean,
   :customerId string,
   :kind string,
   :phoneNumber string,
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
   :resourceUiUrl string}
  
  Order a new customer's account."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers"
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

(defn patch$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/patch
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Body: 
  
  {:alternateEmail string,
   :customerDomain string,
   :customerDomainVerified boolean,
   :customerId string,
   :kind string,
   :phoneNumber string,
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
   :resourceUiUrl string}
  
  Update a customer account's settings. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:customerId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}"
     #{:customerId}
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

(defn update$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/update
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Body: 
  
  {:alternateEmail string,
   :customerDomain string,
   :customerDomainVerified boolean,
   :customerId string,
   :kind string,
   :phoneNumber string,
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
   :resourceUiUrl string}
  
  Update a customer account's settings."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:customerId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}"
     #{:customerId}
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
