package de.epischel.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day04Two {

    record Point(int x, int y) {}

    static void main() throws IOException {
        var lines = Files.readAllLines(Path.of("../inputs/day04.txt"));
        char[][] area = new char[lines.size()][lines.getFirst().length()];
        for (int i = 0; i < lines.size(); i++) {
            area[i] = lines.get(i).toCharArray();
        }
        int total = calcNumberRemovablePaperRolls(area);
        IO.println("removable paper rolls: "+total);
    }

    static int calcNumberRemovablePaperRolls(char[][] area) {
        int sum = 0;
        int removableRolls = 0;
        do {
            List<Point> points = calcRemovablePaperRolls(area);
            removableRolls = points.size();
            sum += points.size();
            removePaperRolls(area, points);
        } while (removableRolls > 0);
        return sum;
    }

    private static void removePaperRolls(char[][] area, List<Point> points) {
        points.forEach(p-> { area[p.x][p.y]='.';});
    }

    static List<Point> calcRemovablePaperRolls(char[][] area) {
        var points = new ArrayList<Point>();
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (area[i][j] != '@') continue;
                if (Day04One.adjacentPaperRolls(area, i,j)<4) points.add(new Point(i, j));
            }
        }
        return points;
    }

}
