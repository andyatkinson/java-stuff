### Java standard library tips

#### Building project

This project was built with Java 8 using IntelliJ IDEA.

This is a Maven project. 


##### Random helpful things

These will require at least Java 8 or potentially newer versions.

`javarepl`

`Objects.requireNonNull()`

* Use this instead of doing manual null checks.

`Playground.frequency(Collection c, Object o)`

* Count number of occurrences of object in collection

`UUID.randomUUID()`

* Generate a random UUID for tests

`Optional.ifPresent()`

* Use a functional programming style and execute a block when object is present

Immutability with builder design pattern

https://dzone.com/articles/immutability-with-builder-design-pattern

`stream()`

> A sequence of elements supporting sequential and parallel aggregate operations.

* [Streams javadoc](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
* [Streams tutorial](https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/)

`filter`, `map`, `sorted` are intermediate operations, where `forEach` is terminal.

Streams may be iterated in parallel.

`Collectors.groupingBy`
`Collectors.toMap`

##### Working with literal lists in javarepl

`ArrayList<String> list = new ArrayList(Arrays.asList("Ryan", "Julie", "Bob"));`
`List a = new ArrayList(Arrays.asList(1,2,3));`
