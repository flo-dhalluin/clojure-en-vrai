(ns santa-api.db
  (:require [honeysql.core :as sql]
            [honeysql.helpers :refer :all :as helpers]
            [clojure.java.jdbc :as jdbc]
            [santa-api.migrations :as migr]))

;; (migr/migrate-all)
