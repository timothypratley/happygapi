(ns happygapi.mirror.subscriptions
  "Google Mirror API
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glass"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: id
  
  Deletes a subscription."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "subscriptions/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: none
  
  Creates a new subscription."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "subscriptions"
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

(defn list$
  "Required parameters: none
  
  Retrieves a list of subscriptions for the authenticated user and service."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "subscriptions"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: id
  
  Updates an existing subscription in place."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "subscriptions/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
