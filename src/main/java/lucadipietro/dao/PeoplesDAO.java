package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lucadipietro.entities.People;
import lucadipietro.exceptions.NotFoundException;

import java.util.UUID;

public class PeoplesDAO {
    private final EntityManager em;

    public PeoplesDAO(EntityManager em) {
        this.em = em;
    }

    public void save(People people) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(people);
        transaction.commit();
        System.out.println("La persona " + people.getName() + " è stata salvata con successo nel database!");
    }

    public People getById(String id) {
        People people = em.find(People.class, UUID.fromString(id));
        if (people == null) throw new NotFoundException(UUID.fromString(id));
        return people;
    }

    public void delete(String id) {
        People found = this.getById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La persona " + found.getName() + " è stata eliminata con successo dal database!");
    }
}
