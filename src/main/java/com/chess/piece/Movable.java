package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.squares.Square;
import java.util.List;

public interface Movable {
    List<Location> getValidMoves(Board board);
    List<Location> getValidMoves(Board board, Square square);
    void makeMove(Square square);
}

/*
Interfaces
interfaces allow us to define a template for what function a class is going to have
the interface itself doesnt provide the implementation, but the class that will have it will give its own implementation

so in this case we can make an interface for the pieces that has an abstract method of moving and getValidMoves
every piece will implement this move and getValidMoves in their own way because each piece has different movement
*/
