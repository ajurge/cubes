package com.bipinet.cubes.sides;


import com.bipinet.cubes.cube.Cube;
import com.bipinet.cubes.pieces.Piece;

import java.util.List;
/**
 * Interface providing contract methods for matching each sides of the {@link Cube}.
 */
public interface Sides {
    
    /**
     * Match left side of the {@link Cube}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchLeft(List<Piece> pieces);
    
    /**
     * Match bottom side of the {@link Cube}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchBottom(List<Piece> pieces);
    
    /**
     * Match front side of the {@link Cube}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchFront(List<Piece> pieces);
    
    /**
     * Match top side of the {@link Cube}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchTop(List<Piece> pieces);
    /**
     * Match back side of the {@link Cube}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchBack(List<Piece> pieces);

    /**
     * Match right side of the {@link Cube}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchRight(List<Piece> pieces);
}
