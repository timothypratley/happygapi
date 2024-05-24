(ns happygapi.aiplatform.publishers
  "Vertex AI API: publishers.
  Train high-quality custom machine learning models with minimal machine learning expertise and effort.
  See: https://cloud.google.com/vertex-ai/docs/reference/rest/v1/publishers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn models-get$
  "https://cloud.google.com/vertex-ai/api/reference/rest/v1/publishers/models/get
  
  Required parameters: name
  
  Optional parameters: languageCode, view
  
  Gets a Model Garden publisher model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://aiplatform.googleapis.com/"
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
