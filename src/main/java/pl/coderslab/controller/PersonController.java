package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Person;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/form")
    public String personForm(){
        return "person/form";
    }

    @PostMapping("/form")
    public String personFormPost(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String email,
                                Model m ){
     Person p = new Person()
             .setLogin(login)
             .setEmail(email)
             .setPassword(password);

     m.addAttribute("person", p);
        return "person/show";
    }

    @GetMapping("/formbind")
    public String personFormBind(Model m){
        m.addAttribute("person", new Person());
        return "person/formbind";
    }

    @PostMapping("/formbind")
    public String personFormBindPost(@ModelAttribute Person person, Model m){
       m.addAttribute("person", person);
        return "person/show";
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies(){
        return Arrays.asList("narty", "rolki", "zagle");
    }
}
