package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Rol;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.repositories.UtilizatorRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DetaliiUtilizatorService implements UserDetailsService {

    private final ProfesorService profesorService;
    private final ElevService elevService;
    private final AdministratorScolarService administratorScolarService;
    private final AdministratorPlatformaService administratorPlatformaService;
    private final UtilizatorRepository utilizatorRepository;

    public DetaliiUtilizatorService(ProfesorService profesorService,
                                    ElevService elevService,
                                    AdministratorScolarService administratorScolarService,
                                    AdministratorPlatformaService administratorPlatformaService,
                                    UtilizatorRepository utilizatorRepository) {
        this.profesorService = profesorService;
        this.elevService = elevService;
        this.administratorScolarService = administratorScolarService;
        this.administratorPlatformaService = administratorPlatformaService;
        this.utilizatorRepository = utilizatorRepository;
    }
    private Set<GrantedAuthority> extrageRoluriUtilizator(Utilizator utilizator) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (administratorScolarService.esteAdministratorScolar(utilizator)) {
            authorities.add(new SimpleGrantedAuthority(Rol.ROL_ADMINISTRATOR_SCOLAR.toString()));
        }
        if(administratorPlatformaService.esteAdministratorPlatforma(utilizator)) {
            authorities.add(new SimpleGrantedAuthority(Rol.ROL_ADMINISTRATOR_PLATFORMA.toString()));
        }
        if (profesorService.esteProfesor(utilizator)) {
            authorities.add(new SimpleGrantedAuthority(Rol.ROL_PROFESOR.toString()));
        }
        if (elevService.esteElev(utilizator)) {
            authorities.add(new SimpleGrantedAuthority(Rol.ROL_ELEV.toString()));
        }
        return authorities;
    }
    @Override
    public UserDetails loadUserByUsername(String porecla) throws UsernameNotFoundException {
        Utilizator user = utilizatorRepository.findByPorecla(porecla)
                .orElseThrow(() -> new UsernameNotFoundException("Nu a fost gasit utilizator cu porecla: " + porecla));
        Set<GrantedAuthority> authorities = extrageRoluriUtilizator(user);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}