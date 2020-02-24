(ns happygapi.books.series
  "Books API
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: series_id
  
  Returns Series metadata for the given series ids."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"series_id"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "series/get"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn membership-get$
  "Required parameters: series_id
  
  Returns Series membership data given the series id."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"series_id"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "series/membership/get"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
