(ns linear-search.core-test
  (:require [clojure.test :refer :all]
            [linear-search.core :refer :all]))

(deftest should-find
  (testing "Should find"
    (is (= "found" (linear-search [1 5 4] 5)))))

(deftest should-not-find
  (testing "Not found"
    (is (= "not found" (linear-search [1 5 4] 7)))))


