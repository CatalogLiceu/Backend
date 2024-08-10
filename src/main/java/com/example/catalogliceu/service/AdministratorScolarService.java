package com.example.catalogliceu.service;

import com.example.catalogliceu.repositories.AdministratorScolarRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministratorScolarService {
    private final AdministratorScolarRepository administratorScolarRepository;
    public AdministratorScolarService(AdministratorScolarRepository administratorScolarRepository) {
        this.administratorScolarRepository = administratorScolarRepository;
    }
}
