// Generics in Java are a powerful feature that allows you to write type-safe, reusable code by enabling classes, interfaces, 
// and methods to operate on types specified as parameters. Instead of working with raw Object types, generics let you specify 
// exactly what types your code should work with at compile time.

// ========================================
// BEFORE GENERICS (Java 1.4 and earlier)
// ========================================

import java.util.*;

class BeforeGenerics {
    public static void demonstrateProblems() {
        // Using raw ArrayList - no type safety
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add("World");
        list.add(42); // Oops! Added an Integer by mistake
        
        // Runtime error waiting to happen
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i); // ClassCastException on 42!
            System.out.println(str.toUpperCase());
        }
    }
}

// ========================================
// WITH GENERICS (Java 5+)
// ========================================

class WithGenerics {
    public static void demonstrateSolution() {
        // Type-safe ArrayList
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        // list.add(42); // Compile-time error! Won't compile
        
        // No casting needed, type-safe iteration
        for (String str : list) {
            System.out.println(str.toUpperCase());
        }
    }
}

// ========================================
// GENERIC CLASSES
// ========================================

// Generic class with type parameter T
class Box<T> {
    private T content;
    
    public void set(T content) {
        this.content = content;
    }
    
    public T get() {
        return content;
    }
    
    public boolean isEmpty() {
        return content == null;
    }
}

// Generic class with multiple type parameters
class Pair<T, U> {
    private T first;
    private U second;
    
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() { return first; }
    public U getSecond() { return second; }
    
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

// ========================================
// GENERIC METHODS
// ========================================

class GenericMethods {
    
    // Generic method to swap elements in an array
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // Generic method to find maximum element
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array.length == 0) return null;
        
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
    
    // Generic method to convert array to list
    public static <T> List<T> arrayToList(T[] array) {
        List<T> list = new ArrayList<T>();
        for (T item : array) {
            list.add(item);
        }
        return list;
    }
}

// ========================================
// BOUNDED TYPE PARAMETERS
// ========================================

// Upper bounded: T must extend Number
class NumberBox<T extends Number> {
    private T number;
    
    public NumberBox(T number) {
        this.number = number;
    }
    
    public double getDoubleValue() {
        return number.doubleValue(); // Can call Number methods
    }
    
    public boolean isPositive() {
        return number.doubleValue() > 0;
    }
}

// Multiple bounds: T must extend Number AND implement Comparable
class ComparableNumberBox<T extends Number & Comparable<T>> {
    private T number;
    
    public ComparableNumberBox(T number) {
        this.number = number;
    }
    
    public boolean isGreaterThan(T other) {
        return number.compareTo(other) > 0; // Can use Comparable methods
    }
}

// ========================================
// WILDCARDS
// ========================================

class WildcardExamples {
    
    // Upper bounded wildcard: can read but not write
    public static void printNumbers(List<? extends Number> numbers) {
        for (Number num : numbers) {
            System.out.println(num);
        }
        // numbers.add(42); // Compile error! Can't add to ? extends
    }
    
    // Lower bounded wildcard: can write but limited reading
    public static void addNumbers(List<? super Integer> numbers) {
        numbers.add(42);
        numbers.add(100);
        // Integer num = numbers.get(0); // Compile error! Can only get Object
    }
    
    // Unbounded wildcard
    public static void printListSize(List<?> list) {
        System.out.println("List size: " + list.size());
        // Can only call methods that don't depend on type parameter
    }
}

// ========================================
// GENERIC INTERFACES
// ========================================

interface Repository<T> {
    void save(T entity);
    T findById(int id);
    List<T> findAll();
    void delete(T entity);
}

class UserRepository implements Repository<User> {
    private List<User> users = new ArrayList<>();
    
    @Override
    public void save(User entity) {
        users.add(entity);
    }
    
    @Override
    public User findById(int id) {
        return users.stream()
                   .filter(user -> user.getId() == id)
                   .findFirst()
                   .orElse(null);
    }
    
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }
    
    @Override
    public void delete(User entity) {
        users.remove(entity);
    }
}

class User {
    private int id;
    private String name;
    
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}

// ========================================
// DEMONSTRATION CLASS
// ========================================

public class GenericsDemo {
    public static void main(String[] args) {
        System.out.println("=== Generic Classes ===");
        
        // Using generic Box class
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics!");
        System.out.println("String box: " + stringBox.get());
        
        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        System.out.println("Integer box: " + intBox.get());
        
        // Using Pair class
        Pair<String, Integer> nameAge = new Pair<>("Alice", 30);
        System.out.println("Name-Age pair: " + nameAge);
        
        System.out.println("\n=== Generic Methods ===");
        
        // Using generic methods
        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.println("Before swap: " + Arrays.toString(names));
        GenericMethods.swap(names, 0, 2);
        System.out.println("After swap: " + Arrays.toString(names));
        
        Integer[] numbers = {5, 2, 8, 1, 9};
        System.out.println("Max number: " + GenericMethods.findMax(numbers));
        
        System.out.println("\n=== Bounded Types ===");
        
        NumberBox<Double> doubleBox = new NumberBox<>(3.14);
        System.out.println("Double value: " + doubleBox.getDoubleValue());
        System.out.println("Is positive: " + doubleBox.isPositive());
        
        System.out.println("\n=== Wildcards ===");
        
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        
        WildcardExamples.printNumbers(intList);
        WildcardExamples.printNumbers(doubleList);
        
        System.out.println("\n=== Generic Interface ===");
        
        UserRepository userRepo = new UserRepository();
        userRepo.save(new User(1, "John"));
        userRepo.save(new User(2, "Jane"));
        
        System.out.println("All users: " + userRepo.findAll());
        System.out.println("User with ID 1: " + userRepo.findById(1));
    }
}
