package com.rapipay.crud.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapipay.crud.dao.ClientDao;
import com.rapipay.crud.entity.Client;

@Service
public class ClientServicesImpl implements ClientServices{

	@Autowired
	ClientDao clientDao;
	
	
	
	
	@Override
	public Client getClient(int id) {
		return clientDao.findById(id).get();
	}

	@Override
	public Client insertClient(Client client) {
		return clientDao.saveAndFlush(client);
	}

	@Override
	public Object updateClient(Client client, int id) {
		if(clientDao.existsById(id)) {
			Client oldClient = clientDao.findById(id).get();
			
			oldClient.setClientName(client.getClientName() != null ? client.getClientName() : oldClient.getClientName());
			oldClient.setClientState(client.getClientState() != null ? client.getClientState() : oldClient.getClientState());
			oldClient.setClientPassword(client.getClientPassword() != null ? client.getClientPassword() : oldClient.getClientPassword());
			oldClient.setPhoneNumber(client.getPhoneNumber() != 0 ? client.getPhoneNumber() : oldClient.getPhoneNumber());
			oldClient.setWalletBalance(client.getWalletBalance() != 0 ? client.getWalletBalance() : oldClient.getWalletBalance());
		    return clientDao.saveAndFlush(oldClient);
		}
		return "Client Not Found";
	}

	@Override
	public String deleteClient(int id) {
		clientDao.deleteById(id);
		return "Client Deleted";
	}

	@Override
	public List<Client> getAllClient() {
	return clientDao.findAll();
	}
    
	@Override
	public List<Client> getClientsOfAgents(int id)
	{
		
		List list=clientDao.findAll();
		
		return  (List<Client>) list.stream().filter(client-> ((Client) client).getAgentId()==(id)).collect(Collectors.toList());
	
	
}
}
