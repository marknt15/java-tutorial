// To run .jar files
java -jar HelloWorld.jar

// Compile a single file
javac HelloWorld.java

// Compile with a specific classpath
javac -cp lib/dependency.jar:. MyClass.java

// Specify output directory
javac -d build src/com/example/MyClass.java

// Run a class with main method
java MyClass

// Run a class with package name
java com.example.MyClass

// Run a JAR file
java -jar application.jar
  
// Maven
./mvn
