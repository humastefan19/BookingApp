package accomodationapp.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    private Accommodation accommodation;

    private int nrOfStars;
    private String title;
    private String body;

    public Review(){

    }
}
