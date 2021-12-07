package com.rapipay.crud.controller;




	import java.util.ArrayList;
import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rapipay.crud.entity.Agent;
	import com.rapipay.crud.services.AgentServices;


	@RestController
	@Component
	public class AgentController {
		
		@Autowired
		AgentServices service;
		
		@Autowired
		RestTemplate restTemplate;
		
		@GetMapping("/agent/{id}")
		public Agent getAgent(@PathVariable int id) {
			Agent agent=this.service.getAgent(id);
			ArrayList client=this.restTemplate.getForObject("http://client-service/client/agent/"+agent.getAgentId(),ArrayList.class);
			agent.setClient(client);
			return service.getAgent(id);
		}
		
		@GetMapping("/agent/all")
		public List<Agent> getAllAgent() {
			return service.getAllAgent();
		}
		
		@PostMapping("/agent/insert")
		public Agent insertAgent(@RequestBody Agent agent) {
			return service.insertAgent(agent);
		}
		
		@PutMapping("/agent/update/{id}")
		public Object updateAgent(@RequestBody Agent agent, @PathVariable int id) {
			return service.updateAgent(agent, id);
		}
		
		@DeleteMapping("/agent/delete/{id}")
		public String deleteAgent(@PathVariable int id) {
			return service.deleteAgent(id);
		}
	}

