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
	private ActorRepository actorRepository;
	private FilmRepository filmRepository;

	public SakilaAppApplication(ActorRepository actorRepository,
								FilmRepository filmRepository)
	{
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
	}


	public static void main(String[] args)
	{
		SpringApplication.run(SakilaAppApplication.class, args);
	}

	//ACTORS

	@GetMapping("/allActors")
	@ResponseBody
	public Iterable<Actor> getAllActors()
	{
		return actorRepository.findAll();
	}

	@GetMapping("/anActor/{id}")
	@ResponseBody
	public Optional<Actor> getActor(@PathVariable Integer id)
	{
		return actorRepository.findById(id);
	}

	@PostMapping("/addActor")
	@ResponseBody
	public String addActor(@RequestBody Actor actor)
	{
		actorRepository.save(actor);
		return ("Actor added");
	}


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

	@DeleteMapping("/removeActor/{id}")
	@ResponseBody
	public String removeActor(@PathVariable Integer id){
		actorRepository.deleteById(id);
		return("Bye bye actor " + id);
	}
// FILMS

	@GetMapping("/allFilms")
	@ResponseBody
	public Iterable<Film> getAllFilms()
	{
		return filmRepository.findAll();
	}

	@GetMapping("/aFilm/{id}")
	@ResponseBody
	public Optional<Film> getFilm(@PathVariable Integer id)
	{
		return filmRepository.findById(id);
	}


	@DeleteMapping("/removeFilm/{id}")
	@ResponseBody
	public String removeFilm(@PathVariable Integer id)
	{
		filmRepository.deleteById(id);
		return("Film removed " + id);
	}

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

}
