(ns happygapi.integrations.callback
  "Application Integration API: callback.
  
  See: https://cloud.google.com/application-integrationapi/reference/rest/v1alpha/callback"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generateToken$
  "https://cloud.google.com/application-integrationapi/reference/rest/v1alpha/callback/generateToken
  
  Required parameters: none
  
  Optional parameters: product, gcpProjectId, redirectUri, state, code
  
  Receives the auth code and auth config id to combine that with the client id and secret to retrieve access tokens from the token endpoint. Returns either a success or error message when it's done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1alpha/callback:generateToken"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
