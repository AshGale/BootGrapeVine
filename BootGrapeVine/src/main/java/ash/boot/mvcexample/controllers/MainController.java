package ash.boot.mvcexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(path="/api") 
public class MainController {
	
	@GetMapping("/greet")
    public String greeting(@RequestParam(name="name", 
	    	required=false, 
	    	defaultValue="World") String name, 
	    	Model model) {

        model.addAttribute("name", name);
        return "/navigations/greet";
    }
    
    @GetMapping("/ajax")
    public String ajax(Model model) {
    	//additional logic!?
    	return "/navigations/ajaxCSRF";
    }
    
}