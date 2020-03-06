(ns happygapi.books.series
  "Books API: series.
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/series"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/series/get
  
  Required parameters: series_id
  
  Optional parameters: none
  Returns Series metadata for the given series ids."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:series_id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "series/get"
     #{:series_id}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn membership-get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/series/membership/get
  
  Required parameters: series_id
  
  Optional parameters: page_size, page_token
  Returns Series membership data given the series id."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:series_id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "series/membership/get"
     #{:series_id}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
