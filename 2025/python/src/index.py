from __future__ import annotations

import sys
from typing import Sequence

from .day01 import (
    count_returns_to_zero,
    count_returns_to_zero_crossings,
    count_returns_to_zero_crossings_reduce,
    load_steps,
)


def main(argv: Sequence[str] | None = None) -> None:
    args = list(argv) if argv is not None else sys.argv[1:]
    input_arg = args[0] if args else None

    loaded = load_steps(input_arg)
    lines = loaded["lines"]
    steps = loaded["steps"]

    print(f"read {len(lines)} lines from {loaded['input_path']}")
    print(f"Ergebnis Teil 1: {count_returns_to_zero(steps)}")
    print(f"Ergebnis Teil 2: {count_returns_to_zero_crossings(steps)}")
    print(f"Ergebnis Teil 2 (reduce): {count_returns_to_zero_crossings_reduce(steps)}")


if __name__ == "__main__":
    main()
