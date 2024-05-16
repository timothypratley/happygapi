(ns happy.oauth2-test
  (:require [clojure.test :refer [deftest is]]
            [happy.oauth2 :as oauth2]
            [happy.oauth2-credentials :as credentials]))

(deftest refresh-test
  (credentials/auth!)
  (let [credentials (credentials/fetch-credentials "user")
        config @credentials/*secret
        scopes @credentials/*scopes]
    (and
      (is credentials)
      (is (oauth2/refreshable? {} credentials))
      (is (oauth2/refresh-credentials config scopes credentials)))))

(deftest revoke-test
  (credentials/auth!)
  (let [credentials (credentials/fetch-credentials "user")
        config @credentials/*secret]
    (and
      (is credentials)
      (is (oauth2/revoke-token config credentials))
      (credentials/delete-credentials "user"))))
