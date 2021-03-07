package BankManagement.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class AccountCredit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String idAccount;
	private String typeAccount;
	private double balance;
	private double debt;
	private double hanMucTinDung;
	
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id")
	private User user;
}
