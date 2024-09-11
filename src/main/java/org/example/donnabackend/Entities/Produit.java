package org.example.donnabackend.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produit
{
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Long prix;
    @Lob
    private byte[] image;

}
