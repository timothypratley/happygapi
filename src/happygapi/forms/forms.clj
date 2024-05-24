(ns happygapi.forms.forms
  "Google Forms API: forms.
  Reads and writes Google Forms and responses.
  See: https://developers.google.com/forms/apidocs/reference/rest/v1/forms"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/forms/apiapi/reference/rest/v1/forms/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:formId string,
   :info {:title string, :documentTitle string, :description string},
   :settings {:quizSettings QuizSettings},
   :items [{:description string,
            :imageItem ImageItem,
            :pageBreakItem PageBreakItem,
            :questionItem QuestionItem,
            :title string,
            :textItem TextItem,
            :questionGroupItem QuestionGroupItem,
            :videoItem VideoItem,
            :itemId string}],
   :revisionId string,
   :responderUri string,
   :linkedSheetId string}
  
  Create a new form using the title given in the provided form message in the request. *Important:* Only the form.info.title and form.info.document_title fields are copied to the new form. All other fields including the form description, items and settings are disallowed. To create a new form and add items, you must first call forms.create to create an empty form with a title and (optional) document title, and then call forms.update to add the items."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/forms.body"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://forms.googleapis.com/"
     "v1/forms"
     #{}
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

(defn get$
  "https://developers.google.com/forms/apiapi/reference/rest/v1/forms/get
  
  Required parameters: formId
  
  Optional parameters: none
  
  Get a form."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/forms.body"
            "https://www.googleapis.com/auth/forms.body.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:formId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://forms.googleapis.com/"
     "v1/forms/{formId}"
     #{:formId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn batchUpdate$
  "https://developers.google.com/forms/apiapi/reference/rest/v1/forms/batchUpdate
  
  Required parameters: formId
  
  Optional parameters: none
  
  Body: 
  
  {:includeFormInResponse boolean,
   :requests [{:updateFormInfo UpdateFormInfoRequest,
               :updateSettings UpdateSettingsRequest,
               :createItem CreateItemRequest,
               :moveItem MoveItemRequest,
               :deleteItem DeleteItemRequest,
               :updateItem UpdateItemRequest}],
   :writeControl {:requiredRevisionId string, :targetRevisionId string}}
  
  Change the form with a batch of updates."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/forms.body"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:formId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://forms.googleapis.com/"
     "v1/forms/{formId}:batchUpdate"
     #{:formId}
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

(defn responses-get$
  "https://developers.google.com/forms/apiapi/reference/rest/v1/forms/responses/get
  
  Required parameters: formId, responseId
  
  Optional parameters: none
  
  Get one response from the form."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/forms.responses.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:formId :responseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://forms.googleapis.com/"
     "v1/forms/{formId}/responses/{responseId}"
     #{:formId :responseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn responses-list$
  "https://developers.google.com/forms/apiapi/reference/rest/v1/forms/responses/list
  
  Required parameters: formId
  
  Optional parameters: filter, pageSize, pageToken
  
  List a form's responses."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/forms.responses.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:formId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://forms.googleapis.com/"
     "v1/forms/{formId}/responses"
     #{:formId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn watches-create$
  "https://developers.google.com/forms/apiapi/reference/rest/v1/forms/watches/create
  
  Required parameters: formId
  
  Optional parameters: none
  
  Body: 
  
  {:watch {:id string,
           :target WatchTarget,
           :eventType string,
           :createTime string,
           :expireTime string,
           :errorType string,
           :state string},
   :watchId string}
  
  Create a new watch. If a watch ID is provided, it must be unused. For each invoking project, the per form limit is one watch per Watch.EventType. A watch expires seven days after it is created (see Watch.expire_time)."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/forms.body"
            "https://www.googleapis.com/auth/forms.body.readonly"
            "https://www.googleapis.com/auth/forms.responses.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:formId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://forms.googleapis.com/"
     "v1/forms/{formId}/watches"
     #{:formId}
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

(defn watches-list$
  "https://developers.google.com/forms/apiapi/reference/rest/v1/forms/watches/list
  
  Required parameters: formId
  
  Optional parameters: none
  
  Return a list of the watches owned by the invoking project. The maximum number of watches is two: For each invoker, the limit is one for each event type per form."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/forms.body"
            "https://www.googleapis.com/auth/forms.body.readonly"
            "https://www.googleapis.com/auth/forms.responses.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:formId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://forms.googleapis.com/"
     "v1/forms/{formId}/watches"
     #{:formId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn watches-renew$
  "https://developers.google.com/forms/apiapi/reference/rest/v1/forms/watches/renew
  
  Required parameters: formId, watchId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Renew an existing watch for seven days. The state of the watch after renewal is `ACTIVE`, and the `expire_time` is seven days from the renewal. Renewing a watch in an error state (e.g. `SUSPENDED`) succeeds if the error is no longer present, but fail otherwise. After a watch has expired, RenewWatch returns `NOT_FOUND`."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/forms.body"
            "https://www.googleapis.com/auth/forms.body.readonly"
            "https://www.googleapis.com/auth/forms.responses.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:watchId :formId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://forms.googleapis.com/"
     "v1/forms/{formId}/watches/{watchId}:renew"
     #{:watchId :formId}
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

(defn watches-delete$
  "https://developers.google.com/forms/apiapi/reference/rest/v1/forms/watches/delete
  
  Required parameters: formId, watchId
  
  Optional parameters: none
  
  Delete a watch."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"
            "https://www.googleapis.com/auth/forms.body"
            "https://www.googleapis.com/auth/forms.body.readonly"
            "https://www.googleapis.com/auth/forms.responses.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:watchId :formId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://forms.googleapis.com/"
     "v1/forms/{formId}/watches/{watchId}"
     #{:watchId :formId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
