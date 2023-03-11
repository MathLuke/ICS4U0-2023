import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>ArrayList Assignment Part 1.2</h1>
 * Driver class for part 1.2 of the Arrays Assignment. Generates a random 4-line poem from a library
 * of words stored in multiple ArrayLists based on the word type. This part of the assignment was primarily
 * completed by Luke Mathieu.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-10
 *
 * @author Luke Mathieu, Tom Philip
 */

public class ArrayList_Assignment_Part1_2 {
    List<String> articles = new ArrayList<>();
    List<String> nouns = new ArrayList<>();
    List<String> verbs = new ArrayList<>();
    List<String> prepositions = new ArrayList<>();
    List<String> adjectives = new ArrayList<>();
    List<String> adverbs = new ArrayList<>();

    /**
     * Class constructor. Adds all the words used for poem generation into the ArrayLists.
     */
    public ArrayList_Assignment_Part1_2 () {
        articles.addAll(Arrays.asList("a", "the", "one", "two", "three", "two thousand", "another", "some"));
        nouns.addAll(Arrays.asList("dog", "tree", "flower", "rock", "bird", "eagle", "bear", "ant", "otter", "winter", "spring", "summer", "fall", "river", "sun"));
        verbs.addAll(Arrays.asList("jumped", "walked", "flew", "listened", "waited", "ran", "sprinted", "looked", "soared", "leaped", "went", "moved", "passed"));
        prepositions.addAll(Arrays.asList("over", "under", "on", "at", "behind", "in front of", "from", "for", "around", "after", "across", "near", "past", "beyond", "towards"));
        adjectives.addAll(Arrays.asList("red", "orange", "yellow", "green", "blue", "white", "black", "grey", "tall", "short", "little", "lovely"));
        adverbs.addAll(Arrays.asList("quickly", "slowly", "desperately", "quietly", "loudly", "silently", "easily", "barely", "nearly", "deliberately", "carefully", "boldly", "bravely", "calmly"));

    }

    /**
     * Generates a 4-line poem based on the words in the Arraylists.
     * @return The complete 4-line poem.
     */
    public String generatePoem () {
        String poem = "";
        String word, nextWord;

        // Generates first line of the poem, composed of a preposition, and article, and a noun.
        word = prepositions.get((int)(Math.random()*prepositions.size()));
        word = word.substring(0, 1).toUpperCase() + word.substring(1);

        poem += word;

        word = articles.get((int) (Math.random() * articles.size()));
        nextWord = nouns.get((int) (Math.random() * nouns.size()));

        if (word.equals("a") && (nextWord.substring(0, 1).equals("a") || nextWord.substring(0, 1).equals("e") || nextWord.substring(0, 1).equals("i") || nextWord.substring(0, 1).equals("o") || nextWord.substring(0, 1).equals("u"))) {
            poem += " " + word + "n " + nextWord;
        } else if (word.equals("two") || word.equals("three") || word.equals("two thousand")) {
            poem += " " + word + " " + nextWord + "s";
        } else {
            poem += " " + word + " " + nextWord;
        }

        poem += ",\n";

        // Generates two lines to the poem, of the same form as the sentences in part 1.
        for (int i = 0; i < 2; i++) {
            word = articles.get((int) (Math.random() * articles.size()));
            word = word.substring(0, 1).toUpperCase() + word.substring(1);
            nextWord = nouns.get((int) (Math.random() * nouns.size()));

            if (word.equals("A") && (nextWord.substring(0, 1).equals("a") || nextWord.substring(0, 1).equals("e") || nextWord.substring(0, 1).equals("i") || nextWord.substring(0, 1).equals("o") || nextWord.substring(0, 1).equals("u"))) {
                poem += word + "n " + nextWord;
            } else if (word.equals("Two") || word.equals("Three") || word.equals("Two thousand")) {
                poem += word + " " + nextWord + "s";
            } else {
                poem += word + " " + nextWord;
            }

            poem += " " + adverbs.get((int) (Math.random() * adverbs.size())) + " " + verbs.get((int) (Math.random() * verbs.size()));

            poem += " " + prepositions.get((int) (Math.random() * prepositions.size()));

            word = articles.get((int) (Math.random() * articles.size()));
            nextWord = adjectives.get((int) (Math.random() * adjectives.size()));

            if (word.equals("a") && (nextWord.substring(0, 1).equals("a") || nextWord.substring(0, 1).equals("e") || nextWord.substring(0, 1).equals("i") || nextWord.substring(0, 1).equals("o") || nextWord.substring(0, 1).equals("u"))) {
                poem += " " + word + "n " + nextWord + " " + nouns.get((int) (Math.random() * nouns.size()));
            } else if (word.equals("two") || word.equals("three") || word.equals("two thousand")) {
                poem += " " + word + " " + nextWord + " " + nouns.get((int) (Math.random() * nouns.size())) + "s";
            } else {
                poem += " " + word + " " + nextWord + " " + nouns.get((int) (Math.random() * nouns.size()));
            }

            poem += ",\n";
        }

        // Generates the final line of the poem, composed of an article and a noun.
        word = articles.get((int) (Math.random() * articles.size()));
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        nextWord = nouns.get((int) (Math.random() * nouns.size()));

        if (word.equals("A") && (nextWord.substring(0, 1).equals("a") || nextWord.substring(0, 1).equals("e") || nextWord.substring(0, 1).equals("i") || nextWord.substring(0, 1).equals("o") || nextWord.substring(0, 1).equals("u"))) {
            poem += word + "n " + nextWord;
        } else if (word.equals("Two") || word.equals("Three") || word.equals("Two thousand")) {
            poem += word + " " + nextWord + "s";
        } else {
            poem += word + " " + nextWord;
        }

        return poem + ".";
    }

    // main method
    public static void main(String[] args) {
        ArrayList_Assignment_Part1_2 main = new ArrayList_Assignment_Part1_2();
        System.out.println("AI Poem Assignment by Luke Mathieu and Tom Philip: \n");
        System.out.println(main.generatePoem());
    }
}