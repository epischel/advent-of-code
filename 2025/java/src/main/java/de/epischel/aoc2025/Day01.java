package de.epischel.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day01 {
  static void main() throws IOException {
      var lines = Files.readAllLines(Path.of("../inputs/day01.txt"));
      IO.println("read "+lines.size() + " lines");
      long dial = 50;
      long reached0 = 0;
      int linenr = 0;

      for (var line : lines) {
          int nr = Integer.parseInt(line.substring(1));
          if (line.startsWith("L")) {
              nr = nr * -1;
          }
          dial += nr;
          if (dial % 100 == 0) {
              reached0++;
          }
          linenr++;
      }
      IO.println("Ergebnis: "+reached0);
  }
}
