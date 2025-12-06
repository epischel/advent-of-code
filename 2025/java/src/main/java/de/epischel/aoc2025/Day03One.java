package de.epischel.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day03One {

    static void main() throws IOException {
        var lines = Files.readAllLines(Path.of("../inputs/day03.txt"));
        int total = calcTotalOutputJoltage(lines);
        IO.println("Total Output Joltage: "+total);
    }

    static int calcTotalOutputJoltage(List<String> lines) {
        return lines.stream()
                .mapToInt(Day03One::calcLargestPossibleJoltage)
                .sum();
    }

    private static int calcLargestPossibleJoltage(String s) {
        final char[] chars = s.toCharArray();
        final PositionalValue pv1 = calcLargestPossibleJoltageSub(chars, 0, chars.length-1);
        final PositionalValue pv2 = calcLargestPossibleJoltageSub(chars, pv1.position+1, chars.length);
        return Integer.parseInt(""+pv1.character+pv2.character);
    }

    private static PositionalValue calcLargestPossibleJoltageSub(char[] chars, int start, int end) {
        int position = start;
        char max = '0';
        for (int i = start; i < end; i++) {
            if (chars[i] > max) {
                max = chars[i];
                position = i;
            }
        }
        return new PositionalValue(max, position);
    }

    record PositionalValue(char character, int position) {}
}
