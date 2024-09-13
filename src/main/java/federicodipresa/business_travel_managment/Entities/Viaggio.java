package federicodipresa.business_travel_managment.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinazione;
    private LocalDate data;
    private String stato;
}