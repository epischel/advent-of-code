package de.epischel.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day01TwoReduce {
  static void main() throws IOException {
      var lines = Files.readAllLines(Path.of("../inputs/day01.txt"));
      IO.println("read "+lines.size() + " lines");
      long reached0 = getReached0(lines);
      IO.println("Ergebnis: "+reached0);
  }

  static long mod(long a, long mod) {
      return Day01Two.mod(a, mod);
  }

  record SafeDialer(int position, int nextDial, int reached0){};

  static final int MODULUS = 100;
  static final SafeDialer initialPosition = new SafeDialer(50, 0, 0);

    static long getReached0(List<String> lines) {
        var result = lines.stream()
                .map(Day01TwoReduce::extractNumber)
                .map(i -> new SafeDialer(0, i,0))
                .reduce(initialPosition, Day01TwoReduce::acc);

        return result.reached0;
    }

    private static SafeDialer acc(SafeDialer old, SafeDialer dialed) {
        int dial = old.position;
        int nr = dialed.nextDial;
        int reached0 = old.reached0;

        var fullDials = Math.abs(nr/MODULUS);
        reached0 += fullDials;
        var nrRemainder = nr%MODULUS;
        var modPlusDial = dial + nrRemainder;
        if (dial!=0 && (modPlusDial<0||modPlusDial>MODULUS)) {
            reached0++;
        }
        dial = Math.toIntExact(mod(dial + nr, MODULUS));
        if (dial==0) {
            reached0++;
        }

        return new SafeDialer(dial, 0, reached0);
    }

    private static int extractNumber(String line) {
        int nr = Integer.parseInt(line.substring(1));
        if (line.startsWith("L")) {
            nr = nr * -1;
        }
        return nr;
    }
}
