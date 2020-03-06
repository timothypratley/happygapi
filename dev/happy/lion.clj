(ns happy.lion
  "Writes to src/happygapi generated namespaces of function wrappers"
  (:require [happy.monkey :as monkey]
            [happy.beaver :as beaver]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [fipp.clojure :as pprint]))

(defn pprint-str [x]
  (with-out-str (pprint/pprint x)))

(defn ns-str [resource-ns]
  (str/replace
    (str/join \newline
              (map pprint-str resource-ns))
    #"\\n"
    "\n  "))

(defn write-api-nss [api]
  (println "Writing" (:name api) (:version api))
  (spit (io/file "resources" (str (:name api) "_schema.edn"))
        (pprint-str (:schemas api)))
  (doseq [[resource-name resource-ns] (beaver/build-nss api)
          :let [dir (io/file "src" beaver/out-ns (:name api))
                resource-name (name resource-name)]]
    (.mkdirs dir)
    (spit (io/file dir (str resource-name ".clj"))
          (ns-str resource-ns)))
  :done)

(defn fetch-and-write [api-url]
  (some-> (try
            (monkey/fetch api-url)
            (catch Exception ex
              (println "*** Failed to fetch ***" api-url)))
          (write-api-nss)))

(defn write-all []
  (doseq [[name version api-url] (monkey/list-apis)]
    (println "Fetching" name version api-url)
    (fetch-and-write api-url))
  :done)

(defn -main [& args]
  (write-all))
