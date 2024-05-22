(ns happy.oauth2-capture-redirect-test
  (:require [clj-http.client :as http]
            [clojure.test :refer [deftest is testing]]
            [happy.oauth2-capture-redirect :as r]
            [happy.oauth2 :as oauth2]
            [happy.oauth2-credentials :as credentials]))

(deftest wait-for-redirect-test
  (with-redefs [r/browse-to-provider (fn [{:keys [redirect_uri]} scopes optional]
                                       (http/get (str redirect_uri "?code=CODE&state=" (:state optional))))
                oauth2/exchange-code (fn [config code]
                                       (is (= "CODE" code))
                                       {:access_token "TOKEN"})]
    (is (= {:access_token "TOKEN"}
           (r/fresh-credentials {:auth_uri     "TEST"
                                 :client_id    "TEST"
                                 :redirect_uri "http://localhost"}
                                []
                                {})))
    (is (= {:access_token "TOKEN"}
           (r/fresh-credentials {:auth_uri     "TEST"
                                 :client_id    "TEST"
                                 :redirect_uri "http://localhost:8080/redirect"}
                                []
                                {})))
    (is (thrown? Throwable
           (r/fresh-credentials {:auth_uri     "TEST"
                                 :client_id    "TEST"
                                 :redirect_uri "http://not.localhost"}
                                []
                                {})))))
