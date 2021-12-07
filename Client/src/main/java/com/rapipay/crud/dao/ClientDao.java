package com.rapipay.crud.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.rapipay.crud.entity.Client;
import javax.persistence.*;
public interface ClientDao extends JpaRepository<Client,Integer>
{
	
}
