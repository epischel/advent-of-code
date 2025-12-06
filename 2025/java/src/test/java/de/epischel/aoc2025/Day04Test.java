package de.epischel.aoc2025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day04Test {

    @Test
    void testExampleOne() {
        char[][] area = getChars();

        int actual = Day04One.calcNumberAccessiblePaperRolls(area);
        Assertions.assertEquals(13, actual);
    }

    @Test
    void testExampleTwo() {
        char[][] area = getChars();
        int actual = Day04Two.calcNumberRemovablePaperRolls(area);
        Assertions.assertEquals(43, actual);
    }

    private static char[][] getChars() {
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
        char[][] area = new char[split.length][split[0].length()];
        for (int i = 0; i < split.length; i++) {
            area[i] = split[i].toCharArray();
        }
        return area;
    }
}
