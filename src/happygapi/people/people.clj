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
  
  Optional parameters: sources, personFields
  
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
   :urls [{:formattedType string,
           :metadata FieldMetadata,
           :type string,
           :value string}],
   :relationshipStatuses [{:formattedValue string,
                           :value string,
                           :metadata FieldMetadata}],
   :coverPhotos [{:url string,
                  :metadata FieldMetadata,
                  :default boolean}],
   :birthdays [{:metadata FieldMetadata, :date Date, :text string}],
   :relations [{:person string,
                :metadata FieldMetadata,
                :type string,
                :formattedType string}],
   :ageRange string,
   :events [{:date Date,
             :formattedType string,
             :type string,
             :metadata FieldMetadata}],
   :phoneNumbers [{:value string,
                   :type string,
                   :metadata FieldMetadata,
                   :formattedType string,
                   :canonicalForm string}],
   :etag string,
   :fileAses [{:metadata FieldMetadata, :value string}],
   :biographies [{:metadata FieldMetadata,
                  :value string,
                  :contentType string}],
   :emailAddresses [{:displayName string,
                     :formattedType string,
                     :value string,
                     :metadata FieldMetadata,
                     :type string}],
   :miscKeywords [{:metadata FieldMetadata,
                   :formattedType string,
                   :value string,
                   :type string}],
   :organizations [{:department string,
                    :formattedType string,
                    :symbol string,
                    :name string,
                    :startDate Date,
                    :type string,
                    :phoneticName string,
                    :title string,
                    :endDate Date,
                    :jobDescription string,
                    :current boolean,
                    :domain string,
                    :location string,
                    :metadata FieldMetadata}],
   :sipAddresses [{:type string,
                   :metadata FieldMetadata,
                   :value string,
                   :formattedType string}],
   :braggingRights [{:metadata FieldMetadata, :value string}],
   :resourceName string,
   :locations [{:type string,
                :current boolean,
                :deskCode string,
                :floor string,
                :floorSection string,
                :value string,
                :buildingId string,
                :metadata FieldMetadata}],
   :externalIds [{:value string,
                  :type string,
                  :metadata FieldMetadata,
                  :formattedType string}],
   :relationshipInterests [{:value string,
                            :formattedValue string,
                            :metadata FieldMetadata}],
   :photos [{:default boolean, :metadata FieldMetadata, :url string}],
   :skills [{:metadata FieldMetadata, :value string}],
   :locales [{:value string, :metadata FieldMetadata}],
   :ageRanges [{:ageRange string, :metadata FieldMetadata}],
   :memberships [{:contactGroupMembership ContactGroupMembership,
                  :metadata FieldMetadata,
                  :domainMembership DomainMembership}],
   :clientData [{:value string, :key string, :metadata FieldMetadata}],
   :interests [{:value string, :metadata FieldMetadata}],
   :nicknames [{:value string, :type string, :metadata FieldMetadata}],
   :residences [{:current boolean,
                 :value string,
                 :metadata FieldMetadata}],
   :imClients [{:protocol string,
                :type string,
                :formattedType string,
                :formattedProtocol string,
                :metadata FieldMetadata,
                :username string}],
   :genders [{:addressMeAs string,
              :formattedValue string,
              :value string,
              :metadata FieldMetadata}],
   :calendarUrls [{:metadata FieldMetadata,
                   :type string,
                   :url string,
                   :formattedType string}],
   :taglines [{:value string, :metadata FieldMetadata}],
   :occupations [{:metadata FieldMetadata, :value string}],
   :metadata {:linkedPeopleResourceNames [string],
              :previousResourceNames [string],
              :sources [Source],
              :objectType string,
              :deleted boolean},
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
   :userDefined [{:key string, :value string, :metadata FieldMetadata}]}
  
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
  
  Optional parameters: pageSize, readMask, query, sources
  
  Provides a list of contacts in the authenticated user's grouped contacts that matches the search query. The query matches on a contact's `names`, `nickNames`, `emailAddresses`, `phoneNumbers`, and `organizations` fields that are from the CONTACT\" source. **IMPORTANT**: Before searching, clients should send a warmup request with an empty query to update the cache. See https://developers.google.com/people/v1/contacts#search_the_users_contacts"
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
  
  Optional parameters: sources, personFields, requestMask.includeField
  
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
  
  Optional parameters: mergeSources, pageSize, sources, query, readMask, pageToken
  
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
  
  Optional parameters: sources, updatePersonFields, personFields
  
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
   :urls [{:formattedType string,
           :metadata FieldMetadata,
           :type string,
           :value string}],
   :relationshipStatuses [{:formattedValue string,
                           :value string,
                           :metadata FieldMetadata}],
   :coverPhotos [{:url string,
                  :metadata FieldMetadata,
                  :default boolean}],
   :birthdays [{:metadata FieldMetadata, :date Date, :text string}],
   :relations [{:person string,
                :metadata FieldMetadata,
                :type string,
                :formattedType string}],
   :ageRange string,
   :events [{:date Date,
             :formattedType string,
             :type string,
             :metadata FieldMetadata}],
   :phoneNumbers [{:value string,
                   :type string,
                   :metadata FieldMetadata,
                   :formattedType string,
                   :canonicalForm string}],
   :etag string,
   :fileAses [{:metadata FieldMetadata, :value string}],
   :biographies [{:metadata FieldMetadata,
                  :value string,
                  :contentType string}],
   :emailAddresses [{:displayName string,
                     :formattedType string,
                     :value string,
                     :metadata FieldMetadata,
                     :type string}],
   :miscKeywords [{:metadata FieldMetadata,
                   :formattedType string,
                   :value string,
                   :type string}],
   :organizations [{:department string,
                    :formattedType string,
                    :symbol string,
                    :name string,
                    :startDate Date,
                    :type string,
                    :phoneticName string,
                    :title string,
                    :endDate Date,
                    :jobDescription string,
                    :current boolean,
                    :domain string,
                    :location string,
                    :metadata FieldMetadata}],
   :sipAddresses [{:type string,
                   :metadata FieldMetadata,
                   :value string,
                   :formattedType string}],
   :braggingRights [{:metadata FieldMetadata, :value string}],
   :resourceName string,
   :locations [{:type string,
                :current boolean,
                :deskCode string,
                :floor string,
                :floorSection string,
                :value string,
                :buildingId string,
                :metadata FieldMetadata}],
   :externalIds [{:value string,
                  :type string,
                  :metadata FieldMetadata,
                  :formattedType string}],
   :relationshipInterests [{:value string,
                            :formattedValue string,
                            :metadata FieldMetadata}],
   :photos [{:default boolean, :metadata FieldMetadata, :url string}],
   :skills [{:metadata FieldMetadata, :value string}],
   :locales [{:value string, :metadata FieldMetadata}],
   :ageRanges [{:ageRange string, :metadata FieldMetadata}],
   :memberships [{:contactGroupMembership ContactGroupMembership,
                  :metadata FieldMetadata,
                  :domainMembership DomainMembership}],
   :clientData [{:value string, :key string, :metadata FieldMetadata}],
   :interests [{:value string, :metadata FieldMetadata}],
   :nicknames [{:value string, :type string, :metadata FieldMetadata}],
   :residences [{:current boolean,
                 :value string,
                 :metadata FieldMetadata}],
   :imClients [{:protocol string,
                :type string,
                :formattedType string,
                :formattedProtocol string,
                :metadata FieldMetadata,
                :username string}],
   :genders [{:addressMeAs string,
              :formattedValue string,
              :value string,
              :metadata FieldMetadata}],
   :calendarUrls [{:metadata FieldMetadata,
                   :type string,
                   :url string,
                   :formattedType string}],
   :taglines [{:value string, :metadata FieldMetadata}],
   :occupations [{:metadata FieldMetadata, :value string}],
   :metadata {:linkedPeopleResourceNames [string],
              :previousResourceNames [string],
              :sources [Source],
              :objectType string,
              :deleted boolean},
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
   :userDefined [{:key string, :value string, :metadata FieldMetadata}]}
  
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
  
  {:photoBytes string, :sources [string], :personFields string}
  
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
  
  Optional parameters: syncToken, readMask, sources, pageToken, requestSyncToken, pageSize, mergeSources
  
  Provides a list of domain profiles and domain contacts in the authenticated user's domain directory."
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
  
  Optional parameters: requestMask.includeField, resourceNames, sources, personFields
  
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
  
  {:readMask string,
   :sources [string],
   :contacts [{:contactPerson Person}]}
  
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
  
  Provides a list of the authenticated user's contacts. The request returns a 400 error if `personFields` is not specified. The request returns a 410 error if `sync_token` is specified and is expired. Sync tokens expire after 7 days to prevent data drift between clients and the server. To handle a sync token expired error, a request should be sent without `sync_token` to get all contacts."
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
