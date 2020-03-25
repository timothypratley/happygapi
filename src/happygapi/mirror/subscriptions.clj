(ns happygapi.mirror.subscriptions
  "Google Mirror API: subscriptions.
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glassapi/reference/rest/v1/subscriptions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/glassapi/reference/rest/v1/subscriptions/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Deletes a subscription."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "subscriptions/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/glassapi/reference/rest/v1/subscriptions/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:userToken string,
   :callbackUrl string,
   :verifyToken string,
   :notification {:collection string,
                  :itemId string,
                  :operation string,
                  :userActions [UserAction],
                  :userToken string,
                  :verifyToken string},
   :updated string,
   :operation [string],
   :id string,
   :kind string,
   :collection string}
  
  Creates a new subscription."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "subscriptions"
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

(defn list$
  "https://developers.google.com/glassapi/reference/rest/v1/subscriptions/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Retrieves a list of subscriptions for the authenticated user and service."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "subscriptions"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/glassapi/reference/rest/v1/subscriptions/update
  
  Required parameters: id
  
  Optional parameters: none
  
  Body: 
  
  {:userToken string,
   :callbackUrl string,
   :verifyToken string,
   :notification {:collection string,
                  :itemId string,
                  :operation string,
                  :userActions [UserAction],
                  :userToken string,
                  :verifyToken string},
   :updated string,
   :operation [string],
   :id string,
   :kind string,
   :collection string}
  
  Updates an existing subscription in place."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "subscriptions/{id}"
     #{:id}
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
