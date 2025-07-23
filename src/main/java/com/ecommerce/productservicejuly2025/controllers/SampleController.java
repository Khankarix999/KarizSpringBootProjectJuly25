package com.ecommerce.productservicejuly2025.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SampleController {

    @GetMapping("/hello/{name}/{time}")
    public String sayHello(@PathVariable("name") String name,
                            @PathVariable("time") int count){

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < count; i++){
            output.append("Hello " + name + " ");
        }
        return output.toString();
    }

    @GetMapping("bye")
    public String sayBye(){
        return "bye";
    }
}
