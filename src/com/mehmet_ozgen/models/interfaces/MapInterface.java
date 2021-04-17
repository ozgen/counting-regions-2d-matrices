package com.mehmet_ozgen.models.interfaces;


import com.mehmet_ozgen.models.Border;
import com.mehmet_ozgen.models.Dimension;

public interface MapInterface {

    //Initial values in area of map


    // Creates / Allocates a map of given size.
    void SetSize(Dimension dim);

    // Get dimensions of given map.

    Dimension GetSize();

    // Sets border at given point.
    void SetBorder(int x, int y) throws Exception;

    // Gets border that you set.
    Border GetBorder() throws Exception;

    // Clears border at given point.

    void ClearBorder(int x, int y) throws Exception;

    // Checks if given point is border.

    boolean IsBorder(int x, int y) throws Exception;

    // Show map contents.

    void Show();

    //Get the 2D map matrices which contains 0 and 1

    int[][] GetMapValue();
}
