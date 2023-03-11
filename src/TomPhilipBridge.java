import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TomPhilipBridge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String defaultDeck = "2S 3S 4S 5S 6S 7S 8S 9S TS JS QS KS AS 2H 3H 4H 5H 6H 7H 8H 9H TH JH QH KH AH 2D 3D 4D 5D 6D 7D 8D 9D TD JD QD KD AD 2C 3C 4C 5C 6C 7C 8C 9C TC JC QC KC AC";

        List<Card> deck = new ArrayList<>();
        boolean validDeck = false;
        while(!validDeck) {
            validDeck = true;

            System.out.println("Please input the deck of cards.");
            for (String cardString : defaultDeck.split(" ")) {
                Card nextCard = Card.fromString(cardString);
                deck.add(nextCard);
                if (nextCard == null) {
                    validDeck = false;
                    System.out.println("Invalid cards, please ensure all cards are in the deck and that each card is space separated.");
                    deck = new ArrayList<>();
                }
            }
            if(validDeck && (new HashSet<>(deck).size()!=52)){
                validDeck = false;
                System.out.println("There are repeated cards in the deck, please ensure they are all distinct.");
                deck = new ArrayList<>();
            }
        }

        Collections.shuffle(deck);

        List<Hand> hands = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            hands.add(new Hand());
            for(int j = 0; j<13; j++){
                hands.get(i).addCard(deck.remove(deck.size()-1));
            }
        }
        Hand bestHand = null;
        int bestScore = 0;

        for (int i = 0; i < 4; i++) {
            int score = hands.get(i).calculateScore();
            System.out.println("Hand "+(i+1)+":\n");
            System.out.println(hands.get(i));
            System.out.println();
            System.out.println("Score: "+score);
            System.out.println("\n------------------------------\n");
            if(score>bestScore){
                bestHand = hands.get(i);
                bestScore = score;
            }
        }
        System.out.println("The winner is Hand "+(hands.indexOf(bestHand)+1)+"!");
        System.out.println("\nPress enter to exit...");
        br.readLine();
    }


    static class Hand{
        private List<Card> cards;
        public Hand(){
            this.cards = new ArrayList<>();
        }

        public void addCard(Card c){
            this.cards.add(c);
        }
        public void clearHand(){
            this.cards = new ArrayList<>();
        }
        public int calculateScore(){
            if(cards.size() != 13){
                return -1;
            }
            int hearts = 0, clubs = 0, spades = 0, diamonds = 0;
            int score = 0;
            for (Card c : cards){
                switch (c.getValue()){
                    case 'A' -> score+=4;
                    case 'J' -> score += 1;
                    case 'Q' -> score+=2;
                    case 'K' -> score +=3;
                }
                switch (c.getSuit()){
                    case 'H' -> hearts++;
                    case 'C' -> clubs++;
                    case 'S' -> spades++;
                    case 'D' -> diamonds++;
                }
            }
            if (hearts*clubs*spades*diamonds==0){
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
        public String toString(){
            List<Card> handCpy = new ArrayList<>(this.cards);
            Collections.sort(handCpy);
            StringBuilder sb = new StringBuilder();
            char last = handCpy.get(0).suit;
            for(Card c : handCpy){
                if(c.suit!=last){
                    last = c.suit;
                    sb.append('\n');
                }
                sb.append(c).append(" ");
            }
            return sb.toString();
        }
    }

    static class Card implements Comparable<Card>{


        private final char suit;
        private final char value;
        private static final List<Card> deck = generateDeck();
        private Card(char s, char v){
            this.suit = s;
            this.value = v;
        }
        private static List<Card> generateDeck(){
            List<Card> newDeck = new ArrayList<>(52);
            for (char s : ("SHDC").toCharArray()){
                for (char v : ("23456789TJQKA").toCharArray()){
                    newDeck.add(new Card(s, v));
                }
            }
            return newDeck;
        }
        public static List<Card> getDeck(){
            return new ArrayList<>(deck);
        }

        public char getSuit() {
            return suit;
        }

        public char getValue() {
            return value;
        }
        public static Card fromString(String s){

            try {
                return deck.get(("23456789TJQKA").indexOf(s.charAt(0))  + ("SHDC").indexOf(s.charAt(1))*13);
            } catch (IndexOutOfBoundsException e){
                System.err.println("Invalid string card "+s+".");
                return null;
            }
        }
        public String toString(){
            return ""+this.value+this.suit;
        }

        @Override
        public int compareTo(Card o) {
            return deck.indexOf(this)-deck.indexOf(o);
        }
    }
}
