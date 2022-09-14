package com.sakilla.api.SakilaApp;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film")
public class Film {
    //attributes
    //define primary key
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmID;
    @Column(name = "title")
    String title;
    @Column(name = "description")
    String description;

    @Column(name = "release_year")
    int year;

    @Column(name = "rental_duration")
    int rentTime;

    @Column(name = "rental_rate")
    double rentRate;

    @Column(name = "length")
    int length;

    @Column(name = "rating")
    String rating;

    //constructors


    public Film(int filmID, String title, String description, int year,
                int rentTime, double rentRate, int length, String rating)
    {
        this.filmID = filmID;
        this.title = title;
        this.description = description;
        this.year = year;
        this.rentTime = rentTime;
        this.rentRate = rentRate;
        this.length = length;
        this.rating = rating;
    }

    public Film(){}

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public double getRentRate() {
        return rentRate;
    }

    public void setRentRate(int rentRate) {
        this.rentRate = rentRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmID == film.filmID && year == film.year && rentTime == film.rentTime && Double.compare(film.rentRate, rentRate) == 0 && length == film.length && Objects.equals(title, film.title) && Objects.equals(description, film.description) && Objects.equals(rating, film.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmID, title, description, year, rentTime, rentRate, length, rating);
    }
}
