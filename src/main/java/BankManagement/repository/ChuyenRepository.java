package BankManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BankManagement.model.ChuyenKhoan;

@Repository
public interface ChuyenRepository extends JpaRepository<ChuyenKhoan, Integer> {

}
