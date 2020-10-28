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
           :value string,
           :formattedType string,
           :metadata FieldMetadata}],
   :relationshipStatuses [{:value string,
                           :metadata FieldMetadata,
                           :formattedValue string}],
   :coverPhotos [{:metadata FieldMetadata,
                  :default boolean,
                  :url string}],
   :birthdays [{:date Date, :text string, :metadata FieldMetadata}],
   :relations [{:formattedType string,
                :person string,
                :metadata FieldMetadata,
                :type string}],
   :ageRange string,
   :events [{:formattedType string,
             :type string,
             :metadata FieldMetadata,
             :date Date}],
   :phoneNumbers [{:value string,
                   :metadata FieldMetadata,
                   :type string,
                   :formattedType string,
                   :canonicalForm string}],
   :etag string,
   :fileAses [{:value string, :metadata FieldMetadata}],
   :biographies [{:metadata FieldMetadata,
                  :contentType string,
                  :value string}],
   :emailAddresses [{:formattedType string,
                     :displayName string,
                     :value string,
                     :type string,
                     :metadata FieldMetadata}],
   :miscKeywords [{:type string,
                   :metadata FieldMetadata,
                   :formattedType string,
                   :value string}],
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
   :sipAddresses [{:formattedType string,
                   :value string,
                   :metadata FieldMetadata,
                   :type string}],
   :braggingRights [{:metadata FieldMetadata, :value string}],
   :resourceName string,
   :locations [{:floorSection string,
                :current boolean,
                :value string,
                :metadata FieldMetadata,
                :buildingId string,
                :floor string,
                :type string,
                :deskCode string}],
   :externalIds [{:type string,
                  :value string,
                  :formattedType string,
                  :metadata FieldMetadata}],
   :relationshipInterests [{:formattedValue string,
                            :metadata FieldMetadata,
                            :value string}],
   :photos [{:metadata FieldMetadata, :default boolean, :url string}],
   :skills [{:value string, :metadata FieldMetadata}],
   :locales [{:metadata FieldMetadata, :value string}],
   :ageRanges [{:ageRange string, :metadata FieldMetadata}],
   :memberships [{:metadata FieldMetadata,
                  :contactGroupMembership ContactGroupMembership,
                  :domainMembership DomainMembership}],
   :clientData [{:value string, :key string, :metadata FieldMetadata}],
   :interests [{:metadata FieldMetadata, :value string}],
   :nicknames [{:metadata FieldMetadata, :type string, :value string}],
   :residences [{:value string,
                 :metadata FieldMetadata,
                 :current boolean}],
   :imClients [{:formattedType string,
                :metadata FieldMetadata,
                :formattedProtocol string,
                :protocol string,
                :username string,
                :type string}],
   :genders [{:addressMeAs string,
              :value string,
              :formattedValue string,
              :metadata FieldMetadata}],
   :calendarUrls [{:url string,
                   :formattedType string,
                   :metadata FieldMetadata,
                   :type string}],
   :taglines [{:value string, :metadata FieldMetadata}],
   :occupations [{:value string, :metadata FieldMetadata}],
   :metadata {:linkedPeopleResourceNames [string],
              :objectType string,
              :deleted boolean,
              :previousResourceNames [string],
              :sources [Source]},
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
  
  Create a new contact and return the person resource for that contact. The request throws a 400 error if more than one field is specified on a field that is a singleton for contact sources: * biographies * birthdays * genders * names"
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

