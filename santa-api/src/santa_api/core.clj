(ns santa-api.core
  (:require [ring.util.response :as response]
            [compojure.api.sweet :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]))

(def handler-api
  (api
   (GET "/merry" []
     (response/response {:msg "Merry Christmas !"
                         :year 2018}))
   (route/not-found (response/not-found "Oups"))))

(defn start-server []
  (run-jetty #'handler-api {:port 8080 :join? false}))
