package com.bipinet.cubes.pieces;


import com.bipinet.cubes.cube.HappyCube;
import com.bipinet.cubes.edges.Edge;
import com.bipinet.cubes.edges.EdgeType;
import com.bipinet.cubes.parameters.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 *  Implementation of the {@link Piece} that will compose the {@link HappyCube}.
 *
 *
 <p> Happy Cube piece representation,  edge marking and direction.   
 <pre>  
 *                    --->
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
 *                   --->
 *                
 </pre>
 * 
 */
public class HappyCubePiece extends AbstractCubePiece {
    /**
     * Custom constructor to create a piece with four {@link Edge}s.
     * @param left reference to the left {@link Edge}.
     * @param top reference to the top {@link Edge}.
     * @param right reference to the right {@link Edge}.
     * @param bottom reference to the bottom {@link Edge}.
     */
    public HappyCubePiece(Edge left, Edge top, Edge right, Edge bottom) {
        super(new ArrayList<>(Arrays.asList(left, top, right, bottom)));
    }

    @Override
    public void rotate() {
        //Rotate by 1 edge clockwise.
        Collections.rotate(super.getEdges(), 1);
        //Reverse to match the top/bottom direction.
        this.getBottomEdge().reverse();
        this.getTopEdge().reverse();        
    }

    @Override
    public void flip() {
        //Swap top with bottom.
        Collections.swap(super.getEdges(), 1, 3);
        //Reverse to match the left/right direction.
        super.getEdges().get(0).reverse();
        super.getEdges().get(2).reverse();
    }

    @Override
    public Edge getLeftEdge() {
        return super.getEdges().get(0);
    }

    @Override
    public Edge getTopEdge() {
        return super.getEdges().get(1);
    }

    @Override
    public Edge getRightEdge() {
        return super.getEdges().get(2);
    }

    @Override
    public Edge getBottomEdge() {
        return super.getEdges().get(3);
    }
    
    @Override
    public String print() {
        final String leftEdgeString = getLeftEdge().getPattern();
        final String rightEdgeString = getRightEdge().getPattern();
        final String lineSeparator = System.lineSeparator();
        final StringBuilder pieceStringBuilder = new StringBuilder();
        pieceStringBuilder.append(this.getTopEdge().getPattern()).append(lineSeparator);
        for (int i = 1; i< Parameters.HAPPY_CUBE_SIZE - 1; i++){
            pieceStringBuilder.append(leftEdgeString.charAt(i)).
                    append(Parameters.HAPPY_CUBE_INNER_SYMBOLS).
                    append(rightEdgeString.charAt(i)).
                    append(lineSeparator);
        }
        pieceStringBuilder.append(this.getBottomEdge().getPattern()).append(lineSeparator);
        return pieceStringBuilder.toString();
    }

    @Override
    public String printWithOffset(String offset) {
        final String leftEdgeString = getLeftEdge().getPattern();
        final String rightEdgeString = getRightEdge().getPattern();
        final String lineSeparator = System.lineSeparator();
        final StringBuilder pieceStringBuilder = new StringBuilder();
        pieceStringBuilder.append(offset).append(this.getTopEdge().getPattern()).append(lineSeparator);
        for (int i = 1; i< Parameters.HAPPY_CUBE_SIZE - 1; i++){
            pieceStringBuilder.
                    append(offset).
                    append(leftEdgeString.charAt(i)).
                    append(Parameters.HAPPY_CUBE_INNER_SYMBOLS).
                    append(rightEdgeString.charAt(i)).append(lineSeparator);
        }
        pieceStringBuilder.append(offset).append(this.getBottomEdge().getPattern()).append(lineSeparator);
        return pieceStringBuilder.toString();
    }

    @Override
    public String[] toStringArray() {
        final String leftEdgeString = getLeftEdge().getPattern();
        final String rightEdgeString = getRightEdge().getPattern();
        final String[] pieceStringArrayBuilder = new String[Parameters.HAPPY_CUBE_SIZE];
        pieceStringArrayBuilder[0] = this.getTopEdge().getPattern();
        for (int i = 1; i< Parameters.HAPPY_CUBE_SIZE - 1; i++){
            pieceStringArrayBuilder[i] = leftEdgeString.charAt(i) +
                    Parameters.HAPPY_CUBE_INNER_SYMBOLS +
                   rightEdgeString.charAt(i);
        }
        pieceStringArrayBuilder[Parameters.HAPPY_CUBE_SIZE-1] = this.getBottomEdge().getPattern();
        return pieceStringArrayBuilder;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Get the first element of the {@link Edge} at the corner of the {@link Piece}.
     * @param edgeType {@link EdgeType}.
     * @return first symbol in the {@link Edge}.
     */
    public char getEdgeCornerAtStart(EdgeType edgeType){
        return edgeType.getCorner(this, false);
    }

    /**
     * Get the last element of the {@link Edge} at the corner of the {@link Piece}.
     * @param edgeType {@link EdgeType}.
     * @return last symbol in the {@link Edge}.
     */
    public char getEdgeCornerAtEnd(EdgeType edgeType){
        return edgeType.getCorner(this, true);
    }    
}
