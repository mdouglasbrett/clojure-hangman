(ns hangman.core)

(defn game
  [word, player]
  (loop [progress (new-progress word), guesses 1]
    (let [guess, (next-guess player progress)
         progress' (update-progress progress word guess)]
      (if (complete? progress' word)
    guesses
    (recur progress' (inc guesses))))))

(defn new-progress [word]
  (repeat (count word) \_))
(defn update-progress [progress word guess]
  (map #(if (= %1 guess) guess %2) word progress))
(defn complete? [progress word]
  (= progress (seq word)))

(defprotocol Player
  (next-guess [player progress])) ;; Protocols just provide a signature, implementation comes later

(defonce letters
  (mapv char (range (int \a) (inc (int \z)))))