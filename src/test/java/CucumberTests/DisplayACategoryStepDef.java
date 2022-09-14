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

public class DisplayACategoryStepDef {

    private SakilaAppApplication sakilaAppApplication;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private ActorRepository actorRepository;


    public DisplayACategoryStepDef(){

        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        actorRepository = mock(ActorRepository.class);

        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository);
    }

    Category testCategory;
    Category expected;
    @Given("there is a category ID")
    public void there_is_an_id() {
        int id = 1;
        expected = new Category();
        expected.setCategoryId(1);
        expected.setCatName("test title");
    }

    @When("the api gets the category")
    public void the_api_is_connected() {
        when(categoryRepository.findById(1)).thenReturn(Optional.of(expected));
        testCategory = categoryRepository.findById(1).get();
    }

    @Then("display a category")
    public void display_a_single_film() {
        Assertions.assertEquals(expected, testCategory, "oopsie doopsie");
    }

}

