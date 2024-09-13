package federicodipresa.business_travel_managment.Repository;


import federicodipresa.business_travel_managment.Entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
}
