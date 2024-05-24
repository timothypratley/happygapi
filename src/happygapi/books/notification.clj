(ns happygapi.books.notification
  "Books API: notification.
  The Google Books API allows clients to access the Google Books repository.
  See: https://code.google.com/apis/books/docs/v1/getting_started.htmldocs/reference/rest/v1/notification"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/notification/get
  
  Required parameters: notification_id
  
  Optional parameters: locale, source
  
  Returns notification details for a given notification id."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:notification_id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/notification/get"
     #{:notification_id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
