package com.chess.piece;

import com.chess.common.File;
import com.chess.common.Location;
import java.util.HashMap;
import java.util.Map;

public final class PieceFactory {
    private PieceFactory() { }
    
    public static Map<Location, AbstractPiece> getPieces() {
        Map<Location, AbstractPiece> pieces = new HashMap<>();
        
        // rooks
        pieces.put(new Location(File.A, 1), new Rook(PieceColour.LIGHT));
        pieces.put(new Location(File.H, 1), new Rook(PieceColour.LIGHT));
        pieces.put(new Location(File.A, 8), new Rook(PieceColour.DARK));
        pieces.put(new Location(File.H, 8), new Rook(PieceColour.DARK));
        
        // knights
        pieces.put(new Location(File.B, 1), new Knight(PieceColour.LIGHT));
        pieces.put(new Location(File.G, 1), new Knight(PieceColour.LIGHT));
        pieces.put(new Location(File.B, 8), new Knight(PieceColour.DARK));
        pieces.put(new Location(File.G, 8), new Knight(PieceColour.DARK));
        
        // bishops
        pieces.put(new Location(File.C, 1), new Bishop(PieceColour.LIGHT));
        pieces.put(new Location(File.F, 1), new Bishop(PieceColour.LIGHT));
        pieces.put(new Location(File.C, 8), new Bishop(PieceColour.DARK));
        pieces.put(new Location(File.F, 8), new Bishop(PieceColour.DARK));
        
        // queens
        pieces.put(new Location(File.D, 1), new Queen(PieceColour.LIGHT));
        pieces.put(new Location(File.D, 8), new Queen(PieceColour.DARK));
        
        // kings
        pieces.put(new Location(File.E, 1), new King(PieceColour.LIGHT));
        pieces.put(new Location(File.E, 8), new King(PieceColour.DARK));
        
        //pawns
        for (File file : File.values()) {
            pieces.put(new Location(file, 2), new Pawn(PieceColour.LIGHT));
            pieces.put(new Location(file, 7), new Pawn(PieceColour.DARK));
        }
        
        return pieces;
    }
}
