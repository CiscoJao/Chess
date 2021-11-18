package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationFactory;
import com.chess.squares.Square;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Knight extends AbstractPiece implements Movable{
    public Knight(PieceColour pieceColour) {
        super(pieceColour);
        this.name = "Knight";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = Collections.emptyList();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getMoves(moveCandidates, squareMap, current, 2, 1);
        getMoves(moveCandidates, squareMap, current, 2, -1);
        getMoves(moveCandidates, squareMap, current, -2, 1);
        getMoves(moveCandidates, squareMap, current, -2, -1);
        getMoves(moveCandidates, squareMap, current, 1, 2);
        getMoves(moveCandidates, squareMap, current, 1, -2);
        getMoves(moveCandidates, squareMap, current, -1, 2);
        getMoves(moveCandidates, squareMap, current, -1, -2);
        return null;
    }
    
    private void getMoves(
            List<Location> candidates,
            Map<Location, Square> squareMap,
            Location current,
            int rankOffset,
            int fileOffset) {
        Location next = LocationFactory.build(current, fileOffset, rankOffset);
        // no need for while loop because the knight just hops to one space
        if (squareMap.containsKey(next)) {
            if (squareMap.get(next).isOccupied()) {
                if (squareMap.get(next).getCurrentPiece().pieceColour.equals(this.pieceColour)) return;
                candidates.add(next);
                return;
            }
            candidates.add(next);
        }
    }
    

    @Override
    public void makeMove(Square square) {
        System.out.println(this.getName() + "-> makeMove()");
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }
}
