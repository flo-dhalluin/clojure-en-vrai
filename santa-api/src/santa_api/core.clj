(ns santa-api.core
  (:require [ring.util.response :as response]
            [ring.adapter.jetty :refer [run-jetty]]))

(defn handler [rq]
  (response/response "Merry Christmas !"))


(defn start-server []
  (run-jetty #'handler {:port 8080 :join? false}))
