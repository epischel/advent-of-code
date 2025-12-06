package de.epischel.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day04One {

    static void main() throws IOException {
        var lines = Files.readAllLines(Path.of("../inputs/day04.txt"));
        char[][] area = new char[lines.size()][lines.getFirst().length()];
        for (int i = 0; i < lines.size(); i++) {
            area[i] = lines.get(i).toCharArray();
        }
        int total = calcNumberAccessiblePaperRolls(area);
        IO.println("Accessible paper rolls: "+total);
    }

    static int calcNumberAccessiblePaperRolls(char[][] area) {
        int sum = 0;
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
               if (area[i][j] != '@') continue;
               if (adjacentPaperRolls(area, i,j)<4) sum++;
            }
        }
        return sum;
    }

    static int adjacentPaperRolls(char[][] area, int x, int y) {
        int sum = 0;
        for(int i = x-1; i <= x+1; i++) {
            for(int j = y-1; j <= y+1; j++) {
                if (x==i && y==j) continue;
                sum += hasPaperRoll(area, i, j);
            }
        }
        return sum;
    }

    static int hasPaperRoll(char[][] area, int x, int y) {
        if (x<0||y<0||x>=area.length||y>=area[0].length)
            return 0;
        return area[x][y]=='@'?1:0;
    }
}
