(ns happygapi.smartdevicemanagement.enterprises
  "Smart Device Management API: enterprises.
  Allow select enterprise partners to access, control, and manage Google and Nest devices programmatically.
  See: https://developers.google.com/nest/device-accessdocs/reference/rest/v1/enterprises"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn structures-list$
  "https://developers.google.com/nest/device-accessapi/reference/rest/v1/enterprises/structures/list
  
  Required parameters: parent
  
  Optional parameters: filter
  
  Lists structures managed by the enterprise."
  {:scopes ["https://www.googleapis.com/auth/sdm.service"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://smartdevicemanagement.googleapis.com/"
     "v1/{+parent}/structures"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn structures-get$
  "https://developers.google.com/nest/device-accessapi/reference/rest/v1/enterprises/structures/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a structure managed by the enterprise."
  {:scopes ["https://www.googleapis.com/auth/sdm.service"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://smartdevicemanagement.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn structures-rooms-get$
  "https://developers.google.com/nest/device-accessapi/reference/rest/v1/enterprises/structures/rooms/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a room managed by the enterprise."
  {:scopes ["https://www.googleapis.com/auth/sdm.service"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://smartdevicemanagement.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn structures-rooms-list$
  "https://developers.google.com/nest/device-accessapi/reference/rest/v1/enterprises/structures/rooms/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists rooms managed by the enterprise."
  {:scopes ["https://www.googleapis.com/auth/sdm.service"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://smartdevicemanagement.googleapis.com/"
     "v1/{+parent}/rooms"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn devices-list$
  "https://developers.google.com/nest/device-accessapi/reference/rest/v1/enterprises/devices/list
  
  Required parameters: parent
  
  Optional parameters: filter
  
  Lists devices managed by the enterprise."
  {:scopes ["https://www.googleapis.com/auth/sdm.service"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://smartdevicemanagement.googleapis.com/"
     "v1/{+parent}/devices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn devices-executeCommand$
  "https://developers.google.com/nest/device-accessapi/reference/rest/v1/enterprises/devices/executeCommand
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:params {}, :command string}
  
  Executes a command to device managed by the enterprise."
  {:scopes ["https://www.googleapis.com/auth/sdm.service"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://smartdevicemanagement.googleapis.com/"
     "v1/{+name}:executeCommand"
     #{:name}
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

(defn devices-get$
  "https://developers.google.com/nest/device-accessapi/reference/rest/v1/enterprises/devices/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a device managed by the enterprise."
  {:scopes ["https://www.googleapis.com/auth/sdm.service"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://smartdevicemanagement.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
