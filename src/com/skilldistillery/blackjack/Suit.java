package com.skilldistillery.blackjack;

public enum Suit {
    HEARTS ("\u2665"), CLUB ("\u2663"), DIAMONDS ("\u2666"), SPADES ("\u2660");

    private String suitSymbol;

    private Suit(String suitSymbol){
        this.suitSymbol = suitSymbol;
    }

    @Override
    public String toString() {
        return this.suitSymbol;
    }
}
