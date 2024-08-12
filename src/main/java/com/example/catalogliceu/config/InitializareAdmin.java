package com.example.catalogliceu.config;
import com.example.catalogliceu.entities.AdministratorPlatforma;
import com.example.catalogliceu.service.AdministratorPlatformaService;
import io.micrometer.common.lang.NonNull;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitializareAdmin implements ApplicationListener<ContextRefreshedEvent> {

    private Boolean initializareCompletata = false;
    private final AdministratorPlatformaService adminPlatformaService;
    private final PasswordEncoder passwordEncoder;

    public InitializareAdmin(AdministratorPlatformaService adminPlatformaService, PasswordEncoder passwordEncoder) {
        this.adminPlatformaService = adminPlatformaService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        if (initializareCompletata) {
            return;
        }
        if (adminPlatformaService.nrAdministratoriPlatforma() == 0) {
            adminPlatformaService.adaugaAdministratorPlatforma(AdministratorPlatforma.builder()
                    .nume("admin")
                    .email("admin")
                    .prenume("admin")
                    .porecla("admin")
                    .parola("admin")
                    .build());
        }

        initializareCompletata = Boolean.TRUE;
    }
}