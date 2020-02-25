(ns happygapi.jobs.projects
  "Cloud Talent Solution API
  Cloud Talent Solution provides the capability to create, read, update, and delete job postings, as well as search jobs based on keywords and filters.
  
  See: https://cloud.google.com/talent-solution/job-search/docs/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "jobs_schema.edn"))))

(defn complete$
  "Required parameters: name
  
  Optional parameters: companyName, scope, pageSize, query, languageCode, type, languageCodes
  
  Completes the specified prefix with keyword suggestions.
  Intended for use by a job search auto-complete search box."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}:complete"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn companies-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes specified company.
  Prerequisite: The company has no jobs associated with it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn companies-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves specified company."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn companies-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates specified company. Company names can't be updated. To update a
  company name, delete the company and all jobs associated with it, and only
  then re-create them."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn companies-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize, requireOpenJobs
  
  Lists all companies associated with the service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/companies"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn companies-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new company entity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/companies"
     #{"parent"}
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

(defn clientEvents-create$
  "Required parameters: parent
  
  Optional parameters: none
  
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
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/clientEvents"
     #{"parent"}
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

(defn jobs-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified job.
  
  Typically, the job becomes unsearchable within 10 seconds, but it may take
  up to 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-list$
  "Required parameters: parent
  
  Optional parameters: pageSize, filter, jobView, pageToken
  
  Lists jobs by filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-batchDelete$
  "Required parameters: parent
  
  Optional parameters: none
  
  Deletes a list of Jobs by filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs:batchDelete"
     #{"parent"}
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

(defn jobs-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new job.
  
  Typically, the job becomes searchable within 10 seconds, but it may take
  up to 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs"
     #{"parent"}
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

(defn jobs-search$
  "Required parameters: parent
  
  Optional parameters: none
  
  Searches for jobs using the provided SearchJobsRequest.
  
  This call constrains the visibility of jobs
  present in the database, and only returns jobs that the caller has
  permission to search against."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs:search"
     #{"parent"}
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

(defn jobs-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified job, whose status is OPEN or recently EXPIRED
  within the last 90 days."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates specified job.
  
  Typically, updated contents become visible in search results within 10
  seconds, but it may take up to 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/jobs"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-searchForAlert$
  "Required parameters: parent
  
  Optional parameters: none
  
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
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://jobs.googleapis.com/"
     "v3/{+parent}/jobs:searchForAlert"
     #{"parent"}
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
