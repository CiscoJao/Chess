package com.chess.common;

import java.util.Objects;

public class Location {
    private final File file;
    private final Integer rank;
    
    // constructor
    public Location(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }
    
    // getter methods
    public File getFile() {
        return file;
    }
    
    public Integer getRank() {
        return rank;
    }
    
    // hashcode method
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.file);
        hash = 83 * hash + Objects.hashCode(this.rank);
        return hash;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // check to see if the instance is equal to itself
        }
        if (obj == null) {
            return false; // checks if the parameter instace is null, because we know the equals instance does
        }
        if (getClass() != obj.getClass()) {
            return false; // finally checks to see if the two instances are the same class
        }
        final Location other = (Location) obj; // casts the instance to the class we're testing
        // the below lines then checks every attribute
        if (this.file != other.file) {
            return false;
        }
        if (!Objects.equals(this.rank, other.rank)) {
            return false;
        }
        return true; // once every attribute is checked, we know that the two instances are "equal"
    }
    
    // every java class has the methods equals and hashcode
    // we need to ovveride the equals method to define what it means for our class
}
