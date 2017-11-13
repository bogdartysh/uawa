(defproject projecteuler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"] [uawa/uawa "0.1.1-SNAPSHOT"] [clj-http "3.7.0"]]
  :main ^:skip-aot projecteuler.core
  :target-path "target/%s"
   :plugins [[lein-gorilla "0.4.0"]]
  :profiles {:uberjar {:aot :all}})
