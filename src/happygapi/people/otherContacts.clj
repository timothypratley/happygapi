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
  
  Optional parameters: pageToken, pageSize, syncToken, readMask, requestSyncToken
  
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

(defn search$
  "https://developers.google.com/people/api/reference/rest/v1/otherContacts/search
  
  Required parameters: none
  
  Optional parameters: readMask, query, pageSize
  
  Provides a list of contacts in the authenticated user's other contacts that matches the search query. The query matches on a contact's `names`, `emailAddresses`, and `phoneNumbers` fields that are from the OTHER_CONTACT source. **IMPORTANT**: Before searching, clients should send a warmup request with an empty query to update the cache. See https://developers.google.com/people/v1/other-contacts#search_the_users_other_contacts"
  {:scopes ["https://www.googleapis.com/auth/contacts.other.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://people.googleapis.com/"
     "v1/otherContacts:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
