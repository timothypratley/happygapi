(ns happy.all
  (:require [happy.util :as util]
            [clj-http.client :as http]))

#_(defn request' [method url parameters]
  (http/request (merge-with merge
                            {:method       method
                             :url          url
                             :query-params parameters
                             :accept       :json
                             :as           :json}
                            (auth!))))

;; TODO: does every call that has nextPageToken have items?
;; TODO: what should the interface be? basically we want to add a parameter to a call
#_(defn all [req]
  (let [url (util/get-url base-url path params args)]
    (loop [acc []
           {:keys [nextPageToken items]} (http/request req)]
      (let [all-items (into acc items)]
        (if nextPageToken
          ;; TODO: update url
          (recur all-items (http/request (assoc req :nextPageToken nextPageToken)))
          all-items)))))

#_(defn all2 []
  (util/get-response



    (~(symbol "http" (str/lower-case ?httpMethod))
      (util/get-url ?base-url ?path ~(set !required-parameters) parameters)
      (merge-with merge
                  {:throw-exceptions false
                   :query-params     parameters
                   :accept           :json
                   :as               :json
                   &                 ~(when ?request
                                        '{:content-type :json
                                          :body         (json/generate-string body)})}
                  auth))))
