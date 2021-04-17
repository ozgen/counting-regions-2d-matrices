package com.mehmet_ozgen;

import com.mehmet_ozgen.interfaces.ZoneCounterInterface;
import com.mehmet_ozgen.models.Dimension;
import com.mehmet_ozgen.models.interfaces.MapInterface;


public class ZoneCounter implements ZoneCounterInterface {

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
        if (dimension != null) {
            for (int i = 0; i < dimension.height; i++) {
                for (int j = 0; j < dimension.width; j++) {

                    if (map.IsBorder(i, j)) {
                        counter++;
                        map.SetBorder(i, j);
                        check();

                    } else

                        //set this border 0 because we pass this coordinate.
                        map.ClearBorder(i, j);

                }
            }
        }
        return counter;
    }

/*
   check() is an recursive method that follows the border till the end on the map.
 */
    private void check() throws Exception {
        int x = map.GetBorder().getX();
        int y = map.GetBorder().getY();

        //set this border 0 because we pass this coordinate.
        map.ClearBorder(x, y);

        for (int k = 0; k < 8; k++) {
            int newX = x + row[k];
            int newY = y + col[k];
            if (map.IsBorder(newX, newY)) {
                map.SetBorder(newX, newY);
                check();
                break;
            }
        }

    }
}
