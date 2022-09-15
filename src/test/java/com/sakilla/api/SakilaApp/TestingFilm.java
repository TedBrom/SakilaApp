package com.sakilla.api.SakilaApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestingFilm {


    SakilaAppApplication sakilaAppApplication;

    @Mock
    CategoryRepository categoryRepository;
    @Mock
    FilmRepository filmRepository;
    @Mock
    ActorRepository actorRepository;


    @BeforeEach
    void setup(){
        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository);
    }

    @Test
    void testGetFilms(){

        List<Film> filmList = new ArrayList<>();

        Film testFilm = new Film (1,"Test Film", "Film Test", 2005,
                6, 0.99, 88, "PG" );
        Film testFilm2 = new Film(2,"Another Film", "Film Another", 2005,
                6, 0.99, 88, "PG" );

        filmList.add(testFilm);
        filmList.add(testFilm2);

        Iterable <Film> filmIterable = filmList;

        when(filmRepository.findAll()).thenReturn(filmIterable);

        Iterable <Film> Expected = filmIterable;
        Iterable <Film> Actual = sakilaAppApplication.getAllFilms();

        Assertions.assertEquals(Expected, Actual, "Get all films broken :(");

    }

    @Test
    void testGetAFilm(){
        when(filmRepository.findById(1)).thenReturn(Optional.of(new Film()));
        Film output = filmRepository.findById(1).get();
        Film expected = new Film();
        Assertions.assertEquals(expected, output, "why nay");

    }

    @Test
    void editFilmTitle(){
        Film film = new Film();
        Assertions.assertEquals(null, film.title);
        when(filmRepository.findById(1)).thenReturn(Optional.of(film));
        Film newTitle = new Film();
        newTitle.setTitle("newTitle");
        ArgumentCaptor<Film> captor = ArgumentCaptor.forClass(Film.class);
        sakilaAppApplication.editFilm(1, newTitle);
        verify(filmRepository).save(newTitle);
    }

    @Test
    void getFilmID(){
        Film film = new Film();
        film.setFilmID(1);
        Assertions.assertEquals(1, film.getFilmID(), "Wrong film ID");
    }
    @Test
    void getFilmTitle(){
        Film film = new Film();
        film.setTitle("Test tite");
        Assertions.assertEquals("Test tite", film.getTitle(), "Wrong film title");
    }
    @Test
    void getFilmDesc(){
        Film film = new Film();
        film.setDescription("Test desc");
        Assertions.assertEquals("Test desc", film.getDescription(), "Wrong film desc");
    }
    @Test
    void getFilmRelease(){
        Film film = new Film();
        film.setYear(2004);
        Assertions.assertEquals(2004, film.getYear(), "Wrong film year");
    }

    @Test
    void getRentTime(){
        Film film = new Film();
        film.setRentTime(10);
        Assertions.assertEquals(10, film.getRentTime(), "Wrong rent time");
    }

    @Test
    void getRentRate(){
        Film film = new Film();
        film.setRentRate(10);
        Assertions.assertEquals(10, film.getRentRate(), "Wrong rent rate");
    }

    @Test
    void getFilmDuration(){
        Film film = new Film();
        film.setLength(29);
        Assertions.assertEquals(29, film.getLength(),"Wrong film duration");
    }

    @Test
    void getFilmRating(){
        Film film = new Film();
        film.setRating("PG");
        Assertions.assertEquals("PG", film.getRating(), "Wrong film rating");
    }


}
