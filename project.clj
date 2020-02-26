(defproject happygapi "0.1.0"
  :description "A Clojure library with source generated functions for using Google APIs."
  :url "http://github.com/timothypratley/happygapi"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [clj-http "3.10.0"]
                 [cheshire "5.10.0"]
                 [luposlip/json-schema "0.1.8"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/clojure "1.10.1"]
                                  [clj-http "3.10.0"]
                                  [cheshire "5.10.0"]
                                  [fipp "0.6.22"]
                                  [com.google.api-client/google-api-client "1.30.8"]
                                  [com.google.oauth-client/google-oauth-client-jetty "1.30.5"]]}
             :uberjar {:aot :all}})
