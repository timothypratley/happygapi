(ns happygapi.displayvideo.customBiddingAlgorithms
  "Display & Video 360 API: customBiddingAlgorithms.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/customBiddingAlgorithms"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn uploadRules$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/uploadRules
  
  Required parameters: customBiddingAlgorithmId
  
  Optional parameters: partnerId, advertiserId
  
  Creates a rules reference object for an AlgorithmRules file. The resulting reference object provides a resource path where the AlgorithmRules file should be uploaded. This reference object should be included when creating a new CustomBiddingAlgorithmRules resource."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customBiddingAlgorithmId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}:uploadRules"
     #{:customBiddingAlgorithmId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/get
  
  Required parameters: customBiddingAlgorithmId
  
  Optional parameters: partnerId, advertiserId
  
  Gets a custom bidding algorithm."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customBiddingAlgorithmId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}"
     #{:customBiddingAlgorithmId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/list
  
  Required parameters: none
  
  Optional parameters: partnerId, advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists custom bidding algorithms that are accessible to the current user and can be used in bidding stratgies. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:customBiddingAlgorithmType string,
   :customBiddingAlgorithmId string,
   :displayName string,
   :name string,
   :sharedAdvertiserIds [string],
   :advertiserId string,
   :modelDetails [{:advertiserId string,
                   :readinessState string,
                   :suspensionState string}],
   :partnerId string,
   :entityStatus string}
  
  Creates a new custom bidding algorithm. Returns the newly created custom bidding algorithm if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms"
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

(defn patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/patch
  
  Required parameters: customBiddingAlgorithmId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:customBiddingAlgorithmType string,
   :customBiddingAlgorithmId string,
   :displayName string,
   :name string,
   :sharedAdvertiserIds [string],
   :advertiserId string,
   :modelDetails [{:advertiserId string,
                   :readinessState string,
                   :suspensionState string}],
   :partnerId string,
   :entityStatus string}
  
  Updates an existing custom bidding algorithm. Returns the updated custom bidding algorithm if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customBiddingAlgorithmId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}"
     #{:customBiddingAlgorithmId}
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

(defn uploadScript$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/uploadScript
  
  Required parameters: customBiddingAlgorithmId
  
  Optional parameters: partnerId, advertiserId
  
  Creates a custom bidding script reference object for a script file. The resulting reference object provides a resource path to which the script file should be uploaded. This reference object should be included in when creating a new custom bidding script object."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customBiddingAlgorithmId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}:uploadScript"
     #{:customBiddingAlgorithmId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rules-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/rules/create
  
  Required parameters: customBiddingAlgorithmId
  
  Optional parameters: partnerId, advertiserId
  
  Body: 
  
  {:name string,
   :customBiddingAlgorithmId string,
   :customBiddingAlgorithmRulesId string,
   :createTime string,
   :active boolean,
   :state string,
   :error {:errorCode string},
   :rules {:resourceName string}}
  
  Creates a new rules resource. Returns the newly created rules resource if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customBiddingAlgorithmId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/rules"
     #{:customBiddingAlgorithmId}
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

(defn rules-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/rules/get
  
  Required parameters: customBiddingAlgorithmId, customBiddingAlgorithmRulesId
  
  Optional parameters: partnerId, advertiserId
  
  Retrieves a rules resource."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:customBiddingAlgorithmId :customBiddingAlgorithmRulesId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/rules/{+customBiddingAlgorithmRulesId}"
     #{:customBiddingAlgorithmId :customBiddingAlgorithmRulesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rules-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/rules/list
  
  Required parameters: customBiddingAlgorithmId
  
  Optional parameters: partnerId, advertiserId, pageSize, pageToken, orderBy
  
  Lists rules resources that belong to the given algorithm. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customBiddingAlgorithmId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/rules"
     #{:customBiddingAlgorithmId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scripts-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/scripts/create
  
  Required parameters: customBiddingAlgorithmId
  
  Optional parameters: partnerId, advertiserId
  
  Body: 
  
  {:name string,
   :customBiddingAlgorithmId string,
   :customBiddingScriptId string,
   :createTime string,
   :active boolean,
   :state string,
   :errors [{:errorCode string,
             :line string,
             :column string,
             :errorMessage string}],
   :script {:resourceName string}}
  
  Creates a new custom bidding script. Returns the newly created script if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customBiddingAlgorithmId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/scripts"
     #{:customBiddingAlgorithmId}
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

(defn scripts-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/scripts/get
  
  Required parameters: customBiddingAlgorithmId, customBiddingScriptId
  
  Optional parameters: partnerId, advertiserId
  
  Gets a custom bidding script."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:customBiddingScriptId :customBiddingAlgorithmId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/scripts/{+customBiddingScriptId}"
     #{:customBiddingScriptId :customBiddingAlgorithmId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scripts-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/customBiddingAlgorithms/scripts/list
  
  Required parameters: customBiddingAlgorithmId
  
  Optional parameters: partnerId, advertiserId, pageSize, pageToken, orderBy
  
  Lists custom bidding scripts that belong to the given algorithm. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customBiddingAlgorithmId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/scripts"
     #{:customBiddingAlgorithmId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
