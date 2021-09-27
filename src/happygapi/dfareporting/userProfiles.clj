(ns happygapi.dfareporting.userProfiles
  "Campaign Manager 360 API: userProfiles.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userProfiles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userProfiles/get
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Gets one user profile by ID."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"
            "https://www.googleapis.com/auth/dfareporting"
            "https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userProfiles/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Retrieves list of user profiles for a user."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"
            "https://www.googleapis.com/auth/dfareporting"
            "https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
