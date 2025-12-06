package de.epischel.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Day02Two {

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
                .filter(Day02Two::isInvalidId)
                .reduce(0L, Long::sum);
    }

    static boolean isInvalidId(long number) {
        var asString = Long.toString(number);
        int halfLength = asString.length() / 2;
        // try repeatedly longer subsequences
        for(int i = 1; i <= halfLength; i++) {
            if (asString.length() % i != 0) continue;
            var substring = asString.substring(0, i);
            var repeated = substring.repeat(asString.length()/i);
            if (repeated.equals(asString)) {
                IO.println("Found invalidId: "+asString+" in step "+i+" ("+repeated+")");
                return true;
            }
        }
        return false;
    }

}
