(ns happygapi.androidpublisher.orders
  "Google Play Android Developer API: orders.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/orders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn refund$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/orders/refund
  
  Required parameters: packageName, orderId
  
  Optional parameters: revoke
  
  Refunds a user's subscription or in-app purchase order. Orders older than 3 years cannot be refunded."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/orders/{orderId}:refund"
     #{:packageName :orderId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
