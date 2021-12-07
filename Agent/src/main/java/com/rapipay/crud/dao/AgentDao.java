package com.rapipay.crud.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rapipay.crud.entity.Agent;

import javax.persistence.*;
@Repository
public interface AgentDao extends JpaRepository<Agent, Integer>{ 
	
	
}





