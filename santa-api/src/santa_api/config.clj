(ns santa-api.config)

(def db {:classname "org.h2.Driver"
         :subprotocol "h2:mem"
         :subname "santa;DB_CLOSE_DELAY=-1"}) ;; the delay is to keep db between


;; (def db {:classname "org.h2.Driver"
;;          :subprotocol "h2:file"
;;          :subname "./santa.h2.db"})
