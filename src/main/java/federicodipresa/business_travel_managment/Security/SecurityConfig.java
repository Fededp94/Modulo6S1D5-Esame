package federicodipresa.business_travel_managment.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.Security.authentication.AuthenticationManager;
import org.springframework.Security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.Security.config.annotation.web.builders.HttpSecurity;
import org.springframework.Security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.Security.config.http.SessionCreationPolicy;
import org.springframework.Security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.Security.crypto.password.PasswordEncoder;
import org.springframework.Security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
