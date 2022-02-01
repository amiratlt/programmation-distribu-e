package pjt.dao;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import pjt.entities.Departement;
import pjt.entities.Employe;
@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long>{
	
		
}
