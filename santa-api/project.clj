(defproject santa-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring "1.7.1"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]}
             :source-paths ["dev" "src"]})
