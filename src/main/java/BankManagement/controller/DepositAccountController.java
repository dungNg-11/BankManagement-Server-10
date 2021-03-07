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

import BankManagement.model.AccountDeposit;
import BankManagement.repository.DepositRepository;

@RestController
@RequestMapping(path = "/deposits", produces = "application/json")
@CrossOrigin(origins = "*")
public class DepositAccountController {
	private final DepositRepository depositRepository;

	@Autowired
	EntityLinks entityLinks;


	public DepositAccountController(DepositRepository depositRepository) {
		super();
		this.depositRepository = depositRepository;
	}

	@GetMapping("/show-deposit-by-id/{id}")
	public AccountDeposit depositById(@PathVariable int id) {
		Optional<AccountDeposit> optDep = depositRepository.findById(id);
		if (optDep.isPresent()) {
			return optDep.get();
		}
		return null;
	}

	@GetMapping("/show-all-deposit")
	public Iterable<AccountDeposit> recentDeposit() {
		return depositRepository.findAll();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountDeposit saveDeposit(@RequestBody AccountDeposit deposit) {
		return depositRepository.save(deposit);
	}

	@PutMapping("/edit-deposit/{id}")
	public AccountDeposit putDeposit(@RequestBody AccountDeposit deposit) {
		return depositRepository.save(deposit);
	}

	@DeleteMapping("/delete-deposit/{id}")
	public void deleteDeposit(@PathVariable("id") int id) {
		try {
			depositRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e){
			e.printStackTrace();
		}
	}
}
