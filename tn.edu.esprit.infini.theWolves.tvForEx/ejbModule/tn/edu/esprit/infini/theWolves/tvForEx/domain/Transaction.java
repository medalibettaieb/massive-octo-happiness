package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Transaction
 * 
 */
@Entity
public class Transaction implements Serializable {

	private TransactionPk transactionPk;
	private String type;
	private int amount;
	private float cotation;
	private static final long serialVersionUID = 1L;

	private Bank bank;
	private Currency currency;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@EmbeddedId
	public TransactionPk getTransactionPk() {
		return transactionPk;
	}

	public void setTransactionPk(TransactionPk transactionPk) {
		this.transactionPk = transactionPk;
	}

	@ManyToOne
	@JoinColumn(name = "idBk", referencedColumnName = "id", updatable = false, insertable = false)
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@ManyToOne
	@JoinColumn(name = "idCu", referencedColumnName = "id", updatable = false, insertable = false)
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Transaction(String type, int amount, Bank bank, Currency currency) {
		super();
		this.type = type;
		this.amount = amount;
		this.bank = bank;
		this.currency = currency;
		this.transactionPk = new TransactionPk(bank.getId(), currency.getId());
	}

	public float getCotation() {
		return cotation;
	}

	public void setCotation(float cotation) {
		this.cotation = cotation;
	}

	public Transaction(float cotation, Bank bank, Currency currency) {
		super();
		this.transactionPk = new TransactionPk(bank.getId(), currency.getId());
		this.type = "bid";
		this.cotation = cotation;
		this.bank = bank;
		this.currency = currency;
	}

	public Transaction(String type, int amount, Bank bank, Currency currency,
			float cotation) {
		super();
		this.type = type;
		this.amount = amount;
		this.cotation = cotation;
		this.bank = bank;
		this.currency = currency;
		this.transactionPk = new TransactionPk(bank.getId(), currency.getId());
	}

}
