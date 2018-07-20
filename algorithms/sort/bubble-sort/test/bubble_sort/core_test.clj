(ns bubble-sort.core-test
  (:require [clojure.test :refer :all]
            [bubble-sort.core :refer :all]))

(deftest swap
  (testing "should swap the two last items of the array"
    (is (= (swap-two-last-items [1 3 5 4]) [1 3 4 5]))
    (testing "even if the array contains only two items"
      (is (= (swap-two-last-items [2 1]) [1 2])))))

(deftest swap?
  (testing "should swap"
   (testing "when the last item is small than the penultimate item"
    (is (= (should-swap? [1 2 4 3]) true))))
  (testing "should not swap"
   (testing "when the last item is bigger than the penultimate item"
    (is (= (should-swap? [3 4]) false)))
   (testing "when the last item is nil"
     (is (= (should-swap? [3 4 nil]) false)))))

(deftest finished-swaps
  (testing "when swaps contains the total-swaps-needed" 
    (testing "and their values are all false should return true"
      (is (= (finished-swaps? [false false false] 3) true)))
    (testing "and their values contains trues and falses should return false"
      (is (= (finished-swaps? [false true false] 3) false))))
  (testing "when swaps not contains the total-swaps-needed"
    (testing "and their values are all false should return false"
      (is (= (finished-swaps? [false false false] 4))))
    (testing "and their values contains trues and falses should return false"
      (is (= (finished-swaps? [false true false] 4))))))

(deftest should-start-swaps-from-initials
  (testing "when array gets to its end"
    (testing "but is not sorted yet"
      (testing "should start the swaps from initial"
        (is (= (should-start-swap-from-initial? [false true true] 3)))))
    (testing "and it is sorted"
      (testing "should not start the swaps from initial"
        (is (= (should-start-swap-from-initial? [false false false] 3))))))
  (testing "when array is not in its end"
    (testing "should not start the swaps from initial"
      (is (= (should-start-swap-from-initial? [false true true] 2))))))

(deftest sort-an-array
  (testing "when is empty"
    (testing "should return an empty array"
     (is (= (bubble-sort []) []))))
  (testing "when has one item"
    (testing "should return the same array"
      (is (= (bubble-sort [4]) [4]))))
  (testing "when has two items unsorted"
    (testing "should swap them"
      (is (= (bubble-sort [4 3]) [3 4]))))
  (testing "when has two items sorted"
    (testing "should return a sorted array"
      (is (= (bubble-sort [3 4]) [3 4]))))
  (testing "when has more than two itens unsorted"
    (testing "and has no repeated items"
      (testing "should return a sorted array"
        (is (= (bubble-sort [4 3 1 7]) [1 3 4 7])))))
    (testing "and contain repeated items"
      (testing "should return a sorted array with the respective repeated items"
        (is (= (bubble-sort [4 1 3 1 7 4]) [1 1 3 4 4 7])))))
