(ns happygapi.people.otherContacts
  "People API: otherContacts.
  Provides access to information about profiles and contacts.
  See: https://developers.google.com/people/api/reference/rest/v1/otherContacts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/people/api/reference/rest/v1/otherContacts/list
  
  Required parameters: none
  
  Optional parameters: readMask, syncToken, requestSyncToken, pageToken, pageSize
  
  List all \"Other contacts\", that is contacts that are not in a contact group. \"Other contacts\" are typically auto created contacts from interactions."
  {:scopes ["https://www.googleapis.com/auth/contacts.other.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/otherContacts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn copyOtherContactToMyContactsGroup$
  "https://developers.google.com/people/api/reference/rest/v1/otherContacts/copyOtherContactToMyContactsGroup
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Body: 
  
  {:copyMask string, :readMask string, :sources [string]}
  
  Copies an \"Other contact\" to a new contact in the user's \"myContacts\" group"
  {:scopes ["https://www.googleapis.com/auth/contacts"
            "https://www.googleapis.com/auth/contacts.other.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://people.googleapis.com/"
     "v1/{+resourceName}:copyOtherContactToMyContactsGroup"
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
