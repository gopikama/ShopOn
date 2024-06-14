package org.example.Test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Annotation from Spring MVC
public class TestController {

    @RequestMapping("/hello")  //this annotation works only for a get request, otherwise specify in annotation
    public String hello(){
        return "Hi";
    }

}
