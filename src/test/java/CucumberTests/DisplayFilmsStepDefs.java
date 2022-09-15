package CucumberTests;

import com.sakilla.api.SakilaApp.ActorRepository;
import com.sakilla.api.SakilaApp.CategoryRepository;
import com.sakilla.api.SakilaApp.FilmRepository;
import com.sakilla.api.SakilaApp.SakilaAppApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

public class DisplayFilmsStepDefs {


    private SakilaAppApplication sakilaAppApplication;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private ActorRepository actorRepository;

    @BeforeEach
    void setup(){

        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        actorRepository = mock(ActorRepository.class);

        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository);
    }

    @Given("the application is running")
    public void the_application_is_running() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("the {string} loads")
    public void the_loads(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("the api connects")
    public void the_api_connects() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("display a list of objects")
    public void display_a_list_of_objects() {
        // Write code here that turns the phrase above into concrete actions

    }
}
