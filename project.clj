(defproject happygapi "0.4.10-SNAPSHOT"
  :description "A Clojure library with source generated functions for using Google APIs."
  :url "http://github.com/timothypratley/happygapi"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :main happy.lion
  :dependencies [[org.clojure/clojure "1.11.2"]
                 [clj-http "3.12.3"]
                 [cheshire "5.12.0"]
                 [buddy/buddy-sign "3.5.351"]]
  :deploy-repositories {"releases" {:url "https://repo.clojars.org"}}
  :profiles {:dev     {:source-paths ["dev"]
                       :dependencies [[fipp "0.6.26"]
                                      [meander/epsilon "0.0.650"]
                                      [ring "1.12.1"]
                                      [org.scicloj/kind-portal "1-beta1"]
                                      [djblue/portal "0.53.0"]
                                      [org.slf4j/slf4j-nop "2.0.12"]]}
             :uberjar {:aot :all}})
