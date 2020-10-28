(ns happygapi.reseller.resellernotify
  "Workspace Reseller API: resellernotify.
  Creates and manages your customers and their subscriptions.
  See: https://developers.google.com/google-apps/reseller/api/reference/rest/v1/resellernotify"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn register$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/resellernotify/register
  
  Required parameters: none
  
  Optional parameters: serviceAccountEmailAddress
  
  Registers a Reseller for receiving notifications."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "resellernotify/register"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unregister$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/resellernotify/unregister
  
  Required parameters: none
  
  Optional parameters: serviceAccountEmailAddress
  
  Unregisters a Reseller for receiving notifications."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "resellernotify/unregister"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getwatchdetails$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/resellernotify/getwatchdetails
  
  Required parameters: none
  
  Optional parameters: none
  
  Returns all the details of the watch corresponding to the reseller."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "resellernotify/getwatchdetails"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
