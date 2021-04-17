package com.mehmet_ozgen.models;

import com.mehmet_ozgen.models.interfaces.MapInterface;

public class Map implements MapInterface {
    private Dimension dimension;
    private int[][] mapVal;
    private int[][] mapValToShow;
    public Border border;

    public Map(int[][] map) {
        this.mapVal = map;
        this.mapValToShow = map;
    }


    @Override
    public void SetSize(Dimension dim) {
        this.dimension = dim;
    }

    @Override
    public Dimension GetSize() {
        return dimension;
    }

    @Override
    public void SetBorder(int x, int y) throws Exception {
        if (dimension.CheckWithin(y, x)) {
            if (border == null)
                border = new Border();
            border.setX(x);
            border.setY(y);
        }

    }

    @Override
    public Border GetBorder() throws Exception {
        return border;
    }

    @Override
    public void ClearBorder(int x, int y) throws Exception {
        if (dimension.CheckWithin(y, x))
            mapVal[x][y] = 0;
    }

    @Override
    public boolean IsBorder(int x, int y) throws Exception {

        return dimension.CheckWithin(y, x) && (mapVal[x][y]) == 1;
    }

    @Override
    public void Show() {

        for (int i = 0; i < dimension.height; i++) {
            for (int j = 0; j < dimension.width; j++) {
                if (mapValToShow[i][j] == 1)
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }

    }

    @Override
    public int[][] GetMapValue() {
        return mapVal;
    }
}
