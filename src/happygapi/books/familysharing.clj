(ns happygapi.books.familysharing
  "Books API: familysharing.
  The Google Books API allows clients to access the Google Books repository.
  See: https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/familysharing"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getFamilyInfo$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/familysharing/getFamilyInfo
  
  Required parameters: none
  
  Optional parameters: source
  
  Gets information regarding the family that the user is part of."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/familysharing/getFamilyInfo"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn share$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/familysharing/share
  
  Required parameters: none
  
  Optional parameters: volumeId, source, docId
  
  Initiates sharing of the content with the user's family. Empty response indicates success."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/familysharing/share"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unshare$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/familysharing/unshare
  
  Required parameters: none
  
  Optional parameters: source, volumeId, docId
  
  Initiates revoking content that has already been shared with the user's family. Empty response indicates success."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/familysharing/unshare"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
