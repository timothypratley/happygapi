(ns happygapi.util
  "The generated functions use these convenience functions"
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(defn get-url
  "Replace URL path parameters with their values"
  [base-url path params args]
  (str base-url
       (reduce #(str/replace %1 (str "{" %2 "}") (args %2))
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
    (throw (ex-info (str "HappyGAPI status: " status) body))))
