(ns happygapi.mybusinessqanda.locations
  "My Business Q&A API: locations.
  The My Business Q&A API allows questions and answers to be posted for specific listings. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/docs/reference/rest/v1/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn questions-list$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/questions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, answersPerQuestion, filter, orderBy
  
  Returns the paginated list of questions and some of its answers for a specified location. This operation is only valid if the specified location is verified."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessqanda.googleapis.com/"
     "v1/{+parent}"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn questions-create$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/questions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :author {:displayName string, :profilePhotoUri string, :type string},
   :upvoteCount integer,
   :text string,
   :createTime string,
   :updateTime string,
   :topAnswers [{:name string,
                 :author Author,
                 :upvoteCount integer,
                 :text string,
                 :createTime string,
                 :updateTime string}],
   :totalAnswerCount integer}
  
  Adds a question for the specified location."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessqanda.googleapis.com/"
     "v1/{+parent}"
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

(defn questions-patch$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/questions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :author {:displayName string, :profilePhotoUri string, :type string},
   :upvoteCount integer,
   :text string,
   :createTime string,
   :updateTime string,
   :topAnswers [{:name string,
                 :author Author,
                 :upvoteCount integer,
                 :text string,
                 :createTime string,
                 :updateTime string}],
   :totalAnswerCount integer}
  
  Updates a specific question written by the current user."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://mybusinessqanda.googleapis.com/"
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

(defn questions-delete$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/questions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a specific question written by the current user."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://mybusinessqanda.googleapis.com/"
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

(defn questions-answers-list$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/questions/answers/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy
  
  Returns the paginated list of answers for a specified question."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessqanda.googleapis.com/"
     "v1/{+parent}/answers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn questions-answers-upsert$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/questions/answers/upsert
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:answer {:name string,
            :author Author,
            :upvoteCount integer,
            :text string,
            :createTime string,
            :updateTime string}}
  
  Creates an answer or updates the existing answer written by the user for the specified question. A user can only create one answer per question."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessqanda.googleapis.com/"
     "v1/{+parent}/answers:upsert"
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

(defn questions-answers-delete$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/questions/answers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the answer written by the current user to a question."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://mybusinessqanda.googleapis.com/"
     "v1/{+name}/answers:delete"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
