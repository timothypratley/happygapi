(ns happygapi.dfareporting.accountActiveAdSummaries
  "Campaign Manager 360 API: accountActiveAdSummaries.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/accountActiveAdSummaries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/accountActiveAdSummaries/get
  
  Required parameters: profileId, summaryAccountId
  
  Optional parameters: none
  
  Gets the account's active ad summary by account ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:summaryAccountId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/accountActiveAdSummaries/{+summaryAccountId}"
     #{:summaryAccountId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
