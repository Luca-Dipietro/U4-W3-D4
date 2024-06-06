package lucadipietro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucadipietro.dao.EventsDAO;
import lucadipietro.dao.LocationDAO;
import lucadipietro.dao.ParticipationDAO;
import lucadipietro.dao.PeoplesDAO;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventsDAO ed = new EventsDAO(em);
        LocationDAO ld = new LocationDAO(em);
        ParticipationDAO pad = new ParticipationDAO(em);
        PeoplesDAO ped = new PeoplesDAO(em);


        em.close();
        emf.close();
    }
}
