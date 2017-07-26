(defproject app "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"], [clj-http "2.3.0"], [uawa/uawa "0.1.0-SNAPSHOT"]]
 ;; :dependencies [[org.clojure/clojure "1.3.0"], [http.async.client "1.2.0"]]
  :aot [app.core]
  :main app.core
  )
