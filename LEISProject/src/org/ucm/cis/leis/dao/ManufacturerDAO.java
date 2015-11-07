package org.ucm.cis.leis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ucm.cis.leis.models.Manufacturer;
import org.ucm.cis.leis.util.HibernateUtil;

public class ManufacturerDAO {

	/**
	 * Add Manufacturer
	 * @param manufacturer1
	 */
	public Manufacturer addManufacturer(Manufacturer manufacturer1) {

		try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(manufacturer1);

		if (manufacturer1 != null) {
			System.out.println("Manufacturer Added :  "
					+ manufacturer1.getManufacturerName());
		} else {
			System.out.println("Manufacturer object is null");
		}

		session.getTransaction().commit();
		session.close();
		
		} catch(Exception e) {
			System.err.print("Exception occured while adding the manufacturer to the database : "+ e.getMessage());
		}
		return manufacturer1;
	}

}
