package lucadipietro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lucadipietro.entities.Participation;
import lucadipietro.exceptions.NotFoundException;

import java.util.UUID;

public class ParticipationDAO {
    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Participation participation) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(participation);
        transaction.commit();
        System.out.println("La partecipazione all'evento " + participation.getEvent().getTitle() + " è stata salvata con successo nel database!");
    }

    public Participation getById(String id) {
        Participation participation = em.find(Participation.class, UUID.fromString(id));
        if (participation == null) throw new NotFoundException(UUID.fromString(id));
        return participation;
    }

    public void delete(String id) {
        Participation found = this.getById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La partecipazione all'evento " + found.getEvent().getTitle() + " è stata eliminata con successo dal database!");
    }
}
