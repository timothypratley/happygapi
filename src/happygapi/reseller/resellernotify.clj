(ns happygapi.reseller.resellernotify
  "Google Workspace Reseller API: resellernotify.
  Perform common functions that are available on the Channel Services console at scale, like placing orders and viewing customer information
  See: https://developers.google.com/google-apps/reseller/api/reference/rest/v1/resellernotify"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/resellernotify/unregister"
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
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/resellernotify/getwatchdetails"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

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
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/resellernotify/register"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
