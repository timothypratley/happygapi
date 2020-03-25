(ns happygapi.civicinfo.elections
  "Google Civic Information API: elections.
  Provides polling places, early vote locations, contest data, election officials, and government representatives for U.S. residential addresses.
  See: https://developers.google.com/civic-informationapi/reference/rest/v2/elections"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn electionQuery$
  "https://developers.google.com/civic-informationapi/reference/rest/v2/elections/electionQuery
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:contextParams {:clientProfile string}}
  
  List of available elections to query."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/civicinfo/v2/"
     "elections"
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

(defn voterInfoQuery$
  "https://developers.google.com/civic-informationapi/reference/rest/v2/elections/voterInfoQuery
  
  Required parameters: address
  
  Optional parameters: electionId, officialOnly, returnAllAvailableData
  
  Body: 
  
  {:contextParams {:clientProfile string},
   :voterInfoSegmentResult {:generatedMillis string,
                            :postalAddress PostalAddress,
                            :request VoterInfoRequest,
                            :response VoterInfoResponse}}
  
  Looks up information relevant to a voter based on the voter's registered address."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:address})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/civicinfo/v2/"
     "voterinfo"
     #{:address}
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
