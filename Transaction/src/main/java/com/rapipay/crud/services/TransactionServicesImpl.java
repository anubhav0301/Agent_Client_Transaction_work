package com.rapipay.crud.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapipay.crud.dao.TransactionDao;

import com.rapipay.crud.entity.Transaction;
@Service
public class TransactionServicesImpl implements TransactionServices {
	@Autowired
	TransactionDao transactionDao; 

	

	

	@Override
	public Transaction getTransaction(int id) {
		return transactionDao.findById(id).get();
	}

	@Override
	public Transaction insertTransaction(Transaction tx) {
		return transactionDao.saveAndFlush(tx);
	}

	@Override
	public Object updateTransaction(Transaction tx, int id) {
		if(transactionDao.existsById(id)) {
			Transaction oldTx = transactionDao.findById(id).get();
			
			oldTx.setAgentId(tx.getAgentId() != 0 ? tx.getAgentId() : oldTx.getAgentId());
			oldTx.setClientId(tx.getClientId() != 0 ? tx.getClientId() : oldTx.getClientId());
			oldTx.setAmount(tx.getAmount() != 0 ? tx.getAmount() : oldTx.getAmount());
			oldTx.settType(tx.gettType() != null ? tx.gettType() : oldTx.gettType());
			oldTx.settDate(tx.gettDate() != null ? tx.gettDate() : oldTx.gettDate());
		    return transactionDao.saveAndFlush(oldTx);
		}
		return "Transaction Not Found";
	}

	@Override
	public String deleteTransaction(int id) {
		transactionDao.deleteById(id);
		return "Transaction Deleted";
	}


	@Override
	public List<Transaction> getAllTransaction() {
		return transactionDao.findAll();
	}
	
	List<Transaction> list ;

    @Override
	public List<Transaction> getTransactionOfAgent(int agentId) {
		return list.stream().filter(tx->tx.getAgentId()==(agentId)).collect(Collectors.toList());
	
	}
    
    @Override
	public String fundTransfer(Transaction transaction) {
		LocalDate currentDate = LocalDate.now();
		
		transaction.settDate(currentDate);
		this.transactionDao.save(transaction);
		
		
		return "Transaction complited successfully";
	}



	

}
