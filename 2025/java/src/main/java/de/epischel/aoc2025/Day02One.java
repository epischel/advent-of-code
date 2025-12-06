package de.epischel.aoc2025;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Day02One {

    record Range(long min, long max) {}

    static void main() throws IOException {
        var lines = Files.readAllLines(Path.of("../inputs/day02.txt"));
        long sum = calculateSum(lines);
        IO.println(sum);
    }

    static long calculateSum(List<String> lines) {
        final List<Range> ranges = lines.stream()
                .flatMap(line-> Arrays.stream(line.split(",")))
                .map(r ->
                        new Range(
                                Long.parseLong(r.substring(0,r.indexOf('-'))),
                                Long.parseLong(r.substring(r.indexOf('-')+1))))
                .toList();
        IO.println("got "+ranges.size()+" ranges");
        long sum = 0;
        for (Range range : ranges) {
            for (long i = range.min; i <= range.max; i++) {
                if (isInvalidId(i)) sum += i;
            }
        }
        return sum;
    }

    static boolean isInvalidId(long number) {
        var asString = Long.toString(number);
        if (asString.length() % 2 != 0) {
            return false;
        }
        var first = asString.substring(0, asString.length()/2);
        var second = asString.substring(asString.length()/2);
        //IO.println(first + " " + second);
        boolean result = first.compareTo(second) == 0;
        if (result) {
            IO.println("invalid id "+number);
        }
        return result;
    }
}
