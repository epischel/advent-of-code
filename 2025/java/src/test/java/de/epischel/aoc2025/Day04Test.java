package de.epischel.aoc2025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day04Test {

    @Test
    void testExampleOne() {
        String lines = "..@@.@@@@.\n" +
                "@@@.@.@.@@\n" +
                "@@@@@.@.@@\n" +
                "@.@@@@..@.\n" +
                "@@.@@@@.@@\n" +
                ".@@@@@@@.@\n" +
                ".@.@.@.@@@\n" +
                "@.@@@.@@@@\n" +
                ".@@@@@@@@.\n" +
                "@.@.@@@.@.";
        String[] split = lines.split("\\n");
        IO.println(split.length);
        char[][] area = new char[split.length][split[0].length()];
        for (int i = 0; i < split.length; i++) {
            area[i] = split[i].toCharArray();
        }

        int actual = Day04One.calcNumberAccessiblePaperRolls(area);
        Assertions.assertEquals(13, actual);
    }
}
