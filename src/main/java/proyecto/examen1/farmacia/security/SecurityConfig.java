package proyecto.examen1.farmacia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(customizer -> customizer
                        .requestMatchers("/login", "/css/**", "/images/**").permitAll()
                        .anyRequest().authenticated()
                ).formLogin(customizer -> customizer
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/presentation/plan/show")
                ).logout(customizer -> customizer
                        .permitAll()
                        .logoutSuccessUrl("/login")
                ).csrf(customizer -> customizer.disable());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}
