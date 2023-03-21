package ArrayList_Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <h1>ArrayList Assignment Part 1.2</h1>
 * Part 2 of the ArrayList Assignment. Reads a string representing a deck of cards into an ArrayList,
 * then shuffles the deck and distributes 13 cards to 4 players. A player's hand is scored based on the rules of bridge,
 * and each player's hand and the corresponding score is output to the console. Finally, the hand with the highest score is
 * also indicated in the output. This part of the assignment was primarily completed by Tom Philip.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-10
 *
 * @author Luke Mathieu, Tom Philip
 */

public class ArrayList_Assignment_Part2 {
    List<List<String>> hands;
    List<String> deck;
    static final String defaultDeck = "2S 3S 4S 5S 6S 7S 8S 9S TS JS QS KS AS 2H 3H 4H 5H 6H 7H 8H 9H TH JH QH KH AH 2D 3D 4D 5D 6D 7D 8D 9D TD JD QD KD AD 2C 3C 4C 5C 6C 7C 8C 9C TC JC QC KC AC";

    /**
     * Class constructor. Reads the defaultDeck string and sorts it into the deck ArrayList, then shuffles the deck.
     * Also initializes the 2D hands ArrayList with a length of 4.
     */
    public ArrayList_Assignment_Part2() {
        deck = new ArrayList<>(Arrays.asList(defaultDeck.split(" "))); // Initializes the deck
        Collections.shuffle(deck); // shuffles the deck
        hands = new ArrayList<>(4);
    }

    /**
     * Distributes 13 cards to each player's hand.
     */
    public void distributeHands() {
        for (int i = 0; i < 4; i++) {
            hands.add(new ArrayList<>());
            for (int j = 0; j < 13; j++) {
                hands.get(i).add(deck.remove(deck.size() - 1));
            }
        }
    }

    /**
     * Displays each player's hand, with cards sorted onto multiple lines based on suit,
     * and outputs the score of each hand. Finally, indicates the winner of the round, the
     * hand with the highest score.
     */
    public void display(){
        int bestHand = 0; //number which will indicate the best hand
        int bestScore = 0;

        for (int i = 0; i < 4; i++) { //for each hand
            int score = calculateScore(hands.get(i));
            System.out.println("Hand "+(i+1)+":\n");
            System.out.println(formatHand(hands.get(i)));
            System.out.println();
            System.out.println("Score: "+score);
            System.out.println("\n------------------------------\n");
            if(score>bestScore){
                bestHand = i;
                bestScore = score;
            }
        }
        System.out.println("The winner is Hand "+(bestHand+1)+"!");
    }

    /**
     * Formats a hand of cards into a String that can be printed to the console.
     * Sorts the cards onto multiple lines based on suit.
     * @param hand The hand to be formatted into a String.
     * @return A String representation of the hand, with suits separated onto multiple lines.
     */
    static String formatHand(List<String> hand) {
        String formattedString = "";
        for (char suit : "SHDC".toCharArray()) { //goes through every suit, in the correct order
            for (String card : hand) { //collects all the cards of that suit on its own line.
                if (card.charAt(1) == suit) {
                    formattedString += card+" ";
                }
            }
            formattedString+='\n';
        }
        return formattedString;
    }

    /**
     * Calculates the score of a hand, based on the number of jacks, queens, kings, and aces
     * in the hand in addition to the number of voids, singletons, and doubletons.
     * @param cards The hand of cards to be scored.
     * @return The integer value representing the hand's score.
     */
    static int calculateScore(List<String> cards){
        if(cards.size() != 13){
            return -1;
        }
        int hearts = 0, clubs = 0, spades = 0, diamonds = 0;
        int score = 0;
        for (String c : cards){
            switch (c.charAt(0)){ //checks the value of the card
                case 'A' -> score+=4;
                case 'J' -> score += 1;
                case 'Q' -> score+=2;
                case 'K' -> score +=3;
            }
            switch (c.charAt(1)){ //counts how many of each suit
                case 'H' -> hearts++;
                case 'C' -> clubs++;
                case 'S' -> spades++;
                case 'D' -> diamonds++;
            }
        }
        //adds the correct score based on how many of each suit
        if ((hearts|clubs|spades|diamonds)==0){ //fun optimization for checking if any values are 0.
            score+=3;
        }
        if (hearts==1||clubs==1||spades==1||diamonds==1){
            score+=2;
        }
        if (hearts==2||clubs==2||spades==2||diamonds==2){
            score+=1;
        }
        return score;
    }
}