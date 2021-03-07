package BankManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BankManagement.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
