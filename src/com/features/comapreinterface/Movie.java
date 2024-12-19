package com.features.comapreinterface;

public class Movie implements Comparable<Movie> {
    int id;
    String name;
    int releaseYear;

    @Override
    public int compareTo(Movie o) {
        return o.releaseYear - this.releaseYear;
    }

    public Movie(int id, String name, int releaseYear) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
