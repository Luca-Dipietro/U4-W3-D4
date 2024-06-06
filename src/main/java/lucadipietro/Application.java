package lucadipietro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucadipietro.dao.EventsDAO;
import lucadipietro.dao.LocationDAO;
import lucadipietro.dao.ParticipationDAO;
import lucadipietro.dao.PeoplesDAO;
import lucadipietro.entities.*;
import lucadipietro.enums.ConcertType;
import lucadipietro.enums.EventType;
import lucadipietro.enums.ParticipationState;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventsDAO ed = new EventsDAO(em);
        LocationDAO ld = new LocationDAO(em);
        ParticipationDAO pad = new ParticipationDAO(em);
        PeoplesDAO ped = new PeoplesDAO(em);

        Location location = new Location("Piazza Castello", "Fossano");
        ld.save(location);

        People luca = new People("Luca", "Dipietro", "luca.dipietro.ld@gmail.com", LocalDate.of(1997, 10, 16), "M");
        People mario = new People("Mario", "Rossi", "mariorossi@gmail.com", LocalDate.of(1990, 5, 24), "M");
//        ped.save(luca);
//        ped.save(mario);

        Set<People> athletes = new HashSet<>();
        athletes.add(luca);

        FootballMatch match = new FootballMatch("Derby", LocalDate.of(2023, 11, 7), "Football Derby", EventType.PUBBLICO, 2500, location, "Fossano", "Cuneo", "Fossano", 3, 1);
        Concert concert = new Concert("OndeSonore", LocalDate.of(2024, 6, 22), "OndeSonore Summer Festival", EventType.PUBBLICO, 5000, location, ConcertType.POP, false);
        AthleticsCompetition competition = new AthleticsCompetition("Giro D'Italia", LocalDate.of(2024, 5, 6), "Giro D'Italia final rush", EventType.PUBBLICO, 25000, location, athletes, luca);
//        ed.save(match);
//        ed.save(concert);
//        ed.save(competition);

        Participation firstParticipation = new Participation(luca, match, ParticipationState.CONFERMATA);
        Participation secondParticipation = new Participation(luca, competition, ParticipationState.CONFERMATA);
//        pad.save(firstParticipation);
//        pad.save(secondParticipation);

        em.close();
        emf.close();
    }
}
