# Learnings while solving AOC 2025 puzzles in Java

## Day 01

### Reading all lines of a file is a one-liner now

This

`var lines = Files.readAllLines(Path.of("../inputs/day01.txt"));`

is nice. No more ´BufferedReader` etc.

### mod vs "%"

`-18 mod 100 = 82` but `-18 % 100 = -18` means I need to implement
the former myself

### Read the assignment in full

The last line gave a hint that the dial can be turned multiple times ("R1000").
I did not account for that in the beginning.

### `reduce` is nice if it's applicable

In this situation (turning the dialer and counting how often it passes "0")
can be modeled as state and so `reduce` is nicely to use in this situation