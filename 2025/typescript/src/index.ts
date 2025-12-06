import {
  loadSteps,
  countReturnsToZero,
  countReturnsToZeroCrossings,
  countReturnsToZeroCrossingsReduce,
} from "./day01.js";

const [, , inputArg] = process.argv;
const { lines, steps, inputPath } = loadSteps(inputArg);

console.log(`read ${lines.length} lines from ${inputPath}`);
console.log(`Ergebnis Teil 1: ${countReturnsToZero(steps)}`);
console.log(`Ergebnis Teil 2: ${countReturnsToZeroCrossings(steps)}`);
console.log(`Ergebnis Teil 2 (reduce): ${countReturnsToZeroCrossingsReduce(steps)}`);
