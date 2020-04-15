package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackjackHand extends Hand{

    Scanner keyboard = new Scanner(System.in);
    private Random random = new Random();
    private Deck deck = new Deck();
    private Dealer dealer = new Dealer();
    private Player player = new Player();

    private List<String> cardKeys = new ArrayList<>();
    private List<String> playerCardsPulled = new ArrayList<>();
    private List<String> dealerCardsPulled = new ArrayList<>();
    private String choice, key, playerMove;

    public BlackjackHand() {
        deck.createDeck();
        changeCardValues();
    }

    public boolean hit(){
        System.out.println("What would you like like to do?\n1. Hit\n2. Stay");
        while (true) {
            playerMove = keyboard.nextLine();
            if (playerMove.equals("1")) {
                return true;
            } else if (playerMove.equals("2")){
                return false;
            } else
                System.out.println("You have entered an invalid choice.\nChoices:\n1. Hit\n2. Stay");
        }
    }

    public boolean isBlackjack(){
        if (player.getTotal() == 21 && dealer.getTotal() == 21){
            System.out.println("You, " + player.getName() + ", and the " + dealer.getName() + " have 21. Tie!");
            return true;
        }
        else if (player.getTotal() == 21) {
            System.out.println("Blackjack! " + player.getName() + ", you are the winner!");
            return true;
        } else if (dealer.getTotal() == 21){
            System.out.println("Blackjack! The dealer is the winner.");
            return true;
        }
        return false;
    }

    public boolean isBlackjack(int playerTotal, int dealerTotal){
        if (playerTotal == 21 && dealerTotal == 21){
            System.out.println("Tie!");
            return true;
        } else if (playerTotal == 21) {
            System.out.println("Blackjack! " + player.getName() + ", you are the winner!");
            return true;
        } else if (dealerTotal == 21) {
            System.out.println("Blackjack! " + dealer.getName() + " wins!");
            return true;
        }
        return false;
    }

    public boolean isBust(int total, String name, String opponent){
        if (total > 21) {
            System.out.println("Sorry, " + name + "! You lost. Your number, " + total + ", is over 21. " + opponent + " wins.");
            return true;
        }
         return false;
    }

    //Change the value for Jacks, Queens, and Kings to 10 for Blackjack Game
    public void changeCardValues(){
        deck.createDeck();
        cardKeys = deck.getDeckKeys();
        for (String eachCard : cardKeys) {
            if ((eachCard.contains("J")) || (eachCard.contains("Q")) || (eachCard.contains("K"))) {
                deck.getDeckOfCards().put(eachCard, 10);
            }
        }
    }

    public String shuffleDeck(){
        key = cardKeys.get(random.nextInt(cardKeys.size()));
        return key;
    }

    public int dealCardToDealer(){
        key = shuffleDeck();
        dealer.getDealerCardsDisplayed().add(key);
        if (key.contains("A")){
            changeAceValueForDealer(key);
        }
        dealerCardsPulled = dealer.getDealerCardsDisplayed();
        for (String cards : dealerCardsPulled){
            System.out.print(cards + " ");
        }
        cardKeys.remove(key);
        int cardValue = deck.getDeckOfCards().remove(key);
        dealer.total += cardValue;
        return cardValue;
    }

    public int dealCardToPlayer(){
        key = shuffleDeck();
        player.getPlayerCardsDisplayed().add(key);
        if (key.contains("A")){
            changeAceValue(key);
        }
        playerCardsPulled = player.getPlayerCardsDisplayed();
        for (String cards : playerCardsPulled){
            System.out.print(cards + " ");
        }
        cardKeys.remove(key);
        int cardValue = deck.getDeckOfCards().remove(key);
        player.total += cardValue;
        return cardValue;
    }

    public int dealFirstCard(){

        //1st Card to Dealer
        key = shuffleDeck();
        dealer.getDealerCardsDisplayed().add(key);
        if (key.contains("A")){
            changeAceValueForDealer(key);
        }
        cardKeys.remove(key);
        int cardValue = deck.getDeckOfCards().remove(key);
        dealer.total += cardValue;

        //2nd Card to Dealer
        key = shuffleDeck();
        dealer.getDealerCardsDisplayed().add(key);
        if (key.contains("A")){
            changeAceValueForDealer(key);
        }
        cardKeys.remove(key);
        cardValue = deck.getDeckOfCards().remove(key);
        dealer.total += cardValue;
        displayBackOfCard();
        System.out.println(" " + key);
        return cardValue;
    }

    public int dealFirstTwoCards(){

        //1st Card to Player
        key = shuffleDeck();
        player.getPlayerCardsDisplayed().add(key);
        if (key.contains("A")){
            changeAceValue(key);
        }
        cardKeys.remove(key);
        int cardValue = deck.getDeckOfCards().remove(key);
        player.total += cardValue;

        //2nd Card to Player
        key = shuffleDeck();
        player.getPlayerCardsDisplayed().add(key);

        if (key.contains("A")){
            changeAceValue(key);
        }
        playerCardsPulled = player.getPlayerCardsDisplayed();
        for (String cards : playerCardsPulled){
            System.out.print(cards + " ");
        }
        cardKeys.remove(key);
        cardValue = deck.getDeckOfCards().remove(key);
        player.total += cardValue;
        //System.out.println(" " + key);
        return cardValue;
    }

    public void changeAceValue(String key) {

        while (true){
            System.out.println("Drew an Ace. Would you like to make it 1 or 11?");
            choice = keyboard.nextLine();

            if (choice.equals("1")){
                deck.getDeckOfCards().put(key, 1);
                break;
            } else if (choice.equals("11")){
                deck.getDeckOfCards().put(key, 11);
                break;
            } else
                System.out.println("Sorry, you have entered an invalid choice.");
        }
    }

    public void changeAceValueForDealer(String key) {
        
            if (getDealerTotal() <= 9) {
                deck.getDeckOfCards().put(key, 11);
            } else {
                deck.getDeckOfCards().put(key, 1);
            }
    }

    public void displayDeck(){
        deck.displayDeck();
    }

    public void displayBackOfCard(){
        deck.displayBackOfCard();
    }

    @Override
    int getHandValue() {
        return super.getHandValue();
    }

    public Player getPlayer(){
        return this.player;
    }

    public Dealer getDealer(){
        return this.dealer;
    }

    public int getDealerTotal(){
        return this.dealer.total;
    }

    public int getPlayerTotal(){
        return this.player.total;
    }

    public void showDealerCardsPulled(){
            dealerCardsPulled = dealer.getDealerCardsDisplayed();
            for (String cards : dealerCardsPulled){
                System.out.print(cards + " ");
            }
    }

    public void showPlayerCardsPulled(){
        playerCardsPulled = player.getPlayerCardsDisplayed();
        for (String cards : playerCardsPulled){
            System.out.print(cards + " ");
        }
    }

}