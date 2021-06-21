(ns happygapi.cloudchannel.accounts
  "Cloud Channel API: accounts.
  
  See: https://cloud.google.com/channelapi/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listTransferableOffers$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/listTransferableOffers
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:sku string,
   :languageCode string,
   :cloudIdentityId string,
   :pageSize integer,
   :customerName string,
   :pageToken string}
  
  List TransferableOffers of a customer based on Cloud Identity ID or Customer Name in the request. Use this method when a reseller gets the entitlement information of an unowned customer. The reseller should provide the customer's Cloud Identity ID or Customer Name. Possible error codes: * PERMISSION_DENIED: * The customer doesn't belong to the reseller and has no auth token. * The supplied auth token is invalid. * The reseller account making the request is different from the reseller account in the query. * INVALID_ARGUMENT: Required request parameters are missing or invalid. Return value: List of TransferableOffer for the given customer and SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}:listTransferableOffers"
     #{:parent}
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

(defn unregister$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/unregister
  
  Required parameters: account
  
  Optional parameters: none
  
  Body: 
  
  {:serviceAccount string}
  
  Unregisters a service account with subscriber privileges on the Cloud Pub/Sub topic created for this Channel Services account. If there are no service accounts left with subscriber privileges, this deletes the topic. You can call ListSubscribers to check for these accounts. Possible error codes: * PERMISSION_DENIED: The reseller account making the request and the provided reseller account are different, or the impersonated user is not a super admin. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: The topic resource doesn't exist. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The topic name that unregistered the service email address. Returns a success response if the service email address wasn't registered with the topic."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:account})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+account}:unregister"
     #{:account}
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

(defn register$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/register
  
  Required parameters: account
  
  Optional parameters: none
  
  Body: 
  
  {:serviceAccount string}
  
  Registers a service account with subscriber privileges on the Cloud Pub/Sub topic for this Channel Services account. After you create a subscriber, you get the events through SubscriberEvent Possible error codes: * PERMISSION_DENIED: The reseller account making the request and the provided reseller account are different, or the impersonated user is not a super admin. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The topic name with the registered service email address."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:account})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+account}:register"
     #{:account}
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

(defn listSubscribers$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/listSubscribers
  
  Required parameters: account
  
  Optional parameters: pageToken, pageSize
  
  Lists service accounts with subscriber privileges on the Cloud Pub/Sub topic created for this Channel Services account. Possible error codes: * PERMISSION_DENIED: The reseller account making the request and the provided reseller account are different, or the impersonated user is not a super admin. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: The topic resource doesn't exist. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: A list of service email addresses."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:account})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+account}:listSubscribers"
     #{:account}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listTransferableSkus$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/listTransferableSkus
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageSize integer,
   :pageToken string,
   :languageCode string,
   :authToken string,
   :customerName string,
   :cloudIdentityId string}
  
  List TransferableSkus of a customer based on the Cloud Identity ID or Customer Name in the request. Use this method to list the entitlements information of an unowned customer. You should provide the customer's Cloud Identity ID or Customer Name. Possible error codes: * PERMISSION_DENIED: * The customer doesn't belong to the reseller and has no auth token. * The supplied auth token is invalid. * The reseller account making the request is different from the reseller account in the query. * INVALID_ARGUMENT: Required request parameters are missing or invalid. Return value: A list of the customer's TransferableSku."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}:listTransferableSkus"
     #{:parent}
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

(defn checkCloudIdentityAccountsExist$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/checkCloudIdentityAccountsExist
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:domain string}
  
  Confirms the existence of Cloud Identity accounts based on the domain and if the Cloud Identity accounts are owned by the reseller. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * INVALID_VALUE: Invalid domain value in the request. Return value: A list of CloudIdentityCustomerAccount resources for the domain (may be empty) Note: in the v1alpha1 version of the API, a NOT_FOUND error returns if no CloudIdentityCustomerAccount resources match the domain."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}:checkCloudIdentityAccountsExist"
     #{:parent}
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

(defn customers-transferEntitlementsToGoogle$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/transferEntitlementsToGoogle
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :entitlements [{:purchaseOrderId string,
                   :provisioningState string,
                   :offer string,
                   :name string,
                   :commitmentSettings GoogleCloudChannelV1CommitmentSettings,
                   :createTime string,
                   :trialSettings GoogleCloudChannelV1TrialSettings,
                   :suspensionReasons [string],
                   :updateTime string,
                   :associationInfo GoogleCloudChannelV1AssociationInfo,
                   :parameters [GoogleCloudChannelV1Parameter],
                   :provisionedService GoogleCloudChannelV1ProvisionedService}]}
  
  Transfers customer entitlements from their current reseller to Google. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: The customer or offer resource was not found. * ALREADY_EXISTS: The SKU was already transferred for the customer. * CONDITION_NOT_MET or FAILED_PRECONDITION: * The SKU requires domain verification to transfer, but the domain is not verified. * An Add-On SKU (example, Vault or Drive) is missing the pre-requisite SKU (example, G Suite Basic). * (Developer accounts only) Reseller and resold domain must meet the following naming requirements: * Domain names must start with goog-test. * Domain names must include the reseller domain. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}:transferEntitlementsToGoogle"
     #{:parent}
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

(defn customers-transferEntitlements$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/transferEntitlements
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:entitlements [{:purchaseOrderId string,
                   :provisioningState string,
                   :offer string,
                   :name string,
                   :commitmentSettings GoogleCloudChannelV1CommitmentSettings,
                   :createTime string,
                   :trialSettings GoogleCloudChannelV1TrialSettings,
                   :suspensionReasons [string],
                   :updateTime string,
                   :associationInfo GoogleCloudChannelV1AssociationInfo,
                   :parameters [GoogleCloudChannelV1Parameter],
                   :provisionedService GoogleCloudChannelV1ProvisionedService}],
   :requestId string,
   :authToken string}
  
  Transfers customer entitlements to new reseller. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: The customer or offer resource was not found. * ALREADY_EXISTS: The SKU was already transferred for the customer. * CONDITION_NOT_MET or FAILED_PRECONDITION: * The SKU requires domain verification to transfer, but the domain is not verified. * An Add-On SKU (example, Vault or Drive) is missing the pre-requisite SKU (example, G Suite Basic). * (Developer accounts only) Reseller and resold domain must meet the following naming requirements: * Domain names must start with goog-test. * Domain names must include the reseller domain. * Specify all transferring entitlements. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}:transferEntitlements"
     #{:parent}
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

