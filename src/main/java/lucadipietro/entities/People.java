package lucadipietro.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;
    private String sex;

    @OneToMany(mappedBy = "people")
    private List<Participation> participations;

    @ManyToMany(mappedBy = "athletes")
    private Set<AthleticsCompetition> athleticsCompetitions;

    @OneToMany(mappedBy = "winner")
    private Set<AthleticsCompetition> totWin;

    public People() {
    }

    public People(String name, String surname, String email, LocalDate birthday, String sex) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public Set<AthleticsCompetition> getAthleticsCompetitions() {
        return athleticsCompetitions;
    }

    public void setAthleticsCompetitions(Set<AthleticsCompetition> athleticsCompetitions) {
        this.athleticsCompetitions = athleticsCompetitions;
    }

    public Set<AthleticsCompetition> getTotWin() {
        return totWin;
    }

    public void setTotWin(Set<AthleticsCompetition> totWin) {
        this.totWin = totWin;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                '}';
    }
}
