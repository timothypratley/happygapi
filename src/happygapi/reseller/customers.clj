(ns happygapi.reseller.customers
  "Google Workspace Reseller API: customers.
  Perform common functions that are available on the Channel Services console at scale, like placing orders and viewing customer information
  See: https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/get
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Gets a customer account. Use this operation to see a customer account already in your reseller management, or to see the minimal account information for an existing customer that you do not manage. For more information about the API response for existing customers, see [retrieving a customer account](/admin-sdk/reseller/v1/how-tos/manage_customers#get_customer)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}"
     #{:customerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/insert
  
  Required parameters: none
  
  Optional parameters: customerAuthToken
  
  Body: 
  
  {:alternateEmail string,
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
   :resourceUiUrl string,
   :customerType string,
   :customerId string,
   :primaryAdmin {:primaryEmail string},
   :customerDomain string,
   :kind string,
   :customerDomainVerified boolean,
   :phoneNumber string}
  
  Orders a new customer's account. Before ordering a new customer account, establish whether the customer account already exists using the [`customers.get`](/admin-sdk/reseller/v1/reference/customers/get) If the customer account exists as a direct Google account or as a resold customer account from another reseller, use the `customerAuthToken\\` as described in [order a resold account for an existing customer](/admin-sdk/reseller/v1/how-tos/manage_customers#create_existing_customer). For more information about ordering a new customer account, see [order a new customer account](/admin-sdk/reseller/v1/how-tos/manage_customers#create_customer). After creating a new customer account, you must provision a user as an administrator. The customer's administrator is required to sign in to the Admin console and sign the G Suite via Reseller agreement to activate the account. Resellers are prohibited from signing the G Suite via Reseller agreement on the customer's behalf. For more information, see [order a new customer account](/admin-sdk/reseller/v1/how-tos/manage_customers#tos)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers"
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

(defn patch$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/patch
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Body: 
  
  {:alternateEmail string,
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
   :resourceUiUrl string,
   :customerType string,
   :customerId string,
   :primaryAdmin {:primaryEmail string},
   :customerDomain string,
   :kind string,
   :customerDomainVerified boolean,
   :phoneNumber string}
  
  Updates a customer account's settings. This method supports patch semantics. You cannot update `customerType` via the Reseller API, but a `\"team\"` customer can verify their domain and become `customerType = \"domain\"`. For more information, see [Verify your domain to unlock Essentials features](https://support.google.com/a/answer/9122284)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customerId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}"
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

(defn update$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/customers/update
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Body: 
  
  {:alternateEmail string,
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
   :resourceUiUrl string,
   :customerType string,
   :customerId string,
   :primaryAdmin {:primaryEmail string},
   :customerDomain string,
   :kind string,
   :customerDomainVerified boolean,
   :phoneNumber string}
  
  Updates a customer account's settings. You cannot update `customerType` via the Reseller API, but a `\"team\"` customer can verify their domain and become `customerType = \"domain\"`. For more information, see [update a customer's settings](/admin-sdk/reseller/v1/how-tos/manage_customers#update_customer)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customerId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}"
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
