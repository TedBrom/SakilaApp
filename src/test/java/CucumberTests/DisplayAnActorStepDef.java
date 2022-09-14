package CucumberTests;

import com.sakilla.api.SakilaApp.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DisplayAnActorStepDef {


    private SakilaAppApplication sakilaAppApplication;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private ActorRepository actorRepository;


    public DisplayAnActorStepDef(){

        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        actorRepository = mock(ActorRepository.class);

        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository);
    }

    Actor testActor;
    Actor expected;
    @Given("there is an Actor ID")
    public void there_is_an_id() {
        int id = 1;
        expected = new Actor();
        expected.setActorId(1);
        expected.setFirstName("test name");
        expected.setLastName("Spooky test last name");
    }

    @When("the api connects to actor")
    public void the_api_is_connected() {
        when(actorRepository.findById(1)).thenReturn(Optional.of(expected));
        testActor = actorRepository.findById(1).get();
    }

    @Then("display an actor")
    public void display_a_single_film() {
        Assertions.assertEquals(expected, testActor, "oopsie doopsie");
    }

}
