package common.java8features.streams;

public class ParallelStreamsMain {
    public static void main(String[] args) {
        // Choosing performance over order of execution
        String my = "Testing parallel streams over string to chars";
        my.chars().parallel().mapToObj(c -> (char) c).forEach(System.out::print);
    }
}
