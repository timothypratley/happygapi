(ns happy.util
  "The generated functions use these convenience functions"
  (:require [clojure.set :as set]
            [clojure.string :as str]
            [cheshire.core :as json]))

(defn get-url
  "Replace URL path parameters with their values"
  [base-url path params args]
  (str base-url
       (reduce (fn [path param]
                 (-> path
                     (str/replace (str "{" (name param) "}") (get args param))
                     (str/replace (str "{+" (name param) "}") (get args param))))
               path
               params)))

(defn has-keys?
  "Checks that m has all ks (a set of keys) present"
  [m ks]
  (set/superset? (set (keys m))
                 ks))

(defn get-response
  "Check an HTTP response, JSON decoding the body if value"
  [{:keys [status body]}]
  (if (= status 200)
    body
    (let [{{:keys [code status message]} :error :as body} (json/parse-string body true)]
      (throw (ex-info (str "HappyGAPI " code ": " status " " message)
                      (or body {}))))))
