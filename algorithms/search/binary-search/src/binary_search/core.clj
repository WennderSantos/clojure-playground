(ns binary-search.core)

(defn binary-search [coll item]
  (if (empty? coll) coll
  (loop [start 0 end (count coll)]
    (if (= start end) "not found"
    (let [index-in-middle (quot (+ start end) 2)
         value-in-middle (nth coll index-in-middle)]
    (cond
      (> item value-in-middle) (recur (inc index-in-middle) (count coll))
      (< item value-in-middle) (recur 0 index-in-middle)
      :else "found"))))))
