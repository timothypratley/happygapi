(ns happygapi.people.contactGroups
  "People API
  Provides access to information about profiles and contacts.
  See: https://developers.google.com/people/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "people_schema.edn"))))

(defn batchGet$
  "Required parameters: none
  
  Optional parameters: resourceNames, maxMembers
  
  Get a list of contact groups owned by the authenticated user by specifying
  a list of contact group resource names."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/contactGroups:batchGet"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "Required parameters: resourceName
  
  Optional parameters: deleteContacts
  
  Delete an existing contact group owned by the authenticated user by
  specifying a contact group resource name."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resourceName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
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

(defn list$
  "Required parameters: none
  
  Optional parameters: pageToken, pageSize, syncToken
  
  List all contact groups owned by the authenticated user. Members of the
  contact groups are not populated."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/contactGroups"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Create a new contact group owned by the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/contactGroups"
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

(defn get$
  "Required parameters: resourceName
  
  Optional parameters: maxMembers
  
  Get a specific contact group owned by the authenticated user by specifying
  a contact group resource name."
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resourceName"})
         (json-schema/validate schemas args)]}
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

(defn update$
  "Required parameters: resourceName
  
  Optional parameters: none
  
  Update the name of an existing contact group owned by the authenticated
  user."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resourceName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
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

(defn members-modify$
  "Required parameters: resourceName
  
  Optional parameters: none
  
  Modify the members of a contact group owned by the authenticated user.
  
  The only system contact groups that can have members added are
  `contactGroups/myContacts` and `contactGroups/starred`. Other system
  contact groups are deprecated and can only have contacts removed."
  {:scopes ["https://www.googleapis.com/auth/contacts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resourceName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}/members:modify"
     #{"resourceName"}
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
