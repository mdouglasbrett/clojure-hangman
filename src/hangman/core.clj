(ns hangman.core)

(defn game
  [word, player]
  (loop [progress (new-progress word), guesses 1]
    let [guess, (next-guess player progress)
         progress' (update-progress progress word guess)]
    if (complete? progress' word)
    guesses
    (recur progress' (inc guesses))))

(defn next-guess [player, progress])
(defn new-progress []) ;; TODO: I think I'm missing an arg here
(defn update-progress [progress word guess])
(defn complete? [progress])