package common.java8features.streams.intermediate;

import java.util.Collection;
import java.util.List;

public class FlatMapMain {
    public static void main(String[] args) {
        /*
         * Flattens the list of lists into a single stream
         */
        List<String> collection = List.of("One", "Two", "One");
        List<List<String>> value = List.of(collection);
        value.stream().flatMap(List::stream).forEach(System.out::print);
        value.stream().flatMap(strings -> strings.stream().distinct()).forEach(System.out::print);
    }
}
