(ns happygapi.mirror.timeline
  "Google Mirror API
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glass"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: id
  
  Deletes a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: id
  
  Gets a single timeline item by ID."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{id}"
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
  
  Inserts a new item into the timeline."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline"
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
  
  Retrieves a list of timeline items for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: id
  
  Updates a timeline item in place. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{id}"
     #{"id"}
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
  
  Updates a timeline item in place."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn attachments-delete$
  "Required parameters: attachmentId,itemId
  
  Deletes an attachment from a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"itemId" "attachmentId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{itemId}/attachments/{attachmentId}"
     #{"itemId" "attachmentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn attachments-get$
  "Required parameters: attachmentId,itemId
  
  Retrieves an attachment on a timeline item by item ID and attachment ID."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"itemId" "attachmentId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{itemId}/attachments/{attachmentId}"
     #{"itemId" "attachmentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn attachments-insert$
  "Required parameters: itemId
  
  Adds a new attachment to a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"itemId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{itemId}/attachments"
     #{"itemId"}
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

(defn attachments-list$
  "Required parameters: itemId
  
  Returns a list of attachments for a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"itemId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "timeline/{itemId}/attachments"
     #{"itemId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
