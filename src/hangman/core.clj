(ns hangman.core)

(defn game
  [word, player]
  (loop [progress (new-progress word), guesses 1]
    let [guess, (next-guess player progress)
         progress' (update-progress progress word guess)]
    if (complete? progress' word)
    guesses
    (recur progress' (inc guesses))))