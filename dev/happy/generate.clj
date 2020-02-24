(ns happy.generate
  "Writes to src/happygapi generated namespaces of function wrappers"
  (:require [happy.monkey :as monkey]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [fipp.clojure :as pprint]))

(def out-ns "happygapi")

(defn pprint-str [x]
  (with-out-str (pprint/pprint x)))

(defn ns-str [{:keys [documentationLink title description] :as api} resource-name methods]
  (str/replace
   (str
    (pprint-str
     (list 'ns (symbol (str out-ns \. (:name api) \. resource-name))
           (str title \newline
                description \newline
                "See: " documentationLink)
           '(:require
             [happygapi.util :as util]
             [clj-http.client :as http]
             [cheshire.core])))
    \newline
    (str/join \newline (map pprint-str methods)))
   #"\\n"
   "\n  "))

(defn write-api-ns [api]
  (println "Writing" (:name api) (:version api))
  (doseq [[k methods] (monkey/build-methods api)
          :let [dir (io/file "src" out-ns (:name api))
                resource-name (name k)]]
    (.mkdirs dir)
    (spit (io/file dir (str resource-name ".clj"))
          (ns-str api resource-name methods))))

#_(defonce sheets-api
  (monkey/fetch "https://sheets.googleapis.com/$discovery/rest?version=v4"))
#_(write-api-ns sheets-api)

(defn write-all []
  (doseq [api (monkey/fetch-all-apis)]
    (write-api-ns api)))

(defn -main [& args]
  (write-all))

#_(-main)
