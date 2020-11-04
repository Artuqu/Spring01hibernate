package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("")
//    @ResponseBody nie jest tu potrzebny
    public String helloW() {
        return "hello";
    }
}
