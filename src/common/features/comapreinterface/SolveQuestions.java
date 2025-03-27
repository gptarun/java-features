package common.features.comapreinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolveQuestions {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "FNF23", 2023));
        movies.add(new Movie(2, "FNF19", 2019));
        movies.add(new Movie(3, "FNF24", 2024));
        Collections.sort(movies);
//        movies.forEach(System.out::println);

        List<Film> films = new ArrayList<>();
        films.add(new Film(1, "FNF23", 2023));
        films.add(new Film(2, "FNF19", 2019));
        films.add(new Film(3, "FNF24", 2024));
        Collections.sort(films, new YearComparator());
        films.forEach(System.out::println);
    }
}