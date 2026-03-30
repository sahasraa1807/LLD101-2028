package services;

import models.Show;
import java.util.*;

public class ShowService {

    private List<Show> shows = new ArrayList<>();

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }
}