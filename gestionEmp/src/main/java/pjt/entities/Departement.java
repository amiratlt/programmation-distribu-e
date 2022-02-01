package pjt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departement implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepart;
	private String NomDepart;
	//@OneToMany(mappedBy = "departement")
	//private List<Employe>  employes=new ArrayList<Employe>();
	
	
	
	
	

/*
	public Departement(Long idDepart, String nomDepart, List<Employe> employes) {
		super();
		this.idDepart = idDepart;
		NomDepart = nomDepart;
		this.employes = employes;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
*/
	public Departement(Long idDepart, String nomDepart) {
		super();
		this.idDepart = idDepart;
		NomDepart = nomDepart;
	}

	public Departement() {
		super();
	}

	public Long getIdDepart() {
		return idDepart;
	}

	public void setIdDepart(Long idDepart) {
		this.idDepart = idDepart;
	}

	public String getNomDepart() {
		return NomDepart;
	}

	public void setNomDepart(String nomDepart) {
		NomDepart = nomDepart;
	}
	
	
	
	

}
