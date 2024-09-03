package org.example.donnabackend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Produit
{
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Long prix;
    private String description;
    private String image;

}
