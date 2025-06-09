Data Access Technologies
- Spring Data JPA
- JPA / Hibernate
- JDBC
- Database


JDBC - Java DB Connectivity (raw SQL connection and queries and closing of connections). Low level access
JPA - Jakarta Persistence API. A specification of mapping Java objects to DB tables. We don't write raw SQL queries. Object Oriented Persistence.
	- JPA is just a specification. To use JPA then use implementations like Hibernate.
Hibernate - ORM (Object Relational Mapper). Similar to Entity Framework in .NET framework. 
	- Provides caching results
	- Provides automatic schema generation - it can generate our DB tables based on our Entity classes.
	- Provides Hibernate Query Language
Spring Data JPA - built on top of JPA and Hibernate to simplify DB access in spring apps. It gives repository interfaces to perform common operations.


What's the difference of the Springboot annotation @controller and @restcontroller 
