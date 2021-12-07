package com.rapipay.crud.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;



@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;
	private String clientName;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}private String clientPassword;
	public int getClientId() {
		return clientId;
	}
	@NaturalId
	private int agentId;

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public String getClientState() {
		return clientState;
	}

	public void setClientState(String clientState) {
		this.clientState = clientState;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private String clientState;
	private double walletBalance;
	private long phoneNumber;
	public Client(int clientId, String clientName, String clientPassword, int agentId, String clientState,
			double walletBalance, long phoneNumber) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientPassword = clientPassword;
		this.agentId = agentId;
		this.clientState = clientState;
		this.walletBalance = walletBalance;
		this.phoneNumber = phoneNumber;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
}