package com.rapipay.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapipay.crud.dao.AgentDao;
import com.rapipay.crud.entity.Agent;
@Service
public class AgentServicesImpl implements AgentServices{
	@Autowired
	AgentDao agentDao;
	
	@Override
	public Agent getAgent(int id) {
		return agentDao.findById(id).get();
	}

	@Override
	public Agent insertAgent(Agent agent) {	
		return agentDao.saveAndFlush(agent);
	}

	@Override
	public Object updateAgent(Agent agent, int id) {
		if(agentDao.existsById(id)) {
			Agent oldAgent = agentDao.findById(id).get();
			if(agent.getAccountNumber() != 0)
			{
				oldAgent.setAccountNumber(agent.getAccountNumber());
				
			}
			else
				oldAgent.getAccountNumber();
				
			
			oldAgent.setAgentName(agent.getAgentName() != null ? agent.getAgentName() : oldAgent.getAgentName());
			oldAgent.setAgentState(agent.getAgentState() != null ? agent.getAgentState() : oldAgent.getAgentState());
			oldAgent.setBankName(agent.getBankName() != null ? agent.getBankName() : oldAgent.getBankName());
		    oldAgent.setPhoneNumber(agent.getPhoneNumber() != 0 ? agent.getPhoneNumber() : oldAgent.getPhoneNumber());
		    oldAgent.setWalletBalance(agent.getWalletBalance() != 0 ? agent.getWalletBalance() : oldAgent.getWalletBalance());
		    return agentDao.saveAndFlush(oldAgent);
		}
		return "Agent Not Found";
	}

	@Override
	public String deleteAgent(int id) {
		agentDao.deleteById(id);
		return "Agent Deleted";
	}

	@Override
	public List<Agent> getAllAgent() {
		return agentDao.findAll();
			
	}
	
	
	
	
}
