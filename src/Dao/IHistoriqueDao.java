package Dao;

import java.util.List;


import model.Recu;

public interface IHistoriqueDao {
	List<Recu> listIdRecus();
	
	Recu getRecuById(int id);

}
