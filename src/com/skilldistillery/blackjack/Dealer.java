package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private String name = "Dealer";
    public int total = 0;
    private List<String> dealerCardsDisplayed = new ArrayList<>();

    public Dealer(){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }

//    public void displayDealerCards(){
//        for (String cards : dealerCardsDisplayed) {
//            System.out.println(cards + " ");
//        }
//    }

    public List<String> getDealerCardsDisplayed() {
        return this.dealerCardsDisplayed;
    }

    public int getTotal(){
        return this.total;
    }
}