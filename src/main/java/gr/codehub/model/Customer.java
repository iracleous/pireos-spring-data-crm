package gr.codehub.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(unique = true)
    private String address;
    private int age;
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "customer")
    private List<Basket> baskets;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;
}
