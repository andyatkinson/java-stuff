## Java Playground

### Build

This project was built with Java 8 using IntelliJ IDEA.

This is a Maven project. 

### Command line

```java
mvn exec:java -Dexec.mainClass="Playground"
```


Execute in parallel, specifying number of threads.

```java
mvn exec:java -Djava.util.concurrent.ForkJoinPool.common.parallelism=4 -Dexec.mainClass="Parallel"

```


### Tips

These will require Java 8+

`javarepl`

`Objects.requireNonNull()`

* Use this instead of doing manual null checks.

`Playground.frequency(Collection c, Object o)`

* Count number of occurrences of object in collection

`UUID.randomUUID()`

* Generate a random UUID for tests

`Optional.ifPresent()`

* Use a functional programming style and execute a block when object is present

### Immutables

<https://dzone.com/articles/immutability-with-builder-design-pattern>

`stream()`

> A sequence of elements supporting sequential and parallel aggregate operations.

* [Streams javadoc](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
* [Streams tutorial](https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/)

`filter`, `map`, `sorted` are intermediate operations, where `forEach` is terminal.

Streams may be iterated in parallel.

`Collectors.groupingBy`
`Collectors.toMap`


### Lists

```java
final ArrayList<String> list = new ArrayList(Arrays.asList("Ryan", "Julie", "Bob"));

final List a = new ArrayList(Arrays.asList(1,2,3));

ImmutableList.of(1, 2, 3);
```
