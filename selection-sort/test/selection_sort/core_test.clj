(ns selection-sort.core-test
  (:require [clojure.test :refer :all]
            [selection-sort.core :refer :all]))

(deftest should-return-empty-array-for-empty-array
  (testing "Empty array"
    (is (= (selection-sort []) []))))

(deftest should-get-the-min-value-from-array
  (testing "Get the min value"
    (is (= (get-min-val [2 3 5 1]) 1))))

(deftest should-delete-min-value-from-array
  (testing "Delete min value from array"
    (is (= (remove-min-val [3 2 9 8]) [3 9 8])))) 

(deftest should-merge-two-arrays
  (testing "Merge array"
    (is (= (merge-array [1 2 3] [4 5 6]) [1 2 3 4 5 6]))))

(deftest should-return-a-sorted-array
  (testing "Sorted array"
    (is (= (selection-sort [2 5 3 8]) [2 3 5 8]))
    (is (= (selection-sort [2 5 2 3 8 5]) [2 2 3 5 5 8]))))
