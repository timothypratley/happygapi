(ns happygapi.reseller.resellernotify
  "Enterprise Apps Reseller API
  Creates and manages your customers and their subscriptions.
  See: https://developers.google.com/google-apps/reseller/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn getwatchdetails$
  "Required parameters: none
  
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
  "Required parameters: none
  
  Registers a Reseller for receiving notifications."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
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
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn unregister$
  "Required parameters: none
  
  Unregisters a Reseller for receiving notifications."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
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
      :as :json,
      :content-type :json,
      :body body}
     auth))))
