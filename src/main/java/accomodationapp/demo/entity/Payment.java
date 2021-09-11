package accomodationapp.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cardNumber")
    private String cardNumber;

    private double sum;

    private LocalDate dateOfPayment;

    @OneToOne
    private Reservation reservation;

    public Payment(){

    }

    public Payment(String cardNumber, double sum){
        this.cardNumber = cardNumber;
        this.sum = sum;
        this.dateOfPayment = LocalDate.now();
    }
}
