package com.rapipay.crud.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.rapipay.crud.entity.Transaction;
import javax.persistence.*;
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}
