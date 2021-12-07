package com.rapipay.crud.services;

import java.util.List;

import com.rapipay.crud.entity.Client;


public interface ClientServices {
	public Client getClient(int id);
	
	public List<Client> getAllClient();

	public Client insertClient(Client client);

	public Object updateClient(Client client, int id);

	public String deleteClient(int id);
	
	public List<Client> getClientsOfAgents(int id);
	
	
}
