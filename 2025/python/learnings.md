# Learnings while solving AOC 2025 puzzles in Python

(mostly) port from java by codex ai

## Day 01

### integer division vs. floor division

- Python's `//` floors negative numbers; Java truncates toward zero. To mirror Java's behavior, use `math.trunc(value / divisor)` for the quotient and derive the remainder from that.

### safe modulo for wrap-around

- `((value % divisor) + divisor) % divisor` keeps the result in the positive range even for negative values, mirroring the helper `mod` function from the Java version.

### resolving input paths

- Anchoring paths off `__file__` keeps `../inputs/day01.txt` reachable no matter where the script is launched from.
