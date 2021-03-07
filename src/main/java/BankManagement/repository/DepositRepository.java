package BankManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BankManagement.model.AccountDeposit;

@Repository
public interface DepositRepository extends CrudRepository<AccountDeposit, Integer>{

}
