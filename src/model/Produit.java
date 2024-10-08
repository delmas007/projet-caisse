package model;
// Generated 22 mars 2022, 09:10:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Produit generated by hbm2java
 */
@Entity
@Table(name = "produit", catalog = "caisse")
public class Produit implements java.io.Serializable {

	private int idProduit;
	private String nomProduit;
	private int prixProduit;

	public Produit() {
	}

	public Produit(int idProduit, String nomProduit, int prixProduit) {
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
	}

	@Id

	@Column(name = "IdProduit", unique = true, nullable = false)
	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	@Column(name = "NomProduit", nullable = false, length = 30)
	public String getNomProduit() {
		return this.nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	@Column(name = "PrixProduit", nullable = false)
	public int getPrixProduit() {
		return this.prixProduit;
	}

	public void setPrixProduit(int prixProduit) {
		this.prixProduit = prixProduit;
	}

}
