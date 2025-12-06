package de.epischel.aoc2025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day03OneTest {

    @Test
    void testExample() {
        var lines = List.of("987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111");
        int actual = Day03One.calcTotalOutputJoltage(lines);
        Assertions.assertEquals(357, actual);
    }
}
