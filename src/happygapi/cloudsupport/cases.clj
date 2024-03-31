(ns happygapi.cloudsupport.cases
  "Google Cloud Support API: cases.
  Manages Google Cloud technical support cases for Customer Care support offerings. 
  See: https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/search
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, query
  
  Search for cases using a query. EXAMPLES: cURL: ```shell parent=\"projects/some-project\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$parent/cases:search\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().search( parent=\"projects/some-project\", query=\"state=OPEN\" ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+parent}/cases:search"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Retrieve all cases under a parent, but not its children. For example, listing cases under an organization only returns the cases that are directly parented by that organization. To retrieve cases under an organization and its projects, use `cases.search`. EXAMPLES: cURL: ```shell parent=\"projects/some-project\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$parent/cases\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().list(parent=\"projects/some-project\") print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+parent}/cases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn close$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/close
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Close a case. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43595344\" curl \\ --request POST \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$case:close\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().close( name=\"projects/some-project/cases/43595344\" ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+name}:close"
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

(defn patch$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :timeZone string,
   :creator {:username string,
             :displayName string,
             :email string,
             :googleSupport boolean},
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :classification {:displayName string, :id string},
   :escalated boolean,
   :contactEmail string,
   :updateTime string,
   :languageCode string,
   :priority string,
   :testCase boolean,
   :subscriberEmailAddresses [string]}
  
  Update a case. Only some fields can be updated. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43595344\" curl \\ --request PATCH \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --header \"Content-Type: application/json\" \\ --data '{ \"priority\": \"P1\" }' \\ \"https://cloudsupport.googleapis.com/v2/$case?updateMask=priority\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().patch( name=\"projects/some-project/cases/43112854\", body={ \"displayName\": \"This is Now a New Title\", \"priority\": \"P2\", }, ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+name}"
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

(defn create$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :timeZone string,
   :creator {:username string,
             :displayName string,
             :email string,
             :googleSupport boolean},
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :classification {:displayName string, :id string},
   :escalated boolean,
   :contactEmail string,
   :updateTime string,
   :languageCode string,
   :priority string,
   :testCase boolean,
   :subscriberEmailAddresses [string]}
  
  Create a new case and associate it with a parent. It must have the following fields set: `display_name`, `description`, `classification`, and `priority`. If you're just testing the API and don't want to route your case to an agent, set `testCase=true`. EXAMPLES: cURL: ```shell parent=\"projects/some-project\" curl \\ --request POST \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --header 'Content-Type: application/json' \\ --data '{ \"display_name\": \"Test case created by me.\", \"description\": \"a random test case, feel free to close\", \"classification\": { \"id\": \"100IK2AKCLHMGRJ9CDGMOCGP8DM6UTB4BT262T31BT1M2T31DHNMENPO6KS36CPJ786L2TBFEHGN6NPI64R3CDHN8880G08I1H3MURR7DHII0GRCDTQM8\" }, \"time_zone\": \"-07:00\", \"subscriber_email_addresses\": [ \"foo@domain.com\", \"bar@domain.com\" ], \"testCase\": true, \"priority\": \"P3\" }' \\ \"https://cloudsupport.googleapis.com/v2/$parent/cases\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().create( parent=\"projects/some-project\", body={ \"displayName\": \"A Test Case\", \"description\": \"This is a test case.\", \"testCase\": True, \"priority\": \"P2\", \"classification\": { \"id\": \"100IK2AKCLHMGRJ9CDGMOCGP8DM6UTB4BT262T31BT1M2T31DHNMENPO6KS36CPJ786L2TBFEHGN6NPI64R3CDHN8880G08I1H3MURR7DHII0GRCDTQM8\" }, }, ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+parent}/cases"
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

(defn escalate$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/escalate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:escalation {:justification string, :reason string}}
  
  Escalate a case, starting the Google Cloud Support escalation management process. This operation is only available for some support services. Go to https://cloud.google.com/support and look for 'Technical support escalations' in the feature list to find out which ones let you do that. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43595344\" curl \\ --request POST \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --header \"Content-Type: application/json\" \\ --data '{ \"escalation\": { \"reason\": \"BUSINESS_IMPACT\", \"justification\": \"This is a test escalation.\" } }' \\ \"https://cloudsupport.googleapis.com/v2/$case:escalate\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().escalate( name=\"projects/some-project/cases/43595344\", body={ \"escalation\": { \"reason\": \"BUSINESS_IMPACT\", \"justification\": \"This is a test escalation.\", }, }, ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+name}:escalate"
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

(defn get$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve a case. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/16033687\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$case\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().get( name=\"projects/some-project/cases/43595344\", ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn attachments-list$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/attachments/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List all the attachments associated with a support case. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/23598314\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$case/attachments\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = ( supportApiService.cases() .attachments() .list(parent=\"projects/some-project/cases/43595344\") ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+parent}/attachments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn comments-list$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/comments/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List all the comments associated with a case. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43595344\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$case/comments\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = ( supportApiService.cases() .comments() .list(parent=\"projects/some-project/cases/43595344\") ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+parent}/comments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn comments-create$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/cases/comments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:creator {:username string,
             :displayName string,
             :email string,
             :googleSupport boolean},
   :body string,
   :name string,
   :createTime string,
   :plainTextBody string}
  
  Add a new comment to a case. The comment must have the following fields set: `body`. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43591344\" curl \\ --request POST \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --header 'Content-Type: application/json' \\ --data '{ \"body\": \"This is a test comment.\" }' \\ \"https://cloudsupport.googleapis.com/v2/$case/comments\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = ( supportApiService.cases() .comments() .create( parent=\"projects/some-project/cases/43595344\", body={\"body\": \"This is a test comment.\"}, ) ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/{+parent}/comments"
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
