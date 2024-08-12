package com.example.catalogliceu.service;

import com.example.catalogliceu.authentication.JwtUtil;
import com.example.catalogliceu.dto.CerereAutentificare;
import com.example.catalogliceu.dto.RaspunsAutentificare;
import com.example.catalogliceu.repositories.UtilizatorRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AutentificareService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UtilizatorRepository utilizatorRepository;
    public AutentificareService(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UtilizatorRepository utilizatorRepository) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.utilizatorRepository = utilizatorRepository;
    }
    public RaspunsAutentificare login(CerereAutentificare cerereAutentificare) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        cerereAutentificare.getPorecla(),
                        cerereAutentificare.getParola()
                )
        );
        var user = utilizatorRepository.findByPorecla(cerereAutentificare.getPorecla()).orElseThrow();

        String jwtToken = jwtUtil.genereazaToken(user.getPorecla());
        return RaspunsAutentificare
                .builder()
                .token(jwtToken)
                .build();
    }
}
