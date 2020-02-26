(ns happygapi.blogger.blogs
  "Blogger API
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_started"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "blogger_schema.edn"))))

(defn get$
  "Required parameters: blogId
  
  Optional parameters: maxPosts, view
  
  Gets one blog by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"blogId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}"
     #{"blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getByUrl$
  "Required parameters: url
  
  Optional parameters: view
  
  Retrieve a Blog by URL."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"url"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/byurl"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listByUser$
  "Required parameters: userId
  
  Optional parameters: fetchUserInfo, role, status, view
  
  Retrieves a list of blogs, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "users/{userId}/blogs"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
