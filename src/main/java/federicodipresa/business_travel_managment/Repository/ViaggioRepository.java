package federicodipresa.business_travel_managment.Repository;

import federicodipresa.business_travel_managment.Entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}
