(ns happygapi.area120tables.tables
  "Area120 Tables API: tables.
  
  See: https://tables.area120.google.comapi/reference/rest/v1alpha1/tables"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://tables.area120.google.comapi/reference/rest/v1alpha1/tables/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a table. Returns NOT_FOUND if the table does not exist."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://tables.area120.google.comapi/reference/rest/v1alpha1/tables/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
  Lists tables for the user."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/tables"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rows-list$
  "https://tables.area120.google.comapi/reference/rest/v1alpha1/tables/rows/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  Lists rows in a table. Returns NOT_FOUND if the table does not exist."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+parent}/rows"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rows-create$
  "https://tables.area120.google.comapi/reference/rest/v1alpha1/tables/rows/create
  
  Required parameters: parent
  
  Optional parameters: view
  
  Body: 
  
  {:values {}, :name string}
  
  Creates a row."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+parent}/rows"
     #{:parent}
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

(defn rows-patch$
  "https://tables.area120.google.comapi/reference/rest/v1alpha1/tables/rows/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, view
  
  Body: 
  
  {:values {}, :name string}
  
  Updates a row."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
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

(defn rows-batchCreate$
  "https://tables.area120.google.comapi/reference/rest/v1alpha1/tables/rows/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:view string, :parent string, :row Row}]}
  
  Creates multiple rows."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+parent}/rows:batchCreate"
     #{:parent}
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

(defn rows-batchUpdate$
  "https://tables.area120.google.comapi/reference/rest/v1alpha1/tables/rows/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:view string, :row Row, :updateMask string}]}
  
  Updates multiple rows."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+parent}/rows:batchUpdate"
     #{:parent}
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

(defn rows-delete$
  "https://tables.area120.google.comapi/reference/rest/v1alpha1/tables/rows/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a row."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/spreadsheets"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rows-get$
  "https://tables.area120.google.comapi/reference/rest/v1alpha1/tables/rows/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets a row. Returns NOT_FOUND if the row does not exist in the table."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
