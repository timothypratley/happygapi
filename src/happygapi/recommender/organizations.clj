(ns happygapi.recommender.organizations
  "Recommender API: organizations.
  
  See: https://cloud.google.com/recommender/docs/docs/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-recommenders-updateConfig$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/recommenders/updateConfig
  
  Required parameters: name
  
  Optional parameters: validateOnly, updateMask
  
  Body: 
  
  {:displayName string,
   :recommenderGenerationConfig {:params {}},
   :updateTime string,
   :annotations {},
   :name string,
   :etag string,
   :revisionId string}
  
  Updates a Recommender Config. This will create a new revision of the config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://recommender.googleapis.com/"
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

(defn locations-recommenders-getConfig$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/recommenders/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the requested Recommender Config. There is only one instance of the config for each Recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommender.googleapis.com/"
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

(defn locations-recommenders-recommendations-list$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/recommenders/recommendations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists recommendations for the specified Cloud Resource. Requires the recommender.*.list IAM permission for the specified recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1/{+parent}/recommendations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-recommenders-recommendations-markFailed$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/recommenders/recommendations/markFailed
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:etag string, :stateMetadata {}}
  
  Marks the Recommendation State as Failed. Users can use this method to indicate to the Recommender API that they have applied the recommendation themselves, and the operation failed. This stops the recommendation content from being updated. Associated insights are frozen and placed in the ACCEPTED state. MarkRecommendationFailed can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED, or FAILED state. Requires the recommender.*.update IAM permission for the specified recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1/{+name}:markFailed"
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

(defn locations-recommenders-recommendations-get$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/recommenders/recommendations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the requested recommendation. Requires the recommender.*.get IAM permission for the specified recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommender.googleapis.com/"
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

(defn locations-recommenders-recommendations-markSucceeded$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/recommenders/recommendations/markSucceeded
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:etag string, :stateMetadata {}}
  
  Marks the Recommendation State as Succeeded. Users can use this method to indicate to the Recommender API that they have applied the recommendation themselves, and the operation was successful. This stops the recommendation content from being updated. Associated insights are frozen and placed in the ACCEPTED state. MarkRecommendationSucceeded can be applied to recommendations in ACTIVE, CLAIMED, SUCCEEDED, or FAILED state. Requires the recommender.*.update IAM permission for the specified recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1/{+name}:markSucceeded"
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

(defn locations-recommenders-recommendations-markDismissed$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/recommenders/recommendations/markDismissed
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:etag string}
  
  Mark the Recommendation State as Dismissed. Users can use this method to indicate to the Recommender API that an ACTIVE recommendation has to be marked back as DISMISSED. MarkRecommendationDismissed can be applied to recommendations in ACTIVE state. Requires the recommender.*.update IAM permission for the specified recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1/{+name}:markDismissed"
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

(defn locations-recommenders-recommendations-markClaimed$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/recommenders/recommendations/markClaimed
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:etag string, :stateMetadata {}}
  
  Marks the Recommendation State as Claimed. Users can use this method to indicate to the Recommender API that they are starting to apply the recommendation themselves. This stops the recommendation content from being updated. Associated insights are frozen and placed in the ACCEPTED state. MarkRecommendationClaimed can be applied to recommendations in CLAIMED, SUCCEEDED, FAILED, or ACTIVE state. Requires the recommender.*.update IAM permission for the specified recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1/{+name}:markClaimed"
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

(defn locations-insightTypes-getConfig$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/insightTypes/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the requested InsightTypeConfig. There is only one instance of the config for each InsightType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommender.googleapis.com/"
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

(defn locations-insightTypes-updateConfig$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/insightTypes/updateConfig
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:etag string,
   :updateTime string,
   :annotations {},
   :displayName string,
   :insightTypeGenerationConfig {:params {}},
   :revisionId string,
   :name string}
  
  Updates an InsightTypeConfig change. This will create a new revision of the config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://recommender.googleapis.com/"
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

(defn locations-insightTypes-insights-markAccepted$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/insightTypes/insights/markAccepted
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:stateMetadata {}, :etag string}
  
  Marks the Insight State as Accepted. Users can use this method to indicate to the Recommender API that they have applied some action based on the insight. This stops the insight content from being updated. MarkInsightAccepted can be applied to insights in ACTIVE state. Requires the recommender.*.update IAM permission for the specified insight."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1/{+name}:markAccepted"
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

(defn locations-insightTypes-insights-get$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/insightTypes/insights/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the requested insight. Requires the recommender.*.get IAM permission for the specified insight type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommender.googleapis.com/"
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

(defn locations-insightTypes-insights-list$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1/organizations/locations/insightTypes/insights/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists insights for the specified Cloud Resource. Requires the recommender.*.list IAM permission for the specified insight type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1/{+parent}/insights"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
