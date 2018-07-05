package ash.boot.mvcexample.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ash.boot.mvcexample.models.Person;;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);
}
