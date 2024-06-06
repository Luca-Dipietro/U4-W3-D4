package lucadipietro.entities;

import jakarta.persistence.*;
import lucadipietro.enums.EventType;

import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("athletics_competition")
public class AthleticsCompetition extends Event {

    @ManyToMany
    @JoinTable(name = "athletics_competition_athletes", joinColumns = @JoinColumn(name = "competition_id"), inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private Set<People> athletes;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private People winner;

    public AthleticsCompetition() {
    }

    public AthleticsCompetition(String title, LocalDate eventDate, String description, EventType eventType, Integer maxParticipants, Location location, Set<People> athletes, People winner) {
        super(title, eventDate, description, eventType, maxParticipants, location);
        this.athletes = athletes;
        this.winner = winner;
    }

    public Set<People> getAthletes() {
        return athletes;
    }

    public void setAthletes(Set<People> athletes) {
        this.athletes = athletes;
    }

    public People getWinner() {
        return winner;
    }

    public void setWinner(People winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticsCompetition{" +
                "athletes=" + athletes +
                ", winner=" + winner +
                '}';
    }
}
