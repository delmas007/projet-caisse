package Dao;

import java.util.List;
import model.Produit;

public interface ICaisseDao {
	 List<Produit> getAllProduits();
	 Produit getProduitById(int id);
}
