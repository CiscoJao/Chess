package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.squares.Square;
import java.util.Collections;
import java.util.List;

public class Queen extends AbstractPiece implements Movable{
    
    private Movable bishop;
    private Movable rook;
    
    public Queen(PieceColour pieceColour) {
        super(pieceColour);
        this.name = "Queen";
    }
    
    // since the queen combines the moves of the bishop and rook, we can construct the queen with the interfaces of bishop and rook
    public Queen(PieceColour pieceColour, Movable bishop, Movable rook) {
        super(pieceColour);
        this.bishop = bishop;
        this.rook = rook;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        // when we get valid moves for the queen, we actaully just get valid moves for a bishop and rook
        // create list to store the moves, get the moves from bishop and rook, return the list of valid moves
        List<Location> moveCandidates = Collections.emptyList();
        moveCandidates.addAll(bishop.getValidMoves(board, this.getCurrentSquare()));
        moveCandidates.addAll(rook.getValidMoves(board, this.getCurrentSquare()));
        return moveCandidates;
    }

    @Override
    public void makeMove(Square square) {
        Square current = this.getCurrentSquare();
        this.setCurrentSquare(square);
        current.reset();
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
