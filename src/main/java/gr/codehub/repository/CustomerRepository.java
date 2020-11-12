package gr.codehub.repository;

import gr.codehub.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer>  findFirstByName(String name);

    @Query("select c.age from Customer c  ")
    List<Integer> findAges();

}
