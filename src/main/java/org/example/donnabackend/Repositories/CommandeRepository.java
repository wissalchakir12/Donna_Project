package org.example.donnabackend.Repositories;

import org.example.donnabackend.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
