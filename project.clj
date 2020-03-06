(defproject happygapi "0.2.0-SNAPSHOT"
  :description "A Clojure library with source generated functions for using Google APIs."
  :url "http://github.com/timothypratley/happygapi"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :main happy.lion
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [clj-http "3.10.0"]
                 [cheshire "5.10.0"]
                 [com.google.api-client/google-api-client "1.30.9"]
                 [com.google.oauth-client/google-oauth-client-jetty "1.30.5"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[fipp "0.6.22"]
                                  [meander/epsilon "0.0.402"]]}
             :uberjar {:aot :all}})
