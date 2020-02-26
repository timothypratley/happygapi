(ns happygapi.tagmanager.accounts
  "Tag Manager API
  This API allows clients to access and modify container and tag
       configuration.
  See: https://developers.google.com/tag-manager"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "tagmanager_schema.edn"))))

(defn list$
  "Required parameters: none
  
  Optional parameters: pageToken
  
  Lists all GTM Accounts that a user has access to."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.manage.accounts"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/accounts"
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
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Account."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.manage.accounts"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a GTM Account."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.accounts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/containers"
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

(defn containers-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.delete.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all Containers that belongs to a GTM Account."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/containers"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-workspaces-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-quick_preview$
  "Required parameters: path
  
  Optional parameters: none
  
  Quick previews a workspace by creating a fake container version from all
  entities in the provided workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:quick_preview"
     #{"path"}
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

(defn containers-workspaces-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/workspaces"
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

(defn containers-workspaces-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-workspaces-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.delete.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-sync$
  "Required parameters: path
  
  Optional parameters: none
  
  Syncs a workspace to the latest container version by updating all
  unmodified workspace entities and displaying conflicts for modified
  entities."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:sync"
     #{"path"}
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

(defn containers-workspaces-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all Workspaces that belong to a GTM Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/workspaces"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-resolve_conflict$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Resolves a merge conflict for a workspace entity by updating it to the
  resolved entity passed in the request."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:resolve_conflict"
     #{"path"}
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

(defn containers-workspaces-getStatus$
  "Required parameters: path
  
  Optional parameters: none
  
  Finds conflicting and modified entities in the workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}/status"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-create_version$
  "Required parameters: path
  
  Optional parameters: none
  
  Creates a Container Version from the entities present in the workspace,
  deletes the workspace, and sets the base container version to the newly
  created version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:create_version"
     #{"path"}
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

(defn containers-workspaces-variables-revert$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Variable in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{"path"}
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

(defn containers-workspaces-variables-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Variable."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-variables-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Variables of a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/variables"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-variables-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a GTM Variable."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/variables"
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

(defn containers-workspaces-variables-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Variable."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-variables-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a GTM Variable."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-workspaces-zones-revert$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Zone in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{"path"}
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

(defn containers-workspaces-zones-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Zone."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-zones-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Zones of a GTM container workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/zones"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-zones-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a GTM Zone."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/zones"
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

(defn containers-workspaces-zones-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Zone."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-zones-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a GTM Zone."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-workspaces-tags-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Tag."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-tags-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a GTM Tag."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-workspaces-tags-revert$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Tag in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{"path"}
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

(defn containers-workspaces-tags-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Tag."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-tags-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Tags of a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/tags"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-tags-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a GTM Tag."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/tags"
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

(defn containers-workspaces-triggers-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a GTM Trigger."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/triggers"
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

(defn containers-workspaces-triggers-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Trigger."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-triggers-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a GTM Trigger."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-workspaces-triggers-revert$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Trigger in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{"path"}
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

(defn containers-workspaces-triggers-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Trigger."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-triggers-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Triggers of a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/triggers"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-folders-revert$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Folder in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{"path"}
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

(defn containers-workspaces-folders-entities$
  "Required parameters: path
  
  Optional parameters: pageToken
  
  List all entities in a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:entities"
     #{"path"}
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

(defn containers-workspaces-folders-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-folders-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Folders of a Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/folders"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-folders-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/folders"
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

(defn containers-workspaces-folders-move_entities_to_folder$
  "Required parameters: path
  
  Optional parameters: tagId, triggerId, variableId
  
  Moves entities to a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:move_entities_to_folder"
     #{"path"}
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

(defn containers-workspaces-folders-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-folders-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a GTM Folder."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-workspaces-built_in_variables-delete$
  "Required parameters: path
  
  Optional parameters: type
  
  Deletes one or more GTM Built-In Variables."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-built_in_variables-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all the enabled Built-In Variables of a GTM Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/built_in_variables"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-built_in_variables-create$
  "Required parameters: parent
  
  Optional parameters: type
  
  Creates one or more GTM Built-In Variables."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/built_in_variables"
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

(defn containers-workspaces-built_in_variables-revert$
  "Required parameters: path
  
  Optional parameters: type
  
  Reverts changes to a GTM Built-In Variables in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}/built_in_variables:revert"
     #{"path"}
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

(defn containers-workspaces-templates-revert$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Reverts changes to a GTM Template in a GTM Workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:revert"
     #{"path"}
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

(defn containers-workspaces-templates-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Template."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-templates-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Templates of a GTM container workspace."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/templates"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-templates-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a GTM Custom Template."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/templates"
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

(defn containers-workspaces-templates-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Template."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-workspaces-templates-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a GTM Template."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-versions-set_latest$
  "Required parameters: path
  
  Optional parameters: none
  
  Sets the latest version used for synchronization of workspaces when
  detecting conflicts and errors."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:set_latest"
     #{"path"}
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

(defn containers-versions-get$
  "Required parameters: path
  
  Optional parameters: containerVersionId
  
  Gets a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.edit.containerversions"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-versions-undelete$
  "Required parameters: path
  
  Optional parameters: none
  
  Undeletes a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:undelete"
     #{"path"}
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

(defn containers-versions-live$
  "Required parameters: parent
  
  Optional parameters: none
  
  Gets the live (i.e. published) container version"
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/versions:live"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-versions-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-versions-publish$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Publishes a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.publish"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:publish"
     #{"path"}
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

(defn containers-versions-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a Container Version."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containerversions"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-environments-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists all GTM Environments of a GTM Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/environments"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-environments-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/environments"
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

(defn containers-environments-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-environments-update$
  "Required parameters: path
  
  Optional parameters: fingerprint
  
  Updates a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn containers-environments-reauthorize$
  "Required parameters: path
  
  Optional parameters: none
  
  Re-generates the authorization code for a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.publish"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}:reauthorize"
     #{"path"}
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

(defn containers-environments-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Deletes a GTM Environment."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-version_headers-list$
  "Required parameters: parent
  
  Optional parameters: includeDeleted, pageToken
  
  Lists all Container Versions of a GTM Container."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.edit.containerversions"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/version_headers"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn containers-version_headers-latest$
  "Required parameters: parent
  
  Optional parameters: none
  
  Gets the latest container version header"
  {:scopes ["https://www.googleapis.com/auth/tagmanager.edit.containers"
            "https://www.googleapis.com/auth/tagmanager.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/version_headers:latest"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn user_permissions-delete$
  "Required parameters: path
  
  Optional parameters: none
  
  Removes a user from the account, revoking access to it and all of its
  containers."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn user_permissions-list$
  "Required parameters: parent
  
  Optional parameters: pageToken
  
  List all users that have access to the account along with Account and
  Container user access granted to each of them."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/user_permissions"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn user_permissions-get$
  "Required parameters: path
  
  Optional parameters: none
  
  Gets a user's Account & Container access."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth args]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn user_permissions-update$
  "Required parameters: path
  
  Optional parameters: none
  
  Updates a user's Account & Container access."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"path"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+path}"
     #{"path"}
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

(defn user_permissions-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a user's Account & Container access."
  {:scopes ["https://www.googleapis.com/auth/tagmanager.manage.users"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/"
     "tagmanager/v2/{+parent}/user_permissions"
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
