(ns happygapi.books.myconfig
  "Books API: myconfig.
  Searches for books and manages your Google Books library.
  See: https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/myconfig"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getUserSettings$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/myconfig/getUserSettings
  
  Required parameters: none
  
  Optional parameters: none
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
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/myconfig/releaseDownloadAccess
  
  Required parameters: cpksver, volumeIds
  
  Optional parameters: locale, source
  Release downloaded content access restriction."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:cpksver :volumeIds})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "myconfig/releaseDownloadAccess"
     #{:cpksver :volumeIds}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn requestAccess$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/myconfig/requestAccess
  
  Required parameters: cpksver, nonce, source, volumeId
  
  Optional parameters: licenseTypes, locale
  Request concurrent and download access restrictions."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:volumeId :source :cpksver :nonce})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "myconfig/requestAccess"
     #{:volumeId :source :cpksver :nonce}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn syncVolumeLicenses$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/myconfig/syncVolumeLicenses
  
  Required parameters: cpksver, nonce, source
  
  Optional parameters: features, includeNonComicsSeries, locale, showPreorders, volumeIds
  Request downloaded content access for specified volumes on the My eBooks shelf."
  {:scopes ["https://www.googleapis.com/auth/books"]}
  [auth args]
  {:pre [(util/has-keys? args #{:source :cpksver :nonce})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/books/v1/"
     "myconfig/syncVolumeLicenses"
     #{:source :cpksver :nonce}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateUserSettings$
  "https://developers.google.com/books/docs/v1/getting_startedapi/reference/rest/v1/myconfig/updateUserSettings
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :notesExport {:folderName string, :isEnabled boolean},
   :notification {:matchMyInterests {:opted_state string},
                  :moreFromAuthors {:opted_state string},
                  :moreFromSeries {:opted_state string},
                  :priceDrop {:opted_state string},
                  :rewardExpirations {:opted_state string}}}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
