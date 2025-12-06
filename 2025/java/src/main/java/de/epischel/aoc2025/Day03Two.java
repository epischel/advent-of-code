package de.epischel.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day03Two {

    static void main() throws IOException {
        var lines = Files.readAllLines(Path.of("../inputs/day03.txt"));
        long total = calcTotalOutputJoltage(lines);
        IO.println("Total Output Joltage: "+total);
    }

    static long calcTotalOutputJoltage(List<String> lines) {
        return lines.stream()
                .mapToLong(Day03Two::calcLargestPossibleJoltage)
                .sum();
    }

    private static long calcLargestPossibleJoltage(String s) {
        final char[] chars = s.toCharArray();
        PositionalValue pv = new PositionalValue('0',-1);
        final List<PositionalValue> joltages = new ArrayList<>();
        for(int i=11; i>=0; i--){
            pv = calcLargestPossibleJoltageSub(chars, pv.position+1, chars.length-i);
            joltages.add(pv);
        }
        final var sb = new StringBuilder();
        joltages.forEach(p->sb.append(p.character));
        return Long.parseLong(sb.toString());
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
