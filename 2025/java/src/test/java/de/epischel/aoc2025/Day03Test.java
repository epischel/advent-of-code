package de.epischel.aoc2025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day03Test {

    @Test
    void testExampleOne() {
        var lines = List.of("987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111");
        int actual = Day03One.calcTotalOutputJoltage(lines);
        Assertions.assertEquals(357, actual);
    }

    @Test
    void testExampleTwo() {
        var lines = List.of("987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111");
        long actual = Day03Two.calcTotalOutputJoltage(lines);
        Assertions.assertEquals(3121910778619L, actual);
    }

}
