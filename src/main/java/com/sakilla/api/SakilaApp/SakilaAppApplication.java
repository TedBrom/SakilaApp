package com.sakilla.api.SakilaApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
@CrossOrigin
public class SakilaAppApplication {


	@Autowired

	//create objects
	private ActorRepository actorRepository;
	private FilmRepository filmRepository;
	private CategoryRepository categoryRepository;

	//constructor
	public SakilaAppApplication(ActorRepository actorRepository,
								FilmRepository filmRepository, CategoryRepository categoryRepository)
	{
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.categoryRepository = categoryRepository;
	}


	//main function (runs the app)
	public static void main(String[] args)
	{
		SpringApplication.run(SakilaAppApplication.class, args);
	}

	//All mapping functionality
	//ACTORS
	@GetMapping("/allActors")
	@ResponseBody
	public Iterable<Actor> getAllActors()
	{
		return actorRepository.findAll();
	}
	//Get one actor based on passed ID

	@GetMapping("/anActor/{id}")
	@ResponseBody
	public Optional<Actor> getActor(@PathVariable Integer id)
	{
		return actorRepository.findById(id);
	}

	//Add an actor to the database
	@PostMapping("/addActor")
	@ResponseBody
	public String addActor(@RequestBody Actor actor)
	{
		actorRepository.save(actor);
		return ("Actor added");
	}

	//Edit the information of an actor selected by the ID passed
	@PutMapping("/editActor/{id}")
	@ResponseBody
	public String editActor(@PathVariable Integer id, @RequestBody Actor newAct)
	{
		final Actor actor = actorRepository.findById(id).get();
		actor.setFirstName(newAct.firstName);
		actor.setLastName(newAct.lastName);
		actorRepository.save(actor);

		return("Actor Edited");
	}

	//Remove an actor based on the ID passed to it
	@DeleteMapping("/removeActor/{id}")
	@ResponseBody
	public String removeActor(@PathVariable Integer id){
		actorRepository.deleteById(id);
		return("Bye bye actor " + id);
	}

	//Find an actor by their names
	@GetMapping("/findActByName")
	@ResponseBody
	public Iterable<Actor> getActByName(String firstName, String lastName)
	{
		return actorRepository.searchByFirstLastName(firstName, lastName);
	}


// FILMS

	//Get all the films
	@GetMapping("/allFilms")
	@ResponseBody
	public Iterable<Film> getAllFilms()
	{
		return filmRepository.findAll();
	}

	//Get the films based on the film's ID
	@GetMapping("/aFilm/{id}")
	@ResponseBody
	public Optional<Film> getFilm(@PathVariable Integer id)
	{
		return filmRepository.findById(id);
	}


	//Remove a film based on the passed ID
	@DeleteMapping("/removeFilm/{id}")
	@ResponseBody
	public String removeFilm(@PathVariable Integer id)
	{
		filmRepository.deleteById(id);
		return("Film removed " + id);
	}

	//Edit a film based on the ID passed
	@PutMapping("/editFilm/{id}")
	@ResponseBody
	public String editFilm(@PathVariable Integer id, @RequestBody Film newFilm)
	{
		final Film film = filmRepository.findById(id).get();
		film.setTitle(newFilm.title);
		film.setDescription(newFilm.description);
		filmRepository.save(film);
		return ("film edited");
	}

	//Category Methods

	@GetMapping("/allCategory")
	@ResponseBody
	public Iterable<Category> getAllCategory()
	{
		return categoryRepository.findAll();
	}
	@GetMapping("/aCategory/{id}")
	@ResponseBody
	public Optional<Category> getCategory(@PathVariable Integer id) {
		return categoryRepository.findById(id);
	}

	@DeleteMapping("/removeCategory/{id}")
	@ResponseBody
	public String removeCategory(@PathVariable Integer id)
	{
		categoryRepository.deleteById(id);
		return("Category removed " + id);
	}

	@PutMapping("/editCategory/{id}")
	@ResponseBody
	public String editCategory(@PathVariable Integer id, @RequestBody Category newCat)
	{
		final Category category = categoryRepository.findById(id).get();
		category.setCatName(newCat.catName);
		categoryRepository.save(category);
		return ("Category edited");
	}


}
