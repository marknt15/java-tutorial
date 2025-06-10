Spring Data JPA Tutorial

Lessons:

Open and Closed Principle - uses dependency injection and polymorphism

	Dependecy Injection is related to Inversion of Control

Dependency Inversion Principle - related to Open Closed Principle that uses interfaces, Dependency Injection, and Inversion of Control.

============================================

How to add Spring Data JPA and connect to a database:
- install MySQL
- in pom.xml file, click add starters link then search the following dependencies
	- spring data jpa, flyway and MySQL driver
- configure data source, go to application.yml file
- add the following:
datasource:
	url: jdbc:mysql://localhost:3306/store?createDatabaseIfNotExist=true
	username: root
	password: MyPassword!

Example DB relationship
Category one to many Product
Product many to many User
User one to one Profile
address many to one User
User many to many Tag

DB first approach: DB -> Application
Model first approach: Application -> DB

Creating a DB:
- Designing DB Tables - using IntelliJ DB tools
- DB migrations with Flyway
- Changing the DB schema

Creating DB tables:
- write SQL DDL statements
- use a DB design tool

How to use Flyway migration:
- create folders src/main/resource/db/migration
- Then in migration folder add a file V!__initial_migration.sql
- right click store DB in IntelliJ then SQL Scripts -> SQL Generator

Running Migrations using Maven
- Add a new plugin in the pom.xml file
- ctrl + n then select Plugin Template
	<groupId>org.flywaydb</groupId> <--- press ctrl + space then select org.flywaydb
	<artifactId>flyway-maven-plugin</artifactId>
	<version></version> <--- select latest version
	<configuration>
		<url>jdbc:mysql://localhost:3306/store?createDatabaseIfNotExist=true</url>
		<user>root</user>
		<password>MyPassword!</password>
		<cleanDisabled>false</cleanDisabled>
	</configuration>

CREATE TABLE profiles
(
	id	BIGINT PRIMARY KEY,
	bio	TEXT,
	phone_number	VARCHAR(15)
	date_of_birth	DATE
	loyalty_points	INT UNSIGNED DEFAULT 0
	FOREIGN KEY (id) REFERENCES users(id)
)

CREATE TABLE tags
(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL
)

-- Create the user_tags join table
CREATE TABLE user_tags
(
	user_id BIGINT NOT NULL,
	tag_id INT NOT NULL,
	PRIMARY KEY (user_id, tag_id),
	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
	FOREIGN KEY (tag_id) REFERENCES tags (id) ON DELETE CASCADE
)

Then click in the intelliJ Maven icon in the right sidebar then double click Plugins -> flyway -> flyway:migrate

Creating the Domain Model:
- Defining Entities
- Simplify Entities using Lombok
- Defining Relationships
- JPA Buddy - makes faster and easier to generate entities and DB migrations
- Model First approach - start Java classes used to generate DB schemas

Entity - is a Java class that represents a table in the DB. Each instance of the class represents a row in our DB. With these entities we can work with Java objects instead of writing raw SQL for every operation.

In the Project, add a new package called entities (some people like to call it models or domain)
then add a class User.java with annotation @Entity above the class name

Example:

// User.java ---> to rearrange code after adding getters setter press shift + control + a then select Rearrange code
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// add also getters and setters for name, email and password
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, name = "name")
	private String name;

	@Column(nullable = false, name = "email")
	private String email;

	@Column(nullable = false, name = "password")
	private String password;	
}


Simplifying Code with Lombok
- Java Lombok is a library that helps developers reduce boilerplate code in Java applications. It provides annotations that automatically generate common methods like getters, setters, constructors, equals, hashCode, and toString, as well as other functionalities such as logging and builder patterns. By using Lombok, developers can focus on writing business logic rather than repetitive code.
- Lombok library gives annotations and instruct intelliJ to automatically generate getters, setters, constructors and utility methods at compile time.
	- @Getter
	- @Setter
	- @AllArgsConstructor
	- @NoArgsConstructor
	- @ToString


