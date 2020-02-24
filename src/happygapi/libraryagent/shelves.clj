(ns happygapi.libraryagent.shelves
  "Library Agent API
  A simple Google Example Library API.
  See: https://cloud.google.com/docs/quota"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: name
  
  Gets a shelf. Returns NOT_FOUND if the shelf does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Lists shelves. The order is unspecified but deterministic. Newly created
  shelves will not necessarily be added to the end of this list."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/shelves"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn books-get$
  "Required parameters: name
  
  Gets a book. Returns NOT_FOUND if the book does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn books-list$
  "Required parameters: parent
  
  Lists books in a shelf. The order is unspecified but deterministic. Newly
  created books will not necessarily be added to the end of this list.
  Returns NOT_FOUND if the shelf does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/{+parent}/books"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn books-return$
  "Required parameters: name
  
  Return a book to the library. Returns the book if it is returned to the
  library successfully.
  Returns error if the book does not belong to the library
  or the users didn't borrow before."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/{+name}:return"
     #{"name"}
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

(defn books-borrow$
  "Required parameters: name
  
  Borrow a book from the library. Returns the book if it is borrowed
  successfully. Returns NOT_FOUND if the book does not exist in the library.
  Returns quota exceeded error if the amount of books borrowed exceeds
  allocation quota in any dimensions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://libraryagent.googleapis.com/"
     "v1/{+name}:borrow"
     #{"name"}
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
