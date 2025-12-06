# Advent of Code 2025 – Python

## Quick start
- Use Python 3.11+ (no external dependencies needed).
- Optional: create a venv (`python3 -m venv .venv && source .venv/bin/activate`).
- Run Day 01 with the default input: `python3 -m src.index`.
- Pass a custom input path: `python3 -m src.index /path/to/input.txt`.

## Layout
- `src/day01.py` contains the Day 01 solver functions.
- `src/index.py` is the entry point; it loads the input, runs both parts, and prints results.
- Inputs live one level up in `../inputs`, shared across languages.

## Day 01 notes
- Input lines like `L10`/`R5` describe turning a dial left/right by that amount.
- Part 1 counts how often the dial lands on multiples of 100 (starting at 50).
- Part 2 counts both full rotations and crossings of multiples of 100 on each step.
