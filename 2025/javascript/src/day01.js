import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

const MODULUS = 100;
const __dirname = path.dirname(fileURLToPath(import.meta.url));
const projectRoot = path.resolve(__dirname, "..");
const defaultInputPath = path.resolve(projectRoot, "../inputs/day01.txt");

const mod = (value, divisor) => ((value % divisor) + divisor) % divisor; // keep remainder positive
const quot = (value, divisor) => Math.trunc(value / divisor);

export const parseStep = (line) => {
  const magnitude = Number(line.slice(1));

  if (Number.isNaN(magnitude)) {
    throw new Error(`Invalid step: ${line}`);
  }

  return line.startsWith("L") ? -magnitude : magnitude;
};

export const loadSteps = (inputPath = defaultInputPath) => {
  const resolvedPath = path.isAbsolute(inputPath)
    ? inputPath
    : path.resolve(projectRoot, inputPath);

  const lines = fs
    .readFileSync(resolvedPath, "utf8")
    .split(/\r?\n/)
    .map((line) => line.trim())
    .filter(Boolean);

  return { inputPath: resolvedPath, lines, steps: lines.map(parseStep) };
};

export const countReturnsToZero = (steps) => {
  const { reached0 } = steps.reduce(
    ({ dial, reached0: hits }, step) => {
      const dialAfterStep = dial + step;
      const hit = dialAfterStep % MODULUS === 0;

      return {
        dial: dialAfterStep,
        reached0: hit ? hits + 1 : hits,
      };
    },
    { dial: 50, reached0: 0 },
  );

  return reached0;
};

export const countReturnsToZeroCrossings = (steps) => {
  const { reached0 } = steps.reduce(
    ({ dial, reached0: hits }, step) => {
      const fullDials = Math.abs(quot(step, MODULUS));
      const stepRem = step % MODULUS;
      const modPlusDial = dial + stepRem;
      const crossed =
        dial !== 0 && (modPlusDial < 0 || modPlusDial > MODULUS);
      const dialWrapped = mod(dial + step, MODULUS);
      const landedOnMark = dialWrapped === 0;

      return {
        dial: dialWrapped,
        reached0:
          hits +
          fullDials +
          (crossed ? 1 : 0) +
          (landedOnMark ? 1 : 0),
      };
    },
    { dial: 50, reached0: 0 },
  );

  return reached0;
};

export const countReturnsToZeroCrossingsReduce = (steps) => {
  // Variant mirroring Day01TwoReduce from the Java version.
  const { reached0 } = steps.reduce(
    ({ position, reached0: hits }, nextDial) => {
      const fullDials = Math.abs(quot(nextDial, MODULUS));
      const stepRem = nextDial % MODULUS;
      const modPlusDial = position + stepRem;
      const crossed =
        position !== 0 && (modPlusDial < 0 || modPlusDial > MODULUS);
      const positionWrapped = mod(position + nextDial, MODULUS);
      const landedOnMark = positionWrapped === 0;

      return {
        position: positionWrapped,
        reached0:
          hits +
          fullDials +
          (crossed ? 1 : 0) +
          (landedOnMark ? 1 : 0),
      };
    },
    { position: 50, reached0: 0 },
  );

  return reached0;
};

export const solvePart1 = (inputPath) => {
  const { inputPath: resolved, lines, steps } = loadSteps(inputPath);
  return {
    inputPath: resolved,
    linesRead: lines.length,
    result: countReturnsToZero(steps),
  };
};

export const solvePart2 = (inputPath) => {
  const { inputPath: resolved, lines, steps } = loadSteps(inputPath);
  return {
    inputPath: resolved,
    linesRead: lines.length,
    result: countReturnsToZeroCrossings(steps),
  };
};

export const solvePart2Reduce = (inputPath) => {
  const { inputPath: resolved, lines, steps } = loadSteps(inputPath);
  return {
    inputPath: resolved,
    linesRead: lines.length,
    result: countReturnsToZeroCrossingsReduce(steps),
  };
};
