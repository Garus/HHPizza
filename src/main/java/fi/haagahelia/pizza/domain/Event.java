package fi.haagahelia.pizza.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "eventit")
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date eventDate;
    private String name;


    public Event() {
        super();
    }

    public Event(int id, String name, Date eventDate) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    public String toString() {
        return id + " " + name + " " + eventDate;
    }
}
