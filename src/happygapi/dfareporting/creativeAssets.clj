(ns happygapi.dfareporting.creativeAssets
  "DCM/DFA Reporting And Trafficking API
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn insert$
  "Required parameters: advertiserId,profileId
  
  Inserts a new creative asset."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"advertiserId" "profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creativeAssets/{advertiserId}/creativeAssets"
     #{"advertiserId" "profileId"}
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
