package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner (System.in);
    private List<String> playerCardsDisplayed = new ArrayList<>();
    private String name;
    public int total = 0;

    public Player(){
    }

    public void askName(){
        System.out.print("Player Name: ");
        name = scanner.nextLine();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getTotal(){
        return this.total;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void closeScanner(){
        scanner.close();
    }

    public List<String> getPlayerCardsDisplayed() {
        return this.playerCardsDisplayed;
    }
}