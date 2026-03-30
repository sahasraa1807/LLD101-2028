package models;


public class Show {
    private int showId;
    private Movie movie;
    private Screen screen;
    private long showTime;

    public Show(int showId, Movie movie, Screen screen, long showTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showTime = showTime;
    }

    public int getShowId() {
        return showId;
    }

    public Screen getScreen() {
        return screen;
    }
}