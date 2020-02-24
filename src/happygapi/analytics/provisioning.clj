(ns happygapi.analytics.provisioning
  "Google Analytics API
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn createAccountTicket$
  "Required parameters: none
  
  Creates an account ticket."
  {:scopes ["https://www.googleapis.com/auth/analytics.provision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "provisioning/createAccountTicket"
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

(defn createAccountTree$
  "Required parameters: none
  
  Provision account."
  {:scopes ["https://www.googleapis.com/auth/analytics.provision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "provisioning/createAccountTree"
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
