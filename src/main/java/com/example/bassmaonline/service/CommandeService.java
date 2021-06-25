package com.example.bassmaonline.service;

import java.util.List;

import com.example.bassmaonline.entity.CommandeEntity;

public interface CommandeService {

	CommandeEntity createCommande(CommandeEntity commandeEntity);

	CommandeEntity getCommandeByOrderId(Long orderId);

	CommandeEntity updateCommande(Long orderId, CommandeEntity commandeEntity);

	void deleteCommande(Long orderId);

	List<CommandeEntity> getCommandes(int page, int limit);

}
