(ns happy.lion-test
  (:require [clojure.test :refer [deftest is testing]]
            [happy.lion :as lion]))

(deftest pprint-str-test
  (is (= "[1 2 3]\n" (lion/pprint-str [1 2 3]))))

(deftest ns-str-test
  (is (= "foo\n\n\"a\n  b\n  c\"\n\nbar\n\nbaz\n" (lion/ns-str '(foo "a\nb\nc" bar baz)))))

#_
(deftest write-api-nss-test
  (is (= :done (lion/fetch-and-write "https://sheets.googleapis.com/$discovery/rest?version=v4"))))

#_
(deftest write-all-test
  (is (= :done (lion/write-all))))
