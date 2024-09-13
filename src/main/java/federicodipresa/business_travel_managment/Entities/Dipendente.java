package federicodipresa.business_travel_managment.Entities;

import jakarta.persistence.*;

@Entity
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String nome;
    private String cognome;
    private String email;
}