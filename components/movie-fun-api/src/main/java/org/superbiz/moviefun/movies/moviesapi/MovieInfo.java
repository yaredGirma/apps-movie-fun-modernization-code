package org.superbiz.moviefun.movies.moviesapi;


import java.util.Objects;

public class MovieInfo {
    private String director;
    private String title;
    private int year;
    private String genre;
    private int rating;

    public MovieInfo() {

    }

    public MovieInfo(String director, String title, String genre, int year, int rating) {
        this.director = director;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public MovieInfo(String director, String title, int year) {
        this.director = director;
        this.title = title;
        this.year = year;
    }


    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieInfo)) return false;
        MovieInfo movieInfo = (MovieInfo) o;
        return getYear() == movieInfo.getYear() &&
                getRating() == movieInfo.getRating() &&
                getId() == movieInfo.getId() &&
                Objects.equals(getDirector(), movieInfo.getDirector()) &&
                Objects.equals(getTitle(), movieInfo.getTitle()) &&
                Objects.equals(getGenre(), movieInfo.getGenre());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDirector(), getTitle(), getYear(), getGenre(), getRating(), getId());
    }
}
