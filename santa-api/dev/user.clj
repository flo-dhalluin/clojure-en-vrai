(ns user
  (:require [clojure.tools.namespace.repl :refer [refresh]]))


(defn reset-all []
  (refresh))

;; maps - the most usefull data-struct
(def my-map {:name "flo" :email "flo@flal.net" :twitter "flal"})

;; vecs better than LISPs cons .. 
(def my-vec ["flo" 42 66])

;; define functions. 
(defn say-hi [name]
  (str "Hello " name))

