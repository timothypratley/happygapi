(ns happygapi.books.personalizedstream
  "Books API: personalizedstream.
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/personalizedstream"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/personalizedstream/get
  
  Required parameters: none
  
  Optional parameters: locale, maxAllowedMaturityRating, source
  
  Returns a stream of personalized book clusters"
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "personalizedstream/get"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
