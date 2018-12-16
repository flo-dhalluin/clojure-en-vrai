(ns santa-api.specs
  (:require [clojure.spec.alpha :as s]))


(defn recipient-valid? [name]
  (re-matches #"[\w-_]+" name))

;; -- wishlist meta-data
(s/def ::recipient recipient-valid?)
(s/def ::behavior (s/and pos-int? #(<= % 10)))
(s/def ::wishlist (s/keys :req-un [::recipient ::behavior]))

;; (s/explain-str ::wishlist {:behavior 4 :recipient "Florent")

;; -- presents meta-data
(s/def ::name string?)
(s/def ::presents (s/coll-of ::name))
(s/def ::wishlist-detailled (s/keys :req-un [::recipient
                                             ::behavior
                                             ::presents]))

;; (s/explain-str ::wishlist-detailled
;;                {:recipient "Florent" :behavior 8
;;                 :presents ["Clojure book" "beers" "hat"]})

(s/def ::quantity pos-int?)
(s/def ::present (s/keys :req-un [::name ::quantity]))

