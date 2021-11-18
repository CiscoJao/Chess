package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationFactory;
import com.chess.squares.Square;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pawn extends AbstractPiece implements Movable{
    
    private boolean isFirstMove = true;
    
    public Pawn(PieceColour pieceColour) {
        super(pieceColour);
        this.name = "Pawn";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = Collections.emptyList();
        Location current = this.getCurrentSquare().getLocation();
        // pawn can move one spot forward always
        moveCandidates.add(LocationFactory.build(current, 0, 1));
        
        if (isFirstMove) {
            // gives pawn extra move forward if first move
            moveCandidates.add(LocationFactory.build(current, 0, 2));
            return moveCandidates;
        }
        
        // legal moves if pawn is taking
        moveCandidates.add(LocationFactory.build(current, 1, 1));
        moveCandidates.add(LocationFactory.build(current, -1, 1));
        
        // check if the legal moves in the list are valid
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        List<Location> validMoves = moveCandidates.stream()
                .filter(squareMap::containsKey)
                .collect(Collectors.toList());
        
        return validMoves.stream().filter((candidate) -> {
            if (candidate.getFile().equals(this.getCurrentSquare().getLocation().getFile()) &&
                    squareMap.get(candidate).isOccupied()) {
                return false;
            }
            
            return !squareMap.get(candidate).getCurrentPiece().pieceColour.equals(this.getPieceColour());
        }).collect(Collectors.toList());
    }

    @Override
    public void makeMove(Square square) {
        if (isFirstMove) {
          isFirstMove = false;
        }
        this.currentSquare.setOccupied(false);
        this.setCurrentSquare(square);
        square.setCurrentPiece(this);
        square.setOccupied(true);
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }
}
