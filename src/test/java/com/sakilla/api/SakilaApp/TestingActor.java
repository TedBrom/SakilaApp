package com.sakilla.api.SakilaApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestingActor {

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
    void testAllAct(){

        List <Actor> actorList = new ArrayList<>();

        Actor testActor = new Actor(1, "Jeff", "Bezos");
        Actor anotherActor = new Actor(2, "Abu", "Star Wars");

        actorList.add(testActor);
        actorList.add(anotherActor);

        Iterable <Actor> actorIterable = actorList;

        when(actorRepository.findAll()).thenReturn(actorIterable);

        Iterable <Actor> Expected = actorIterable;
        Iterable <Actor> Actual = sakilaAppApplication.getAllActors();

        Assertions.assertEquals(Expected, Actual , "Get all actors is broken");

    }
}
