(ns happygapi.biglake.projects
  "BigLake API: projects.
  The BigLake API provides access to BigLake Metastore, a serverless, fully managed, and highly available metastore for open-source data that can be used for querying Apache Iceberg tables in BigQuery.
  See: https://cloud.google.com/bigquery/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-catalogs-create$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/create
  
  Required parameters: parent
  
  Optional parameters: catalogId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :deleteTime string,
   :expireTime string}
  
  Creates a new catalog."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+parent}/catalogs"
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

(defn locations-catalogs-delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing catalog specified by the catalog ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-get$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the catalog specified by the resource name."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List all catalogs in a specified project."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+parent}/catalogs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-databases-create$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/create
  
  Required parameters: parent
  
  Optional parameters: databaseId
  
  Body: 
  
  {:hiveOptions {:locationUri string, :parameters {}},
   :name string,
   :createTime string,
   :updateTime string,
   :deleteTime string,
   :expireTime string,
   :type string}
  
  Creates a new database."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+parent}/databases"
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

(defn locations-catalogs-databases-delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing database specified by the database ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-databases-patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:hiveOptions {:locationUri string, :parameters {}},
   :name string,
   :createTime string,
   :updateTime string,
   :deleteTime string,
   :expireTime string,
   :type string}
  
  Updates an existing database specified by the database ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+name}"
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

(defn locations-catalogs-databases-get$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the database specified by the resource name."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-databases-list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List all databases in a specified catalog."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+parent}/databases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-databases-tables-create$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/tables/create
  
  Required parameters: parent
  
  Optional parameters: tableId
  
  Body: 
  
  {:hiveOptions {:parameters {},
                 :tableType string,
                 :storageDescriptor StorageDescriptor},
   :name string,
   :createTime string,
   :updateTime string,
   :deleteTime string,
   :expireTime string,
   :type string,
   :etag string}
  
  Creates a new table."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+parent}/tables"
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

(defn locations-catalogs-databases-tables-delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/tables/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing table specified by the table ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-databases-tables-patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/tables/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:hiveOptions {:parameters {},
                 :tableType string,
                 :storageDescriptor StorageDescriptor},
   :name string,
   :createTime string,
   :updateTime string,
   :deleteTime string,
   :expireTime string,
   :type string,
   :etag string}
  
  Updates an existing table specified by the table ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+name}"
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

(defn locations-catalogs-databases-tables-rename$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/tables/rename
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:newName string}
  
  Renames an existing table specified by the table ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+name}:rename"
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

(defn locations-catalogs-databases-tables-get$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/tables/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the table specified by the resource name."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-databases-tables-list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/catalogs/databases/tables/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  List all tables in a specified database."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://biglake.googleapis.com/"
     "v1/{+parent}/tables"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
