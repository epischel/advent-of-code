# Advent of Code 2025 – Clojure

## Quick start
- Run `clj -M:run` to execute `aoc.core/-main`.
- Start an nREPL for interactive work: `clj -M:repl`.

## Layout
- `src/` contains all solution namespaces (e.g., `src/aoc/day01.clj`).

Happy coding! This repo uses the Clojure CLI (`deps.edn`) with `src` on the classpath.

## Day 01
- Input file expected at `../inputs/day01.txt` (relative to this directory).
- Run `clj -M:run` to print Part 1 (simple multiples-of-100 hits), Part 2 (crossings), and a second Part 2 variant implemented as a reduce pass.
