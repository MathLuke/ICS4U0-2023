import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>ArrayList Assignment Part 1.1</h1>
 * Driver class for part 1.1 of the Arrays Assignment.
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V. <br></br>
 * <p>
 * 2023-03-07
 *
 * @author Luke Mathieu, Tom Philip
 */

public class ArrayList_Assignment_Part1_1 {
    List<String> articles = new ArrayList<>();
    List<String> nouns = new ArrayList<>();
    List<String> verbs = new ArrayList<>();
    List<String> prepositions = new ArrayList<>();
    List<String> adjectives = new ArrayList<>();
    List<String> adverbs = new ArrayList<>();

    /**
     * Class constructor.
     */
    public ArrayList_Assignment_Part1_1 () {
        articles.addAll(Arrays.asList("a", "the", "one", "two", "three", "two thousand", "another", "some"));
        nouns.addAll(Arrays.asList("boy", "girl", "dog", "tree", "flower", "building", "house", "egg"));
        verbs.addAll(Arrays.asList("jumped", "walked", "flew", "listened", "waited", "ran", "sprinted", "heard"));
        prepositions.addAll(Arrays.asList("over", "under", "on", "behind", "in front of", "from", "for", "around"));
        adjectives.addAll(Arrays.asList("red", "orange", "yellow", "green", "blue", "purple", "tall", "short"));
        adverbs.addAll(Arrays.asList("quickly", "slowly", "desperately", "efficiently", "quietly", "loudly"));

    }

    public String generateSentence () {
        String sentence = "";
        String word, nextWord;

        word = articles.get((int) (Math.random()*articles.size()));
        word = word.substring(0,1).toUpperCase() + word.substring(1);
        nextWord = nouns.get((int)(Math.random()*nouns.size()));

        if (word.equals("A") && (nextWord.substring(0,1).equals("a") || nextWord.substring(0,1).equals("e") || nextWord.substring(0,1).equals("i") || nextWord.substring(0,1).equals("o") || nextWord.substring(0,1).equals("u"))) {
            sentence += word + "n " + nextWord;
        } else if (word.equals("Two") || word.equals("Three") || word.equals("Two thousand")) {
            sentence += word + " " + nextWord + "s";
        } else {
            sentence += word + " " + nextWord;
        }

        sentence += " " + adverbs.get((int)(Math.random()*adverbs.size())) + " " + verbs.get((int)(Math.random()*verbs.size()));

        sentence += " " + prepositions.get((int) (Math.random()*prepositions.size()));

        word = articles.get((int) (Math.random()*prepositions.size()));
        nextWord = adjectives.get((int) (Math.random()*adjectives.size()));

        if (word.equals("a") && (nextWord.substring(0,1).equals("a") || nextWord.substring(0,1).equals("e") || nextWord.substring(0,1).equals("i") || nextWord.substring(0,1).equals("o") || nextWord.substring(0,1).equals("u"))) {
            sentence += " " + word + "n " + nextWord + " " + nouns.get((int)(Math.random()*nouns.size()));
        } else if (word.equals("two") || word.equals("three") || word.equals("two thousand")) {
            sentence += " " + word + " " + nextWord + " " + nouns.get((int)(Math.random()*nouns.size())) + "s";
        } else {
            sentence += " " + word + " " + nextWord + " " + nouns.get((int)(Math.random()*nouns.size()));
        }

        return sentence + ".";
    }

    // main method
    public static void main(String[] args) {
        ArrayList_Assignment_Part1_1 main = new ArrayList_Assignment_Part1_1();
        for (int i = 0; i < 10; i++) {
            System.out.println(main.generateSentence());
        }

    }
}