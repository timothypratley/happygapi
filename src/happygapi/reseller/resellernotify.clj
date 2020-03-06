(ns happygapi.reseller.resellernotify
  "Enterprise Apps Reseller API: resellernotify.
  Creates and manages your customers and their subscriptions.
  See: https://developers.google.com/google-apps/reseller/api/reference/rest/v1/resellernotify"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getwatchdetails$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/resellernotify/getwatchdetails
  
  Required parameters: none
  
  Optional parameters: none
  Returns all the details of the watch corresponding to the reseller."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "resellernotify/getwatchdetails"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn register$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/resellernotify/register
  
  Required parameters: none
  
  Optional parameters: serviceAccountEmailAddress
  Registers a Reseller for receiving notifications."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "resellernotify/register"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn unregister$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/resellernotify/unregister
  
  Required parameters: none
  
  Optional parameters: serviceAccountEmailAddress
  Unregisters a Reseller for receiving notifications."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "resellernotify/unregister"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