(defn customers-get$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the requested Customer resource. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: The customer resource doesn't exist. Usually the result of an invalid name parameter. Return value: The Customer resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customers-patch$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:alternateEmail string,
   :primaryContactInfo {:firstName string,
                        :title string,
                        :phone string,
                        :email string,
                        :displayName string,
                        :lastName string},
   :name string,
   :createTime string,
   :cloudIdentityId string,
   :orgPostalAddress {:sortingCode string,
                      :locality string,
                      :revision integer,
                      :administrativeArea string,
                      :addressLines [string],
                      :organization string,
                      :recipients [string],
                      :languageCode string,
                      :regionCode string,
                      :postalCode string,
                      :sublocality string},
   :updateTime string,
   :orgDisplayName string,
   :languageCode string,
   :domain string,
   :channelPartnerId string,
   :cloudIdentityInfo {:phoneNumber string,
                       :languageCode string,
                       :adminConsoleUri string,
                       :primaryDomain string,
                       :customerType string,
                       :alternateEmail string,
                       :isDomainVerified boolean,
                       :eduData GoogleCloudChannelV1EduData}}
  
  Updates an existing Customer resource for the reseller or distributor. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: No Customer resource found for the name in the request. Return value: The updated Customer resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn customers-create$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:alternateEmail string,
   :primaryContactInfo {:firstName string,
                        :title string,
                        :phone string,
                        :email string,
                        :displayName string,
                        :lastName string},
   :name string,
   :createTime string,
   :cloudIdentityId string,
   :orgPostalAddress {:sortingCode string,
                      :locality string,
                      :revision integer,
                      :administrativeArea string,
                      :addressLines [string],
                      :organization string,
                      :recipients [string],
                      :languageCode string,
                      :regionCode string,
                      :postalCode string,
                      :sublocality string},
   :updateTime string,
   :orgDisplayName string,
   :languageCode string,
   :domain string,
   :channelPartnerId string,
   :cloudIdentityInfo {:phoneNumber string,
                       :languageCode string,
                       :adminConsoleUri string,
                       :primaryDomain string,
                       :customerType string,
                       :alternateEmail string,
                       :isDomainVerified boolean,
                       :eduData GoogleCloudChannelV1EduData}}
  
  Creates a new Customer resource under the reseller or distributor account. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: * Required request parameters are missing or invalid. * Domain field value doesn't match the primary email domain. Return value: The newly created Customer resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/customers"
     #{:parent}
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

