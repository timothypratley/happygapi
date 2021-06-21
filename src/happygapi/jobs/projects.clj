(ns happygapi.jobs.projects
  "Cloud Talent Solution API: projects.
  Cloud Talent Solution provides the capability to create, read, update, and delete job postings, as well as search jobs based on keywords and filters. 
  See: https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn tenants-get$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves specified tenant."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-completeQuery$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/completeQuery
  
  Required parameters: tenant
  
  Optional parameters: company, scope, query, pageSize, languageCodes, type
  
  Completes the specified prefix with keyword suggestions. Intended for use by a job search auto-complete search box."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:tenant})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+tenant}:completeQuery"
     #{:tenant}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-create$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :externalId string}
  
  Creates a new tenant entity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/tenants"
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

(defn tenants-patch$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :externalId string}
  
  Updates specified tenant."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
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

(defn tenants-list$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all tenants associated with the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/tenants"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-delete$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes specified tenant."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-jobs-get$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified job, whose status is OPEN or recently EXPIRED within the last 90 days."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-jobs-patch$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:processingOptions {:disableStreetAddressResolution boolean,
                       :htmlSanitization string},
   :description string,
   :department string,
   :addresses [string],
   :postingPublishTime string,
   :jobBenefits [string],
   :requisitionId string,
   :degreeTypes [string],
   :postingCreateTime string,
   :name string,
   :customAttributes {},
   :jobEndTime string,
   :derivedInfo {:locations [Location], :jobCategories [string]},
   :responsibilities string,
   :companyDisplayName string,
   :title string,
   :qualifications string,
   :postingExpireTime string,
   :promotionValue integer,
   :languageCode string,
   :postingUpdateTime string,
   :postingRegion string,
   :applicationInfo {:uris [string],
                     :emails [string],
                     :instruction string},
   :jobStartTime string,
   :compensationInfo {:annualizedBaseCompensationRange CompensationRange,
                      :annualizedTotalCompensationRange CompensationRange,
                      :entries [CompensationEntry]},
   :employmentTypes [string],
   :visibility string,
   :company string,
   :incentives string,
   :jobLevel string}
  
  Updates specified job. Typically, updated contents become visible in search results within 10 seconds, but it may take up to 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
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

(defn tenants-jobs-batchUpdate$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:jobs [{:processingOptions ProcessingOptions,
           :description string,
           :department string,
           :addresses [string],
           :postingPublishTime string,
           :jobBenefits [string],
           :requisitionId string,
           :degreeTypes [string],
           :postingCreateTime string,
           :name string,
           :customAttributes {},
           :jobEndTime string,
           :derivedInfo JobDerivedInfo,
           :responsibilities string,
           :companyDisplayName string,
           :title string,
           :qualifications string,
           :postingExpireTime string,
           :promotionValue integer,
           :languageCode string,
           :postingUpdateTime string,
           :postingRegion string,
           :applicationInfo ApplicationInfo,
           :jobStartTime string,
           :compensationInfo CompensationInfo,
           :employmentTypes [string],
           :visibility string,
           :company string,
           :incentives string,
           :jobLevel string}],
   :updateMask string}
  
  Begins executing a batch update jobs operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/jobs:batchUpdate"
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

(defn tenants-jobs-create$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:processingOptions {:disableStreetAddressResolution boolean,
                       :htmlSanitization string},
   :description string,
   :department string,
   :addresses [string],
   :postingPublishTime string,
   :jobBenefits [string],
   :requisitionId string,
   :degreeTypes [string],
   :postingCreateTime string,
   :name string,
   :customAttributes {},
   :jobEndTime string,
   :derivedInfo {:locations [Location], :jobCategories [string]},
   :responsibilities string,
   :companyDisplayName string,
   :title string,
   :qualifications string,
   :postingExpireTime string,
   :promotionValue integer,
   :languageCode string,
   :postingUpdateTime string,
   :postingRegion string,
   :applicationInfo {:uris [string],
                     :emails [string],
                     :instruction string},
   :jobStartTime string,
   :compensationInfo {:annualizedBaseCompensationRange CompensationRange,
                      :annualizedTotalCompensationRange CompensationRange,
                      :entries [CompensationEntry]},
   :employmentTypes [string],
   :visibility string,
   :company string,
   :incentives string,
   :jobLevel string}
  
  Creates a new job. Typically, the job becomes searchable within 10 seconds, but it may take up to 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/jobs"
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

(defn tenants-jobs-batchCreate$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:jobs [{:processingOptions ProcessingOptions,
           :description string,
           :department string,
           :addresses [string],
           :postingPublishTime string,
           :jobBenefits [string],
           :requisitionId string,
           :degreeTypes [string],
           :postingCreateTime string,
           :name string,
           :customAttributes {},
           :jobEndTime string,
           :derivedInfo JobDerivedInfo,
           :responsibilities string,
           :companyDisplayName string,
           :title string,
           :qualifications string,
           :postingExpireTime string,
           :promotionValue integer,
           :languageCode string,
           :postingUpdateTime string,
           :postingRegion string,
           :applicationInfo ApplicationInfo,
           :jobStartTime string,
           :compensationInfo CompensationInfo,
           :employmentTypes [string],
           :visibility string,
           :company string,
           :incentives string,
           :jobLevel string}]}
  
  Begins executing a batch create jobs operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/jobs:batchCreate"
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

