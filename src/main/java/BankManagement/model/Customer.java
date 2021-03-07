package BankManagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String cmt;
	private Date dateOfBirth;
	private String address;
	
//	@PrePersist
//	void dateOfBirth() {
//		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//		this.dateOfBirth = new Date();
//	}
	
	

}
