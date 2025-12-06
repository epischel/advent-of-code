package de.epischel.aoc2025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day01TwoTest {

    @Test
    void test() {
        var lines = """
                L68
                L30
                R48
                L5
                R60
                L55
                L1
                L99
                R14
                L82
                """.lines().map(String::strip).toList();
        Assertions.assertEquals(6, Day01Two.getReached0(lines));
    }

    @Test
    void test2() {
        var result = Day01Two.getReached0(List.of("R1000"));
        Assertions.assertEquals(10, result);
    }

    @Test
    void testModulus() {
        Assertions.assertEquals(-18,-18 % 100);
        Assertions.assertEquals(18,18 % 100);
        Assertions.assertEquals(-18,-118 % 100);
        Assertions.assertEquals(18,118 % 100);
        int n = -18;
        int nn = Math.abs(n/100 + 1) * 100;
        int nnn = n + nn;
        Assertions.assertEquals(82,  nnn);
        Assertions.assertEquals(82, Day01Two.mod(-18, 100));
    }
}