package BankManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BankManagement.model.AccountCredit;

@Repository
public interface CreditRepository extends CrudRepository<AccountCredit, Integer>{

}
