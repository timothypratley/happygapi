(ns happygapi.people.people
  "People API: people.
  Provides access to information about profiles and contacts.
  See: https://developers.google.com/people/api/reference/rest/v1/people"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn createContact$
  "https://developers.google.com/people/api/reference/rest/v1/people/createContact
  
  Required parameters: none
  
  Optional parameters: personFields, sources
  
  Body: 
  
  {:addresses [{:formattedType string,
                :poBox string,
                :city string,
                :type string,
                :streetAddress string,
                :region string,
                :formattedValue string,
                :postalCode string,
                :extendedAddress string,
                :country string,
                :metadata FieldMetadata,
                :countryCode string}],
   :urls [{:metadata FieldMetadata,
           :value string,
           :type string,
           :formattedType string}],
   :relationshipStatuses [{:metadata FieldMetadata,
                           :value string,
                           :formattedValue string}],
   :coverPhotos [{:metadata FieldMetadata,
                  :url string,
                  :default boolean}],
   :birthdays [{:metadata FieldMetadata, :date Date, :text string}],
   :relations [{:metadata FieldMetadata,
                :person string,
                :type string,
                :formattedType string}],
   :ageRange string,
   :events [{:metadata FieldMetadata,
             :date Date,
             :type string,
             :formattedType string}],
   :phoneNumbers [{:metadata FieldMetadata,
                   :value string,
                   :canonicalForm string,
                   :type string,
                   :formattedType string}],
   :etag string,
   :fileAses [{:metadata FieldMetadata, :value string}],
   :biographies [{:metadata FieldMetadata,
                  :value string,
                  :contentType string}],
   :emailAddresses [{:metadata FieldMetadata,
                     :value string,
                     :type string,
                     :formattedType string,
                     :displayName string}],
   :miscKeywords [{:metadata FieldMetadata,
                   :value string,
                   :type string,
                   :formattedType string}],
   :organizations [{:department string,
                    :formattedType string,
                    :symbol string,
                    :name string,
                    :startDate Date,
                    :type string,
                    :fullTimeEquivalentMillipercent integer,
                    :phoneticName string,
                    :costCenter string,
                    :title string,
                    :endDate Date,
                    :jobDescription string,
                    :current boolean,
                    :domain string,
                    :location string,
                    :metadata FieldMetadata}],
   :sipAddresses [{:metadata FieldMetadata,
                   :value string,
                   :type string,
                   :formattedType string}],
   :braggingRights [{:metadata FieldMetadata, :value string}],
   :resourceName string,
   :locations [{:metadata FieldMetadata,
                :value string,
                :type string,
                :current boolean,
                :buildingId string,
                :floor string,
                :floorSection string,
                :deskCode string}],
   :externalIds [{:metadata FieldMetadata,
                  :value string,
                  :type string,
                  :formattedType string}],
   :relationshipInterests [{:metadata FieldMetadata,
                            :value string,
                            :formattedValue string}],
   :photos [{:metadata FieldMetadata, :url string, :default boolean}],
   :skills [{:metadata FieldMetadata, :value string}],
   :locales [{:metadata FieldMetadata, :value string}],
   :ageRanges [{:metadata FieldMetadata, :ageRange string}],
   :memberships [{:metadata FieldMetadata,
                  :contactGroupMembership ContactGroupMembership,
                  :domainMembership DomainMembership}],
   :clientData [{:metadata FieldMetadata, :key string, :value string}],
   :interests [{:metadata FieldMetadata, :value string}],
   :nicknames [{:metadata FieldMetadata, :value string, :type string}],
   :residences [{:metadata FieldMetadata,
                 :value string,
                 :current boolean}],
   :imClients [{:metadata FieldMetadata,
                :username string,
                :type string,
                :formattedType string,
                :protocol string,
                :formattedProtocol string}],
   :genders [{:metadata FieldMetadata,
              :value string,
              :formattedValue string,
              :addressMeAs string}],
   :calendarUrls [{:metadata FieldMetadata,
                   :url string,
                   :type string,
                   :formattedType string}],
   :taglines [{:metadata FieldMetadata, :value string}],
   :occupations [{:metadata FieldMetadata, :value string}],
   :metadata {:sources [Source],
              :previousResourceNames [string],
              :linkedPeopleResourceNames [string],
              :deleted boolean,
              :objectType string},
   :names [{:middleName string,
            :phoneticHonorificPrefix string,
            :phoneticHonorificSuffix string,
            :displayNameLastFirst string,
            :displayName string,
            :phoneticGivenName string,
            :honorificPrefix string,
            :phoneticFullName string,
            :phoneticFamilyName string,
            :familyName string,
            :phoneticMiddleName string,
            :unstructuredName string,
            :givenName string,
            :honorificSuffix string,
            :metadata FieldMetadata}],
   :userDefined [{:metadata FieldMetadata, :key string, :value string}]}
  
  Create a new contact and return the person resource for that contact. The request returns a 400 error if more than one field is specified on a field that is a singleton for contact sources: * biographies * birthdays * genders * names Mutate requests for the same user should be sent sequentially to avoid increased latency and failures."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:createContact"
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

(defn searchContacts$
  "https://developers.google.com/people/api/reference/rest/v1/people/searchContacts
  
  Required parameters: none
  
  Optional parameters: query, pageSize, readMask, sources
  
  Provides a list of contacts in the authenticated user's grouped contacts that matches the search query. The query matches on a contact's `names`, `nickNames`, `emailAddresses`, `phoneNumbers`, and `organizations` fields that are from the CONTACT source. **IMPORTANT**: Before searching, clients should send a warmup request with an empty query to update the cache. See https://developers.google.com/people/v1/contacts#search_the_users_contacts"
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:searchContacts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/people/api/reference/rest/v1/people/get
  
  Required parameters: resourceName
  
  Optional parameters: requestMask.includeField, personFields, sources
  
  Provides information about a person by specifying a resource name. Use `people/me` to indicate the authenticated user. The request returns a 400 error if 'personFields' is not specified."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.other.readonly"
            "https://www.googleapis.com/auth/contacts.readonly"
            "https://www.googleapis.com/auth/directory.readonly"
            "https://www.googleapis.com/auth/user.addresses.read"
            "https://www.googleapis.com/auth/user.birthday.read"
            "https://www.googleapis.com/auth/user.emails.read"
            "https://www.googleapis.com/auth/user.gender.read"
            "https://www.googleapis.com/auth/user.organization.read"
            "https://www.googleapis.com/auth/user.phonenumbers.read"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}"
     #{:resourceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn searchDirectoryPeople$
  "https://developers.google.com/people/api/reference/rest/v1/people/searchDirectoryPeople
  
  Required parameters: none
  
  Optional parameters: query, readMask, sources, mergeSources, pageSize, pageToken
  
  Provides a list of domain profiles and domain contacts in the authenticated user's domain directory that match the search query."
  {:scopes ["https://www.googleapis.com/auth/directory.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:searchDirectoryPeople"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deleteContact$
  "https://developers.google.com/people/api/reference/rest/v1/people/deleteContact
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Delete a contact person. Any non-contact data will not be deleted. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:deleteContact"
     #{:resourceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateContact$
  "https://developers.google.com/people/api/reference/rest/v1/people/updateContact
  
  Required parameters: resourceName
  
  Optional parameters: updatePersonFields, personFields, sources
  
  Body: 
  
  {:addresses [{:formattedType string,
                :poBox string,
                :city string,
                :type string,
                :streetAddress string,
                :region string,
                :formattedValue string,
                :postalCode string,
                :extendedAddress string,
                :country string,
                :metadata FieldMetadata,
                :countryCode string}],
   :urls [{:metadata FieldMetadata,
           :value string,
           :type string,
           :formattedType string}],
   :relationshipStatuses [{:metadata FieldMetadata,
                           :value string,
                           :formattedValue string}],
   :coverPhotos [{:metadata FieldMetadata,
                  :url string,
                  :default boolean}],
   :birthdays [{:metadata FieldMetadata, :date Date, :text string}],
   :relations [{:metadata FieldMetadata,
                :person string,
                :type string,
                :formattedType string}],
   :ageRange string,
   :events [{:metadata FieldMetadata,
             :date Date,
             :type string,
             :formattedType string}],
   :phoneNumbers [{:metadata FieldMetadata,
                   :value string,
                   :canonicalForm string,
                   :type string,
                   :formattedType string}],
   :etag string,
   :fileAses [{:metadata FieldMetadata, :value string}],
   :biographies [{:metadata FieldMetadata,
                  :value string,
                  :contentType string}],
   :emailAddresses [{:metadata FieldMetadata,
                     :value string,
                     :type string,
                     :formattedType string,
                     :displayName string}],
   :miscKeywords [{:metadata FieldMetadata,
                   :value string,
                   :type string,
                   :formattedType string}],
   :organizations [{:department string,
                    :formattedType string,
                    :symbol string,
                    :name string,
                    :startDate Date,
                    :type string,
                    :fullTimeEquivalentMillipercent integer,
                    :phoneticName string,
                    :costCenter string,
                    :title string,
                    :endDate Date,
                    :jobDescription string,
                    :current boolean,
                    :domain string,
                    :location string,
                    :metadata FieldMetadata}],
   :sipAddresses [{:metadata FieldMetadata,
                   :value string,
                   :type string,
                   :formattedType string}],
   :braggingRights [{:metadata FieldMetadata, :value string}],
   :resourceName string,
   :locations [{:metadata FieldMetadata,
                :value string,
                :type string,
                :current boolean,
                :buildingId string,
                :floor string,
                :floorSection string,
                :deskCode string}],
   :externalIds [{:metadata FieldMetadata,
                  :value string,
                  :type string,
                  :formattedType string}],
   :relationshipInterests [{:metadata FieldMetadata,
                            :value string,
                            :formattedValue string}],
   :photos [{:metadata FieldMetadata, :url string, :default boolean}],
   :skills [{:metadata FieldMetadata, :value string}],
   :locales [{:metadata FieldMetadata, :value string}],
   :ageRanges [{:metadata FieldMetadata, :ageRange string}],
   :memberships [{:metadata FieldMetadata,
                  :contactGroupMembership ContactGroupMembership,
                  :domainMembership DomainMembership}],
   :clientData [{:metadata FieldMetadata, :key string, :value string}],
   :interests [{:metadata FieldMetadata, :value string}],
   :nicknames [{:metadata FieldMetadata, :value string, :type string}],
   :residences [{:metadata FieldMetadata,
                 :value string,
                 :current boolean}],
   :imClients [{:metadata FieldMetadata,
                :username string,
                :type string,
                :formattedType string,
                :protocol string,
                :formattedProtocol string}],
   :genders [{:metadata FieldMetadata,
              :value string,
              :formattedValue string,
              :addressMeAs string}],
   :calendarUrls [{:metadata FieldMetadata,
                   :url string,
                   :type string,
                   :formattedType string}],
   :taglines [{:metadata FieldMetadata, :value string}],
   :occupations [{:metadata FieldMetadata, :value string}],
   :metadata {:sources [Source],
              :previousResourceNames [string],
              :linkedPeopleResourceNames [string],
              :deleted boolean,
              :objectType string},
   :names [{:middleName string,
            :phoneticHonorificPrefix string,
            :phoneticHonorificSuffix string,
            :displayNameLastFirst string,
            :displayName string,
            :phoneticGivenName string,
            :honorificPrefix string,
            :phoneticFullName string,
            :phoneticFamilyName string,
            :familyName string,
            :phoneticMiddleName string,
            :unstructuredName string,
            :givenName string,
            :honorificSuffix string,
            :metadata FieldMetadata}],
   :userDefined [{:metadata FieldMetadata, :key string, :value string}]}
  
  Update contact data for an existing contact person. Any non-contact data will not be modified. Any non-contact data in the person to update will be ignored. All fields specified in the `update_mask` will be replaced. The server returns a 400 error if `person.metadata.sources` is not specified for the contact to be updated or if there is no contact source. The server returns a 400 error with reason `\"failedPrecondition\"` if `person.metadata.sources.etag` is different than the contact's etag, which indicates the contact has changed since its data was read. Clients should get the latest person and merge their updates into the latest person. The server returns a 400 error if `memberships` are being updated and there are no contact group memberships specified on the person. The server returns a 400 error if more than one field is specified on a field that is a singleton for contact sources: * biographies * birthdays * genders * names Mutate requests for the same user should be sent sequentially to avoid increased latency and failures."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:updateContact"
     #{:resourceName}
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

(defn updateContactPhoto$
  "https://developers.google.com/people/api/reference/rest/v1/people/updateContactPhoto
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Body: 
  
  {:photoBytes string, :personFields string, :sources [string]}
  
  Update a contact's photo. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:updateContactPhoto"
     #{:resourceName}
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

(defn deleteContactPhoto$
  "https://developers.google.com/people/api/reference/rest/v1/people/deleteContactPhoto
  
  Required parameters: resourceName
  
  Optional parameters: personFields, sources
  
  Delete a contact's photo. Mutate requests for the same user should be done sequentially to avoid // lock contention."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:deleteContactPhoto"
     #{:resourceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn batchDeleteContacts$
  "https://developers.google.com/people/api/reference/rest/v1/people/batchDeleteContacts
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:resourceNames [string]}
  
  Delete a batch of contacts. Any non-contact data will not be deleted. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:batchDeleteContacts"
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

(defn batchUpdateContacts$
  "https://developers.google.com/people/api/reference/rest/v1/people/batchUpdateContacts
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:contacts {},
   :updateMask string,
   :readMask string,
   :sources [string]}
  
  Update a batch of contacts and return a map of resource names to PersonResponses for the updated contacts. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:batchUpdateContacts"
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

(defn listDirectoryPeople$
  "https://developers.google.com/people/api/reference/rest/v1/people/listDirectoryPeople
  
  Required parameters: none
  
  Optional parameters: readMask, sources, mergeSources, pageSize, pageToken, requestSyncToken, syncToken
  
  Provides a list of domain profiles and domain contacts in the authenticated user's domain directory. When the `sync_token` is specified, resources deleted since the last sync will be returned as a person with `PersonMetadata.deleted` set to true. When the `page_token` or `sync_token` is specified, all other request parameters must match the first call. Writes may have a propagation delay of several minutes for sync requests. Incremental syncs are not intended for read-after-write use cases. See example usage at [List the directory people that have changed](/people/v1/directory#list_the_directory_people_that_have_changed)."
  {:scopes ["https://www.googleapis.com/auth/directory.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:listDirectoryPeople"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getBatchGet$
  "https://developers.google.com/people/api/reference/rest/v1/people/getBatchGet
  
  Required parameters: none
  
  Optional parameters: resourceNames, requestMask.includeField, personFields, sources
  
  Provides information about a list of specific people by specifying a list of requested resource names. Use `people/me` to indicate the authenticated user. The request returns a 400 error if 'personFields' is not specified."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.other.readonly"
            "https://www.googleapis.com/auth/contacts.readonly"
            "https://www.googleapis.com/auth/directory.readonly"
            "https://www.googleapis.com/auth/user.addresses.read"
            "https://www.googleapis.com/auth/user.birthday.read"
            "https://www.googleapis.com/auth/user.emails.read"
            "https://www.googleapis.com/auth/user.gender.read"
            "https://www.googleapis.com/auth/user.organization.read"
            "https://www.googleapis.com/auth/user.phonenumbers.read"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:batchGet"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn batchCreateContacts$
  "https://developers.google.com/people/api/reference/rest/v1/people/batchCreateContacts
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:contacts [{:contactPerson Person}],
   :readMask string,
   :sources [string]}
  
  Create a batch of new contacts and return the PersonResponses for the newly Mutate requests for the same user should be sent sequentially to avoid increased latency and failures."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:batchCreateContacts"
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

(defn connections-list$
  "https://developers.google.com/people/api/reference/rest/v1/people/connections/list
  
  Required parameters: resourceName
  
  Optional parameters: requestSyncToken, requestMask.includeField, sources, personFields, syncToken, pageToken, pageSize, sortOrder
  
  Provides a list of the authenticated user's contacts. Sync tokens expire 7 days after the full sync. A request with an expired sync token will get an error with an [google.rpc.ErrorInfo](https://cloud.google.com/apis/design/errors#error_info) with reason \"EXPIRED_SYNC_TOKEN\". In the case of such an error clients should make a full sync request without a `sync_token`. The first page of a full sync request has an additional quota. If the quota is exceeded, a 429 error will be returned. This quota is fixed and can not be increased. When the `sync_token` is specified, resources deleted since the last sync will be returned as a person with `PersonMetadata.deleted` set to true. When the `page_token` or `sync_token` is specified, all other request parameters must match the first call. Writes may have a propagation delay of several minutes for sync requests. Incremental syncs are not intended for read-after-write use cases. See example usage at [List the user's contacts that have changed](/people/v1/contacts#list_the_users_contacts_that_have_changed)."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}/connections"
     #{:resourceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
