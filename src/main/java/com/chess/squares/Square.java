package com.chess.squares;

import com.chess.common.Location;
import com.chess.piece.AbstractPiece;

public class Square {
    private final SquareColour squareColour;
    private final Location location;
    private boolean isOccupied;
    private AbstractPiece currentPiece;
    
    // constructor
    public Square(SquareColour squareColour, Location location) {
        this.squareColour = squareColour;
        this.location = location;
        this.isOccupied = false;
    }
    
    public void reset() {
        this.isOccupied = false;
        this.currentPiece = null;
    }
    
    public boolean isOccupied() {
        return isOccupied;
    }
    
    // getter and setter methods
    public AbstractPiece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(AbstractPiece currentPiece) {    
        this.currentPiece = currentPiece;
    }
    
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
    
    public SquareColour getSquareColour() {
        return squareColour;
    }
    
    public Location getLocation() {
        return location;
    }
    
    // toString method
    @Override
    public String toString() {
        return "Square{" + "squareColour=" 
                + squareColour + ", location=" 
                + location + ", isOccupied=" 
                + isOccupied + '}';
    }
    
}
