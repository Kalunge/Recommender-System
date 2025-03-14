# Spring
- Spring is an open source java application framework based on two key principles
    - **Dependency Injection**
    - **Inversion of Control**
- Spring's ability to autowire the dependency at runtime allows the developer to write loosely coupled code.
- Spring framework uses metadata in the form of xml file or java annotations to create objects and identifies dependencies thereby producing a ready-to-use application
- there are three main layers in a typical web application
    - **web**
    - **Business**
    - **Data**
- these collaborate to make an application work and these collaborations are called dependencies
- a typical application has a lot of classes and dependencies

**Tight Coupling**
- Tightly coupled code involves creating an instance of the dependency inside the class


```java
// MovieRecommender class
 public class MovieRecommender {
    ContentBasedFilter filter = new ContentBasedFilter();
    //...
 }
```

```java
// ContentBasedFilter class
 public class ContentBasedFilter {
 	//...
 }
```
- problems arise when we want ti use a different option for the dependency.
- we would need to change the code of the recommender to switch to lets say a more collaborative filter
- this is the disadvantage of a tightly coupled code.

**Loose coupling**
- a better way to implement the above code would be to implement a filter interface
- this will remove the direct instantiation of the `ContentBasedFilter`, and instead ask for the type of filter as an assignment to the constructor

- declare the interface
```java
interface Filter {
    //method declarations
}
```

- implement the interface
```java
public class ContentBasedFilter implements Filter {
    //implement interface methods
}
```

- inject it into MovieRecommender
```java
public class MovieRecommender {
    Filter filter;

    public MovieRecommender(Filter filter) {
        this.filter = filter;
    }
    //...
}
```
- this way, the movie recommender is not dependent on a specific type of filter and can be used with both a content based filter and a collaborative filter.
- we have created an object of `ContentBasedFilter` class implementing the Filter interface ad an object of `MovieRecommender` class.
- we have injected the `ContentBasedFilter` object into the `MovieRecommender` object
- the spring framework writes the code on its own.
- it creates objects ad populates dependencies.
- as a programmer, I need only to have to tell which objects Spring has to create and what the dependencies of each object are.
- Spring takes control of populating the dependencies and injecting the filter object into the movierecomender
- this is in contrast to earlier when the movie recommender instantiated the filter object itself.
- spring inverts the control by taking responsibility for populating the dependency. this is referred to as **Inversion of Control(IoC)**

- Spring has evolved over time and has simplified application development and its ease of use has led to widespread adoption of the framework
- Spring Boot enables users to create a project with all required dependencies automatically wired in.

## Terminology
**Beans**
- Beans are the objects of classes that are managed by Spring
- Traditionally, objects used to create their own dependencies , but Spring manages all the dependencies of an object and instantiates the object after injecting the required dependencies
- the `@Component` annotation is the most common method of defining beans
```java
@Component
public class Vehicle{
    
}
```
**Autowiring**
- The process of identifying a dependency, looking for a match, and then populating the dependency is called autowiring
- The `@Autowired` annotation tells Spring to find and inject a collaborating bean into another
- if more than one bean of the same type is available, Spring throws an error
- in the following scenario, tow beans of type `Operator` are detected by Spring

```java
@Component
class Arithmetic(){
    @Autowired
    private Operator operator;
}
```

```java
@Component
class Addition implements Operator{
  //.. Code here
}
```

```java
class Subtraction implements Operator{
    //.. Code here
}
```
- unless explicitly specified, Spring will not know which bean to inject into the Arithmetic Bean

**Dependency Injection**
- this is the process by which Spring looks up the beans that are needed for a particular bean to function and injects them as a dependency.
- Spring can perform dependency injection by using constructor or by using a setter method

**Inversion of Control(IoC)**
- Traditionally, the class which needed the dependency created and instance of the dependency.
- the clas decided when to create the dependency and how to create it.
- for example, `Engine` class is a dependency of the `Vehicle` class, which creates its object
```java
@Component
class Vehicle{
    private Engine engine = new Engine();
}
```
- in IoC, Spring takes this responsibility from the class and creates the object itself.
- the developer simply mentions the dependency and the framework takes care of he rest
```java
class Vehicle{
    @Autowired
    private final Engine engine;
}

interface Engine{
    //...
}

class EngineImpl implements Engine{
    //...
}
```

