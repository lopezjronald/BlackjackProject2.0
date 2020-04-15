package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackJackApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        BlackjackHand blackjackHand = new BlackjackHand();
        String playAgain;
        boolean hit = true, playerAnswer = false, overTwentyOne, winner;

//        This method prints out the deck of cards. Aces are negative 1 for now until it is draw from the deck
//        blackjackHand.displayDeck();

        blackjackHand.getPlayer().askName();
        String playerName = blackjackHand.getPlayer().getName();
        System.out.println("Nice to meet you, " + playerName);
        boolean playerReady = readyToPlay(blackjackHand.getPlayer(), sc);

        int count = 0;
        while (playerReady) {
            while (true) {
                if (count % 2 == 1) {
                    if (count == 1) {
                        System.out.println("************************");
                        System.out.println("Dealer:");
                        int secondCardValue = blackjackHand.dealFirstCard();
                        // System.out.println(blackjackHand.getDealerTotal()); //This will display the value of the first card
                        System.out.println("Total: ? + " + secondCardValue);
                        winner = blackjackHand.isBlackjack();
                        if (winner) {
                            break;
                        }
                        count++;
                    } else if (!hit && (blackjackHand.getDealerTotal() < 17)) {
                        System.out.println("************************");
                        System.out.println("Dealer:");
                        blackjackHand.dealCardToDealer();
                        System.out.println("\nTotal: " + blackjackHand.getDealerTotal());
                        blackjackHand.isBust(blackjackHand.getDealerTotal(), blackjackHand.getDealer().getName(), blackjackHand.getPlayer().getName());
                        winner = blackjackHand.isBlackjack();
                        if (winner) {
                            break;
                        }
                        continue;
                    } else if (blackjackHand.getDealerTotal() < 17) {
                        System.out.println("************************");
                        System.out.println("Dealer:");
                        blackjackHand.dealCardToDealer();
                        System.out.println("\nTotal: " + blackjackHand.getDealerTotal());
                        overTwentyOne = blackjackHand.isBust(blackjackHand.getDealerTotal(), blackjackHand.getDealer().getName(), blackjackHand.getPlayer().getName());
                        if (overTwentyOne) {
                            break;
                        }

                        winner = blackjackHand.isBlackjack();
                        if (winner) {
                            break;
                        }
                        count++;
                    } else if (blackjackHand.getDealerTotal() >= 17 && blackjackHand.getDealerTotal() <= 21){
                        System.out.println("************************");
                        if (blackjackHand.getPlayerTotal() > blackjackHand.getDealerTotal()) {
                            System.out.println("Congratulations " + blackjackHand.getPlayer().getName() + "! You won!");
                        } else if (blackjackHand.getPlayerTotal() < blackjackHand.getDealerTotal()) {
                            System.out.println("Sorry. The dealer won.");
                        } else
                            System.out.println("You and the dealer have a tie!");
                        break;
                    } else
                        break;

                } else {
                    if (count == 0) {
                        System.out.println("************************");
                        System.out.println(blackjackHand.getPlayer().getName());
                        blackjackHand.dealFirstTwoCards();
                        System.out.println("\nTotal: " + blackjackHand.getPlayerTotal());
                        winner = blackjackHand.isBlackjack();
                        if (winner) {
                            break;
                        }
                        overTwentyOne = blackjackHand.isBust(blackjackHand.getPlayerTotal(), blackjackHand.getPlayer().getName(), blackjackHand.getDealer().getName());
                        if (overTwentyOne) {
                            break;
                        }
                        count++;
                    } else if (blackjackHand.getPlayerTotal() < 21) {
                        System.out.println("************************");
                        System.out.println(blackjackHand.getPlayer().getName());
                        hit = blackjackHand.hit();
                        if (hit) {
                            blackjackHand.dealCardToPlayer();
                            System.out.println("\nTotal: " + blackjackHand.getPlayerTotal());
                            overTwentyOne = blackjackHand.isBust(blackjackHand.getPlayerTotal(), blackjackHand.getPlayer().getName(), blackjackHand.getDealer().getName());
                            if (overTwentyOne) {
                                break;
                            }
                        }
                        count++;
                    }
                }

            }

            System.out.println("************************");
            System.out.println("Dealer: " + blackjackHand.getDealerTotal());
            blackjackHand.showDealerCardsPulled();
            System.out.println("\n" + blackjackHand.getPlayer().getName() + ": " + blackjackHand.getPlayerTotal());
            blackjackHand.showPlayerCardsPulled();
            System.out.println("\n************************");

            System.out.println("\nWould you like to play again? (Y/N)");
            while (true) {
                playAgain = sc.nextLine();
                if (playAgain.toUpperCase().equals("Y")) {
                    blackjackHand = new BlackjackHand();
                    blackjackHand.getPlayer().setName(playerName);
                    count = 0;
                    hit = true;
                    break;
                } else if (playAgain.toUpperCase().equals("N")){
                    exitGame(blackjackHand.getPlayer(), sc);
                } else
                    System.out.println("You have entered an invalid entry.\nChoices:\nY for Yes\nN for No");
            }
//        blackjackHand.displayDeck(); // This will display the rest of the deck once all cards have been drawn
//        blackjackHand.displayDeck(); // Test whether the deck was recreated
        }

        exitGame(blackjackHand.getPlayer(), sc);
    }

    public static boolean readyToPlay(Player player, Scanner sc){
        String choice;
        System.out.print("Are you ready to play? (Y/N) ");
        while (true) {
            choice = sc.nextLine();
            choice = choice.toUpperCase();
            if (choice.equals("N")){
                return false;
            } else if (choice.equals("Y")) {
                return true;
            }
            else
                System.out.print("Sorry, you have entered an invalid option.\nChoices: Y or N ");
        }
    }

    public static void exitGame(Player player, Scanner sc){
        System.out.println("It was nice to meet you, " + player.getName() + ". Have a wonderful day.");
        player.closeScanner();
        sc.close();
        System.exit(0);
    }
}
