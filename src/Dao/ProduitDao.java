package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import util.HibernateUtil;

import model.Produit;
import model.Recu;

public class ProduitDao implements IProduitDao{

	@Override
	public void saveProduit(Produit produit) {
		  Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(produit);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public void supprimerProduit(Integer idProduit) {
		Transaction transaction = null;
		Produit student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            student = session.get(Produit.class, idProduit);
            // get student object
            session.delete(student);
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

	@Override
	public List<Produit> listProduit() {
		Transaction transaction = null;
        List <Produit> idProduits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            idProduits = session.createQuery("from Produit").list();
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

		
	}


