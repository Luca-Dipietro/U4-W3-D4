package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lucadipietro.entities.Event;
import lucadipietro.exceptions.NotFoundException;

import java.util.UUID;

public class EventsDAO {

    private final EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("L'evento " + event.getTitle() + " è stato salvato con successo nel database!");
    }

    public Event getById(String id) {
        Event event = em.find(Event.class, UUID.fromString(id));
        if (event == null) throw new NotFoundException(UUID.fromString(id));
        return event;
    }

    public void delete(String id) {
        Event found = this.getById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitle() + " è stato eliminato con successo dal database!");
    }
}
