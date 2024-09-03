package org.example.donnabackend.Web;

import org.example.donnabackend.Entities.Produit;
import org.example.donnabackend.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProduitController
{
    @Autowired
    private ProduitRepository produitRepository ;

    @GetMapping("/produits")
    public List<Produit> produits()
    {
        return produitRepository.findAll();
    }
}
