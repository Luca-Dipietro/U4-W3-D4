package lucadipietro.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String city;

    @OneToMany(mappedBy = "location")
    private List<Event> events;

    public Location() {
    }

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
