package com.example.catalogliceu;

import com.example.catalogliceu.entities.*;
import com.example.catalogliceu.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CatalogLiceuApplicationTests {
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private SpecializareRepository specializareRepository;
	@Autowired
	private ClasaRepository clasaRepository;
	@Autowired
	private MaterieRepository materieRepository;
	@Autowired
	private LiceuRepository liceuRepository;
	@Autowired
	private DiriginteRepository diriginteRepository;
	@Autowired
	private ProfesorRepository profesorRepository;
	@Autowired
	private AnClasaRepository anClasaRepository;
	@Autowired
	private ClasaMaterieProfesorRepository clasaMaterieProfesorRepository;
	@Autowired
	private AdministratorScolarRepository administratorScolarRepository;
	@Autowired
	private PermisieAdministratorRepository permisieAdministratorRepository;
	@Test
	void contextLoads() {
		Profil profilReal = Profil.builder()
				.nume("Real")
				.build();
		profilRepository.save(profilReal);
		Specializare specializareMateInfo = Specializare.builder()
				.profil(profilReal)
				.nume("Matematematica-Informatica")
				.build();
		specializareRepository.save(specializareMateInfo);
		List<Specializare> specializariList = new ArrayList<>();
		specializariList.add(specializareMateInfo);
		Materie materieMatematica = Materie.builder()
				.nume("Matematica")
				.specializari(specializariList)
				.build();
		Materie materieRomana = Materie.builder()
				.nume("Romana")
				.specializari(specializariList)
				.build();
		materieRepository.save(materieMatematica);
		materieRepository.save(materieRomana);
		Liceu liceu = Liceu.builder()
				.nume("Colegiul National")
				.specializari(specializariList)
				.build();
		liceuRepository.save(liceu);
		AnClasa cls9 = AnClasa.builder()
				.nrClasa(9L)
				.build();
		anClasaRepository.save(cls9);
		Profesor profesor = Profesor.builder().build();
		profesor = profesorRepository.save(profesor);
		Clasa clasa9A = Clasa.builder()
				.anClasa(cls9)
				.litera("A")
				.liceu(liceu)
				.specializare(specializareMateInfo)
				.diriginte(profesor)
				.build();
		clasaRepository.save(clasa9A);
		Diriginte diriginte = Diriginte.builder()
				.clasa(clasa9A)
				.profesor(profesor)
				.build();
		diriginteRepository.save(diriginte);
		ClasaMaterieProfesor a = ClasaMaterieProfesor.builder()
				.clasa(clasa9A)
				.materie(materieRomana)
				.profesor(profesor)
				.build();
		ClasaMaterieProfesor b = ClasaMaterieProfesor.builder()
				.clasa(clasa9A)
				.materie(materieMatematica)
				.profesor(profesor)
				.build();
		clasaMaterieProfesorRepository.save(a);
		clasaMaterieProfesorRepository.save(b);

		AdministratorScolar administratorScolar = AdministratorScolar.builder().build();
		administratorScolarRepository.save(administratorScolar);
		PermisieAdministrator perm1 = PermisieAdministrator.builder()
				.utilizator(profesor)
				.build();
		PermisieAdministrator perm2 = PermisieAdministrator.builder()
				.utilizator(administratorScolar)
				.build();
		permisieAdministratorRepository.save(perm1);
		permisieAdministratorRepository.save(perm2);
	}
}