(defn get$
  "https://developers.google.com/people/api/reference/rest/v1/people/get
  
  Required parameters: resourceName
  
  Optional parameters: sources, personFields, requestMask.includeField
  
  Provides information about a person by specifying a resource name. Use `people/me` to indicate the authenticated user. The request throws a 400 error if 'personFields' is not specified."
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
  
  Optional parameters: pageSize, readMask, pageToken, query, sources, mergeSources
  
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
  
  Optional parameters: personFields, updatePersonFields, sources
  
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
           :value string,
           :formattedType string,
           :metadata FieldMetadata}],
   :relationshipStatuses [{:value string,
                           :metadata FieldMetadata,
                           :formattedValue string}],
   :coverPhotos [{:metadata FieldMetadata,
                  :default boolean,
                  :url string}],
   :birthdays [{:date Date, :text string, :metadata FieldMetadata}],
   :relations [{:formattedType string,
                :person string,
                :metadata FieldMetadata,
                :type string}],
   :ageRange string,
   :events [{:formattedType string,
             :type string,
             :metadata FieldMetadata,
             :date Date}],
   :phoneNumbers [{:value string,
                   :metadata FieldMetadata,
                   :type string,
                   :formattedType string,
                   :canonicalForm string}],
   :etag string,
   :fileAses [{:value string, :metadata FieldMetadata}],
   :biographies [{:metadata FieldMetadata,
                  :contentType string,
                  :value string}],
   :emailAddresses [{:formattedType string,
                     :displayName string,
                     :value string,
                     :type string,
                     :metadata FieldMetadata}],
   :miscKeywords [{:type string,
                   :metadata FieldMetadata,
                   :formattedType string,
                   :value string}],
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
   :sipAddresses [{:formattedType string,
                   :value string,
                   :metadata FieldMetadata,
                   :type string}],
   :braggingRights [{:metadata FieldMetadata, :value string}],
   :resourceName string,
   :locations [{:floorSection string,
                :current boolean,
                :value string,
                :metadata FieldMetadata,
                :buildingId string,
                :floor string,
                :type string,
                :deskCode string}],
   :externalIds [{:type string,
                  :value string,
                  :formattedType string,
                  :metadata FieldMetadata}],
   :relationshipInterests [{:formattedValue string,
                            :metadata FieldMetadata,
                            :value string}],
   :photos [{:metadata FieldMetadata, :default boolean, :url string}],
   :skills [{:value string, :metadata FieldMetadata}],
   :locales [{:metadata FieldMetadata, :value string}],
   :ageRanges [{:ageRange string, :metadata FieldMetadata}],
   :memberships [{:metadata FieldMetadata,
                  :contactGroupMembership ContactGroupMembership,
                  :domainMembership DomainMembership}],
   :clientData [{:value string, :key string, :metadata FieldMetadata}],
   :interests [{:metadata FieldMetadata, :value string}],
   :nicknames [{:metadata FieldMetadata, :type string, :value string}],
   :residences [{:value string,
                 :metadata FieldMetadata,
                 :current boolean}],
   :imClients [{:formattedType string,
                :metadata FieldMetadata,
                :formattedProtocol string,
                :protocol string,
                :username string,
                :type string}],
   :genders [{:addressMeAs string,
              :value string,
              :formattedValue string,
              :metadata FieldMetadata}],
   :calendarUrls [{:url string,
                   :formattedType string,
                   :metadata FieldMetadata,
                   :type string}],
   :taglines [{:value string, :metadata FieldMetadata}],
   :occupations [{:value string, :metadata FieldMetadata}],
   :metadata {:linkedPeopleResourceNames [string],
              :objectType string,
              :deleted boolean,
              :previousResourceNames [string],
              :sources [Source]},
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
  
  {:personFields string, :sources [string], :photoBytes string}
  
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
  
  Optional parameters: personFields, sources
  
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

(defn listDirectoryPeople$
  "https://developers.google.com/people/api/reference/rest/v1/people/listDirectoryPeople
  
  Required parameters: none
  
  Optional parameters: syncToken, readMask, pageSize, mergeSources, pageToken, requestSyncToken, sources
  
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
  
  Optional parameters: requestMask.includeField, personFields, sources, resourceNames
  
  Provides information about a list of specific people by specifying a list of requested resource names. Use `people/me` to indicate the authenticated user. The request throws a 400 error if 'personFields' is not specified."
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

(defn connections-list$
  "https://developers.google.com/people/api/reference/rest/v1/people/connections/list
  
  Required parameters: resourceName
  
  Optional parameters: requestSyncToken, requestMask.includeField, sources, personFields, syncToken, pageToken, pageSize, sortOrder
  
  Provides a list of the authenticated user's contacts. The request throws a 400 error if 'personFields' is not specified."
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
