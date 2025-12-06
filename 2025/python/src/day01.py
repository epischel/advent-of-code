from __future__ import annotations

import math
from functools import reduce
from pathlib import Path
from typing import Iterable, Sequence, TypedDict

MODULUS = 100
START_POSITION = 50
PROJECT_ROOT = Path(__file__).resolve().parent.parent
DEFAULT_INPUT_PATH = (PROJECT_ROOT.parent / "inputs/day01.txt").resolve()


class LoadedSteps(TypedDict):
    input_path: Path
    lines: list[str]
    steps: list[int]


class SolveResult(TypedDict):
    input_path: Path
    lines_read: int
    result: int


def mod(value: int, divisor: int) -> int:
    return ((value % divisor) + divisor) % divisor


def quot(value: int, divisor: int) -> int:
    return math.trunc(value / divisor)


def remainder(value: int, divisor: int) -> int:
    # Match Java's remainder that keeps the sign of the dividend.
    return value - quot(value, divisor) * divisor


def parse_step(line: str) -> int:
    stripped = line.strip()
    if not stripped:
        raise ValueError("Empty step")

    magnitude = int(stripped[1:])
    return -magnitude if stripped.startswith("L") else magnitude


def load_steps(input_path: str | Path | None = None) -> LoadedSteps:
    resolved = Path(input_path) if input_path is not None else DEFAULT_INPUT_PATH
    if not resolved.is_absolute():
        resolved = (PROJECT_ROOT / resolved).resolve()

    lines = [line.strip() for line in resolved.read_text().splitlines() if line.strip()]
    return {"input_path": resolved, "lines": lines, "steps": [parse_step(line) for line in lines]}


def count_returns_to_zero(steps: Sequence[int]) -> int:
    dial = START_POSITION
    reached0 = 0

    for step in steps:
        dial += step
        if dial % MODULUS == 0:
            reached0 += 1

    return reached0


def count_returns_to_zero_crossings(steps: Sequence[int]) -> int:
    dial = START_POSITION
    reached0 = 0

    for step in steps:
        full_dials = abs(quot(step, MODULUS))
        step_rem = remainder(step, MODULUS)
        mod_plus_dial = dial + step_rem
        crossed = dial != 0 and (mod_plus_dial < 0 or mod_plus_dial > MODULUS)
        dial_wrapped = mod(dial + step, MODULUS)
        landed_on_mark = dial_wrapped == 0

        reached0 += full_dials + (1 if crossed else 0) + (1 if landed_on_mark else 0)
        dial = dial_wrapped

    return reached0


def count_returns_to_zero_crossings_reduce(steps: Sequence[int]) -> int:
    def reducer(state: tuple[int, int], next_dial: int) -> tuple[int, int]:
        position, hits = state

        full_dials = abs(quot(next_dial, MODULUS))
        step_rem = remainder(next_dial, MODULUS)
        mod_plus_dial = position + step_rem
        crossed = position != 0 and (mod_plus_dial < 0 or mod_plus_dial > MODULUS)
        position_wrapped = mod(position + next_dial, MODULUS)
        landed_on_mark = position_wrapped == 0

        reached = hits + full_dials + (1 if crossed else 0) + (1 if landed_on_mark else 0)
        return position_wrapped, reached

    _, reached0 = reduce(reducer, steps, (START_POSITION, 0))
    return reached0


def solve_part1(input_path: str | Path | None = None) -> SolveResult:
    loaded = load_steps(input_path)
    steps: Iterable[int] = loaded["steps"]
    return {
        "input_path": loaded["input_path"],
        "lines_read": len(loaded["lines"]),
        "result": count_returns_to_zero(steps),
    }


def solve_part2(input_path: str | Path | None = None) -> SolveResult:
    loaded = load_steps(input_path)
    steps: Iterable[int] = loaded["steps"]
    return {
        "input_path": loaded["input_path"],
        "lines_read": len(loaded["lines"]),
        "result": count_returns_to_zero_crossings(steps),
    }


def solve_part2_reduce(input_path: str | Path | None = None) -> SolveResult:
    loaded = load_steps(input_path)
    steps: Iterable[int] = loaded["steps"]
    return {
        "input_path": loaded["input_path"],
        "lines_read": len(loaded["lines"]),
        "result": count_returns_to_zero_crossings_reduce(steps),
    }
