package com.example.memorygame;

public class MemCard extends Cards {

    public boolean matched;

    public MemCard(String color, String value) {
        super(color, value);
        this.matched = false;
    }

    public boolean isAMatch(MemCard other) {
        if (this.value.equals(other.value) && this.color.equals(other.color)) {
            return true;
        }
        return false;
    }

}
