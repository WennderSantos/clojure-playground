(ns bubble-sort.core)

(defn swap-two-last-items
  [arr]
  (let [last-item (first (reverse arr))
        new-array (vec (reverse (rest (rest (reverse arr)))))]
    (-> new-array 
        (conj (first (reverse arr)))
        (conj (first (rest (reverse arr)))))))

(defn should-swap?
  [arr]
  (let [last-item (first (reverse arr))
        penultimate-item (first (rest (reverse arr)))]
  (if (or (= nil last-item) (= nil penultimate-item)) false
    (> penultimate-item last-item))))

(defn finished-swaps?
  [swaps total-swaps-needed]
  (true? (and (every? false? swaps) (= total-swaps-needed (count swaps)))))

(defn should-start-swap-from-initial?
  [swaps total-swaps-needed]
  (true? (and (some true? swaps) (= total-swaps-needed (count swaps)))))

(defn bubble-sort
  [arr]
  (if (or (empty? arr) (= 1 (count arr))) arr
  (loop [sorted (conj [] (first arr)) unsorted (rest arr) swaps []]
    (let [sorted-aux (conj sorted (first unsorted))
          total-swaps-needed (dec (count arr))]
    (cond 
      (finished-swaps? swaps total-swaps-needed) sorted
      (should-swap? sorted-aux) (recur (swap-two-last-items sorted-aux) (rest unsorted) (conj swaps true))
      (should-start-swap-from-initial? swaps total-swaps-needed) (recur (conj [] (first sorted-aux)) (rest sorted-aux) []) 
      :else (recur sorted-aux (rest unsorted) (conj swaps false)))))))
