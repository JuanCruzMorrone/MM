package app;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Reunion;
import classes.Usuario;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mmm");
		EntityManager manager = emf.createEntityManager();

        manager.getTransaction( ).begin( );

		Usuario u1 = new Usuario("Juan");
		Usuario u2 = new Usuario("Juancito");
		Usuario u3 = new Usuario("Mariano");
		Usuario u4 = new Usuario("Chuba");
		Usuario u5 = new Usuario("Alejo");
		Usuario u6 = new Usuario("Agustin");
		


		Date fechaR1 = new GregorianCalendar(2017, Calendar.NOVEMBER, 19, 12, 30).getTime();


        Reunion r1 = new Reunion(fechaR1, 2, u1);


        r1.addInvitado(u2);
        r1.addInvitado(u3);
        r1.addInvitado(u4);



		manager.persist(u1);
		manager.persist(u2);
		manager.persist(u3);
		manager.persist(u4);
		manager.persist(u5);
		manager.persist(u6);
		manager.persist(r1);

		manager.getTransaction( ).commit( );
		manager.close();
		emf.close();

	}
}