(defn tenants-jobs-delete$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified job. Typically, the job becomes unsearchable within 10 seconds, but it may take up to 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-jobs-search$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/search
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:customRankingInfo {:rankingExpression string,
                       :importanceLevel string},
   :searchMode string,
   :maxPageSize integer,
   :offset integer,
   :disableKeywordMatch boolean,
   :histogramQueries [{:histogramQuery string}],
   :requestMetadata {:sessionId string,
                     :userId string,
                     :deviceInfo DeviceInfo,
                     :domain string,
                     :allowMissingIds boolean},
   :enableBroadening boolean,
   :diversificationLevel string,
   :pageToken string,
   :jobView string,
   :jobQuery {:customAttributeFilter string,
              :publishTimeRange TimestampRange,
              :queryLanguageCode string,
              :companyDisplayNames [string],
              :languageCodes [string],
              :compensationFilter CompensationFilter,
              :locationFilters [LocationFilter],
              :disableSpellCheck boolean,
              :jobCategories [string],
              :companies [string],
              :commuteFilter CommuteFilter,
              :excludedJobs [string],
              :query string,
              :employmentTypes [string]},
   :orderBy string}
  
  Searches for jobs using the provided SearchJobsRequest. This call constrains the visibility of jobs present in the database, and only returns jobs that the caller has permission to search against."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/jobs:search"
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

(defn tenants-jobs-batchDelete$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Begins executing a batch delete jobs operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/jobs:batchDelete"
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

(defn tenants-jobs-list$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, jobView, filter, pageSize
  
  Lists jobs by filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/jobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-jobs-searchForAlert$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/jobs/searchForAlert
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:customRankingInfo {:rankingExpression string,
                       :importanceLevel string},
   :searchMode string,
   :maxPageSize integer,
   :offset integer,
   :disableKeywordMatch boolean,
   :histogramQueries [{:histogramQuery string}],
   :requestMetadata {:sessionId string,
                     :userId string,
                     :deviceInfo DeviceInfo,
                     :domain string,
                     :allowMissingIds boolean},
   :enableBroadening boolean,
   :diversificationLevel string,
   :pageToken string,
   :jobView string,
   :jobQuery {:customAttributeFilter string,
              :publishTimeRange TimestampRange,
              :queryLanguageCode string,
              :companyDisplayNames [string],
              :languageCodes [string],
              :compensationFilter CompensationFilter,
              :locationFilters [LocationFilter],
              :disableSpellCheck boolean,
              :jobCategories [string],
              :companies [string],
              :commuteFilter CommuteFilter,
              :excludedJobs [string],
              :query string,
              :employmentTypes [string]},
   :orderBy string}
  
  Searches for jobs using the provided SearchJobsRequest. This API call is intended for the use case of targeting passive job seekers (for example, job seekers who have signed up to receive email alerts about potential job opportunities), it has different algorithmic adjustments that are designed to specifically target passive job seekers. This call constrains the visibility of jobs present in the database, and only returns jobs the caller has permission to search against."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/jobs:searchForAlert"
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

(defn tenants-clientEvents-create$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/clientEvents/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:eventNotes string,
   :eventId string,
   :requestId string,
   :createTime string,
   :jobEvent {:type string, :jobs [string]}}
  
  Report events issued when end user interacts with customer's application that uses Cloud Talent Solution. You may inspect the created events in [self service tools](https://console.cloud.google.com/talent-solution/overview). [Learn more](https://cloud.google.com/talent-solution/docs/management-tools) about self service tools."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/clientEvents"
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

(defn tenants-companies-patch$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/companies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:imageUri string,
   :keywordSearchableJobCustomAttributes [string],
   :careerSiteUri string,
   :headquartersAddress string,
   :displayName string,
   :name string,
   :eeoText string,
   :derivedInfo {:headquartersLocation Location},
   :suspended boolean,
   :size string,
   :externalId string,
   :hiringAgency boolean,
   :websiteUri string}
  
  Updates specified company."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
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

(defn tenants-companies-delete$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/companies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes specified company. Prerequisite: The company has no jobs associated with it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-companies-list$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/companies/list
  
  Required parameters: parent
  
  Optional parameters: requireOpenJobs, pageToken, pageSize
  
  Lists all companies associated with the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/companies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-companies-get$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/companies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves specified company."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tenants-companies-create$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/tenants/companies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:imageUri string,
   :keywordSearchableJobCustomAttributes [string],
   :careerSiteUri string,
   :headquartersAddress string,
   :displayName string,
   :name string,
   :eeoText string,
   :derivedInfo {:headquartersLocation Location},
   :suspended boolean,
   :size string,
   :externalId string,
   :hiringAgency boolean,
   :websiteUri string}
  
  Creates a new company entity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+parent}/companies"
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

(defn operations-get$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v4/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v4/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
