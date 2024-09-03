package org.example.donnabackend.Web;


import org.example.donnabackend.Entities.Commande;
import org.example.donnabackend.Repositories.CommandeRepository;
import org.example.donnabackend.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommandeController
{

    @Autowired
    private CommandeRepository commandeRepository ;
    @Autowired
    private EmailService emailService;

    public void formCommande(@RequestBody Commande commande )
    {
         //Stocker la commande dans la db d'apres le form
        commandeRepository.save(commande);
        emailService.sendSimpleEmail(commande.getMail());





    }


}
