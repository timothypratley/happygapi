(ns happygapi.sheets.spreadsheets-test
  (:require [happygapi.sheets.spreadsheets :as gsheets]
            [happy.oauth2 :as oauth2]
            [clojure.test :refer [deftest is testing]]))

(deftest get$-test
  (is (= {} (gsheets/get$ (oauth2/auth)
                          {"spreaddsheetId" "1NbGRyCRMoOT_MLhnubC5900JNwiQq_uqvdKwbqZOfyM"}))))

;; TODO: test schema validation
