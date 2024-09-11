package org.example.donnabackend.Web;

import org.example.donnabackend.Entities.Produit;
import org.example.donnabackend.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.net.URLConnection;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/produits")
    public List<Produit> produits() {
        return produitRepository.findAll();
    }

    // New API endpoint to retrieve image by product ID
    @GetMapping("/produits/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        try {
            // Fetch the product from the repository
            Produit produit = produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));

            // Assuming the image is stored as a BLOB in the "image" field of Produit
            byte[] imageData = produit.getImage(); // Make sure there is a getter for the image field

            // Dynamically determine the content type of the image
            String contentType = getContentType(imageData);

            // Return the image data as a response with appropriate headers
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"image_" + id + "\"")
                    .body(imageData);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Helper method to determine the content type of the image
    private String getContentType(byte[] imageData) {
        try {
            // Use URLConnection to guess the content type from the image byte array
            ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
            String contentType = URLConnection.guessContentTypeFromStream(bais);

            // Default to 'application/octet-stream' if content type is not detected
            return contentType != null ? contentType : "application/octet-stream";
        } catch (Exception e) {
            return "application/octet-stream"; // Fallback content type
        }
    }
}
