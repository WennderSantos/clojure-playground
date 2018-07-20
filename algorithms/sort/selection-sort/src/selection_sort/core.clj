(ns selection-sort.core)

(defn get-min-val
  [arr]
  (apply min arr))

(defn merge-array
  [arr1 arr2]
  (if (empty? arr2) arr1
    (merge-array (conj arr1 (first arr2)) (rest arr2))))

(defn remove-min-val
  [arr]
  (loop [new-arr [] aux-arr arr]
    (cond
      (empty? aux-arr) new-arr
      (= (first aux-arr) (get-min-val arr)) (merge-array new-arr (rest aux-arr))
      :else (recur (conj new-arr (first aux-arr)) (rest aux-arr)))))
    
(defn selection-sort
  [arr]
  (cond
    (empty? arr) []
    :else (loop [unsorted arr sorted []]
            (if (empty? unsorted) sorted
           (recur (remove-min-val unsorted) (conj sorted (get-min-val unsorted)))))))
