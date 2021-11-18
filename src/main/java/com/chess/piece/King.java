package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.squares.Square;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class King extends AbstractPiece implements Movable{
    
    private Movable bishop;
    private Movable rook;
    
    public King(PieceColour pieceColour) {
        super(pieceColour);
        this.name = "King";
    }
    
    public King(PieceColour pieceColour, Movable bishop, Movable rook) {
        super(pieceColour);
        this.name = "King";
        this.bishop = bishop;
        this.rook = rook;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = Collections.emptyList();
        moveCandidates.addAll(rook.getValidMoves(board, this.getCurrentSquare()));
        moveCandidates.addAll(bishop.getValidMoves(board, this.getCurrentSquare()));
        Location current = this.getCurrentSquare().getLocation();
        // filters every spot that is beyond one space movement, since the king can only move one space
        return moveCandidates.stream()
                .filter(candidate -> (
                        Math.abs(candidate.getFile().ordinal() - current.getFile().ordinal()) == 1 &&
                        Math.abs(candidate.getRank()-current.getRank()) == 1))
                .collect(Collectors.toList());
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
