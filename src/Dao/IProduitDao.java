package Dao;

import java.util.List;

import model.Produit;
import model.Recu;

public interface IProduitDao {
	
void saveProduit(Produit produit);

void supprimerProduit(Integer id_Produit);

List<Produit> listProduit();




}
