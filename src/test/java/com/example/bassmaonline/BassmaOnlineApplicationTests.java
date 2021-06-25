package com.example.bassmaonline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.bassmaonline.Reposotory.CommandeReposotory;
import com.example.bassmaonline.entity.CommandeEntity;
import com.example.bassmaonline.service.CommandeServiceImp;

@SpringBootTest
@AutoConfigureTestDatabase
class BassmaOnlineApplicationTests {

    @Autowired
    private CommandeServiceImp commandeService;
    @MockBean
    private CommandeReposotory commandeReposotory;
    
    @Test
    public void saveCommandesTest() {
    	CommandeEntity commande = new CommandeEntity("19","10","10","10","10");
    	when(commandeReposotory.save(commande)).thenReturn(commande);
    	assertEquals(commande, commandeService.createCommande(commande));
    }
    
    @Test
    public void getCommandeTest() {
    	CommandeEntity commande = new CommandeEntity("19","10","10","10","10");
    	commandeService.getCommandeByOrderId(0L);
    	verify(commandeReposotory, times(1)).findByOrderId(0L);
    }
    
}
