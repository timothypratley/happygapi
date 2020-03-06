(ns happy.util-test
  (:require [clojure.test :refer :all]
            [happy.util :as util]))

(deftest get-url-test
  (is (= "BASE/a/B/c" (util/get-url "BASE/" "a/{b}/c" #{:b} {:b "B"}))
      "should put required arguments into the url"))

(deftest has-keys?-test
  (testing "When map contains required keys"
    (is (util/has-keys? {:a 1 :b 2} #{:a :b})
        "should be true")))

(deftest get-response-test
  (testing "When the response is not success"
    (is (thrown? Exception (util/get-response {}))
        "should throw an exception")))
