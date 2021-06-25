package com.example.bassmaonline.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bassmaonline.entity.CommandeEntity;
import com.example.bassmaonline.service.CommandeService;

@RestController
@RequestMapping("/Commande")
public class CommandeController {

	@Autowired
	CommandeService commandeService;

	@GetMapping("/{orderId}")
	public ResponseEntity<CommandeEntity> getCommandeById(@PathVariable Long orderId) {
		CommandeEntity commande = commandeService.getCommandeByOrderId(orderId);

		return new ResponseEntity<CommandeEntity>(commande, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CommandeEntity>> getAllCommandeByOrder(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit) {
		List<CommandeEntity> commande = commandeService.getCommandes(page, limit);
		return new ResponseEntity<List<CommandeEntity>>(commande, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CommandeEntity> createCommandeById(@RequestBody CommandeEntity commandeEntity) {
		CommandeEntity commandeEntity1 = commandeService.createCommande(commandeEntity);
		return new ResponseEntity<>(commandeEntity1, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{orderId}")
	public ResponseEntity<CommandeEntity> updateCommandeById(@RequestBody CommandeEntity commandeEntity,
			@PathVariable Long orderId) {
		CommandeEntity commande = commandeService.updateCommande(orderId, commandeEntity);
		return new ResponseEntity<CommandeEntity>(commande, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/Remove/{OrderId}")
	public ResponseEntity<CommandeEntity> removeCommandeById(@PathVariable Long orderId) {
		commandeService.deleteCommande(orderId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
