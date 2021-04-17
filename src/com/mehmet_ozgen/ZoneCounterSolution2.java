package com.mehmet_ozgen;

import com.mehmet_ozgen.interfaces.ZoneCounterInterface;
import com.mehmet_ozgen.models.Dimension;
import com.mehmet_ozgen.models.interfaces.MapInterface;


public class ZoneCounterSolution2 implements ZoneCounterInterface {

    private MapInterface map;
    private Dimension dimension;


    // Below arrays detail all eight possible movements from a cell
    // (top, right, bottom, left, and four diagonal moves)
    private static final int[] row = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] col = {-1, 1, 0, -1, -1, 1, 0, 1};

    @Override
    public void Init(MapInterface map) throws Exception {
        this.map = map;
        this.dimension = map.GetSize();

    }

    @Override
    public int Solve() throws Exception {
        int counter = 1;
        int matrix[][] = map.GetMapValue();
        boolean[][] visited = new boolean[dimension.height][dimension.width];
        for (int i = 0; i < dimension.height; i++) {
            for (int j = 0; j < dimension.width; j++) {

                if (matrix[i][j] == 1 && !visited[i][j]) {
                    counter++;
                    check(i, j, visited);

                } else
                    visited[i][j] = true;

            }
        }
        return counter;
    }

    private void check(int x, int y, boolean[][] visited) throws Exception {

        visited[x][y] = true;

        for (int k = 0; k < 8; k++) {
            int newX = x + row[k];
            int newY = y + col[k];
            if (map.IsBorder(newX, newY) && !visited[newX][newY]) {
                check(newX, newY, visited);
                break;
            }
        }

    }
}
