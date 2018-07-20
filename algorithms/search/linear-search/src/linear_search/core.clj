(ns linear-search.core)

(defn linear-search
  [list-of-numbers number-to-find]
    (cond
      (empty? list-of-numbers) "not found"
      (= (first list-of-numbers) number-to-find) "found"
      :else (linear-search (rest list-of-numbers) number-to-find)))
