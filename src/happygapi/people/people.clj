(ns happygapi.people.people
  "People API: people.
  Provides access to information about profiles and contacts.
  See: https://developers.google.com/people/api/reference/rest/v1/people"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/people/api/reference/rest/v1/people/get
  
  Required parameters: resourceName
  
  Optional parameters: personFields, requestMask.includeField
  Provides information about a person by specifying a resource name. Use
  `people/me` to indicate the authenticated user.
  
  The request throws a 400 error if 'personFields' is not specified."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"
            "https://www.googleapis.com/auth/user.addresses.read"
            "https://www.googleapis.com/auth/user.birthday.read"
            "https://www.googleapis.com/auth/user.emails.read"
            "https://www.googleapis.com/auth/user.organization.read"
            "https://www.googleapis.com/auth/user.phonenumbers.read"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resourceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}"
     #{:resourceName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deleteContact$
  "https://developers.google.com/people/api/reference/rest/v1/people/deleteContact
  
  Required parameters: resourceName
  
  Optional parameters: none
  Delete a contact person. Any non-contact data will not be deleted."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resourceName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:deleteContact"
     #{:resourceName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getBatchGet$
  "https://developers.google.com/people/api/reference/rest/v1/people/getBatchGet
  
  Required parameters: none
  
  Optional parameters: personFields, requestMask.includeField, resourceNames
  Provides information about a list of specific people by specifying a list
  of requested resource names. Use `people/me` to indicate the authenticated
  user.
  
  The request throws a 400 error if 'personFields' is not specified."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"
            "https://www.googleapis.com/auth/user.addresses.read"
            "https://www.googleapis.com/auth/user.birthday.read"
            "https://www.googleapis.com/auth/user.emails.read"
            "https://www.googleapis.com/auth/user.organization.read"
            "https://www.googleapis.com/auth/user.phonenumbers.read"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:batchGet"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateContactPhoto$
  "https://developers.google.com/people/api/reference/rest/v1/people/updateContactPhoto
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Body: 
  
  {:photoBytes string, :personFields string}
  
  Update a contact's photo."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resourceName})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:updateContactPhoto"
     #{:resourceName}
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

(defn updateContact$
  "https://developers.google.com/people/api/reference/rest/v1/people/updateContact
  
  Required parameters: resourceName
  
  Optional parameters: updatePersonFields
  
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
           :type string,
           :value string,
           :formattedType string}],
   :relationshipStatuses [{:value string,
                           :formattedValue string,
                           :metadata FieldMetadata}],
   :coverPhotos [{:url string,
                  :metadata FieldMetadata,
                  :default boolean}],
   :birthdays [{:metadata FieldMetadata, :text string, :date Date}],
   :relations [{:metadata FieldMetadata,
                :type string,
                :person string,
                :formattedType string}],
   :ageRange string,
   :events [{:metadata FieldMetadata,
             :type string,
             :date Date,
             :formattedType string}],
   :phoneNumbers [{:canonicalForm string,
                   :metadata FieldMetadata,
                   :type string,
                   :value string,
                   :formattedType string}],
   :etag string,
   :biographies [{:value string,
                  :contentType string,
                  :metadata FieldMetadata}],
   :emailAddresses [{:displayName string,
                     :metadata FieldMetadata,
                     :type string,
                     :value string,
                     :formattedType string}],
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
   :sipAddresses [{:metadata FieldMetadata,
                   :type string,
                   :value string,
                   :formattedType string}],
   :braggingRights [{:value string, :metadata FieldMetadata}],
   :resourceName string,
   :relationshipInterests [{:metadata FieldMetadata,
                            :value string,
                            :formattedValue string}],
   :photos [{:metadata FieldMetadata, :default boolean, :url string}],
   :skills [{:metadata FieldMetadata, :value string}],
   :locales [{:metadata FieldMetadata, :value string}],
   :ageRanges [{:ageRange string, :metadata FieldMetadata}],
   :memberships [{:contactGroupMembership ContactGroupMembership,
                  :domainMembership DomainMembership,
                  :metadata FieldMetadata}],
   :interests [{:value string, :metadata FieldMetadata}],
   :nicknames [{:metadata FieldMetadata, :type string, :value string}],
   :residences [{:metadata FieldMetadata,
                 :current boolean,
                 :value string}],
   :imClients [{:formattedProtocol string,
                :formattedType string,
                :metadata FieldMetadata,
                :type string,
                :protocol string,
                :username string}],
   :genders [{:formattedValue string,
              :metadata FieldMetadata,
              :value string}],
   :taglines [{:metadata FieldMetadata, :value string}],
   :occupations [{:metadata FieldMetadata, :value string}],
   :metadata {:objectType string,
              :linkedPeopleResourceNames [string],
              :sources [Source],
              :previousResourceNames [string],
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
            :givenName string,
            :honorificSuffix string,
            :metadata FieldMetadata}],
   :userDefined [{:key string, :metadata FieldMetadata, :value string}]}
  
  Update contact data for an existing contact person. Any non-contact data
  will not be modified.
  
  The request throws a 400 error if `updatePersonFields` is not specified.
  
  The request throws a 400 error if `person.metadata.sources` is not
  specified for the contact to be updated.
  
  The request throws a 400 error with an error with reason
  `\"failedPrecondition\"` if `person.metadata.sources.etag` is different than
  the contact's etag, which indicates the contact has changed since its data
  was read. Clients should get the latest person and re-apply their updates
  to the latest person."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resourceName})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:updateContact"
     #{:resourceName}
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

