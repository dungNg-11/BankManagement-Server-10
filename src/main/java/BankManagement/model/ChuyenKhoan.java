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
public class ChuyenKhoan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String noidungck;
	@ManyToOne(targetEntity = AccountCredit.class)
	@JoinColumn(name ="accountcredit_id")
	private AccountCredit accountCredit;
	private double moneysend;
	private String nguoinhan;
	public String getNguoinhan() {
		return nguoinhan;
	}
	public void setNguoinhan(String nguoinhan) {
		this.nguoinhan = nguoinhan;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoidungck() {
		return noidungck;
	}
	public void setNoidungck(String noidungck) {
		this.noidungck = noidungck;
	}
	public AccountCredit getAccountCredit() {
		return accountCredit;
	}
	public void setAccountCredit(AccountCredit accountCredit) {
		this.accountCredit = accountCredit;
	}
	public double getMoneysend() {
		return moneysend;
	}
	public void setMoneysend(double moneysend) {
		this.moneysend = moneysend;
	}
	
	

}
