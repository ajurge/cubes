package com.bipinet.cubes.edges;

import com.bipinet.cubes.pieces.Piece;


/**
 * Enum providing functionality to retrieve first and last elements for each of the four {@link Edge}s 
 * in the {@link Piece}.
 * 
 *
 <p> Happy Cube edge marking and direction.   
 <pre>  
 *                    {@code --->}
 *
 *                    TOP (1)
 *                   ooooo         
 *       |           o   o            |
 *       |  LEFT(0)  o   o  RIGHT(2)  |
 *      \/           o   o           \/
 *                   ooooo         
 *
 *                   BOTTOM (3)
 *
 *                   {@code --->}
 *
 </pre>
 *
 */
public enum EdgeType {
    LEFT {
        @Override
        public Character getCorner(Piece piece, boolean end) {            
            return piece.getLeftEdge().getPattern().charAt(getEdgeCornerIndex(end));
        }
    },
    RIGHT {
        @Override
        public Character getCorner(Piece piece, boolean end) {           
            return piece.getRightEdge().getPattern().charAt(getEdgeCornerIndex(end));
        }
    },
    TOP {
        @Override
        public Character getCorner(Piece piece, boolean end) {   
            return piece.getTopEdge().getPattern().charAt(getEdgeCornerIndex(end));
        }
    },
    BOTTOM {
        @Override
        public Character getCorner(Piece piece, boolean end) {
            return piece.getBottomEdge().getPattern().charAt(getEdgeCornerIndex(end));
        }
    };

    /**
     * Abstract method to retrieve a corner symbolf of the {@link Edge}.
     * 
     * @param piece reference to the {@link Piece} for which a specific {@link Edge} corner will be returned.
     * @param end if true return the last symbol, else the start element.
     * @return character representing the corner of the specified edge.
     */
    public abstract Character getCorner(Piece piece, boolean end);

    /**
     * Fetches the index of the corner symbol in the {@link Edge}.
     * @param end if true return the last symbol, else the start element.
     * @return index of the corner symbol.
     */
    private static final int getEdgeCornerIndex(boolean end){
        return (end) ? 4 : 0;
    }   
}
