(ns happygapi.playcustomapp.accounts
  "Google Play Custom App Publishing API
  An API to publish custom Android apps.
  See: https://developers.google.com/android/work/play/custom-app-api"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn customApps-create$
  "Required parameters: account
  
  Create and publish a new custom app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"account"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/playcustomapp/v1/accounts/"
     "{account}/customApps"
     #{"account"}
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
