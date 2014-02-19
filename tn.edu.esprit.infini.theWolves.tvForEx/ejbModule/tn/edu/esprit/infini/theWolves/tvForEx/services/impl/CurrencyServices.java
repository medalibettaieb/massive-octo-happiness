package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;

/**
 * Session Bean implementation class CurrencyServices
 */
@Stateless
public class CurrencyServices implements CurrencyServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CurrencyServices() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Currency> findAllCurrencies() {
		String jpql = "select c from Currency c";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public boolean addCurrency(Currency currency) {
		boolean b = false;
		try {
			entityManager.persist(currency);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

	@Override
	public boolean addTransaction(Bank bank, Currency currency,
			String typeOfTransaction, int amount, float cotation) {
		boolean b = false;
		try {
			Transaction transaction = new Transaction(typeOfTransaction,
					amount, bank, currency, cotation);
			entityManager.persist(transaction);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

	@Override
	public Bank findBankById(int id) {

		return entityManager.find(Bank.class, id);
	}

	@Override
	public Currency findCurrencyById(int id) {

		return entityManager.find(Currency.class, id);
	}

	@Override
	public boolean createOffer(Bank bank, Currency currency, float cotation) {
		boolean b = false;
		try {
			Transaction transaction = new Transaction(cotation, bank, currency);
			entityManager.persist(transaction);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

	@Override
	public boolean addBank(Bank bank) {
		boolean b = false;
		try {
			entityManager.persist(bank);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

}
