(ns happygapi.playdeveloperreporting.vitals
  "Google Play Developer Reporting API: vitals.
  
  See: https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn stuckbackgroundwakelockrate-query$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/stuckbackgroundwakelockrate/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:timelineSpec {:startTime GoogleTypeDateTime,
                  :aggregationPeriod string,
                  :endTime GoogleTypeDateTime},
   :dimensions [string],
   :pageToken string,
   :filter string,
   :pageSize integer,
   :metrics [string],
   :userCohort string}
  
  Queries the metrics in the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}:query"
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

(defn stuckbackgroundwakelockrate-get$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/stuckbackgroundwakelockrate/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Describes the properties of the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn errors-issues-search$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/errors/issues/search
  
  Required parameters: parent
  
  Optional parameters: interval.startTime.nanos, interval.startTime.day, interval.startTime.seconds, interval.endTime.seconds, interval.startTime.year, interval.startTime.utcOffset, interval.endTime.day, interval.endTime.nanos, interval.endTime.minutes, interval.endTime.hours, pageToken, interval.endTime.timeZone.version, interval.endTime.utcOffset, interval.startTime.month, sampleErrorReportLimit, interval.startTime.hours, filter, pageSize, interval.startTime.minutes, interval.endTime.year, interval.startTime.timeZone.id, interval.endTime.timeZone.id, interval.endTime.month, orderBy, interval.startTime.timeZone.version
  
  Searches all error issues in which reports have been grouped."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+parent}/errorIssues:search"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn errors-counts-query$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/errors/counts/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:timelineSpec {:startTime GoogleTypeDateTime,
                  :aggregationPeriod string,
                  :endTime GoogleTypeDateTime},
   :pageSize integer,
   :dimensions [string],
   :pageToken string,
   :metrics [string],
   :filter string}
  
  Queries the metrics in the metrics set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}:query"
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

(defn errors-counts-get$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/errors/counts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Describes the properties of the metrics set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn errors-reports-search$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/errors/reports/search
  
  Required parameters: parent
  
  Optional parameters: interval.startTime.nanos, interval.startTime.day, interval.startTime.seconds, interval.endTime.seconds, interval.startTime.year, interval.startTime.utcOffset, interval.endTime.day, interval.endTime.nanos, interval.endTime.minutes, interval.endTime.hours, pageToken, interval.endTime.timeZone.version, interval.endTime.utcOffset, interval.startTime.month, interval.startTime.hours, filter, pageSize, interval.startTime.minutes, interval.endTime.year, interval.startTime.timeZone.id, interval.endTime.timeZone.id, interval.endTime.month, interval.startTime.timeZone.version
  
  Searches all error reports received for an app."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+parent}/errorReports:search"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn slowrenderingrate-get$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/slowrenderingrate/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Describes the properties of the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn slowrenderingrate-query$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/slowrenderingrate/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:timelineSpec {:startTime GoogleTypeDateTime,
                  :aggregationPeriod string,
                  :endTime GoogleTypeDateTime},
   :dimensions [string],
   :pageToken string,
   :filter string,
   :metrics [string],
   :userCohort string,
   :pageSize integer}
  
  Queries the metrics in the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}:query"
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

(defn slowstartrate-query$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/slowstartrate/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:metrics [string],
   :pageToken string,
   :userCohort string,
   :filter string,
   :dimensions [string],
   :timelineSpec {:startTime GoogleTypeDateTime,
                  :aggregationPeriod string,
                  :endTime GoogleTypeDateTime},
   :pageSize integer}
  
  Queries the metrics in the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}:query"
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

(defn slowstartrate-get$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/slowstartrate/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Describes the properties of the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn excessivewakeuprate-query$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/excessivewakeuprate/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string,
   :pageSize integer,
   :metrics [string],
   :filter string,
   :userCohort string,
   :dimensions [string],
   :timelineSpec {:startTime GoogleTypeDateTime,
                  :aggregationPeriod string,
                  :endTime GoogleTypeDateTime}}
  
  Queries the metrics in the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}:query"
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

(defn excessivewakeuprate-get$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/excessivewakeuprate/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Describes the properties of the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn anrrate-query$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/anrrate/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:userCohort string,
   :dimensions [string],
   :timelineSpec {:startTime GoogleTypeDateTime,
                  :aggregationPeriod string,
                  :endTime GoogleTypeDateTime},
   :filter string,
   :metrics [string],
   :pageToken string,
   :pageSize integer}
  
  Queries the metrics in the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}:query"
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

(defn anrrate-get$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/anrrate/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Describes the properties of the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn crashrate-query$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/crashrate/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:filter string,
   :dimensions [string],
   :metrics [string],
   :userCohort string,
   :pageSize integer,
   :timelineSpec {:startTime GoogleTypeDateTime,
                  :aggregationPeriod string,
                  :endTime GoogleTypeDateTime},
   :pageToken string}
  
  Queries the metrics in the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}:query"
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

(defn crashrate-get$
  "https://developers.google.com/play/developer/reportingapi/reference/rest/v1beta1/vitals/crashrate/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Describes the properties of the metric set."
  {:scopes ["https://www.googleapis.com/auth/playdeveloperreporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://playdeveloperreporting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
