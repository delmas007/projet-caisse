package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Produit;
import model.Recu;
import util.HibernateUtil;

public class RecuDao implements IRecuDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveProduit(Recu recu) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(recu);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}

	@Override
	public int idRecu() {
		 Transaction transaction = null;
		 Query student = null;
		 int stud1 = 0 ;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    // start the transaction
				    transaction = session.beginTransaction();

				    // get student object
				    student= session.createQuery("SELECT MAX(numRecu) FROM Recu");
				    stud1= student.executeUpdate();
				     // or student = session.get(Student.class, id);
				    //or student = session.load(Student.class, id);
				   //or commit the transaction
				    transaction.commit();
				    System.out.println(stud1);
			} catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
	               
			}
				 
			}
			return stud1;
	        
	        
	       
	}
	/*
	public int idRecu() {
		 Transaction transaction = null;
		 Query student = null;
		 int stud1 = 0;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    // start the transaction
				    transaction = session.beginTransaction();

				    // get student object
				    student= session.createQuery("SELECT MAX(numRecu) FROM Recu");
				    stud1= student.executeUpdate();
				     // or student = session.get(Student.class, id);
				    //or student = session.load(Student.class, id);
				   //or commit the transaction
				    transaction.commit();
				    System.out.println(stud1);
			} catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
	               
			}
				 
			}
			return stud1;
	        
	        
	       
	}
	*/

}
