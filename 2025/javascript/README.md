# Advent of Code 2025 – JavaScript

## Quick start
- Install Node (v18+) and run `npm install` (no dependencies, generates `package-lock.json`).
- Execute Day 01 with the default input: `npm start`.
- Pass a custom input path: `node src/index.js /path/to/input.txt`.

## Layout
- `src/day01.js` contains the Day 01 solver functions.
- `src/index.js` is the entry point; it loads the input, runs both parts, and prints results.
- Inputs live one level up in `../inputs`, shared across languages.

## Day 01 notes
- Input lines like `L10`/`R5` describe turning a dial left/right by that amount.
- Part 1 counts how often the dial lands on multiples of 100 (starting at 50).
- Part 2 counts both full rotations and crossings of multiples of 100 on each step.
