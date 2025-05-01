public class JavaVariableTypes {
    public static void main(String[] args) {

        var message = "Hello"; // Clearly a String
        var count = 0;         // Clearly an int

        // Instead of this:
        HashMap<String, List<Customer>> customersByRegion = new HashMap<String, List<Customer>>();
        
        // You can write:
        var customersByRegion = new HashMap<String, List<Customer>>();


        
        // PRIMITIVE DATA TYPES
        System.out.println("--- PRIMITIVE DATA TYPES ---");
        
        // 1. Integer types
        byte byteVar = 127;                // 8-bit, range: -128 to 127
        short shortVar = 32767;            // 16-bit, range: -32,768 to 32,767
        int intVar = 2147483647;           // 32-bit, range: -2^31 to 2^31-1
        long longVar = 9223372036854775807L; // 64-bit, range: -2^63 to 2^63-1, note the 'L' suffix
        
        System.out.println("byte value: " + byteVar);
        System.out.println("short value: " + shortVar);
        System.out.println("int value: " + intVar);
        System.out.println("long value: " + longVar);
        
        // 2. Floating-point types
        float floatVar = 3.14159265f;      // 32-bit IEEE 754, note the 'f' suffix
        double doubleVar = 3.141592653589793; // 64-bit IEEE 754
        
        System.out.println("float value: " + floatVar);
        System.out.println("double value: " + doubleVar);
        
        // 3. Character type
        char charVar = 'A';                // 16-bit Unicode character
        char unicodeChar = '\u0041';       // Unicode representation (also 'A')
        
        System.out.println("char value: " + charVar);
        System.out.println("Unicode char value: " + unicodeChar);
        
        // 4. Boolean type
        boolean boolVar = true;            // true or false
        
        System.out.println("boolean value: " + boolVar);
        
        // REFERENCE DATA TYPES
        System.out.println("\n--- REFERENCE DATA TYPES ---");
        
        // 5. String (most commonly used reference type)
        String stringVar = "Hello, Java!";  // String is a class, not a primitive
        
        System.out.println("String value: " + stringVar);
        
        // 6. Arrays
        int[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Java", "Python", "C++"};
        
        System.out.println("First element in intArray: " + intArray[0]);
        System.out.println("Second element in stringArray: " + stringArray[1]);
        
        // 7. Classes and Objects
        Person person = new Person("John", 30);
        System.out.println("Person object: " + person.getName() + ", " + person.getAge());
        
        // 8. Enums
        Day today = Day.MONDAY;
        System.out.println("Enum value: " + today);
        System.out.println("Is weekend? " + today.isWeekend());
        
        // WRAPPER CLASSES (Object equivalents of primitive types)
        System.out.println("\n--- WRAPPER CLASSES ---");
        
        Byte byteWrapper = 127;
        Short shortWrapper = 32767;
        Integer intWrapper = 2147483647;
        Long longWrapper = 9223372036854775807L;
        Float floatWrapper = 3.14159265f;
        Double doubleWrapper = 3.141592653589793;
        Character charWrapper = 'A';
        Boolean boolWrapper = true;
        
        System.out.println("Integer wrapper: " + intWrapper);
        System.out.println("Boolean wrapper: " + boolWrapper);
        
        // Auto-boxing and unboxing
        int primitiveInt = intWrapper;     // auto-unboxing
        Integer wrapperInt = primitiveInt; // auto-boxing
        
        // COLLECTION TYPES
        System.out.println("\n--- COLLECTION TYPES ---");
        
        // 9. ArrayList (dynamically resizable array)
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("ArrayList: " + list);
        
        // 10. HashMap (key-value pairs)
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        System.out.println("HashMap: " + map);
        System.out.println("Bob's age: " + map.get("Bob"));
        
        // SPECIAL VARIABLE DECLARATIONS
        System.out.println("\n--- SPECIAL VARIABLE DECLARATIONS ---");
        
        // 11. Constants (final variables)
        final double PI = 3.14159265359;
        // PI = 3.14; // This would cause a compilation error
        System.out.println("Constant PI: " + PI);
        
        // 12. Static variables (class variables)
        System.out.println("Static counter before: " + Counter.count);
        Counter.incrementCount();
        System.out.println("Static counter after: " + Counter.count);
        
        // 13. Instance variables vs local variables
        VariableDemo varDemo = new VariableDemo();
        varDemo.demonstrateVariables();
        
        // 14. var keyword (Local Variable Type Inference, Java 10+)
        var dynamicVar = "This type is inferred as String";
        var numberVar = 100; // This type is inferred as int
        System.out.println("var String: " + dynamicVar);
        System.out.println("var int: " + numberVar);
    }
}

// Example class for Objects
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}

// Example for Enum
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    
    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

// Example for static variables
class Counter {
    public static int count = 0;
    
    public static void incrementCount() {
        count++;
    }
}

// Example for instance vs local variables
class VariableDemo {
    private int instanceVar = 10; // Instance variable
    
    public void demonstrateVariables() {
        int localVar = 20; // Local variable
        System.out.println("Instance variable: " + instanceVar);
        System.out.println("Local variable: " + localVar);
        
        // localVar is only accessible within this method
        // instanceVar is accessible throughout the class
    }
}

// To compile this code, you would need these imports:
// import java.util.ArrayList;
// import java.util.HashMap;

/*
Java Variable Types Guide
Java provides a rich set of variable types that can be categorized into primitives and reference types. I've created a comprehensive example that demonstrates all of Java's variable types:
Primitive Data Types
These are the basic data types built into Java:

Integer Types: Used for whole numbers

byte (8-bit): -128 to 127
short (16-bit): -32,768 to 32,767
int (32-bit): Approximately ±2 billion
long (64-bit): Much larger range, requires an 'L' suffix


Floating-Point Types: Used for decimal numbers

float (32-bit): Requires an 'f' suffix
double (64-bit): Higher precision


Character Type:

char: Stores a single 16-bit Unicode character


Boolean Type:

boolean: Stores true or false values



Reference Data Types
These are object types that reference memory locations:

String: For text data
Arrays: For collections of the same type
Classes/Objects: Custom data types
Enum: Special class for constants

Wrapper Classes
Object equivalents of primitive types:

Byte, Short, Integer, Long
Float, Double
Character, Boolean

Collection Types
For storing multiple objects:

ArrayList: Dynamic arrays
HashMap: Key-value pairs

Special Variable Declarations

Constants: Using the final keyword
Static Variables: Shared across all instances
Instance vs. Local Variables: Scope differences
var: Type inference (Java 10+)
*/

