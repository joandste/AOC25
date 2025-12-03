(ns aoc.day2
  (:require [clojure.string :as str]))

(def input (->> (str/split (str/trim-newline (slurp "input")) #",")
                (mapv #(str/split % #"-"))))

(defn id-check [input acc]
  (if (empty? input) acc
    (let [arg (first input)
          a (parse-long (get arg 0))
          b (parse-long (get arg 1))
          invalid-ids (filter repeat-check (range a b))]
      (recur (next input)
             (reduce + acc invalid-ids)))))


(defn repeat-check [id]
  (when id (let [string (str id)
        middle (/ (count string) 2)
        a (subs string 0 middle)
        b (subs string middle)]
    (when (= a b) true))))


(id-check input 0)