(defn customers-provisionCloudIdentity$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/provisionCloudIdentity
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:validateOnly boolean,
   :cloudIdentityInfo {:phoneNumber string,
                       :languageCode string,
                       :adminConsoleUri string,
                       :primaryDomain string,
                       :customerType string,
                       :alternateEmail string,
                       :isDomainVerified boolean,
                       :eduData GoogleCloudChannelV1EduData},
   :user {:familyName string, :email string, :givenName string}}
  
  Creates a Cloud Identity for the given customer using the customer's information, or the information provided here. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: The customer was not found. * ALREADY_EXISTS: The customer's primary email already exists. Retry after changing the customer's primary contact email. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The Operation metadata contains an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+customer}:provisionCloudIdentity"
     #{:customer}
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

(defn customers-delete$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the given Customer permanently. Possible error codes: * PERMISSION_DENIED: The account making the request does not own this customer. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * FAILED_PRECONDITION: The customer has existing entitlements. * NOT_FOUND: No Customer resource found for the name in the request."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customers-listPurchasableOffers$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/listPurchasableOffers
  
  Required parameters: customer
  
  Optional parameters: pageToken, pageSize, changeOfferPurchase.newSku, languageCode, changeOfferPurchase.entitlement, createEntitlementPurchase.sku
  
  Lists the following: * Offers that you can purchase for a customer. * Offers that you can change for an entitlement. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller * INVALID_ARGUMENT: Required request parameters are missing or invalid."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+customer}:listPurchasableOffers"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customers-list$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List Customers. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. Return value: List of Customers, or an empty list if there are no customers."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/customers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customers-listPurchasableSkus$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/listPurchasableSkus
  
  Required parameters: customer
  
  Optional parameters: changeOfferPurchase.entitlement, pageToken, changeOfferPurchase.changeType, languageCode, pageSize, createEntitlementPurchase.product
  
  Lists the following: * SKUs that you can purchase for a customer * SKUs that you can upgrade or downgrade for an entitlement. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+customer}:listPurchasableSkus"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customers-entitlements-changeParameters$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/changeParameters
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:purchaseOrderId string,
   :requestId string,
   :parameters [{:name string,
                 :editable boolean,
                 :value GoogleCloudChannelV1Value}]}
  
  Change parameters of the entitlement. An entitlement update is a long-running operation and it updates the entitlement as a result of fulfillment. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. For example, the number of seats being changed is greater than the allowed number of max seats, or decreasing seats for a commitment based plan. * NOT_FOUND: Entitlement resource not found. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}:changeParameters"
     #{:name}
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

(defn customers-entitlements-changeOffer$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/changeOffer
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:parameters [{:name string,
                 :editable boolean,
                 :value GoogleCloudChannelV1Value}],
   :purchaseOrderId string,
   :offer string,
   :requestId string}
  
  Updates the Offer for an existing customer entitlement. An entitlement update is a long-running operation and it updates the entitlement as a result of fulfillment. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: Offer or Entitlement resource not found. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}:changeOffer"
     #{:name}
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

(defn customers-entitlements-get$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the requested Entitlement resource. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: The customer entitlement was not found. Return value: The requested Entitlement resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customers-entitlements-create$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:entitlement {:purchaseOrderId string,
                 :provisioningState string,
                 :offer string,
                 :name string,
                 :commitmentSettings GoogleCloudChannelV1CommitmentSettings,
                 :createTime string,
                 :trialSettings GoogleCloudChannelV1TrialSettings,
                 :suspensionReasons [string],
                 :updateTime string,
                 :associationInfo GoogleCloudChannelV1AssociationInfo,
                 :parameters [GoogleCloudChannelV1Parameter],
                 :provisionedService GoogleCloudChannelV1ProvisionedService},
   :requestId string}
  
  Creates an entitlement for a customer. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: * Required request parameters are missing or invalid. * There is already a customer entitlement for a SKU from the same product family. * INVALID_VALUE: Make sure the OfferId is valid. If it is, contact Google Channel support for further troubleshooting. * NOT_FOUND: The customer or offer resource was not found. * ALREADY_EXISTS: * The SKU was already purchased for the customer. * The customer's primary email already exists. Retry after changing the customer's primary contact email. * CONDITION_NOT_MET or FAILED_PRECONDITION: * The domain required for purchasing a SKU has not been verified. * A pre-requisite SKU required to purchase an Add-On SKU is missing. For example, Google Workspace Business Starter is required to purchase Vault or Drive. * (Developer accounts only) Reseller and resold domain must meet the following naming requirements: * Domain names must start with goog-test. * Domain names must include the reseller domain. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/entitlements"
     #{:parent}
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

