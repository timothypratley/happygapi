(ns happygapi.androidpublisher.orders
  "Google Play Developer API: orders.
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/orders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn refund$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/orders/refund
  
  Required parameters: orderId, packageName
  
  Optional parameters: revoke
  
  Refund a user's subscription or in-app purchase order."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/orders/{orderId}:refund"
     #{:packageName :orderId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
