(ns happygapi.mirror.timeline
  "Google Mirror API
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "mirror_schema.edn"))))

(defn delete$
  "Required parameters: id
  
  Optional parameters: none
  
  Deletes a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Gets a single timeline item by ID."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Inserts a new item into the timeline."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: bundleId, includeDeleted, maxResults, orderBy, pageToken, pinnedOnly, sourceItemId
  
  Retrieves a list of timeline items for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Updates a timeline item in place. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Updates a timeline item in place."
  {:scopes ["https://www.googleapis.com/auth/glass.location"
            "https://www.googleapis.com/auth/glass.timeline"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
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
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn attachments-delete$
  "Required parameters: attachmentId, itemId
  
  Optional parameters: none
  
  Deletes an attachment from a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"itemId" "attachmentId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: attachmentId, itemId
  
  Optional parameters: none
  
  Retrieves an attachment on a timeline item by item ID and attachment ID."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"itemId" "attachmentId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Adds a new attachment to a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"itemId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn attachments-list$
  "Required parameters: itemId
  
  Optional parameters: none
  
  Returns a list of attachments for a timeline item."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{"itemId"})
         (json-schema/validate schemas args)]}
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
