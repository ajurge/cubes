package com.bipinet.cubes.corners;


import com.bipinet.cubes.cube.Cube;
import com.bipinet.cubes.pieces.Piece;
import com.bipinet.cubes.sides.Sides;

import java.util.List;

/**
 * Interface providing contract methods for matching each corner in {@link Sides} of the {@link Cube}.
 */
public interface Corners {
    
    /**
     * Match corner at the bottom left of the front side in {@link Sides}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchBottomFrontLeft(List<Piece> pieces);
    
    /**
     * Match corner at the bottom right of the front side in {@link Sides}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchBottomFrontRight(List<Piece> pieces);
    
    /**
     * Match corner at the bottom left of the back side in {@link Sides}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchBottomBackLeft(List<Piece> pieces);
    
    /**
     * Match corner at the bottom right of the back side in {@link Sides}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchBottomBackRight(List<Piece> pieces);
    
    /**
     * Match corner at the top left of the front side in {@link Sides}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchTopFrontLeft(List<Piece> pieces);
    
    /**
     * Match corner at the top right of the front side in {@link Sides}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchTopFrontRight(List<Piece> pieces);
    
    /**
     * Match corner at the top left of the back side in {@link Sides}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchTopBackLeft(List<Piece> pieces);
    
    /**
     * Match corner at the top right of the back side in {@link Sides}
     * @param pieces {@link List} of {@link Piece}s that will be used for corner matching.
     * @return true if matched, false otherwise.
     */
    boolean matchTopBackRight(List<Piece> pieces);
}
