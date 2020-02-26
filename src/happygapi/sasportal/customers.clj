(ns happygapi.sasportal.customers
  "SAS Portal API
  
  See: https://developers.google.com/spectrum-access-system/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "sasportal_schema.edn"))))

(defn get$
  "Required parameters: name
  
  Optional parameters: none
  
  Returns a requested customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}"
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
  
  Optional parameters: pageToken, pageSize
  
  Returns a list of requested customers."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/customers"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates an existing customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates an existing node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Returns a requested node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-move$
  "Required parameters: name
  
  Optional parameters: none
  
  Moves a node under another node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn nodes-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists nodes."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn devices-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets details about a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-updateSigned$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates a signed device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}:updateSigned"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-bulk$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a device under a node or customer. Returned devices are unordered."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:bulk"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn devices-createSigned$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a signed device under a
  node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:createSigned"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn devices-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn devices-move$
  "Required parameters: name
  
  Optional parameters: none
  
  Moves a device under another node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn devices-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-list$
  "Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists devices under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-signDevice$
  "Required parameters: name
  
  Optional parameters: none
  
  Signs a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/{+name}:signDevice"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
