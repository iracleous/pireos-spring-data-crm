package gr.codehub.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime date;
    private String Code;

    @ManyToOne
    private Customer customer;
}
