package org.example.donnabackend.Repositories;

import org.example.donnabackend.Entities.Commande;
import org.example.donnabackend.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
