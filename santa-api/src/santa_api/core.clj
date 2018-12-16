(ns santa-api.core
  (:require [ring.util.response :as response]
            [compojure.api.sweet :refer :all]
            [compojure.route :as route]
            [santa-api.specs :as sp]
            [santa-api.db :as db]
            [clojure.spec.alpha :as s]
            [ring.adapter.jetty :refer [run-jetty]]))

(def example-wishlist
  {:recipient "Florent"
   :behavior 5})

(def example-wishlist-detailled
  {:recipient "Florent"
   :behavior 5
   :presents ["Clojure book" "scarf" "beers"]})

(def handler-api
  (api
   {:coercion :spec}
   (swagger-routes)
   
   (GET "/merry" []
     (response/response {:msg "Merry Christmas !"
                         :year 2018}))
   ;; wishlist api
   (context "/wishlists" []
     (POST "/" []
       :body [w ::sp/wishlist]
       (let [r (db/create-wishlist! w)]
         (response/created (str "/wishlists/" (:id r)))))
     
     (GET "/" []
       :return (s/coll-of ::sp/wishlist)
       (response/response
        (db/get-all-whishlist)))

     (GET "/:id" []
       :path-params [id :- pos-int?]
       :return ::sp/wishlist-detailled
       (response/response
        (db/get-wishlist id)))

     (POST "/:id" []
       :path-params [id :- pos-int?]
       :body [present ::sp/present]
       (let [r (db/add-present! id present)]
         (response/created (str (:id r))))))

   (GET "/all-presents" []
     :return ::sp/presents
     (response/response ["One" "Two" "Three"]))
   
   (route/not-found (response/not-found "Oups"))))

(defn start-server []
  (run-jetty #'handler-api {:port 8080 :join? false}))

;;(def serv (start-server))

