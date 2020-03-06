(ns happygapi.jobs.projects
  "Cloud Talent Solution API: projects.
  Cloud Talent Solution provides the capability to create, read, update, and delete job postings, as well as search jobs based on keywords and filters.
  
  See: https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn complete$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/complete
  
  Required parameters: name
  
  Optional parameters: languageCodes, scope, companyName, pageSize, query, languageCode, type
  Completes the specified prefix with keyword suggestions.
  Intended for use by a job search auto-complete search box."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}:complete"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn companies-create$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/companies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:company {:imageUri string,
             :keywordSearchableJobCustomAttributes [string],
             :careerSiteUri string,
             :headquartersAddress string,
             :displayName string,
             :name string,
             :eeoText string,
             :derivedInfo CompanyDerivedInfo,
             :suspended boolean,
             :size string,
             :externalId string,
             :hiringAgency boolean,
             :websiteUri string}}
  
  Creates a new company entity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/companies"
     #{:parent}
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

(defn companies-delete$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/companies/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes specified company.
  Prerequisite: The company has no jobs associated with it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn companies-get$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/companies/get
  
  Required parameters: name
  
  Optional parameters: none
  Retrieves specified company."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn companies-patch$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/companies/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :company {:imageUri string,
             :keywordSearchableJobCustomAttributes [string],
             :careerSiteUri string,
             :headquartersAddress string,
             :displayName string,
             :name string,
             :eeoText string,
             :derivedInfo CompanyDerivedInfo,
             :suspended boolean,
             :size string,
             :externalId string,
             :hiringAgency boolean,
             :websiteUri string}}
  
  Updates specified company. Company names can't be updated. To update a
  company name, delete the company and all jobs associated with it, and only
  then re-create them."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{:name}
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

(defn companies-list$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/companies/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, requireOpenJobs
  Lists all companies associated with the service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/companies"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn clientEvents-create$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/clientEvents/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:clientEvent {:jobEvent JobEvent,
                 :requestId string,
                 :createTime string,
                 :parentEventId string,
                 :eventId string,
                 :extraInfo {}}}
  
  Report events issued when end user interacts with customer's application
  that uses Cloud Talent Solution. You may inspect the created events in
  [self service
  tools](https://console.cloud.google.com/talent-solution/overview).
  [Learn
  more](https://cloud.google.com/talent-solution/docs/management-tools)
  about self service tools."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/clientEvents"
     #{:parent}
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

(defn jobs-delete$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/jobs/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes the specified job.
  
  Typically, the job becomes unsearchable within 10 seconds, but it may take
  up to 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-list$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/jobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, jobView, pageToken
  Lists jobs by filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-batchDelete$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/jobs/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string}
  
  Deletes a list of Jobs by filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs:batchDelete"
     #{:parent}
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

(defn jobs-create$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/jobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:job {:processingOptions ProcessingOptions,
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
         :companyName string,
         :employmentTypes [string],
         :visibility string,
         :incentives string,
         :jobLevel string}}
  
  Creates a new job.
  
  Typically, the job becomes searchable within 10 seconds, but it may take
  up to 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs"
     #{:parent}
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

(defn jobs-search$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/jobs/search
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:searchMode string,
   :offset integer,
   :disableKeywordMatch boolean,
   :requestMetadata {:deviceInfo DeviceInfo,
                     :sessionId string,
                     :domain string,
                     :userId string},
   :enableBroadening boolean,
   :histogramFacets {:compensationHistogramFacets [CompensationHistogramRequest],
                     :simpleHistogramFacets [string],
                     :customAttributeHistogramFacets [CustomAttributeHistogramRequest]},
   :diversificationLevel string,
   :pageToken string,
   :pageSize integer,
   :requirePreciseResultSize boolean,
   :jobView string,
   :jobQuery {:companyNames [string],
              :customAttributeFilter string,
              :publishTimeRange TimestampRange,
              :queryLanguageCode string,
              :companyDisplayNames [string],
              :languageCodes [string],
              :compensationFilter CompensationFilter,
              :locationFilters [LocationFilter],
              :disableSpellCheck boolean,
              :jobCategories [string],
              :commuteFilter CommuteFilter,
              :query string,
              :employmentTypes [string]},
   :orderBy string}
  
  Searches for jobs using the provided SearchJobsRequest.
  
  This call constrains the visibility of jobs
  present in the database, and only returns jobs that the caller has
  permission to search against."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs:search"
     #{:parent}
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

(defn jobs-get$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/jobs/get
  
  Required parameters: name
  
  Optional parameters: none
  Retrieves the specified job, whose status is OPEN or recently EXPIRED
  within the last 90 days."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-patch$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/jobs/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:job {:processingOptions ProcessingOptions,
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
         :companyName string,
         :employmentTypes [string],
         :visibility string,
         :incentives string,
         :jobLevel string},
   :updateMask string}
  
  Updates specified job.
  
  Typically, updated contents become visible in search results within 10
  seconds, but it may take up to 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{:name}
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

(defn jobs-searchForAlert$
  "https://cloud.google.com/talent-solution/job-search/docs/api/reference/rest/v3/projects/jobs/searchForAlert
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:searchMode string,
   :offset integer,
   :disableKeywordMatch boolean,
   :requestMetadata {:deviceInfo DeviceInfo,
                     :sessionId string,
                     :domain string,
                     :userId string},
   :enableBroadening boolean,
   :histogramFacets {:compensationHistogramFacets [CompensationHistogramRequest],
                     :simpleHistogramFacets [string],
                     :customAttributeHistogramFacets [CustomAttributeHistogramRequest]},
   :diversificationLevel string,
   :pageToken string,
   :pageSize integer,
   :requirePreciseResultSize boolean,
   :jobView string,
   :jobQuery {:companyNames [string],
              :customAttributeFilter string,
              :publishTimeRange TimestampRange,
              :queryLanguageCode string,
              :companyDisplayNames [string],
              :languageCodes [string],
              :compensationFilter CompensationFilter,
              :locationFilters [LocationFilter],
              :disableSpellCheck boolean,
              :jobCategories [string],
              :commuteFilter CommuteFilter,
              :query string,
              :employmentTypes [string]},
   :orderBy string}
  
  Searches for jobs using the provided SearchJobsRequest.
  
  This API call is intended for the use case of targeting passive job
  seekers (for example, job seekers who have signed up to receive email
  alerts about potential job opportunities), and has different algorithmic
  adjustments that are targeted to passive job seekers.
  
  This call constrains the visibility of jobs
  present in the database, and only returns jobs the caller has
  permission to search against."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs:searchForAlert"
     #{:parent}
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
