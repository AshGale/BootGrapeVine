package ash.boot.mvcexample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ash.boot.mvcexample.models.Person;

@org.springframework.web.bind.annotation.RestController
public class RestController {

//	@GetMapping("/knockknock")//@RequestMapping("/knockknock")
//    public Person knockknock(@RequestParam(value="username", defaultValue="World") String name) {
//    	System.out.println("knockknock rest");
//    	if(name.isEmpty()) {
//    		return new Person("Who's","There");
//    	}
//    	else {
//    		//TODO add query for username and give back first and last name
//    		return new Person("Hello",name);
//    	}
//        
//    }
//	
}
