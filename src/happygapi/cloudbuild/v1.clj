(ns happygapi.cloudbuild.v1
  "Cloud Build API: v1.
  Creates and manages builds on Google Cloud Platform.
  See: https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/webhook
  
  Required parameters: none
  
  Optional parameters: webhookKey
  
  Body: 
  
  {:data string, :extensions [{}], :contentType string}
  
  ReceiveWebhook is called when the API receives a GitHub webhook."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/webhook"
     #{}
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
