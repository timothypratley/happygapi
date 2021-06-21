(defproject happygapi "0.4.6"
  :description "A Clojure library with source generated functions for using Google APIs."
  :url "http://github.com/timothypratley/happygapi"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :main happy.lion
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [clj-http "3.12.2"]
                 [cheshire "5.10.0"]
                 [buddy "2.0.0"]]
  :deploy-repositories {"releases" {:url "https://repo.clojars.org"}}
  :profiles {:dev     {:source-paths ["dev"]
                       :dependencies [[fipp "0.6.23"]
                                      [meander/epsilon "0.0.602"]
                                      [ring "1.9.3"]
                                      [org.slf4j/slf4j-nop "1.7.31"]]}
             :uberjar {:aot :all}})
