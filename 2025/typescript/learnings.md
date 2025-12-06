# Learnings while solving AOC 2025 puzzles in Java

(mostly) port from java by codex ai

## Day 01

### type annotations

style is `value: number` like in Pascal.

In TypeScript die wichtigsten eingebauten Typen:

- `string`, `number`, `boolean`, `bigint`, `symbol`
- `null`, `undefined`
- `void` (kein Wert), `never` (kein erreichbarer Wert), `unknown` (sicheres „weiß nicht“), `any` (unsicher „egal“)
- `object` (irgendein Nicht-Primitive), `{}` (beliebiges Wertobjekt, inkl. primitive), `Function` (beliebige Funktion)
- Collections sind abgeleitet: `T[]`/`Array<T>`, `Tupel [T1, T2]`, `ReadonlyArray<T>` usw.

Literaltypen (z. B. "on" oder 42) sind auch eingebaut, aber keine eigenen „Typklassen“. Enums sind ein Sprachfeature, aber kein primitive Built-in.



### declaring types

```
export type LoadedSteps = { inputPath: string; lines: string[]; steps: number[] };
```

### `readonly` means `final`

Ja. `readonly` gibt es für Objekte, Arrays und Tupel:

- Objektfelder: `type User = { readonly id: string; name: string };` — `id` kann nach Initialisierung nicht mehr verändert werden.
- Arrays: `ReadonlyArray<T>` oder `readonly T[]` machen das Array selbst nicht mutierbar (Methoden wie `push` fehlen), einzelne Elemente dürfen aber weiterhin referenztypisch intern veränderbar sein.
- Tupel: `readonly [number, string]` macht die Tupel-Länge/Position unveränderlich.

Wichtig: `readonly` ist nur ein TypeScript-Typmerkmal zur Compile-Zeit; zur Laufzeit wird nichts eingefroren.

