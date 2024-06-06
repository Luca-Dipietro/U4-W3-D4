package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lucadipietro.entities.Concert;
import lucadipietro.entities.Event;
import lucadipietro.entities.FootballMatch;
import lucadipietro.enums.ConcertType;
import lucadipietro.exceptions.NotFoundException;

import java.util.List;
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

    public List<Concert> getConcertInStreaming(boolean inStreaming) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.inStreaming = :inStreaming", Concert.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concert> getConcertGenre(ConcertType genre) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.genre = :genre", Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    public List<FootballMatch> getPartiteVinteInCasa() {
        TypedQuery<FootballMatch> query = em.createNamedQuery("getPartiteVinteInCasa", FootballMatch.class);
        return query.getResultList();
    }

    public List<FootballMatch> getPartiteVinteInTrasferta() {
        TypedQuery<FootballMatch> query = em.createNamedQuery("getPartiteVinteInTrasferta", FootballMatch.class);
        return query.getResultList();
    }
}
