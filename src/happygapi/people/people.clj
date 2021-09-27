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
   :urls [{:type string,
           :metadata FieldMetadata,
           :value string,
           :formattedType string}],
   :relationshipStatuses [{:formattedValue string,
                           :metadata FieldMetadata,
                           :value string}],
   :coverPhotos [{:url string,
                  :default boolean,
                  :metadata FieldMetadata}],
   :birthdays [{:date Date, :text string, :metadata FieldMetadata}],
   :relations [{:metadata FieldMetadata,
                :type string,
                :person string,
                :formattedType string}],
   :ageRange string,
   :events [{:date Date,
             :metadata FieldMetadata,
             :formattedType string,
             :type string}],
   :phoneNumbers [{:value string,
                   :formattedType string,
                   :metadata FieldMetadata,
                   :canonicalForm string,
                   :type string}],
   :etag string,
   :fileAses [{:metadata FieldMetadata, :value string}],
   :biographies [{:value string,
                  :metadata FieldMetadata,
                  :contentType string}],
   :emailAddresses [{:type string,
                     :metadata FieldMetadata,
                     :displayName string,
                     :formattedType string,
                     :value string}],
   :miscKeywords [{:formattedType string,
                   :metadata FieldMetadata,
                   :value string,
                   :type string}],
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
   :sipAddresses [{:formattedType string,
                   :type string,
                   :value string,
                   :metadata FieldMetadata}],
   :braggingRights [{:metadata FieldMetadata, :value string}],
   :resourceName string,
   :locations [{:metadata FieldMetadata,
                :type string,
                :floor string,
                :floorSection string,
                :deskCode string,
                :buildingId string,
                :value string,
                :current boolean}],
   :externalIds [{:formattedType string,
                  :value string,
                  :metadata FieldMetadata,
                  :type string}],
   :relationshipInterests [{:metadata FieldMetadata,
                            :formattedValue string,
                            :value string}],
   :photos [{:default boolean, :metadata FieldMetadata, :url string}],
   :skills [{:value string, :metadata FieldMetadata}],
   :locales [{:value string, :metadata FieldMetadata}],
   :ageRanges [{:ageRange string, :metadata FieldMetadata}],
   :memberships [{:domainMembership DomainMembership,
                  :metadata FieldMetadata,
                  :contactGroupMembership ContactGroupMembership}],
   :clientData [{:key string, :metadata FieldMetadata, :value string}],
   :interests [{:metadata FieldMetadata, :value string}],
   :nicknames [{:value string, :metadata FieldMetadata, :type string}],
   :residences [{:metadata FieldMetadata,
                 :current boolean,
                 :value string}],
   :imClients [{:formattedProtocol string,
                :formattedType string,
                :metadata FieldMetadata,
                :protocol string,
                :type string,
                :username string}],
   :genders [{:addressMeAs string,
              :formattedValue string,
              :metadata FieldMetadata,
              :value string}],
   :calendarUrls [{:formattedType string,
                   :metadata FieldMetadata,
                   :url string,
                   :type string}],
   :taglines [{:value string, :metadata FieldMetadata}],
   :occupations [{:value string, :metadata FieldMetadata}],
   :metadata {:previousResourceNames [string],
              :sources [Source],
              :deleted boolean,
              :objectType string,
              :linkedPeopleResourceNames [string]},
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
   :userDefined [{:key string, :metadata FieldMetadata, :value string}]}
  
  Create a new contact and return the person resource for that contact. The request returns a 400 error if more than one field is specified on a field that is a singleton for contact sources: * biographies * birthdays * genders * names"
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
  
  Optional parameters: readMask, pageSize, sources, query
  
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
  
  Optional parameters: personFields, requestMask.includeField, sources
  
  Provides information about a person by specifying a resource name. Use `people/me` to indicate the authenticated user. The request returns a 400 error if 'personFields' is not specified."
  {:scopes ["https://www.googleapis.com/auth/contacts"
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
  
  Optional parameters: readMask, sources, pageSize, mergeSources, pageToken, query
  
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
  
  Delete a contact person. Any non-contact data will not be deleted."
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
  
  Optional parameters: personFields, sources, updatePersonFields
  
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
   :urls [{:type string,
           :metadata FieldMetadata,
           :value string,
           :formattedType string}],
   :relationshipStatuses [{:formattedValue string,
                           :metadata FieldMetadata,
                           :value string}],
   :coverPhotos [{:url string,
                  :default boolean,
                  :metadata FieldMetadata}],
   :birthdays [{:date Date, :text string, :metadata FieldMetadata}],
   :relations [{:metadata FieldMetadata,
                :type string,
                :person string,
                :formattedType string}],
   :ageRange string,
   :events [{:date Date,
             :metadata FieldMetadata,
             :formattedType string,
             :type string}],
   :phoneNumbers [{:value string,
                   :formattedType string,
                   :metadata FieldMetadata,
                   :canonicalForm string,
                   :type string}],
   :etag string,
   :fileAses [{:metadata FieldMetadata, :value string}],
   :biographies [{:value string,
                  :metadata FieldMetadata,
                  :contentType string}],
   :emailAddresses [{:type string,
                     :metadata FieldMetadata,
                     :displayName string,
                     :formattedType string,
                     :value string}],
   :miscKeywords [{:formattedType string,
                   :metadata FieldMetadata,
                   :value string,
                   :type string}],
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
   :sipAddresses [{:formattedType string,
                   :type string,
                   :value string,
                   :metadata FieldMetadata}],
   :braggingRights [{:metadata FieldMetadata, :value string}],
   :resourceName string,
   :locations [{:metadata FieldMetadata,
                :type string,
                :floor string,
                :floorSection string,
                :deskCode string,
                :buildingId string,
                :value string,
                :current boolean}],
   :externalIds [{:formattedType string,
                  :value string,
                  :metadata FieldMetadata,
                  :type string}],
   :relationshipInterests [{:metadata FieldMetadata,
                            :formattedValue string,
                            :value string}],
   :photos [{:default boolean, :metadata FieldMetadata, :url string}],
   :skills [{:value string, :metadata FieldMetadata}],
   :locales [{:value string, :metadata FieldMetadata}],
   :ageRanges [{:ageRange string, :metadata FieldMetadata}],
   :memberships [{:domainMembership DomainMembership,
                  :metadata FieldMetadata,
                  :contactGroupMembership ContactGroupMembership}],
   :clientData [{:key string, :metadata FieldMetadata, :value string}],
   :interests [{:metadata FieldMetadata, :value string}],
   :nicknames [{:value string, :metadata FieldMetadata, :type string}],
   :residences [{:metadata FieldMetadata,
                 :current boolean,
                 :value string}],
   :imClients [{:formattedProtocol string,
                :formattedType string,
                :metadata FieldMetadata,
                :protocol string,
                :type string,
                :username string}],
   :genders [{:addressMeAs string,
              :formattedValue string,
              :metadata FieldMetadata,
              :value string}],
   :calendarUrls [{:formattedType string,
                   :metadata FieldMetadata,
                   :url string,
                   :type string}],
   :taglines [{:value string, :metadata FieldMetadata}],
   :occupations [{:value string, :metadata FieldMetadata}],
   :metadata {:previousResourceNames [string],
              :sources [Source],
              :deleted boolean,
              :objectType string,
              :linkedPeopleResourceNames [string]},
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
   :userDefined [{:key string, :metadata FieldMetadata, :value string}]}
  
  Update contact data for an existing contact person. Any non-contact data will not be modified. Any non-contact data in the person to update will be ignored. All fields specified in the `update_mask` will be replaced. The server returns a 400 error if `person.metadata.sources` is not specified for the contact to be updated or if there is no contact source. The server returns a 400 error with reason `\"failedPrecondition\"` if `person.metadata.sources.etag` is different than the contact's etag, which indicates the contact has changed since its data was read. Clients should get the latest person and merge their updates into the latest person. The server returns a 400 error if `memberships` are being updated and there are no contact group memberships specified on the person. The server returns a 400 error if more than one field is specified on a field that is a singleton for contact sources: * biographies * birthdays * genders * names"
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
  
  {:sources [string], :photoBytes string, :personFields string}
  
  Update a contact's photo."
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
  
  Optional parameters: sources, personFields
  
  Delete a contact's photo."
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
  
  Delete a batch of contacts. Any non-contact data will not be deleted. Limited to 10 parallel requests per user."
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
  
  {:updateMask string,
   :contacts {},
   :sources [string],
   :readMask string}
  
  Update a batch of contacts and return a map of resource names to PersonResponses for the updated contacts. Limited to 10 parallel requests per user."
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
  
  Optional parameters: pageSize, sources, syncToken, pageToken, requestSyncToken, readMask, mergeSources
  
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
   :sources [string],
   :readMask string}
  
  Create a batch of new contacts and return the PersonResponses for the newly created contacts. Limited to 10 parallel requests per user."
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
  
  Provides a list of the authenticated user's contacts. Sync tokens expire 7 days after the full sync. A request with an expired sync token will result in a 410 error. In the case of such an error clients should make a full sync request without a `sync_token`. The first page of a full sync request has an additional quota. If the quota is exceeded, a 429 error will be returned. This quota is fixed and can not be increased. When the `sync_token` is specified, resources deleted since the last sync will be returned as a person with `PersonMetadata.deleted` set to true. When the `page_token` or `sync_token` is specified, all other request parameters must match the first call. Writes may have a propagation delay of several minutes for sync requests. Incremental syncs are not intended for read-after-write use cases. See example usage at [List the user's contacts that have changed](/people/v1/contacts#list_the_users_contacts_that_have_changed)."
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
