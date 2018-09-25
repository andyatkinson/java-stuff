import java.util.Arrays;

public class Parallel {

    /*
    https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

    filter, map, forEach aren't performing actual transformations, but
    they're called with the array item and thread name to see how they're executed

    4 threads available by default on my machine, behavior is non-deterministic
     */
    private void streamPrint() {
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
              .parallelStream()
              .filter(s -> {
                  System.out.format("filter: %s [%s]\n",
                                    s, Thread.currentThread().getName());
                  return true;
              })
              .map(s -> {
                  System.out.format("map: %s [%s]\n",
                                    s, Thread.currentThread().getName());
                  return s.toUpperCase();
              })
              .forEach(s -> System.out.format("forEach: %s [%s]\n",
                                              s, Thread.currentThread().getName()));
    }


    public static void main(String[] args) {
        Parallel p = new Parallel();
        p.streamPrint();
    }
}
