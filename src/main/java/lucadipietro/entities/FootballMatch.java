package lucadipietro.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import lucadipietro.enums.EventType;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("football_match")

@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT fm FROM FootballMatch fm WHERE fm.homeTeam = fm.winnerTeam")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT fm FROM FootballMatch fm WHERE fm.awayTeam = fm.winnerTeam")

public class FootballMatch extends Event {

    private String homeTeam;
    private String awayTeam;
    private String winnerTeam;
    private Integer numGolHomeTeam;
    private Integer numGolAwayTeam;

    public FootballMatch() {
    }

    public FootballMatch(String title, LocalDate eventDate, String description, EventType eventType, Integer maxParticipants, Location location, String homeTeam, String awayTeam, String winnerTeam, Integer numGolHomeTeam, Integer numGolAwayTeam) {
        super(title, eventDate, description, eventType, maxParticipants, location);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.winnerTeam = winnerTeam;
        this.numGolHomeTeam = numGolHomeTeam;
        this.numGolAwayTeam = numGolAwayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public Integer getNumGolHomeTeam() {
        return numGolHomeTeam;
    }

    public void setNumGolHomeTeam(Integer numGolHomeTeam) {
        this.numGolHomeTeam = numGolHomeTeam;
    }

    public Integer getNumGolAwayTeam() {
        return numGolAwayTeam;
    }

    public void setNumGolAwayTeam(Integer numGolAwayTeam) {
        this.numGolAwayTeam = numGolAwayTeam;
    }
}
