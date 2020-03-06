(ns happygapi.mirror.contacts
  "Google Mirror API: contacts.
  Interacts with Glass users via the timeline.
  See: https://developers.google.com/glassapi/reference/rest/v1/contacts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/glassapi/reference/rest/v1/contacts/delete
  
  Required parameters: id
  
  Optional parameters: none
  Deletes a contact."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "contacts/{id}"
     #{:id}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/glassapi/reference/rest/v1/contacts/get
  
  Required parameters: id
  
  Optional parameters: none
  Gets a single contact by ID."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "contacts/{id}"
     #{:id}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/glassapi/reference/rest/v1/contacts/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :speakableName string,
   :sharingFeatures [string],
   :acceptCommands [{:type string}],
   :type string,
   :source string,
   :acceptTypes [string],
   :imageUrls [string],
   :priority integer,
   :id string,
   :kind string,
   :phoneNumber string}
  
  Inserts a new contact."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "contacts"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/glassapi/reference/rest/v1/contacts/list
  
  Required parameters: none
  
  Optional parameters: none
  Retrieves a list of contacts for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "contacts"
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
  "https://developers.google.com/glassapi/reference/rest/v1/contacts/patch
  
  Required parameters: id
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :speakableName string,
   :sharingFeatures [string],
   :acceptCommands [{:type string}],
   :type string,
   :source string,
   :acceptTypes [string],
   :imageUrls [string],
   :priority integer,
   :id string,
   :kind string,
   :phoneNumber string}
  
  Updates a contact in place. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "contacts/{id}"
     #{:id}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/glassapi/reference/rest/v1/contacts/update
  
  Required parameters: id
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :speakableName string,
   :sharingFeatures [string],
   :acceptCommands [{:type string}],
   :type string,
   :source string,
   :acceptTypes [string],
   :imageUrls [string],
   :priority integer,
   :id string,
   :kind string,
   :phoneNumber string}
  
  Updates a contact in place."
  {:scopes ["https://www.googleapis.com/auth/glass.timeline"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/mirror/v1/"
     "contacts/{id}"
     #{:id}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
