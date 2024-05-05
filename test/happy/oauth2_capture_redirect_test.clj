(ns happy.oauth2-capture-redirect-test
  (:require [clj-http.client :as http]
            [clojure.test :refer [deftest is testing]]
            [happy.oauth2-capture-redirect :as r]
            [happy.oauth2-credentials :as credentials]))

(deftest wait-for-redirect-test
  (is (= "CODE" (let [redirect-uri "http://localhost"
                      simulate-redirect (fn [uri] (http/get (str uri "?code=CODE")))
                      code (r/wait-for-redirect simulate-redirect {:redirect_uri redirect-uri})]
                  code))))

(deftest add-port-test
  (do
    (is (= "http://localhost:1234" (r/add-port "http://localhost" 1234)) "No path")
    (is (= "http://localhost:1234/" (r/add-port "http://localhost/" 1234)) "Trailing slash")
    (is (= "http://localhost:1234/bla/blubb" (r/add-port "http://localhost/bla/blubb" 1234)) "Path")
    (is (= "http://localhost:1234/bla/blubb" (r/add-port "http://localhost:1234/bla/blubb" 1234)) "Port, path")
    (is (thrown-with-msg? RuntimeException #"URI doesn't match pattern" (r/add-port "http://otherhost/bla/blubb" 1234)) "Not localhost")))

(deftest redirect-uri->port-test
  (do
    (is (= 0 (r/redirect-uri->port "http://localhost")) "No port, no path")
    (is (= 0 (r/redirect-uri->port "http://127.0.0.1")) "IPv4 address, no path")
    (is (= 0 (r/redirect-uri->port "http://localhost/bla/blubb")) "Path, no port")
    (is (= 1234 (r/redirect-uri->port "http://localhost:1234")) "Explicit port, no path")
    (is (= 1234 (r/redirect-uri->port "http://localhost:1234/")) "Explicit port, trailing slash")
    (is (= 1234 (r/redirect-uri->port "http://localhost:1234/bla/blubb")) "Explicit port, path")
    (is (thrown-with-msg? RuntimeException #"URI doesn't match pattern" (r/redirect-uri->port "http://otherhost/bla/blubb")) "Not localhost")))
