package id.ac.ui.cs.advprog.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String homePage(){
        return "HomePage";
    }
}
