(ns happygapi.script.scripts
  "Apps Script API: scripts.
  Manages and executes Google Apps Script projects. 
  See: https://developers.google.com/apps-script/api/api/reference/rest/v1/scripts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn run$
  "https://developers.google.com/apps-script/api/api/reference/rest/v1/scripts/run
  
  Required parameters: scriptId
  
  Optional parameters: none
  
  Body: 
  
  {:sessionState string,
   :function string,
   :parameters [any],
   :devMode boolean}
  
  Runs a function in an Apps Script project. The script project must be deployed for use with the Apps Script API and the calling application must share the same Cloud Platform project. This method requires authorization with an OAuth 2.0 token that includes at least one of the scopes listed in the [Authorization](#authorization-scopes) section; script projects that do not require authorization cannot be executed through this API. To find the correct scopes to include in the authentication token, open the script project **Overview** page and scroll down to \"Project OAuth Scopes.\" The error `403, PERMISSION_DENIED: The caller does not have permission` indicates that the Cloud Platform project used to authorize the request is not the same as the one used by the script."
  {:scopes ["https://mail.google.com/"
            "https://www.google.com/calendar/feeds"
            "https://www.google.com/m8/feeds"
            "https://www.googleapis.com/auth/admin.directory.group"
            "https://www.googleapis.com/auth/admin.directory.user"
            "https://www.googleapis.com/auth/documents"
            "https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/forms"
            "https://www.googleapis.com/auth/forms.currentonly"
            "https://www.googleapis.com/auth/groups"
            "https://www.googleapis.com/auth/spreadsheets"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:scriptId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://script.googleapis.com/"
     "v1/scripts/{scriptId}:run"
     #{:scriptId}
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
