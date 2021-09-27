(ns happygapi.people.contactGroups
  "People API: contactGroups.
  Provides access to information about profiles and contacts.
  See: https://developers.google.com/people/api/reference/rest/v1/contactGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/people/api/reference/rest/v1/contactGroups/get
  
  Required parameters: resourceName
  
  Optional parameters: groupFields, maxMembers
  
  Get a specific contact group owned by the authenticated user by specifying a contact group resource name."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
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

(defn create$
  "https://developers.google.com/people/api/reference/rest/v1/contactGroups/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:readGroupFields string,
   :contactGroup {:memberCount integer,
                  :groupType string,
                  :name string,
                  :etag string,
                  :memberResourceNames [string],
                  :resourceName string,
                  :clientData [GroupClientData],
                  :metadata ContactGroupMetadata,
                  :formattedName string}}
  
  Create a new contact group owned by the authenticated user. Created contact group names must be unique to the users contact groups. Attempting to create a group with a duplicate name will return a HTTP 409 error."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/contactGroups"
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

(defn update$
  "https://developers.google.com/people/api/reference/rest/v1/contactGroups/update
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Body: 
  
  {:updateGroupFields string,
   :contactGroup {:memberCount integer,
                  :groupType string,
                  :name string,
                  :etag string,
                  :memberResourceNames [string],
                  :resourceName string,
                  :clientData [GroupClientData],
                  :metadata ContactGroupMetadata,
                  :formattedName string},
   :readGroupFields string}
  
  Update the name of an existing contact group owned by the authenticated user. Updated contact group names must be unique to the users contact groups. Attempting to create a group with a duplicate name will return a HTTP 409 error."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}"
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

(defn delete$
  "https://developers.google.com/people/api/reference/rest/v1/contactGroups/delete
  
  Required parameters: resourceName
  
  Optional parameters: deleteContacts
  
  Delete an existing contact group owned by the authenticated user by specifying a contact group resource name."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/delete
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

(defn list$
  "https://developers.google.com/people/api/reference/rest/v1/contactGroups/list
  
  Required parameters: none
  
  Optional parameters: syncToken, pageSize, groupFields, pageToken
  
  List all contact groups owned by the authenticated user. Members of the contact groups are not populated."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/contactGroups"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn batchGet$
  "https://developers.google.com/people/api/reference/rest/v1/contactGroups/batchGet
  
  Required parameters: none
  
  Optional parameters: maxMembers, resourceNames, groupFields
  
  Get a list of contact groups owned by the authenticated user by specifying a list of contact group resource names."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/contactGroups:batchGet"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn members-modify$
  "https://developers.google.com/people/api/reference/rest/v1/contactGroups/members/modify
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Body: 
  
  {:resourceNamesToAdd [string], :resourceNamesToRemove [string]}
  
  Modify the members of a contact group owned by the authenticated user. The only system contact groups that can have members added are `contactGroups/myContacts` and `contactGroups/starred`. Other system contact groups are deprecated and can only have contacts removed."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}/members:modify"
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
