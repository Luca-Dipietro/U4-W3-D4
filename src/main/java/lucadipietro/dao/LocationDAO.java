package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lucadipietro.entities.Location;
import lucadipietro.exceptions.NotFoundException;

import java.util.UUID;

public class LocationDAO {

    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("La location " + location.getCity() + " è stata salvata con successo nel database!");
    }

    public Location getById(String id) {
        Location location = em.find(Location.class, UUID.fromString(id));
        if (location == null) throw new NotFoundException(UUID.fromString(id));
        return location;
    }

    public void delete(String id) {
        Location found = this.getById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La location " + found.getCity() + " è stata eliminata con successo dal database!");
    }
}