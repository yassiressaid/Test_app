package com.example.bassmaonline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bassmaonline.Reposotory.CommandeReposotory;
import com.example.bassmaonline.entity.CommandeEntity;

@Service
public class CommandeServiceImp implements CommandeService {
	@Autowired
	CommandeReposotory commandeReposotory;

	@Override
	public CommandeEntity createCommande(CommandeEntity commandeEntity) {
		return commandeReposotory.save(commandeEntity);
	}

	@Override
	public CommandeEntity getCommandeByOrderId(Long orderId) {
		return commandeReposotory.findByOrderId(orderId);
	}

	@Override
	public CommandeEntity updateCommande(Long orderId, CommandeEntity commandeEntity) {

		CommandeEntity commande = commandeReposotory.findByOrderId(orderId);

		commande.setAdresse(commandeEntity.getAdresse());
		commande.setCodePostal(commandeEntity.getCodePostal());

		return commandeReposotory.save(commande);
	};

	@Override
	public void deleteCommande(Long orderId) {
		try {
			CommandeEntity commandeEntity = commandeReposotory.findByOrderId(orderId);
			commandeReposotory.delete(commandeEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<CommandeEntity> getCommandes(int page, int limit) {
		if (page > 0)
			page -= 1;
		List<CommandeEntity> commandelist = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<CommandeEntity> userPage = commandeReposotory.findAll(pageableRequest);
		List<CommandeEntity> users = userPage.getContent();

		for (CommandeEntity userEntity : users) {
			CommandeEntity user = new CommandeEntity();
			BeanUtils.copyProperties(userEntity, user);
			commandelist.add(user);
		}

		return commandelist;
	}

}