(defn deleteContactPhoto$
  "https://developers.google.com/people/api/reference/rest/v1/people/deleteContactPhoto
  
  Required parameters: resourceName
  
  Optional parameters: personFields
  Delete a contact's photo."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resourceName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:deleteContactPhoto"
     #{:resourceName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn createContact$
  "https://developers.google.com/people/api/reference/rest/v1/people/createContact
  
  Required parameters: none
  
  Optional parameters: none
  
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
           :type string,
           :value string,
           :formattedType string}],
   :relationshipStatuses [{:value string,
                           :formattedValue string,
                           :metadata FieldMetadata}],
   :coverPhotos [{:url string,
                  :metadata FieldMetadata,
                  :default boolean}],
   :birthdays [{:metadata FieldMetadata, :text string, :date Date}],
   :relations [{:metadata FieldMetadata,
                :type string,
                :person string,
                :formattedType string}],
   :ageRange string,
   :events [{:metadata FieldMetadata,
             :type string,
             :date Date,
             :formattedType string}],
   :phoneNumbers [{:canonicalForm string,
                   :metadata FieldMetadata,
                   :type string,
                   :value string,
                   :formattedType string}],
   :etag string,
   :biographies [{:value string,
                  :contentType string,
                  :metadata FieldMetadata}],
   :emailAddresses [{:displayName string,
                     :metadata FieldMetadata,
                     :type string,
                     :value string,
                     :formattedType string}],
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
   :sipAddresses [{:metadata FieldMetadata,
                   :type string,
                   :value string,
                   :formattedType string}],
   :braggingRights [{:value string, :metadata FieldMetadata}],
   :resourceName string,
   :relationshipInterests [{:metadata FieldMetadata,
                            :value string,
                            :formattedValue string}],
   :photos [{:metadata FieldMetadata, :default boolean, :url string}],
   :skills [{:metadata FieldMetadata, :value string}],
   :locales [{:metadata FieldMetadata, :value string}],
   :ageRanges [{:ageRange string, :metadata FieldMetadata}],
   :memberships [{:contactGroupMembership ContactGroupMembership,
                  :domainMembership DomainMembership,
                  :metadata FieldMetadata}],
   :interests [{:value string, :metadata FieldMetadata}],
   :nicknames [{:metadata FieldMetadata, :type string, :value string}],
   :residences [{:metadata FieldMetadata,
                 :current boolean,
                 :value string}],
   :imClients [{:formattedProtocol string,
                :formattedType string,
                :metadata FieldMetadata,
                :type string,
                :protocol string,
                :username string}],
   :genders [{:formattedValue string,
              :metadata FieldMetadata,
              :value string}],
   :taglines [{:metadata FieldMetadata, :value string}],
   :occupations [{:metadata FieldMetadata, :value string}],
   :metadata {:objectType string,
              :linkedPeopleResourceNames [string],
              :sources [Source],
              :previousResourceNames [string],
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
            :givenName string,
            :honorificSuffix string,
            :metadata FieldMetadata}],
   :userDefined [{:key string, :metadata FieldMetadata, :value string}]}
  
  Create a new contact and return the person resource for that contact."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/people:createContact"
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

(defn connections-list$
  "https://developers.google.com/people/api/reference/rest/v1/people/connections/list
  
  Required parameters: resourceName
  
  Optional parameters: requestSyncToken, pageToken, pageSize, requestMask.includeField, syncToken, personFields, sortOrder
  Provides a list of the authenticated user's contacts merged with any
  connected profiles.
  
  The request throws a 400 error if 'personFields' is not specified."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resourceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}/connections"
     #{:resourceName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
