package com.skilldistillery.blackjack;

import java.util.*;

public class Deck{
    private Map<String, Integer> deckOfCards = new HashMap<>();
    private Card card = new Card();
    private List<String> cardKeys = new ArrayList<>();

    public Deck() {
    }

    public void createDeck() {
        for (Suit eachSuit : card.suits) {
            for (Rank eachRank : card.ranks) {
                if (eachSuit.toString().equals("\u2665")) {
                    assignHearts(eachSuit.toString(), eachRank);
                } else if (eachSuit.toString().equals("\u2663")) {
                    assignClubs(eachSuit.toString(), eachRank);
                } else if (eachSuit.toString().equals("\u2666")) {
                    assignDiamonds(eachSuit.toString(), eachRank);
                } else if (eachSuit.toString().equals("\u2660")) {
                    assignSpades(eachSuit.toString(), eachRank);
                }
            }
        }
    }

    public void displayDeck() {
        int count = 1;
        for (Map.Entry<String, Integer> entry : deckOfCards.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(count + ". " + key + ": " + value);
            count++;
        }
    }

    public void displayBackOfCard(){
        System.out.print("\uD83C\uDCA0");
    }

    public Map<String, Integer> getDeckOfCards(){
        return this.deckOfCards;
    }

    public List<String> getDeckKeys(){
        for (String key: getDeckOfCards().keySet()){
            cardKeys.add(key);
        }
        return cardKeys;
    }

    public void assignHearts(String suit, Rank rank) {
        // Assigning "Heart" of Cards
        switch (rank.toString()) {
            case "ACE":
                deckOfCards.put(suit + " \uD83C\uDCB1 (A)", -1);
                break;
            case "TWO":
                deckOfCards.put(suit + " \uD83C\uDCB2", 2);
                break;
            case "THREE":
                deckOfCards.put(suit + " \uD83C\uDCB3", 3);
                break;
            case "FOUR":
                deckOfCards.put(suit + " \uD83C\uDCB4", 4);
                break;
            case "FIVE":
                deckOfCards.put(suit + " \uD83C\uDCB5", 5);
                break;
            case "SIX":
                deckOfCards.put(suit + " \uD83C\uDCB6", 6);
                break;
            case "SEVEN":
                deckOfCards.put(suit + " \uD83C\uDCB7", 7);
                break;
            case "EIGHT":
                deckOfCards.put(suit + " \uD83C\uDCB8", 8);
                break;
            case "NINE":
                deckOfCards.put(suit + " \uD83C\uDCB9", 9);
                break;
            case "TEN":
                deckOfCards.put(suit + " \uD83C\uDCBA", 10);
                break;
            case "JACK":
                deckOfCards.put(suit + " \uD83C\uDCBB (J)", -1);
                break;
            case "QUEEN":
                deckOfCards.put(suit + " \uD83C\uDCBD (Q)", -1);
                break;
            case "KING":
                deckOfCards.put(suit + " \uD83C\uDCBE (K)", -1);
                break;
            default:
                break;
        }
    }

    public void assignClubs(String suit, Rank rank) {
        // Assigning "Heart" of Cards
        switch (rank.toString()) {
            case "ACE":
                deckOfCards.put(suit + " " + "\uD83C\uDCD1 (A)", -1);
                break;
            case "TWO":
                deckOfCards.put(suit + " " + "\uD83C\uDCD2", 2);
                break;
            case "THREE":
                deckOfCards.put(suit + " " + "\uD83C\uDCD3", 3);
                break;
            case "FOUR":
                deckOfCards.put(suit + " " + "\uD83C\uDCD4", 4);
                break;
            case "FIVE":
                deckOfCards.put(suit + " " + "\uD83C\uDCD5", 5);
                break;
            case "SIX":
                deckOfCards.put(suit + " " + "\uD83C\uDCD6", 6);
                break;
            case "SEVEN":
                deckOfCards.put(suit + " " + "\uD83C\uDCD7", 7);
                break;
            case "EIGHT":
                deckOfCards.put(suit + " " + "\uD83C\uDCD8", 8);
                break;
            case "NINE":
                deckOfCards.put(suit + " " + "\uD83C\uDCD9", 9);
                break;
            case "TEN":
                deckOfCards.put(suit + " " + "\uD83C\uDCDA", 10);
                break;
            case "JACK":
                deckOfCards.put(suit + " " + "\uD83C\uDCDB (J)", -1);
                break;
            case "QUEEN":
                deckOfCards.put(suit + " " + "\uD83C\uDCDD (Q)", -1);
                break;
            case "KING":
                deckOfCards.put(suit + " " + "\uD83C\uDCDE (K)", -1);
                break;
            default:
                break;
        }
    }

