(defproject santa-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [metosin/compojure-api "2.0.0-alpha28"]
                 [ring "1.7.1"]
                 [org.clojure/java.jdbc "0.7.8"] ;; ...
                 [com.h2database/h2 "1.4.197"] ;; h2 driver
                 [migratus "1.2.0"]
                 [honeysql "0.9.4"]]
  
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]}
             :source-paths ["dev" "src"]})
