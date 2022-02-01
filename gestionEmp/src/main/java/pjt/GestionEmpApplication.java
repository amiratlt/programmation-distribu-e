package pjt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javassist.expr.NewArray;
import pjt.dao.DepartementRepository;
import pjt.dao.EmployeRepository;
import pjt.entities.Departement;
import pjt.entities.Employe;

@SpringBootApplication
public class GestionEmpApplication implements CommandLineRunner{

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository departemetRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionEmpApplication.class, args);
	}
	
	
	@Override
	public void run(String... args)throws Exception {
		/*
		//departemetRepository.save(new Departement(null, "nomDepart11"));
		Departement dep = new Departement(null, "nomDepart1");
		departemetRepository.save(dep);
		employeRepository.save(new Employe(null, "nom1", "prenom1", "nom1.prenom1@adressMail",dep));
		employeRepository.save(new Employe(null, "nom2", "prenom2", "nom2.prenom2@adressMail",dep));
		employeRepository.save(new Employe(null, "nom3", "prenom3", "nom3.prenom3@adressMail",dep));
		//departemetRepository.save(new Departement(null, "nomDepart1"));
	
		
		employeRepository.findAll().forEach(emp -> {
			System.out.println(emp.toString());
		});
		*/
		
		
		
	
	
	}
	

}
