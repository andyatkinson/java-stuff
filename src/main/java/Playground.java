import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import com.google.common.collect.ImmutableSet;


public class Playground {
    public static void main(String[] args) {
        Playground p = new Playground();
        System.out.println(p.filterCollection());
        p.processPersons();
        p.groupPersons();
        p.buildPersonsMap();
        p.flatMapExample();
        p.enhancedForLoop();
        p.collectionsStuff();
        p.collectionsConversion();
        p.bigMaths();
        p.rangePrint();
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

    private void collectionsStuff() {
        final Set<String> strings = ImmutableSet.of("123", "456", "122");

        System.out.println("Unsorted: " + strings);
        System.out.println("Sorted strings: " + strings.stream().sorted().collect(Collectors.toSet()));
    }

    private void collectionsConversion() {
        List<List<Integer>> outer = new ArrayList<List<Integer>>();

        // array literals
        List<Integer> row1 = Arrays.asList(new Integer[]{1, 2, 3});
        List<Integer> row2 = Arrays.asList(new Integer[]{4, 5, 6});
        List<Integer> row3 = Arrays.asList(new Integer[]{7, 8, 9});

        outer.add(row1);
        outer.add(row2);
        outer.add(row3);

        System.out.format("outer: %s", outer);

        int[][] twoDArray = new int[outer.size()][outer.size()];
        System.out.println("two D array: " + Arrays.toString(twoDArray));

        for(int i = 0; i < outer.size(); i++) {
            List<Integer> row = outer.get(i);
            for(int j = 0; j < row.size(); j++) {
                twoDArray[i][j] = row.get(j);
            }
        }

        System.out.println("two D array: " + twoDArray);
    }

    private void bigMaths() {
        final List<Integer> numbers = Arrays.asList(new Integer[]{1,2,3,4,5});

        // divide the quantity of numbers in the list, by the sum of the items
        final BigDecimal result = new BigDecimal(numbers.size()).divide(
                new BigDecimal(numbers.stream().reduce(0, Integer::sum)), 6, RoundingMode.CEILING
        );
        System.out.println("division result, scale of 6: " + result);
    }

    private void rangePrint() {
        System.out.print("Range: ");
        // start inclusive, end exclusive
        IntStream.range(0, 10).forEach(i -> {
            System.out.print(i);
        });
    }
}
