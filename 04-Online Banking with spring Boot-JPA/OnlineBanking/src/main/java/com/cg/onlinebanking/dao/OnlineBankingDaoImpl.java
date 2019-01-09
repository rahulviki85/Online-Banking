package com.cg.onlinebanking.dao;



import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.AccountTransaction;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.exception.InvalidInputException;

@Repository("dao")
@Transactional
public class OnlineBankingDaoImpl implements OnlineBankingDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	//private static final EntityManagerFactory em = Persistence
          //  .createEntityManagerFactory("demoonlinebanking");
	public OnlineBankingDaoImpl() {
		super();
		
	}
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer+" "+entityManager);
		Customer acc= findOne(customer.getAccount().getAccountNumber());
		System.out.println("hiiii"+acc);
		if(acc==null) {
		Account account=customer.getAccount();
		
		//EntityManager manager = em.createEntityManager();
	    //EntityTransaction transaction = null;
	   // transaction = manager.getTransaction();
        //transaction.begin();
        System.out.println(account);
       
       //manager.persist(account);
        entityManager.persist(customer); 
        entityManager.flush();
        System.out.println("done P");
        //transaction.commit();
        System.out.println("done.Commit.......");
        
        //manager.close();
		}else if(customer.getAccount().getAccountNumber().compareTo(acc.getAccount().getAccountNumber())==0)  {
			Account account=customer.getAccount();
			
			/*EntityManager manager = em.createEntityManager();
		    EntityTransaction transaction = null;
		    transaction = manager.getTransaction();
	        transaction.begin();
	        System.out.println("merge "+customer);*/
	        //manager.persist(account.getTransactionDetail());
	        //manager.merge(account);
	        entityManager.merge(customer);   
	        System.out.println("done P merge");
	        //transaction.commit();
	        entityManager.flush();
	        System.out.println("done.merge.......");
	        //manager.close();
		}else {
			throw new InvalidInputException("Check your Inputs");
		}
		return true;
	}

	public Customer findOne(Integer accountNumber) {
		// TODO Auto-generated method stub
		System.out.println(accountNumber+" "+entityManager);
		Customer cust=null;
		/*EntityManager manager = em.createEntityManager();
	    EntityTransaction transaction = null;
	    transaction = manager.getTransaction();
        transaction.begin();*/
		
        Query query=entityManager.createQuery("SELECT b FROM Customer b JOIN b.account a WHERE a.accountNumber=:anumber");
	    query.setParameter("anumber",accountNumber);
	    //System.out.println(query.getSingleResult());
		//System.out.println("Find..."+query.getResultList().get(0));
	    try {
		cust=(Customer) query.getSingleResult();
		System.out.println(cust+" "+entityManager);
	    }catch(NoResultException ex) {
	    	System.out.println("Check your Account Number");
	    }
		return cust;
	}
	public boolean saveTranSaction(AccountTransaction dao) {
		// TODO Auto-generated method stub
		System.out.println(dao);
		if(dao!=null) {
		/*EntityManager manager = em.createEntityManager();
	    EntityTransaction transaction = null;
	    transaction = manager.getTransaction();
        transaction.begin();*/
        System.out.println(dao);
       
       //manager.persist(account);
        entityManager.persist(dao);   
        System.out.println("done P");
        //transaction.commit();
        entityManager.flush();
        System.out.println("done.Commit.......");
        //manager.close();
		}
		return true;
	}
	public List<AccountTransaction> getTrasactionByDate(Date date, Integer account) {
		// TODO Auto-generated method stub
		List<AccountTransaction> all=null;
		if(date!=null && account!=null) {
			System.out.println(date+" "+account);
			/*EntityManager manager = em.createEntityManager();
		    EntityTransaction transaction = null;
		    transaction = manager.getTransaction();
	        transaction.begin();*/
	       Query query= entityManager.createQuery("SELECT at FROM  AccountTransaction at JOIN at.savingsAccount a WHERE a.accountNumber=:account AND at.transactionDate=:date");
	        query.setParameter("account",account);
	        query.setParameter("date",date);
	         all=  query.getResultList();
	         System.out.println(all);
		}
		
		return all;
	}
	
	public List<AccountTransaction> getTrasactionBetweenDate(Date fromDate, Date toDate, Integer account) {
		// TODO Auto-generated method stub
		List<AccountTransaction> all=null;
		if(fromDate!=null && fromDate!=null && account!=null) {
			System.out.println(fromDate+" "+account);
			/*EntityManager manager = em.createEntityManager();
		    EntityTransaction transaction = null;
		    transaction = manager.getTransaction();
	        transaction.begin();*/
	       Query query= entityManager.createQuery("SELECT at FROM  AccountTransaction at JOIN at.savingsAccount a WHERE a.accountNumber=:account AND at.transactionDate BETWEEN :two AND :one");
	       query.setParameter("account",account);
	       System.out.println(fromDate+" "+toDate);
	        query.setParameter("one",fromDate,TemporalType.DATE);
	        query.setParameter("two",toDate,TemporalType.DATE);
	         all=  query.getResultList();
	         System.out.println(all);
		}
		
		return all;
	}
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		Query queryAll=entityManager.createQuery("FROM Customer");
		return queryAll.getResultList();
	}
	

}
