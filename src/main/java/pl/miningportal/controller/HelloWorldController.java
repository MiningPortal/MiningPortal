package pl.miningportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {


    @RequestMapping({"/", "", "index.html", "index"})
    @ResponseBody
    public String helloWorld() {
        return "Hello miners";
    }

}
