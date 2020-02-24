(ns happygapi.doubleclicksearch.reports
  "Search Ads 360 API
  Reports and modifies your advertising data in DoubleClick Search (for example, campaigns, ad groups, keywords, and conversions).
  See: https://developers.google.com/doubleclick-search/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn generate$
  "Required parameters: none
  
  Generates and returns a report immediately."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "reports/generate"
     #{}
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

(defn get$
  "Required parameters: reportId
  
  Polls for the status of a report request."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "reports/{reportId}"
     #{"reportId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getFile$
  "Required parameters: reportFragment,reportId
  
  Downloads a report file encoded in UTF-8."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "reportFragment"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "reports/{reportId}/files/{reportFragment}"
     #{"reportId" "reportFragment"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn request$
  "Required parameters: none
  
  Inserts a report request into the reporting system."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "reports"
     #{}
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
