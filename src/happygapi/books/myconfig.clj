(ns happygapi.books.myconfig
  "Books API: myconfig.
  The Google Books API allows clients to access the Google Books repository.
  See: https://code.google.com/apis/books/docs/v1/getting_started.htmldocs/reference/rest/v1/myconfig"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getUserSettings$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/myconfig/getUserSettings
  
  Required parameters: none
  
  Optional parameters: country
  
  Gets the current settings for the user."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/myconfig/getUserSettings"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn releaseDownloadAccess$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/myconfig/releaseDownloadAccess
  
  Required parameters: cpksver, volumeIds
  
  Optional parameters: locale, source
  
  Release downloaded content access restriction."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:cpksver :volumeIds})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/myconfig/releaseDownloadAccess"
     #{:cpksver :volumeIds}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn requestAccess$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/myconfig/requestAccess
  
  Required parameters: cpksver, nonce, source, volumeId
  
  Optional parameters: licenseTypes, locale
  
  Request concurrent and download access restrictions."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:volumeId :source :cpksver :nonce})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/myconfig/requestAccess"
     #{:volumeId :source :cpksver :nonce}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn syncVolumeLicenses$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/myconfig/syncVolumeLicenses
  
  Required parameters: cpksver, nonce, source
  
  Optional parameters: features, includeNonComicsSeries, locale, showPreorders, volumeIds
  
  Request downloaded content access for specified volumes on the My eBooks shelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:source :cpksver :nonce})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/myconfig/syncVolumeLicenses"
     #{:source :cpksver :nonce}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateUserSettings$
  "https://code.google.com/apis/books/docs/v1/getting_started.htmlapi/reference/rest/v1/myconfig/updateUserSettings
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :notification {:moreFromAuthors {:opted_state string},
                  :moreFromSeries {:opted_state string},
                  :rewardExpirations {:opted_state string},
                  :priceDrop {:opted_state string},
                  :matchMyInterests {:opted_state string}},
   :notesExport {:isEnabled boolean, :folderName string}}
  
  Sets the settings for the user. If a sub-object is specified, it will overwrite the existing sub-object stored in the server. Unspecified sub-objects will retain the existing value."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://books.googleapis.com/"
     "books/v1/myconfig/updateUserSettings"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
