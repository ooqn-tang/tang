package net.ttcxy.tang.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PageController {

    @GetMapping({"/",""})
    public String toIndex(){
        return "forward:/index.html";
    }

    @GetMapping("post/{id}")
    public String toBlog(@PathVariable("id") String id){
        return "blog";
    }

    @GetMapping("author/{username}")
    public String toAuthor(@PathVariable("username") String username){
        return "author";
    }
}
