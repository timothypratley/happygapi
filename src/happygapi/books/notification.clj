(ns happygapi.books.notification
  "Books API
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: notification_id
  
  Returns notification details for a given notification id."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{"notification_id"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "notification/get"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
