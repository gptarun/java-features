package common.features.comapreinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SolveQuestions {
    public static void main(String[] args) {
        // Example for Comparable
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "FNF23", 2023));
        movies.add(new Movie(2, "FNF19", 2019));
        movies.add(new Movie(3, "FNF24", 2024));
        Collections.sort(movies);
//        movies.forEach(System.out::println);

        // Example for Comparator
        List<Film> films = new ArrayList<>();
        films.add(new Film(1, "FNF231", 2023));
        films.add(new Film(2, "FNF19", 2019));
        films.add(new Film(3, "FNF2434", 2024));
//        Collections.sort(films, new YearComparator());
        Collections.sort(films, Comparator.comparingInt(o -> o.name.length()));
        films.forEach(System.out::println);
    }
}