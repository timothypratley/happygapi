(ns happygapi.dfareporting.conversions
  "DCM/DFA Reporting And Trafficking API
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn batchinsert$
  "Required parameters: profileId
  
  Inserts conversions."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/conversions/batchinsert"
     #{"profileId"}
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

(defn batchupdate$
  "Required parameters: profileId
  
  Updates existing conversions."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/conversions/batchupdate"
     #{"profileId"}
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
