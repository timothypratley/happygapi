(ns happy.oauth2-credentials-test
  (:require [clojure.test :refer [deftest is]])
  (:require [happy.oauth2-credentials :as credentials]))

(deftest auth!-test
  (credentials/init!)
  (is (credentials/auth!)))
