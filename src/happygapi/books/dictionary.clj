(ns happygapi.books.dictionary
  "Books API: dictionary.
  The Google Books API allows clients to access the Google Books repository.
  See: https://code.google.com/apis/books/docs/v1/getting_started.htmldocs/reference/rest/v1/dictionary"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listOfflineMetadata$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/dictionary/listOfflineMetadata
  
  Required parameters: cpksver
  
  Optional parameters: none
  
  Returns a list of offline dictionary metadata available"
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:cpksver})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/dictionary/listOfflineMetadata"
     #{:cpksver}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
