(ns happygapi.speech.projects
  "Cloud Speech-to-Text API: projects.
  Converts audio to text by applying powerful neural network models.
  See: https://cloud.google.com/speech-to-text/docs/quickstart-protocoldocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-phraseSets-create$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/phraseSets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:phraseSetId string,
   :phraseSet {:boost number,
               :deleteTime string,
               :kmsKeyVersionName string,
               :displayName string,
               :uid string,
               :name string,
               :etag string,
               :state string,
               :phrases [Phrase],
               :reconciling boolean,
               :kmsKeyName string,
               :annotations {},
               :expireTime string}}
  
  Create a set of phrase hints. Each item in the set can be a single word or a multi-word phrase. The items in the PhraseSet are favored by the recognition model when you send a call that includes the PhraseSet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/{+parent}/phraseSets"
     #{:parent}
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

(defn locations-phraseSets-get$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/phraseSets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a phrase set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://speech.googleapis.com/"
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

(defn locations-phraseSets-list$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/phraseSets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List phrase sets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/{+parent}/phraseSets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-phraseSets-patch$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/phraseSets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:boost number,
   :deleteTime string,
   :kmsKeyVersionName string,
   :displayName string,
   :uid string,
   :name string,
   :etag string,
   :state string,
   :phrases [{:value string, :boost number}],
   :reconciling boolean,
   :kmsKeyName string,
   :annotations {},
   :expireTime string}
  
  Update a phrase set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/{+name}"
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

(defn locations-phraseSets-delete$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/phraseSets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a phrase set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://speech.googleapis.com/"
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

(defn locations-customClasses-create$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/customClasses/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:customClassId string,
   :customClass {:deleteTime string,
                 :kmsKeyVersionName string,
                 :displayName string,
                 :uid string,
                 :name string,
                 :etag string,
                 :state string,
                 :customClassId string,
                 :reconciling boolean,
                 :kmsKeyName string,
                 :annotations {},
                 :expireTime string,
                 :items [ClassItem]}}
  
  Create a custom class."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/{+parent}/customClasses"
     #{:parent}
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

(defn locations-customClasses-get$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/customClasses/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a custom class."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://speech.googleapis.com/"
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

(defn locations-customClasses-list$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/customClasses/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List custom classes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/{+parent}/customClasses"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customClasses-patch$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/customClasses/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:deleteTime string,
   :kmsKeyVersionName string,
   :displayName string,
   :uid string,
   :name string,
   :etag string,
   :state string,
   :customClassId string,
   :reconciling boolean,
   :kmsKeyName string,
   :annotations {},
   :expireTime string,
   :items [{:value string}]}
  
  Update a custom class."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/{+name}"
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

(defn locations-customClasses-delete$
  "https://cloud.google.com/speech-to-text/docs/quickstart-protocolapi/reference/rest/v1/projects/locations/customClasses/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a custom class."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://speech.googleapis.com/"
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
