package models;

public class Movie {
    private int movieId;
    private String name;

    public Movie(int movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }
}