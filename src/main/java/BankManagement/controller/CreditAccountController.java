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

import BankManagement.model.AccountCredit;
import BankManagement.repository.CreditRepository;

@RestController
@RequestMapping(path = "/credits", produces = "application/json")
@CrossOrigin(origins = "*")
public class CreditAccountController {
	private final CreditRepository creditRepository;
	@Autowired
	EntityLinks entityLinks;

	public CreditAccountController(CreditRepository creditRepository) {
		super();
		this.creditRepository = creditRepository;
	}

	@GetMapping("/show-credit-by-id/{id}")
	public AccountCredit creditById(@PathVariable int id) {
		Optional<AccountCredit> optCre = creditRepository.findById(id);
		if (optCre.isPresent()) {
			return optCre.get();
		}
		return null;
	}

	@GetMapping("/show-all-credit")
	public Iterable<AccountCredit> recentCredit() {
		return creditRepository.findAll();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountCredit saveCredit(@RequestBody AccountCredit credit) {
		return creditRepository.save(credit);
	}

	@PutMapping("/edit-credit/{id}")
	public AccountCredit putCredit(@RequestBody AccountCredit credit) {
		return creditRepository.save(credit);
	}

	@DeleteMapping("/delete-credit/{id}")
	public void deleteCredit(@PathVariable("id") int id) {
		try {
			creditRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e){
			e.printStackTrace();
		}
	}
}
