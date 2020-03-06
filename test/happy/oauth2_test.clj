(ns happy.oauth2-test
  (:require [clojure.test :refer [deftest is testing]]
            [happy.oauth2 :as oauth2]))

(deftest start!-test
  (oauth2/start!)
  (is (oauth2/auth!))
  (oauth2/stop!)
  (oauth2/start!)
  (is (oauth2/auth!))
  (oauth2/stop!))
