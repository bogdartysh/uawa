(defproject gorilla-uawa "0.1.0-SNAPSHOT"
      :dependencies [
                            [org.clojure/clojure "1.8.0"]
                            [org.clojure/data.json "0.2.6"]
                            [clj-http "2.3.0"]
                            [org.clojure/java.jdbc "0.7.0-beta4"]
                    ]
        :main ^:skip-aot gorilla-test.core
          :target-path "target/%s"
            :plugins [[lein-gorilla "0.4.0"]]
              :profiles {:uberjar {:aot :all}})
