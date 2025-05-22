import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaGenericsStreamsTutorial {

    public static void main(String[] args) {
        // Demonstrate Generics
        System.out.println("--- Java Generics Demo ---");
        genericsDemo();

        // Demonstrate Streams
        System.out.println("\n--- Java Streams Demo ---");
        streamsDemo();
    }

    // Section: Java Generics
    // Java Generics allow us to create classes, interfaces, and methods that can work with different data types
    // while providing compile-time type safety. This helps in reducing code duplication and catching errors early.

    /**
     * Demonstrates the use of a generic class.
     *
     * @param <T> the type of the value
     */
    static class Box<T> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    /**
     * Demonstrates the use of a generic method.
     *
     * @param <E>   the type of elements in the list
     * @param list  the list to print
     */
    public static <E> void printList(List<E> list) {
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void genericsDemo() {
        // Example 1: Generic Class Box
        // Creating a Box for Integer
        Box<Integer> integerBox = new Box<>(10);
        System.out.println("Integer Box value: " + integerBox.getValue());

        // Creating a Box for String
        Box<String> stringBox = new Box<>("Hello Generics");
        System.out.println("String Box value: " + stringBox.getValue());

        // Example 2: Generic Method printList
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.print("Printing Integer list: ");
        printList(numbers);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        System.out.print("Printing String list: ");
        printList(names);

        // Example 3: Type inference with the diamond operator
        Box<Double> doubleBox = new Box<>(25.5); // Type inferred
        System.out.println("Double Box value: " + doubleBox.getValue());
    }


    // Section: Java Streams
    // Java Streams, introduced in Java 8, provide a powerful and concise way to process sequences of elements.
    // Streams support various operations like filtering, mapping, reducing, and collecting.
    // They enable functional-style programming on collections.

    public static void streamsDemo() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig");

        // Example 1: Filtering
        // Filter words that start with 'c'
        List<String> wordsStartingWithC = words.stream()
                                               .filter(word -> word.startsWith("c")) // Predicate to filter
                                               .collect(Collectors.toList());      // Collect results into a new list
        System.out.println("Words starting with 'c': " + wordsStartingWithC);

        // Example 2: Mapping
        // Convert all words to uppercase
        List<String> uppercaseWords = words.stream()
                                          .map(String::toUpperCase) // Function to transform each element
                                          .collect(Collectors.toList());
        System.out.println("Uppercase words: " + uppercaseWords);

        // Example 3: Filtering and Mapping
        // Get the lengths of words that have more than 5 characters
        List<Integer> lengthsOfLongWords = words.stream()
                                               .filter(word -> word.length() > 5) // Filter long words
                                               .map(String::length)             // Map to their lengths
                                               .collect(Collectors.toList());
        System.out.println("Lengths of long words (>5 chars): " + lengthsOfLongWords);

        // Example 4: Reducing
        // Concatenate all words into a single string
        String concatenatedWords = words.stream()
                                        .reduce("", (partialString, element) -> partialString + " " + element); // Accumulator
        System.out.println("Concatenated words: " + concatenatedWords.trim());

        // Example 5: ForEach
        // Print each word that contains 'a'
        System.out.print("Words containing 'a': ");
        words.stream()
             .filter(word -> word.contains("a"))
             .forEach(word -> System.out.print(word + " ")); // Terminal operation
        System.out.println();

        // Example 6: Creating a stream from an array and performing operations
        Integer[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Sum of squares of even numbers
        int sumOfSquaresOfEvenNumbers = Arrays.stream(numberArray) // Create stream from array
                                             .filter(n -> n % 2 == 0)    // Filter even numbers
                                             .mapToInt(n -> n * n)       // Square each number (map to IntStream for sum())
                                             .sum();                     // Reduce to get the sum
        System.out.println("Sum of squares of even numbers from array: " + sumOfSquaresOfEvenNumbers);

        // Example 7: Using distinct() to get unique elements
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5, 6, 6);
        List<Integer> distinctNumbers = numbersWithDuplicates.stream()
                                                            .distinct() // Get unique elements
                                                            .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers);
    }
}
