package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import model.Produit;
import model.Recu;

public class HistoriqueDao implements IHistoriqueDao{

	@Override
	public List<Recu> listIdRecus() {
		Transaction transaction = null;
        List <Recu> idProduits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            idProduits = session.createQuery("from Recu").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		return idProduits;
	}

	@Override
	public Recu getRecuById(int id) {
		Transaction transaction = null;
		Recu recu = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    recu= session.byId(Recu.class).getReference(id);
			     // or student = session.get(Student.class, id);
			    //or student = session.load(Student.class, id);
			   //or commit the transaction
			    transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
			
		}
        
        
        return recu;
	}

	

}
