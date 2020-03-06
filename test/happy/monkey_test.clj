(ns happy.monkey-test
  (:require [clojure.test :refer [deftest testing is]]
            [happy.monkey :as monkey]))

(deftest fetch-test
  (let [api (monkey/fetch "https://sheets.googleapis.com/$discovery/rest?version=v4")]
    (is (map? api) "should deserialize")
    (is (seq api) "should contain definition")))

(deftest list-apis-test
  (let [api-list (monkey/list-apis)]
    (is (<= 170 (count api-list) 200)
        "should find a good number of Google APIs")))
