import java.util.*;
import java.util.stream.Collectors;

public class Homework08 {
    // Task 1: Intersection of sets
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        // Creating a new set to store the intersection
        Set<Integer> result = new HashSet<>(set1);
        // With the help of retainAll, we leave only common elements
        result.retainAll(set2);
        return result;
    }

    // Task 2: The difference between sets
    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        // Creating a new set to store the difference
        Set<Integer> result = new HashSet<>(set1);
        // Using removeAll, we remove the elements that are in the second set
        result.removeAll(set2);
        return result;
    }

    // Task 3: Counting words in a line
    public static Map<String, Integer> countWords(String input) {
        // Splitting the string into words using spaces
        String[] words = input.split("\\s+");
        // Creating a map to store words and their number
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            // We bring the word to the lower case
            String cleanWord = word.toLowerCase();
            // We use a regular expression to remove punctuation marks
            cleanWord = cleanWord.replaceAll("[^a-z]", "");
            // Counting words
            wordCount.put(cleanWord, wordCount.getOrDefault(cleanWord, 0) + 1);
        }

        return wordCount;
    }

    public static void main(String[] args) {
        Set<Integer> x = Set.of(1, 2, 3, 4);
        Set<Integer> y = Set.of(5, 2, 7, 1);

        Set<Integer> intersectionResult = intersection(x, y);
        System.out.println("Intersection: " + intersectionResult);

        Set<Integer> differenceResult = difference(x, y);
        System.out.println("Difference: " + differenceResult);

        String text = "Hello this is a string that contains Hello and other words";
        Map<String, Integer> wordCounts = countWords(text);

        System.out.println("Word Counts: " + wordCounts.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(", ")));
    }
}
