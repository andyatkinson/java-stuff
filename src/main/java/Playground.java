import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Playground {
    public static void main(String[] args) {
        Playground p = new Playground();
        System.out.println(p.filterCollection());
        p.processPersons();
        p.groupPersons();
        p.buildPersonsMap();
        p.flatMapExample();
        p.enhancedForLoop();
    }

    private Collection<String> filterCollection() {

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        return myList.stream()
              .filter(s -> s.startsWith("c"))
              .sorted()
              .collect(Collectors.toList());
    }


    private void stream() {
        // stream of object references
        Stream.of("a1", "a2", "a3")
              .findFirst()
              .ifPresent(System.out::println);  // a1
    }


    /*
    Streams collect() example
    - terminal operation
     */

    private void processPersons() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        List<Person> filtered =
                persons.stream()
                .filter(p -> p.name.startsWith("P"))
                .collect(Collectors.toList());

        System.out.println(filtered);
    }

    /*
    Collectors.groupingBy()
     */
    private void groupPersons() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge.forEach((age, p) ->
        System.out.format("age %s: %s\n", age, p));
    }

    /*
    Building a map of Persons
    key mapper
    value mapper
    merge function, if multiple values exist for same key
     */
    private void buildPersonsMap() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
    }

    /*
    transforms stream of 3 foo objects
    into a stream of 9 bar objects
     */
    private void flatMapExample() {
        List<Foo> foos = new ArrayList<>();

        // create foos
        IntStream.range(1,4)
                 .forEach(i -> foos.add(new Foo("Foo" + i)));

        // create bars
        foos.forEach(f ->
            IntStream.range(1,4)
                     .forEach(i -> f.bars.add(new Bar("Bar " + i + " <- " + f.name)))
        );

        foos.stream()
            .flatMap(f -> f.bars.stream())
            .forEach(b -> System.out.println(b.name));

    }


    private void enhancedForLoop() {
        // inclusive start and end
        IntStream.rangeClosed(1,10).forEachOrdered(n -> System.out.println(n));
    }
}
