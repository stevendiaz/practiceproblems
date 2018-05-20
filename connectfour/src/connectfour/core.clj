(ns connectfour.core
  (:gen-class))
(use 'clojure.core.matrix)

;; game state vars
(def board
  (matrix :ndarray
  [[0 0 0 0 0 0]
   [0 0 0 0 0 0]
   [0 0 0 0 0 0]
   [0 0 0 0 0 0]
   [0 0 0 0 0 0]
   [0 0 0 0 0 0]]))

(def turn (atom 1))

;; End game checking logic
(defn valid-column? [column board]
  (and (>= column 0) (< column (column-count board))))

(defn valid-row? [row board]
  (and (>= row 0) (< row (row-count board))))

(defn in-bounds? [row column board]
  (and (valid-row? row board) (valid-column? column board)))

(defn position-set? [row column board player]
  (= (mget board row column) player))

;; Precondition for checking a connect four
(defn pre-condition? [row column board player]
  (and (in-bounds? row column board) (position-set? row column board player)))

(defn get-coordinates [board]
  (apply concat (for [x (range (row-count board))] (for [y (range (column-count board))] [x y]))))

(defn find-first
  [f coll]
  (first (filter f coll)))

(defn connect-four?
  ([board player]
   (find-first (partial connect-four? board player) (get-coordinates board)))
  ([board player coordinates]
   (let [row    (nth coordinates 0)
         column (nth coordinates 1)]
     (if (pre-condition? row column board player)
       (or (connect-four? board player coordinates [0 1] 0)   ;; horizontal
           (connect-four? board player coordinates [1 0] 0)   ;; vertical
           (connect-four? board player coordinates [1 1] 0)   ;; positive slope
           (connect-four? board player coordinates [1 -1] 0)) ;; negative slope
           false)))
  ([board player coordinates direction counter]
    (let [row (nth coordinates 0)
         column (nth coordinates 1)
         row-dir (nth direction 0)
         col-dir (nth direction 1)]
     (cond
       (= counter 4) true
       (not (pre-condition? row column board player)) false
       :else (connect-four? board player [(+ row row-dir) (+ column col-dir)] direction (inc counter))))))


;; Position set logic
(defn column-full? [column board]
  (or (empty? board) (not= (nth (first board) column) 0)))

(defn first-empty-row
  ([column board]
    (if (column-full? column board)
      -1
      (first-empty-row 1 column (rest board))))
  ([row column board]
    (if (column-full? column board)
       (- row 1)
       (recur (+ row 1) column (rest board)))))

;; Board to string formatting
(defn player-to-string [p]
  (cond
    (= p 1) "A"
    (= p -1) "B"
    :else "O"))

(defn row-to-string [row]
  (let [str-row (map player-to-string row)]
    (let [concat-row (reduce str (map #(str %1 " ") str-row))]
      (str concat-row "\n"))))

(defn format-board [board]
  (str (reduce str (map row-to-string board)) "0 1 2 3 4 5" ))

;; Game logic
(defn update-next-player [turn]
  (swap! turn #(if (= % 1) -1 1)))

(defn do-next-turn [column turn]
  (let [row (first-empty-row column board)]
    (mset! board (first-empty-row column board) column @turn)
    (if (connect-four? board @turn)
      true
      (do (update-next-player turn) false))))

(defn play-game []
  (let [player-name (str "Player " (player-to-string @turn))]
    (println (format-board board))
    (println (str (str "It's " player-name) "'s turn."))
    (println "What column to enter?: ")
    (let [column (read-string (read-line))]
      (cond
        (not (valid-column? column board)) (play-game)
        (column-full? column board) (play-game)
        (do-next-turn column turn) (do (println "game complete") (println (format-board board)))
        :else (play-game)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (format-board board))
  (pm board)
  (play-game))

