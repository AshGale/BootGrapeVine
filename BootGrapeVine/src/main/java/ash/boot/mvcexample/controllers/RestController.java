package ash.boot.mvcexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ash.boot.mvcexample.models.Person;
import ash.boot.mvcexample.services.PersonRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private PersonRepository personRepository;
	
    @RequestMapping("/knockknock")
    public @ResponseBody Person knockknock(
    		@RequestParam(value="first") String first,
    		@RequestParam(value="last") String last) {
    	
    	if(first.isEmpty()) {
    		System.out.println("please add ?first=first&last=last to your request");
    		return new Person("Who's","There");    		
    	}
    	else {
    		System.out.println("knockknock: " +first +" "+ last);
    		//TODO add query for username and give back first and last name
    		return new Person(first,last);
    	}
        
    }
		
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (
			@RequestParam String firstName, 
			@RequestParam String lastName) {

		Person n = new Person();
		n.setFirstName(firstName);
		n.setLastName(lastName);
		personRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Person> getAllUsers() {
		// This returns a JSON or XML with the users
		return personRepository.findAll();
	}
}
