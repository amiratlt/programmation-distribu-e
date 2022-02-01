package pjt.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Employe implements Serializable{
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String nom;
private String prenom;
private String adressMail;
@ManyToOne
@JoinColumn(name = "idDepart")
private Departement departement;


public Departement getDepartement() {
	return departement;
}
public void setDepartement(Departement departement) {
	this.departement = departement;
}
public Employe() {
	super();
}



public Employe(Long id, String nom, String prenom, String adressMail, Departement departement) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.adressMail = adressMail;
	this.departement = departement;
}
public Employe(Long id, String nom, String prenom, String adressMail) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.adressMail = adressMail;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}


public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAdressMail() {
	return adressMail;
}
public void setAdressMail(String adressMail) {
	this.adressMail = adressMail;
}

public String toString() {
	
	return "Employe: \n id :"+this.id+" Nom : "+this.nom+" Prenom : "+this.prenom+" Adresse : "+this.adressMail;
}


}