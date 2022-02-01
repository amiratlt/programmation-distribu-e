package pjt.dao;

import java.awt.print.Pageable;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pjt.entities.Employe;

//@Repository
@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe, Long>{
	
	
	@RestResource(path = "byNom")
	@Query("select e from Employe e where e.nom like :x")
	public List<Employe> nomParMotCle(@PathParam("x")String x);
	
	@RestResource(path = "byNomContains")
	@Query("select e from Employe e where e.nom like :x")
	public List<Employe> nomParMotCleContains(@PathParam("x")String x);
	
	
	@RestResource(path = "byIdDepart")
	@Query("select e from Employe e where e.departement.idDepart like :x")
	public List<Employe> EmpParDepartID(@PathParam("x")Long x );
	

	@RestResource(path = "byNomDepart")
	@Query("select e from Employe e where e.departement.NomDepart like :x")
	public List<Employe> EmpParDepart(@PathParam("x")String x );
	
	
	
	/*
	 * @Query("select e from Employe e join Departement p where (e.departement.idDepart=p.idDepart) and (p.NomDepart like :x)")
	@Query("select e from Employee where e.nom like :x")
	public List<Employe> nomParMotCle(@Param("x")String nom);
	*/
	
}
