package de.epischel.aoc2025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day02OneTest {

    @Test
    void testExample() {
        var ranges = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                "824824821-824824827,2121212118-2121212124";
        var result = Day02One.calculateSum(List.of(ranges));
        Assertions.assertEquals(1227775554L,  result);
    }


    @Test
    void testMissing1() {
        var ranges = "1188511880-1188511890";
        var result = Day02One.calculateSum(List.of(ranges));
        Assertions.assertEquals(1188511885L,  result);
    }
}