    public void assignDiamonds(String suit, Rank rank) {
        switch (rank.toString()) {
            case "ACE":
                deckOfCards.put(suit + " " + "\uD83C\uDCC1 (A)", -1);
                break;
            case "TWO":
                deckOfCards.put(suit + " " + "\uD83C\uDCC2", 2);
                break;
            case "THREE":
                deckOfCards.put(suit + " " + "\uD83C\uDCC3", 3);
                break;
            case "FOUR":
                deckOfCards.put(suit + " " + "\uD83C\uDCC4", 4);
                break;
            case "FIVE":
                deckOfCards.put(suit + " " + "\uD83C\uDCC5", 5);
                break;
            case "SIX":
                deckOfCards.put(suit + " " + "\uD83C\uDCC6", 6);
                break;
            case "SEVEN":
                deckOfCards.put(suit + " " + "\uD83C\uDCC7", 7);
                break;
            case "EIGHT":
                deckOfCards.put(suit + " " + "\uD83C\uDCC8", 8);
                break;
            case "NINE":
                deckOfCards.put(suit + " " + "\uD83C\uDCC9", 9);
                break;
            case "TEN":
                deckOfCards.put(suit + " " + "\uD83C\uDCCA", 10);
                break;
            case "JACK":
                deckOfCards.put(suit + " " + "\uD83C\uDCCB (J)", -1);
                break;
            case "QUEEN":
                deckOfCards.put(suit + " " + "\uD83C\uDCCD (Q)", -1);
                break;
            case "KING":
                deckOfCards.put(suit + " " + "\uD83C\uDCCE (K)", -1);
                break;
            default:
                break;
        }
    }

    public void assignSpades(String suit, Rank rank) {
        switch (rank.toString()) {
            case "ACE":
                deckOfCards.put(suit + " " + "\uD83C\uDCA1 (A)", -1);
                break;
            case "TWO":
                deckOfCards.put(suit + " " + "\uD83C\uDCA2", 2);
                break;
            case "THREE":
                deckOfCards.put(suit + " " + "\uD83C\uDCA3", 3);
                break;
            case "FOUR":
                deckOfCards.put(suit + " " + "\uD83C\uDCA4", 4);
                break;
            case "FIVE":
                deckOfCards.put(suit + " " + "\uD83C\uDCA5", 5);
                break;
            case "SIX":
                deckOfCards.put(suit + " " + "\uD83C\uDCA6", 6);
                break;
            case "SEVEN":
                deckOfCards.put(suit + " " + "\uD83C\uDCA7", 7);
                break;
            case "EIGHT":
                deckOfCards.put(suit + " " + "\uD83C\uDCA8", 8);
                break;
            case "NINE":
                deckOfCards.put(suit + " " + "\uD83C\uDCA9", 9);
                break;
            case "TEN":
                deckOfCards.put(suit + " " + "\uD83C\uDCCA", 10);
                break;
            case "JACK":
                deckOfCards.put(suit + " " + "\uD83C\uDCAB (J)", -1);
                break;
            case "QUEEN":
                deckOfCards.put(suit + " " + "\uD83C\uDCAA (Q)", -1);
                break;
            case "KING":
                deckOfCards.put(suit + " " + "\uD83C\uDCAE (K)", -1);
                break;
            default:
                break;
        }
    }

}