(ns happy.oauth2-capture-redirect-test
  (:require [clj-http.client :as http]
            [clojure.test :refer [deftest is testing]]
            [happy.oauth2-capture-redirect :as r]
            [happy.oauth2-credentials :as credentials]))

(deftest wait-for-redirect-test
  (-> (fn []
        (Thread/sleep 100)
        (http/get "http://localhost/redirect?code=CODE"))
      (Thread. "redirect in a little while")
      (.start))
  (is (= "CODE" (r/wait-for-redirect {}))))
