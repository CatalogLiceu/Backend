package com.example.catalogliceu.config;

import com.example.catalogliceu.authentication.JwtFiltruAutentificare;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final AuthenticationConfiguration authConfiguration;
    private final JwtFiltruAutentificare jwtFiltruAutentificare;
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.addAllowedOrigin("*");
                    config.addAllowedMethod("*");
                    config.addAllowedHeader("*");
                    return config;
                }))
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/v3/api-docs/**").permitAll()
                        .requestMatchers("/autentificare/**").permitAll()
                        .requestMatchers("administrator_scolar/**").hasRole("ROL_ADMINISTRATOR_PLATFORMA")
                        .requestMatchers("an_clasa/**").hasAnyAuthority("ROL_ADMINISTRATOR_PLATFORMA")
                        .requestMatchers("clasa/**").hasAnyAuthority("ROL_ADMINISTRATOR_SCOLAR", "ROL_PROFESOR", "ROL_ELEV")
                        .requestMatchers("clasa_materie_profesor/").hasAuthority("ROL_ADMINISTRATOR_SCOLAR")
                        .requestMatchers("clasa_materie_profesor/profesor/**").hasAnyAuthority("ROL_ADMINISTRATOR_SCOLAR", "ROL_PROFESOR", "ROL_ELEV")
                        .requestMatchers("clasa_materie_profesor/clasa/**").hasAnyAuthority("ROL_ADMINISTRATOR_SCOLAR", "ROL_PROFESOR", "ROL_ELEV")
                        .requestMatchers("diriginte/**").hasAnyAuthority("ROL_ADMINISTRATOR_SCOLAR")
                        .requestMatchers("elev/clasa/**").hasAnyAuthority("ROL_ADMINISTRATOR_SCOLAR")
                        .requestMatchers("/elev/{id}/note").hasAnyAuthority("ROL_ELEV, ROL_PROFESOR")
                        .requestMatchers("liceu/").hasAnyAuthority("ROL_ADMINISTRATOR_PLATFORMA")
                        .requestMatchers("liceu/{id}/clasa").hasAnyAuthority("ROL_ADMINISTRATOR_SCOLAR")
                        .requestMatchers("liceu/**").hasAnyAuthority("ROL_ADMINISTRATOR_SCOLAR", "ROL_PROFESOR")
                        .requestMatchers("materie/**").hasAuthority("ROL_ADMINISTRATOR_PLATFORMA")
                        .requestMatchers("nota/elev/{id_elev}/materie/{id_materie}").hasAnyAuthority("ROL_ELEV", "ROL_PROFEOSR")
                        .requestMatchers("nota/**").hasAnyAuthority("ROL_PROFESOR")
                        .requestMatchers("permisie_administrator_scolar/**").hasAuthority("ROL_ADMINISTRATOR_PLATFORMA")
                        .requestMatchers("profesor/").hasAuthority("ROL_ADMINISTRATOR_SCOLAR")
                        .requestMatchers(HttpMethod.POST, "/profil/").hasAuthority("ROL_ADMINISTRATOR_PLATFORMA")
                        .requestMatchers(HttpMethod.GET, "/profil/**").permitAll()
                        .requestMatchers("specializare/**").hasAuthority("ROL_ADMINISTRATOR_PLATFORMA")
                        .requestMatchers("utilizator/**").hasAnyAuthority("ROL_ADMINISTRATOR_PLATFORMA", "ROL_ADMINISTRATOR_SCOLAR")
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtFiltruAutentificare, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}