(ns happygapi.area120tables.workspaces
  "Area120 Tables API: workspaces.
  
  See: https://support.google.com/area120-tables/answer/10011390docs/reference/rest/v1alpha1/workspaces"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://support.google.com/area120-tables/answer/10011390api/reference/rest/v1alpha1/workspaces/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
  Lists workspaces for the user."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"
            "https://www.googleapis.com/auth/tables"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://area120tables.googleapis.com/"
     "v1alpha1/workspaces"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://support.google.com/area120-tables/answer/10011390api/reference/rest/v1alpha1/workspaces/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a workspace. Returns NOT_FOUND if the workspace does not exist."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/spreadsheets.readonly"
            "https://www.googleapis.com/auth/tables"]}
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
