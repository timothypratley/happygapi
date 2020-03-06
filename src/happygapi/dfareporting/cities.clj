(ns happygapi.dfareporting.cities
  "DCM/DFA Reporting And Trafficking API: cities.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/cities"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/cities/list
  
  Required parameters: profileId
  
  Optional parameters: countryDartIds, dartIds, namePrefix, regionDartIds
  Retrieves a list of cities, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/cities"
     #{:profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
