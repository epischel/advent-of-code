import fs from "node:fs";
import path from "node:path";
import { fileURLToPath, pathToFileURL } from "node:url";

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const projectRoot = path.resolve(__dirname, "..");
const defaultInputPath = path.resolve(projectRoot, "../inputs/day02.txt");

export const parseRange = (token) => {
  const [minText, maxText] = token.split("-");
  const min = Number(minText);
  const max = Number(maxText);

  if (maxText === undefined || Number.isNaN(min) || Number.isNaN(max)) {
    throw new Error(`Invalid range: ${token}`);
  }

  return { min, max };
};

export const loadLines = (inputPath = defaultInputPath) => {
  const resolvedPath = path.isAbsolute(inputPath)
    ? inputPath
    : path.resolve(projectRoot, inputPath);

  const lines = fs
    .readFileSync(resolvedPath, "utf8")
    .split(/\r?\n/)
    .map((line) => line.trim())
    .filter(Boolean);

  return { inputPath: resolvedPath, lines };
};

export const isInvalidId = (value, { log = true } = {}) => {
  const digits = String(value);
  if (digits.length % 2 !== 0) return false;

  const half = digits.length / 2;
  const mirrored = digits.slice(0, half) === digits.slice(half);

  if (mirrored && log) {
    console.log(`invalid id ${value}`);
  }

  return mirrored;
};

export const calculateSumFromLines = (lines, { logInvalidIds = true } = {}) => {
  const rangeTokens = lines.flatMap((line) =>
    line.split(",").map((token) => token.trim()),
  );

  let sum = 0;
  for (const token of rangeTokens) {
    const { min, max } = parseRange(token);

    for (let n = min; n <= max; n += 1) {
      if (isInvalidId(n, { log: logInvalidIds })) {
        sum += n;
      }
    }
  }

  return sum;
};

export const solveDay02 = (inputPath, { logInvalidIds = true } = {}) => {
  const { inputPath: resolved, lines } = loadLines(inputPath);

  return {
    inputPath: resolved,
    linesRead: lines.length,
    result: calculateSumFromLines(lines, { logInvalidIds }),
  };
};

const runFromCli = () => {
  const [, , inputArg] = process.argv;
  const { inputPath: resolved, linesRead, result } = solveDay02(inputArg);

  console.log(`read ${linesRead} lines from ${resolved}`);
  console.log(`Ergebnis: ${result}`);
};

const invokedDirectly =
  process.argv[1] &&
  import.meta.url === pathToFileURL(process.argv[1]).href;

if (invokedDirectly) {
  runFromCli();
}
