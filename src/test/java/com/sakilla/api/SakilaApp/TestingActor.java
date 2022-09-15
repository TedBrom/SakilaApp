package com.sakilla.api.SakilaApp;

import io.cucumber.java.en_old.Ac;
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

    @Test
    void testGetAnActor(){
        when(actorRepository.findById(1)).thenReturn(Optional.of(new Actor()));
        Actor output = actorRepository.findById(1).get();
        Actor expected = new Actor();
        Assertions.assertEquals(expected, output, "why nay");
    }

    @Test
    void editActorName(){
        Actor actor = new Actor();
        Assertions.assertEquals(null, actor.firstName);
        when(actorRepository.findById(1)).thenReturn(Optional.of(actor));
        Actor newAct = new Actor();
        newAct.setFirstName("newActName");
        ArgumentCaptor<Category> captor = ArgumentCaptor.forClass(Category.class);
        sakilaAppApplication.editActor(1, newAct);
        verify(actorRepository).save(newAct);
    }

    @Test
    void getActorID(){
       Actor actor = new Actor();
       actor.setActorId(2);
       Assertions.assertEquals(2, actor.getActorId(), "Wrong actor ID");
    }

    @Test
    void getActorFirstName(){
        Actor actor = new Actor();
        actor.setFirstName("Kiyrean");
        Assertions.assertEquals("Kiyrean", actor.getFirstName(), "Wrong actor name");
    }
    @Test
    void getActorLastName(){
        Actor actor = new Actor();
        actor.setLastName("Dyer-Allen");
        Assertions.assertEquals("Dyer-Allen", actor.getLastName(), "Wrong actor surname");
    }

    @Test
    void DeleteActorById(){
        Actor actor = new Actor();
        actor.setFirstName("Kiyrean");
        actor.setLastName("Matej");
        actor.setActorId(3);
        sakilaAppApplication.removeActor(actor.getActorId());
        verify(actorRepository).deleteById(actor.getActorId());
    }

    @Test
    public void testEquals_Symmetric() {
        Actor x = new Actor();  // equals and hashCode check name field value
        Actor y = new Actor();
        x.setFirstName("yes");
        y.setFirstName("yes");
        Assertions.assertTrue(x.equals(y) && y.equals(x));
        Assertions.assertTrue(x.hashCode() == y.hashCode());
    }
}
