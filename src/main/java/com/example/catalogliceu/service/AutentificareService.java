package com.example.catalogliceu.service;

import com.example.catalogliceu.authentication.JwtUtil;
import com.example.catalogliceu.dto.CerereAutentificare;
import com.example.catalogliceu.dto.RaspunsAutentificare;
import com.example.catalogliceu.repositories.UtilizatorRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AutentificareService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UtilizatorRepository utilizatorRepository;
    private final DetaliiUtilizatorService detaliiUtilizatorService;
    public AutentificareService(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UtilizatorRepository utilizatorRepository, DetaliiUtilizatorService detaliiUtilizatorService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.utilizatorRepository = utilizatorRepository;
        this.detaliiUtilizatorService = detaliiUtilizatorService;
    }
    public RaspunsAutentificare login(CerereAutentificare cerereAutentificare) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        cerereAutentificare.getPorecla(),
                        cerereAutentificare.getParola()
                )
        );
        var user = utilizatorRepository.findByPorecla(cerereAutentificare.getPorecla()).orElseThrow();
        Set<GrantedAuthority> roluri = detaliiUtilizatorService.extrageRoluriUtilizator(user);
        String jwtToken = jwtUtil.genereazaToken(user.getPorecla(), roluri);
        return RaspunsAutentificare
                .builder()
                .token(jwtToken)
                .build();
    }
}
