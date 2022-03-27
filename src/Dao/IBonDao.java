package Dao;

import java.util.List;

import model.BonReduction;

public interface IBonDao {
	BonReduction getNimBonById(int id);
	 List<BonReduction> getAllId();
	 BonReduction getBONById(int id);
}
