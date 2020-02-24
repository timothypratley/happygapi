(ns happygapi.books.myconfig
  "Books API
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn getUserSettings$
  "Required parameters: none
  
  Gets the current settings for the user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "myconfig/getUserSettings"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn releaseDownloadAccess$
  "Required parameters: cpksver,volumeIds
  
  Release downloaded content access restriction."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"cpksver" "volumeIds"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "myconfig/releaseDownloadAccess"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn requestAccess$
  "Required parameters: cpksver,nonce,source,volumeId
  
  Request concurrent and download access restrictions."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"cpksver" "volumeId" "source" "nonce"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "myconfig/requestAccess"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn syncVolumeLicenses$
  "Required parameters: cpksver,nonce,source
  
  Request downloaded content access for specified volumes on the My eBooks shelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"cpksver" "source" "nonce"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "myconfig/syncVolumeLicenses"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn updateUserSettings$
  "Required parameters: none
  
  Sets the settings for the user. If a sub-object is specified, it will overwrite the existing sub-object stored in the server. Unspecified sub-objects will retain the existing value."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "myconfig/updateUserSettings"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