- Thus control moves from the component that needs the dependency to the framework.
- the framework takes thhe repsonsibility for finding out the dependencies of a component, ensuring their availability and injecting them in the component
- this process is called Inversion of Control

  ```
  Vehicle ---> Creates ---> Engine To Vehicle <----Injection <---- Engine
  ```

**IoC Container**
- an IoC container is a framework that provides the Onversio of Control functionality.
- The IoC container manages the beans.
- referring to our previous example, it creates an instance of the `Engine` class, then creates an instance of the `Vehicle` class, and the injects the `Engine` objects as a dependency into the `Vehicle` object
- IoC container is a generic term, it is not framework specific, Spring offers two implementations of the IoC container
1. Bean Factory
2. Application Context

```java
class Vehicle{
    private Engine engine;
}
```
- **Bean Factory** and **Application context** are interfaces that have different implementations available.
- Application context is the typical IoC container in the Context of spring.
- Spring recommends using it unless there is memory concern, like in a mobile device.
- if available memory is low, bean factory should be used

**Bean Factory**
- the basic version of the Spring IoC container is bean factory.
- it is the legacy IoC container and provides basic management for beans and wiring of dependencies.
- in Spring, bean factory still exists to provide backward compatibility

**Application Context**
- this adds more features to the bean factory that are typically needed by an enterprise application.
- it is the most important part of the Spring framework.
- all the core logic of spring happens here.
- it includes basic management of beans and wiring of dependencies as provided by the bean factory.
- Additional features in application context include Spring AOP features, internationalization, web application context, etc.

## Spring Architecture
- Spring is not a one big framework, it is broken down into modules.
- This can be seen in the Maven dependencies folder, where there are a lot of JAR files instead of just one big JAR
- it is built in a modular way adn this enables some modules to be used without using the whole framework
- the developer has the choice of which module to use ad which one to discard.

## Spring Modules
- the modules of Spring architecture are grouped together in layers.
  **Core container**
    - **Beans**
    - **Core**
    - **Context**
    - **Spring Expression Language(SpEL)**
- these modules provide fundamental functionality of the Spring framework like inversion of control, dependency injection, internationalization as well as support for querying object at run time

**Data access/Integration**
- Spring has very good integration with data as well as with layers and provides support to interact with databases.
- it has the following modules that aid with data access/integration
- **JDBC(Java Database Connectivity):** allows data layer to interact with databases ot get or store data, or to interact with other systems without the need of cumbersome Jdbc coding.
    - Spring JDBC is very straightforward as compared to plain JDBC and makes the code very short
- **ORM(Object Relational Mapping):** this provides support to integrate with ORM frameworks including Hibernate and JPA
- **JMS(Java Messaging Service):** talks to other applications through the queue to produce and consume messages
- **OXM(object-XML mapping):** makes the object-to-xml transformation easy by providing useful features
- **Transactions:** the transaction management module provides support for successful rollback in case a transaction fails.

**Web (MVC/Remoting)**
- this contains the Web, Servlets, Portlets, and Sockets modules to support the creation of a web application
- Spring offers a web framework of its own called Spring MVC

**Test**
- The test module handles the cross cutting concern of unit testing
- the Spring Test framework supports testing with Junit, TestNG, as well as creating mock objects for testing the code in isolation

**AOP**
- this module provides Aspect Oriented Programming functionality like method interception and pointcuts as well as security and logging features
- Spring has its own module called Spring AOP that offers basic aspect-oriented programming functionality
- Advanced AOP functionality can be implemented through integration with AspectJ.
- AOP features cross cutting concerns from business logic

## Spring Projects
- Spring also provides solutions to different enterprise application problems through Spring projects some of which are discussed below.
  **Spring Boot:**
- this is used to develop micro services
- it makes developing applications easy through features like startup projects, auto configuration, and actuator.

**Spring Cloud**
- allows the development of cloud native applications that can be dynamically configured and deployed
- it provides functionality for handling common patterns in distributed systems

**Spring Data**
- provides consistent access to SQL and NoSQL databases

**Spring Integration**
- implements the patterns outlined by the book Enterprise Application Integration Patterns
- it allows enterprise applications to be connected easily through messaging and declarative patterns

**Spring Batch**
- provides functionality to handle large volumes of data like ability to restart, read from and write to different systems, chunk processing, parallel processing, and transaction management

**Spring Security**
- provides security solutions for different applications be it a web application or  REST service
- it also provides authentication and authorization

