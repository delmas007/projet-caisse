package model;
// Generated 22 mars 2022, 09:10:07 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Recu generated by hbm2java
 */
@Entity
@Table(name = "recu", catalog = "caisse")
public class Recu implements java.io.Serializable {

	private int numRecu;
	private Date date;
	private int somTotal;
	private String produit;
	private int montant;
	private int monnaie;

	public Recu() {
	}

	public Recu(int numRecu, Date date, int somTotal, String produit, int montant, int monnaie) {
		this.numRecu = numRecu;
		this.date = date;
		this.somTotal = somTotal;
		this.produit = produit;
		this.montant = montant;
		this.monnaie = monnaie;
	}

	@Id

	@Column(name = "NumRecu", unique = true, nullable = false)
	public int getNumRecu() {
		return this.numRecu;
	}

	public void setNumRecu(int numRecu) {
		this.numRecu = numRecu;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "SomTotal", nullable = false)
	public int getSomTotal() {
		return this.somTotal;
	}

	public void setSomTotal(int somTotal) {
		this.somTotal = somTotal;
	}

	@Column(name = "produit", nullable = false, length = 200)
	public String getProduit() {
		return this.produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	@Column(name = "montant", nullable = false)
	public int getMontant() {
		return this.montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	@Column(name = "monnaie", nullable = false)
	public int getMonnaie() {
		return this.monnaie;
	}

	public void setMonnaie(int monnaie) {
		this.monnaie = monnaie;
	}

}