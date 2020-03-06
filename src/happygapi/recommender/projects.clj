(ns happygapi.recommender.projects
  "Recommender API: projects.
  
  See: https://cloud.google.com/recommender/docs/api/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-recommenders-recommendations-list$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1beta1/projects/locations/recommenders/recommendations/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  Lists recommendations for a Cloud project. Requires the recommender.*.list
  IAM permission for the specified recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1beta1/{+parent}/recommendations"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-recommenders-recommendations-get$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1beta1/projects/locations/recommenders/recommendations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the requested recommendation. Requires the recommender.*.get
  IAM permission for the specified recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-recommenders-recommendations-markClaimed$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1beta1/projects/locations/recommenders/recommendations/markClaimed
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:stateMetadata {}, :etag string}
  
  Marks the Recommendation State as Claimed. Users can use this method to
  indicate to the Recommender API that they are starting to apply the
  recommendation themselves. This stops the recommendation content from being
  updated. Associated insights are frozen and placed in the ACCEPTED state.
  
  MarkRecommendationClaimed can be applied to recommendations in CLAIMED or
  ACTIVE state.
  
  Requires the recommender.*.update IAM permission for the specified
  recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1beta1/{+name}:markClaimed"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-recommenders-recommendations-markSucceeded$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1beta1/projects/locations/recommenders/recommendations/markSucceeded
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:stateMetadata {}, :etag string}
  
  Marks the Recommendation State as Succeeded. Users can use this method to
  indicate to the Recommender API that they have applied the recommendation
  themselves, and the operation was successful. This stops the recommendation
  content from being updated. Associated insights are frozen and placed in
  the ACCEPTED state.
  
  MarkRecommendationSucceeded can be applied to recommendations in ACTIVE,
  CLAIMED, SUCCEEDED, or FAILED state.
  
  Requires the recommender.*.update IAM permission for the specified
  recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1beta1/{+name}:markSucceeded"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-recommenders-recommendations-markFailed$
  "https://cloud.google.com/recommender/docs/api/reference/rest/v1beta1/projects/locations/recommenders/recommendations/markFailed
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:stateMetadata {}, :etag string}
  
  Marks the Recommendation State as Failed. Users can use this method to
  indicate to the Recommender API that they have applied the recommendation
  themselves, and the operation failed. This stops the recommendation content
  from being updated. Associated insights are frozen and placed in the
  ACCEPTED state.
  
  MarkRecommendationFailed can be applied to recommendations in ACTIVE,
  CLAIMED, SUCCEEDED, or FAILED state.
  
  Requires the recommender.*.update IAM permission for the specified
  recommender."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recommender.googleapis.com/"
     "v1beta1/{+name}:markFailed"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
