package lucadipietro.entities;


import jakarta.persistence.*;
import lucadipietro.enums.ParticipationState;

import java.util.UUID;

@Entity
@Table(name = "participations")
public class Participation {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private ParticipationState participationState;

    public Participation() {
    }

    public Participation(People people, Event event, ParticipationState participationState) {
        this.people = people;
        this.event = event;
        this.participationState = participationState;
    }

    public UUID getId() {
        return id;
    }


    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ParticipationState getParticipationState() {
        return participationState;
    }

    public void setParticipationState(ParticipationState participationState) {
        this.participationState = participationState;
    }
}
