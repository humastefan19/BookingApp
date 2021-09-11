package accomodationapp.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    private Accommodation accommodation;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    private String name;
    private int nrOfPersons;
    private int nrOfRooms;
    private int nrOfRoomsReserved;
    private String utilities;
    private String description;

    public Room(){

    }


}
