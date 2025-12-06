package de.epischel.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Day02One {

    record Range(long min, long max) {}

    static void main() throws IOException {
        var lines = Files.readAllLines(Path.of("../inputs/day02.txt"));
        long sum = calculateSum(lines);
        IO.println(sum);
    }

    static long calculateSum(List<String> lines) {
        return lines.stream()
                .flatMap(line-> Arrays.stream(line.split(",")))
                .map(r1 ->
                        new Range(
                                Long.parseLong(r1.substring(0, r1.indexOf('-'))),
                                Long.parseLong(r1.substring(r1.indexOf('-')+1))))
                .flatMapToLong(r -> LongStream.rangeClosed(r.min, r.max))
                .filter(Day02One::isInvalidId)
                .reduce(0L, Long::sum);
    }

    static boolean isInvalidId(long number) {
        var asString = Long.toString(number);
        if (asString.length() % 2 != 0) {
            return false;
        }
        var first = asString.substring(0, asString.length()/2);
        var second = asString.substring(asString.length()/2);
        boolean result = first.compareTo(second) == 0;
        if (result) {
            IO.println("invalid id "+number);
        }
        return result;
    }
}
