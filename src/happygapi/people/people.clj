(ns happygapi.people.people
  "People API
  Provides access to information about profiles and contacts.
  See: https://developers.google.com/people/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: resourceName
  
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
  {:pre [(util/has-keys? args #{"resourceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}"
     #{"resourceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deleteContact$
  "Required parameters: resourceName
  
  Delete a contact person. Any non-contact data will not be deleted."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resourceName"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:deleteContact"
     #{"resourceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getBatchGet$
  "Required parameters: none
  
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
  "Required parameters: resourceName
  
  Update a contact's photo."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resourceName"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:updateContactPhoto"
     #{"resourceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deleteContactPhoto$
  "Required parameters: resourceName
  
  Delete a contact's photo."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resourceName"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:deleteContactPhoto"
     #{"resourceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateContact$
  "Required parameters: resourceName
  
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
  [auth args]
  {:pre [(util/has-keys? args #{"resourceName"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:updateContact"
     #{"resourceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn createContact$
  "Required parameters: none
  
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
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn connections-list$
  "Required parameters: resourceName
  
  Provides a list of the authenticated user's contacts merged with any
  connected profiles.
  
  The request throws a 400 error if 'personFields' is not specified."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resourceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}/connections"
     #{"resourceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
