(ns aoc.day01
  (:require [clojure.string :as str]))

(defn parse-step
  "Convert a line like \"L10\" or \"R5\" to its signed numeric delta."
  [s]
  (let [n (Long/parseLong (subs s 1))]
    (if (str/starts-with? s "L") (- n) n)))

(defn count-returns-to-zero
  "Simulate the dial movements and count how often it hits multiples of 100."
  [steps]
  (:reached0
   (reduce (fn [{:keys [dial reached0]} step]
             (let [dial' (+ dial step)]
               {:dial dial'
                :reached0 (if (zero? (mod dial' 100))
                            (inc reached0)
                            reached0)}))
           {:dial 50
            :reached0 0}
           steps)))

(defn count-returns-to-zero-2
  "Part 2 dial simulation: count crossings of multiples of 100."
  [steps]
  (let [modulus 100]
    (:reached0
     (reduce (fn [{:keys [dial reached0]} step]
               (let [full-dials (Math/abs (quot step modulus))
                     reached0-full (+ reached0 full-dials)
                     step-rem (rem step modulus)
                     mod-plus-dial (+ dial step-rem)
                     reached0-cross (if (and (not (zero? dial))
                                              (or (neg? mod-plus-dial)
                                                  (> mod-plus-dial modulus)))
                                      (inc reached0-full)
                                      reached0-full)
                     dial (mod (+ dial step) modulus)
                     reached0-final (if (zero? dial)
                                      (inc reached0-cross)
                                      reached0-cross)]
                 {:dial dial
                  :reached0 reached0-final}))
             {:dial 50
              :reached0 0}
             steps))))

(defn solve
  "Run Day 01 with the given lines; reads ../inputs/day01.txt by default."
  ([]
   (solve "../inputs/day01.txt"))
  ([path]
   (let [lines (->> path slurp str/split-lines (remove str/blank?))
         steps (map parse-step lines)
         result (count-returns-to-zero steps)]
     {:lines-read (count lines)
      :result result})))

(defn solve-2
  "Part 2: count crossings using the more precise dial arithmetic."
  ([]
   (solve-2 "../inputs/day01.txt"))
  ([path]
   (let [lines (->> path slurp str/split-lines (remove str/blank?))
         steps (map parse-step lines)
         result (count-returns-to-zero-2 steps)]
     {:lines-read (count lines)
      :result result})))
