(ns happygapi.books.familysharing
  "Books API: familysharing.
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/familysharing"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getFamilyInfo$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/familysharing/getFamilyInfo
  
  Required parameters: none
  
  Optional parameters: source
  
  Gets information regarding the family that the user is part of."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "familysharing/getFamilyInfo"
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
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/familysharing/share
  
  Required parameters: none
  
  Optional parameters: docId, source, volumeId
  
  Initiates sharing of the content with the user's family. Empty response indicates success."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "familysharing/share"
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
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/familysharing/unshare
  
  Required parameters: none
  
  Optional parameters: docId, source, volumeId
  
  Initiates revoking content that has already been shared with the user's family. Empty response indicates success."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "familysharing/unshare"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
