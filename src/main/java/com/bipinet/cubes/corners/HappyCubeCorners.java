package com.bipinet.cubes.corners;


import com.bipinet.cubes.cube.HappyCube;
import com.bipinet.cubes.edges.EdgeType;
import com.bipinet.cubes.pieces.HappyCubePiece;
import com.bipinet.cubes.pieces.Piece;
import java.util.*;


/**
 * Implementation of the {@link Corners} matching for the {@link HappyCube}.
 * 
 *   
 * <p> Happy Cube side marking:
 * <pre>
 *     0 - LEFT
 *     1 - BOTTOM
 *     2 - FRONT
 *     3 - TOP
 *     4 - BACK
 *     5 - RIGHT
    </pre> 
 *
 * <p> Happy Cube in unfolded representation.  
 * 
    <pre>                 
 *         ooooo ooooo ooooo
 *         o   o o   o o   o
 *         o 0 o o 1 o o 5 o  
 *         o   o o   o o   o
 *         ooooo ooooo ooooo 
 *     
*                ooooo
*                o   o
*                o 2 o
*                o   o
*                ooooo
*
*                ooooo
*                o   o
*                o 3 o
*                o   o
*                ooooo
*                
*                ooooo
*                o   o
*                o 4 o
*                o   o
*                ooooo
    </pre>          
 *    
    <p> Happy Cube edge marking.   
    <pre>  
 *                 TOP
 *                ooooo
 *                o   o
 *          LEFT  o   o  RIGHT
 *                o   o
 *                ooooo
 *   
 *                BOTTOM
    </pre>
 */
public class HappyCubeCorners implements Corners {

    @Override
    public boolean matchBottomFrontLeft(List<Piece> pieces) {
        final List<Character> corner = new ArrayList<>(Arrays.asList(
                ((HappyCubePiece)pieces.get(0)).getEdgeCornerAtEnd(EdgeType.RIGHT),
                ((HappyCubePiece)pieces.get(1)).getEdgeCornerAtEnd(EdgeType.LEFT),
                ((HappyCubePiece)pieces.get(2)).getEdgeCornerAtStart(EdgeType.TOP)
        ));        
        return isCornerMatched(corner);
    }

    @Override
    public boolean matchBottomFrontRight(List<Piece> pieces) {
        final List<Character> corner = new ArrayList<>(Arrays.asList(
                ((HappyCubePiece)pieces.get(1)).getEdgeCornerAtEnd(EdgeType.RIGHT),
                ((HappyCubePiece)pieces.get(5)).getEdgeCornerAtEnd(EdgeType.LEFT),
                ((HappyCubePiece)pieces.get(2)).getEdgeCornerAtEnd(EdgeType.TOP)
        ));
        return isCornerMatched(corner);
    }

    @Override
    public boolean matchBottomBackLeft(List<Piece> pieces) {
        final List<Character> corner = new ArrayList<>(Arrays.asList(
                ((HappyCubePiece)pieces.get(0)).getEdgeCornerAtStart(EdgeType.RIGHT),
                ((HappyCubePiece)pieces.get(1)).getEdgeCornerAtStart(EdgeType.LEFT),
                ((HappyCubePiece)pieces.get(4)).getEdgeCornerAtStart(EdgeType.BOTTOM)
        ));
        return isCornerMatched(corner);
    }

    @Override
    public boolean matchBottomBackRight(List<Piece> pieces) {
        final List<Character> corner = new ArrayList<>(Arrays.asList(
                ((HappyCubePiece)pieces.get(1)).getEdgeCornerAtEnd(EdgeType.TOP),
                ((HappyCubePiece)pieces.get(5)).getEdgeCornerAtStart(EdgeType.LEFT),
                ((HappyCubePiece)pieces.get(4)).getEdgeCornerAtEnd(EdgeType.BOTTOM)
        ));
        return isCornerMatched(corner);
    }

    @Override
    public boolean matchTopFrontLeft(List<Piece> pieces) {
        final List<Character> corner = new ArrayList<>(Arrays.asList(
                ((HappyCubePiece)pieces.get(3)).getEdgeCornerAtStart(EdgeType.LEFT),
                ((HappyCubePiece)pieces.get(0)).getEdgeCornerAtEnd(EdgeType.LEFT),
                ((HappyCubePiece)pieces.get(2)).getEdgeCornerAtStart(EdgeType.BOTTOM)
        ));
        return isCornerMatched(corner);
    }

    @Override
    public boolean matchTopFrontRight(List<Piece> pieces) {
        final List<Character> corner = new ArrayList<>(Arrays.asList(
                ((HappyCubePiece)pieces.get(3)).getEdgeCornerAtEnd(EdgeType.TOP),
                ((HappyCubePiece)pieces.get(5)).getEdgeCornerAtEnd(EdgeType.BOTTOM),
                ((HappyCubePiece)pieces.get(2)).getEdgeCornerAtEnd(EdgeType.BOTTOM)               
        ));
        return isCornerMatched(corner);
    }

    @Override
    public boolean matchTopBackLeft(List<Piece> pieces) {
        final List<Character> corner = new ArrayList<>(Arrays.asList(
                ((HappyCubePiece)pieces.get(4)).getEdgeCornerAtStart(EdgeType.TOP),
                ((HappyCubePiece)pieces.get(0)).getEdgeCornerAtStart(EdgeType.LEFT),
                ((HappyCubePiece)pieces.get(3)).getEdgeCornerAtEnd(EdgeType.LEFT)
        ));
        return isCornerMatched(corner);
    }

    @Override
    public boolean matchTopBackRight(List<Piece> pieces) {
        final List<Character> corner = new ArrayList<>(Arrays.asList(
                ((HappyCubePiece)pieces.get(4)).getEdgeCornerAtEnd(EdgeType.TOP),
                ((HappyCubePiece)pieces.get(5)).getEdgeCornerAtEnd(EdgeType.TOP),
                ((HappyCubePiece)pieces.get(3)).getEdgeCornerAtEnd(EdgeType.BOTTOM)
        ));
        return isCornerMatched(corner);
    }

    /**
     * Checks if the passed in corner is matched correctly, i.e. there must be only one filled in square, 
     * represented as 'o' and two empty squares, represented as ' '. 
     * @param corner {@link List} with 3 edge squares from 3 different pieces forming the corner.
     * @return true if matched correctly, false otherwise.
     */
    private final boolean isCornerMatched(List<Character> corner){
        return ((Collections.frequency(corner, ' ') == 2) && (Collections.frequency(corner, 'o') == 1)) ? true : false;
    }   
    
}
