(ns happy.oauth2-test
  (:require [clojure.test :refer [deftest is]]
            [happy.oauth2 :as oauth2]
            [happy.oauth2-capture-redirect :as r]
            [happy.oauth2-credentials :as credentials]))

(deftest oauth2-test
  (let [config @credentials/secret
        scopes @credentials/scopes]
    (let [code (r/request-code config scopes nil)]
      (is code)
      (let [credentials (oauth2/exchange-code config code)]
        (is credentials)
        (let [new-credentials (oauth2/refresh-credentials config scopes credentials)]
          (is new-credentials)
          (oauth2/revoke-token new-credentials))))))
