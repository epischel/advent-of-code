# Learnings while solving AOC 2025 puzzles in Clojure


(mostly ported by codex ai)

I haven't used clojure for quite a while.

## Day 01


### thread-first and thread-last

`->` (thread-first) inserts the previous value as the first argument of each form; `->>` (thread-last) inserts it as the last argument of each form. This is used a lot in clojure

you build "pipelines" like
```
[lines (->> path slurp str/split-lines (remove str/blank?))
```

which is roughly a nested call chain
```
collections.remove(str::blank, str.split-lines(slurp(path)))
```

or
```
                  :reached0 (-> reached0
                                (+ full-dials)
                                (cond-> crossed? inc)
                                (cond-> hits? inc))}))
```
which is
```
reached0 = reached0 + full-dials
if (crossed?) reached0++;
if (hits?) reached0++;
```

I think this "pipeline" with `cond->` is quite clever.

## binding form

as a more procedural or OO programmer, binding form looks like a part where variables are declared (and assigned). but pretty much can happen here, effectively the whole "computation" of the function can happen here

## destructuring

like `[{:keys [position reached0]} next-dial]` - maybe java will get that someday or maybe it is not as important?




