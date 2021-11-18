package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationFactory;
import com.chess.squares.Square;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rook extends AbstractPiece implements Movable{
    public Rook(PieceColour pieceColour) {
        super(pieceColour);
        this.name = "Rook";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getFileCandidates(moveCandidates, squareMap, current, -1);
        getFileCandidates(moveCandidates, squareMap, current, 1);
        getRankCandidates(moveCandidates, squareMap, current, -1);
        getRankCandidates(moveCandidates, squareMap, current, 1);
        return moveCandidates;
    }
    
    private void getRankCandidates(
            List<Location> moveCandidates, 
            Map<Location, Square> squareMap, 
            Location current, 
            int offset) {
        Location next = LocationFactory.build(current, current.getFile().ordinal(), offset);
        // checks every spot in the row/column until it hits an occupied spot
        while (squareMap.containsKey(next)) {
            // if the spot being checked is occupied, add it as a candidate only if it is the opposite colour
            if (squareMap.get(next).isOccupied()) {
                if (squareMap.get(next).getCurrentPiece().pieceColour.equals(this.pieceColour)) {
                    break;
                }
                moveCandidates.add(next);
                break;
            }
            moveCandidates.add(next);
            // keep the file fixed, but offset the rank by 1 in each iteration
            // the .ordinal() means to get the same value of the enum, this is an enum specific method, effectivley saying to stay in the same file
            next = LocationFactory.build(next, next.getFile().ordinal(), offset);
        }
    }
    
    // essentially the same method as getRankCandidates, but instead the rank stays the same while file changes
    private void getFileCandidates(
            List<Location> moveCandidates,
            Map<Location, Square> squareMap,
            Location current,
            int offset) {
        Location next = LocationFactory.build(current, offset, 0);
        while (squareMap.containsKey(next)) {
            if (squareMap.get(next).isOccupied()) {
                if (squareMap.get(next).getCurrentPiece().pieceColour.equals(this.pieceColour)) break;
                moveCandidates.add(next);
                break;
            }
            moveCandidates.add(next);
            next = LocationFactory.build(next, offset, 0);
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
