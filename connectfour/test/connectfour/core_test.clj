(ns connectfour.core-test
  (:require [clojure.test :refer :all]
            [connectfour.core :refer :all]))
(use 'clojure.core.matrix)

(defn in?
    "true if coll contains elm"
      [coll elm]
        (some #(= elm %) coll))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest test-boundary-checks
  (testing "Bounds checking works"
    (let [board (matrix :ndarray
          [[0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [0 0 0 0 0 0]])]
      (is (valid-row? 5 board))
      (is (not (valid-row? -1 board)))
      (is (valid-column? 0 board))
      (is (not (valid-column? -1 board)))
      (is (in-bounds? 5 5 board))
      (is (in-bounds? 0 0 board))
      (is (not (in-bounds? 6 3 board)))
      (is (not (in-bounds? 3 6 board))))))

(deftest position-set
  (testing "Position set check works"
    (let [board (matrix :ndarray
          [[-1 0 0 0 0 1]
          [0 0 0 0 0 0]
          [0 0 0 -1 0 0]
          [0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [1 0 0 0 0 0]])]
      (is (not (position-set? 0 0 board 1)))
      (is (position-set? 5 0 board 1))
      (is (position-set? 0 5 board 1))
      (is (position-set? 2 3 board -1))
      (is (not (position-set? 5 0 board -1))))))

(deftest pre-condition
  (testing "Pre-condition works"
    (let [board (matrix :ndarray
          [[-1 0 0 0 0 1]
          [0 0 0 0 0 0]
          [0 0 0 -1 0 0]
          [0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [1 0 0 0 0 0]])]
      (is (not (pre-condition? 0 0 board 1)))
      (is (pre-condition? 0 0 board -1))
      (is (pre-condition? 5 0 board 1))
      (is (pre-condition? 0 5 board 1))
      (is (pre-condition? 2 3 board -1))
      (is (not (pre-condition? 6 6 board 1)))
      (is (not (pre-condition? -1 5 board -1))))))


(deftest get-coordinates-test
  (testing "Produces all coordinates for a board"
    (let [board (matrix :ndarray
          [[0 0 0 0 0 1]
          [0 0 0 0 0 0]
          [0 0 0 1 0 0]
          [0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [1 0 0 0 0 0]])]
      (is (in? (get-coordinates board) [5 5]))
      (is (in? (get-coordinates board) [0 1]))
      (is (in? (get-coordinates board) [4 3]))
      (is (not (in? (get-coordinates board) [6 0]))))))

(deftest test-column-full
  (testing "column full checks if a column is full"
    (let [board (matrix :ndarray
          [[0 0 0 0 0 1]
          [0 0 0 0 0 1]
          [0 0 0 0 0 1]
          [0 0 0 0 0 1]
          [0 0 0 0 0 1]
          [0 0 0 0 0 1]])]
      (is (not (column-full? 2 board)))
      (is (column-full? 5 board)))))

(deftest test-first-empty-row
  (testing "returns the first empty row"
    (let [board (matrix :ndarray
          [[0 0 0 1 0 0]
          [0 0 0 1 0 0]
          [0 0 0 1 0 1]
          [0 0 0 1 0 1]
          [0 0 0 1 0 1]
          [0 0 0 1 0 1]])]
      (is (= 1 (first-empty-row 5 board)))
      (is (= -1 (first-empty-row 3 board)))
      (is (= 5 (first-empty-row 1 board))))))

(deftest test-row-to-string
  (testing "row is converted to string"
    (let [board (matrix :ndarray
          [[0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [0 1 0 1 1 1]
          [0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [0 0 0 0 0 0]])]
      (is (= "0 1 0 1 1 1 \n" (row-to-string (nth board 2)))))))

(deftest test-format-board
  (testing "Board is formatting to text"
    (let [board (matrix :ndarray
          [[0 -1 0 1]
           [0 1 1 1]
           [1 1 -1 -1]])]
      (is (= "0 -1 0 1 \n0 1 1 1 \n1 1 -1 -1 \n"
             (format-board board))))))

(deftest test-next-turn
  (testing "Flips atom on next turn"
    (let [turn (atom 1)]
      (is (= @turn 1))
      (update-next-player turn)
      (is (= @turn -1))
      (update-next-player turn)
      (is (= @turn 1)))))

(deftest test-find-first
  (testing "Returns the first element where the function turns true"
    (is (find-first #(if %1 %1 false) [false false false true false]))
    (is (not (find-first #(if %1 %1 false) [false false false false false])))
    (is (find-first #(if (= % 2) true false) [1 0 3 4 5 0 2]))
    (is (not (find-first #(if (= % 2) true false) [1 0 3 4 5 0 8])))))

(deftest test-connect-four
  (testing "Checks for connect four for a given player"
    (let [board (matrix :ndarray
          [[0 0 0 0 0 0]
          [0 0 0 0 0 0]
          [0 0 0 0 1 0]
          [0 0 0 1 0 0]
          [0 0 1 0 0 0]
          [0 1 0 0 0 0]])]
      (is (connect-four? board 1))
      (is (not (connect-four? board -1))))))

