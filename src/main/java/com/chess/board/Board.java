package com.chess.board;

import com.chess.common.File;
import com.chess.common.Location;
import com.chess.piece.AbstractPiece;
import com.chess.piece.PieceColour;
import com.chess.piece.PieceFactory;
import com.chess.squares.Square;
import com.chess.squares.SquareColour;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private static final Integer BOARD_LENGTH = 8;
    private final Map<Location, Square> locationSquareMap;
    
    // Square[][] array to hold information for the board
    Square[][] boardSquares = new Square[BOARD_LENGTH][BOARD_LENGTH];
    
    private final List<AbstractPiece> lightPieces = new ArrayList<>();
    private final List<AbstractPiece> darkPieces = new ArrayList<>();
    
    public Board() {
        locationSquareMap = new HashMap<>();
        Map<Location, AbstractPiece> pieces = PieceFactory.getPieces();
                
        for (int i = 0; i < boardSquares.length; i++) {
            int column = 0;
            SquareColour currentColour = (i % 2 == 0) ? SquareColour.LIGHT : SquareColour.DARK;
            // new java syntax above,     if statement   if true do this      if false do this
            
            // creating the board
            for (File file : File.values()) {
               Square newSquare = new Square(currentColour, new Location(file, BOARD_LENGTH-i));
               // if the square should have a piece in it
               if (pieces.containsKey(newSquare.getLocation())) {
                   AbstractPiece piece = pieces.get(newSquare.getLocation());
                   newSquare.setCurrentPiece(piece); // sets the square as what the piece is
                   newSquare.setOccupied(true);
                   piece.setCurrentSquare(newSquare); // sets the location of the instance of the piece
                   
                   // save which piece is dark and light colour
                   if (piece.getPieceColour().equals(PieceColour.DARK)) {
                       darkPieces.add(piece);
                   } else {
                       lightPieces.add(piece);
                   }
               }
               boardSquares[i][column] = newSquare; // load what the squares are in a data structure
               locationSquareMap.put(newSquare.getLocation(), newSquare); // load location coords in a data structure
               currentColour = (currentColour == SquareColour.DARK) ? SquareColour.LIGHT : SquareColour.DARK; // toggle colour
               column++;
            }
        }
    }
    
    public Map<Location, Square> getLocationSquareMap() {
        return locationSquareMap;
    }
    
    public List<AbstractPiece> getLightPieces() {
        return lightPieces;
    }
    
    public List<AbstractPiece> getDarkPieces() {
        return darkPieces;
    }
    
    // print the actual board
    public void printBoard() {
        for (int i = 0; i < boardSquares.length; i++) {
            System.out.print(BOARD_LENGTH - i + " ");
            for (int j = 0; j < boardSquares[i].length; j++) {
                if (boardSquares[i][j].isOccupied()) {
                    AbstractPiece piece = boardSquares[i][j].getCurrentPiece();
                    System.out.print(piece.getName().charAt(0) + " ");
                } else {
                    // empty square
                    System.out.print("- ");
                }  
            }
            System.out.println();
        }
        
        System.out.print("  ");
        for (File file : File.values()) {
            System.out.print(file.name() + " ");
        }
        System.out.println();
    }
}
