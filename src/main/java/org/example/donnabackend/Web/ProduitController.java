package org.example.donnabackend.Web;

import org.example.donnabackend.Entities.Produit;
import org.example.donnabackend.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    // Récupérer tous les produits
    @GetMapping("/produits")
    public List<Produit> produits() {
        return produitRepository.findAll();
    }

    // Récupérer l'image d'un produit par ID et la renvoyer en base64
    @GetMapping("/produits/{id}/image")
    public ResponseEntity<String> getImage(@PathVariable Long id) {
        try {
            Produit produit = produitRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

            byte[] imageData = produit.getImage();
            if (imageData == null || imageData.length == 0) {
                throw new RuntimeException("Image non trouvée pour ce produit.");
            }

            // Encoder l'image en base64
            String base64Image = Base64.getEncoder().encodeToString(imageData);

            // Retourner l'image encodée en base64
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"image_" + id + ".jpg\"")
                    .body(base64Image);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erreur : " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur : " + e.getMessage());
        }
    }
}
