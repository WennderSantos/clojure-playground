(ns selection-sort.core)

(defn get-min-val
  [arr]
  (if (empty? arr) arr
    (apply min arr)))

(defn merge-array
  [arr1 arr2]
  (if (empty? arr2) arr1
    (merge-array (conj arr1 (first arr2)) (rest arr2))))

(defn remove-min-val
  [arr min-val]
  (loop [new-arr [] aux-arr arr]
    (cond
      (empty? aux-arr) new-arr
      (= (first aux-arr) min-val) (merge-array new-arr (rest aux-arr))
      :else (recur (conj new-arr (first aux-arr)) (rest aux-arr)))))
    
(defn selection-sort
  [arr]
  (cond
    (empty? arr) []
    :else (loop [unsorted arr sorted []]
            (let [min-val (get-min-val unsorted)]
              (if (empty? unsorted) sorted
              (recur (remove-min-val unsorted min-val) (conj sorted min-val)))))))
