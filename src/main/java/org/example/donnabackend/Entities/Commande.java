package org.example.donnabackend.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class Commande
{
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Produit> produits ;
    private String nomComplet;
    private Long telephone;
    private String Adresse;
    private Long PrixTotal;
    private String mail;

}
