(ns happygapi.books.promooffer
  "Books API: promooffer.
  The Google Books API allows clients to access the Google Books repository.
  See: https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/promooffer"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/promooffer/get
  
  Required parameters: none
  
  Optional parameters: device, androidId, manufacturer, product, model, serial
  
  Returns a list of promo offers available to the user"
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/promooffer/get"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dismiss$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/promooffer/dismiss
  
  Required parameters: none
  
  Optional parameters: model, androidId, product, offerId, manufacturer, serial, device
  
  Marks the promo offer as dismissed."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/promooffer/dismiss"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accept$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/promooffer/accept
  
  Required parameters: none
  
  Optional parameters: manufacturer, androidId, volumeId, offerId, product, model, serial, device
  
  Accepts the promo offer."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/promooffer/accept"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
