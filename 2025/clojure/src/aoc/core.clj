(ns aoc.core
  (:require [aoc.day01 :as day01]))

(defn -main
  "Entry point for running solutions from the command line."
  [& _args]
  (let [{:keys [lines-read result]} (day01/solve)
        part2 (day01/solve-2)
        part2-reduce (day01/solve-2-reduce)]
    (println "read" lines-read "lines")
    (println "Ergebnis Teil 1:" result)
    (println "Ergebnis Teil 2:" (:result part2))
    (println "Ergebnis Teil 2 (reduce):" (:result part2-reduce))))
