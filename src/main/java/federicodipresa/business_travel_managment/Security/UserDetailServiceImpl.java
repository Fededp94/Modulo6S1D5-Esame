package federicodipresa.business_travel_managment.Security;

import federicodipresa.business_travel_managment.Entities.Dipendente;
import federicodipresa.business_travel_managment.Repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.Security.core.userdetails.UserDetails;
import org.springframework.Security.core.userdetails.UserDetailsService;
import org.springframework.Security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Dipendente dipendente = dipendenteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato con username: " + username));

        return new org.springframework.security.core.userdetails.User(dipendente.getUsername(), dipendente.getPassword(), new ArrayList<>());
    }
}
