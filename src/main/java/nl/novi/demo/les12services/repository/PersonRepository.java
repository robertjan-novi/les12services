package nl.novi.demo.les12services.repository;

import nl.novi.demo.les12services.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
