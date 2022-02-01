package pjt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pjt.entities.Departement;
import pjt.entities.Employe;

@RestController
@CrossOrigin("*")
public class EmployeRestService {
	
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository departementRepository;
	
	//http://localhost:8080/listEmployes
	@GetMapping(value = "/listEmployes")
	public List<Employe> getAllEmp(){
		return employeRepository.findAll();
	}
	
	//http://localhost:8080/listEmployes/1
	@GetMapping(value = "/listEmployes/{id}")
	public Employe getEmploye(@PathVariable(name = "id") Long id) {
		return employeRepository.findById(id).get();
	}
	
	@PutMapping(value = "/listEmployes/{id}")
	public Employe updateEmp(@PathVariable(name = "id") Long id,@RequestBody Employe emp) {
		emp.setId(id);
		return employeRepository.save(emp);
	}
	@GetMapping(value = "/listEmployes/listDepartements")
    public List<Departement> getAllDep(){
        return departementRepository.findAll();
    }
	
	
	@PostMapping(value = "/listEmployes/")
	public Employe save(@RequestBody Employe emp) {
		return employeRepository.save(emp);
	}
	
	
	
	@PostMapping(value = "/listEmployes/listDepartements/{nbD}")
	public Departement creation(@PathVariable(name = "nbD" )String nom)
	{
		//List<Employe> employes=new ArrayList<Employe>();
		Departement dep;
		//Employe emp;
		//for (int i=0;i<nbD;i++) {
			dep = new Departement(null, nom);
			return departementRepository.save(dep);
			//for(int j=0;j<(nbE/nbD);j++) {
				//emp = new Employe(null, "nom"+j, "prenom"+j, "adressMail"+j,dep);
				//employeRepository.save(emp);
				//employes.add(emp);
		//}
		}
	//return 	employes;
	//}
	
	
	@DeleteMapping(value = "/listEmployes/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		employeRepository.deleteById(id);
	}
	
	//http://localhost:8080/listEmployes/chercher/nom2
	@GetMapping(value = "/listEmployes/chercher/{x}")
	public List<Employe> chercher(@PathVariable(name = "x")String x){
		List<Employe> list=employeRepository.nomParMotCle(x);
		//System.out.println("list taille"+list.size());
		return list;
	}
	
	//http://localhost:8080/listEmployes/chercherContains/no
	@GetMapping(value = "/listEmployes/chercherContains/{x}")
	public List<Employe> chercherContains(@PathVariable(name = "x")String x){
		List<Employe> list=employeRepository.nomParMotCleContains("%"+x+"%");
		//System.out.println("list taille"+list.size());
		return list;
		
	}
	
	
	@GetMapping(value = "/listEmployes/empParDepID/{x}")
	public List<Employe> employeParDepId(@PathVariable(name = "x")Long x){
		List<Employe> list=employeRepository.EmpParDepartID(x);
		//System.out.println("list taille"+list.size());
		return list;
	}
	
	

	@GetMapping(value = "/listEmployes/empParDepNom/{x}")
	public List<Employe> employeParDepNom(@PathVariable(name = "x")String x){
		List<Employe> list=employeRepository.EmpParDepart(x);
		//System.out.println("list taille"+list.size());
		return list;
	}
	
	
	
	
	/*
	@GetMapping(value = "/listEmployes/{nom}")
	public List<Employe> parMotCle(@PathVariable(name = "nom") String nom){
		return employeRepository.nomParMotCle(nom);
	}
	
	
	@GetMapping("/listEmployes/employesParMC/{x}")
	public List<Employe> getEmpsMC(@PathVariable(name = "x")String mc)
	{
		return employeRepository.EmployeParMotCle(mc);
	}
	*/
	
	/*
	@GetMapping(value = "/listEmployes/{nom}")
	@Query("select e from Employe e where e.nom like :x")
	public List<Employe> nomParMotCle(@PathVariable(name = nom) ("x")String nom);
	

	@RestResource(path = "byNom")
	public List<Employe> findByNomContains(@Param("nom") String Nom);
	//http://localhost:8080/employes/search/byNom?nom=nom1
	
	@RestResource(path="byNomPage")
	public Page<Employe> findByNomContains(@Param("nom") String nom, Pageable pageable);
	//http://localhost:8080/employes/search/byNomPage?nom=nom1&page=1&size=1
	*/
	
}