(defn customers-entitlements-changeRenewalSettings$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/changeRenewalSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :renewalSettings {:resizeUnitCount boolean,
                     :enableRenewal boolean,
                     :paymentCycle GoogleCloudChannelV1Period,
                     :paymentPlan string}}
  
  Updates the renewal settings for an existing customer entitlement. An entitlement update is a long-running operation and it updates the entitlement as a result of fulfillment. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: Entitlement resource not found. * NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a commitment plan. Can't enable or disable renewals for non-commitment plans. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}:changeRenewalSettings"
     #{:name}
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

(defn customers-entitlements-lookupOffer$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/lookupOffer
  
  Required parameters: entitlement
  
  Optional parameters: none
  
  Returns the requested Offer resource. Possible error codes: * PERMISSION_DENIED: The entitlement doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: Entitlement or offer was not found. Return value: The Offer resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:entitlement})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+entitlement}:lookupOffer"
     #{:entitlement}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customers-entitlements-suspend$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/suspend
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Suspends a previously fulfilled entitlement. An entitlement suspension is a long-running operation. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: Entitlement resource not found. * NOT_ACTIVE: Entitlement is not active. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}:suspend"
     #{:name}
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

(defn customers-entitlements-list$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists Entitlements belonging to a customer. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. Return value: A list of the customer's Entitlements."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/entitlements"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customers-entitlements-cancel$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Cancels a previously fulfilled entitlement. An entitlement cancellation is a long-running operation. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * FAILED_PRECONDITION: There are Google Cloud projects linked to the Google Cloud entitlement's Cloud Billing subaccount. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: Entitlement resource not found. * DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace add-ons, or entitlements for Google Cloud's development platform. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
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

(defn customers-entitlements-activate$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Activates a previously suspended entitlement. Entitlements suspended for pending ToS acceptance can't be activated using this method. An entitlement activation is a long-running operation and it updates the state of the customer entitlement. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: Entitlement resource not found. * SUSPENSION_NOT_RESELLER_INITIATED: Can only activate reseller-initiated suspensions and entitlements that have accepted the TOS. * NOT_SUSPENDED: Can only activate suspended entitlements not in an ACTIVE state. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}:activate"
     #{:name}
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

(defn customers-entitlements-startPaidService$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/customers/entitlements/startPaidService
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Starts paid service for a trial entitlement. Starts paid service for a trial entitlement immediately. This method is only applicable if a plan is set up for a trial entitlement but has some trial days remaining. Possible error codes: * PERMISSION_DENIED: The customer doesn't belong to the reseller. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: Entitlement resource not found. * FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for entitlement on trial plans. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The ID of a long-running operation. To get the results of the operation, call the GetOperation method of CloudChannelOperationsService. The Operation metadata will contain an instance of OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}:startPaidService"
     #{:name}
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

(defn channelPartnerLinks-create$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/channelPartnerLinks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:resellerCloudIdentityId string,
   :linkState string,
   :updateTime string,
   :channelPartnerCloudIdentityInfo {:phoneNumber string,
                                     :languageCode string,
                                     :adminConsoleUri string,
                                     :primaryDomain string,
                                     :customerType string,
                                     :alternateEmail string,
                                     :isDomainVerified boolean,
                                     :eduData GoogleCloudChannelV1EduData},
   :name string,
   :createTime string,
   :publicId string,
   :inviteLinkUri string}
  
  Initiates a channel partner link between a distributor and a reseller, or between resellers in an n-tier reseller channel. Invited partners need to follow the invite_link_uri provided in the response to accept. After accepting the invitation, a link is set up between the two parties. You must be a distributor to call this method. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * ALREADY_EXISTS: The ChannelPartnerLink sent in the request already exists. * NOT_FOUND: No Cloud Identity customer exists for provided domain. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The new ChannelPartnerLink resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/channelPartnerLinks"
     #{:parent}
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

(defn channelPartnerLinks-get$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/channelPartnerLinks/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Returns the requested ChannelPartnerLink resource. You must be a distributor to call this method. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: ChannelPartnerLink resource not found because of an invalid channel partner link name. Return value: The ChannelPartnerLink resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channelPartnerLinks-list$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/channelPartnerLinks/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, view
  
  List ChannelPartnerLinks belonging to a distributor. You must be a distributor to call this method. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. Return value: The list of the distributor account's ChannelPartnerLink resources."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/channelPartnerLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channelPartnerLinks-patch$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/channelPartnerLinks/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:channelPartnerLink {:resellerCloudIdentityId string,
                        :linkState string,
                        :updateTime string,
                        :channelPartnerCloudIdentityInfo GoogleCloudChannelV1CloudIdentityInfo,
                        :name string,
                        :createTime string,
                        :publicId string,
                        :inviteLinkUri string},
   :updateMask string}
  
  Updates a channel partner link. Distributors call this method to change a link's status. For example, to suspend a partner link. You must be a distributor to call this method. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: * Required request parameters are missing or invalid. * Link state cannot change from invited to active or suspended. * Cannot send reseller_cloud_identity_id, invite_url, or name in update mask. * NOT_FOUND: ChannelPartnerLink resource not found. * INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. * UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud Channel support. Return value: The updated ChannelPartnerLink resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn channelPartnerLinks-customers-get$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/channelPartnerLinks/customers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the requested Customer resource. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: The customer resource doesn't exist. Usually the result of an invalid name parameter. Return value: The Customer resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channelPartnerLinks-customers-list$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/channelPartnerLinks/customers/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List Customers. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. Return value: List of Customers, or an empty list if there are no customers."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/customers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channelPartnerLinks-customers-patch$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/channelPartnerLinks/customers/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:alternateEmail string,
   :primaryContactInfo {:firstName string,
                        :title string,
                        :phone string,
                        :email string,
                        :displayName string,
                        :lastName string},
   :name string,
   :createTime string,
   :cloudIdentityId string,
   :orgPostalAddress {:sortingCode string,
                      :locality string,
                      :revision integer,
                      :administrativeArea string,
                      :addressLines [string],
                      :organization string,
                      :recipients [string],
                      :languageCode string,
                      :regionCode string,
                      :postalCode string,
                      :sublocality string},
   :updateTime string,
   :orgDisplayName string,
   :languageCode string,
   :domain string,
   :channelPartnerId string,
   :cloudIdentityInfo {:phoneNumber string,
                       :languageCode string,
                       :adminConsoleUri string,
                       :primaryDomain string,
                       :customerType string,
                       :alternateEmail string,
                       :isDomainVerified boolean,
                       :eduData GoogleCloudChannelV1EduData}}
  
  Updates an existing Customer resource for the reseller or distributor. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * NOT_FOUND: No Customer resource found for the name in the request. Return value: The updated Customer resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn channelPartnerLinks-customers-create$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/channelPartnerLinks/customers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:alternateEmail string,
   :primaryContactInfo {:firstName string,
                        :title string,
                        :phone string,
                        :email string,
                        :displayName string,
                        :lastName string},
   :name string,
   :createTime string,
   :cloudIdentityId string,
   :orgPostalAddress {:sortingCode string,
                      :locality string,
                      :revision integer,
                      :administrativeArea string,
                      :addressLines [string],
                      :organization string,
                      :recipients [string],
                      :languageCode string,
                      :regionCode string,
                      :postalCode string,
                      :sublocality string},
   :updateTime string,
   :orgDisplayName string,
   :languageCode string,
   :domain string,
   :channelPartnerId string,
   :cloudIdentityInfo {:phoneNumber string,
                       :languageCode string,
                       :adminConsoleUri string,
                       :primaryDomain string,
                       :customerType string,
                       :alternateEmail string,
                       :isDomainVerified boolean,
                       :eduData GoogleCloudChannelV1EduData}}
  
  Creates a new Customer resource under the reseller or distributor account. Possible error codes: * PERMISSION_DENIED: The reseller account making the request is different from the reseller account in the API request. * INVALID_ARGUMENT: * Required request parameters are missing or invalid. * Domain field value doesn't match the primary email domain. Return value: The newly created Customer resource."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/customers"
     #{:parent}
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

(defn channelPartnerLinks-customers-delete$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/channelPartnerLinks/customers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the given Customer permanently. Possible error codes: * PERMISSION_DENIED: The account making the request does not own this customer. * INVALID_ARGUMENT: Required request parameters are missing or invalid. * FAILED_PRECONDITION: The customer has existing entitlements. * NOT_FOUND: No Customer resource found for the name in the request."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn offers-list$
  "https://cloud.google.com/channelapi/reference/rest/v1/accounts/offers/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize, languageCode
  
  Lists the Offers the reseller can sell. Possible error codes: * INVALID_ARGUMENT: Required request parameters are missing or invalid."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/offers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
