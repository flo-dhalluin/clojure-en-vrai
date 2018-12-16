(ns santa-api.db
  (:require [honeysql.core :as sql]
            [honeysql.helpers :refer :all :as helpers]
            [clojure.java.jdbc :as jdbc]
            [santa-api.migrations :as migr]
            [santa-api.config :as config]))

;;(migr/migrate-all)

(defn- query [query-map]
  (jdbc/query config/db (sql/format query-map)))

(defn- execute! [query-map]
  (jdbc/execute! config/db (sql/format query-map)
                 {:return-keys true}))

(defn create-wishlist! [ wishlist ]
  (execute! (-> (insert-into :wishlists)
                (values [wishlist]))))

(defn get-all-whishlist []
  (query (-> (select :*)
             (from :wishlists))))


(defn add-present! [wishlist-id present]
  (execute! (-> (insert-into :presents)
                (values [(assoc present :wishlistid wishlist-id)]))))

(defn- get-presents [records]
  (->> records
      (map :name)
      (filter identity)
      (reduce conj [])))

(defn get-wishlist [wishlist-id]
  (if-let [records (seq (query (-> (select :*)
                                    (from :wishlists)
                                    (where [ := :wishlists.id wishlist-id])
                                    (left-join :presents [:= :presents.wishlistid :wishlists.id]))))]
    (assoc (select-keys (first records) [:recipient :behavior :id])
           :presents (get-presents records))))

