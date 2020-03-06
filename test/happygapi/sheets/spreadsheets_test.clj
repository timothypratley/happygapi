(ns happygapi.sheets.spreadsheets-test
  (:require [clojure.test :refer [deftest is testing]]
            [happygapi.sheets.spreadsheets :as gsheets]
            [happy.oauth2 :as oauth2]))

(def spreadsheet-id "1NbGRyCRMoOT_MLhnubC5900JNwiQq_uqvdKwbqZOfyM")

(deftest get$-test
  (testing "When fetching a spreadsheet"
    (let [spreadsheet (gsheets/get$ (oauth2/auth!)
                                    {:spreadsheetId spreadsheet-id})]
      (is (map? spreadsheet) "should receive spreadsheet info")
      (is (seq spreadsheet) "should contain properties")))

  (testing "When missing a required key"
    (is (thrown? AssertionError (gsheets/get$ (oauth2/auth!) {:badKey "123"}))
        "should get an exception")))

(deftest values-batchUpdate$-test
  (testing "When updating values in a sheet"
    (let [response (gsheets/values-batchUpdate$ (oauth2/auth!)
                                                {:spreadsheetId spreadsheet-id}
                                                {:valueInputOption "USER_ENTERED"
                                                 :data             [{:range  "Sheet1"
                                                                     :values [[1 2 3]
                                                                              [4 5 6]]}]})]
      (is (map? response) "should receive a summary")
      (is (seq response) "containing data"))))
