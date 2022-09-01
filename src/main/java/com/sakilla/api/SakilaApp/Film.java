package com.sakilla.api.SakilaApp;
import javax.persistence.*;

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

    //constructors
    public Film(int filmID, String title, String description)
    {
        this.filmID = filmID;
        this.title = title;
        this.description = description;
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
}
