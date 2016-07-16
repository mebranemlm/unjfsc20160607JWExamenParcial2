package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
	
	public EntityManager em;
	public EntityManagerFactory emf;
	
	public void abrir()
	{
		emf=Persistence.createEntityManagerFactory("MERCEDES_BRANDAN");
		em=emf.createEntityManager();
	}
	public void cerrar()
	{
		em.close();
		emf.close();
	}	

}
