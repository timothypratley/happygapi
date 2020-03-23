(ns happy.oauth2-capture-redirect-test
  (:require [clojure.test :refer [deftest is testing]]
            [happy.oauth2-capture-redirect :as r]
            [clj-http.client :as http]))

(deftest wait-for-redirect-test
  (-> (fn []
        (Thread/sleep 100)
        (http/get "http://localhost:8888/redirect?code=CODE"))
      (Thread.)
      (.start))
  (is (= "CODE" (r/wait-for-redirect {}))))
