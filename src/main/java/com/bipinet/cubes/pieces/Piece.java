package com.bipinet.cubes.pieces;


import com.bipinet.cubes.corners.Corners;
import com.bipinet.cubes.cube.Cube;
import com.bipinet.cubes.edges.Edge;
import com.bipinet.cubes.sides.Sides;

/**
 * Interface with contract methods for pieces that will be matched to 
 * {@link Sides} and {@link Corners} of the {@link Cube}
 */
public interface Piece {
    /**
     * Rotate the piece by 90 degrees clockwise.
     */
    void rotate();

    /**
     * Flip the piece upside down.
     */
    void flip();

    /**
     * Get left edge of the piece.
     * @return reference to the {@link Edge}.
     */
    Edge getLeftEdge();
    
    /**
     * Get top edge of the piece.
     * @return reference to the {@link Edge}.
     */
    Edge getTopEdge();

    /**
     * Get right edge of the piece.
     * @return reference to the {@link Edge}.
     */
    Edge getRightEdge();

    /**
     * Get bottom edge of the piece.
     * @return reference to the {@link Edge}.
     */
    Edge getBottomEdge();

    /**
     * Print the piece as {@link String}.
     * @return String representation of the piece.
     */
    String print();

    /**
     * Print the piece as {@link String} with the passed in offset.
     * @param offset string with offset
     * @return String representation of the piece.
     */
    String printWithOffset(String offset);

    /**
     * Convert the piece to {@link String} array.
     * @return String array with the piece {@link Edge}s.
     */
    String[] toStringArray();
}
