package com.rapipay.crud.services;

import java.util.List;

import com.rapipay.crud.entity.Transaction;

public interface TransactionServices {
	
    public Transaction getTransaction(int id);
    
    public List<Transaction> getAllTransaction();
	
	public Transaction insertTransaction(Transaction tx);
	
	public Object updateTransaction(Transaction tx, int id);
	
	public String deleteTransaction(int id);
	
	public List<Transaction> getTransactionOfAgent(int agentId);

	String fundTransfer(Transaction transaction);
}
