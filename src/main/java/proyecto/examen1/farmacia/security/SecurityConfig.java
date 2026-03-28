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
                        .requestMatchers("/", "/css/**", "/images/**").permitAll()
                        .anyRequest().authenticated()
                ).formLogin(customizer -> customizer
                        .loginPage("/")
                        .loginProcessingUrl("/login")
                        .permitAll()
                        .defaultSuccessUrl("/presentation/documentos/show")
                ).logout(customizer -> customizer
                        .permitAll()
                        .logoutSuccessUrl("/")
                ).csrf(customizer -> customizer.disable());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}
