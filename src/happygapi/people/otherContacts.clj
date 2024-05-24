(ns happygapi.people.otherContacts
  "People API: otherContacts.
  Provides access to information about profiles and contacts.
  See: https://developers.google.com/people/docs/reference/rest/v1/otherContacts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/people/api/reference/rest/v1/otherContacts/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize, requestSyncToken, syncToken, readMask, sources
  
  List all \"Other contacts\", that is contacts that are not in a contact group. \"Other contacts\" are typically auto created contacts from interactions. Sync tokens expire 7 days after the full sync. A request with an expired sync token will get an error with an [google.rpc.ErrorInfo](https://cloud.google.com/apis/design/errors#error_info) with reason \"EXPIRED_SYNC_TOKEN\". In the case of such an error clients should make a full sync request without a `sync_token`. The first page of a full sync request has an additional quota. If the quota is exceeded, a 429 error will be returned. This quota is fixed and can not be increased. When the `sync_token` is specified, resources deleted since the last sync will be returned as a person with `PersonMetadata.deleted` set to true. When the `page_token` or `sync_token` is specified, all other request parameters must match the first call. Writes may have a propagation delay of several minutes for sync requests. Incremental syncs are not intended for read-after-write use cases. See example usage at [List the user's other contacts that have changed](/people/v1/other-contacts#list_the_users_other_contacts_that_have_changed)."
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
  
  Copies an \"Other contact\" to a new contact in the user's \"myContacts\" group Mutate requests for the same user should be sent sequentially to avoid increased latency and failures."
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
  
  Optional parameters: query, pageSize, readMask
  
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
