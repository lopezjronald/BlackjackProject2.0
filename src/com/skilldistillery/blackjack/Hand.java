package com.skilldistillery.blackjack;

import java.util.List;

public abstract class Hand{

    List <Card> cards;

    Hand() {
    }

    void addCard(Card card){
    }

    void clear(){
    }

    int getHandValue(){
        return 0;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
