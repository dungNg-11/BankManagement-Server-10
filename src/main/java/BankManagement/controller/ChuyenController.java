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

import BankManagement.model.ChuyenKhoan;
import BankManagement.repository.ChuyenRepository;

@RestController
@RequestMapping(path = "/chuyenkhoans", produces = "application/json")
@CrossOrigin(origins = "*")
public class ChuyenController {
	private final ChuyenRepository chuyenRepository;
	@Autowired
	EntityLinks entityLinks;
	public ChuyenController(ChuyenRepository chuyenRepository) {
		super();
		this.chuyenRepository = chuyenRepository;
	}
	@GetMapping("/show-chuyenkhoan-by-id/{id}")
	public ChuyenKhoan ChuyenById(@PathVariable int id) {
		Optional<ChuyenKhoan> optChuyen = chuyenRepository.findById(id);
		if (optChuyen.isPresent()) {
			return optChuyen.get();
		}
		return null;
	}
	@GetMapping("/show-all-chuyenkhoan")
	public Iterable<ChuyenKhoan> recentChuyenKhoan() {
		return chuyenRepository.findAll();
	}
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ChuyenKhoan saveCredit(@RequestBody ChuyenKhoan chuyenkhoan) {
		return chuyenRepository.save(chuyenkhoan);
	}
	@PutMapping("/edit-chuyenkhoan/{id}")
	public ChuyenKhoan putChuyenKhoan(@RequestBody ChuyenKhoan chuyenkhoan) {
		return chuyenRepository.save(chuyenkhoan);
	}
	
	@DeleteMapping("/delete-chuyenkhoan/{id}")
	public void deleteChuyenKhoan(@PathVariable("id") int id) {
		try {
			chuyenRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e){
			e.printStackTrace();
		}
	}

}
