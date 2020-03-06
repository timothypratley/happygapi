(ns happygapi.books.promooffer
  "Books API: promooffer.
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/promooffer"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn accept$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/promooffer/accept
  
  Required parameters: none
  
  Optional parameters: androidId, device, manufacturer, model, offerId, product, serial, volumeId
  "
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "promooffer/accept"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn dismiss$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/promooffer/dismiss
  
  Required parameters: none
  
  Optional parameters: androidId, device, manufacturer, model, offerId, product, serial
  "
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "promooffer/dismiss"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/promooffer/get
  
  Required parameters: none
  
  Optional parameters: androidId, device, manufacturer, model, product, serial
  Returns a list of promo offers available to the user"
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "promooffer/get"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