**Spring Session**
- manages session information and makes it easier to share session data between services in the cloud regardless of the platform/container.
- it also supports sessions in a single browser instance.

**Spring Mobile**
- offers device detection and progressive rendering options that make mobile web application development easy.

**Spring Android**
- facilitates the development of android applications

## Reasons for Sustained Popularity
- flexibility and integration with other frameworks
- Removing plumbing code
- promotes testable code
- Staying up to date

## Creating a project
- building a Spring application from scratch can be hard
- the developer needs to decide which maven dependencies to use, set up the configuration for XML or java, install tomcat e.tc.
- all these things are necessary for building the infra of the application.
- to simplify this process, enter springboot which offers a quick-fire way to create a spring project.
- it skips the manual configuration
- the highlight of springboot is its auto-configuration feature whereby it automatically includes all the dependencies of a project based property files abd JAR classpaths.
- springboot is basically the spring framework with embedded servers.
  `Spring Boot = Spring Framework + Embedded server - Manual configuration`


- ContentBasedFilter class is a dependency of the RecommenderImplementation, it needs a filter to perform its task. 
  - Tight Coupling
    -   ```RecommenderClass``` -------- calls -------> ```ContentBasedFilterClass```
- if we want to use another filter we would need to change the implementation class. 
- tight coupling makes it difficult for us for instance in a scenario where we want to use one type of filter in one situation and another tyoe in another situation.
- in the above example, we created just two classes which work together, thus creating a dependency.
- in a typical enterprise application, there are a large number of objects which work together to provide some end result to the user.
- This results in a lot of dependencies 
- Spring is a dependency injection framework that makes the process of managing these dependencies easier

## Filter Interface
- One way to make the code loosely coupled is by using an interface called Filter.
- an interface contains abstract methods whose implementation is left to the classes using it. 

- Loose coupling is achieved by making the implementation class use the interface instead of one of its mplementations
- the filter is injected into the recommender using a constructor
- the getRecommendations method now belongs to the interface 
- by using the interface instead of actual implementation, we can dynamically choose which algorithm to use.
- hereby the recommender implementation clas is made independent of the filter implementation and now calls method of the Filter interface
- `Filter` is a dependency of the Recommender Implementation. we still have to create an object f recommenderimplementation and an Object of Filter and pass the objects to the constructor

## Managing Beans and Dependencies
- so far, we have created objects f RecommenderImplementation class and two classes implementing the Filter interface.
- we are binding the objects together in the constructor.
- our code is now loosely coupled as we are passing the name of the filter to be used as a constructor argument. 
- Spring automates the process of creating objects and binding them together .
- it takes the responsibility of creating instances of classes and binding instances based on their dependencies.
- the instances or objects that Spring manages are called Beans
- to manage objects and dependencies, spring requires information about three things
  - Beans
  - Dependencies
  - Location of beans

## @Component
- if we want Spring to create and manage objects, we can do so by adding the @Component annotation at the beginning of the class and importing the Component from springFramework
- if we add the @Component annotation to our recommenderImplementation class and the contentBasedFilter class, the Spring container will have two beans. 

## @Autowired
- the second thing Spring needs to know is the dependencies of each Object.
- the `@Autowired ` annotation is used for this purpose and we need to import it to be able to use it. 
- in our code, the contentBasedFilter class is a dependency of the RecommenderImplementation class.
- the @Autowired annotation tells Spring the recommenderimplementation needs an object of type Filter. in other words, Filter is a dependency of the remommenderclass

- so far the spring container has two beans and it is able to identify that the recommenderimplementation needs a Filter dependency

## @ComponentScan
- the third thing that Spring requires from the developer, is the location of the beans so that it can find them and autowire the dependencies.
- the @ComponentScan annotation is used for this purpose.
- this annotation can be used with or without arguments
- it tells Spring to scan a specific package and all of its sub-packages.
- in our case, all the files that contain beans are in the same package
- since we are using Spring Boot, it uses the @SpringBootApplication annotation on the main class. this annotation is equivalent to the following three annotations
  - **Configuration**: declares a class as the source for beans declaration
  - **EnableAutoConfiguration**: allows the application to add beans using classpath definitions
  - **ComponentScan**: directs Spring to search for components in the path specified
- thus we do not need to use `@ComponentScan` in our application 

