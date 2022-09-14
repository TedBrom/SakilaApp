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


public class DisplayAFilmStepDef {


    private SakilaAppApplication sakilaAppApplication;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private ActorRepository actorRepository;


     public DisplayAFilmStepDef(){

        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        actorRepository = mock(ActorRepository.class);

        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository);
    }

    Film testFilm;
    Film expected;
    @Given("there is an ID")
    public void there_is_an_id() {
        int id = 1;
        expected = new Film();
        expected.setFilmID(1);
        expected.setTitle("test title");
        expected.setDescription("Spooky test desc");
    }

    @When("the api is connected")
    public void the_api_is_connected() {
       when(filmRepository.findById(1)).thenReturn(Optional.of(expected));
        testFilm = filmRepository.findById(1).get();
    }

    @Then("display a single film")
    public void display_a_single_film() {
        Assertions.assertEquals(expected, testFilm, "oopsie doopsie");
    }

}
