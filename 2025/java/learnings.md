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

## Day 2

### flatmap

I know flatmap "combines" two streams but I always have to look up the exact way it works.

### ranges

Java Stream API has "ranges" (both int and long). Nice.

## Day 3

### Think

After I read the task I was off several hours and thought about a solution. 
The implemented solution came to my mind quickly. Later I wondered if we could
just take the top-2 largest digits independent of position but `1460` is a counter example
(largest digits are 6 and 4 -> 46, but the actual solution is 60)

### Arrays

When I started programming, famous "off-by-one" errors were common because
working with arrays and indices were common. Nowadays we often work with streams
and don't use indices at all. Back to working with arrays I took care to not
get a "off-by-one" error.

## Day 4

### ints instead of booleans

in `hasPaperRoll` I return an int (actual 1 or 0) instead of boolean because this can
directly used in summing the accessible paper rolls