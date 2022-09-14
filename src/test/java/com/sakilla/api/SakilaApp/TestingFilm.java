package com.sakilla.api.SakilaApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


}