## @SpringBootApplication
- `@SpringBootApplication` tells Spring to scan all the files in the package where the class with this annotation is present
- it also scans any sub-packages of the package where it is placed.
- when we use the `@Component`,` @Autowired` and `@SpringBootApplication` annotations we no longer need to instanciate the RecommenderImplementation class.

- the beans that Spring creates are managed by the `ApplicactionContext`.
- we can get information about a bean from the Applicatio context.
- the run() method returns the application context, which can be assigned to a variable appcontext
- then the getBean() method of ApplicationContext can be used to get the bean of a particular class.
- we will create a local variable recommender to assign the bean to it. 

```java
@SpringBootApplication
public class MovieRecommenderSystemApplication {
    public static void main(String[] args) {
        // application context manages the beans and dependencies
        ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

        // we can use appcontext to find which filter is being used
        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);

        // call method to get recommendations
        String[] result = recommender.recommendMovies("Finding Dorry");

        System.out.println(Arrays.toString(result));

    }
}
```

- instead of us having to create an instance of the RecommenderImplementation class , Spring applicaction context creates the beans. we can simply pick it up from there and use it to execute the recommendMovies method
- this might look complex and unnecessary in the beginning, but consider for a moment an application that has hundreds of beans, each having a number of dependencies.
- the fact that we do not have to explicitly create beans and manually wire the dependencies makes the job of a developer very easy
- when we run the application, the application shows that the bean being used is the ContentBased filter.
- if the @Component annotation is used on the CollaborativeBasedFilter instead, the output wll change accordingly. 

- To understand what goes on in the background, we will change the logging level to debug.
- this is done by adding the follwing line to the `application.properties` file.
```yaml
logging:
  level:
    org.springFramework: debug
```
when run, the next code widget will show the log of all the actions that are being performed in the background.
a summarry of the actions is shown below

* Loadng source class... The package is being searched. spring starts with a component scan to find anything with @Component as well as other annotations
* Identified candidate component class... Spring identifies two candidates which have the @Component annotation as we have only used it in two places in our code
* Creating shared instance of Singleton bean MovieRecommenderSystemApplication
* Creating shared instance of Singleton bean ContentBasedFilter. Spring starts creating instances of the beans. it creates beans that do not have any dependency first
* creating shared instance of MovieRecommendatioImplementation
* Autowiring type bean name recommenderImplmentation via constructor to bean named ContentBasedFilter

- Now Spring can autowire the dependency using the constructor that we have provided and creates the RecommenderImplementation bean.
- To better understand these annotations, we can play around with the code and see what error messages Spring throws when some of the annotations are missing
- the error messages can be seen at the end of the logs
- if we remove \2Component from the ContentBased class, Spring will throow an error when trying to autowire the dependency saying it required a bean of type Filter that could not be found
- if we remove the @Component from the RecommenderImplementation class as well, we will get an error when trying to execute the getBean() method as no beans exist.
- if we add @Component to the collaborative filter class, Spring will not know which bean of Filter type to autowire. it says, RecommenderImplementation required a single bean but 2 were found.

## Autowiring by Type - @Primary
- here we will learn how Spring dynamically autowires a dependency in the case it finds more than one component of the same type.

### Dynamic bean selection
- we saw Spring  manage two beans of the RecommenderImplementation and ContentBasedFiltee classes for us.
- now, we will add anothr bean to see how Spring can dynamically choose a bean if it finds two matches of the same type.
- we will add the @Component annotation on the collaborativefilter class to declare it a bean
- now both implementations of the Filter interface care beans.
- preciously Spring searched for a dependency to be autowired in the recommenderimplementation object, it only found one bean matching the type.
- now when we run the application it fails to start and it throws NoUniqueBeanDefinitionException saying requreid a single bean, but two were found

### @Primary Annotation
- one way Spring can choose between two beans of the same type is by giving one bean priority over the other.
- the @Primary annotation is used for making a component the default choice when multiple beans of the same type are found
- Let's say we want the collaborative filter to take precedence, we will add the @Primary annotation on the CollaborativeFilter class and import the annotation form spring context
- when we run the application now, it uses CollaborativeFilter as expected.

- using `@Primary` is called `autowiring by type`
- we are looking for instances fo type Filter.
- if we make both beans primary by adding the @Primary annotation to both implementations of the Filter nterface, we will get an error.
- This happens because Spring does not know which one to inject in the RecommenderImplementation object.
- the error message states `more than one 'primary' bean found among candidates`
















