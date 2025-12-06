import path from "node:path";
import { pathToFileURL } from "node:url";
import { loadLines, parseRange } from "./day02.js";

const calculateSumFromLinesPart2 = (
  lines,
  { logInvalidIds = true } = {},
) => {
  let sum = 0;
  for (const token of lines.flatMap((line) =>
    line.split(",").map((t) => t.trim()),
  )) {
    const { min, max } = parseRange(token);
    for (let n = min; n <= max; n += 1) {
      if (isInvalidIdRepeated(n, { log: logInvalidIds })) {
        sum += n;
      }
    }
  }

  return sum;
};

export const isInvalidIdRepeated = (value, { log = true } = {}) => {
  const digits = String(value);
  const halfLength = Math.floor(digits.length / 2);

  for (let size = 1; size <= halfLength; size += 1) {
    if (digits.length % size !== 0) continue;

    const chunk = digits.slice(0, size);
    const repeated = chunk.repeat(digits.length / size);
    if (repeated === digits) {
      if (log) {
        console.log(
          `Found invalidId: ${digits} in step ${size} (${repeated})`,
        );
      }
      return true;
    }
  }

  return false;
};

export const solveDay02Part2 = (
  inputPath,
  { logInvalidIds = true } = {},
) => {
  const { inputPath: resolved, lines } = loadLines(inputPath);
  return {
    inputPath: resolved,
    linesRead: lines.length,
    result: calculateSumFromLinesPart2(lines, { logInvalidIds }),
  };
};

const runFromCli = () => {
  const [, , inputArg] = process.argv;
  const { inputPath: resolved, linesRead, result } = solveDay02Part2(
    inputArg,
  );

  console.log(`read ${linesRead} lines from ${resolved}`);
  console.log(`Ergebnis Teil 2: ${result}`);
};

const invokedDirectly =
  process.argv[1] &&
  import.meta.url === pathToFileURL(process.argv[1]).href;

if (invokedDirectly) {
  runFromCli();
}
