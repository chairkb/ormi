## ormi


ormi maps Java POJO into relational databases. ormi is the only true ORM that is able to map all OO concept into a relational database.


## Supported Database

- MySQL
- MariaDB
- Postgres
- Oracle


## Features

ormi supports mapping the following Java OOP concepts:

- Class (maps into a table)
- Properties (maps class properties into database fields for all primitive datatypes)
- Class Properties (maps complex datatypes of type class, in OOP also known as a member of)
- Inheritance (maps the inheritance relationship of a class with the inherited class)
- Abstract Class (places the properties of an abstract class into a concrete class)
- Polymorphism (enable a member of class type to behave polymorphically)
- Array of Objects (supports handling of array of objects)

ormi supports the following database operations:

- DDL Creation (generate DDL to create tables, columns for the defined class in Java)
- Persistence (when a Java POJO class is persisted, ormi will handle all the underlying intricancies)
- Deletion (when deleting a class, ormi can also delete its related class when configured to do so)
- Updating (like Persistence and Deletion, many complex class relationship is being manage by ormi)
- No SQL hence can be easily ported to any SQL database, DDL/DML can be done through java methods

## Benefits

- Allow full enterprise team to use standard OOP as the universal design model
- Never redesign your data model again with ormi standard, consistent and reusable model
- Allows team to have common understanding of a single design principal and concept
- No duplication of enterprise information
- Unlimited standardise scaling capabilities for all your enterprise information system

## Examples

#### Defining database object 

````java
// anything that extends Clasz will be map into the database
public class Addr extends Clasz {
	@ReflectField(type=FieldType.STRING, size=32, displayPosition=5) 
	public static String Addr1;
  
	@ReflectField(type=FieldType.STRING, size=32, displayPosition=10) 
	public static String Addr2;
  
	@ReflectField(type=FieldType.STRING, size=32, displayPosition=15) 
	public static String Addr3;
  
	@ReflectField(type=FieldType.STRING, size=8, displayPosition=20) 
	public static String PostalCode;
  
	@ReflectField(type=FieldType.OBJECT, deleteAsMember=false, 
	clasz=biz.stech.bznes.Country.class, displayPosition=35, prefetch=true, lookup=true) 
	public static String Country; 
  
	@ReflectField(type=FieldType.OBJECT, deleteAsMember=false, 
	clasz=biz.stech.bznes.State.class, displayPosition=40, prefetch=true, lookup=true) 
	public static String State; 
  
	@ReflectField(type=FieldType.OBJECT, deleteAsMember=false, 
	clasz=biz.stech.bznes.City.class, displayPosition=45, prefetch=true, lookup=true) 
	public static String City; 
}
````

#### Persisting objects (insert or update)

````java
	Person employee = (Person) ObjectBase.CreateObject(conn, Person.class);
	employee.setName("Ken Miria");
	employee.setBirthDate(new DateTime());
	employee.setGender(Gender.Male);
	employee.setNationality(Country.UnitedStates);
	employee.setMaritalStatus(Marital.Married);
	company.addEmployee(conn, employee);

	ObjectBase.PersistCommit(conn, company);
````

#### Deleting objects

````java
	// create the object to delete and set a unique search criteria
	Person person = (Person) objectDb.createObject(Person.class); 
	person.setName("Edward Yourdon");
	if (person.populate(conn) == true) {
		if (person.deleteCommit(conn)) {
			App.logInfo("Deleted person Edward Yourdon");
		} else {
			throw new Hinderance("Fail to delete person Edward Yourdon");
		}
	}
````
				
## Quick Start

1. Install Postgres and create a database name 'ormi' using 'postgres' user and 'abc1234' password.

2. Install Java and Maven if you do not have them.

3. Download ormi soruce code from github and extract them to your install directory.

4. Build ormi by going into the installed directory and run

````bash
	mvn install
````

5. Go into the example directory and run 

````bash
	mvn clean compile assembly:single
````

6. In the example/target directory, copy ormi.proprties into the target directory

````bash
	cp ../ormi.properties .
````

7. Run the example application with

````bash
	java -jar example-1.0-SNAPSHOT-jar-with-dependencies.jar
````

8. You will get the follwoing output

````bash
	18Jun2021 22:56:14 INFO Log level is at: DEBG
	18Jun2021 22:56:14 INFO Working directory: C:\stech\ormi-main\example\target
	18Jun2021 22:56:14 INFO Found property file at: C:\stech\ormi-main\example\target\ormi.properties
	18Jun2021 22:56:14 INFO Configuration from: C:\stech\ormi-main\example\target\ormi.properties
	18Jun2021 22:56:14 INFO Log file: C:\Users\Admin\AppData\Local\Temp\\App.202106.log
	18Jun2021 22:56:14 INFO Log on console: true
	18Jun2021 22:56:14 INFO Log next switch at: 2021-07-01T00:00:00.244+08:00
	18Jun2021 22:56:14 INFO Maximum thread: 16
	18Jun2021 22:56:14 COFG OS name: Windows 10
	18Jun2021 22:56:14 COFG OS architecture: amd64
	18Jun2021 22:56:14 COFG OS version: 10.0
	18Jun2021 22:56:14 COFG Java classpath: example-1.0-SNAPSHOT-jar-with-dependencies.jar
	18Jun2021 22:56:14 INFO Total db connection available for threading: 2
	18Jun2021 22:56:14 COFG Jdbc, connecting with url = jdbc:postgresql://localhost:5432/ormi
	18Jun2021 22:56:14 COFG Jdbc, connecting with user = postgres
	18Jun2021 22:56:14 COFG Jdbc, connecting with password = *********
	18Jun2021 22:56:14 COFG Jdbc, connecting with init conn = 2
	18Jun2021 22:56:14 COFG Jdbc, connecting with max conn = 32
	18Jun2021 22:56:14 COFG Jdbc, connecting with time out= 30
	18Jun2021 22:56:15 WARN [ConnectionPool] Getting jdbc connection, available free connection to get from: 2
	18Jun2021 22:56:15 INFO [Clasz] Creating table for class: 'LeaveForm'
	18Jun2021 22:56:15 INFO [Simple] Successfully save leave form into the database!
	18Jun2021 22:56:15 DEBG [ConnectionPool] Released jdbc connection, total free connection: 2
````

9. Check your database for the created tables


## Usage

To use ormi without maven, copy the jar file in the 'relase' directory into your java project library. 

If you're using maven, dowload the release directory and run the following maven command:

````bash
	mvn install:install-file -Dfile=./ormi-1.0-SNAPSHOT.jar -DpomFile=./pom.xml
````

After installing ormi into your maven repository, use the following pom dependency in you maven project:

````maven
	<dependency>
		<groupId>biz.stech</groupId>
		<artifactId>ormi</artifactId>
		<version>1.0-SNAPSHOT</version>
	</dependency>
````

To try out ormi, go to the 'example' directory and compile 'Simple.java' and execute it. To compile with IDE (e.g. eclipse or netbeans) you can import the maven project.
