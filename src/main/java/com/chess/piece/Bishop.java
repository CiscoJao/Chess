package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationFactory;
import com.chess.squares.Square;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bishop extends AbstractPiece implements Movable{
    public Bishop(PieceColour pieceColour) {
        super(pieceColour);
        this.name = "Bishop";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getMoves(moveCandidates, squareMap, current, 1, 1);
        getMoves(moveCandidates, squareMap, current, -1, 1);
        getMoves(moveCandidates, squareMap, current, 1, -1);
        getMoves(moveCandidates, squareMap, current, -1, -1);
        return moveCandidates;
    }
    
    private void getMoves(
            List<Location> moveCandidates, 
            Map<Location, Square> squareMap, 
            Location current, 
            int rankOffset, 
            int fileOffset) {
        Location next = LocationFactory.build(current, fileOffset, rankOffset);
        while (squareMap.containsKey(next)) {
            if (squareMap.get(next).isOccupied()) {
                if (squareMap.get(next).getCurrentPiece().pieceColour.equals(this.pieceColour)) break;
                moveCandidates.add(next);
                break;
            }
            moveCandidates.add(next);
            // for diagonal movement both offsets always change
            next = LocationFactory.build(next, fileOffset, rankOffset);
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
