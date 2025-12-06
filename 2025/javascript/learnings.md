# Learnings while solving AOC 2025 puzzles in Java

(mostly) port from java by codex ai

## Day 01

### imports

- `import foo from "bar"` holt den Default-Export des Moduls und bindet ihn an den Namen foo. Funktioniert nur, wenn das Modul einen default exportiert (`export default …`).
- `import { foo } from "bar"` holt einen benannten Export foo aus dem Modul. Funktioniert nur, wenn das Modul genau diesen Namen exportiert (`export const foo = … oder export { foo }`).
- Beides kann kombiniert werden: `import foo, { bar, baz as qux } from "mod"`

## native maps

maybe originating from lisp heritage of javascript, js has native maps:
```
return { inputPath: resolvedPath, lines, steps: lines.map(parseStep) };
```

as an untyped language (similar to clojure) and more "build-in" ways to handle maps, using maps is more ideomatic in JS.
