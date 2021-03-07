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

import BankManagement.model.Customer;
import BankManagement.repository.CustomerRepository;

@RestController
@RequestMapping(path = "/customers", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {

	private final CustomerRepository customerRepository;
	
	@Autowired
	EntityLinks entityLinks;

	public CustomerController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@GetMapping("/show-customer-by-id/{id}")
	public Customer customerById(@PathVariable int id) {
		Optional<Customer> optCus = customerRepository.findById(id);
		if (optCus.isPresent()) {
			return optCus.get();
		}
		return null;
	}

	@GetMapping("/show-all-customers")
	public Iterable<Customer> recentTacos() {
		// PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		return customerRepository.findAll();
	}

	// save customer
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping("/edit-customer/{id}")
	public Customer putCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@DeleteMapping("/delete-customer/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
		try {
			customerRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e){
			e.printStackTrace();
		}
	}

}
