(ns aoc.day1
  (:require [clojure.string :as str]))

(def input (str/split-lines (slurp "input")))

(defn dial [input dial acc]
  (if (empty? input) acc 
    (let [rotation (parse-long (subs (first input) 1))
          direction (str (subs (first input) 0 1))
          value (mod (cond (= direction "L") (- dial rotation)
                           (= direction "R") (+ dial rotation)) 100)]
      (recur (next input)
              value 
             (if (= 0 value) (inc acc) acc)))))

(dial input 50 0)
