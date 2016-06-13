package com.bipinet.cubes.sides;

import com.bipinet.cubes.cube.HappyCube;
import com.bipinet.cubes.corners.Corners;
import com.bipinet.cubes.pieces.Piece;

import java.util.List;

/**
 * Implementation of the {@link Sides} matching for the {@link HappyCube}.
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
public class HappyCubeSides extends AbstractSides {

    public HappyCubeSides(Corners corners) {
        super(corners);
    }

    @Override
    public boolean matchLeft(List<Piece> pieces) {
        return matchLeftSide(1, pieces);
    }

    @Override
    public boolean matchBottom(List<Piece> pieces) {
        final Piece bottomPiece = pieces.get(1);     
        return ((bottomPiece.getLeftEdge().matchesTo(pieces.get(0).getRightEdge())) &&
                (bottomPiece.getTopEdge().matchesTo(pieces.get(4).getBottomEdge()))&&
                (bottomPiece.getRightEdge().matchesTo(pieces.get(5).getLeftEdge())) &&
                (bottomPiece.getBottomEdge().matchesTo(pieces.get(2).getTopEdge())) &&
                (super.getCorners().matchBottomFrontLeft(pieces)) &&
                (super.getCorners().matchBottomFrontRight(pieces)) &&
                (super.getCorners().matchBottomBackLeft(pieces)) &&
                (super.getCorners().matchBottomBackRight(pieces)));
    }

    @Override
    public boolean matchFront(List<Piece> pieces) {    
        boolean isMatch;
        pieces.get(2).getLeftEdge().reverse();
        isMatch = ((pieces.get(2).getBottomEdge().matchesTo(pieces.get(3).getTopEdge())) &&
                (pieces.get(2).getLeftEdge().matchesTo(pieces.get(0).getBottomEdge()))&&
                (pieces.get(2).getRightEdge().matchesTo(pieces.get(5).getBottomEdge())) &&
                (pieces.get(2).getTopEdge().matchesTo(pieces.get(1).getBottomEdge())) &&
                (super.getCorners().matchBottomFrontLeft(pieces)) &&
                (super.getCorners().matchBottomFrontRight(pieces)) &&
                (super.getCorners().matchTopFrontLeft(pieces)) &&
                (super.getCorners().matchTopFrontRight(pieces)));
        pieces.get(2).getLeftEdge().reverse();
        return isMatch;        
    }

    @Override
    public boolean matchTop(List<Piece> pieces) {
        final Piece topPiece = pieces.get(3);         
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                boolean isMatch;
                pieces.get(0).getLeftEdge().reverse();
                isMatch = ((topPiece.getLeftEdge().matchesTo(pieces.get(0).getLeftEdge())) &&
                        (topPiece.getTopEdge().matchesTo(pieces.get(2).getBottomEdge())) &&
                        (super.getCorners().matchTopFrontLeft(pieces)));
                pieces.get(0).getLeftEdge().reverse();
                if (isMatch) return true;
                topPiece.rotate();
            }
            topPiece.flip();
        }
        return false;
    }

    @Override
    public boolean matchBack(List<Piece> pieces) {
        final Piece backPiece = pieces.get(4);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if ((backPiece.getLeftEdge().matchesTo(pieces.get(0).getTopEdge())) &&
                        (backPiece.getBottomEdge().matchesTo(pieces.get(1).getTopEdge())) &&
                        (backPiece.getTopEdge().matchesTo(pieces.get(3).getBottomEdge())) &&
                        (super.getCorners().matchBottomBackLeft(pieces)) &&
                        (super.getCorners().matchTopBackLeft(pieces))) return true;

                backPiece.rotate();
            }
            backPiece.flip();
        }
        return false;
    }

    @Override
    public boolean matchRight(List<Piece> pieces) {
        final Piece rightPiece = pieces.get(5);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                boolean isMatch;
                rightPiece.getTopEdge().reverse();
                rightPiece.getRightEdge().reverse();
                isMatch = ((rightPiece.getLeftEdge().matchesTo(pieces.get(1).getRightEdge()))&&
                        (rightPiece.getTopEdge().matchesTo(pieces.get(4).getRightEdge())) &&
                        (rightPiece.getRightEdge().matchesTo(pieces.get(3).getRightEdge())) &&
                        (rightPiece.getBottomEdge().matchesTo(pieces.get(2).getRightEdge())) &&
                        (super.getCorners().matchBottomFrontRight(pieces)) &&
                        (super.getCorners().matchBottomBackRight(pieces)) &&
                        (super.getCorners().matchTopFrontRight(pieces)) &&
                        (super.getCorners().matchTopBackRight(pieces)));
                rightPiece.getTopEdge().reverse();
                rightPiece.getRightEdge().reverse();
                if (isMatch) return true;
                rightPiece.rotate();
            }
            rightPiece.flip();
        }
        return false;
    }
    
    private boolean matchLeftSide(Integer pieceNumber, List<Piece> pieces){
        final Piece currentPiece = pieces.get(pieceNumber);
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 4; j++){
                boolean isMatch;
                pieces.get(2).getLeftEdge().reverse();
                isMatch = ((pieces.get(0).getRightEdge().matchesTo(pieces.get(1).getLeftEdge())) && 
                        (pieces.get(1).getBottomEdge().matchesTo(pieces.get(2).getTopEdge())) && 
                        (pieces.get(2).getLeftEdge().matchesTo(pieces.get(0).getBottomEdge())) &&
                        (super.getCorners().matchBottomFrontLeft(pieces)));
                pieces.get(2).getLeftEdge().reverse();
                if (isMatch) return true;
                if (pieceNumber <= 2){
                    if (matchLeftSide(pieceNumber + 1, pieces)) return true;
                }                
                currentPiece.rotate();  
            }
            currentPiece.flip();            
        }
        return false;        
    }
       
}