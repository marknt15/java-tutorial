package org.helloworld;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A comprehensive tutorial on Java Collections Framework
 * This tutorial covers the fundamental concepts and implementations
 * of the Java Collections Framework with practical examples.
 */
public class CollectionsTutorial {
    public static void main(String[] args) {
        // Introduction
        System.out.println("=== Introduction to Java Collections ===");
        /*
         * The Java Collections Framework is a unified architecture for representing and manipulating collections.
         * It provides a set of interfaces, implementations, and algorithms for common data structures.
         * Collections are objects that group multiple elements into a single unit.
         */

        // Overview of Collections Framework
        System.out.println("\n=== Overview of Collections Framework ===");
        /*
         * The Collections Framework consists of:
         * 1. Interfaces: Define the contract for different types of collections
         * 2. Implementations: Concrete classes that implement the interfaces
         * 3. Algorithms: Methods that perform useful computations on collections
         */

        // The Need for Iterables
        System.out.println("\n=== The Need for Iterables ===");
        /*
         * Iterables are needed to provide a standard way to traverse through collections
         * regardless of their underlying implementation.
         * This allows for consistent iteration patterns across different collection types.
         */

        // The Iterable Interface
        System.out.println("\n=== The Iterable Interface ===");
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        // Method 1: Using enhanced for loop (internally uses Iterable)
        System.out.println("Using enhanced for loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        // Method 2: Using forEach method
        System.out.println("\nUsing forEach method:");
        fruits.forEach(System.out::println);
        // Method 3: Using forEach with lambda
        System.out.println("\nUsing forEach with lambda:");
        fruits.forEach(fruit -> System.out.println("Fruit: " + fruit));

        // The Iterator Interface
        System.out.println("\n=== The Iterator Interface ===");
        Iterator<String> iterator = fruits.iterator();
        System.out.println("Using Iterator:");
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        // The List Interface
        System.out.println("\n=== The List Interface ===");
        // ArrayList example
        System.out.println("\nArrayList Example:");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("ArrayList: " + numbers);
        System.out.println("Size: " + numbers.size());
        System.out.println("Contains 2: " + numbers.contains(2));
        System.out.println("Index of 3: " + numbers.indexOf(3));

        // LinkedList example
        System.out.println("\nLinkedList Example:");
        List<String> names = new LinkedList<>();
        names.add("John");
        names.add("Jane");
        names.add("Bob");
        System.out.println("LinkedList: " + names);
        System.out.println("First element: " + ((LinkedList<String>) names).getFirst());
        System.out.println("Last element: " + ((LinkedList<String>) names).getLast());

        // The Comparable Interface
        System.out.println("\n=== The Comparable Interface ===");
        class Person implements Comparable<Person> {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(Person other) {
                return this.age - other.age;
            }

            @Override
            public String toString() {
                return name + " (" + age + ")";
            }
        }

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));
        Collections.sort(people);
        System.out.println("Sorted by age: " + people);

        // The Comparator Interface
        System.out.println("\n=== The Comparator Interface ===");
        Comparator<Person> nameComparator = (p1, p2) -> p1.name.compareTo(p2.name);
        Collections.sort(people, nameComparator);
        System.out.println("Sorted by name: " + people);

        // The Set Interface
        System.out.println("\n=== The Set Interface ===");
        // HashSet example
        System.out.println("\nHashSet Example:");
        Set<String> uniqueWords = new HashSet<>();
        uniqueWords.add("apple");
        uniqueWords.add("banana");
        uniqueWords.add("apple"); // Duplicate, won't be added
        System.out.println("HashSet: " + uniqueWords);
        System.out.println("Size: " + uniqueWords.size());
        System.out.println("Contains 'banana': " + uniqueWords.contains("banana"));

        // TreeSet example
        System.out.println("\nTreeSet Example:");
        Set<Integer> sortedNumbers = new TreeSet<>();
        sortedNumbers.add(5);
        sortedNumbers.add(2);
        sortedNumbers.add(8);
        System.out.println("TreeSet: " + sortedNumbers);
        System.out.println("First element: " + ((TreeSet<Integer>) sortedNumbers).first());
        System.out.println("Last element: " + ((TreeSet<Integer>) sortedNumbers).last());

        // Hash tables
        System.out.println("\n=== Hash Tables ===");
        /*
         * Hash tables are data structures that implement an associative array abstract data type,
         * a structure that can map keys to values. They use a hash function to compute an index
         * into an array of buckets or slots, from which the desired value can be found.
         */

        // The Map Interface
        System.out.println("\n=== The Map Interface ===");
        // HashMap example
        System.out.println("\nHashMap Example:");
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("John", 85);
        studentScores.put("Jane", 92);
        studentScores.put("Bob", 78);
        System.out.println("HashMap: " + studentScores);
        System.out.println("John's score: " + studentScores.get("John"));
        System.out.println("Contains key 'Jane': " + studentScores.containsKey("Jane"));
        System.out.println("Contains value 92: " + studentScores.containsValue(92));

        // TreeMap example
        System.out.println("\nTreeMap Example:");
        Map<String, String> countryCapitals = new TreeMap<>();
        countryCapitals.put("USA", "Washington D.C.");
        countryCapitals.put("Japan", "Tokyo");
        countryCapitals.put("France", "Paris");
        System.out.println("TreeMap: " + countryCapitals);
        System.out.println("First key: " + ((TreeMap<String, String>) countryCapitals).firstKey());
        System.out.println("Last key: " + ((TreeMap<String, String>) countryCapitals).lastKey());

        // Summary
        System.out.println("\n=== Summary ===");
        /*
         * The Java Collections Framework provides:
         * 1. Reusable data structures
         * 2. Standard interfaces for collections
         * 3. Efficient implementations
         * 4. Algorithms for common operations
         * 5. Type safety through generics
         * 6. Thread-safe collections when needed
         */
    }
}
