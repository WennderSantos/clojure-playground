(ns insertion-sort.core-test
  (:require [clojure.test :refer :all]
            [insertion-sort.core :refer :all]))

(deftest should-sort-an-array
  (testing "when array is empty, should return an empty array"
    (is (= (insertion-sort []) [])))
  (testing "when array has one item, should return the same array"
    (is (= (insertion-sort [1]) [1])))
  (testing "when array is sorted, should return the same array"
    (is (= (insertion-sort [1 2 3]) [1 2 3])))
  (testing "when array is unsorted, should return it sorted"
    (is (= (insertion-sort [3 2 5 1 4]) [1 2 3 4 5])))
  (testing "when array contains repeated items, should return them consecutively"
    (is (= (insertion-sort [3 2 5 1 4 4]) [1 2 3 4 4 5]))))
