(ns santa-api.migrations
  (:require [santa-api.config :as config]
            [migratus.core :as migratus]))


(def config {:store :database ;; store migration states in db
             :db config/db})

;; manually create a migration 
;; (migratus/create config "create-presents")

(defn migrate-all []
  (do
    (migratus/init config)
    (migratus/migrate config)))
