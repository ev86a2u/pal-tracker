package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    public final String input_msg;

    @Autowired
    public WelcomeController(@Value("${WELCOME_MESSAGE}")  String input_msg)
    {
        this.input_msg = input_msg;
    }

        @GetMapping("/")
    public String sayHello()
    {
        return  input_msg;
    }

}
