package lucadipietro.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lucadipietro.enums.ConcertType;
import lucadipietro.enums.EventType;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("concert")
public class Concert extends Event {

    @Enumerated(EnumType.STRING)
    private ConcertType genre;
    private Boolean inStreaming;

    public Concert() {
    }

    public Concert(String title, LocalDate eventDate, String description, EventType eventType, Integer maxParticipants, Location location, ConcertType genre, Boolean inStreaming) {
        super(title, eventDate, description, eventType, maxParticipants, location);
        this.genre = genre;
        this.inStreaming = inStreaming;
    }

    public ConcertType getGenre() {
        return genre;
    }

    public void setGenre(ConcertType genre) {
        this.genre = genre;
    }

    public Boolean getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(Boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "genre=" + genre +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
