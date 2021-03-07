package BankManagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import BankManagement.model.User;
import BankManagement.repository.UserRepository;

@RestController
@RequestMapping(path = "/users", produces = "application/json")
@CrossOrigin(origins = "*")
public class UserController {
	
	private final UserRepository userRepository;
	@Autowired
	EntityLinks entityLinks;

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping("/show-user-by-id/{id}")
	public User userById(@PathVariable int id) {
		Optional<User> optUser = userRepository.findById(id);
		if (optUser.isPresent()) {
			return optUser.get();
		}
		return null;
	}

	@GetMapping("/show-all-user")
	public Iterable<User> showAllUser() {
		return userRepository.findAll();
	}

	// save user
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/edit-user/{id}")
	public User putUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		try {
			userRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e){
			e.printStackTrace();
		}
	}

}
