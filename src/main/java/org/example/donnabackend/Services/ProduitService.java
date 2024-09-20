package org.example.donnabackend.Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.example.donnabackend.Entities.Produit;
import org.example.donnabackend.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public void saveProduitWithImage(String nom, Long prix, File imageFile) throws IOException {
        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setPrix(prix);
        produit.setImage(convertImageToBytes(imageFile));
        produitRepository.save(produit);
    }

    private byte[] convertImageToBytes(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        }
    }
}
