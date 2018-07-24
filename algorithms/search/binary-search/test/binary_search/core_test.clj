(ns binary-search.core-test
  (:require [clojure.test :refer :all]
            [binary-search.core :refer :all]))

(deftest Binary-search
  (testing "when array is empty, should return an empty array"
    (is (= (binary-search [] 1) [])))
  (testing "when array contains the item, should return 'found'"
    (is (= (binary-search [1 2 3] 2) "found"))
    (is (= (binary-search [1] 1) "found"))
    (is (= (binary-search [1 2 3 4] 4) "found")))
  (testing "when array does not contains the item, should return 'not found'"
    (is (= (binary-search [1 2 3] 4) "not found"))
    (is (= (binary-search [1] 0) "not found"))
    (is (= (binary-search [1 2 3 4] 5) "not found"))
    (is (= (binary-search [1 2 3 4] 0) "not found"))))
