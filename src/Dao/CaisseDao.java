package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import model.Produit;

public class CaisseDao implements ICaisseDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Produit> getAllProduits() {
	        Transaction transaction = null;
	        List <Produit> produit = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // get students
	            produit = session.createQuery("from Produit").list();
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	        return produit;
	    }

	@Override
	public Produit getProduitById(int id) {
		Transaction transaction = null;
		Produit produit = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    produit= session.byId(Produit.class).getReference(id);
			     // or student = session.get(Student.class, id);
			    //or student = session.load(Student.class, id);
			   //or commit the transaction
			    transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
			
		}
        
        
        return produit;
	}

	}

