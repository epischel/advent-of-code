package de.epischel.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day01Two {
  static void main() throws IOException {
      var lines = Files.readAllLines(Path.of("../inputs/day01.txt"));
      IO.println("read "+lines.size() + " lines");
      long reached0 = getReached0(lines);
      IO.println("Ergebnis: "+reached0);
  }

  static long mod(long a, long mod) {
      if (a>=0) {
          return a%mod;
      } else if (a % mod == 0) {
          return 0;
      }
      long nn = ((-a/mod) + 1) * mod;
      return a + nn;
  }

    static long getReached0(List<String> lines) {
        final int MODULUS = 100;
        long dial = 50;
        long reached0 = 0;
        int linenr = 0;

        for (var line : lines) {
            int nr = Integer.parseInt(line.substring(1));
            if (line.startsWith("L")) {
                nr = nr * -1;
            }
            var fullDials = Math.abs(nr/MODULUS);
            reached0 += fullDials;
            var nrRemainder = nr%MODULUS;
            var modPlusDial = dial + nrRemainder;
            if (dial!=0 && (modPlusDial<0||modPlusDial>MODULUS)) {
                reached0++;
            }
            dial = mod(dial+nr, MODULUS);
            if (dial==0) {
                reached0++;
            }
            linenr++;
        }
        return reached0;
    }
}
