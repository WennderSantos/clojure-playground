(ns insertion-sort.core)

(defn insertion-sort [arr]
   (reduce (fn [last-operation-result input]
             (let [[less more] (split-with #(< % input) last-operation-result)]
               (vec (concat less [input] more))))
           []
           arr))
