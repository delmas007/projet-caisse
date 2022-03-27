package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.BonReduction;
import util.HibernateUtil;

public class BonDao implements IBonDao {

	@Override
	public BonReduction getNimBonById(int id) {
		Transaction transaction = null;
        BonReduction nomBon = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    nomBon= session.byId(BonReduction.class).getReference(id);
			     // or student = session.get(Student.class, id);
			    //or student = session.load(Student.class, id);
			   //or commit the transaction
			    transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
			
		}
        
        
        return nomBon;
	}

	@Override
	public List<BonReduction> getAllId() {
		Transaction transaction = null;
        List <BonReduction> bon = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            bon = session.createQuery("from BonReduction").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return bon;
	}

	@Override
	public BonReduction getBONById(int id) {
		Transaction transaction = null;
		BonReduction dateBonReduction = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    dateBonReduction= session.byId(BonReduction.class).getReference(id);
			     // or student = session.get(Student.class, id);
			    //or student = session.load(Student.class, id);
			   //or commit the transaction
			    transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
			
		}
        
        
        return dateBonReduction;
	}

}
